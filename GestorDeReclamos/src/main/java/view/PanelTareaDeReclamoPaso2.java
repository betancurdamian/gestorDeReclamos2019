/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ControllerProcesarReclamo;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.Reclamo;
import model.UsuarioLogueado;


/**
 *
 * @author JUANA
 */
public class PanelTareaDeReclamoPaso2 extends javax.swing.JPanel {

private ControllerProcesarReclamo controlador;
    public PanelTareaDeReclamoPaso2(ControllerProcesarReclamo controladorParametro) {
        this.controlador = controladorParametro;
        this.controlador.setUnEstadoReclamo(this.controlador.encontrarEstadoDeReclamo("En curso"));
//        this.controlador.setUnEstadoLineaDeReclamo(this.controlador.encontrarEstadoLineaDeReclamo("Empleado experto asignado"));

        initComponents();
        mostrarDatos();
    }

            public void mostrarDatos(){
                

//               this.controlador.getReclamo().setEstado(lbl_ESTADO.getText());
                this.lbl_ESTADO.setText(this.controlador.getUnEstadoReclamo().getDescripcion());
//                this.lbl_NUMERO.setText(this.controlador.getUnReclamo().getNroReclamo()+"");
//                this.lbl_TIPODERECLAMO.setText(this.controlador.getUnReclamo().getUnTipoDeReclamo().getMotivo());
//                this.lbl_DESCRIPCION.setText(this.controlador.getUnReclamo().getUnaDescripcionInicial().getUnaDescripcionInicial());
//                this.lbl_SERVICIO.setText(this.controlador.getUnReclamo().getServicio().getTipoServicio());
//                 this.lbl_TIPODEURGENCIA.setText(this.controlador.getUnReclamo().getUnTipoDeUrgencia().getUnTipoDeUrgencia());
//
////------------------------------------DATOS DE CLIENTE---------------------------------------------------------------------                
//                this.lbl_NUMERODECLIENTE.setText(this.controlador.getUnReclamo().getUnCliente().getNroCliente());
//                this.lbl_APELLIDO.setText(this.controlador.getUnReclamo().getUnCliente().getApellido());
//                this.lbl_NOMBREDECLIENTE.setText(this.controlador.getUnReclamo().getUnCliente().getNombre());
//                this.lbl_DNIDECLIENTE.setText(this.controlador.getUnReclamo().getUnCliente().getDni());
//------------------------------------------------------------------------------------------------------------------------
                
            }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenido = new javax.swing.JPanel();
        lbl_nuevoReclamoDeCliente = new javax.swing.JLabel();
        lbl_estado = new javax.swing.JLabel();
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
        btn_FinalizarReclamo = new javax.swing.JButton();
        btn_Cancelar = new javax.swing.JButton();
        jFormattedTextField_Hora = new javax.swing.JFormattedTextField();
        lbl_ESTADO = new javax.swing.JLabel();
        lbl_tipoDeUrgencia = new javax.swing.JLabel();
        lbl_TIPODEURGENCIA = new javax.swing.JLabel();
        jScrollPane_Descripcion = new javax.swing.JScrollPane();
        jTextArea_descripcionResolucion = new javax.swing.JTextArea();

        setLayout(null);

        jPanelContenido.setBackground(new java.awt.Color(255, 255, 255));
        jPanelContenido.setPreferredSize(new java.awt.Dimension(1200, 750));
        jPanelContenido.setLayout(null);

        lbl_nuevoReclamoDeCliente.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        lbl_nuevoReclamoDeCliente.setText("                       Registrar Tarea De Reclamo");
        lbl_nuevoReclamoDeCliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbl_nuevoReclamoDeCliente.setOpaque(true);
        lbl_nuevoReclamoDeCliente.setPreferredSize(new java.awt.Dimension(1000, 100));
        jPanelContenido.add(lbl_nuevoReclamoDeCliente);
        lbl_nuevoReclamoDeCliente.setBounds(0, 0, 1200, 100);

        lbl_estado.setText("ESTADO:");
        jPanelContenido.add(lbl_estado);
        lbl_estado.setBounds(70, 220, 70, 24);

        lbl_reclamo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_reclamo.setText("RECLAMO");
        jPanelContenido.add(lbl_reclamo);
        lbl_reclamo.setBounds(430, 180, 70, 17);

        lbl_fecha.setText("FECHA:");
        jPanelContenido.add(lbl_fecha);
        lbl_fecha.setBounds(500, 220, 48, 25);

