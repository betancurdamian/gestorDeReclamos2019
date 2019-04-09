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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Reclamo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String unaDescripcionInicial;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente unCliente;

    @ManyToOne
    @JoinColumn(name = "id_empleadoComercial")
    private Empleado unEmpleadoComercial;

    @ManyToOne
    @JoinColumn(name = "id_empleadoExperto")
    private Empleado unEmpleadoExperto;

    @ManyToOne
    @JoinColumn(name = "id_tipoDeUrgencia")
    private TipoDeUrgencia unTipoDeUrgencia;

    @ManyToOne
    @JoinColumn(name = "id_tipoDeReclamo")
    private TipoDeReclamo unTipoDeReclamo;

    @ManyToOne
    @JoinColumn(name = "id_estadoReclamo")
    private EstadoReclamo unEstadoReclamo;

    @OneToMany(mappedBy = "reclamo", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE},fetch = FetchType.LAZY, orphanRemoval = true)
    private List<LineaDeReclamo> lineasDeReclamo = new ArrayList<>();
    

    
  
    @ManyToOne
    @JoinColumn(name = "id_servicio")
    private Servicio servicio;

    public Reclamo() {
    }

    public Reclamo(String unaDescripcionInicial, Cliente unCliente, Empleado unEmpleadoComercial, Empleado unEmpleadoExperto, TipoDeUrgencia unTipoDeUrgencia, TipoDeReclamo unTipoDeReclamo, EstadoReclamo unEstadoReclamo, Servicio servicio) {
        this.unaDescripcionInicial = unaDescripcionInicial;
        this.unCliente = unCliente;
        this.unEmpleadoComercial = unEmpleadoComercial;
        this.unEmpleadoExperto = unEmpleadoExperto;
        this.unTipoDeUrgencia = unTipoDeUrgencia;
        this.unTipoDeReclamo = unTipoDeReclamo;
        this.unEstadoReclamo = unEstadoReclamo;
        this.servicio = servicio;
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
        if (!(object instanceof Reclamo)) {
            return false;
        }
        Reclamo other = (Reclamo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.ReclamoA[ id=" + id + " ]";
    }

    public String getUnaDescripcionInicial() {
        return unaDescripcionInicial;
    }

    public void setUnaDescripcionInicial(String unaDescripcionInicial) {
        this.unaDescripcionInicial = unaDescripcionInicial;
    }

    public Cliente getUnCliente() {
        return unCliente;
    }

    public void setUnCliente(Cliente unCliente) {
        this.unCliente = unCliente;
    }

    public Empleado getUnEmpleadoComercial() {
        return unEmpleadoComercial;
    }

    public void setUnEmpleadoComercial(Empleado unEmpleadoComercial) {
        this.unEmpleadoComercial = unEmpleadoComercial;
    }

    public Empleado getUnEmpleadoExperto() {
        return unEmpleadoExperto;
    }

    public void setUnEmpleadoExperto(Empleado unEmpleadoExperto) {
        this.unEmpleadoExperto = unEmpleadoExperto;
    }

    public TipoDeUrgencia getUnTipoDeUrgencia() {
        return unTipoDeUrgencia;
    }

    public void setUnTipoDeUrgencia(TipoDeUrgencia unTipoDeUrgencia) {
        this.unTipoDeUrgencia = unTipoDeUrgencia;
    }

    public TipoDeReclamo getUnTipoDeReclamo() {
        return unTipoDeReclamo;
    }

    public void setUnTipoDeReclamo(TipoDeReclamo unTipoDeReclamo) {
        this.unTipoDeReclamo = unTipoDeReclamo;
    }

    public EstadoReclamo getUnEstadoReclamo() {
        return unEstadoReclamo;
    }

    public void setUnEstadoReclamo(EstadoReclamo unEstadoReclamo) {
        this.unEstadoReclamo = unEstadoReclamo;
    }

    public List<LineaDeReclamo> getLineasDeReclamo() {
        return lineasDeReclamo;
    }

    public void setLineasDeReclamo(List<LineaDeReclamo> lineasDeReclamo) {
        this.lineasDeReclamo = lineasDeReclamo;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    
}
