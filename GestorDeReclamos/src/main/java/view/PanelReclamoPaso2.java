/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProcesarReclamo;
import java.awt.Image;
import javax.swing.ImageIcon;
import model.Servicio;

/**
 *
 * @author JUANA
 */
public class PanelReclamoPaso2 extends javax.swing.JPanel {

    private ControllerProcesarReclamo controlador;
    private Servicio servicioEncontrado;

    public PanelReclamoPaso2(ControllerProcesarReclamo controladorParametro) {
        this.controlador = controladorParametro;

        initComponents();
        lbl_imagenServicio.setBounds(600, 230, 80, 60);
        ImageIcon carpetaModificar = new ImageIcon(getClass().getResource("/image/servicio.jpg"));
        ImageIcon icono = new ImageIcon(carpetaModificar.getImage().getScaledInstance(lbl_imagenServicio.getWidth(), lbl_imagenServicio.getHeight(), Image.SCALE_SMOOTH));
        lbl_imagenServicio.setIcon(icono);
////       add(lbl_imagenServicio);
        btn_siguiente.setEnabled(false);

        buttonGroup_servicio.add(jRadioButton_cable);
        buttonGroup_servicio.add(jRadioButton_internet);
        buttonGroup_servicio.add(jRadioButton_telefonia);
        System.out.println("cliente controlador: " + this.controlador.getUnClienteReclamo().getApellido());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_servicio = new javax.swing.ButtonGroup();
        jPanelContenido2 = new javax.swing.JPanel();
        barra = new javax.swing.JProgressBar();
        lbl_nuevoReclamoDeCliente = new javax.swing.JLabel();
        jRadioButton_telefonia = new javax.swing.JRadioButton();
        jRadioButton_cable = new javax.swing.JRadioButton();
        jRadioButton_internet = new javax.swing.JRadioButton();
        lbl_imagenServicio = new javax.swing.JLabel();
        lbl_Servicio = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        btn_siguiente = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMaximumSize(new java.awt.Dimension(1200, 750));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(1200, 750));
        setLayout(null);

        jPanelContenido2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContenido2.setPreferredSize(new java.awt.Dimension(1200, 750));
        jPanelContenido2.setLayout(null);

        barra.setForeground(new java.awt.Color(0, 153, 0));
        barra.setMaximum(120);
        barra.setValue(40);
        barra.setPreferredSize(new java.awt.Dimension(120, 15));
        barra.setString("40%");
        jPanelContenido2.add(barra);
        barra.setBounds(10, 150, 1030, 20);
        barra.getAccessibleContext().setAccessibleName("");

        lbl_nuevoReclamoDeCliente.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbl_nuevoReclamoDeCliente.setText("                   Nuevo Reclamo De Cliente");
        lbl_nuevoReclamoDeCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_nuevoReclamoDeCliente.setOpaque(true);
        lbl_nuevoReclamoDeCliente.setPreferredSize(new java.awt.Dimension(1200, 100));
        jPanelContenido2.add(lbl_nuevoReclamoDeCliente);
        lbl_nuevoReclamoDeCliente.setBounds(0, 0, 1200, 100);
        lbl_nuevoReclamoDeCliente.getAccessibleContext().setAccessibleDescription("");

        jRadioButton_telefonia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton_telefonia.setText("TELEFONIA");
        jRadioButton_telefonia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_telefoniaActionPerformed(evt);
            }
        });
        jPanelContenido2.add(jRadioButton_telefonia);
        jRadioButton_telefonia.setBounds(70, 480, 117, 31);

        jRadioButton_cable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton_cable.setText("CABLE");
        jRadioButton_cable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_cableActionPerformed(evt);
            }
        });
        jPanelContenido2.add(jRadioButton_cable);
        jRadioButton_cable.setBounds(70, 370, 77, 31);

        jRadioButton_internet.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton_internet.setText("INTERNET");
        jRadioButton_internet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_internetActionPerformed(evt);
            }
        });
        jPanelContenido2.add(jRadioButton_internet);
        jRadioButton_internet.setBounds(70, 420, 109, 31);

        lbl_imagenServicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/servicio.jpg"))); // NOI18N
        lbl_imagenServicio.setPreferredSize(new java.awt.Dimension(80, 60));
        jPanelContenido2.add(lbl_imagenServicio);
        lbl_imagenServicio.setBounds(620, 230, 80, 60);

        lbl_Servicio.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbl_Servicio.setText("SERVICIO");
        jPanelContenido2.add(lbl_Servicio);
        lbl_Servicio.setBounds(440, 280, 156, 44);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Pasos de Proceso 2-6(Seleccionar Servicio)");
        jPanelContenido2.add(jLabel1);
        jLabel1.setBounds(380, 120, 370, 22);

        btn_cancelar.setBackground(new java.awt.Color(255, 0, 0));
        btn_cancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.setPreferredSize(new java.awt.Dimension(240, 40));
        jPanelContenido2.add(btn_cancelar);
        btn_cancelar.setBounds(90, 620, 240, 40);

        btn_siguiente.setBackground(new java.awt.Color(51, 204, 0));
        btn_siguiente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_siguiente.setForeground(new java.awt.Color(255, 255, 255));
        btn_siguiente.setText("SIGUIENTE");
        btn_siguiente.setPreferredSize(new java.awt.Dimension(240, 40));
        jPanelContenido2.add(btn_siguiente);
        btn_siguiente.setBounds(580, 620, 240, 40);

        add(jPanelContenido2);
        jPanelContenido2.setBounds(0, 0, 1200, 750);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton_cableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_cableActionPerformed
        btn_siguiente.setEnabled(true);
        if (jRadioButton_cable.isSelected()) {
            servicioEncontrado = this.controlador.encontrarServicio("cable");
        }
        this.controlador.setUnServicioReclamo(servicioEncontrado);

    }//GEN-LAST:event_jRadioButton_cableActionPerformed

    private void jRadioButton_internetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_internetActionPerformed
        btn_siguiente.setEnabled(true);
        if (jRadioButton_internet.isSelected()) {
            servicioEncontrado = this.controlador.encontrarServicio("internet");
        }
        this.controlador.setUnServicioReclamo(servicioEncontrado);

    }//GEN-LAST:event_jRadioButton_internetActionPerformed

    private void jRadioButton_telefoniaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_telefoniaActionPerformed
        btn_siguiente.setEnabled(true);
        if (jRadioButton_telefonia.isSelected()) {
            servicioEncontrado = this.controlador.encontrarServicio("telefonia");
        }

        this.controlador.setUnServicioReclamo(servicioEncontrado);

    }//GEN-LAST:event_jRadioButton_telefoniaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_siguiente;
    private javax.swing.ButtonGroup buttonGroup_servicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelContenido2;
    private javax.swing.JRadioButton jRadioButton_cable;
    private javax.swing.JRadioButton jRadioButton_internet;
    private javax.swing.JRadioButton jRadioButton_telefonia;
    private javax.swing.JLabel lbl_Servicio;
    private javax.swing.JLabel lbl_imagenServicio;
    private javax.swing.JLabel lbl_nuevoReclamoDeCliente;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getBtn_cancelar() {
        return btn_cancelar;
    }

    public javax.swing.JButton getBtn_siguiente() {
        return btn_siguiente;
    }

    public ControllerProcesarReclamo getControlador() {
        return controlador;
    }

}
