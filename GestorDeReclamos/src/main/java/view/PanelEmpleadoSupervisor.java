/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProcesarReclamo;
import java.awt.BorderLayout;
import javax.swing.tree.TreePath;

/**
 *
 * @author JUANA
 */
public class PanelEmpleadoSupervisor extends javax.swing.JPanel {

private ControllerProcesarReclamo controlador;
private PanelBienvenida panelBienvenida;
private PanelPestacionDeServicioEstadistica unPanelPestacionDeServicioEstadistica;
    public PanelEmpleadoSupervisor(ControllerProcesarReclamo controladorParametro) {
       this.controlador = controladorParametro;
        initComponents();
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
        javax.swing.tree.DefaultMutableTreeNode treeNode2 = new javax.swing.tree.DefaultMutableTreeNode("Modulo Gestor De Empleados");
        javax.swing.tree.DefaultMutableTreeNode treeNode3 = new javax.swing.tree.DefaultMutableTreeNode("Prestación De Servicio Estadistica");
        treeNode2.add(treeNode3);
        treeNode1.add(treeNode2);
        arbolEmpleadoComercial.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        arbolEmpleadoComercial.setPreferredSize(new java.awt.Dimension(300, 750));
        arbolEmpleadoComercial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                arbolEmpleadoComercialMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanelArbolLayout = new javax.swing.GroupLayout(jPanelArbol);
        jPanelArbol.setLayout(jPanelArbolLayout);
        jPanelArbolLayout.setHorizontalGroup(
            jPanelArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 884, Short.MAX_VALUE)
            .addGroup(jPanelArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelArbolLayout.createSequentialGroup()
                    .addComponent(arbolEmpleadoComercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 584, Short.MAX_VALUE)))
        );
        jPanelArbolLayout.setVerticalGroup(
            jPanelArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 772, Short.MAX_VALUE)
            .addGroup(jPanelArbolLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelArbolLayout.createSequentialGroup()
                    .addComponent(arbolEmpleadoComercial, javax.swing.GroupLayout.PREFERRED_SIZE, 761, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 11, Short.MAX_VALUE)))
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

            if(captura.equals("[INCATEL, Modulo Gestor De Empleados, Prestación De Servicio Estadistica]")){
                unPanelPestacionDeServicioEstadistica = new PanelPestacionDeServicioEstadistica();
                unPanelPestacionDeServicioEstadistica.setBounds(0, 0, 1200, 750);
                unPanelPestacionDeServicioEstadistica.setVisible(true);
                
                jPanelContenido.removeAll();
                jPanelContenido.add(unPanelPestacionDeServicioEstadistica, BorderLayout.EAST);
                jPanelContenido.repaint(); 
            }

          
        }
    }//GEN-LAST:event_arbolEmpleadoComercialMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree arbolEmpleadoComercial;
    private javax.swing.JPanel jPanelArbol;
    private javax.swing.JPanel jPanelContenido;
    private javax.swing.JScrollPane jScrollPanel;
    // End of variables declaration//GEN-END:variables
}
