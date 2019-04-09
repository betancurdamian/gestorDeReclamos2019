/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.Login;

public class Main {
    public static void main(String[] args){
        Login login = new Login();
        login.setBounds(0, 0, 400, 450);

              
        login.setVisible(true);

        login.repaint();
        login.setLocationRelativeTo(null);
    }
        
        
}
