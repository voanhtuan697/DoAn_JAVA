/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import javax.swing.UIManager;
import view.Login;

/**
 *
 * @author E7250
 */
public class testLogIn {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
