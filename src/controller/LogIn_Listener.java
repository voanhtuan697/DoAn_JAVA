/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.UIManager;
import view.Login;
import view.MenuFrameGV;

/**
 *
 * @author E7250
 */
public class LogIn_Listener implements ActionListener {

    private Login log;

    public LogIn_Listener(Login log) {
        this.log = log;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();
        if (btn.equals("Đăng nhập")) {
            this.log.dispose();
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                new MenuFrameGV();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

}
