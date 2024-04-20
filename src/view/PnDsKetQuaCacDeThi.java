/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
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
public class PnDsKetQuaCacDeThi extends JPanel{
    private DefaultTableModel model;
    private JTextField txt_mon;
    private JTextField txt_nam;
    private JComboBox<String> cbb_hocKy;
    private JTextField txt_maDe;
    public PnDsKetQuaCacDeThi(){
        init();
    }
    
    public void init(){
        this.setLayout(new BorderLayout());
        JPanel pn_header = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        
        JLabel lb_maDe = new JLabel("Mã đề:");
        txt_maDe = new JTextField(10);
        JLabel lb_mon = new JLabel("Tên môn:");
        txt_mon = new JTextField(10);
        JLabel lb_nam = new JLabel("Năm:");
        txt_nam = new JTextField(10);
        JLabel lb_hocKy = new JLabel("Học kỳ:");
        cbb_hocKy = new JComboBox<>(new String[]{"1", "2"});
        cbb_hocKy.setPreferredSize(new Dimension(100,cbb_hocKy.getPreferredSize().height));
        
        pn_header.add(lb_maDe);
        pn_header.add(txt_maDe);
        
        pn_header.add(lb_mon);
        pn_header.add(txt_mon);
        pn_header.add(lb_nam);
        pn_header.add(txt_nam);
        pn_header.add(lb_hocKy);
        pn_header.add(cbb_hocKy);

        JPanel pn_table = new JPanel(new BorderLayout());

        Object[][] data = {
                {"D1", "Kiểm tra giữa kỳ","Cấu trúc dữ liệu","Lý Mạc Sầu","19-4-2024","2024","2"},
        };
        Object[] columns = {"Mã đề", "Tên đề","Môn","Người tạo đề","Ngày làm bài","Năm","Học kỳ"};
        
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
        
        this.add(pn_header, BorderLayout.NORTH);
        this.add(pn_table, BorderLayout.CENTER);
  
    }
    
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(800, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.getContentPane().add( new PnDsKetQuaCacDeThi());
        f.setVisible(true);
    }
}
