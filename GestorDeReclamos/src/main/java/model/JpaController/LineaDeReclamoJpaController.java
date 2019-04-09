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
import model.LineaDeReclamo;
import model.Reclamo;

/**
 *
 * @author JUANA
 */
public class LineaDeReclamoJpaController implements Serializable {

    public LineaDeReclamoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(LineaDeReclamo lineaDeReclamo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reclamo reclamo = lineaDeReclamo.getReclamo();
            if (reclamo != null) {
                reclamo = em.getReference(reclamo.getClass(), reclamo.getId());
                lineaDeReclamo.setReclamo(reclamo);
            }
            em.persist(lineaDeReclamo);
            if (reclamo != null) {
                reclamo.getLineasDeReclamo().add(lineaDeReclamo);
                reclamo = em.merge(reclamo);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(LineaDeReclamo lineaDeReclamo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LineaDeReclamo persistentLineaDeReclamo = em.find(LineaDeReclamo.class, lineaDeReclamo.getId());
            Reclamo reclamoOld = persistentLineaDeReclamo.getReclamo();
            Reclamo reclamoNew = lineaDeReclamo.getReclamo();
            if (reclamoNew != null) {
                reclamoNew = em.getReference(reclamoNew.getClass(), reclamoNew.getId());
                lineaDeReclamo.setReclamo(reclamoNew);
            }
            lineaDeReclamo = em.merge(lineaDeReclamo);
            if (reclamoOld != null && !reclamoOld.equals(reclamoNew)) {
                reclamoOld.getLineasDeReclamo().remove(lineaDeReclamo);
                reclamoOld = em.merge(reclamoOld);
            }
            if (reclamoNew != null && !reclamoNew.equals(reclamoOld)) {
                reclamoNew.getLineasDeReclamo().add(lineaDeReclamo);
                reclamoNew = em.merge(reclamoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = lineaDeReclamo.getId();
                if (findLineaDeReclamo(id) == null) {
                    throw new NonexistentEntityException("The lineaDeReclamo with id " + id + " no longer exists.");
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
            LineaDeReclamo lineaDeReclamo;
            try {
                lineaDeReclamo = em.getReference(LineaDeReclamo.class, id);
                lineaDeReclamo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The lineaDeReclamo with id " + id + " no longer exists.", enfe);
            }
            Reclamo reclamo = lineaDeReclamo.getReclamo();
            if (reclamo != null) {
                reclamo.getLineasDeReclamo().remove(lineaDeReclamo);
                reclamo = em.merge(reclamo);
            }
            em.remove(lineaDeReclamo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<LineaDeReclamo> findLineaDeReclamoEntities() {
        return findLineaDeReclamoEntities(true, -1, -1);
    }

    public List<LineaDeReclamo> findLineaDeReclamoEntities(int maxResults, int firstResult) {
        return findLineaDeReclamoEntities(false, maxResults, firstResult);
    }

    private List<LineaDeReclamo> findLineaDeReclamoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(LineaDeReclamo.class));
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

    public LineaDeReclamo findLineaDeReclamo(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(LineaDeReclamo.class, id);
        } finally {
            em.close();
        }
    }

    public int getLineaDeReclamoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<LineaDeReclamo> rt = cq.from(LineaDeReclamo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
