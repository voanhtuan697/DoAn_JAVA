/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MenuFrameAdmin;

/**
 *
 * @author E7250
 */
public class Menu_Admin_Listener implements ActionListener{
    private MenuFrameAdmin mnAdmin;

    public Menu_Admin_Listener(MenuFrameAdmin mnAdmin) {
        this.mnAdmin = mnAdmin;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String btn_name = e.getActionCommand();
        if (btn_name.equals("Tạo giảng viên")) {
            mnAdmin.getCardLayout().show(mnAdmin.getCards(), "pnTaoGV");
            mnAdmin.getLb_Header().setText("Tạo giảng viên");
        } else if (btn_name.equals("Tạo sinh viên")) {
            mnAdmin.getCardLayout().show(mnAdmin.getCards(), "pnTaoSV");
            mnAdmin.getLb_Header().setText("Tạo sinh viên");
        }
//        } else if (btn_name.equals("Kết quả")) { 
//            mnGV.getCardLayout().show(mnGV.getCards(), "pnKQ");
//            mnGV.getLb_Header().setText("Kết quả");
//        }else if (btn_name.equals("Đổi mật khẩu")) { 
//            mnGV.getCardLayout().show(mnGV.getCards(), "pnPass");
//            mnGV.getLb_Header().setText("Đổi mật khẩu");
//        }
    }
}
