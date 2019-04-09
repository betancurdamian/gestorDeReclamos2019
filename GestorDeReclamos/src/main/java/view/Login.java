/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.LoginController;
import java.awt.Image;
import javax.swing.ImageIcon;
import model.TipoUsuario;
import model.Usuario;

public class Login extends javax.swing.JFrame {

    private Usuario unUsuario;
    private TipoUsuario unTipoUsuario;
    private LoginController controlador = new LoginController();
    JFramePrincipal frameBienvenida;
    PanelReclamoPaso1 unPanelReclamoPaso1;

    public Login() {

        initComponents();
        //se le da tama±o al logo del login.
        //se busca el directorio de la imagen y se lo hace visible.
        lbl_logo.setBounds(10, 10, 360, 200);
        ImageIcon carpetaModificar = new ImageIcon(getClass().getResource("/image/logoIncatel.jpg"));
        ImageIcon icono = new ImageIcon(carpetaModificar.getImage().getScaledInstance(lbl_logo.getWidth(), lbl_logo.getHeight(), Image.SCALE_SMOOTH));
        lbl_logo.setIcon(icono);
        //this.add(lbl_logo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenido = new javax.swing.JPanel();
        lbl_usuario = new javax.swing.JLabel();
        lbl_contraseña = new javax.swing.JLabel();
        jtf_usuario = new javax.swing.JTextField();
        jpf_clave = new javax.swing.JPasswordField();
        lbl_logo = new javax.swing.JLabel();
        lbl_MensajeError = new javax.swing.JLabel();
        btn_ingresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 255));

        jPanelContenido.setBackground(new java.awt.Color(0, 0, 255));
        jPanelContenido.setPreferredSize(new java.awt.Dimension(400, 450));
        jPanelContenido.setLayout(null);

        lbl_usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_usuario.setForeground(new java.awt.Color(255, 255, 255));
        lbl_usuario.setText("USUARIO:");
        jPanelContenido.add(lbl_usuario);
        lbl_usuario.setBounds(20, 230, 100, 17);

        lbl_contraseña.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_contraseña.setForeground(new java.awt.Color(255, 255, 255));
        lbl_contraseña.setText("CONTRASEÑA:");
        jPanelContenido.add(lbl_contraseña);
        lbl_contraseña.setBounds(20, 280, 105, 17);
        jPanelContenido.add(jtf_usuario);
        jtf_usuario.setBounds(130, 230, 240, 20);
        jPanelContenido.add(jpf_clave);
        jpf_clave.setBounds(130, 280, 240, 20);
        jPanelContenido.add(lbl_logo);
        lbl_logo.setBounds(20, 20, 350, 170);

        lbl_MensajeError.setForeground(new java.awt.Color(255, 0, 0));
        jPanelContenido.add(lbl_MensajeError);
        lbl_MensajeError.setBounds(60, 320, 270, 20);

        btn_ingresar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_ingresar.setText("INGRESAR");
        btn_ingresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ingresarActionPerformed(evt);
            }
        });
        jPanelContenido.add(btn_ingresar);
        btn_ingresar.setBounds(10, 350, 360, 25);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelContenido, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jPanelContenido.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_ingresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ingresarActionPerformed
        // se instancia el objeto "unUsuario"
        //con el getText obtiene los datos ingresados por el usuario.
        unUsuario = new Usuario(jtf_usuario.getText(), jpf_clave.getText());

        //   En esta condicion queremos corroborar si los datos ingresados por el usuario son correctos.
        //   si los datos son correctos se elimina el framePrincipal y se hace visible la siguiente ventana.
        if (controlador.login(unUsuario) == true) {

            frameBienvenida = new JFramePrincipal();
            frameBienvenida.setBounds(0, 0, 1500, 750);
            frameBienvenida.setVisible(true);

            this.dispose();

        } else {

            //Si el usuario o contraseÃ±a es incorrecto se muestra este mensaje.
            this.lbl_MensajeError.setText("USUARIO O CONTRASEÑA INCORRECTA");
            //Limpia las cajas de textos
            this.limpiar();

        }
    }//GEN-LAST:event_btn_ingresarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_ingresar;
    private javax.swing.JPanel jPanelContenido;
    private javax.swing.JPasswordField jpf_clave;
    private javax.swing.JTextField jtf_usuario;
    private javax.swing.JLabel lbl_MensajeError;
    private javax.swing.JLabel lbl_contraseña;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_usuario;
    // End of variables declaration//GEN-END:variables

    public void limpiar() {
        this.jtf_usuario.setText("");
        this.jpf_clave.setText("");
    }

}
