/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.*;
import DTO.*;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
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
public class PnDSLopGV extends JPanel implements ActionListener {

    private DefaultTableModel model;
    private JComboBox<String> cbb_trangThai;
    private String maGV;
    private Object[] columns = {"Mã lớp", "Tên lớp", "Tên môn", "Năm học", "Học kỳ"};
    private JTable table;
    private JTextField txt_timKiem;
    private ArrayList<String> dsLopGV = new ArrayList<>();

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

    public Object[] getColumns() {
        return columns;
    }

    public void setColumns(Object[] columns) {
        this.columns = columns;
    }

    public PnDSLopGV(String maGV) throws SQLException {
        this.maGV = maGV;
        init();
        loadDSLopGV(true);
        addEvent();
    }

    public void init() {
        this.setLayout(new BorderLayout());

        JPanel pnHeader = new JPanel();
        pnHeader.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pnHeader.setPreferredSize(new Dimension(0, 40));
        pnHeader.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        JLabel lb_trangThaiLop = new JLabel("Trạng thái:");
        String[] cacTrangThai = new String[]{"Đang dạy", "Đã dạy"};
        cbb_trangThai = new JComboBox<>(cacTrangThai);
//        ChangeTableLopGV listener = new ChangeTableLopGV(this);
        cbb_trangThai.addActionListener(this);

        JLabel lb_timKiem = new JLabel("Tìm kiếm:");
        txt_timKiem = new JTextField(15);

        pnHeader.add(lb_trangThaiLop);
        pnHeader.add(cbb_trangThai);
        pnHeader.add(lb_timKiem);
        pnHeader.add(txt_timKiem);

        JPanel pnTable = new JPanel();
        pnTable.setLayout(new BorderLayout());

        Object[][] data = {
            {"L1", "CNTT", "Toán", "2024", "1"},};

//        model = new DefaultTableModel(data, columns);
        table = new JTable(model) {
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
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedOption = (String) getCbb_trangThai().getSelectedItem();
        if (selectedOption.equals("Đang dạy")) {
            // Dữ liệu mới khi lựa chọn là Option 1
            try {
                loadDSLopGV(true);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (selectedOption.equals(
                "Đã dạy")) {
            // Dữ liệu mới khi lựa chọn là Option 2
            try {
                loadDSLopGV(false);

            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public void addEvent() throws SQLException {
        cbb_trangThai.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String selectedOption = (String) cbb_trangThai.getSelectedItem();
                    try {
                        if (selectedOption.equals("Đang dạy")) {
                            loadDSLopGV(true);

                        } else if (selectedOption.equals("Đã dạy")) {
                            loadDSLopGV(false);
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        txt_timKiem.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (cbb_trangThai.getSelectedItem().equals("Đang dạy")) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        model = new DefaultTableModel();
                        for (Object x : columns) {
                            model.addColumn(x);
                        }

                        try {
                            ArrayList<lopDTO> ketQua = timKiem(new lopBUS().layDanhSachLopTheoMaGV(maGV), txt_timKiem.getText(), true);
                            for (lopDTO x : ketQua) {
                                if (x.getTrangThai() == true) {
                                    model.addRow(new Object[]{x.getMaLop(), x.getNhomLop(), new monBUS().layTenMonTheoMaMon(x.getMaMon()), x.getNam(), x.getHocKy()});
                                }
                            }

                            table.setModel(model);
                            table.revalidate();
                            table.repaint();
                            ketQua.clear();
                        } catch (SQLException ex) {
                            ex.printStackTrace();

                        }
                    }
                } else {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        model = new DefaultTableModel();
                        for (Object x : columns) {
                            model.addColumn(x);
                        }
                        try {
                            ArrayList<lopDTO> ketQua = timKiem(new lopBUS().layDanhSachLopTheoMaGV(maGV), txt_timKiem.getText(), false);
                            for (lopDTO x : ketQua) {
                                if (x.getTrangThai() == false) {
                                    model.addRow(new Object[]{x.getMaLop(), x.getNhomLop(), new monBUS().layTenMonTheoMaMon(x.getMaMon()), x.getNam(), x.getHocKy()});
                                }
                            }

                            table.setModel(model);
                            table.revalidate();
                            table.repaint();
                            ketQua.clear();
                        } catch (SQLException ex) {
                            ex.printStackTrace();

                        }
                    }
                }
            }
        }
        );
    }

    public ArrayList<lopDTO> timKiem(ArrayList<lopDTO> ds, String tuKhoa, boolean TrangThai) throws SQLException {
        ArrayList<lopDTO> ketQua = new ArrayList<>();

        for (lopDTO x : ds) {
            if (x.getTrangThai() == TrangThai) {
                if (x.getMaLop().toLowerCase().contains(tuKhoa) || Integer.toString(x.getNhomLop()).contains(tuKhoa) || new monBUS().layTenMonTheoMaMon(x.getMaMon()).toLowerCase().contains(tuKhoa) || Integer.toString(x.getHocKy()).contains(tuKhoa) || Integer.toString(x.getNam()).contains(tuKhoa)) {
                    ketQua.add(x);
                }
            }

        }

        return ketQua;
    }

    public void loadDSLopGV(boolean isTeaching) throws SQLException {
        System.out.println("há");
        model = new DefaultTableModel();
        for (Object x : columns) {
            model.addColumn(x);
        }

        for (lopDTO x : new lopBUS().layDanhSachLopTheoMaGV(maGV)) {
            if (x.getTrangThai() == isTeaching) {
                System.out.println("A");
                model.addRow(new Object[]{x.getMaLop().trim(), x.getNhomLop(), new monBUS().layTenMonTheoMaMon(x.getMaMon()), x.getNam(), x.getHocKy()});
                System.out.println(model);
            }
        }

        table.setModel(model);
        table.revalidate();
        table.repaint();
    }

    public static void main(String[] args) throws SQLException {
        JFrame f = new JFrame();
        f.setSize(800, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.getContentPane().add(new PnDSLopGV("TK4"));
        f.setVisible(true);
    }
}
