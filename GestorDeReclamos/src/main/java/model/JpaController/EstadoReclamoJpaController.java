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
import model.EstadoReclamo;
import model.JpaController.exceptions.NonexistentEntityException;

/**
 *
 * @author JUANA
 */
public class EstadoReclamoJpaController implements Serializable {

    public EstadoReclamoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EstadoReclamo estadoReclamo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(estadoReclamo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EstadoReclamo estadoReclamo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            estadoReclamo = em.merge(estadoReclamo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = estadoReclamo.getId();
                if (findEstadoReclamo(id) == null) {
                    throw new NonexistentEntityException("The estadoReclamo with id " + id + " no longer exists.");
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
            EstadoReclamo estadoReclamo;
            try {
                estadoReclamo = em.getReference(EstadoReclamo.class, id);
                estadoReclamo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The estadoReclamo with id " + id + " no longer exists.", enfe);
            }
            em.remove(estadoReclamo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EstadoReclamo> findEstadoReclamoEntities() {
        return findEstadoReclamoEntities(true, -1, -1);
    }

    public List<EstadoReclamo> findEstadoReclamoEntities(int maxResults, int firstResult) {
        return findEstadoReclamoEntities(false, maxResults, firstResult);
    }

    private List<EstadoReclamo> findEstadoReclamoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EstadoReclamo.class));
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

    public EstadoReclamo findEstadoReclamo(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EstadoReclamo.class, id);
        } finally {
            em.close();
        }
    }

    public int getEstadoReclamoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EstadoReclamo> rt = cq.from(EstadoReclamo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
