/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static model.base.dark_green;
import static model.base.font13;
import static model.base.font13b;
import static model.base.gray_bg;
import static model.base.white;

public class  pnKetQua extends JPanel{
    private JPanel pnHeader, pnTable, pnInput;
    private JLabel[] lbl = new JLabel[4];
    private JTextField txtMonThi, txtDeThi, txtDiemTu, txtDiem;
    private JButton btnTimTheoDiem, btnXuat, btnVe;
    private DefaultTableModel model;
    private JRadioButton rdMax, rdMin, rdThi;
    private String[] lblContent = {"Môn thi:", "Đề thi:", "Điểm từ:", "Điểm"};

    public pnKetQua() {
        init();
        initComponent();
        showLayout();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        pnHeader = new JPanel();
        pnHeader.setBackground(gray_bg);

        pnTable = new JPanel(new BorderLayout());

        pnInput = new JPanel();
        pnInput.setBackground(gray_bg);

        this.add(pnHeader, BorderLayout.NORTH);
        this.add(pnTable, BorderLayout.CENTER);
        this.add(pnInput, BorderLayout.SOUTH);
    }

    private void initComponent() {

        Object[] columns = {"Mã thí sinh", "Họ và tên", "Điểm", "Lớp", "Môn"};
        Object[][] data = {{null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},};

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
            lbl[i].setFont(font13);
        }

        txtMonThi = new JTextField(20);
        txtDeThi = new JTextField(20);
        txtDiemTu = new JTextField(20);
        txtDiem = new JTextField(20);

        rdMax = new JRadioButton("Điểm cao nhất");
        rdMax.setBackground(gray_bg);
        rdMax.setFont(font13);
        rdMin = new JRadioButton("Điểm thấp nhất");
        rdMin.setBackground(gray_bg);
        rdMin.setFont(font13);
        rdThi = new JRadioButton("Thi lại");
        rdThi.setBackground(gray_bg);
        rdThi.setFont(font13);
        ButtonGroup group = new ButtonGroup();
        group.add(rdMax);
        group.add(rdMin);
        group.add(rdThi);

        btnXuat = new JButton("Xuất Excel  ");
        btnXuat.setBackground(dark_green);
        btnXuat.setFont(font13b);
        btnXuat.setForeground(white);
        btnXuat.setBorderPainted(false);
        btnXuat.setFocusPainted(false);
        btnXuat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        btnVe = new JButton("Vẽ biểu đồ");
        btnVe.setBackground(dark_green);
        btnVe.setForeground(white);
        btnVe.setFont(font13b);
        btnVe.setBorderPainted(false);
        btnVe.setFocusPainted(false);
        btnVe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        
        btnTimTheoDiem = new JButton("Tìm theo điểm");
        btnTimTheoDiem.setBackground(dark_green);
        btnTimTheoDiem.setFont(font13b);
        btnTimTheoDiem.setForeground(white);
        btnTimTheoDiem.setBorderPainted(false);
        btnTimTheoDiem.setFocusPainted(false);
        btnTimTheoDiem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(txtMonThi)
                        .addComponent(txtDeThi)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(rdMax)
                        .addComponent(rdMin)
                        .addComponent(rdThi)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lbl[2])
                        .addComponent(lbl[3])
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(txtDiemTu)
                        .addComponent(txtDiem)
                        .addComponent(btnTimTheoDiem)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(btnVe)
                        .addComponent(btnXuat)
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lbl[0])
                        .addComponent(txtMonThi)
                        .addComponent(rdMax)
                        .addComponent(lbl[2])
                        .addComponent(txtDiemTu)
                        .addComponent(btnVe)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(rdMin)
                                        .addComponent(lbl[3])
                                        .addComponent(txtDiem)
                                        .addComponent(btnXuat)
                                )
                        )
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lbl[1])
                        .addComponent(txtDeThi)
                        .addComponent(rdThi)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(btnTimTheoDiem)
                        )
                )
        );
    }
    
}
