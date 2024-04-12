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

//            new MenuFrameAd();

                new MenuFrameAd();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
