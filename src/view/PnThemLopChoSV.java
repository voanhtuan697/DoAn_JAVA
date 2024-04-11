/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

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
import model.DisabledTableCellRenderer;

/**
 *
 * @author E7250
 */
public class PnThemLopChoSV extends JPanel{
    private DefaultTableModel model;
    private JComboBox<String> cbb_trangThai;
    private String maSV;
    
    public PnThemLopChoSV() {
        init();
    }
    
    public void init(){
        this.setSize(500,380);
        this.setLayout(new BorderLayout());
        
        JPanel pnHeader = new JPanel();
        pnHeader.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pnHeader.setPreferredSize(new Dimension(0, 40));
        pnHeader.setLayout(new FlowLayout(FlowLayout.LEFT,20, 10));

        JLabel lb_trangThaiLop = new JLabel("Trạng thái:");
        String[] cacTrangThai = new String[]{"Đang học", "Đã học"};
        cbb_trangThai = new JComboBox<>(cacTrangThai);

        JLabel lb_timKiem = new JLabel("Tìm kiếm:");
        JTextField txt_timKiem = new JTextField(15);
        
        pnHeader.add(lb_trangThaiLop);
        pnHeader.add(cbb_trangThai);
        pnHeader.add(lb_timKiem);
        pnHeader.add(txt_timKiem);
        
        JPanel pnTable = new JPanel();
        pnTable.setLayout(new BorderLayout());
        
        Object[][] data = {
            {"L1", "CNTT", "Lý Mạc Sầu", "Toán","2024","1"},
            
            
            };
        Object[] columns = {"Mã lớp", "Tên lớp", "Tên giảng viên", "Tên môn","Năm học","Học kỳ"};
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
        
        JPanel pn_input = new JPanel();
        pn_input.setLayout(new FlowLayout(0,10,10));
        
        JLabel lb_mon = new JLabel("Ten lop");
        JTextField txt_mon = new JTextField(15);
        
        JComboBox<String> cbb_maMon = new JComboBox<>();
        cbb_maMon.setPreferredSize(new Dimension(100,cbb_maMon.getPreferredSize().height));
        
        pn_input.add(lb_mon);
        pn_input.add(txt_mon);
        pn_input.add(cbb_maMon);

        String []btn_name = new String[]{"Them","Xoa","Sua"};
        for(int i=0;i<3;i++){
            JButton btn = new JButton(btn_name[i]);
            pn_input.add(btn);
        }
        
        this.add(pnHeader,BorderLayout.NORTH);
        this.add(pnTable,BorderLayout.CENTER);
        this.add(pn_input,BorderLayout.SOUTH);
        
        
    }
    
    
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(800, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PnThemLopChoSV p = new PnThemLopChoSV();
        f.getContentPane().setLayout(new BorderLayout());
        f.add(p);
        f.setVisible(true);
    }
}
