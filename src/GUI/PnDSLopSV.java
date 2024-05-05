/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.lopBUS2;
import BUS.monBUS2;
import BUS.taiKhoanBUS2;
import DTO.lopDTO;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author E7250
 */
public class PnDSLopSV extends JPanel {

    private DefaultTableModel model;
    private JComboBox<String> cbb_trangThai;
    private String maSV;
    private lopBUS2 bus = new lopBUS2();
    private monBUS2 busMon = new monBUS2();
    private taiKhoanBUS2 busTK = new taiKhoanBUS2();

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public JComboBox<String> getCbb_trangThai() {
        return cbb_trangThai;
    }

    public void setCbb_trangThai(JComboBox<String> cbb_trangThai) {
        this.cbb_trangThai = cbb_trangThai;
    }

    public PnDSLopSV(String maSV) {
        this.maSV = maSV;
        init();
        loadData();
    }

    public void init() {
        this.setLayout(new BorderLayout());

        JPanel pnHeader = new JPanel();
        pnHeader.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pnHeader.setPreferredSize(new Dimension(0, 40));
        pnHeader.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        JLabel lb_trangThaiLop = new JLabel("Trạng thái:");
        String[] cacTrangThai = new String[]{"Đang học", "Đã học"};
        cbb_trangThai = new JComboBox<>(cacTrangThai);

        JLabel lb_timKiem = new JLabel("Tìm kiếm:");
        JTextField txt_timKiem = new JTextField(15);

        pnHeader.add(lb_trangThaiLop);
        pnHeader.add(cbb_trangThai);
        pnHeader.add(lb_timKiem);
        pnHeader.add(txt_timKiem);

        JPanel pnTable = new JPanel();
        pnTable.setLayout(new BorderLayout());

        Object[][] data = {
            {"L1", "CNTT", "Lý Mạc Sầu", "Toán", "2024", "1"},};
        Object[] columns = {"Mã lớp", "Tên giảng viên", "Tên môn", "Năm học", "Học kỳ"};
        model = new DefaultTableModel(data, columns);

        JTable table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JScrollPane scrollPane_table = new JScrollPane(table);
        pnTable.add(scrollPane_table, BorderLayout.CENTER);

        this.add(pnHeader, BorderLayout.NORTH);
        this.add(pnTable, BorderLayout.CENTER);

        this.setVisible(true);

        cbb_trangThai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String TrangThai = cbb_trangThai.getSelectedItem() + "";
                boolean trangthai = true;
                if (TrangThai.equals("Đang học")) {
                    trangthai = true;
                } else if (TrangThai.equals("Đã học")) {
                    trangthai = false;
                }
                DSTrangThai(trangthai);
            }
        });
        
        txt_timKiem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = txt_timKiem.getText();
                if(keyword.isEmpty()){
                    loadData();
                }else{
                    timkiem(keyword);
                }
            }
        });
    }

    private void loadData() {
        model.setRowCount(0);
        ArrayList<lopDTO> list = bus.DSLop1SV(maSV);
        for (lopDTO x : list) {
            String TenMon = busMon.getNameByMaMon(x.getMaMon());
            String TenGV = busTK.getNameByMaTk(x.getMaGV());
            Object[] row = {x.getMaLop(), TenGV, TenMon, x.getNam(), x.getHocKy()};
            model.addRow(row);
        }
    }

    private void DSTrangThai(boolean TrangThai) {
        model.setRowCount(0);
        ArrayList<lopDTO> list = bus.DSTrangThaiLop1SV(maSV, TrangThai);
        for (lopDTO x : list) {
            String TenMon = busMon.getNameByMaMon(x.getMaMon());
            String TenGV = busTK.getNameByMaTk(x.getMaGV());
            Object[] row = {x.getMaLop(), TenGV, TenMon, x.getNam(), x.getHocKy()};
            model.addRow(row);
        }
    }

    private void timkiem(String keyword) {
        model.setRowCount(0);
        ArrayList<lopDTO> list = bus.TimKiemDS1SV(maSV, keyword);
        for (lopDTO x : list) {
            String TenMon = busMon.getNameByMaMon(x.getMaMon());
            String TenGV = busTK.getNameByMaTk(x.getMaGV());
            Object[] row = {x.getMaLop(), TenGV, TenMon, x.getNam(), x.getHocKy()};
            model.addRow(row);
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(800, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.getContentPane().add(new PnDSLopSV("TK14"));
        f.setVisible(true);
    }
}
