/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MenuFrameGV;

/**
 *
 * @author E7250
 */
public class Menu_GV_Listener implements ActionListener {

    private MenuFrameGV mnGV;

    public Menu_GV_Listener(MenuFrameGV mnGV) {
        this.mnGV = mnGV;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn_name = e.getActionCommand();
        if (btn_name.equals("Tạo câu hỏi")) {
            mnGV.getCardLayout().show(mnGV.getCards(), "pnTaoCH");
            mnGV.getLb_Header().setText("Tạo câu hỏi");
        } else if (btn_name.equals("Tạo đề thi")) {
            mnGV.getCardLayout().show(mnGV.getCards(), "pnTaoDT");
            mnGV.getLb_Header().setText("Tạo đề thi");
        } else if (btn_name.equals("Kết quả")) { 
            mnGV.getCardLayout().show(mnGV.getCards(), "pnKQ");
            mnGV.getLb_Header().setText("Kết quả");
        }else if (btn_name.equals("Đổi mật khẩu")) { 
            mnGV.getCardLayout().show(mnGV.getCards(), "pnPass");
            mnGV.getLb_Header().setText("Đổi mật khẩu");
        }
    }

}
