/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.MenuFrameTBM;

public class Menu_TBM_Listener implements ActionListener{
    private MenuFrameTBM mnTBM;
    
    public Menu_TBM_Listener(MenuFrameTBM mnTBM){
        this.mnTBM = mnTBM;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String btn_name = e.getActionCommand();
        if (btn_name.equals("Trưởng bộ môn")) {
            mnTBM.getCardLayout().show(mnTBM.getCards(), "pnCTTBM");
            mnTBM.getLb_Header().setText("Thông tin trưởng bộ môn");
            
        } else if (btn_name.equals("Duyệt câu hỏi")) {
            mnTBM.getCardLayout().show(mnTBM.getCards(), "pnDuyetCH");
            mnTBM.getLb_Header().setText("Duyệt câu hỏi");
        } 
    }
}
