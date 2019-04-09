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
import model.TipoDeUrgencia;

/**
 *
 * @author JUANA
 */
public class TipoDeUrgenciaJpaController implements Serializable {

    public TipoDeUrgenciaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoDeUrgencia tipoDeUrgencia) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoDeUrgencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoDeUrgencia tipoDeUrgencia) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoDeUrgencia = em.merge(tipoDeUrgencia);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = tipoDeUrgencia.getId();
                if (findTipoDeUrgencia(id) == null) {
                    throw new NonexistentEntityException("The tipoDeUrgencia with id " + id + " no longer exists.");
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
            TipoDeUrgencia tipoDeUrgencia;
            try {
                tipoDeUrgencia = em.getReference(TipoDeUrgencia.class, id);
                tipoDeUrgencia.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoDeUrgencia with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoDeUrgencia);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoDeUrgencia> findTipoDeUrgenciaEntities() {
        return findTipoDeUrgenciaEntities(true, -1, -1);
    }

    public List<TipoDeUrgencia> findTipoDeUrgenciaEntities(int maxResults, int firstResult) {
        return findTipoDeUrgenciaEntities(false, maxResults, firstResult);
    }

    private List<TipoDeUrgencia> findTipoDeUrgenciaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoDeUrgencia.class));
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

    public TipoDeUrgencia findTipoDeUrgencia(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoDeUrgencia.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoDeUrgenciaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoDeUrgencia> rt = cq.from(TipoDeUrgencia.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
