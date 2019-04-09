/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.JpaController;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Servicio;
import model.LineaDeReclamo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.JpaController.exceptions.IllegalOrphanException;
import model.JpaController.exceptions.NonexistentEntityException;
import model.Reclamo;

/**
 *
 * @author JUANA
 */
public class ReclamoJpaController implements Serializable {

    public ReclamoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Reclamo reclamo) {
        if (reclamo.getLineasDeReclamo() == null) {
            reclamo.setLineasDeReclamo(new ArrayList<LineaDeReclamo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Servicio servicio = reclamo.getServicio();
            if (servicio != null) {
                servicio = em.getReference(servicio.getClass(), servicio.getId());
                reclamo.setServicio(servicio);
            }
            List<LineaDeReclamo> attachedLineasDeReclamo = new ArrayList<LineaDeReclamo>();
            for (LineaDeReclamo lineasDeReclamoLineaDeReclamoToAttach : reclamo.getLineasDeReclamo()) {
                lineasDeReclamoLineaDeReclamoToAttach = em.getReference(lineasDeReclamoLineaDeReclamoToAttach.getClass(), lineasDeReclamoLineaDeReclamoToAttach.getId());
                attachedLineasDeReclamo.add(lineasDeReclamoLineaDeReclamoToAttach);
            }
            reclamo.setLineasDeReclamo(attachedLineasDeReclamo);
            em.persist(reclamo);
            if (servicio != null) {
                servicio.getListaDeReclamos().add(reclamo);
                servicio = em.merge(servicio);
            }
            for (LineaDeReclamo lineasDeReclamoLineaDeReclamo : reclamo.getLineasDeReclamo()) {
                Reclamo oldReclamoOfLineasDeReclamoLineaDeReclamo = lineasDeReclamoLineaDeReclamo.getReclamo();
                lineasDeReclamoLineaDeReclamo.setReclamo(reclamo);
                lineasDeReclamoLineaDeReclamo = em.merge(lineasDeReclamoLineaDeReclamo);
                if (oldReclamoOfLineasDeReclamoLineaDeReclamo != null) {
                    oldReclamoOfLineasDeReclamoLineaDeReclamo.getLineasDeReclamo().remove(lineasDeReclamoLineaDeReclamo);
                    oldReclamoOfLineasDeReclamoLineaDeReclamo = em.merge(oldReclamoOfLineasDeReclamoLineaDeReclamo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reclamo reclamo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reclamo persistentReclamo = em.find(Reclamo.class, reclamo.getId());
            Servicio servicioOld = persistentReclamo.getServicio();
            Servicio servicioNew = reclamo.getServicio();
            List<LineaDeReclamo> lineasDeReclamoOld = persistentReclamo.getLineasDeReclamo();
            List<LineaDeReclamo> lineasDeReclamoNew = reclamo.getLineasDeReclamo();
            List<String> illegalOrphanMessages = null;
            for (LineaDeReclamo lineasDeReclamoOldLineaDeReclamo : lineasDeReclamoOld) {
                if (!lineasDeReclamoNew.contains(lineasDeReclamoOldLineaDeReclamo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain LineaDeReclamo " + lineasDeReclamoOldLineaDeReclamo + " since its reclamo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (servicioNew != null) {
                servicioNew = em.getReference(servicioNew.getClass(), servicioNew.getId());
                reclamo.setServicio(servicioNew);
            }
            List<LineaDeReclamo> attachedLineasDeReclamoNew = new ArrayList<LineaDeReclamo>();
            for (LineaDeReclamo lineasDeReclamoNewLineaDeReclamoToAttach : lineasDeReclamoNew) {
                lineasDeReclamoNewLineaDeReclamoToAttach = em.getReference(lineasDeReclamoNewLineaDeReclamoToAttach.getClass(), lineasDeReclamoNewLineaDeReclamoToAttach.getId());
                attachedLineasDeReclamoNew.add(lineasDeReclamoNewLineaDeReclamoToAttach);
            }
            lineasDeReclamoNew = attachedLineasDeReclamoNew;
            reclamo.setLineasDeReclamo(lineasDeReclamoNew);
            reclamo = em.merge(reclamo);
            if (servicioOld != null && !servicioOld.equals(servicioNew)) {
                servicioOld.getListaDeReclamos().remove(reclamo);
                servicioOld = em.merge(servicioOld);
            }
            if (servicioNew != null && !servicioNew.equals(servicioOld)) {
                servicioNew.getListaDeReclamos().add(reclamo);
                servicioNew = em.merge(servicioNew);
            }
            for (LineaDeReclamo lineasDeReclamoNewLineaDeReclamo : lineasDeReclamoNew) {
                if (!lineasDeReclamoOld.contains(lineasDeReclamoNewLineaDeReclamo)) {
                    Reclamo oldReclamoOfLineasDeReclamoNewLineaDeReclamo = lineasDeReclamoNewLineaDeReclamo.getReclamo();
                    lineasDeReclamoNewLineaDeReclamo.setReclamo(reclamo);
                    lineasDeReclamoNewLineaDeReclamo = em.merge(lineasDeReclamoNewLineaDeReclamo);
                    if (oldReclamoOfLineasDeReclamoNewLineaDeReclamo != null && !oldReclamoOfLineasDeReclamoNewLineaDeReclamo.equals(reclamo)) {
                        oldReclamoOfLineasDeReclamoNewLineaDeReclamo.getLineasDeReclamo().remove(lineasDeReclamoNewLineaDeReclamo);
                        oldReclamoOfLineasDeReclamoNewLineaDeReclamo = em.merge(oldReclamoOfLineasDeReclamoNewLineaDeReclamo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = reclamo.getId();
                if (findReclamo(id) == null) {
                    throw new NonexistentEntityException("The reclamo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Reclamo reclamo;
            try {
                reclamo = em.getReference(Reclamo.class, id);
                reclamo.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reclamo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<LineaDeReclamo> lineasDeReclamoOrphanCheck = reclamo.getLineasDeReclamo();
            for (LineaDeReclamo lineasDeReclamoOrphanCheckLineaDeReclamo : lineasDeReclamoOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Reclamo (" + reclamo + ") cannot be destroyed since the LineaDeReclamo " + lineasDeReclamoOrphanCheckLineaDeReclamo + " in its lineasDeReclamo field has a non-nullable reclamo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Servicio servicio = reclamo.getServicio();
            if (servicio != null) {
                servicio.getListaDeReclamos().remove(reclamo);
                servicio = em.merge(servicio);
            }
            em.remove(reclamo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reclamo> findReclamoEntities() {
        return findReclamoEntities(true, -1, -1);
    }

    public List<Reclamo> findReclamoEntities(int maxResults, int firstResult) {
        return findReclamoEntities(false, maxResults, firstResult);
    }

    private List<Reclamo> findReclamoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reclamo.class));
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

    public Reclamo findReclamo(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reclamo.class, id);
        } finally {
            em.close();
        }
    }

    public int getReclamoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reclamo> rt = cq.from(Reclamo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
