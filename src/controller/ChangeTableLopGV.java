/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.FrameDSLopGV;

/**
 *
 * @author E7250
 */
public class ChangeTableLopGV implements ActionListener {

    private FrameDSLopGV gv;

    public ChangeTableLopGV(FrameDSLopGV gv) {
        this.gv = gv;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedOption = (String) gv.getCbb_trangThai().getSelectedItem();
        if (selectedOption.equals("Đang dạy")) {
            // Dữ liệu mới khi lựa chọn là Option 1
            Object[][] newData = {
                {"L1", "CNTT", "Toán", "2024", "1"},};
            gv.getModel().setDataVector(newData, gv.getColumns());
        } else if (selectedOption.equals("Đã dạy")) {
            // Dữ liệu mới khi lựa chọn là Option 2
            Object[][] newData = {
                {"L2", "CNTT1", "Toán1", "20241", "111"},};
            gv.getModel().setDataVector(newData, gv.getColumns());
        }

    }

}
