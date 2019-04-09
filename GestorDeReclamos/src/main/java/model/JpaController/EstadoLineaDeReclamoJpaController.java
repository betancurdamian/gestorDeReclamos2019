/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.JpaController;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.EstadoLineaDeReclamo;
import model.JpaController.exceptions.NonexistentEntityException;

/**
 *
 * @author JUANA
 */
public class EstadoLineaDeReclamoJpaController implements Serializable {

    public EstadoLineaDeReclamoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EstadoLineaDeReclamo estadoLineaDeReclamo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(estadoLineaDeReclamo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EstadoLineaDeReclamo estadoLineaDeReclamo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            estadoLineaDeReclamo = em.merge(estadoLineaDeReclamo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = estadoLineaDeReclamo.getId();
                if (findEstadoLineaDeReclamo(id) == null) {
                    throw new NonexistentEntityException("The estadoLineaDeReclamo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EstadoLineaDeReclamo estadoLineaDeReclamo;
            try {
                estadoLineaDeReclamo = em.getReference(EstadoLineaDeReclamo.class, id);
                estadoLineaDeReclamo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estadoLineaDeReclamo with id " + id + " no longer exists.", enfe);
            }
            em.remove(estadoLineaDeReclamo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EstadoLineaDeReclamo> findEstadoLineaDeReclamoEntities() {
        return findEstadoLineaDeReclamoEntities(true, -1, -1);
    }

    public List<EstadoLineaDeReclamo> findEstadoLineaDeReclamoEntities(int maxResults, int firstResult) {
        return findEstadoLineaDeReclamoEntities(false, maxResults, firstResult);
    }

    private List<EstadoLineaDeReclamo> findEstadoLineaDeReclamoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EstadoLineaDeReclamo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public EstadoLineaDeReclamo findEstadoLineaDeReclamo(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EstadoLineaDeReclamo.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstadoLineaDeReclamoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EstadoLineaDeReclamo> rt = cq.from(EstadoLineaDeReclamo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
