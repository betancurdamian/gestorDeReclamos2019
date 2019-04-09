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
import model.Empresa;
import model.Reclamo;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.JpaController.exceptions.NonexistentEntityException;
import model.Servicio;

/**
 *
 * @author JUANA
 */
public class ServicioJpaController implements Serializable {

    public ServicioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Servicio servicio) {
        if (servicio.getListaDeReclamos() == null) {
            servicio.setListaDeReclamos(new ArrayList<Reclamo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa empresa = servicio.getEmpresa();
            if (empresa != null) {
                empresa = em.getReference(empresa.getClass(), empresa.getId());
                servicio.setEmpresa(empresa);
            }
            List<Reclamo> attachedListaDeReclamos = new ArrayList<Reclamo>();
            for (Reclamo listaDeReclamosReclamoToAttach : servicio.getListaDeReclamos()) {
                listaDeReclamosReclamoToAttach = em.getReference(listaDeReclamosReclamoToAttach.getClass(), listaDeReclamosReclamoToAttach.getId());
                attachedListaDeReclamos.add(listaDeReclamosReclamoToAttach);
            }
            servicio.setListaDeReclamos(attachedListaDeReclamos);
            em.persist(servicio);
            if (empresa != null) {
                empresa.getListaDeServicios().add(servicio);
                empresa = em.merge(empresa);
            }
            for (Reclamo listaDeReclamosReclamo : servicio.getListaDeReclamos()) {
                Servicio oldServicioOfListaDeReclamosReclamo = listaDeReclamosReclamo.getServicio();
                listaDeReclamosReclamo.setServicio(servicio);
                listaDeReclamosReclamo = em.merge(listaDeReclamosReclamo);
                if (oldServicioOfListaDeReclamosReclamo != null) {
                    oldServicioOfListaDeReclamosReclamo.getListaDeReclamos().remove(listaDeReclamosReclamo);
                    oldServicioOfListaDeReclamosReclamo = em.merge(oldServicioOfListaDeReclamosReclamo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Servicio servicio) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Servicio persistentServicio = em.find(Servicio.class, servicio.getId());
            Empresa empresaOld = persistentServicio.getEmpresa();
            Empresa empresaNew = servicio.getEmpresa();
            List<Reclamo> listaDeReclamosOld = persistentServicio.getListaDeReclamos();
            List<Reclamo> listaDeReclamosNew = servicio.getListaDeReclamos();
            if (empresaNew != null) {
                empresaNew = em.getReference(empresaNew.getClass(), empresaNew.getId());
                servicio.setEmpresa(empresaNew);
            }
            List<Reclamo> attachedListaDeReclamosNew = new ArrayList<Reclamo>();
            for (Reclamo listaDeReclamosNewReclamoToAttach : listaDeReclamosNew) {
                listaDeReclamosNewReclamoToAttach = em.getReference(listaDeReclamosNewReclamoToAttach.getClass(), listaDeReclamosNewReclamoToAttach.getId());
                attachedListaDeReclamosNew.add(listaDeReclamosNewReclamoToAttach);
            }
            listaDeReclamosNew = attachedListaDeReclamosNew;
            servicio.setListaDeReclamos(listaDeReclamosNew);
            servicio = em.merge(servicio);
            if (empresaOld != null && !empresaOld.equals(empresaNew)) {
                empresaOld.getListaDeServicios().remove(servicio);
                empresaOld = em.merge(empresaOld);
            }
            if (empresaNew != null && !empresaNew.equals(empresaOld)) {
                empresaNew.getListaDeServicios().add(servicio);
                empresaNew = em.merge(empresaNew);
            }
            for (Reclamo listaDeReclamosOldReclamo : listaDeReclamosOld) {
                if (!listaDeReclamosNew.contains(listaDeReclamosOldReclamo)) {
                    listaDeReclamosOldReclamo.setServicio(null);
                    listaDeReclamosOldReclamo = em.merge(listaDeReclamosOldReclamo);
                }
            }
            for (Reclamo listaDeReclamosNewReclamo : listaDeReclamosNew) {
                if (!listaDeReclamosOld.contains(listaDeReclamosNewReclamo)) {
                    Servicio oldServicioOfListaDeReclamosNewReclamo = listaDeReclamosNewReclamo.getServicio();
                    listaDeReclamosNewReclamo.setServicio(servicio);
                    listaDeReclamosNewReclamo = em.merge(listaDeReclamosNewReclamo);
                    if (oldServicioOfListaDeReclamosNewReclamo != null && !oldServicioOfListaDeReclamosNewReclamo.equals(servicio)) {
                        oldServicioOfListaDeReclamosNewReclamo.getListaDeReclamos().remove(listaDeReclamosNewReclamo);
                        oldServicioOfListaDeReclamosNewReclamo = em.merge(oldServicioOfListaDeReclamosNewReclamo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = servicio.getId();
                if (findServicio(id) == null) {
                    throw new NonexistentEntityException("The servicio with id " + id + " no longer exists.");
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
            Servicio servicio;
            try {
                servicio = em.getReference(Servicio.class, id);
                servicio.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The servicio with id " + id + " no longer exists.", enfe);
            }
            Empresa empresa = servicio.getEmpresa();
            if (empresa != null) {
                empresa.getListaDeServicios().remove(servicio);
                empresa = em.merge(empresa);
            }
            List<Reclamo> listaDeReclamos = servicio.getListaDeReclamos();
            for (Reclamo listaDeReclamosReclamo : listaDeReclamos) {
                listaDeReclamosReclamo.setServicio(null);
                listaDeReclamosReclamo = em.merge(listaDeReclamosReclamo);
            }
            em.remove(servicio);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Servicio> findServicioEntities() {
        return findServicioEntities(true, -1, -1);
    }

    public List<Servicio> findServicioEntities(int maxResults, int firstResult) {
        return findServicioEntities(false, maxResults, firstResult);
    }

    private List<Servicio> findServicioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Servicio.class));
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

    public Servicio findServicio(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Servicio.class, id);
        } finally {
            em.close();
        }
    }

    public int getServicioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Servicio> rt = cq.from(Servicio.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
