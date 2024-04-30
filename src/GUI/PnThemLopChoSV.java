/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
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
public class PnThemLopChoSV extends JPanel{
    private DefaultTableModel model;
    private String maSV;
    
    public PnThemLopChoSV() {
        init();
    }
    
    public void init(){
        this.setLayout(new BorderLayout());
        
        JPanel pnHeader = new JPanel();
        pnHeader.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pnHeader.setPreferredSize(new Dimension(0, 40));
        pnHeader.setLayout(new FlowLayout(FlowLayout.LEFT,20, 10));


        JLabel lb_timKiem = new JLabel("Tìm kiếm tên sinh viên:");
        JTextField txt_timKiem = new JTextField(15);
        
        pnHeader.add(lb_timKiem);
        pnHeader.add(txt_timKiem);
        
        JPanel pnTable = new JPanel();
        pnTable.setLayout(new BorderLayout());
        
        Object[][] data = {
            {"SV1", "Tuấn","2024-01-01"},
            
            
            };
        Object[] columns = {"Mã Sinh viên",  "Tên sinh viên" , "Ngày sinh"};
        model = new DefaultTableModel(data, columns);
        
        JTable table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        JScrollPane scrollPane_table = new JScrollPane(table);
        pnTable.add(scrollPane_table, BorderLayout.CENTER);
        
        JPanel pn_input = new JPanel();
        pn_input.setLayout(new FlowLayout(0,10,10));
        
        JLabel lb_mon = new JLabel("Tên môn");
        JTextField txt_mon = new JTextField(15);
        JLabel lb_lop = new JLabel("Lớp:");
        JLabel lb_nam = new JLabel("Năm:");
        JComboBox<String> cbb_nam = new JComboBox<>();
        cbb_nam.setPreferredSize(new Dimension(80,cbb_nam.getPreferredSize().height));
        JLabel lb_hocKy = new JLabel("Học kỳ:");
        JComboBox<String> cbb_hocKy = new JComboBox<>(new String[]{"1", "2"});
        cbb_hocKy.setPreferredSize(new Dimension(50,cbb_hocKy.getPreferredSize().height));
        
        JComboBox<String> cbb_lop = new JComboBox<>();
        cbb_lop.setPreferredSize(new Dimension(130,cbb_lop.getPreferredSize().height));
        
        pn_input.add(lb_nam);
        pn_input.add(cbb_nam);
        pn_input.add(lb_hocKy);
        pn_input.add(cbb_hocKy);
        pn_input.add(lb_mon);
        pn_input.add(txt_mon);
        pn_input.add(lb_lop);
        pn_input.add(cbb_lop);

        JButton btn_them = new JButton("Them");
        pn_input.add(btn_them);
        
        this.add(pnHeader,BorderLayout.NORTH);
        this.add(pnTable,BorderLayout.CENTER);
        this.add(pn_input,BorderLayout.SOUTH);
    }
    
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(900, 500);
        PnThemLopChoSV p = new PnThemLopChoSV();
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
