/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.lopBUS2;
import BUS.monBUS2;
import BUS.nguoiDungBUS2;
import BUS.taiKhoanBUS2;
import DTO.lopDTO;
import DTO.monDTO;
import DTO.nguoiDungDTO;
import DTO.taiKhoanDTO;
import static GUI.BASE.dark_green;
import static GUI.BASE.font14;
import static GUI.BASE.font14b;
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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


public class PnTaoLopMoi extends JPanel {

    private JPanel pnTop, pnCenter, pnBottom;
    private JComboBox cbb_TrThLop, cbb_HocKy, cbb_TrangThai, cb_GiaoVien, cb_Mon;
    private JTextField tfSearch, tfTenLop, tfSL;
    private JButton btnThem, btnLopKT, btnNhapE, btnXoa;
    private JTable table;
    private DefaultTableModel model;
    private lopBUS2 bus = new lopBUS2();
    private taiKhoanBUS2 busTK = new taiKhoanBUS2();
    private monBUS2 busMon = new monBUS2();
    private nguoiDungBUS2 busNg = new nguoiDungBUS2();

    public PnTaoLopMoi() {
        init();
        initComponents();
        loadData();
    }

    public void init() {
        this.setLayout(new BorderLayout());
        pnTop = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnTop.setBackground(gray_bg);
        pnCenter = new JPanel(new BorderLayout());
        pnBottom = new JPanel();
        pnBottom.setBackground(gray_bg);
        this.add(pnTop, BorderLayout.NORTH);
        this.add(pnCenter, BorderLayout.CENTER);
        this.add(pnBottom, BorderLayout.SOUTH);
    }

