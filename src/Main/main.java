/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import javax.swing.UIManager;
import GUI.dangNhapTaiKhoanGUI;


public class main {

   
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new dangNhapTaiKhoanGUI();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}