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
import javax.swing.JFrame;
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

public class PnThongTinGV extends JPanel {

    private JLabel lblHoten, lblNgaySinh;
    private JPanel pnthongtincn, pnphutrach;
    private DefaultTableModel modelMH, modelLop;
    String[] lblThongtin = {"Họ và tên", "Ngày sinh:"};
    private JLabel[] lblJ = new JLabel[2];
    private Color colorPink = Color.decode("#DA91A4");
    private Color colorGray = Color.decode("#B3BECB");
    Font font = new Font("Segoe UI", Font.PLAIN, 14);

    public PnThongTinGV() {
        init();
        initComponent();
        showLayout();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setBackground(colorPink);

        pnthongtincn = new JPanel();
        pnthongtincn.setBorder(BorderFactory.createTitledBorder(null, "Thông tin cá nhân của giảng viên", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font) {
        }));
        pnthongtincn.setBackground(colorPink);

        pnphutrach = new JPanel(new GridLayout(2, 1));
        pnphutrach.setBorder(BorderFactory.createTitledBorder(null, "Quản lý giảng dạy", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font) {
        }));
        pnphutrach.setBackground(colorPink);

        this.add(pnthongtincn, BorderLayout.WEST);
        this.add(pnphutrach, BorderLayout.CENTER);
    }

    private void initComponent() {
        for (int i = 0; i < lblThongtin.length; i++) {
            lblJ[i] = new JLabel(lblThongtin[i]);
            lblJ[i].setFont(font);
        }
        lblHoten = new JLabel("Nguyễn Thanh Tùng");
        lblHoten.setFont(font);
        lblNgaySinh = new JLabel("05/07/1994");
        lblNgaySinh.setFont(font);

        JPanel pnMonhoc = new JPanel(new BorderLayout());
        pnMonhoc.setBorder(BorderFactory.createTitledBorder(null, "Môn phụ trách", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font) {
        }));
        pnMonhoc.setBackground(colorPink);

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
        pnLop.setBorder(BorderFactory.createTitledBorder(null, "Lớp phụ trách", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font) {
        }));
        pnLop.setBackground(colorPink);
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
    
    public static void main(String[] args){
        JFrame f = new JFrame();
        f.setSize(950,450);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PnThongTinGV p = new PnThongTinGV();
        f.getContentPane().setLayout(new BorderLayout());
        f.add(p);
        f.setVisible(true);
    }

}
