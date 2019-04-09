/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProcesarReclamo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import model.Empleado;
import model.LineaDeReclamo;
import model.Reclamo;
import model.UsuarioLogueado;

public class PanelReclamoPaso6 extends javax.swing.JPanel {

    private final ControllerProcesarReclamo controlador;
    private final Reclamo unReclamoAuxiliar;
    private final LineaDeReclamo unaLineaDeReclamoAuxiliar;
    private Empleado unEmpleado;
    private final SimpleDateFormat formatoFecha;
    private final SimpleDateFormat formatoHora;

    public PanelReclamoPaso6(ControllerProcesarReclamo controladorParametro) {

        this.controlador = controladorParametro;

        initComponents();
        this.controlador.setUnEstadoReclamo(this.controlador.encontrarEstadoDeReclamo("Alta"));
        this.controlador.setUnEstadoLineaDeReclamo(this.controlador.encontrarEstadoLineaDeReclamo("Empleado experto asignado"));

        this.controlador.cargarEmpleadoExperto();

        this.unReclamoAuxiliar = new Reclamo(this.controlador.getUnaDescripcionInicialReclamo(), this.controlador.getUnClienteReclamo(), UsuarioLogueado.getInstance().getUnUsuario().getUnEmpleado(), this.controlador.getUnEmpleadoExperto(), this.controlador.getUnTipoDeUrgenciaReclamo(), this.controlador.getUnTipoDeReclamo(), this.controlador.getUnEstadoReclamo(), this.controlador.getUnServicioReclamo());
        this.controlador.asignarEmpleadoExpertoReclamo(unReclamoAuxiliar);

        this.unaLineaDeReclamoAuxiliar = new LineaDeReclamo("Empleado experto asignado", this.controlador.getUnEstadoLineaDeReclamo(), this.unReclamoAuxiliar.getUnEmpleadoExperto());

//        this.unReclamoAuxiliar.getLineasDeReclamo().add(unaLineaDeReclamoAuxiliar);
        this.unaLineaDeReclamoAuxiliar.setReclamo(unReclamoAuxiliar);
        this.controlador.setUnReclamo(unReclamoAuxiliar);
        this.getBtn_FinalizarReclamo().setEnabled(false);
        this.formatoHora = new SimpleDateFormat("HH:mm");
        this.formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        mostrarDatos();
        if (this.controlador.getUnReclamo() != null) {
            this.getBtn_FinalizarReclamo().setEnabled(true);
        }

    }

    public final void mostrarDatos() {
//-------------------------------------DATOS DEL RECLAMO----------------------------------------------------------------
        this.jFormattedTextField_FECHA.setText(fechaActual());
        this.jFormattedTextField_Hora.setText(horaActual());
        this.lbl_ESTADO.setText(this.controlador.getUnEstadoReclamo().getDescripcion());
        this.lbl_TIPODERECLAMO.setText(this.controlador.getUnTipoDeReclamo().getDescripcion());
        this.lbl_DESCRIPCION.setText(this.controlador.getUnaDescripcionInicialReclamo());
        this.lbl_SERVICIO.setText(this.controlador.getUnServicioReclamo().getDescripcion());
        this.lbl_TIPODEURGENCIA.setText(this.controlador.getUnTipoDeUrgenciaReclamo().getDescripcion());

//------------------------------------DATOS DEL CLIENTE---------------------------------------------------------------------                
        this.lbl_NUMERODECLIENTE.setText(this.controlador.getUnReclamo().getUnCliente().getNroCliente());
        this.lbl_APELLIDO.setText(this.controlador.getUnReclamo().getUnCliente().getApellido());
        this.lbl_NOMBREDECLIENTE.setText(this.controlador.getUnReclamo().getUnCliente().getNombre());
        this.lbl_DNIDECLIENTE.setText(this.controlador.getUnReclamo().getUnCliente().getDni());

//--------------------------------------DATOS DEL EMPLEADO EXPERTO ASIGNADO--------------------------------------
        this.lbl_APELLIDOEMPLEADOEXPERTO.setText(this.controlador.getUnReclamo().getUnEmpleadoExperto().getApellido());
        this.lbl_NOMBREEMPLEADOEXPERTO.setText(this.controlador.getUnReclamo().getUnEmpleadoExperto().getNombre());
        this.lbl_DNIEMPLEADOEXPERTO.setText(this.controlador.getUnReclamo().getUnEmpleadoExperto().getDni());
        this.lbl_TIPOEMPLEADOEXPERTO.setText(this.controlador.getUnReclamo().getUnEmpleadoExperto().getUnTipoEmpleado().getDescripcion());
//------------------------------------DATOS DE TAREAS ASIGNADAS--------------------------------------------------------
        mostrarTabla();
    }

