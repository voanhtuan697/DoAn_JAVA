/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.chiTietQuyenBUS;
import BUS.chucNangBUS;
import BUS.quyenBUS;
import DTO.chiTietQuyenDTO;
import DTO.chucNangDTO;
import DTO.quyenDTO;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author E7250
 */
public class PnPhanQuyen extends JPanel implements ActionListener {

    private quyenBUS quyen;
    private chucNangBUS chucNang;
    private chiTietQuyenBUS chiTietQuyen;
    private JTabbedPane tabbedPane;
    private Font fontBig;

    public PnPhanQuyen() throws SQLException {
        quyen = new quyenBUS();
        chucNang = new chucNangBUS();
        chiTietQuyen = new chiTietQuyenBUS();
        init();
        checkCacCheckbox();
    }

    public void init() {
        this.setLayout(new BorderLayout());

        tabbedPane = new JTabbedPane();

        ArrayList<quyenDTO> arrQuyen = quyen.layDanhSachQuyen();
        ArrayList<chucNangDTO> arrChucNang = chucNang.layDanhSachChucNang();

        int soCot = 2;
        int soHang = arrChucNang.size() / 2;
        fontBig = new Font("typeface", Font.PLAIN, 18);
        for (quyenDTO q : arrQuyen) {
            JPanel panel = new JPanel(new GridLayout(soHang, soCot, 10, 10));
            for (chucNangDTO cn : arrChucNang) {
                JCheckBox checkBox = new JCheckBox(cn.getTenCN());

                checkBox.setFont(fontBig);

                checkBox.setActionCommand(q.getMaQuyen().trim() + "_" + cn.getMaCN().trim());
//                System.out.println(checkBox.getActionCommand());
                panel.add(checkBox);
            }
            tabbedPane.addTab(q.getTenQuyen(), panel);
        }

        this.add(tabbedPane, BorderLayout.CENTER);
        JPanel pn_btn = new JPanel(new FlowLayout(1, 10, 10));
        JButton btn_acept = new JButton("Chấp nhận");
        btn_acept.addActionListener(this);
        pn_btn.add(btn_acept);
        this.add(pn_btn, BorderLayout.SOUTH);
    }

    public String khacNhap(String s1, String s2) {
        return s1.trim() + "_" + s2.trim();
    }

    public void checkCheckBoxByName(String checkBoxName, boolean checked) {
        for (Component comp : tabbedPane.getComponents()) {
            if (comp instanceof JPanel) {
                JPanel panel = (JPanel) comp;
                for (Component innerComp : panel.getComponents()) {
                    if (innerComp instanceof JCheckBox) {
                        JCheckBox checkBox = (JCheckBox) innerComp;
                        if (checkBox.getActionCommand().equals(checkBoxName)) {
                            checkBox.setSelected(checked);
                            return;
                        }
                    }
                }
            }
        }
    }

    public void checkCacCheckbox() {
        ArrayList<chiTietQuyenDTO> arr = chiTietQuyen.layDanhSachChucNang();
        for (chiTietQuyenDTO ctq : arr) {
            String chuoiGhep = khacNhap(ctq.getMaQuyen(), ctq.getMaCN());
            checkCheckBoxByName(chuoiGhep, true);
        }
    }

    public ArrayList<String> dsCacCheckboxDuocChon() {
        int selectedIndex = tabbedPane.getSelectedIndex();
        JPanel selectedPanel = (JPanel) tabbedPane.getComponentAt(selectedIndex);

        ArrayList<String> arr = new ArrayList<>();

        for (Component comp : selectedPanel.getComponents()) {
            if (comp instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) comp;
                if (checkBox.isSelected()) {
                    arr.add(checkBox.getActionCommand());
                }
            }
        }

        return arr;
    }

    public chiTietQuyenDTO taoChiTietQuyen(String input) {
        String[] parts = input.split("_");
        String maQuyen = parts[0];
        String maChucNang = parts[1];
        chiTietQuyenDTO ctq = new chiTietQuyenDTO(maChucNang, maQuyen);
        return ctq;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();
        if (btn.equals("Chấp nhận")) {
            int selectedIndex = tabbedPane.getSelectedIndex();
            String selectedTabTitle = tabbedPane.getTitleAt(selectedIndex);
            String maQuyen = "";
            ArrayList<quyenDTO> arr = quyen.layDanhSachQuyen();
            for (quyenDTO x : arr) {
                if (selectedTabTitle.equals(x.getTenQuyen().trim())) {
                    maQuyen = x.getMaQuyen().trim();
                    break;
                }
            }
//            System.out.println(maQuyen);
            chiTietQuyen.xoaQuyenTrongDSCTQ(maQuyen);
            ArrayList<String> arrCheck = dsCacCheckboxDuocChon();
            for (String x : arrCheck) {
                chiTietQuyenDTO ctq = taoChiTietQuyen(x);
                chiTietQuyen.themChiTietQuyen(ctq);
            }

        }
    }

}
