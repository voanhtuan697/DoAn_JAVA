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
        if (btn_name.equals("ADMIN")) {
            mnAd.getCardLayout().show(mnAd.getCards(), "pnCTAD");
            mnAd.getLb_Header().setText("ADMIN");
            
        } else if (btn_name.equals("Thêm Admin")) {
            mnAd.getCardLayout().show(mnAd.getCards(), "pnThemAD");
            mnAd.getLb_Header().setText("Thêm Admin");
            
        } else if (btn_name.equals("Thêm TBM")) { 
            mnAd.getCardLayout().show(mnAd.getCards(), "pnThemTBM");
            mnAd.getLb_Header().setText("Thêm Trưởng bộ môn");
            
        }else if (btn_name.equals("Thêm GV")) {
            mnAd.getCardLayout().show(mnAd.getCards(), "pnThemGV");
            mnAd.getLb_Header().setText("Thêm Giảng viên");
            
        } else if (btn_name.equals("Thêm SV")) { 
            mnAd.getCardLayout().show(mnAd.getCards(), "pnThemSV");
            mnAd.getLb_Header().setText("Thêm sinh viên");
            
        }
    }
}
