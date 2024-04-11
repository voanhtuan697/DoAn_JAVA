/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MenuFrameSV;


public class Menu_SV_Listener implements ActionListener{
    private MenuFrameSV mnSV;
    
    public Menu_SV_Listener(MenuFrameSV mnSV){
        this.mnSV = mnSV;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String btn_name = e.getActionCommand();
        if (btn_name.equals("Sinh viên")) {
            mnSV.getCardLayout().show(mnSV.getCards(), "pnCTSV");
            mnSV.getLb_Header().setText("Sinh viên");
        } else if (btn_name.equals("Đổi mật khẩu")) {
            mnSV.getCardLayout().show(mnSV.getCards(), "pnPass");
            mnSV.getLb_Header().setText("Đổi mật khẩu");
        } 
    }
}
