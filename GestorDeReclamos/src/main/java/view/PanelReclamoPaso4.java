package view;

import controller.ControllerProcesarReclamo;

/**
 *
 * @author JUANA
 */
public class PanelReclamoPaso4 extends javax.swing.JPanel {

    private String unaDescripcionInicialReclamo;
    private ControllerProcesarReclamo controlador;

    public PanelReclamoPaso4(ControllerProcesarReclamo controladorParametro) {
        this.controlador = controladorParametro;
        initComponents();

        btn_siguiente.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenido4 = new javax.swing.JPanel();
        lbl_nuevoReclamoDeCliente = new javax.swing.JLabel();
        lbl_Pasos = new javax.swing.JLabel();
        barra = new javax.swing.JProgressBar();
        lbl_DescripcionDeUnReclamo = new javax.swing.JLabel();
        btn_cancelar = new javax.swing.JButton();
        btn_siguiente = new javax.swing.JButton();
        jTextArea_descripcionInicial = new java.awt.TextArea();

        setPreferredSize(new java.awt.Dimension(1200, 750));
        setLayout(null);

        jPanelContenido4.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContenido4.setPreferredSize(new java.awt.Dimension(1200, 750));
        jPanelContenido4.setLayout(null);

        lbl_nuevoReclamoDeCliente.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbl_nuevoReclamoDeCliente.setText("                   Nuevo Reclamo De Cliente");
        lbl_nuevoReclamoDeCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_nuevoReclamoDeCliente.setOpaque(true);
        lbl_nuevoReclamoDeCliente.setPreferredSize(new java.awt.Dimension(1000, 100));
        jPanelContenido4.add(lbl_nuevoReclamoDeCliente);
        lbl_nuevoReclamoDeCliente.setBounds(0, 0, 1200, 100);

        lbl_Pasos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_Pasos.setText("Pasos de Proceso 4-6(Agregar Descripción Inicial)");
        jPanelContenido4.add(lbl_Pasos);
        lbl_Pasos.setBounds(380, 120, 410, 22);

        barra.setForeground(new java.awt.Color(0, 153, 0));
        barra.setMaximum(120);
        barra.setValue(80);
        barra.setPreferredSize(new java.awt.Dimension(120, 15));
        barra.setString("80%");
        jPanelContenido4.add(barra);
        barra.setBounds(10, 150, 1030, 20);

        lbl_DescripcionDeUnReclamo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbl_DescripcionDeUnReclamo.setText("Descripción inicial de un reclamo");
        jPanelContenido4.add(lbl_DescripcionDeUnReclamo);
        lbl_DescripcionDeUnReclamo.setBounds(33, 254, 371, 51);

        btn_cancelar.setBackground(new java.awt.Color(255, 0, 0));
        btn_cancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setText("CANCELAR");
        btn_cancelar.setPreferredSize(new java.awt.Dimension(240, 40));
        jPanelContenido4.add(btn_cancelar);
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
        jPanelContenido4.add(btn_siguiente);
        btn_siguiente.setBounds(580, 620, 240, 40);

        jTextArea_descripcionInicial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextArea_descripcionInicialKeyReleased(evt);
            }
        });
        jPanelContenido4.add(jTextArea_descripcionInicial);
        jTextArea_descripcionInicial.setBounds(30, 310, 790, 210);

        add(jPanelContenido4);
        jPanelContenido4.setBounds(0, 0, 1200, 750);
    }// </editor-fold>//GEN-END:initComponents


    private void jTextArea_descripcionInicialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextArea_descripcionInicialKeyReleased

        unaDescripcionInicialReclamo = jTextArea_descripcionInicial.getText();
        if (!unaDescripcionInicialReclamo.isEmpty()) {
            btn_siguiente.setEnabled(true);
        }
    }//GEN-LAST:event_jTextArea_descripcionInicialKeyReleased

    private void btn_siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_siguienteActionPerformed

        if (!unaDescripcionInicialReclamo.isEmpty()) {
            this.controlador.setUnaDescripcionInicialReclamo(unaDescripcionInicialReclamo);

        }
    }//GEN-LAST:event_btn_siguienteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_siguiente;
    private javax.swing.JPanel jPanelContenido4;
    private java.awt.TextArea jTextArea_descripcionInicial;
    private javax.swing.JLabel lbl_DescripcionDeUnReclamo;
    private javax.swing.JLabel lbl_Pasos;
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
