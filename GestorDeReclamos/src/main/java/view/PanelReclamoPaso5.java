/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProcesarReclamo;
import model.EstadoReclamo;
import model.Reclamo;
import model.TipoDeUrgencia;

/**
 *
 * @author JUANA
 */
public class PanelReclamoPaso5 extends javax.swing.JPanel {

    private ControllerProcesarReclamo controlador;
    private TipoDeUrgencia tipoUrgenciaEncontrado;
    private Reclamo unReclamo;

    public PanelReclamoPaso5(ControllerProcesarReclamo controladorParametro) {
        this.controlador = controladorParametro;
        initComponents();
        btn_siguiente.setEnabled(false);
        buttonGroup_tipoDeUrgencia.add(jRadioButton_Critico);
        buttonGroup_tipoDeUrgencia.add(jRadioButton_Urgencia);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup_tipoDeUrgencia = new javax.swing.ButtonGroup();
        jPanelContenido5 = new javax.swing.JPanel();
        lbl_nuevoReclamoDeCliente = new javax.swing.JLabel();
        lbl_pasos = new javax.swing.JLabel();
        barra = new javax.swing.JProgressBar();
        lbl_tipoDeUrgencia = new javax.swing.JLabel();
        jRadioButton_Critico = new javax.swing.JRadioButton();
        jRadioButton_Urgencia = new javax.swing.JRadioButton();
        btn_cancelar = new javax.swing.JButton();
        btn_siguiente = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1200, 750));
        setLayout(null);

        jPanelContenido5.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContenido5.setPreferredSize(new java.awt.Dimension(1200, 750));
        jPanelContenido5.setLayout(null);

        lbl_nuevoReclamoDeCliente.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbl_nuevoReclamoDeCliente.setText("                   Nuevo Reclamo De Cliente");
        lbl_nuevoReclamoDeCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_nuevoReclamoDeCliente.setOpaque(true);
        lbl_nuevoReclamoDeCliente.setPreferredSize(new java.awt.Dimension(1000, 100));
        jPanelContenido5.add(lbl_nuevoReclamoDeCliente);
        lbl_nuevoReclamoDeCliente.setBounds(0, 0, 1200, 100);

        lbl_pasos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_pasos.setText("Pasos de Proceso 5-6(Seleccionar Tipo De Urgencia)");
        jPanelContenido5.add(lbl_pasos);
        lbl_pasos.setBounds(380, 120, 430, 22);

        barra.setForeground(new java.awt.Color(0, 153, 0));
        barra.setMaximum(120);
        barra.setValue(100);
        barra.setPreferredSize(new java.awt.Dimension(120, 15));
        barra.setString("100%");
        jPanelContenido5.add(barra);
        barra.setBounds(10, 150, 1030, 20);

        lbl_tipoDeUrgencia.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbl_tipoDeUrgencia.setText("Tipo de Urgencia");
        jPanelContenido5.add(lbl_tipoDeUrgencia);
        lbl_tipoDeUrgencia.setBounds(410, 250, 270, 44);

        jRadioButton_Critico.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton_Critico.setText("CRITICO");
        jRadioButton_Critico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_CriticoActionPerformed(evt);
            }
        });
        jPanelContenido5.add(jRadioButton_Critico);
        jRadioButton_Critico.setBounds(138, 354, 97, 31);

        jRadioButton_Urgencia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton_Urgencia.setText("URGENTE");
        jRadioButton_Urgencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_UrgenciaActionPerformed(evt);
            }
        });
        jPanelContenido5.add(jRadioButton_Urgencia);
        jRadioButton_Urgencia.setBounds(140, 420, 103, 31);

        btn_cancelar.setBackground(new java.awt.Color(255, 0, 0));
        btn_cancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.setPreferredSize(new java.awt.Dimension(240, 40));
        jPanelContenido5.add(btn_cancelar);
        btn_cancelar.setBounds(90, 620, 240, 40);

        btn_siguiente.setBackground(new java.awt.Color(0, 204, 0));
        btn_siguiente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_siguiente.setForeground(new java.awt.Color(255, 255, 255));
        btn_siguiente.setText("SIGUIENTE");
        btn_siguiente.setPreferredSize(new java.awt.Dimension(240, 40));
        btn_siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_siguienteActionPerformed(evt);
            }
        });
        jPanelContenido5.add(btn_siguiente);
        btn_siguiente.setBounds(580, 620, 240, 40);

        add(jPanelContenido5);
        jPanelContenido5.setBounds(0, 0, 1200, 750);
    }// </editor-fold>//GEN-END:initComponents

    private void jRadioButton_CriticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_CriticoActionPerformed
        btn_siguiente.setEnabled(true);
        if (jRadioButton_Critico.isSelected()) {
            tipoUrgenciaEncontrado = this.controlador.encontrarTipoDeUrgencia("critico");
        }
        this.controlador.setUnTipoDeUrgenciaReclamo(tipoUrgenciaEncontrado);
        System.out.println("tipo de urgencia: " + this.controlador.getUnTipoDeUrgenciaReclamo().getDescripcion());
    }//GEN-LAST:event_jRadioButton_CriticoActionPerformed

    private void jRadioButton_UrgenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_UrgenciaActionPerformed
        btn_siguiente.setEnabled(true);
        if (jRadioButton_Urgencia.isSelected()) {
            tipoUrgenciaEncontrado = this.controlador.encontrarTipoDeUrgencia("urgente");
        }
        this.controlador.setUnTipoDeUrgenciaReclamo(tipoUrgenciaEncontrado);
        System.out.println("tipo de urgencia: " + this.controlador.getUnTipoDeUrgenciaReclamo().getDescripcion());


    }//GEN-LAST:event_jRadioButton_UrgenciaActionPerformed

    private void btn_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_siguienteActionPerformed


    }//GEN-LAST:event_btn_siguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_siguiente;
    private javax.swing.ButtonGroup buttonGroup_tipoDeUrgencia;
    private javax.swing.JPanel jPanelContenido5;
    private javax.swing.JRadioButton jRadioButton_Critico;
    private javax.swing.JRadioButton jRadioButton_Urgencia;
    private javax.swing.JLabel lbl_nuevoReclamoDeCliente;
    private javax.swing.JLabel lbl_pasos;
    private javax.swing.JLabel lbl_tipoDeUrgencia;
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
