/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.JpaController;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author JUANA
 */
public class Conexion {
             private static final String PERSISTENCE_UNIT_NAME = "FinalIncatelPU";
    private static EntityManagerFactory factory;
    
    public static EntityManagerFactory getEntityManagerFactory(){
        if(factory==null){
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        }
    return factory;
    
}
//    
//    private static EntityManagerFactory emf;
//    private static EntityManager em;
//
//    private static void setup() {
//        if (em == null) {
//            Conexion.emf = Persistence.createEntityManagerFactory("MVCEjemploPU");
//            Conexion.em = Conexion.emf.createEntityManager();
//        }
//    }
//
//    public static EntityManagerFactory getEmf() {
//        return emf;
//    }
//
//    public static void setEmf(EntityManagerFactory emf) {
//        Conexion.emf = emf;
//    }
//
//    public static EntityManager getEm() {
//        return em;
//    }
//
//    public static void setEm(EntityManager em) {
//        Conexion.em = em;
//    }
//
//    public Conexion() {
//        Conexion.setup();
//    }
}
