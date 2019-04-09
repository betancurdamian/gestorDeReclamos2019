/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProcesarReclamo;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import model.Reclamo;

public class PanelBuscarReclamoCliente extends javax.swing.JPanel {

    private ControllerProcesarReclamo controlador;

    public PanelBuscarReclamoCliente(ControllerProcesarReclamo controladorParametro) {
        this.controlador = controladorParametro;
        initComponents();
        btn_ImagenBuscar.setBounds(450, 290, 50, 30);
        ImageIcon carpetaModificar = new ImageIcon(getClass().getResource("/image/buscar.jpg"));
        ImageIcon icono = new ImageIcon(carpetaModificar.getImage().getScaledInstance(btn_ImagenBuscar.getWidth(), btn_ImagenBuscar.getHeight(), Image.SCALE_SMOOTH));
        btn_ImagenBuscar.setIcon(icono);
//        mostrarTabla("");
    }

    public void mostrarTabla(String dni) {
        DefaultTableModel model;
        //nombre de las columnas del modelo
        String[] titulo = {"DNI", "NOMBRE", "APELLIDO", "ESTADO RECLAMO"};

        model = new DefaultTableModel(null, titulo) {
            @Override
            //hace que las 4 columnas no sean editables.
            public boolean isCellEditable(int row, int column) {
                if (column == 4) {
                    return true;
                } else {

                    return false;
                }
            }
        };
//        List<Reclamo> clienteBd = this.controlador.ListaDeReclamos(dni);
       
        String[] datosClientes = new String[4];
        
        for (Reclamo clienteRecorrrido : controlador.ListaDeReclamos(this.controlador.getUnClienteReclamo().getDni())) {
            
            datosClientes[0] = clienteRecorrrido.getUnCliente().getDni();
            datosClientes[1] = clienteRecorrrido.getUnCliente().getNombre();
            datosClientes[2] = clienteRecorrrido.getUnCliente().getApellido();
            datosClientes[3] = clienteRecorrrido.getUnEstadoReclamo().getDescripcion();
            model.addRow(datosClientes);

        }
        jTable_listaDeCliente.setModel(model);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenidoBuscarReclamo = new javax.swing.JPanel();
        lbl_nuevoReclamoDeCliente = new javax.swing.JLabel();
        jtx_buscarCliente = new javax.swing.JTextField();
        btn_ImagenBuscar = new javax.swing.JButton();
        jScrollPane_BuscarReclamo = new javax.swing.JScrollPane();
        jTable_listaDeCliente = new javax.swing.JTable();
        btn_verReclamo = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1200, 750));
        setLayout(null);

        jPanelContenidoBuscarReclamo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContenidoBuscarReclamo.setPreferredSize(new java.awt.Dimension(1200, 750));
        jPanelContenidoBuscarReclamo.setLayout(null);

        lbl_nuevoReclamoDeCliente.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbl_nuevoReclamoDeCliente.setText("                   Buscar Reclamo De Cliente");
        lbl_nuevoReclamoDeCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_nuevoReclamoDeCliente.setOpaque(true);
        lbl_nuevoReclamoDeCliente.setPreferredSize(new java.awt.Dimension(1000, 100));
        jPanelContenidoBuscarReclamo.add(lbl_nuevoReclamoDeCliente);
        lbl_nuevoReclamoDeCliente.setBounds(0, 0, 1200, 100);

        jtx_buscarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtx_buscarClienteKeyReleased(evt);
            }
        });
        jPanelContenidoBuscarReclamo.add(jtx_buscarCliente);
        jtx_buscarCliente.setBounds(40, 290, 410, 30);

        btn_ImagenBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/buscar.jpg"))); // NOI18N
        jPanelContenidoBuscarReclamo.add(btn_ImagenBuscar);
        btn_ImagenBuscar.setBounds(450, 290, 50, 30);

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
                "DNI", "NOMBRE", "APELLIDO", "ESTADO RECLAMO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane_BuscarReclamo.setViewportView(jTable_listaDeCliente);

        jPanelContenidoBuscarReclamo.add(jScrollPane_BuscarReclamo);
        jScrollPane_BuscarReclamo.setBounds(30, 360, 860, 200);

        btn_verReclamo.setBackground(new java.awt.Color(0, 204, 0));
        btn_verReclamo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_verReclamo.setForeground(new java.awt.Color(255, 255, 255));
        btn_verReclamo.setText("VER RECLAMO");
        jPanelContenidoBuscarReclamo.add(btn_verReclamo);
        btn_verReclamo.setBounds(580, 620, 240, 40);

        add(jPanelContenidoBuscarReclamo);
        jPanelContenidoBuscarReclamo.setBounds(0, 0, 1200, 750);
        jPanelContenidoBuscarReclamo.getAccessibleContext().setAccessibleName("");
    }// </editor-fold>//GEN-END:initComponents

    private void jTable_listaDeClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_listaDeClienteMouseClicked
        int filaseleccionada = jTable_listaDeCliente.getSelectedRow();
        String dni = (String) jTable_listaDeCliente.getValueAt(filaseleccionada, 0);
        String nombre = (String) jTable_listaDeCliente.getValueAt(filaseleccionada, 1);
        String apellido = (String) jTable_listaDeCliente.getValueAt(filaseleccionada, 2);
        String estadoReclamo = (String) jTable_listaDeCliente.getValueAt(filaseleccionada, 3);

    }//GEN-LAST:event_jTable_listaDeClienteMouseClicked

    private void jtx_buscarClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtx_buscarClienteKeyReleased
//        mostrarTabla(jtx_buscarCliente.getText());
    }//GEN-LAST:event_jtx_buscarClienteKeyReleased

//    public void mostrarTabla(String dni) {
//
//        controlador.ListarClientes(jTable_listaDeCliente, dni);
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ImagenBuscar;
    private javax.swing.JButton btn_verReclamo;
    private javax.swing.JPanel jPanelContenidoBuscarReclamo;
    private javax.swing.JScrollPane jScrollPane_BuscarReclamo;
    private javax.swing.JTable jTable_listaDeCliente;
    private javax.swing.JTextField jtx_buscarCliente;
    private javax.swing.JLabel lbl_nuevoReclamoDeCliente;
    // End of variables declaration//GEN-END:variables

    public JButton getBtn_verReclamo() {
        return btn_verReclamo;
    }

    public ControllerProcesarReclamo getControlador() {
        return controlador;
    }

}
