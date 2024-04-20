/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import static javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION;
import static javax.swing.border.TitledBorder.DEFAULT_POSITION;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static model.base.font13;
import static model.base.font14;
import static model.base.gray_bg;

public class PnThongTinGV extends JPanel {

    private JLabel lblHoten, lblNgaySinh;
    private JPanel pnthongtincn, pnphutrach;
    private DefaultTableModel modelMH, modelLop;
    String[] lblThongtin = {"Họ và tên", "Ngày sinh:"};
    private JLabel[] lblJ = new JLabel[2];
//    private Color colorPink = Color.decode("#DA91A4");
//    private Color colorGray = Color.decode("#B3BECB");
//    Font font = new Font("Segoe UI", Font.PLAIN, 14);

    public PnThongTinGV() {
        init();
        initComponent();
        showLayout();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setBackground(gray_bg);

        pnthongtincn = new JPanel();
        pnthongtincn.setBorder(BorderFactory.createTitledBorder(null, "Thông tin cá nhân của giảng viên", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font14) {
        }));
        pnthongtincn.setBackground(gray_bg);

        pnphutrach = new JPanel(new GridLayout(2, 1));
        pnphutrach.setBorder(BorderFactory.createTitledBorder(null, "Quản lý giảng dạy", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font14) {
        }));
        pnphutrach.setBackground(gray_bg);

        this.add(pnthongtincn, BorderLayout.WEST);
        this.add(pnphutrach, BorderLayout.CENTER);
    }

    private void initComponent() {
        for (int i = 0; i < lblThongtin.length; i++) {
            lblJ[i] = new JLabel(lblThongtin[i]);
            lblJ[i].setFont(font13);
        }
        lblHoten = new JLabel("Nguyễn Thanh Tùng");
        lblHoten.setFont(font13);
        lblNgaySinh = new JLabel("05/07/1994");
        lblNgaySinh.setFont(font13);

        JPanel pnMonhoc = new JPanel(new BorderLayout());
        pnMonhoc.setBorder(BorderFactory.createTitledBorder(null, "Môn phụ trách", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font14) {
        }));
        pnMonhoc.setBackground(gray_bg);

        Object[] columnsMH = {"ID", "Tên môn dạy"};
        Object[][] dataMH = {{null, null}, {null, null}, {null, null}, {null, null}, {null, null}};
        modelMH = new DefaultTableModel(dataMH, columnsMH);
        JTable tableMH = new JTable(modelMH);
        int[] columnWidths = {80, 150};
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = tableMH.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
        JScrollPane scrMH = new JScrollPane(tableMH);
        pnMonhoc.add(scrMH);

        JPanel pnLop = new JPanel(new BorderLayout());
        pnLop.setBorder(BorderFactory.createTitledBorder(null, "Lớp phụ trách", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font14) {
        }));
        pnLop.setBackground(gray_bg);
        Object[] columnsLop = {"ID", "Tên Lớp dạy"};
        Object[][] dataLop = {{null, null}, {null, null}, {null, null}, {null, null}, {null, null}};
        modelLop = new DefaultTableModel(dataLop, columnsLop);
        JTable tableLop = new JTable(modelLop);
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = tableLop.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
        JScrollPane scrLop = new JScrollPane(tableLop);
        pnLop.add(scrLop);

        pnphutrach.add(pnMonhoc);
        pnphutrach.add(pnLop);

        modelMH.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (modelMH.getRowCount() == 0) {
                    tableMH.setBackground(Color.decode("#024F8E"));
                } else {
                    tableMH.setBackground(Color.WHITE);
                }
            }
        });

        modelLop.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                if (modelLop.getRowCount() == 0) {
                    tableLop.setBackground(Color.decode("#024F8E"));
                } else {
                    tableLop.setBackground(Color.WHITE);
                }
            }
        });
    }

    private void showLayout() {
        GroupLayout layout = new GroupLayout(pnthongtincn);
        pnthongtincn.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblJ[0])
                        .addComponent(lblJ[1])
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblHoten)
                        .addComponent(lblNgaySinh)
                )
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblJ[0])
                        .addComponent(lblHoten)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblJ[1])
                        .addComponent(lblNgaySinh)
                )
        );

    }

}