    public void mostrarTabla() {
        DefaultTableModel model;

        String[] titulo = {"NUMERO", "MOTIVO", "EMPLEADO EXPERTO"};

        model = new DefaultTableModel(null, titulo) {
            @Override
            //hace que las 3 columnas no sean editables.
            public boolean isCellEditable(int row, int column) {
                if (column == 3) {
                    return true;
                } else {

                    return false;
                }
            }
        };

        String[] datos = new String[3];

        for (LineaDeReclamo lineasDeReclamos : this.controlador.getUnReclamo().getLineasDeReclamo()) {
            datos[0] = lineasDeReclamos.getId() + "";
            datos[1] = lineasDeReclamos.getMotivo();
            datos[2] = lineasDeReclamos.getUnEmpleadoExperto().getApellido();

            model.addRow(datos);

        }
        jTable_listaLineaDeReclamo.setModel(model);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenido6 = new javax.swing.JPanel();
        lbl_nuevoReclamoDeCliente = new javax.swing.JLabel();
        lbl_pasos = new javax.swing.JLabel();
        barra = new javax.swing.JProgressBar();
        lbl_estado = new javax.swing.JLabel();
        lbl_reclamo = new javax.swing.JLabel();
        lbl_fecha = new javax.swing.JLabel();
        jFormattedTextField_FECHA = new javax.swing.JFormattedTextField();
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
        btn_Cancelar = new javax.swing.JButton();
        jScrollPaneAsignacionEmpleadoExperto = new javax.swing.JScrollPane();
        jTable_listaLineaDeReclamo = new javax.swing.JTable();
        jFormattedTextField_Hora = new javax.swing.JFormattedTextField();
        lbl_ESTADO = new javax.swing.JLabel();
        lbl_tipoDeUrgencia = new javax.swing.JLabel();
        lbl_TIPODEURGENCIA = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1200, 750));
        setLayout(null);

        jPanelContenido6.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContenido6.setPreferredSize(new java.awt.Dimension(1200, 750));
        jPanelContenido6.setLayout(null);

        lbl_nuevoReclamoDeCliente.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbl_nuevoReclamoDeCliente.setText("                   Nuevo Reclamo De Cliente");
        lbl_nuevoReclamoDeCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_nuevoReclamoDeCliente.setOpaque(true);
        lbl_nuevoReclamoDeCliente.setPreferredSize(new java.awt.Dimension(1000, 100));
        jPanelContenido6.add(lbl_nuevoReclamoDeCliente);
        lbl_nuevoReclamoDeCliente.setBounds(0, 0, 1200, 100);

        lbl_pasos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_pasos.setText("Pasos de Proceso 6-6(Datos de Reclamo)");
        jPanelContenido6.add(lbl_pasos);
        lbl_pasos.setBounds(380, 120, 430, 22);

        barra.setForeground(new java.awt.Color(0, 153, 0));
        barra.setMaximum(120);
        barra.setValue(120);
        barra.setPreferredSize(new java.awt.Dimension(120, 15));
        barra.setString("120%");
        jPanelContenido6.add(barra);
        barra.setBounds(10, 150, 1030, 20);

        lbl_estado.setText("ESTADO:");
        jPanelContenido6.add(lbl_estado);
        lbl_estado.setBounds(70, 220, 70, 24);

        lbl_reclamo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_reclamo.setText("RECLAMO");
        jPanelContenido6.add(lbl_reclamo);
        lbl_reclamo.setBounds(430, 180, 70, 17);

        lbl_fecha.setText("FECHA:");
        jPanelContenido6.add(lbl_fecha);
        lbl_fecha.setBounds(500, 220, 48, 25);

        jFormattedTextField_FECHA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jPanelContenido6.add(jFormattedTextField_FECHA);
        jFormattedTextField_FECHA.setBounds(580, 220, 100, 20);

        lbl_hora.setText("HORA:");
        jPanelContenido6.add(lbl_hora);
        lbl_hora.setBounds(500, 260, 40, 14);

        lbl_TipoDeReclamo.setText("TIPO DE RECLAMO:");
        jPanelContenido6.add(lbl_TipoDeReclamo);
        lbl_TipoDeReclamo.setBounds(70, 260, 110, 14);

        lbl_servicio.setText("SERVICIO:");
        jPanelContenido6.add(lbl_servicio);
        lbl_servicio.setBounds(500, 290, 60, 14);

        lbl_SERVICIO.setOpaque(true);
        lbl_SERVICIO.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido6.add(lbl_SERVICIO);
        lbl_SERVICIO.setBounds(580, 290, 320, 20);

        lbl_TIPODERECLAMO.setOpaque(true);
        lbl_TIPODERECLAMO.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido6.add(lbl_TIPODERECLAMO);
        lbl_TIPODERECLAMO.setBounds(190, 250, 280, 22);

        jLabel1.setText("DESCRIPCIÓN: ");
        jPanelContenido6.add(jLabel1);
        jLabel1.setBounds(70, 320, 90, 14);

        lbl_DESCRIPCION.setOpaque(true);
        lbl_DESCRIPCION.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido6.add(lbl_DESCRIPCION);
        lbl_DESCRIPCION.setBounds(188, 318, 720, 30);

        lbl_cliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_cliente.setText("CLIENTE");
        jPanelContenido6.add(lbl_cliente);
        lbl_cliente.setBounds(440, 360, 63, 17);

        lbl_numeroCiente.setText("NUMERO:");
        jPanelContenido6.add(lbl_numeroCiente);
        lbl_numeroCiente.setBounds(70, 380, 70, 14);

        lbl_NUMERODECLIENTE.setOpaque(true);
        lbl_NUMERODECLIENTE.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido6.add(lbl_NUMERODECLIENTE);
        lbl_NUMERODECLIENTE.setBounds(190, 380, 280, 20);

        lbl_nombre.setText("NOMBRE:");
        jPanelContenido6.add(lbl_nombre);
        lbl_nombre.setBounds(500, 380, 70, 14);

        lbl_NOMBREDECLIENTE.setOpaque(true);
        lbl_NOMBREDECLIENTE.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido6.add(lbl_NOMBREDECLIENTE);
        lbl_NOMBREDECLIENTE.setBounds(580, 380, 330, 18);

        lbl_apellido.setText("APELLIDO:");
        jPanelContenido6.add(lbl_apellido);
        lbl_apellido.setBounds(70, 410, 70, 14);

        lbl_APELLIDO.setOpaque(true);
        lbl_APELLIDO.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido6.add(lbl_APELLIDO);
        lbl_APELLIDO.setBounds(190, 410, 280, 20);

        lbl_dni.setText("DNI:");
        jPanelContenido6.add(lbl_dni);
        lbl_dni.setBounds(500, 410, 50, 14);

        lbl_DNIDECLIENTE.setOpaque(true);
        lbl_DNIDECLIENTE.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido6.add(lbl_DNIDECLIENTE);
        lbl_DNIDECLIENTE.setBounds(580, 410, 330, 20);

        lbl_empleadoExpertoAsignado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_empleadoExpertoAsignado.setText("EMPLEADO EXPERTO ASIGNADO");
        jPanelContenido6.add(lbl_empleadoExpertoAsignado);
        lbl_empleadoExpertoAsignado.setBounds(340, 450, 231, 17);

        lbl_nombreEmpleadoExperto.setText("NOMBRE:");
        jPanelContenido6.add(lbl_nombreEmpleadoExperto);
        lbl_nombreEmpleadoExperto.setBounds(70, 480, 70, 14);

        lbl_NOMBREEMPLEADOEXPERTO.setOpaque(true);
        lbl_NOMBREEMPLEADOEXPERTO.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido6.add(lbl_NOMBREEMPLEADOEXPERTO);
        lbl_NOMBREEMPLEADOEXPERTO.setBounds(190, 480, 280, 20);

        lbl_apellidoEmoleadoExperto.setText("APELLIDO:");
        jPanelContenido6.add(lbl_apellidoEmoleadoExperto);
        lbl_apellidoEmoleadoExperto.setBounds(500, 480, 70, 20);

        lbl_APELLIDOEMPLEADOEXPERTO.setOpaque(true);
        lbl_APELLIDOEMPLEADOEXPERTO.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido6.add(lbl_APELLIDOEMPLEADOEXPERTO);
        lbl_APELLIDOEMPLEADOEXPERTO.setBounds(580, 480, 330, 20);

        lbl_dniEmpleadoExperto.setText("DNI:");
        jPanelContenido6.add(lbl_dniEmpleadoExperto);
        lbl_dniEmpleadoExperto.setBounds(70, 510, 40, 14);

        lbl_DNIEMPLEADOEXPERTO.setOpaque(true);
        lbl_DNIEMPLEADOEXPERTO.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido6.add(lbl_DNIEMPLEADOEXPERTO);
        lbl_DNIEMPLEADOEXPERTO.setBounds(190, 510, 280, 20);

        lbl_tipoempleadoexperto.setText("TIPO:");
        jPanelContenido6.add(lbl_tipoempleadoexperto);
        lbl_tipoempleadoexperto.setBounds(500, 510, 40, 14);

        lbl_TIPOEMPLEADOEXPERTO.setOpaque(true);
        lbl_TIPOEMPLEADOEXPERTO.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido6.add(lbl_TIPOEMPLEADOEXPERTO);
        lbl_TIPOEMPLEADOEXPERTO.setBounds(580, 510, 330, 20);

        lbl_tareasRealizadas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_tareasRealizadas.setText("TAREAS ASIGNADAS");
        jPanelContenido6.add(lbl_tareasRealizadas);
        lbl_tareasRealizadas.setBounds(410, 550, 147, 17);

        btn_FinalizarReclamo.setBackground(new java.awt.Color(0, 204, 0));
        btn_FinalizarReclamo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_FinalizarReclamo.setForeground(new java.awt.Color(255, 255, 255));
        btn_FinalizarReclamo.setText("FINALIZAR RECLAMO");
        btn_FinalizarReclamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FinalizarReclamoActionPerformed(evt);
            }
        });
        jPanelContenido6.add(btn_FinalizarReclamo);
        btn_FinalizarReclamo.setBounds(590, 680, 175, 35);

        btn_Cancelar.setBackground(new java.awt.Color(255, 0, 0));
        btn_Cancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Cancelar.setText("CANCELAR");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });
        jPanelContenido6.add(btn_Cancelar);
        btn_Cancelar.setBounds(150, 680, 175, 35);

        jTable_listaLineaDeReclamo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
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
        jScrollPaneAsignacionEmpleadoExperto.setViewportView(jTable_listaLineaDeReclamo);

        jPanelContenido6.add(jScrollPaneAsignacionEmpleadoExperto);
        jScrollPaneAsignacionEmpleadoExperto.setBounds(42, 580, 930, 50);

        jFormattedTextField_Hora.setEditable(false);
        jFormattedTextField_Hora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));
        jFormattedTextField_Hora.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jFormattedTextField_Hora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanelContenido6.add(jFormattedTextField_Hora);
        jFormattedTextField_Hora.setBounds(580, 250, 100, 23);

        lbl_ESTADO.setOpaque(true);
        jPanelContenido6.add(lbl_ESTADO);
        lbl_ESTADO.setBounds(190, 220, 280, 20);

        lbl_tipoDeUrgencia.setText("TIPO DE URGENCIA: ");
        jPanelContenido6.add(lbl_tipoDeUrgencia);
        lbl_tipoDeUrgencia.setBounds(70, 290, 120, 14);

        lbl_TIPODEURGENCIA.setOpaque(true);
        jPanelContenido6.add(lbl_TIPODEURGENCIA);
        lbl_TIPODEURGENCIA.setBounds(190, 280, 280, 20);

        add(jPanelContenido6);
        jPanelContenido6.setBounds(0, 0, 1200, 750);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed

    }//GEN-LAST:event_btn_CancelarActionPerformed

    private void btn_FinalizarReclamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FinalizarReclamoActionPerformed
        this.controlador.guardarReclamo(this.controlador.getUnReclamo());

    }//GEN-LAST:event_btn_FinalizarReclamoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar barra;
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_FinalizarReclamo;
    private javax.swing.JFormattedTextField jFormattedTextField_FECHA;
    private javax.swing.JFormattedTextField jFormattedTextField_Hora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelContenido6;
    private javax.swing.JScrollPane jScrollPaneAsignacionEmpleadoExperto;
    private javax.swing.JTable jTable_listaLineaDeReclamo;
    private javax.swing.JLabel lbl_APELLIDO;
    private javax.swing.JLabel lbl_APELLIDOEMPLEADOEXPERTO;
    private javax.swing.JLabel lbl_DESCRIPCION;
    private javax.swing.JLabel lbl_DNIDECLIENTE;
    private javax.swing.JLabel lbl_DNIEMPLEADOEXPERTO;
    private javax.swing.JLabel lbl_ESTADO;
    private javax.swing.JLabel lbl_NOMBREDECLIENTE;
    private javax.swing.JLabel lbl_NOMBREEMPLEADOEXPERTO;
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
    private javax.swing.JLabel lbl_numeroCiente;
    private javax.swing.JLabel lbl_pasos;
    private javax.swing.JLabel lbl_reclamo;
    private javax.swing.JLabel lbl_servicio;
    private javax.swing.JLabel lbl_tareasRealizadas;
    private javax.swing.JLabel lbl_tipoDeUrgencia;
    private javax.swing.JLabel lbl_tipoempleadoexperto;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JButton getBtn_Cancelar() {
        return btn_Cancelar;
    }

    public javax.swing.JButton getBtn_FinalizarReclamo() {
        return btn_FinalizarReclamo;
    }

    public ControllerProcesarReclamo getControlador() {
        return controlador;
    }

    public String fechaActual() {

        Date fecha = Calendar.getInstance().getTime();

        return this.formatoFecha.format(fecha);
    }

    public String horaActual() {

        Date hora = Calendar.getInstance().getTime();

        return this.formatoHora.format(hora);
    }

}
