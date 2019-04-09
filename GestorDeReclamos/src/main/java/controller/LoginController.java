/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.JpaController.Conexion;
import model.JpaController.UsuarioJpaController;
import model.Usuario;
import model.UsuarioLogueado;
import view.JFramePrincipal;
import view.Login;
import view.PanelReclamoPaso1;

public class LoginController{ 
    
    UsuarioLogueado usuarioLogueado;
    Usuario unUsuario;
    UsuarioJpaController controladorUsuario = new UsuarioJpaController(Conexion.getEntityManagerFactory());
    Login controladorVista;
     Login login;
    JFramePrincipal frameBienvenida;
    PanelReclamoPaso1 unPanelReclamoPaso1;
   
    
    public void crearUsuario(Usuario u){
    controladorUsuario.create(u);
    }

    
    public boolean login(Usuario u){
    boolean ingreso=false;

    
    Usuario usuarioEncontrado = null;
        for (Usuario usuarioRecorrido : controladorUsuario.findUsuarioEntities()) {
            if (u.getNickname().equals(usuarioRecorrido.getNickname()) && u.getPassword().equals(usuarioRecorrido.getPassword())) {
                usuarioEncontrado=usuarioRecorrido;           
                              
            }
        }
        if (usuarioEncontrado!=null) {
            ingreso=true;
            int valor=1;
             int privilegio;
    
            usuarioLogueado = UsuarioLogueado.getInstance();
            usuarioLogueado.setUnUsuario(usuarioEncontrado);
            System.out.println("SINGLETON: "+UsuarioLogueado.getInstance().getUnUsuario().getNickname()+UsuarioLogueado.getInstance().getUnUsuario().getPassword());
            System.out.println("usuario permitido: "+usuarioEncontrado.getNickname()+usuarioEncontrado.getPassword());
            System.out.println("--------EMPLEADO--------------");
            System.out.println("Nombre: "+UsuarioLogueado.getInstance().getUnUsuario().getUnEmpleado().getNombre());
            System.out.println("Apellido: "+UsuarioLogueado.getInstance().getUnUsuario().getUnEmpleado().getApellido());
            System.out.println("DNI: "+UsuarioLogueado.getInstance().getUnUsuario().getUnEmpleado().getDni());          
      
        } else{
       System.out.println("usuario Denegado");
       } 
               
    return ingreso;
    
    }

    




     }


