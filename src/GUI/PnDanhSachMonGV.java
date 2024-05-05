/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.monBUS;
import DTO.monDTO;
import static GUI.BASE.clTable;
import static GUI.BASE.font16;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class PnDanhSachMonGV extends JPanel {

    private DefaultTableModel model;
    private String maGV;
    private Object[] columns = {"Mã môn", "Tên môn"};
    private monBUS busMon;

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public Object[] getColumns() {
        return columns;
    }

    public void setColumns(Object[] columns) {
        this.columns = columns;
    }

    public PnDanhSachMonGV(String maGV) throws SQLException {
        this.maGV = maGV;
        busMon = new monBUS();
        init();
        loadData();
    }

    public void init() {
        this.setLayout(new BorderLayout());

        JPanel pnHeader = new JPanel();
        pnHeader.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pnHeader.setPreferredSize(new Dimension(0, 40));
        pnHeader.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

//        ChangeTableLopGV listener =new ChangeTableLopGV(this);
//        cbb_trangThai.addActionListener(listener);
        JLabel lb_timKiem = new JLabel("Tìm kiếm:");
        lb_timKiem.setFont(font16);
        JTextField txt_timKiem = new JTextField(15);
        txt_timKiem.setFont(font16);

        pnHeader.add(lb_timKiem);
        pnHeader.add(txt_timKiem);

        JPanel pnTable = new JPanel();
        pnTable.setLayout(new BorderLayout());

        JTable table = new JTable();
     
        model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
       
        
     
        table = new JTable(model);
        
        setTableFont(table);
        JScrollPane scrollPane_table = new JScrollPane(table);
        pnTable.add(scrollPane_table, BorderLayout.CENTER);

        this.add(pnHeader, BorderLayout.NORTH);
        this.add(pnTable, BorderLayout.CENTER);

        this.setVisible(true);

        txt_timKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = txt_timKiem.getText();
                if (!key.isEmpty()) {
                    TimKiem(key);
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
        header.setBackground(clTable);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setFont(font16);
        table.setDefaultRenderer(Object.class, renderer);
        table.setRowHeight(30);
    }

    private void loadData() {
        model.setRowCount(0);
        ArrayList<monDTO> list = busMon.DSMon1GVDay(maGV);
        for (monDTO x : list) {
            Object[] row = {x.getMaMon(), x.getTenMon()};
            model.addRow(row);
        }
    }

    private void TimKiem(String key) {
        model.setRowCount(0);
        ArrayList<monDTO> list = busMon.TimKiemDSMon1GVDay(maGV, key);
        for (monDTO x : list) {
            Object[] row = {x.getMaMon(), x.getTenMon()};
            model.addRow(row);
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(800, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
//        f.getContentPane().add(new PnDanhSachMonGV("ddd"));
        f.setVisible(true);
    }
}
