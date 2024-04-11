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
        if (btn_name.equals("Thông tin")) {
            mnSV.getCardLayout().show(mnSV.getCards(), "PnThongtin");
            mnSV.getLb_Header().setText("Thông tin thi");
        } else if (btn_name.equals("Vào thi")) {
            mnSV.getCardLayout().show(mnSV.getCards(), "PnThi");
            mnSV.getLb_Header().setText("Vào Thi");
        } else if(btn_name.equals("Cá nhân")) {
            mnSV.getCardLayout().show(mnSV.getCards(), "pnCTAD");
            mnSV.getLb_Header().setText("Cá nhân");
        }
    }
}
