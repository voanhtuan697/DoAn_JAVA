/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class PnSinhvien extends JPanel {

    private JPanel pnSearch, pnTable, pnInput;
    private DefaultTableModel model;
    private JTextField txtSearch, txtMaQL, txtLop, txtHoTen, txtNgSinh, txtMonHoc;
    private JButton btnThem, btnSua, btnXoa, btnClear, btnNhap, btnXuat;
    private JLabel[] lbl = new JLabel[5];
    private String[] lblContent = {"Mã quản lý:", "Họ và tên:", "Môn học:", "Lớp:", "Ngày sinh:"};
    private Color colorGray = Color.decode("#B3BECB");
    private Color colorBtn = Color.decode("#009594");
    private Color colorPink = Color.decode("#DA91A4");
    Font font = new Font("Segoe UI", Font.PLAIN, 14);

    public PnSinhvien() {
        init();
        initComponent();
        showLayout();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        pnSearch = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        pnSearch.setBackground(colorGray);

        pnTable = new JPanel(new BorderLayout());

        pnInput = new JPanel();
        pnInput.setBackground(colorGray);

        this.add(pnSearch, BorderLayout.NORTH);
        this.add(pnTable, BorderLayout.CENTER);
        this.add(pnInput, BorderLayout.SOUTH);
    }

    private void initComponent() {
        JLabel lblSearch = new JLabel("Tìm kiếm");
        lblSearch.setFont(font);
        txtSearch = new JTextField(25);
        pnSearch.add(lblSearch);
        pnSearch.add(txtSearch);

        Object[] columns = {"Mã quản lý", "Họ và tên", "Môn học", "Ngày sinh", "Lớp"};
        Object[][] data = {{null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null}};
        model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);

        int[] columnWidths = {100, 200, 80, 100, 100};
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
        JScrollPane scrTabel = new JScrollPane(table);
        pnTable.add(scrTabel, BorderLayout.CENTER);

        for (int i = 0; i < lblContent.length; i++) {
            lbl[i] = new JLabel(lblContent[i]);
            lbl[i].setFont(font);
        }
        txtMaQL = new JTextField(25);
        txtLop = new JTextField(25);
        txtNgSinh = new JTextField(25);
        txtHoTen = new JTextField(25);
        txtMonHoc = new JTextField(25);

        btnThem = new JButton("     Thêm     ");
        btnThem.setBackground(colorBtn);

        btnXoa = new JButton("       Xóa      ");
        btnXoa.setBackground(colorBtn);
        btnNhap = new JButton("Nhập Excel");
        btnNhap.setBackground(colorBtn);
        btnXuat = new JButton("Xuất Excel");
        btnXuat.setBackground(colorBtn);
        btnSua = new JButton("    Sửa       ");
        btnSua.setBackground(colorBtn);
        btnClear = new JButton("    Clear     ");
        btnClear.setBackground(colorBtn);
    }

    private void showLayout() {
        GroupLayout layout = new GroupLayout(pnInput);
        pnInput.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lbl[0])
                        .addComponent(lbl[1])
                        .addComponent(lbl[2])
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(txtMaQL)
                        .addComponent(txtHoTen)
                        .addComponent(txtMonHoc)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lbl[4])
                        .addComponent(lbl[3])
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(txtLop)
                        .addComponent(txtNgSinh)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(btnThem)
                        .addComponent(btnXoa)
                        .addComponent(btnNhap)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(btnSua)
                        .addComponent(btnClear)
                        .addComponent(btnXuat)
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl[0])
                        .addComponent(txtMaQL)
                        .addComponent(lbl[4])
                        .addComponent(txtLop)
                        .addComponent(btnThem)
                        .addComponent(btnSua)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl[1])
                        .addComponent(txtHoTen)
                        .addComponent(lbl[3])
                        .addComponent(txtNgSinh)
                        .addComponent(btnXoa)
                        .addComponent(btnClear)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl[2])
                        .addComponent(txtMonHoc)
                        .addComponent(btnNhap)
                        .addComponent(btnXuat)
                )
        );
    }

}