    public void initComponents() {
        JLabel lblTrangthai, lblSearch;
        lblTrangthai = new JLabel("Trạng thái");
        lblSearch = new JLabel("Tìm kiếm");
        String[] cacTrangThai = new String[]{"Tất cả", "Đang mở", "Đã kết thúc"};
        cbb_TrThLop = new JComboBox<>(cacTrangThai);
        tfSearch = new JTextField(20);
        pnTop.add(lblTrangthai);
        pnTop.add(cbb_TrThLop);
        pnTop.add(lblSearch);
        pnTop.add(tfSearch);

        Object[] columns = {"Mã lớp", "Nhóm lớp", "Tên giảng viên", "Mã môn", "Năm học", "Học kỳ", "Số lượng", "Trạng thái"};
        model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
//<<<<<<< HEAD:src/GUI/PnThemLop.java
        table = new JTable(model);
        setTableFont(table);
        JScrollPane scrlTable = new JScrollPane(table);
        pnCenter.add(scrlTable, BorderLayout.CENTER);

        tfTenLop = new JTextField();
        tfSL = new JTextField();
//        JLabel lblTenLop, lblMon, lblHocKy, lblGv, lblSL, lblTThai;
        String[] title = {"Tên lớp", "Tên môn:", "Học kỳ:", "Giảng viên:", "Số lượng:", "Trạng thái:"};
        JLabel[] lbl = new JLabel[title.length]; // Đổi độ dài của mảng thành title.length
        for (int i = 0; i < title.length; i++) {
            lbl[i] = new JLabel(title[i]);
            lbl[i].setFont(font14);
        }
        cb_GiaoVien = new JComboBox();
        cb_Mon = new JComboBox();
        cbb_HocKy = new JComboBox<>(new String[]{"1", "2"});
        cbb_TrangThai = new JComboBox<>(new String[]{"Hoạt động", "Kết thúc"});

        btnThem = new JButton("Thêm");
        btnThem.setBackground(dark_green);
        btnThem.setFont(font14b);
        btnThem.setForeground(white);
        btnThem.setBorderPainted(false);
        btnThem.setFocusPainted(false);
        btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnThem.setMaximumSize(new Dimension(120, 25));

        btnNhapE = new JButton("Nhập Excel");
        btnNhapE.setBackground(dark_green);
        btnNhapE.setForeground(white);
        btnNhapE.setFont(font14b);
        btnNhapE.setBorderPainted(false);
        btnNhapE.setFocusPainted(false);
        btnNhapE.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnNhapE.setMaximumSize(new Dimension(120, 25));

        btnXoa = new JButton("Xóa");
        btnXoa.setBackground(dark_green);
        btnXoa.setForeground(white);
        btnXoa.setFont(font14b);
        btnXoa.setBorderPainted(false);
        btnXoa.setFocusPainted(false);
        btnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnXoa.setMaximumSize(new Dimension(120, 25));

        btnLopKT = new JButton("Lớp kết thúc");
        btnLopKT.setBackground(dark_green);
        btnLopKT.setForeground(white);
        btnLopKT.setFont(font14b);
        btnLopKT.setBorderPainted(false);
        btnLopKT.setFocusPainted(false);
        btnLopKT.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnLopKT.setMaximumSize(new Dimension(106, 25));

        GroupLayout layout = new GroupLayout(pnBottom);
        pnBottom.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lbl[1])
                        .addComponent(lbl[2])
                        .addComponent(lbl[3])
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(cb_Mon)
                        .addComponent(cbb_HocKy)
                        .addComponent(cb_GiaoVien)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lbl[4])
                        .addComponent(lbl[5])
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(tfSL)
                        .addComponent(cbb_TrangThai)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(btnThem)
                        .addComponent(btnXoa)
                        .addComponent(btnNhapE)
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl[1])
                        .addComponent(cb_Mon)
                        .addComponent(lbl[4])
                        .addComponent(tfSL)
                        .addComponent(btnThem)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl[2])
                        .addComponent(cbb_HocKy)
                        .addComponent(lbl[5])
                        .addComponent(cbb_TrangThai)
                        .addComponent(btnXoa)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl[3])
                        .addComponent(cb_GiaoVien)
                        .addComponent(btnNhapE)
                )
        );

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String i = (String) cbb_TrangThai.getSelectedItem();
                String soLuong = tfSL.getText();

                int number = Integer.parseInt(soLuong);
                if (soLuong.isEmpty()) {
                    new ShowDiaLog("Không được để rỗng", ShowDiaLog.ERROR_DIALOG);
                    tfSL.requestFocus();
                } else if (!soLuong.matches("^\\d+$")) {
                    new ShowDiaLog("Vui lòng nhập số nguyên dương", ShowDiaLog.ERROR_DIALOG);
                } else if (number > 100) {
                    new ShowDiaLog("Số phải là số dương và nhỏ hơn hoặc bằng 100", ShowDiaLog.ERROR_DIALOG);
                } else {
                    themLop();
                    tfSL.setText("");
                }
            }

        });

        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                XoaLop();
            }
        });

        tfSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String keyword = tfSearch.getText();
                TimKiem(keyword);
                tfSearch.setText("");
            }
        });

        cbb_TrThLop.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedItem = (String) cbb_TrThLop.getSelectedItem();
                    if ("Đang mở".equals(selectedItem)) {
                        listTrangThai(1);
                    } else if ("Đã kết thúc".equals(selectedItem)) {
                        listTrangThai(0);
                    } else if ("Tất cả".equals(selectedItem)) {
                        loadData();
                    }
                }
            }
        });

        cb_Mon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String TenMon = cb_Mon.getSelectedItem() + "";
                if (TenMon != "") {
                    ArrayList<nguoiDungDTO> list = busNg.DSTenGV(TenMon);
                    cb_GiaoVien.removeAllItems();
                    for (nguoiDungDTO ng : list) {
                        cb_GiaoVien.addItem(ng.getHoTen());
                    }
                }
            }
        });

        btnNhapE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NhapExcel();
            }
        });

    }

    private void loadData() {

        ArrayList<monDTO> listMon = busMon.getList();
        cb_Mon.removeAllItems();
        for (monDTO m : listMon) {
            cb_Mon.addItem(m.getTenMon());
        }

        model.setRowCount(0);
        lopBUS2 busLop = new lopBUS2();
        ArrayList<lopDTO> listLop = busLop.getList();
        for (lopDTO lop : listLop) {
            String TenGv, TenMon;
            TenGv = busTK.getNameByMaTk(lop.getMaGV());
            TenMon = busMon.getNameByMaMon(lop.getMaMon());
            String TrangThai = "";
            if (lop.isTrangThai() == true) {
                TrangThai = "Hoạt động";
            } else if (lop.isTrangThai() == false) {
                TrangThai = "Kết thúc";
            }

            Object[] row = {lop.getMaLop(), lop.getNhomLop(), TenGv, TenMon, lop.getNam(), lop.getHocKy(), lop.getSoLuong(), TrangThai};
            model.addRow(row);
        }

    }

    private void setTableFont(JTable table) {
        table.setFont(font14);

        JTableHeader header = table.getTableHeader();
        header.setFont(font14);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setFont(font14);
        table.setDefaultRenderer(Object.class, renderer);
    }

    private void themLop() {

        String TenMon = cb_Mon.getSelectedItem().toString();
        String MaMon = busMon.getMaMonByName(TenMon);
        String MaLop = getMaLop(TenMon);

        String hocky = cbb_HocKy.getSelectedItem().toString();
        int HocKy = Integer.parseInt(hocky);

        String gv = cb_GiaoVien.getSelectedItem().toString();
        String MaGv = busTK.getMaTkByName(gv);

        int soLuong = Integer.parseInt(tfSL.getText());

        LocalDate currentDate = LocalDate.now();
        int Nam = currentDate.getYear();

        int NhomLop = getNhomLop(TenMon);

        String tt = cbb_TrangThai.getSelectedItem().toString();
        boolean TrangThai = true;
        if (tt == "Hoạt động") {
            TrangThai = true;
        } else if (tt == "Kết thúc") {
            TrangThai = false;
        }
        boolean rs = bus.themLop(MaLop, MaGv, soLuong, MaMon, Nam, HocKy, TrangThai, NhomLop);
        loadData();
    }

    private void XoaLop() {
        int i = table.getSelectedRow();
        if (i == -1) {
            new ShowDiaLog("Vui lòng chọn 1 dòng để xóa", ShowDiaLog.ERROR_DIALOG);
        } else {
            String MaLop = table.getValueAt(i, 0) + "";
            System.out.println(MaLop);
            bus.XoaLop(MaLop);
            loadData();
        }
    }

    private void TimKiem(String keyword) {
        ArrayList<lopDTO> list = bus.TimKiem(keyword);
        model.setRowCount(0);
        for (lopDTO lop : list) {
            String TenGv, TenMon;
            TenGv = busTK.getNameByMaTk(lop.getMaGV());
            TenMon = busMon.getNameByMaMon(lop.getMaMon());
            Object[] row = {lop.getMaLop(), lop.getNhomLop(), TenGv, TenMon, lop.getNam(), lop.getHocKy(), lop.getSoLuong(), lop.isTrangThai()};
            model.addRow(row);
        }
        if (keyword == "") {
            loadData();
        }
    }

    private void listTrangThai(int i) {
        ArrayList<lopDTO> list = bus.listTrangThaiLop(i);
        model.setRowCount(0);
        for (lopDTO lop : list) {
            String TenGv, TenMon;
            TenGv = busTK.getNameByMaTk(lop.getMaGV());
            TenMon = busMon.getNameByMaMon(lop.getMaMon());
            Object[] row = {lop.getMaLop(), lop.getNhomLop(), TenGv, TenMon, lop.getNam(), lop.getHocKy(), lop.getSoLuong(), lop.isTrangThai()};
            model.addRow(row);
        }
    }

    private void NhapExcel() {
        xuLyFileExcel nhapFile = new xuLyFileExcel();
        nhapFile.nhapExcel(table);
    }

    private String getMaLop(String TenMon) {
        String tmp = bus.getMaLop(TenMon);

        String result = "";
        if (tmp != "") {
            StringBuilder str = new StringBuilder();
            StringBuilder num = new StringBuilder();
            for (char c : tmp.toCharArray()) {
                if (Character.isLetter(c)) {
                    str.append(c);
                } else if (Character.isDigit(c)) {
                    num.append(c);
                }
            }
            int number = Integer.parseInt(num.toString()) + 1;
            result = str.toString() + number;
        } else {
            String Char = String.valueOf(TenMon.charAt(0)).toUpperCase();
            for (int i = 1; i < TenMon.length(); i++) {
                if (TenMon.charAt(i - 1) == ' ') {
                    Char += String.valueOf(TenMon.charAt(i)).toUpperCase();
                }
            }
            result = "L" + Char + "1";
        }

        return result;
    }

    private int getNhomLop(String TenMon) {
        int id = bus.getNhomLop(TenMon);
        return id + 1;
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        PnTaoLopMoi b = new PnTaoLopMoi();
        f.add(b);
        f.setSize(800, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}
