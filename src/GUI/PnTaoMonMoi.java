/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.khoCauHoiBUS;
import BUS.monBUS;
import DTO.monDTO;
import static GUI.BASE.dark_green;
import static GUI.BASE.font16;
import static GUI.BASE.font16b;
import static GUI.BASE.gray_bg;
import XULY.ShowDiaLog;
import XULY.xuLyFileExcel;
import java.awt.BorderLayout;
import static java.awt.Color.white;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.Normalizer;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class PnTaoMonMoi extends JPanel {

    private JTextField tfTimKiem, tfTenMon;
    private DefaultTableModel model;
    private JTable table;
    private JButton btnThem, btnNhapExcel;
    private JPanel pnTop, pnCenter, pnBottom;
    private monBUS busMon;
    private monDTO dtoMon = new monDTO();
    private khoCauHoiBUS busKho;

    public PnTaoMonMoi() throws SQLException {
        busMon = new monBUS();
        busKho = new khoCauHoiBUS();
        init();
        initComponents();
        loadData();
    }

    public void init() {
        this.setLayout(new BorderLayout());
        pnTop = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        pnTop.setBackground(gray_bg);
        pnCenter = new JPanel(new BorderLayout());
        pnBottom = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnBottom.setBackground(gray_bg);
        this.add(pnTop, BorderLayout.NORTH);
        this.add(pnCenter, BorderLayout.CENTER);
        this.add(pnBottom, BorderLayout.SOUTH);
    }

    public void initComponents() {
        JLabel lblTimKiem, lblTenMon;
        lblTimKiem = new JLabel("Tìm kiếm");
        lblTimKiem.setFont(font16);
        tfTimKiem = new JTextField();
        tfTimKiem.setPreferredSize(new Dimension(170, 26));
        pnTop.add(lblTimKiem);
        pnTop.add(tfTimKiem);

        Object[] columns = {"Mã môn", "Tên môn"};
        model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(model);
        setTableFont(table);
        JScrollPane scrlTable = new JScrollPane(table);
        pnCenter.add(scrlTable);

        lblTenMon = new JLabel("Tên môn:");
        lblTenMon.setFont(font16);
        tfTenMon = new JTextField();
        tfTenMon.setPreferredSize(new Dimension(190, 30));
        btnThem = new JButton("Thêm");
        btnThem.setBackground(dark_green);
        btnThem.setFont(font16b);
        btnThem.setForeground(white);
        btnThem.setBorderPainted(false);
        btnThem.setFocusPainted(false);
        btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnThem.setMaximumSize(new Dimension(120, 20));

        pnBottom.add(lblTenMon);
        pnBottom.add(tfTenMon);
        pnBottom.add(btnThem);

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String TenMon = tfTenMon.getText();

                if (TenMon.isEmpty()) {
                    new ShowDiaLog("Bạn chưa nhập tên môn", ShowDiaLog.ERROR_DIALOG);

                } else if (TenMon.matches(".*\\d.*")) {
                    new ShowDiaLog("Tên môn không được chứa số", ShowDiaLog.ERROR_DIALOG);

                } else {
                    String ten = TenMon.trim().replaceAll("\\s+", " ");
                    ten = ten.substring(0, 1).toUpperCase() + ten.substring(1);
                    String tenkhongdau = Normalizer.normalize(ten, Normalizer.Form.NFD)
                            .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
                    String[] words = tenkhongdau.split("\\s+");
                    String MaMon = "M";
                    String MaKho = "K";
                    for (String word : words) {
                        if (!word.isEmpty()) {
                            MaMon += Character.toUpperCase(word.charAt(0));
                            MaKho += Character.toUpperCase(word.charAt(0));
                        }
                    }

                    System.out.println(ten);
                    System.out.println(MaMon);
                    System.out.println(MaKho);
                    System.out.println(tenkhongdau);
                    ThemMon(MaMon, ten);
                    ThemKho(MaKho, MaMon);
                }
            }
        });

        tfTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = tfTimKiem.getText();
                if (!name.isEmpty()) {
                    TimKiem(name);
                } else {
                    loadData();
                }
            }
        });

    }

    private void setTableFont(JTable table) {
        table.setFont(font16);

        JTableHeader header = table.getTableHeader();
        header.setFont(font16);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setFont(font16);
        table.setDefaultRenderer(Object.class, renderer);
        table.setRowHeight(30);
    }

    private void loadData() {
        model.setRowCount(0);
        ArrayList<monDTO> list = busMon.getList();
        for (monDTO m : list) {
            Object[] row = {m.getMaMon(), m.getTenMon()};
            model.addRow(row);
        }
    }

    private void ThemMon(String MaMon, String TenMon) {
        boolean result = busMon.ThemMon(MaMon, TenMon);
        if (result) {
            loadData();
            tfTenMon.setText("");
        }
    }

    private void ThemKho(String MaKho, String MaMon) {
        busKho.ThemKho(MaKho, MaMon, null);
    }

    private void TimKiem(String keyword) {
        ArrayList<monDTO> list = busMon.TimKiem(keyword);
        model.setRowCount(0);
        for (monDTO m : list) {
            Object[] row = {m.getMaMon(), m.getTenMon()};
            model.addRow(row);
        }
    }

    private void NhapExcel() {
        xuLyFileExcel nhapExcel = new xuLyFileExcel();
        nhapExcel.nhapExcel(table);

    }

    public static void main(String[] args) throws SQLException {
        JFrame f = new JFrame();
        f.setSize(900, 400);
        PnTaoMonMoi p = new PnTaoMonMoi();
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}
