/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author JUANA
 */
@Entity
public class LineaDeReclamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String motivo;

    @ManyToOne
    @JoinColumn(name = "id_estadoLineaDeReclamo")
    private EstadoLineaDeReclamo unEstadoLineaDeReclamo;

    @ManyToOne
    @JoinColumn(name = "id_empleadoExperto")
    private Empleado unEmpleadoExperto;

    @ManyToOne
    @JoinColumn(name = "id_reclamo", nullable = false)
    private Reclamo reclamo;

    public LineaDeReclamo(String motivo, EstadoLineaDeReclamo unEstadoLineaDeReclamo, Empleado unEmpleadoExperto) {
        this.motivo = motivo;
        this.unEstadoLineaDeReclamo = unEstadoLineaDeReclamo;
        this.unEmpleadoExperto = unEmpleadoExperto;
    }

    
    
    public LineaDeReclamo() {
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
        if (!(object instanceof LineaDeReclamo)) {
            return false;
        }
        LineaDeReclamo other = (LineaDeReclamo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.LineaDeReclamoNueva[ id=" + id + " ]";
    }

    

    public EstadoLineaDeReclamo getUnEstadoLineaDeReclamo() {
        return unEstadoLineaDeReclamo;
    }

    public void setUnEstadoLineaDeReclamo(EstadoLineaDeReclamo unEstadoLineaDeReclamo) {
        this.unEstadoLineaDeReclamo = unEstadoLineaDeReclamo;
    }

    public Empleado getUnEmpleadoExperto() {
        return unEmpleadoExperto;
    }

    public void setUnEmpleadoExperto(Empleado unEmpleadoExperto) {
        this.unEmpleadoExperto = unEmpleadoExperto;
    }
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }


    public Reclamo getReclamo() {
        return reclamo;
    }

    public void setReclamo(Reclamo reclamo) {
        this.reclamo = reclamo;
    }

}
