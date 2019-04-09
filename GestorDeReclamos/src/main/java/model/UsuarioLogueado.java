/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author JUANA
 */
public class UsuarioLogueado {
 
       private static UsuarioLogueado singletonUsuarioLogueado= null;

    private Usuario unUsuario;
        
    private UsuarioLogueado(){
    
    }
    
     public static UsuarioLogueado getInstance(){
     if(singletonUsuarioLogueado == null){
     singletonUsuarioLogueado = new UsuarioLogueado();  

     }

    return singletonUsuarioLogueado;
 
     }

    

    public void setUnUsuario(Usuario unUsuario) {
        this.unUsuario = unUsuario;
    
     
    }    

    public Usuario getUnUsuario(){
  
        return unUsuario;
    }
}
