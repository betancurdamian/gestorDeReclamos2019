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
import javax.persistence.ManyToOne;

/**
 *
 * @author JUANA
 */
@Entity
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nickname;
    private String password;
    
    @ManyToOne
    private  TipoUsuario unTipoUsuario;
    
    @ManyToOne
    private Empleado unEmpleado;

    public Usuario() {
    }
    

    public Usuario(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }

    public Usuario(String nickname, String password, TipoUsuario unTipoUsuario, Empleado unEmpleado) {
        this.nickname = nickname;
        this.password = password;
        this.unTipoUsuario = unTipoUsuario;
        this.unEmpleado = unEmpleado;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Usuario[ id=" + id + " ]";
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TipoUsuario getUnTipoUsuario() {
        return unTipoUsuario;
    }

    public void setUnTipoUsuario(TipoUsuario unTipoUsuario) {
        this.unTipoUsuario = unTipoUsuario;
    }

    public Empleado getUnEmpleado() {
        return unEmpleado;
    }

    public void setUnEmpleado(Empleado unEmpleado) {
        this.unEmpleado = unEmpleado;
    }
    
}
