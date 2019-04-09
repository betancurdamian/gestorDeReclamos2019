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
import model.JpaController.exceptions.NonexistentEntityException;
import model.TipoDeReclamo;

/**
 *
 * @author JUANA
 */
public class TipoDeReclamoJpaController implements Serializable {

    public TipoDeReclamoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoDeReclamo tipoDeReclamo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoDeReclamo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoDeReclamo tipoDeReclamo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoDeReclamo = em.merge(tipoDeReclamo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = tipoDeReclamo.getId();
                if (findTipoDeReclamo(id) == null) {
                    throw new NonexistentEntityException("The tipoDeReclamo with id " + id + " no longer exists.");
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
            TipoDeReclamo tipoDeReclamo;
            try {
                tipoDeReclamo = em.getReference(TipoDeReclamo.class, id);
                tipoDeReclamo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoDeReclamo with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoDeReclamo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoDeReclamo> findTipoDeReclamoEntities() {
        return findTipoDeReclamoEntities(true, -1, -1);
    }

    public List<TipoDeReclamo> findTipoDeReclamoEntities(int maxResults, int firstResult) {
        return findTipoDeReclamoEntities(false, maxResults, firstResult);
    }

    private List<TipoDeReclamo> findTipoDeReclamoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoDeReclamo.class));
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

    public TipoDeReclamo findTipoDeReclamo(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoDeReclamo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoDeReclamoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoDeReclamo> rt = cq.from(TipoDeReclamo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
