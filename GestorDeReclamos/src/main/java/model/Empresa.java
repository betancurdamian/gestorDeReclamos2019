/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author JUANA
 */
@Entity
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String razonSocial;
    private String cuit;
    private String direccion;
    private String telefono;
    

    @OneToMany(mappedBy = "empresa", cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE}, fetch = FetchType.LAZY, orphanRemoval = true)   
    private List<Servicio> listaDeServicios;
    
  
    @OneToMany(mappedBy = "empresa", cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE}, fetch = FetchType.LAZY, orphanRemoval = true)   
    private List<Empleado> listaDeEmpleados;
    

    @OneToMany(mappedBy = "empresa", cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.REMOVE}, fetch = FetchType.LAZY, orphanRemoval = true)   
    private List<Cliente> listaDeClientes;

    public Empresa() {
    listaDeServicios= new ArrayList<>();   
    listaDeEmpleados = new ArrayList<>();
    listaDeClientes= new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Empresa[ id=" + id + " ]";
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public List<Servicio> getListaDeServicios() {
        return listaDeServicios;
    }

    public List<Empleado> getListaDeEmpleados() {
        return listaDeEmpleados;
    }

    public List<Cliente> getListaDeClientes() {
        return listaDeClientes;
    }

    public void setListaDeServicios(List<Servicio> listaDeServicios) {
        this.listaDeServicios = listaDeServicios;
    }

    public void setListaDeEmpleados(List<Empleado> listaDeEmpleados) {
        this.listaDeEmpleados = listaDeEmpleados;
    }

    public void setListaDeClientes(List<Cliente> listaDeClientes) {
        this.listaDeClientes = listaDeClientes;
    }
    
}