        jFormattedTextField_FECHA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter()));
        jPanelContenido.add(jFormattedTextField_FECHA);
        jFormattedTextField_FECHA.setBounds(580, 220, 100, 20);

        lbl_numero.setText("NUMERO:");
        jPanelContenido.add(lbl_numero);
        lbl_numero.setBounds(70, 260, 60, 14);

        lbl_NUMERO.setOpaque(true);
        lbl_NUMERO.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido.add(lbl_NUMERO);
        lbl_NUMERO.setBounds(190, 250, 280, 22);

        lbl_hora.setText("HORA:");
        jPanelContenido.add(lbl_hora);
        lbl_hora.setBounds(500, 260, 40, 14);

        lbl_TipoDeReclamo.setText("TIPO DE RECLAMO:");
        jPanelContenido.add(lbl_TipoDeReclamo);
        lbl_TipoDeReclamo.setBounds(70, 290, 110, 14);

        lbl_servicio.setText("SERVICIO:");
        jPanelContenido.add(lbl_servicio);
        lbl_servicio.setBounds(500, 290, 60, 14);

        lbl_SERVICIO.setOpaque(true);
        lbl_SERVICIO.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido.add(lbl_SERVICIO);
        lbl_SERVICIO.setBounds(580, 290, 320, 20);

        lbl_TIPODERECLAMO.setOpaque(true);
        lbl_TIPODERECLAMO.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido.add(lbl_TIPODERECLAMO);
        lbl_TIPODERECLAMO.setBounds(190, 290, 280, 22);

        jLabel1.setText("DESCRIPCIÓN: ");
        jPanelContenido.add(jLabel1);
        jLabel1.setBounds(490, 330, 90, 14);

        lbl_DESCRIPCION.setOpaque(true);
        lbl_DESCRIPCION.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido.add(lbl_DESCRIPCION);
        lbl_DESCRIPCION.setBounds(578, 318, 330, 30);

        lbl_cliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_cliente.setText("CLIENTE");
        jPanelContenido.add(lbl_cliente);
        lbl_cliente.setBounds(430, 360, 63, 17);

        lbl_numeroCiente.setText("NUMERO:");
        jPanelContenido.add(lbl_numeroCiente);
        lbl_numeroCiente.setBounds(70, 380, 70, 14);

        lbl_NUMERODECLIENTE.setOpaque(true);
        lbl_NUMERODECLIENTE.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido.add(lbl_NUMERODECLIENTE);
        lbl_NUMERODECLIENTE.setBounds(190, 380, 280, 20);

        lbl_nombre.setText("NOMBRE:");
        jPanelContenido.add(lbl_nombre);
        lbl_nombre.setBounds(500, 380, 70, 14);

        lbl_NOMBREDECLIENTE.setOpaque(true);
        lbl_NOMBREDECLIENTE.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido.add(lbl_NOMBREDECLIENTE);
        lbl_NOMBREDECLIENTE.setBounds(580, 380, 330, 18);

        lbl_apellido.setText("APELLIDO:");
        jPanelContenido.add(lbl_apellido);
        lbl_apellido.setBounds(70, 410, 70, 14);

        lbl_APELLIDO.setOpaque(true);
        lbl_APELLIDO.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido.add(lbl_APELLIDO);
        lbl_APELLIDO.setBounds(190, 410, 280, 20);

        lbl_dni.setText("DNI:");
        jPanelContenido.add(lbl_dni);
        lbl_dni.setBounds(500, 410, 50, 14);

        lbl_DNIDECLIENTE.setOpaque(true);
        lbl_DNIDECLIENTE.setPreferredSize(new java.awt.Dimension(0, 20));
        jPanelContenido.add(lbl_DNIDECLIENTE);
        lbl_DNIDECLIENTE.setBounds(580, 410, 330, 20);

        btn_FinalizarReclamo.setBackground(new java.awt.Color(0, 204, 0));
        btn_FinalizarReclamo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_FinalizarReclamo.setForeground(new java.awt.Color(255, 255, 255));
        btn_FinalizarReclamo.setText("FINALIZAR TAREA");
        btn_FinalizarReclamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_FinalizarReclamoActionPerformed(evt);
            }
        });
        jPanelContenido.add(btn_FinalizarReclamo);
        btn_FinalizarReclamo.setBounds(600, 650, 175, 35);

        btn_Cancelar.setBackground(new java.awt.Color(255, 0, 0));
        btn_Cancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_Cancelar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Cancelar.setText("CANCELAR");
        btn_Cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CancelarActionPerformed(evt);
            }
        });
        jPanelContenido.add(btn_Cancelar);
        btn_Cancelar.setBounds(150, 650, 175, 35);

        jFormattedTextField_Hora.setEditable(false);
        jFormattedTextField_Hora.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getTimeInstance())));
        jFormattedTextField_Hora.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jFormattedTextField_Hora.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanelContenido.add(jFormattedTextField_Hora);
        jFormattedTextField_Hora.setBounds(580, 250, 100, 23);

        lbl_ESTADO.setOpaque(true);
        jPanelContenido.add(lbl_ESTADO);
        lbl_ESTADO.setBounds(190, 220, 280, 20);

        lbl_tipoDeUrgencia.setText("TIPO DE URGENCIA: ");
        jPanelContenido.add(lbl_tipoDeUrgencia);
        lbl_tipoDeUrgencia.setBounds(70, 330, 120, 14);

        lbl_TIPODEURGENCIA.setOpaque(true);
        jPanelContenido.add(lbl_TIPODEURGENCIA);
        lbl_TIPODEURGENCIA.setBounds(190, 330, 280, 20);

        jTextArea_descripcionResolucion.setColumns(20);
        jTextArea_descripcionResolucion.setRows(5);
        jScrollPane_Descripcion.setViewportView(jTextArea_descripcionResolucion);

        jPanelContenido.add(jScrollPane_Descripcion);
        jScrollPane_Descripcion.setBounds(66, 476, 830, 150);

        add(jPanelContenido);
        jPanelContenido.setBounds(0, 0, 1200, 750);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_FinalizarReclamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_FinalizarReclamoActionPerformed
        //     controlador.guardarReclamo(this.controlador.getNuevoReclamo());
        //                this.lbl_TIPODEURGENCIA.setText(this.controlador.getUnTipoDeUrgenciaReclamo().getUnTipoDeUrgencia());
    }//GEN-LAST:event_btn_FinalizarReclamoActionPerformed

    private void btn_CancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CancelarActionPerformed

    }//GEN-LAST:event_btn_CancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancelar;
    private javax.swing.JButton btn_FinalizarReclamo;
    private javax.swing.JFormattedTextField jFormattedTextField_FECHA;
    private javax.swing.JFormattedTextField jFormattedTextField_Hora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelContenido;
    private javax.swing.JScrollPane jScrollPane_Descripcion;
    private javax.swing.JTextArea jTextArea_descripcionResolucion;
    private javax.swing.JLabel lbl_APELLIDO;
    private javax.swing.JLabel lbl_DESCRIPCION;
    private javax.swing.JLabel lbl_DNIDECLIENTE;
    private javax.swing.JLabel lbl_ESTADO;
    private javax.swing.JLabel lbl_NOMBREDECLIENTE;
    private javax.swing.JLabel lbl_NUMERO;
    private javax.swing.JLabel lbl_NUMERODECLIENTE;
    private javax.swing.JLabel lbl_SERVICIO;
    private javax.swing.JLabel lbl_TIPODERECLAMO;
    private javax.swing.JLabel lbl_TIPODEURGENCIA;
    private javax.swing.JLabel lbl_TipoDeReclamo;
    private javax.swing.JLabel lbl_apellido;
    private javax.swing.JLabel lbl_cliente;
    private javax.swing.JLabel lbl_dni;
    private javax.swing.JLabel lbl_estado;
    private javax.swing.JLabel lbl_fecha;
    private javax.swing.JLabel lbl_hora;
    private javax.swing.JLabel lbl_nombre;
    private javax.swing.JLabel lbl_nuevoReclamoDeCliente;
    private javax.swing.JLabel lbl_numero;
    private javax.swing.JLabel lbl_numeroCiente;
    private javax.swing.JLabel lbl_reclamo;
    private javax.swing.JLabel lbl_servicio;
    private javax.swing.JLabel lbl_tipoDeUrgencia;
    // End of variables declaration//GEN-END:variables
   
    
//    public static String fechaActual(){
//    Date fecha = new Date();
//    SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/YYYY");
//    return formatoFecha.format(fecha);
//    }
//    
//    public static String horaActual(){
//    Date hora = new Date();
//    SimpleDateFormat formatoFecha = new SimpleDateFormat("HH:mm");
//    return formatoFecha.format(hora);
//    }

    public ControllerProcesarReclamo getControlador() {
        return controlador;
    }

    public javax.swing.JButton getBtn_Cancelar() {
        return btn_Cancelar;
    }

    public javax.swing.JButton getBtn_FinalizarReclamo() {
        return btn_FinalizarReclamo;
    }
    
    
}
