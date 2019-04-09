/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProcesarReclamo;
import java.awt.Image;
import javax.swing.ImageIcon;
import model.Reclamo;

/**
 *
 * @author JUANA
 */
public class PanelTareaDeReclamoPaso1 extends javax.swing.JPanel {

private ControllerProcesarReclamo controlador;
private Reclamo unaTareaReclamo;
    public PanelTareaDeReclamoPaso1(ControllerProcesarReclamo controladorParametro) {
        this.controlador = controladorParametro;
        initComponents();
       lbl_imagenServicio.setBounds(700, 230, 80, 60);
       ImageIcon carpetaModificar = new ImageIcon(getClass().getResource("/image/servicio.jpg"));
       ImageIcon icono = new ImageIcon(carpetaModificar.getImage().getScaledInstance(lbl_imagenServicio.getWidth(), lbl_imagenServicio.getHeight(), Image.SCALE_SMOOTH));
       lbl_imagenServicio.setIcon(icono);
       this.btn_siguiente.setEnabled(false);
    mostrarTabla();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenido1 = new javax.swing.JPanel();
        lbl_nuevoReclamoDeCliente = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_listaDeCliente = new javax.swing.JTable();
        btn_siguiente = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        lbl_seleccionarOrdenDeTrabajo = new javax.swing.JLabel();
        lbl_imagenServicio = new javax.swing.JLabel();

        setLayout(null);

        jPanelContenido1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContenido1.setPreferredSize(new java.awt.Dimension(1200, 750));
        jPanelContenido1.setLayout(null);

        lbl_nuevoReclamoDeCliente.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbl_nuevoReclamoDeCliente.setText("                         Tarea De Reclamo ");
        lbl_nuevoReclamoDeCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_nuevoReclamoDeCliente.setOpaque(true);
        lbl_nuevoReclamoDeCliente.setPreferredSize(new java.awt.Dimension(1000, 100));
        jPanelContenido1.add(lbl_nuevoReclamoDeCliente);
        lbl_nuevoReclamoDeCliente.setBounds(0, 0, 1200, 100);

        jTable_listaDeCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable_listaDeCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "NRO RECLAMO", "NRO CLIENTE", "DNI", "APELLIDO", "NOMBRE", "TIPO DE URGENCIA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_listaDeCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_listaDeClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_listaDeCliente);

        jPanelContenido1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 380, 860, 200);

        btn_siguiente.setBackground(new java.awt.Color(0, 204, 0));
        btn_siguiente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_siguiente.setForeground(new java.awt.Color(255, 255, 255));
        btn_siguiente.setText("SIGUIENTE");
        jPanelContenido1.add(btn_siguiente);
        btn_siguiente.setBounds(580, 620, 240, 40);

        btn_cancelar.setBackground(new java.awt.Color(255, 51, 51));
        btn_cancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancelar.setText("CANCELAR");
        jPanelContenido1.add(btn_cancelar);
        btn_cancelar.setBounds(90, 620, 220, 40);

        lbl_seleccionarOrdenDeTrabajo.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_seleccionarOrdenDeTrabajo.setText("SELECCIONAR UNA ORDEN DE TRABAJO");
        jPanelContenido1.add(lbl_seleccionarOrdenDeTrabajo);
        lbl_seleccionarOrdenDeTrabajo.setBounds(400, 250, 320, 60);
        jPanelContenido1.add(lbl_imagenServicio);
        lbl_imagenServicio.setBounds(620, 140, 130, 130);

        add(jPanelContenido1);
        jPanelContenido1.setBounds(0, 0, 1200, 750);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_listaDeClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_listaDeClienteMouseClicked
        //una vez que se hace click en un cliente, se hace visible el boton.

        this.btn_siguiente.setEnabled(true);
        int filaseleccionada = jTable_listaDeCliente.getSelectedRow();
        String nroReclamo = (String)jTable_listaDeCliente.getValueAt(filaseleccionada, 0);
        String nroCliente = (String)jTable_listaDeCliente.getValueAt(filaseleccionada, 1);
        String dni = (String)jTable_listaDeCliente.getValueAt(filaseleccionada, 2);
        String apellido = (String)jTable_listaDeCliente.getValueAt(filaseleccionada, 3);
        String nombre = (String)jTable_listaDeCliente.getValueAt(filaseleccionada, 4);
        String tipoDeUrgencia = (String)jTable_listaDeCliente.getValueAt(filaseleccionada, 5);
        
//        unaTareaReclamo = new Reclamo(nroReclamo, nroCliente, dni, apellido, nombre, tipoDeUrgencia);
    }//GEN-LAST:event_jTable_listaDeClienteMouseClicked
 
    public void mostrarTabla(){
//    this.controlador.ListarRegistroDeClientes(jTable_listaDeCliente);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_siguiente;
    private javax.swing.JPanel jPanelContenido1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_listaDeCliente;
    private javax.swing.JLabel lbl_imagenServicio;
    private javax.swing.JLabel lbl_nuevoReclamoDeCliente;
    private javax.swing.JLabel lbl_seleccionarOrdenDeTrabajo;
    // End of variables declaration//GEN-END:variables

    public ControllerProcesarReclamo getControlador() {
        return controlador;
    }

    public javax.swing.JButton getBtn_siguiente() {
        return btn_siguiente;
    }

    public javax.swing.JButton getBtn_cancelar() {
        return btn_cancelar;
    }


}
