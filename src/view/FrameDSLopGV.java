/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ChangeTableLopGV;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
public class FrameDSLopGV extends JFrame{
    private DefaultTableModel model;
    private JComboBox<String> cbb_trangThai;
    private String maGV;
    private Object[] columns = {"Mã lớp", "Tên lớp", "Tên môn","Năm học","Học kỳ"};

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
    
    
    
    public FrameDSLopGV(String maGV){
        this.maGV = maGV;
        init();
    }
    
    public void init(){
        this.setTitle(maGV);
        this.setSize(500,380);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());
        
        JPanel pnHeader = new JPanel();
        pnHeader.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pnHeader.setPreferredSize(new Dimension(0, 40));
        pnHeader.setLayout(new FlowLayout(FlowLayout.LEFT,20, 10));

        JLabel lb_trangThaiLop = new JLabel("Trạng thái:");
        String[] cacTrangThai = new String[]{"Đang dạy", "Đã dạy"};
        cbb_trangThai = new JComboBox<>(cacTrangThai);
        ChangeTableLopGV listener =new ChangeTableLopGV(this);
        cbb_trangThai.addActionListener(listener);


        JLabel lb_timKiem = new JLabel("Tìm kiếm:");
        JTextField txt_timKiem = new JTextField(15);
        
        pnHeader.add(lb_trangThaiLop);
        pnHeader.add(cbb_trangThai);
        pnHeader.add(lb_timKiem);
        pnHeader.add(txt_timKiem);
        
        JPanel pnTable = new JPanel();
        pnTable.setLayout(new BorderLayout());
        
        Object[][] data = {     
            {"L1", "CNTT", "Toán", "2024", "1"},    
            };
        
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
        pnTable.add(scrollPane_table, BorderLayout.CENTER);
        
        this.getContentPane().add(pnHeader,BorderLayout.NORTH);
        this.getContentPane().add(pnTable,BorderLayout.CENTER);
        
        
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new FrameDSLopGV("ddd");
    }
}
