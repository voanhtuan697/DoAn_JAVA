/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MenuFrameAd;


public class Menu_AD_Listener implements ActionListener{
    private MenuFrameAd mnAd;
    
    public Menu_AD_Listener(MenuFrameAd mnAd){
        this.mnAd = mnAd;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String btn_name = e.getActionCommand();
        if (btn_name.equals("Quản lý")) {
            mnAd.getCardLayout().show(mnAd.getCards(), "PnQuanLy");
            mnAd.getLb_Header().setText("Quản lý");
        } else if (btn_name.equals("Sinh viên")) {
            mnAd.getCardLayout().show(mnAd.getCards(), "PnSV");
            mnAd.getLb_Header().setText("Sinh viên");
        } else if (btn_name.equals("Thông tin")) { 
            mnAd.getCardLayout().show(mnAd.getCards(), "PnInfor");
            mnAd.getLb_Header().setText("Thông tin");
        }
    }
}
