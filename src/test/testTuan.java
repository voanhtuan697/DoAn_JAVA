/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import javax.swing.UIManager;
import view.MenuFrameGV;

/**
 *
 * @author E7250
 */
public class testTuan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        new MenuFrameGV();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new MenuFrameGV();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
