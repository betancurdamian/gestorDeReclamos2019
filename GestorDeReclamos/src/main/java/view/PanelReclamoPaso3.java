/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProcesarReclamo;
import javax.swing.table.DefaultTableModel;
import model.Empleado;
import model.TipoDeReclamo;

/**
 *
 * @author JUANA
 */
public class PanelReclamoPaso3 extends javax.swing.JPanel {

    private ControllerProcesarReclamo controlador;
    private TipoDeReclamo unTipoDeReclamo;
    private Empleado empleadoConFunciones;

    public PanelReclamoPaso3(ControllerProcesarReclamo controladorParametro) {
        this.controlador = controladorParametro;
        initComponents();
        btn_siguiente.setEnabled(false);

        mostrarTabla();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenido3 = new javax.swing.JPanel();
        lbl_nuevoReclamoDeCliente = new javax.swing.JLabel();
        lbl_pasos = new javax.swing.JLabel();
        barra = new javax.swing.JProgressBar();
        lbl_tipoDeReclamo = new javax.swing.JLabel();
        jtx_tipoDeReclamo = new javax.swing.JTextField();
        jScrollPane_TipoDeReclamo = new javax.swing.JScrollPane();
        jTable_listaTipoDeReclamo = new javax.swing.JTable();
        btn_siguiente = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1200, 750));
        setLayout(null);

        jPanelContenido3.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContenido3.setPreferredSize(new java.awt.Dimension(1200, 750));
        jPanelContenido3.setLayout(null);

        lbl_nuevoReclamoDeCliente.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbl_nuevoReclamoDeCliente.setText("                   Nuevo Reclamo De Cliente");
        lbl_nuevoReclamoDeCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_nuevoReclamoDeCliente.setOpaque(true);
        lbl_nuevoReclamoDeCliente.setPreferredSize(new java.awt.Dimension(1200, 100));
        jPanelContenido3.add(lbl_nuevoReclamoDeCliente);
        lbl_nuevoReclamoDeCliente.setBounds(0, 0, 1200, 100);

        lbl_pasos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_pasos.setText("Pasos de Proceso 3-6(Seleccionar Tipos De Reclamo)");
        jPanelContenido3.add(lbl_pasos);
        lbl_pasos.setBounds(380, 120, 440, 22);

        barra.setForeground(new java.awt.Color(0, 153, 0));
        barra.setMaximum(120);
        barra.setValue(60);
        barra.setPreferredSize(new java.awt.Dimension(120, 15));
        barra.setString("60%");
        jPanelContenido3.add(barra);
        barra.setBounds(10, 150, 1030, 20);
        barra.getAccessibleContext().setAccessibleName("");

        lbl_tipoDeReclamo.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        lbl_tipoDeReclamo.setText("Tipos De Reclamo");
        jPanelContenido3.add(lbl_tipoDeReclamo);
        lbl_tipoDeReclamo.setBounds(450, 200, 285, 44);
        jPanelContenido3.add(jtx_tipoDeReclamo);
        jtx_tipoDeReclamo.setBounds(60, 290, 390, 30);

        jTable_listaTipoDeReclamo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTable_listaTipoDeReclamo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "CÓDIGO", "MOTIVO", "SERVICIO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable_listaTipoDeReclamo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_listaTipoDeReclamoMouseClicked(evt);
            }
        });
        jScrollPane_TipoDeReclamo.setViewportView(jTable_listaTipoDeReclamo);

        jPanelContenido3.add(jScrollPane_TipoDeReclamo);
        jScrollPane_TipoDeReclamo.setBounds(60, 350, 931, 201);

        btn_siguiente.setBackground(new java.awt.Color(0, 204, 0));
        btn_siguiente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_siguiente.setForeground(new java.awt.Color(255, 255, 255));
        btn_siguiente.setText("SIGUIENTE");
        btn_siguiente.setPreferredSize(new java.awt.Dimension(240, 40));
        jPanelContenido3.add(btn_siguiente);
        btn_siguiente.setBounds(580, 620, 240, 40);

        btn_Cancelar.setBackground(new java.awt.Color(255, 0, 0));
        btn_Cancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Cancelar.setText("CANCELAR");
        btn_Cancelar.setPreferredSize(new java.awt.Dimension(240, 40));
        jPanelContenido3.add(btn_Cancelar);
        btn_Cancelar.setBounds(90, 620, 240, 40);

        add(jPanelContenido3);
        jPanelContenido3.setBounds(0, 0, 1200, 750);
    }// </editor-fold>//GEN-END:initComponents


    private void jTable_listaTipoDeReclamoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_listaTipoDeReclamoMouseClicked

        TipoDeReclamo retorno = null;
        int index = -1;
        int filaSeleccionada = jTable_listaTipoDeReclamo.getSelectedRow();
        // validamos que haya una fila seleccionada

        if (filaSeleccionada >= 0) {

            this.controlador.setUnTipoDeReclamo(this.controlador.buscarTipoDeReclamoId(Integer.parseInt(jTable_listaTipoDeReclamo.getValueAt(filaSeleccionada, 0).toString())));
        }
        if (this.controlador.getUnTipoDeReclamo() != null) {
            btn_siguiente.setEnabled(true);
        }
    }//GEN-LAST:event_jTable_listaTipoDeReclamoMouseClicked

    public void mostrarTabla() {

        DefaultTableModel model;

        String[] titulo = {"CODIGO", "MOTIVO", "SERVICIO"};

        model = new DefaultTableModel(null, titulo) {
            @Override
            //hace que las 4 columnas no sean editables.
            public boolean isCellEditable(int row, int column) {
                if (column == 3) {
                    return true;
                } else {

                    return false;
                }
            }
        };

        String[] datosTiposServicios = new String[3];

        for (TipoDeReclamo tipoDeServiciosRecorridos : controlador.ListarTipoDeReclamos(this.controlador.getUnServicioReclamo())) {
            datosTiposServicios[0] = tipoDeServiciosRecorridos.getId() + "";
            datosTiposServicios[1] = tipoDeServiciosRecorridos.getDescripcion();
            datosTiposServicios[2] = tipoDeServiciosRecorridos.getServicio().getDescripcion();

            model.addRow(datosTiposServicios);

        }
        jTable_listaTipoDeReclamo.setModel(model);

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_siguiente;
    private javax.swing.JPanel jPanelContenido3;
    private javax.swing.JScrollPane jScrollPane_TipoDeReclamo;
    private javax.swing.JTable jTable_listaTipoDeReclamo;
    private javax.swing.JTextField jtx_tipoDeReclamo;
    private javax.swing.JLabel lbl_nuevoReclamoDeCliente;
    private javax.swing.JLabel lbl_pasos;
    private javax.swing.JLabel lbl_tipoDeReclamo;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getBtn_Cancelar() {
        return btn_Cancelar;
    }

    public javax.swing.JButton getBtn_siguiente() {
        return btn_siguiente;
    }

    public ControllerProcesarReclamo getControlador() {
        return controlador;
    }

}
