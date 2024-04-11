/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import model.DisabledTableCellRenderer;

/**
 *
 * @author E7250
 */
public class PnThemLop extends JPanel {

    private DefaultTableModel model;
    private JComboBox<String> cbb_trangThai;
    private String maGV;
    private Object[] columns = {"Mã lớp", "Tên lớp", "Tên giảng viên", "Tên môn", "Năm học", "Học kỳ", "Số lượng"};

    public PnThemLop() {
        init();

    }

    public void init() {
        this.setLayout(new BorderLayout());
        JPanel pn_header = new JPanel();
        pn_header.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pn_header.setPreferredSize(new Dimension(0, 40));
        pn_header.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        JLabel lb_trangThai = new JLabel("Trạng thái: ");
        String[] cacTrangThai = new String[]{"Đang mở", "Đã kết thúc"};
        cbb_trangThai = new JComboBox<>(cacTrangThai);

        JLabel lb_timKiem = new JLabel("Tìm kiếm:");
        JTextField txt_timKiem = new JTextField(15);

        pn_header.add(lb_trangThai);
        pn_header.add(cbb_trangThai);
        pn_header.add(lb_timKiem);
        pn_header.add(txt_timKiem);

//        pn table
        JPanel pn_table = new JPanel();
        pn_table.setLayout(new BorderLayout());

        Object[][] data = {
            {"L1", "CNTT", "Lý Mạc Sầu", "Toán", "2024", "1", "100"},};

        model = new DefaultTableModel(data, columns);

        JTable table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };;
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new DisabledTableCellRenderer());
        }

        JScrollPane scrollPane_table = new JScrollPane(table);
        pn_table.add(scrollPane_table, BorderLayout.CENTER);

        JPanel pn_input = new JPanel();
        pn_input.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pn_input.setPreferredSize(new Dimension(0, 140));

        JPanel pn_input_left = new JPanel();
        JPanel pn_input_center = new JPanel();
        JPanel pn_input_right = new JPanel();

        GroupLayout layout_input = new GroupLayout(pn_input);
        pn_input.setLayout(layout_input);

        layout_input.setHorizontalGroup(
                layout_input.createSequentialGroup()
                        .addComponent(pn_input_left)
                        .addComponent(pn_input_center)
                        .addComponent(pn_input_right)
        );

        layout_input.setVerticalGroup(
                layout_input.createSequentialGroup()
                        .addGroup(layout_input.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(pn_input_left)
                                .addComponent(pn_input_center)
                                .addComponent(pn_input_right))
        );

        JLabel lb_lop = new JLabel("Ten lop:");
        JLabel lb_mon = new JLabel("Mon:");
        JLabel lb_empty1 = new JLabel("      ");
        JLabel lb_nam = new JLabel("Nam:");
        JLabel lb_hocKy = new JLabel("Hoc ky:");
        JLabel lb_maGV = new JLabel("Giang vien:");
        JLabel lb_empty2 = new JLabel("      ");
        JLabel lb_soLuong = new JLabel("So luong:");

        JTextField txt_lop = new JTextField(10);
        txt_lop.setPreferredSize(new Dimension(0, 25));
        JTextField txt_mon = new JTextField(10);
        txt_mon.setPreferredSize(new Dimension(0, 25));
        JComboBox<String> cbb_mon = new JComboBox<>();
        cbb_mon.setPreferredSize(new Dimension(150, cbb_mon.getPreferredSize().height));
        JTextField txt_nam = new JTextField(20);
        txt_nam.setPreferredSize(new Dimension(0, 25));

        JComboBox<String> cbb_hocKy = new JComboBox<>(new String[]{"1", "2"});
        cbb_hocKy.setPreferredSize(new Dimension(150, cbb_hocKy.getPreferredSize().height));
        JTextField txt_maGV = new JTextField(10);
        txt_maGV.setPreferredSize(new Dimension(0, 25));
        JComboBox<String> cbb_maGV = new JComboBox<>();
        cbb_maGV.setPreferredSize(new Dimension(192, cbb_maGV.getPreferredSize().height));
        JTextField txt_soLuong = new JTextField(10);
        txt_soLuong.setPreferredSize(new Dimension(0, 25));
        pn_input_left.setPreferredSize(new Dimension(300, 0));
        GroupLayout layout_left = new GroupLayout(pn_input_left);
        pn_input_left.setLayout(layout_left);
        layout_left.setAutoCreateGaps(true);
        layout_left.setAutoCreateContainerGaps(true);

        layout_left.setHorizontalGroup(
                layout_left.createSequentialGroup()
                        .addGroup(layout_left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lb_lop)
                                .addComponent(lb_mon)
                                .addComponent(lb_empty1)
                                .addComponent(lb_nam))
                        .addGroup(layout_left.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(txt_lop)
                                .addComponent(txt_mon)
                                .addComponent(cbb_mon)
                                .addComponent(txt_nam))
        );

        layout_left.setVerticalGroup(
                layout_left.createSequentialGroup()
                        .addGroup(layout_left.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_lop)
                                .addComponent(txt_lop))
                        .addGroup(layout_left.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_mon)
                                .addComponent(txt_mon))
                        .addGroup(layout_left.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_empty1)
                                .addComponent(cbb_mon))
                        .addGroup(layout_left.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_nam)
                                .addComponent(txt_nam))
        );

        pn_input_center.setPreferredSize(new Dimension(300, 0));
        GroupLayout layout_center = new GroupLayout(pn_input_center);
        pn_input_center.setLayout(layout_center);
        layout_center.setAutoCreateGaps(true);
        layout_center.setAutoCreateContainerGaps(true);

        layout_center.setHorizontalGroup(
                layout_center.createSequentialGroup()
                        .addGroup(layout_center.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lb_hocKy)
                                .addComponent(lb_maGV)
                                .addComponent(lb_empty2)
                                .addComponent(lb_soLuong))
                        .addGroup(layout_center.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(cbb_hocKy)
                                .addComponent(txt_maGV)
                                .addComponent(cbb_maGV)
                                .addComponent(txt_soLuong))
        );
        layout_center.setVerticalGroup(
                layout_center.createSequentialGroup()
                        .addGroup(layout_center.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_hocKy)
                                .addComponent(cbb_hocKy))
                        .addGroup(layout_center.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_maGV)
                                .addComponent(txt_maGV))
                        .addGroup(layout_center.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_empty2)
                                .addComponent(cbb_maGV))
                        .addGroup(layout_center.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_soLuong)
                                .addComponent(txt_soLuong))
        );

        pn_input_right.setMaximumSize(new Dimension(100, 0));
        GroupLayout layout_right = new GroupLayout(pn_input_right);
        pn_input_right.setLayout(layout_right);
        layout_right.setAutoCreateGaps(true);
        layout_right.setAutoCreateContainerGaps(true);

        Font fontBtn = new Font("Arial", Font.BOLD, 10);
        String[] name_btn = new String[]{"Thêm", "Xóa", "Sửa", "Lop ket thuc"};
        JButton btn_them = new JButton("Them");
        btn_them.setMaximumSize(new Dimension(106, 25));
        JButton btn_xoa = new JButton("Xóa");
        btn_xoa.setMaximumSize(new Dimension(106, 25));
        JButton btn_sua = new JButton("Sửa");
        btn_sua.setMaximumSize(new Dimension(106, 25));
        JButton btn_ketThuc = new JButton("Lop ket thuc");
        btn_ketThuc.setMaximumSize(new Dimension(106, 25));


        layout_right.setHorizontalGroup(
                layout_right.createSequentialGroup()
                        .addGroup(layout_right.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(btn_them)
                                .addComponent(btn_xoa)
                                .addComponent(btn_sua)
                                .addComponent(btn_ketThuc))
        );
        layout_right.setVerticalGroup(
                layout_right.createSequentialGroup()
                        .addComponent(btn_them)
                        .addComponent(btn_xoa)
                        .addComponent(btn_sua)
                        .addComponent(btn_ketThuc)
        );

        this.add(pn_header, BorderLayout.NORTH);
        this.add(pn_table, BorderLayout.CENTER);
        this.add(pn_input, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        PnThemLop b = new PnThemLop();
        f.add(b);
        f.setSize(800, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
//        f.pack();
//        f.setResizable(false);
        f.setLocationRelativeTo(null);
    }

}
