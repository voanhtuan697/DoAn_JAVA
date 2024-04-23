/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import view.PanelTaoCauHoi;

/**
 *
 * @author E7250
 */
public class HinhThucCauHoi_Listener implements ActionListener {

    private PanelTaoCauHoi panelTaoCauHoi;

    public HinhThucCauHoi_Listener(PanelTaoCauHoi panelTaoCauHoi) {
        this.panelTaoCauHoi = panelTaoCauHoi;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        String btn_name = e.getActionCommand();

        String selectedOption = (String) panelTaoCauHoi.getCbb_hinhThuc().getSelectedItem();
        if (selectedOption.equals("Trắc nghiệm một lựa chọn đúng")) {
            panelTaoCauHoi.getCardLayout().show(panelTaoCauHoi.getCards(), "pn_TN4");
            panelTaoCauHoi.getLb_soDapAn().setVisible(false);
            panelTaoCauHoi.getTxt_soDapAn().setVisible(false);
        } else if (selectedOption.equals("Trắc nghiệm nhiều lựa chọn đúng")) {
            panelTaoCauHoi.getCardLayout().show(panelTaoCauHoi.getCards(), "pn_TN_Nhieu");
            panelTaoCauHoi.getLb_soDapAn().setVisible(true);
            panelTaoCauHoi.getTxt_soDapAn().setVisible(true);

            String pattern = "\\d+";
            String input = panelTaoCauHoi.getTxt_soDapAn().getText();

            if (Pattern.matches(pattern, input)) {
                int number = Integer.parseInt(input);
                panelTaoCauHoi.chan(number);
//                panelTaoCauHoi.getTxt_soDapAn().setText("");
            } else {
                System.out.println("Không phải là số nguyên.");
//                panelTaoCauHoi.getTxt_soDapAn().setText("");
            }

        }

    }

}
