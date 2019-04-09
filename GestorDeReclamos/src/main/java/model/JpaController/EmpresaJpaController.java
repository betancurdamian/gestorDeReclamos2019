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
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import model.Empleado;
import model.Cliente;
import model.Empresa;
import model.JpaController.exceptions.IllegalOrphanException;
import model.JpaController.exceptions.NonexistentEntityException;

/**
 *
 * @author JUANA
 */
public class EmpresaJpaController implements Serializable {

    public EmpresaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empresa empresa) {
        if (empresa.getListaDeServicios() == null) {
            empresa.setListaDeServicios(new ArrayList<Servicio>());
        }
        if (empresa.getListaDeEmpleados() == null) {
            empresa.setListaDeEmpleados(new ArrayList<Empleado>());
        }
        if (empresa.getListaDeClientes() == null) {
            empresa.setListaDeClientes(new ArrayList<Cliente>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Servicio> attachedListaDeServicios = new ArrayList<Servicio>();
            for (Servicio listaDeServiciosServicioToAttach : empresa.getListaDeServicios()) {
                listaDeServiciosServicioToAttach = em.getReference(listaDeServiciosServicioToAttach.getClass(), listaDeServiciosServicioToAttach.getId());
                attachedListaDeServicios.add(listaDeServiciosServicioToAttach);
            }
            empresa.setListaDeServicios(attachedListaDeServicios);
            List<Empleado> attachedListaDeEmpleados = new ArrayList<Empleado>();
            for (Empleado listaDeEmpleadosEmpleadoToAttach : empresa.getListaDeEmpleados()) {
                listaDeEmpleadosEmpleadoToAttach = em.getReference(listaDeEmpleadosEmpleadoToAttach.getClass(), listaDeEmpleadosEmpleadoToAttach.getId());
                attachedListaDeEmpleados.add(listaDeEmpleadosEmpleadoToAttach);
            }
            empresa.setListaDeEmpleados(attachedListaDeEmpleados);
            List<Cliente> attachedListaDeClientes = new ArrayList<Cliente>();
            for (Cliente listaDeClientesClienteToAttach : empresa.getListaDeClientes()) {
                listaDeClientesClienteToAttach = em.getReference(listaDeClientesClienteToAttach.getClass(), listaDeClientesClienteToAttach.getId());
                attachedListaDeClientes.add(listaDeClientesClienteToAttach);
            }
            empresa.setListaDeClientes(attachedListaDeClientes);
            em.persist(empresa);
            for (Servicio listaDeServiciosServicio : empresa.getListaDeServicios()) {
                Empresa oldEmpresaOfListaDeServiciosServicio = listaDeServiciosServicio.getEmpresa();
                listaDeServiciosServicio.setEmpresa(empresa);
                listaDeServiciosServicio = em.merge(listaDeServiciosServicio);
                if (oldEmpresaOfListaDeServiciosServicio != null) {
                    oldEmpresaOfListaDeServiciosServicio.getListaDeServicios().remove(listaDeServiciosServicio);
                    oldEmpresaOfListaDeServiciosServicio = em.merge(oldEmpresaOfListaDeServiciosServicio);
                }
            }
            for (Empleado listaDeEmpleadosEmpleado : empresa.getListaDeEmpleados()) {
                Empresa oldEmpresaOfListaDeEmpleadosEmpleado = listaDeEmpleadosEmpleado.getEmpresa();
                listaDeEmpleadosEmpleado.setEmpresa(empresa);
                listaDeEmpleadosEmpleado = em.merge(listaDeEmpleadosEmpleado);
                if (oldEmpresaOfListaDeEmpleadosEmpleado != null) {
                    oldEmpresaOfListaDeEmpleadosEmpleado.getListaDeEmpleados().remove(listaDeEmpleadosEmpleado);
                    oldEmpresaOfListaDeEmpleadosEmpleado = em.merge(oldEmpresaOfListaDeEmpleadosEmpleado);
                }
            }
            for (Cliente listaDeClientesCliente : empresa.getListaDeClientes()) {
                Empresa oldEmpresaOfListaDeClientesCliente = listaDeClientesCliente.getEmpresa();
                listaDeClientesCliente.setEmpresa(empresa);
                listaDeClientesCliente = em.merge(listaDeClientesCliente);
                if (oldEmpresaOfListaDeClientesCliente != null) {
                    oldEmpresaOfListaDeClientesCliente.getListaDeClientes().remove(listaDeClientesCliente);
                    oldEmpresaOfListaDeClientesCliente = em.merge(oldEmpresaOfListaDeClientesCliente);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Empresa empresa) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empresa persistentEmpresa = em.find(Empresa.class, empresa.getId());
            List<Servicio> listaDeServiciosOld = persistentEmpresa.getListaDeServicios();
            List<Servicio> listaDeServiciosNew = empresa.getListaDeServicios();
            List<Empleado> listaDeEmpleadosOld = persistentEmpresa.getListaDeEmpleados();
            List<Empleado> listaDeEmpleadosNew = empresa.getListaDeEmpleados();
            List<Cliente> listaDeClientesOld = persistentEmpresa.getListaDeClientes();
            List<Cliente> listaDeClientesNew = empresa.getListaDeClientes();
            List<String> illegalOrphanMessages = null;
            for (Servicio listaDeServiciosOldServicio : listaDeServiciosOld) {
                if (!listaDeServiciosNew.contains(listaDeServiciosOldServicio)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Servicio " + listaDeServiciosOldServicio + " since its empresa field is not nullable.");
                }
            }
            for (Empleado listaDeEmpleadosOldEmpleado : listaDeEmpleadosOld) {
                if (!listaDeEmpleadosNew.contains(listaDeEmpleadosOldEmpleado)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Empleado " + listaDeEmpleadosOldEmpleado + " since its empresa field is not nullable.");
                }
            }
            for (Cliente listaDeClientesOldCliente : listaDeClientesOld) {
                if (!listaDeClientesNew.contains(listaDeClientesOldCliente)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Cliente " + listaDeClientesOldCliente + " since its empresa field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            List<Servicio> attachedListaDeServiciosNew = new ArrayList<Servicio>();
            for (Servicio listaDeServiciosNewServicioToAttach : listaDeServiciosNew) {
                listaDeServiciosNewServicioToAttach = em.getReference(listaDeServiciosNewServicioToAttach.getClass(), listaDeServiciosNewServicioToAttach.getId());
                attachedListaDeServiciosNew.add(listaDeServiciosNewServicioToAttach);
            }
            listaDeServiciosNew = attachedListaDeServiciosNew;
            empresa.setListaDeServicios(listaDeServiciosNew);
            List<Empleado> attachedListaDeEmpleadosNew = new ArrayList<Empleado>();
            for (Empleado listaDeEmpleadosNewEmpleadoToAttach : listaDeEmpleadosNew) {
                listaDeEmpleadosNewEmpleadoToAttach = em.getReference(listaDeEmpleadosNewEmpleadoToAttach.getClass(), listaDeEmpleadosNewEmpleadoToAttach.getId());
                attachedListaDeEmpleadosNew.add(listaDeEmpleadosNewEmpleadoToAttach);
            }
            listaDeEmpleadosNew = attachedListaDeEmpleadosNew;
            empresa.setListaDeEmpleados(listaDeEmpleadosNew);
            List<Cliente> attachedListaDeClientesNew = new ArrayList<Cliente>();
            for (Cliente listaDeClientesNewClienteToAttach : listaDeClientesNew) {
                listaDeClientesNewClienteToAttach = em.getReference(listaDeClientesNewClienteToAttach.getClass(), listaDeClientesNewClienteToAttach.getId());
                attachedListaDeClientesNew.add(listaDeClientesNewClienteToAttach);
            }
            listaDeClientesNew = attachedListaDeClientesNew;
            empresa.setListaDeClientes(listaDeClientesNew);
            empresa = em.merge(empresa);
            for (Servicio listaDeServiciosNewServicio : listaDeServiciosNew) {
                if (!listaDeServiciosOld.contains(listaDeServiciosNewServicio)) {
                    Empresa oldEmpresaOfListaDeServiciosNewServicio = listaDeServiciosNewServicio.getEmpresa();
                    listaDeServiciosNewServicio.setEmpresa(empresa);
                    listaDeServiciosNewServicio = em.merge(listaDeServiciosNewServicio);
                    if (oldEmpresaOfListaDeServiciosNewServicio != null && !oldEmpresaOfListaDeServiciosNewServicio.equals(empresa)) {
                        oldEmpresaOfListaDeServiciosNewServicio.getListaDeServicios().remove(listaDeServiciosNewServicio);
                        oldEmpresaOfListaDeServiciosNewServicio = em.merge(oldEmpresaOfListaDeServiciosNewServicio);
                    }
                }
            }
            for (Empleado listaDeEmpleadosNewEmpleado : listaDeEmpleadosNew) {
                if (!listaDeEmpleadosOld.contains(listaDeEmpleadosNewEmpleado)) {
                    Empresa oldEmpresaOfListaDeEmpleadosNewEmpleado = listaDeEmpleadosNewEmpleado.getEmpresa();
                    listaDeEmpleadosNewEmpleado.setEmpresa(empresa);
                    listaDeEmpleadosNewEmpleado = em.merge(listaDeEmpleadosNewEmpleado);
                    if (oldEmpresaOfListaDeEmpleadosNewEmpleado != null && !oldEmpresaOfListaDeEmpleadosNewEmpleado.equals(empresa)) {
                        oldEmpresaOfListaDeEmpleadosNewEmpleado.getListaDeEmpleados().remove(listaDeEmpleadosNewEmpleado);
                        oldEmpresaOfListaDeEmpleadosNewEmpleado = em.merge(oldEmpresaOfListaDeEmpleadosNewEmpleado);
                    }
                }
            }
            for (Cliente listaDeClientesNewCliente : listaDeClientesNew) {
                if (!listaDeClientesOld.contains(listaDeClientesNewCliente)) {
                    Empresa oldEmpresaOfListaDeClientesNewCliente = listaDeClientesNewCliente.getEmpresa();
                    listaDeClientesNewCliente.setEmpresa(empresa);
                    listaDeClientesNewCliente = em.merge(listaDeClientesNewCliente);
                    if (oldEmpresaOfListaDeClientesNewCliente != null && !oldEmpresaOfListaDeClientesNewCliente.equals(empresa)) {
                        oldEmpresaOfListaDeClientesNewCliente.getListaDeClientes().remove(listaDeClientesNewCliente);
                        oldEmpresaOfListaDeClientesNewCliente = em.merge(oldEmpresaOfListaDeClientesNewCliente);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = empresa.getId();
                if (findEmpresa(id) == null) {
                    throw new NonexistentEntityException("The empresa with id " + id + " no longer exists.");
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
            Empresa empresa;
            try {
                empresa = em.getReference(Empresa.class, id);
                empresa.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empresa with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            List<Servicio> listaDeServiciosOrphanCheck = empresa.getListaDeServicios();
            for (Servicio listaDeServiciosOrphanCheckServicio : listaDeServiciosOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Servicio " + listaDeServiciosOrphanCheckServicio + " in its listaDeServicios field has a non-nullable empresa field.");
            }
            List<Empleado> listaDeEmpleadosOrphanCheck = empresa.getListaDeEmpleados();
            for (Empleado listaDeEmpleadosOrphanCheckEmpleado : listaDeEmpleadosOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Empleado " + listaDeEmpleadosOrphanCheckEmpleado + " in its listaDeEmpleados field has a non-nullable empresa field.");
            }
            List<Cliente> listaDeClientesOrphanCheck = empresa.getListaDeClientes();
            for (Cliente listaDeClientesOrphanCheckCliente : listaDeClientesOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Empresa (" + empresa + ") cannot be destroyed since the Cliente " + listaDeClientesOrphanCheckCliente + " in its listaDeClientes field has a non-nullable empresa field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(empresa);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empresa> findEmpresaEntities() {
        return findEmpresaEntities(true, -1, -1);
    }

    public List<Empresa> findEmpresaEntities(int maxResults, int firstResult) {
        return findEmpresaEntities(false, maxResults, firstResult);
    }

    private List<Empresa> findEmpresaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empresa.class));
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

    public Empresa findEmpresa(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empresa.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpresaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empresa> rt = cq.from(Empresa.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
