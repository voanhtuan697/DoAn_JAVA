/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import javax.swing.UIManager;
import GUI.FrameBaiThi;
import GUI.GiaoDienUser;

public class testTuan {

    public static void main(String[] args) {
        new GiaoDienUser();
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            new GiaoDienUser();
//            new MenuFrameAd();
//            new FrameBaiThi();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
