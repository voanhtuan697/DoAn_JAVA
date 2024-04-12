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
        if (btn_name.equals("TT cá nhân")) {
            mnAd.getCardLayout().show(mnAd.getCards(), "pnCTAD");
            mnAd.getLb_Header().setText("Thông tin cá nhân");
            
        } else if (btn_name.equals("Admin")) {
            mnAd.getCardLayout().show(mnAd.getCards(), "pnThemAD");
            mnAd.getLb_Header().setText("Quản lý admin");
            
        } else if (btn_name.equals("Tr bộ môn")) { 
            mnAd.getCardLayout().show(mnAd.getCards(), "pnThemTBM");
            mnAd.getLb_Header().setText("Quản lý trưởng bộ môn");
            
        }else if (btn_name.equals("Giảng viên")) {
            mnAd.getCardLayout().show(mnAd.getCards(), "pnThemGV");
            mnAd.getLb_Header().setText("Quản lý giảng viên");
            
        } else if (btn_name.equals("Sinh viên")) { 
            mnAd.getCardLayout().show(mnAd.getCards(), "pnThemSV");
            mnAd.getLb_Header().setText("Quản lý sinh viên");
            
        }
    }
}
