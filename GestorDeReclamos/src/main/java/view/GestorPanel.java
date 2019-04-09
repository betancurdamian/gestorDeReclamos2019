/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProcesarReclamo;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.tree.TreePath;
import model.Cliente;
import model.JpaController.ClienteJpaController;
import model.Servicio;

public class GestorPanel extends javax.swing.JPanel {

private PanelBienvenida panelBienvenida;
private GestorPanel panelEmpleadoComercial;
private PanelReclamoPaso1 unPanelReclamoPaso1;
private PanelReclamoPaso2 unPanelReclamoPaso2;
private PanelReclamoPaso3 unPanelReclamoPaso3;
private PanelReclamoPaso4 unPanelReclamoPaso4;
private PanelReclamoPaso5 unPanelReclamoPaso5;
private PanelReclamoPaso6 unPanelReclamoPaso6;
private ControllerProcesarReclamo controlador;
private PanelBuscarReclamoCliente unPanelBuscarReclamoCliente;
private PanelConsultaReclamo unPanelConsultaReclamo;
private Cliente clienteReclamo = null;
private Servicio unServicioReclamo = null;
private ClienteJpaController clienteDao;
 
    public GestorPanel(ControllerProcesarReclamo controladorParametro) {
        initComponents();
           this.controlador= controladorParametro;
           panelBienvenida = new PanelBienvenida();
           panelBienvenida.setBounds(0, 0, 1200, 750);
           panelBienvenida.setVisible(true);
           jPanelContenido.add(panelBienvenida);
           panelBienvenida.repaint();
                                
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenido = new javax.swing.JPanel();
        jScrollPanel = new javax.swing.JScrollPane();
        jPanelArbol = new javax.swing.JPanel();
        arbolEmpleadoComercial = new javax.swing.JTree();

        setPreferredSize(new java.awt.Dimension(1500, 750));
        setLayout(null);

        jPanelContenido.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContenido.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelContenido.setPreferredSize(new java.awt.Dimension(1200, 750));

        javax.swing.GroupLayout jPanelContenidoLayout = new javax.swing.GroupLayout(jPanelContenido);
        jPanelContenido.setLayout(jPanelContenidoLayout);
        jPanelContenidoLayout.setHorizontalGroup(
            jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1196, Short.MAX_VALUE)
        );
        jPanelContenidoLayout.setVerticalGroup(
            jPanelContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 746, Short.MAX_VALUE)
        );

        add(jPanelContenido);
        jPanelContenido.setBounds(300, 0, 1200, 750);

        jScrollPanel.setPreferredSize(new java.awt.Dimension(300, 750));

        arbolEmpleadoComercial.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("INCATEL");
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Modulo Gestor De Reclamos");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Nuevo Reclamo");
        treeNode2.add(treeNode3);
        treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Buscar Reclamo de Clientes");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        arbolEmpleadoComercial.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        arbolEmpleadoComercial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arbolEmpleadoComercialMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelArbolLayout = new javax.swing.GroupLayout(jPanelArbol);
        jPanelArbol.setLayout(jPanelArbolLayout);
        jPanelArbolLayout.setHorizontalGroup(
            jPanelArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArbolLayout.createSequentialGroup()
                .addComponent(arbolEmpleadoComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        jPanelArbolLayout.setVerticalGroup(
            jPanelArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelArbolLayout.createSequentialGroup()
                .addComponent(arbolEmpleadoComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jScrollPanel.setViewportView(jPanelArbol);

        add(jScrollPanel);
        jScrollPanel.setBounds(0, 0, 300, 750);
    }// </editor-fold>//GEN-END:initComponents

    private void arbolEmpleadoComercialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_arbolEmpleadoComercialMouseClicked
     TreePath tp = arbolEmpleadoComercial.getPathForLocation(evt.getX(), evt.getY());     
       if (tp != null){
             String captura = arbolEmpleadoComercial.getSelectionPath().toString();
            /*Intentanmos validar si la cadena equivale a vacio.
              Si ejecutamos nos daremos cuenta que esto
             genera una excepciòn ya que la cadena es nula*/
                                        
       
            
            if(captura.equals("[INCATEL, Modulo Gestor De Reclamos, Nuevo Reclamo]")){  
                             

                unPanelReclamoPaso1 = new PanelReclamoPaso1(controlador);
                unPanelReclamoPaso1.setBounds(0, 0, 1200, 750);
                unPanelReclamoPaso1.setVisible(true);
//                
//                ClienteJpaController modelo = new ClienteJpaController(Conexion.getEntityManagerFactory());
//                 
//                
//               ControllerProcesarReclamo controlador = new ControllerProcesarReclamo(unPanelReclamoPaso1, modelo);
                
//                unPanelReclamoPaso1.setControlador(controlador);

                jPanelContenido.removeAll();
                jPanelContenido.add(unPanelReclamoPaso1, BorderLayout.EAST);
                jPanelContenido.repaint();
            
                
                   //panel paso 1 muestra el panel 2
                   unPanelReclamoPaso1.getBtn_siguiente().addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent e) {
                                        
                                        jPanelContenido.removeAll();
                                        unPanelReclamoPaso2 = new PanelReclamoPaso2(unPanelReclamoPaso1.getControlador());
                                        unPanelReclamoPaso2.setBounds(0, 0, 1200, 750); 
                                        jPanelContenido.add(unPanelReclamoPaso2);
                                        unPanelReclamoPaso2.setVisible(true);
                                        unPanelReclamoPaso2.repaint(); 
                                        //hasta aca esta bien.        
                                        
                                        //panel paso 2 muestra el panel 3
                                        unPanelReclamoPaso2.getBtn_siguiente().addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                        jPanelContenido.removeAll();
                                        unPanelReclamoPaso3 = new PanelReclamoPaso3(unPanelReclamoPaso2.getControlador());
                                        unPanelReclamoPaso3.setBounds(0, 0, 1200, 750); 
                                        jPanelContenido.add(unPanelReclamoPaso3);
                                        unPanelReclamoPaso3.setVisible(true);
                                        unPanelReclamoPaso3.repaint(); 
                                                //panel paso 3 muestra el panel 4
                                                unPanelReclamoPaso3.getBtn_siguiente().addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                jPanelContenido.removeAll();
                                                unPanelReclamoPaso4 = new PanelReclamoPaso4(unPanelReclamoPaso3.getControlador());
                                                unPanelReclamoPaso4.setBounds(0, 0, 1200, 750); 
                                                jPanelContenido.add(unPanelReclamoPaso4);
                                                unPanelReclamoPaso4.setVisible(true);
                                                unPanelReclamoPaso4.repaint(); 

                                                        
                                                        //panel paso 4 muestra el panel 5
                                                        unPanelReclamoPaso4.getBtn_siguiente().addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                        jPanelContenido.removeAll();
                                                        unPanelReclamoPaso5 = new PanelReclamoPaso5(unPanelReclamoPaso4.getControlador());
                                                        unPanelReclamoPaso5.setBounds(0, 0, 1200, 750); 
                                                        jPanelContenido.add(unPanelReclamoPaso5);
                                                        unPanelReclamoPaso5.setVisible(true);
                                                        unPanelReclamoPaso5.repaint();     
                                                            
                                                            //panel paso 5 muestra el panel 6
                                                            unPanelReclamoPaso5.getBtn_siguiente().addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                            jPanelContenido.removeAll();
                                                            unPanelReclamoPaso6 = new PanelReclamoPaso6(unPanelReclamoPaso5.getControlador());
                                                            unPanelReclamoPaso6.setBounds(0, 0, 1200, 750); 
                                                            jPanelContenido.add(unPanelReclamoPaso6);
                                                            unPanelReclamoPaso6.setVisible(true);
                                                            unPanelReclamoPaso6.repaint();
                                                           
//                                                            System.out.println("tipo de urgencia controlador: "+controlador.getUnTipoDeUrgenciaReclamo().getUnTipoDeUrgencia());

                                                                        //panel 6 vuelve al inicio
                                                                        unPanelReclamoPaso6.getBtn_FinalizarReclamo().addActionListener(new ActionListener() {
                                                                        @Override
                                                                        public void actionPerformed(ActionEvent e) {
                                                                        jPanelContenido.removeAll();
                                                                        panelBienvenida = new PanelBienvenida();
                                                                        panelBienvenida.setBounds(0, 0, 1200, 750);
                                                                        panelBienvenida.setVisible(true);
                                                                        jPanelContenido.add(panelBienvenida);
                                                                        panelBienvenida.repaint();
                                                                        
                                                                        }
                                                                        });



                                                                        //panel 6 vuelve al inicio
                                                                        unPanelReclamoPaso6.getBtn_Cancelar().addActionListener(new ActionListener() {
                                                                        @Override
                                                                        public void actionPerformed(ActionEvent e) {
                                                                        jPanelContenido.removeAll();
                                                                        panelBienvenida = new PanelBienvenida();
                                                                        panelBienvenida.setBounds(0, 0, 1200, 750);
                                                                        panelBienvenida.setVisible(true);
                                                                        jPanelContenido.add(panelBienvenida);
                                                                        panelBienvenida.repaint();
                                                                        
                                                                        }
                                                                        });
                                                            }
                                                            });
                                                            
                                                            //panel 5 vuelve al inicio
                                                            unPanelReclamoPaso5.getBtn_cancelar().addActionListener(new ActionListener() {
                                                            @Override
                                                            public void actionPerformed(ActionEvent e) {
                                                            jPanelContenido.removeAll();
                                                            panelBienvenida = new PanelBienvenida();
                                                            panelBienvenida.setBounds(0, 0, 1200, 750);
                                                            panelBienvenida.setVisible(true);
                                                            jPanelContenido.add(panelBienvenida);
                                                            panelBienvenida.repaint();                                                              
                                                            }
                                                            });
                                                        }
                                                        });
                                                        
                                                        //panel 4 vuelve al inicio
                                                        unPanelReclamoPaso4.getBtn_cancelar().addActionListener(new ActionListener() {
                                                        @Override
                                                        public void actionPerformed(ActionEvent e) {
                                                        jPanelContenido.removeAll();
                                                        panelBienvenida = new PanelBienvenida();
                                                        panelBienvenida.setBounds(0, 0, 1200, 750);
                                                        panelBienvenida.setVisible(true);
                                                        jPanelContenido.add(panelBienvenida);
                                                        panelBienvenida.repaint();                                                   
                                                        }
                                                        });
                                                }
                                                });
                                                
                                                //panel 3 vuelve al inicio
                                                unPanelReclamoPaso3.getBtn_Cancelar().addActionListener(new ActionListener() {
                                                @Override
                                                public void actionPerformed(ActionEvent e) {
                                                jPanelContenido.removeAll();
                                                panelBienvenida = new PanelBienvenida();
                                                panelBienvenida.setBounds(0, 0, 1200, 750);
                                                panelBienvenida.setVisible(true);
                                                jPanelContenido.add(panelBienvenida);
                                                panelBienvenida.repaint();                                             
                                                }
                                                });
                                        }
                                        });
                                        
                                        //panel 2 vuelve al inicio
                                        unPanelReclamoPaso2.getBtn_cancelar().addActionListener(new ActionListener() {
                                            @Override
                                            public void actionPerformed(ActionEvent e) {
                                            jPanelContenido.removeAll();
                                            panelBienvenida = new PanelBienvenida();
                                            panelBienvenida.setBounds(0, 0, 1200, 750);
                                            panelBienvenida.setVisible(true);
                                            jPanelContenido.add(panelBienvenida);
                                            panelBienvenida.repaint();  
                                            }
                                        });
                            } 
                          });
                   //panel 1 vuelve al inicio     
                   unPanelReclamoPaso1.getBtn_cancelar().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                                       jPanelContenido.removeAll();
                                       panelBienvenida = new PanelBienvenida();
                                       panelBienvenida.setBounds(0, 0, 1200, 750);
                                        panelBienvenida.setVisible(true);
                                        jPanelContenido.add(panelBienvenida);
                                        panelBienvenida.repaint();                               
                    }
                   });
                          
                                  
                                      

                               
 }

           if(captura.equals("[INCATEL, Modulo Gestor De Reclamos, Buscar Reclamo de Clientes]")){
                unPanelBuscarReclamoCliente = new PanelBuscarReclamoCliente(controlador);
                unPanelBuscarReclamoCliente.setBounds(0, 0, 1200, 750);
                unPanelBuscarReclamoCliente.setVisible(true);
                
                jPanelContenido.removeAll();
                jPanelContenido.add(unPanelBuscarReclamoCliente, BorderLayout.EAST);
                jPanelContenido.repaint();
                
                    unPanelBuscarReclamoCliente.getBtn_verReclamo().addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                          jPanelContenido.removeAll();
                          unPanelConsultaReclamo = new PanelConsultaReclamo(unPanelBuscarReclamoCliente.getControlador());
                          unPanelConsultaReclamo.setBounds(0, 0, 1200, 750);
                          unPanelConsultaReclamo.setVisible(true);
                          jPanelContenido.add(unPanelConsultaReclamo);
                          unPanelConsultaReclamo.repaint();
                    
                               unPanelConsultaReclamo.getBtn_anterior().addActionListener(new ActionListener() {
                               @Override
                               public void actionPerformed(ActionEvent e) {
                                       jPanelContenido.removeAll();
                                        add(jPanelContenido);
                                        add(jScrollPanel);
                                        unPanelBuscarReclamoCliente.setBounds(0, 0, 1200, 750);
                                        jPanelContenido.add(unPanelBuscarReclamoCliente);
                                        unPanelBuscarReclamoCliente.setVisible(true);
                                        jScrollPanel.setVisible(true);
                                        jPanelContenido.repaint();
                                        jScrollPanel.repaint(); 

                               }
                           });
                    }
                });
       }
             
    }//GEN-LAST:event_arbolEmpleadoComercialMouseClicked
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbolEmpleadoComercial;
    private javax.swing.JPanel jPanelArbol;
    private javax.swing.JPanel jPanelContenido;
    private javax.swing.JScrollPane jScrollPanel;
    // End of variables declaration//GEN-END:variables


    
}
