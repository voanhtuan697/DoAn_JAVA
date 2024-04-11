/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package test;

import javax.swing.UIManager;
import view.MenuFrameAd;
import view.MenuFrameGV;

public class testTuan {

    public static void main(String[] args) {
//        new MenuFrameGV();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            new MenuFrameGV();
<<<<<<< HEAD
//            new MenuFrameAd();
=======
                new MenuFrameAd();
>>>>>>> ce7f38ba17de22569a58cfe10607f4588f17259f
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
