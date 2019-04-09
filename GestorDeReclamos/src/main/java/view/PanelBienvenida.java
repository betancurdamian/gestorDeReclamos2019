/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author JUANA
 */
public class PanelBienvenida extends javax.swing.JPanel {

//PANEL DE BIENVENIDA
    public PanelBienvenida() {
        initComponents();
        lbl_imagen.setBounds(200, 150, 800, 518);
       ImageIcon carpetaModificar = new ImageIcon(getClass().getResource("/image/imagenWifi.jpg"));
       ImageIcon icono = new ImageIcon(carpetaModificar.getImage().getScaledInstance(lbl_imagen.getWidth(), lbl_imagen.getHeight(), Image.SCALE_SMOOTH));
       lbl_imagen.setIcon(icono);
//       add(lbl_imagen);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenido1 = new javax.swing.JPanel();
        lbl_menuPrincipal = new javax.swing.JLabel();
        lbl_imagen = new javax.swing.JLabel();

        setLayout(null);

        jPanelContenido1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContenido1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanelContenido1.setPreferredSize(new java.awt.Dimension(1200, 750));
        jPanelContenido1.setLayout(null);

        lbl_menuPrincipal.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbl_menuPrincipal.setText("                           MENU PRINCIPAL");
        lbl_menuPrincipal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        lbl_menuPrincipal.setOpaque(true);
        jPanelContenido1.add(lbl_menuPrincipal);
        lbl_menuPrincipal.setBounds(2, 2, 1293, 80);

        lbl_imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/imagenWifi.jpg"))); // NOI18N
        jPanelContenido1.add(lbl_imagen);
        lbl_imagen.setBounds(111, 100, 1055, 518);

        add(jPanelContenido1);
        jPanelContenido1.setBounds(0, 0, 1200, 750);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanelContenido1;
    private javax.swing.JLabel lbl_imagen;
    private javax.swing.JLabel lbl_menuPrincipal;
    // End of variables declaration//GEN-END:variables
}
