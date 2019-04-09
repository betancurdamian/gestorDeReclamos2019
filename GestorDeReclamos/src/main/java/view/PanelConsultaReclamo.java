/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProcesarReclamo;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author JUANA
 */
public class PanelConsultaReclamo extends javax.swing.JPanel {
private ControllerProcesarReclamo controlador;
    public PanelConsultaReclamo(ControllerProcesarReclamo controladorParametro) {
        this.controlador = controladorParametro;
        initComponents();
       
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenido2 = new javax.swing.JPanel();
        lbl_nuevoReclamoDeCliente = new javax.swing.JLabel();
        lbl_estado = new javax.swing.JLabel();
        lbl_ESTADO = new javax.swing.JLabel();
        lbl_reclamo = new javax.swing.JLabel();
        lbl_fecha = new javax.swing.JLabel();
        jFormattedTextField_FECHA = new javax.swing.JFormattedTextField();
        lbl_numero = new javax.swing.JLabel();
        lbl_NUMERO = new javax.swing.JLabel();
        lbl_hora = new javax.swing.JLabel();
        lbl_TipoDeReclamo = new javax.swing.JLabel();
        lbl_servicio = new javax.swing.JLabel();
        lbl_SERVICIO = new javax.swing.JLabel();
        lbl_TIPODERECLAMO = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbl_DESCRIPCION = new javax.swing.JLabel();
        lbl_cliente = new javax.swing.JLabel();
        lbl_numeroCiente = new javax.swing.JLabel();
        lbl_NUMERODECLIENTE = new javax.swing.JLabel();
        lbl_nombre = new javax.swing.JLabel();
        lbl_NOMBREDECLIENTE = new javax.swing.JLabel();
        lbl_apellido = new javax.swing.JLabel();
        lbl_APELLIDO = new javax.swing.JLabel();
        lbl_dni = new javax.swing.JLabel();
        lbl_DNIDECLIENTE = new javax.swing.JLabel();
        lbl_empleadoExpertoAsignado = new javax.swing.JLabel();
        lbl_nombreEmpleadoExperto = new javax.swing.JLabel();
        lbl_NOMBREEMPLEADOEXPERTO = new javax.swing.JLabel();
        lbl_apellidoEmoleadoExperto = new javax.swing.JLabel();
        lbl_APELLIDOEMPLEADOEXPERTO = new javax.swing.JLabel();
        lbl_dniEmpleadoExperto = new javax.swing.JLabel();
        lbl_DNIEMPLEADOEXPERTO = new javax.swing.JLabel();
        lbl_tipoempleadoexperto = new javax.swing.JLabel();
        lbl_TIPOEMPLEADOEXPERTO = new javax.swing.JLabel();
        lbl_tareasRealizadas = new javax.swing.JLabel();
        btn_FinalizarReclamo = new javax.swing.JButton();
        btn_anterior = new javax.swing.JButton();
        jScrollPaneAsignacionEmpleadoExperto = new javax.swing.JScrollPane();
        jTableAsignacionEmpleadoExperto = new javax.swing.JTable();
        jFormattedTextField_Hora = new javax.swing.JFormattedTextField();
        lbl_tipoUrgencia = new javax.swing.JLabel();
        lbl_TIPODEURGENCIA = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1200, 750));
        setLayout(null);

        jPanelContenido2.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContenido2.setPreferredSize(new java.awt.Dimension(1200, 750));
        jPanelContenido2.setLayout(null);

        lbl_nuevoReclamoDeCliente.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbl_nuevoReclamoDeCliente.setText("                          Reclamo De Cliente");
        lbl_nuevoReclamoDeCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_nuevoReclamoDeCliente.setOpaque(true);
        lbl_nuevoReclamoDeCliente.setPreferredSize(new java.awt.Dimension(1000, 100));
        jPanelContenido2.add(lbl_nuevoReclamoDeCliente);
        lbl_nuevoReclamoDeCliente.setBounds(0, 0, 1200, 100);

        lbl_estado.setText("ESTADO:");
        jPanelContenido2.add(lbl_estado);
        lbl_estado.setBounds(60, 220, 70, 24);

        lbl_ESTADO.setOpaque(true);
        lbl_ESTADO.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido2.add(lbl_ESTADO);
        lbl_ESTADO.setBounds(170, 220, 160, 24);

        lbl_reclamo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_reclamo.setText("RECLAMO");
        jPanelContenido2.add(lbl_reclamo);
        lbl_reclamo.setBounds(410, 150, 160, 29);

        lbl_fecha.setText("FECHA:");
        jPanelContenido2.add(lbl_fecha);
        lbl_fecha.setBounds(500, 220, 48, 25);

        jFormattedTextField_FECHA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jPanelContenido2.add(jFormattedTextField_FECHA);
        jFormattedTextField_FECHA.setBounds(580, 220, 211, 20);

        lbl_numero.setText("NUMERO:");
        jPanelContenido2.add(lbl_numero);
        lbl_numero.setBounds(60, 260, 60, 14);

        lbl_NUMERO.setOpaque(true);
        lbl_NUMERO.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido2.add(lbl_NUMERO);
        lbl_NUMERO.setBounds(170, 250, 240, 22);

        lbl_hora.setText("HORA:");
        jPanelContenido2.add(lbl_hora);
        lbl_hora.setBounds(500, 260, 40, 14);

        lbl_TipoDeReclamo.setText("TIPO DE RECLAMO:");
        jPanelContenido2.add(lbl_TipoDeReclamo);
        lbl_TipoDeReclamo.setBounds(60, 290, 110, 14);

        lbl_servicio.setText("SERVICIO:");
        jPanelContenido2.add(lbl_servicio);
        lbl_servicio.setBounds(500, 290, 60, 14);

        lbl_SERVICIO.setOpaque(true);
        lbl_SERVICIO.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido2.add(lbl_SERVICIO);
        lbl_SERVICIO.setBounds(580, 280, 211, 20);

        lbl_TIPODERECLAMO.setOpaque(true);
        lbl_TIPODERECLAMO.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido2.add(lbl_TIPODERECLAMO);
        lbl_TIPODERECLAMO.setBounds(170, 280, 240, 22);

        jLabel1.setText("DESCRIPCIÓN: ");
        jPanelContenido2.add(jLabel1);
        jLabel1.setBounds(500, 330, 90, 14);

        lbl_DESCRIPCION.setOpaque(true);
        lbl_DESCRIPCION.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido2.add(lbl_DESCRIPCION);
        lbl_DESCRIPCION.setBounds(580, 320, 280, 21);

        lbl_cliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_cliente.setText("CLIENTE");
        jPanelContenido2.add(lbl_cliente);
        lbl_cliente.setBounds(440, 354, 63, 17);

        lbl_numeroCiente.setText("NUMERO:");
        jPanelContenido2.add(lbl_numeroCiente);
        lbl_numeroCiente.setBounds(60, 380, 60, 14);

        lbl_NUMERODECLIENTE.setOpaque(true);
        lbl_NUMERODECLIENTE.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido2.add(lbl_NUMERODECLIENTE);
        lbl_NUMERODECLIENTE.setBounds(170, 380, 240, 20);

        lbl_nombre.setText("NOMBRE:");
        jPanelContenido2.add(lbl_nombre);
        lbl_nombre.setBounds(500, 380, 60, 14);

        lbl_NOMBREDECLIENTE.setOpaque(true);
        lbl_NOMBREDECLIENTE.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido2.add(lbl_NOMBREDECLIENTE);
        lbl_NOMBREDECLIENTE.setBounds(590, 370, 210, 18);

        lbl_apellido.setText("APELLIDO:");
        jPanelContenido2.add(lbl_apellido);
        lbl_apellido.setBounds(60, 410, 60, 14);

        lbl_APELLIDO.setOpaque(true);
        lbl_APELLIDO.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido2.add(lbl_APELLIDO);
        lbl_APELLIDO.setBounds(170, 400, 240, 20);

        lbl_dni.setText("DNI:");
        jPanelContenido2.add(lbl_dni);
        lbl_dni.setBounds(500, 410, 30, 14);

        lbl_DNIDECLIENTE.setOpaque(true);
        lbl_DNIDECLIENTE.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido2.add(lbl_DNIDECLIENTE);
        lbl_DNIDECLIENTE.setBounds(590, 400, 210, 20);

        lbl_empleadoExpertoAsignado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_empleadoExpertoAsignado.setText("EMPLEADO EXPERTO ASIGNADO");
        jPanelContenido2.add(lbl_empleadoExpertoAsignado);
        lbl_empleadoExpertoAsignado.setBounds(360, 448, 231, 17);

        lbl_nombreEmpleadoExperto.setText("NOMBRE:");
        jPanelContenido2.add(lbl_nombreEmpleadoExperto);
        lbl_nombreEmpleadoExperto.setBounds(60, 480, 70, 14);

        lbl_NOMBREEMPLEADOEXPERTO.setOpaque(true);
        lbl_NOMBREEMPLEADOEXPERTO.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido2.add(lbl_NOMBREEMPLEADOEXPERTO);
        lbl_NOMBREEMPLEADOEXPERTO.setBounds(170, 480, 240, 20);

        lbl_apellidoEmoleadoExperto.setText("APELLIDO:");
        jPanelContenido2.add(lbl_apellidoEmoleadoExperto);
        lbl_apellidoEmoleadoExperto.setBounds(500, 490, 60, 14);

        lbl_APELLIDOEMPLEADOEXPERTO.setOpaque(true);
        lbl_APELLIDOEMPLEADOEXPERTO.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido2.add(lbl_APELLIDOEMPLEADOEXPERTO);
        lbl_APELLIDOEMPLEADOEXPERTO.setBounds(590, 480, 213, 20);

        lbl_dniEmpleadoExperto.setText("DNI:");
        jPanelContenido2.add(lbl_dniEmpleadoExperto);
        lbl_dniEmpleadoExperto.setBounds(60, 510, 40, 14);

        lbl_DNIEMPLEADOEXPERTO.setOpaque(true);
        lbl_DNIEMPLEADOEXPERTO.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido2.add(lbl_DNIEMPLEADOEXPERTO);
        lbl_DNIEMPLEADOEXPERTO.setBounds(170, 510, 240, 20);

        lbl_tipoempleadoexperto.setText("TIPO:");
        jPanelContenido2.add(lbl_tipoempleadoexperto);
        lbl_tipoempleadoexperto.setBounds(500, 520, 40, 14);

        lbl_TIPOEMPLEADOEXPERTO.setOpaque(true);
        lbl_TIPOEMPLEADOEXPERTO.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido2.add(lbl_TIPOEMPLEADOEXPERTO);
        lbl_TIPOEMPLEADOEXPERTO.setBounds(590, 510, 213, 20);

        lbl_tareasRealizadas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_tareasRealizadas.setText("TAREAS REALIZADAS");
        jPanelContenido2.add(lbl_tareasRealizadas);
        lbl_tareasRealizadas.setBounds(404, 541, 153, 17);

        btn_FinalizarReclamo.setBackground(new java.awt.Color(0, 204, 0));
        btn_FinalizarReclamo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_FinalizarReclamo.setForeground(new java.awt.Color(255, 255, 255));
        btn_FinalizarReclamo.setText("FINALIZAR CONSULTA");
        jPanelContenido2.add(btn_FinalizarReclamo);
        btn_FinalizarReclamo.setBounds(590, 680, 175, 35);

        btn_anterior.setBackground(new java.awt.Color(0, 255, 0));
        btn_anterior.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_anterior.setForeground(new java.awt.Color(255, 255, 255));
        btn_anterior.setText("ANTERIOR");
        jPanelContenido2.add(btn_anterior);
        btn_anterior.setBounds(150, 680, 175, 35);

        jTableAsignacionEmpleadoExperto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "NUMERO", "MOTIVO", "EMPLEADO EXPERTO"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPaneAsignacionEmpleadoExperto.setViewportView(jTableAsignacionEmpleadoExperto);

        jPanelContenido2.add(jScrollPaneAsignacionEmpleadoExperto);
        jScrollPaneAsignacionEmpleadoExperto.setBounds(42, 580, 930, 50);

        jFormattedTextField_Hora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("HH:mm"))));
        jPanelContenido2.add(jFormattedTextField_Hora);
        jFormattedTextField_Hora.setBounds(580, 250, 130, 20);

        lbl_tipoUrgencia.setText("TIPO DE URGENCIA: ");
        jPanelContenido2.add(lbl_tipoUrgencia);
        lbl_tipoUrgencia.setBounds(60, 330, 110, 14);

        lbl_TIPODEURGENCIA.setOpaque(true);
        jPanelContenido2.add(lbl_TIPODEURGENCIA);
        lbl_TIPODEURGENCIA.setBounds(170, 320, 240, 20);

        add(jPanelContenido2);
        jPanelContenido2.setBounds(0, 0, 1200, 750);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_FinalizarReclamo;
    private javax.swing.JButton btn_anterior;
    private javax.swing.JFormattedTextField jFormattedTextField_FECHA;
    private javax.swing.JFormattedTextField jFormattedTextField_Hora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelContenido2;
    private javax.swing.JScrollPane jScrollPaneAsignacionEmpleadoExperto;
    private javax.swing.JTable jTableAsignacionEmpleadoExperto;
    private javax.swing.JLabel lbl_APELLIDO;
    private javax.swing.JLabel lbl_APELLIDOEMPLEADOEXPERTO;
    private javax.swing.JLabel lbl_DESCRIPCION;
    private javax.swing.JLabel lbl_DNIDECLIENTE;
    private javax.swing.JLabel lbl_DNIEMPLEADOEXPERTO;
    private javax.swing.JLabel lbl_ESTADO;
    private javax.swing.JLabel lbl_NOMBREDECLIENTE;
    private javax.swing.JLabel lbl_NOMBREEMPLEADOEXPERTO;
    private javax.swing.JLabel lbl_NUMERO;
    private javax.swing.JLabel lbl_NUMERODECLIENTE;
    private javax.swing.JLabel lbl_SERVICIO;
    private javax.swing.JLabel lbl_TIPODERECLAMO;
    private javax.swing.JLabel lbl_TIPODEURGENCIA;
    private javax.swing.JLabel lbl_TIPOEMPLEADOEXPERTO;
    private javax.swing.JLabel lbl_TipoDeReclamo;
    private javax.swing.JLabel lbl_apellido;
    private javax.swing.JLabel lbl_apellidoEmoleadoExperto;
    private javax.swing.JLabel lbl_cliente;
    private javax.swing.JLabel lbl_dni;
    private javax.swing.JLabel lbl_dniEmpleadoExperto;
    private javax.swing.JLabel lbl_empleadoExpertoAsignado;
    private javax.swing.JLabel lbl_estado;
    private javax.swing.JLabel lbl_fecha;
    private javax.swing.JLabel lbl_hora;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_nombreEmpleadoExperto;
    private javax.swing.JLabel lbl_nuevoReclamoDeCliente;
    private javax.swing.JLabel lbl_numero;
    private javax.swing.JLabel lbl_numeroCiente;
    private javax.swing.JLabel lbl_reclamo;
    private javax.swing.JLabel lbl_servicio;
    private javax.swing.JLabel lbl_tareasRealizadas;
    private javax.swing.JLabel lbl_tipoUrgencia;
    private javax.swing.JLabel lbl_tipoempleadoexperto;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getBtn_FinalizarReclamo() {
        return btn_FinalizarReclamo;
    }

    public javax.swing.JButton getBtn_anterior() {
        return btn_anterior;
    }

    public ControllerProcesarReclamo getControlador() {
        return controlador;
    }
    public static String fechaActual(){
    Date fecha = new Date();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
    return formatoFecha.format(fecha);
    }
    
    public static String horaActual(){
    Date hora = new Date();
    SimpleDateFormat formatoFecha = new SimpleDateFormat("HH:mm");
    return formatoFecha.format(hora);
    }

}
