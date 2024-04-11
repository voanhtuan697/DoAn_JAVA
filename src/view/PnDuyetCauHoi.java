/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
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
public class PnDuyetCauHoi extends JPanel{
    private DefaultTableModel model;
    public PnDuyetCauHoi(){
        init();
    }
    
    public void init(){
        this.setLayout(new BorderLayout());
        
        JPanel pn_header = new JPanel();
        pn_header.setLayout(new FlowLayout(0,10,10));
        pn_header.setBackground(Color.yellow);
        String tenMon = "Cơ sở dữ liệu";
        JLabel lb_mon = new JLabel("Ten mon: "+tenMon );
        String []trangThai = {"Chưa duyệt","Đã duyệt"};
        JComboBox cbb_trangThai = new JComboBox(trangThai);
        
        JPanel pnSearch = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        pnSearch.setBackground(Color.decode("#B3BECB"));
        
        JLabel lblSearch = new JLabel("Tìm kiếm");
//        lblSearch.setFont(font);
        JTextField txtSearch = new JTextField(15);
        
        
        
        pn_header.add(lb_mon);
        pn_header.add(cbb_trangThai);
        pn_header.add(lblSearch);
        pn_header.add(txtSearch);
        
//        -------------
        JPanel pn_table = new JPanel();
        pn_table.setLayout(new BorderLayout());

        Object[][] data = {
            {"CH1", "GV1", "Who are you?Who are you?", "Dễ"},
            {"CH1", "GV2", "Where do you do?", "Khó"},
            {"CH1", "GV3", "Will you marry me?", "Trung Bình"},
            {"CH1", "GV1", "Who are you?Who are you?", "Dễ"},
            {"CH1", "GV2", "Where do you do?", "Khó"},
            {"CH1", "GV3", "Will you marry me?", "Trung Bình"},
            {"CH1", "GV1", "Who are you?Who are you?", "Dễ"},
            {"CH1", "GV2", "Where do you do?", "Khó"},
            {"CH1", "GV3", "Will you marry me?", "Trung Bình"},
            {"CH1", "GV1", "Who are you?Who are you?", "Dễ"},
            {"CH1", "GV2", "Where do you do?", "Khó"},
            };

        // Tạo tiêu đề cho bảng
        Object[] columns = {"Mã câu hỏi", "Mã giảng viên", "Nội dung", "Độ khó","Ảnh"};
        model = new DefaultTableModel(data, columns);

//        Không cho người dùng tác động
        JTable table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };;

        // Thiết lập renderer cho tất cả các cột
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new DisabledTableCellRenderer());
        }
//        set chiều ngang cho cột
//        TableColumnModel columnModel = table.getColumnModel();
//        columnModel.getColumn(0).setPreferredWidth(60); // Mã câu hỏi
//        columnModel.getColumn(1).setPreferredWidth(80); // Mã giảng viên
//        columnModel.getColumn(2).setPreferredWidth(1000); // Nội dung
//        columnModel.getColumn(3).setPreferredWidth(70); // Độ khó

        JScrollPane scrollPane_table = new JScrollPane(table);
        pn_table.add(scrollPane_table, BorderLayout.CENTER);
        
        
        JPanel pn_btn = new JPanel();
        pn_btn.setLayout(new FlowLayout(0,10,10));
        pn_btn.setBackground(Color.yellow);
        String []name_btn = new String[]{"Xem chi tiết","Duyệt","Xóa","Sửa"};
        for (int i = 0; i < name_btn.length; i++) {
            JButton btn = new JButton(name_btn[i]);
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            pn_btn.add(btn);
        }
        
        this.add(pn_header,BorderLayout.NORTH);
        this.add(pn_table,BorderLayout.CENTER);
        this.add(pn_btn,BorderLayout.SOUTH);
        
    }
    
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(800, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PnDuyetCauHoi p = new PnDuyetCauHoi();
        f.getContentPane().setLayout(new BorderLayout());
        f.add(p);
        f.setVisible(true);
    }
}
