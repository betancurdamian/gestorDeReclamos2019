/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProcesarReclamo;
import model.Cliente;

public class PanelReclamoPaso1 extends javax.swing.JPanel {

    private ControllerProcesarReclamo controlador;
    private Cliente clienteReclamo;

    public PanelReclamoPaso1(ControllerProcesarReclamo controladorParametro) {
        this.controlador = controladorParametro;
        initComponents();
        btn_siguiente.setEnabled(false);

        mostrarTabla("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenido1 = new javax.swing.JPanel();
        lbl_nuevoReclamoDeCliente = new javax.swing.JLabel();
        barra = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jtx_buscarCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_listaDeCliente = new javax.swing.JTable();
        btn_siguiente = new javax.swing.JButton();
        btn_cancelar = new javax.swing.JButton();
        lbl_dni = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(1200, 750));
        setLayout(null);

        jPanelContenido1.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContenido1.setPreferredSize(new java.awt.Dimension(1200, 750));
        jPanelContenido1.setLayout(null);

        lbl_nuevoReclamoDeCliente.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbl_nuevoReclamoDeCliente.setText("                   Nuevo Reclamo De Cliente");
        lbl_nuevoReclamoDeCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_nuevoReclamoDeCliente.setOpaque(true);
        lbl_nuevoReclamoDeCliente.setPreferredSize(new java.awt.Dimension(1000, 100));
        jPanelContenido1.add(lbl_nuevoReclamoDeCliente);
        lbl_nuevoReclamoDeCliente.setBounds(0, 0, 1200, 100);

        barra.setForeground(new java.awt.Color(0, 153, 0));
        barra.setMaximum(120);
        barra.setValue(20);
        barra.setPreferredSize(new java.awt.Dimension(120, 15));
        barra.setString("20%");
        jPanelContenido1.add(barra);
        barra.setBounds(10, 150, 1030, 20);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Pasos de Proceso 1-6(Seleccionar Cliente)");
        jPanelContenido1.add(jLabel1);
        jLabel1.setBounds(380, 120, 370, 22);

        jtx_buscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtx_buscarClienteKeyReleased(evt);
            }
        });
        jPanelContenido1.add(jtx_buscarCliente);
        jtx_buscarCliente.setBounds(100, 290, 350, 30);

        jTable_listaDeCliente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable_listaDeCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "DNI", "Apellido", "Nombre", "Nro Cliente"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
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

        lbl_dni.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        lbl_dni.setText("DNI:");
        jPanelContenido1.add(lbl_dni);
        lbl_dni.setBounds(50, 290, 70, 30);

        add(jPanelContenido1);
        jPanelContenido1.setBounds(0, 0, 1200, 750);
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_listaDeClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_listaDeClienteMouseClicked
        //una vez que se hace click en un cliente, se hace visible el boton.

        this.btn_siguiente.setEnabled(true);
        int filaseleccionada = jTable_listaDeCliente.getSelectedRow();
        String dni12 = (String) jTable_listaDeCliente.getValueAt(filaseleccionada, 0);
        String apellido12 = (String) jTable_listaDeCliente.getValueAt(filaseleccionada, 1);
        String nombre12 = (String) jTable_listaDeCliente.getValueAt(filaseleccionada, 2);
        String nroCliente12 = (String) jTable_listaDeCliente.getValueAt(filaseleccionada, 3);

        clienteReclamo = new Cliente(dni12, apellido12, nombre12, nroCliente12);

        this.controlador.setUnClienteReclamo(this.controlador.encontrarCliente(clienteReclamo));


    }//GEN-LAST:event_jTable_listaDeClienteMouseClicked

    private void jtx_buscarClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtx_buscarClienteKeyReleased
        mostrarTabla(jtx_buscarCliente.getText());
    }//GEN-LAST:event_jtx_buscarClienteKeyReleased

    public void mostrarTabla(String dni) {

        controlador.ListarClientes(jTable_listaDeCliente, dni);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra;
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_siguiente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelContenido1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_listaDeCliente;
    private javax.swing.JTextField jtx_buscarCliente;
    private javax.swing.JLabel lbl_dni;
    private javax.swing.JLabel lbl_nuevoReclamoDeCliente;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getBtn_siguiente() {

        return btn_siguiente;
    }

    public javax.swing.JButton getBtn_cancelar() {
        return btn_cancelar;
    }

    public Cliente getClienteReclamo() {
        return clienteReclamo;
    }

    public void setClienteReclamo(Cliente clienteReclamo) {
        this.clienteReclamo = clienteReclamo;
    }

    public ControllerProcesarReclamo getControlador() {
        return controlador;
    }

}
