/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.*;
import DTO.*;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static GUI.BASE.createResizedIcon;
import XULY.ShowDiaLog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.SwingUtilities;

/**
 *
 * @author E7250
 */
public class FrameThemCHVaoDe extends JFrame {
    
    private DefaultTableModel model_left;
    private DefaultTableModel model_right;
    private Object[] columns = {"Mã câu hỏi", "Nội dung"};
    
    private JComboBox<String> cbb_nguoiTao;
    private JTextField txt_ndCH;
    private JTable table_left, table_right;
    private JButton btnThem, btnXoa, btnHoanThanh;
    private ArrayList<String> dsMaCH = new ArrayList<>();
    private cauHoiBUS ch;
    private String tenMon = "Quản trị doanh nghiệp";
    private String maTK = "TK8";
    
    public ArrayList<String> getDsMaCH() {
        return dsMaCH;
    }
    
    public void setDsMaCH(ArrayList<String> dsMaCH) {
        this.dsMaCH = dsMaCH;
    }
    
    public FrameThemCHVaoDe() throws SQLException {
        init();
        loadTable_Left();
        addEvent();
    }
    
    private void init() {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        
        JPanel pn_header = new JPanel(new FlowLayout(0, 10, 10));
        JLabel lb_ndCH = new JLabel("Câu hỏi:");
        txt_ndCH = new JTextField(15);
        JLabel lb_nguoiTao = new JLabel("Câu hỏi tạo bởi:");
        String[] items = {"Tất cả giảng viên", "Chính mình"};
        cbb_nguoiTao = new JComboBox<>(items);
        pn_header.add(lb_ndCH);
        pn_header.add(txt_ndCH);
        pn_header.add(lb_nguoiTao);
        pn_header.add(cbb_nguoiTao);
        
        JPanel pn_table = new JPanel();
        GroupLayout layout_table = new GroupLayout(pn_table);
        pn_table.setLayout(layout_table);
        
        JLabel lb_khoCH = new JLabel("Kho cau hoi");
        JLabel lb_deThi = new JLabel("De thi");
        
        JPanel pn_table_left = new JPanel();
        pn_table_left.setLayout(new BorderLayout());
        
        Object[][] data_left = {
            {"L1", "CNTT"},
            {"L1", "CNTT"},};

//        model_left = new DefaultTableModel(data_left, columns);
        table_left = new JTable(model_left) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        JScrollPane scrollPane_table_left = new JScrollPane(table_left);
        pn_table_left.add(scrollPane_table_left, BorderLayout.CENTER);
//        --------------------------------------
        JPanel pn_table_right = new JPanel();
        
        pn_table_right.setLayout(new BorderLayout());
        
        Object[][] data_right = {
            {"L1", "CNTT"},
            {"L1", "CNTT"},};
        
        model_right = new DefaultTableModel();
        model_right.addColumn("Mã câu hỏi");
        model_right.addColumn("Nội dung");
        table_right = new JTable(model_right) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        JScrollPane scrollPane_table_right = new JScrollPane(table_right);
        pn_table_right.add(scrollPane_table_right, BorderLayout.CENTER);
        
        JPanel pn_btn_center = new JPanel();
        pn_btn_center.setLayout(new BoxLayout(pn_btn_center, 1));
        pn_btn_center.setPreferredSize(new Dimension(100, 0));
        
        pn_btn_center.add(Box.createVerticalGlue());
        
        btnThem = new JButton();
        btnThem.setBorderPainted(false);
        btnThem.setFocusPainted(false);
        btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnThem.setIcon(createResizedIcon(FrameThemCHVaoDe.class, "..//image//right-icon.png", 20, 20));
        pn_btn_center.add(btnThem);
        
        pn_btn_center.add(Box.createVerticalStrut(20));
        
        btnXoa = new JButton();
        btnXoa.setBorderPainted(false);
        btnXoa.setFocusPainted(false);
        btnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnXoa.setIcon(createResizedIcon(FrameThemCHVaoDe.class, "..//image//left-icon.png", 20, 20));
        pn_btn_center.add(btnXoa);
        pn_btn_center.add(Box.createVerticalGlue());
        
        layout_table.setHorizontalGroup(
                layout_table.createSequentialGroup()
                        .addGroup(layout_table.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lb_khoCH)
                                .addComponent(pn_table_left))
                        .addComponent(pn_btn_center)
                        .addGroup(layout_table.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lb_deThi)
                                .addComponent(pn_table_right))
        );
        
        layout_table.setVerticalGroup(
                layout_table.createSequentialGroup()
                        .addGroup(layout_table.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_khoCH)
                                .addComponent(lb_deThi))
                        .addGroup(layout_table.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(pn_table_left)
                                .addComponent(pn_table_right)
                                .addComponent(pn_btn_center)
                        )
        );
        
        JPanel pn_btn = new JPanel(new FlowLayout(0, 10, 10));
        btnHoanThanh = new JButton("Hoàn thành");
        btnHoanThanh.setBorderPainted(false);
        btnHoanThanh.setFocusPainted(false);
        btnHoanThanh.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pn_btn.add(btnHoanThanh);
        
        this.getContentPane().add(pn_header, BorderLayout.NORTH);
        this.getContentPane().add(pn_table, BorderLayout.CENTER);
        this.getContentPane().add(pn_btn, BorderLayout.SOUTH);
        
        this.setVisible(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public void loadTable_Left() throws SQLException {
        ch = new cauHoiBUS();
        model_left = new DefaultTableModel();
        model_left.addColumn("Mã câu hỏi");
        model_left.addColumn("Nội dung");
        String maMon = new monBUS().layMaMonTheoTenMon(tenMon.trim());
        String maKho = new khoCauHoiBUS().layMaKhoCHTheoMaMon(maMon);
        
        for (cauHoiDTO x : ch.layDanhSachCauHoi()) {
            if (x.getMaKho().equalsIgnoreCase(maKho)) {
                model_left.addRow(new Object[]{x.getMaCH(), x.getNoidung()});
                
            }
        }
        table_left.setModel(model_left);
        this.revalidate();
        this.repaint();
    }
    
    public void loadTable_Right() throws SQLException {
        ch = new cauHoiBUS();
        model_right = new DefaultTableModel();
        model_right.addColumn("Mã câu hỏi");
        model_right.addColumn("Nội dung");
        for (cauHoiDTO x : ch.layDanhSachCauHoi()) {
            for (String y : dsMaCH) {
                if (x.getMaCH().equalsIgnoreCase(y)) {
                    model_right.addRow(new Object[]{x.getMaCH(), x.getNoidung()});
                }
            }
        }
        table_right.setModel(model_right);
        this.revalidate();
        this.repaint();
    }
    
    public void luuCauHoiDaChon() throws SQLException {
        int selectedRow = table_left.getSelectedRow();
        if (selectedRow != -1) {
            String maCH = table_left.getValueAt(selectedRow, 0).toString();
            for (String x : dsMaCH) {
                if (x.equalsIgnoreCase(maCH)) {
                    new ShowDiaLog("Câu hỏi đã được chọn!", ShowDiaLog.ERROR_DIALONG);
                    return;
                }
            }
            dsMaCH.add(maCH);
        }
    }
    
    public void xoaCauHoiDaChon() throws SQLException {
        String tmp = "";
        int selectedRow = table_right.getSelectedRow();
        if (selectedRow != -1) {
            String maCH = table_right.getValueAt(selectedRow, 0).toString();
            for (String x : dsMaCH) {
                if (x.equalsIgnoreCase(maCH)) {
                    tmp = x;
                }
            }
            dsMaCH.remove(tmp);
        }
    }
    
    public ArrayList<cauHoiDTO> timKiem(ArrayList<cauHoiDTO> ds, String tuKhoa) throws SQLException {
        ArrayList<cauHoiDTO> ketQua = new ArrayList<>();
        
        for (cauHoiDTO x : new cauHoiBUS().layDanhSachCauHoi()) {
            if (x.getMaCH().toLowerCase().contains(tuKhoa) || x.getNoidung().toLowerCase().contains(tuKhoa)) {
                ketQua.add(x);
            }
        }
        
        return ketQua;
    }
    
    public void loadTable_LeftTheoCmb(String ma) throws SQLException {
        ch = new cauHoiBUS();
        model_left = new DefaultTableModel();
        model_left.addColumn("Mã câu hỏi");
        model_left.addColumn("Nội dung");
        System.out.println("2");
        for (cauHoiDTO x : ch.layDanhSachCauHoi()) {
            System.out.println(x.getMaGV());
            if (x.getMaGV().equalsIgnoreCase(ma)) {
                System.out.println("4");
                model_left.addRow(new Object[]{x.getMaCH(), x.getNoidung()});
                
            }
        }
        table_left.setModel(model_left);
        this.revalidate();
        this.repaint();
    }
    
    public void addEvent() {
//        this.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                dsMaCH.clear();
//            }
//        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    luuCauHoiDaChon();
                    loadTable_Left();
                    loadTable_Right();
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    xoaCauHoiDaChon();
                    loadTable_Left();
                    loadTable_Right();
                    
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        txt_ndCH.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    model_left = new DefaultTableModel();
                    String[] str = {"Mã câu hỏi", "Nội dung"};
                    for (String s : str) {
                        model_left.addColumn(s);
                    }
                    try {
                        ArrayList<cauHoiDTO> ketQua = timKiem(new cauHoiBUS().layDanhSachCauHoi(), txt_ndCH.getText());
                        for (cauHoiDTO y : ketQua) {
                            model_left.addRow(new Object[]{
                                y.getMaCH(),
                                y.getNoidung()
                            });
                            break;
                        }
                        
                        table_left.setModel(model_left);
                        ketQua.clear();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        
                    }
                }
            }
        });
        cbb_nguoiTao.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String luaChon = cbb_nguoiTao.getSelectedItem().toString();
                if (luaChon.equalsIgnoreCase("Tất cả giảng viên")) {
                    try {
                        loadTable_Left();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        System.out.println("1");
                        loadTable_LeftTheoCmb(maTK);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        btnHoanThanh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setDsMaCH(dsMaCH);
                JFrame closingFrame = (JFrame) SwingUtilities.getWindowAncestor((JButton)e.getSource());
                // Đóng frame
                closingFrame.dispose();
            }
        });
    }
    
    public static void main(String[] args) throws SQLException {
        new FrameThemCHVaoDe();
    }
    
}
