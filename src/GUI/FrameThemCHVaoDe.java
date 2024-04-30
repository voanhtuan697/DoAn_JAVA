/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static GUI.BASE.createResizedIcon;


/**
 *
 * @author E7250
 */
public class FrameThemCHVaoDe extends JFrame {

    private DefaultTableModel model_left;
    private DefaultTableModel model_right;
    private Object[] columns = {"Mã câu hỏi", "Nội dung"};

    public FrameThemCHVaoDe() {
        init();
    }

    private void init() {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JPanel pn_header = new JPanel(new FlowLayout(0, 10, 10));
        JLabel lb_ndCH = new JLabel("Câu hỏi:");
        JTextField txt_ndCH = new JTextField(15);
        JLabel lb_nguoiTao = new JLabel("Câu hỏi tạo bởi:");
        String[] items = {"Tất cả giảng viên", "Chính mình"};
        JComboBox<String> cbb_nguoiTao = new JComboBox<>(items);
        pn_header.add(lb_ndCH);
        pn_header.add(txt_ndCH);
        pn_header.add(lb_nguoiTao);
        pn_header.add(cbb_nguoiTao);

        JPanel pn_table = new JPanel();
        GroupLayout layout_table = new GroupLayout(pn_table);
        pn_table.setLayout(layout_table);

        JLabel lb_khoCH = new JLabel("Kho cau hoi");
        JLabel lb_deThi = new JLabel("De thi");

        JPanel pn_table_left = new JPanel();
        pn_table_left.setLayout(new BorderLayout());

        Object[][] data_left = {
            {"L1", "CNTT"},
            {"L1", "CNTT"},};

        model_left = new DefaultTableModel(data_left, columns);

        JTable table_left = new JTable(model_left) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JScrollPane scrollPane_table_left = new JScrollPane(table_left);
        pn_table_left.add(scrollPane_table_left, BorderLayout.CENTER);
//        --------------------------------------
        JPanel pn_table_right = new JPanel();

        pn_table_right.setLayout(new BorderLayout());

        Object[][] data_right = {
            {"L1", "CNTT"},
            {"L1", "CNTT"},};

        model_right = new DefaultTableModel(data_right, columns);

        JTable table_right = new JTable(model_right) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JScrollPane scrollPane_table_right = new JScrollPane(table_right);
        pn_table_right.add(scrollPane_table_right, BorderLayout.CENTER);
        
        JPanel pn_btn_center = new JPanel();
        pn_btn_center.setLayout(new BoxLayout(pn_btn_center, 1));
        pn_btn_center.setPreferredSize(new Dimension(100,0));
        
        pn_btn_center.add(Box.createVerticalGlue());
        
        JButton btnThem = new JButton();
            btnThem.setBorderPainted(false);
            btnThem.setFocusPainted(false);
            btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btnThem.setIcon(createResizedIcon(FrameThemCHVaoDe.class, "..//image//right-icon.png", 20, 20));
            pn_btn_center.add(btnThem);
            
            pn_btn_center.add(Box.createVerticalStrut(20));
            
        JButton btnXoa = new JButton();
            btnXoa.setBorderPainted(false);
            btnXoa.setFocusPainted(false);
            btnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btnXoa.setIcon(createResizedIcon(FrameThemCHVaoDe.class, "..//image//left-icon.png", 20, 20));
            pn_btn_center.add(btnXoa);
        pn_btn_center.add(Box.createVerticalGlue());

        layout_table.setHorizontalGroup(
                layout_table.createSequentialGroup()
                        .addGroup(layout_table.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lb_khoCH)
                                .addComponent(pn_table_left))
                        .addComponent(pn_btn_center)
                        .addGroup(layout_table.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lb_deThi)
                                .addComponent(pn_table_right))
                        
                
        );

        layout_table.setVerticalGroup(
                layout_table.createSequentialGroup()
                        .addGroup(layout_table.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_khoCH)
                                .addComponent(lb_deThi))
                        .addGroup(layout_table.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(pn_table_left)
                                .addComponent(pn_table_right)
                                .addComponent(pn_btn_center)
                        )
                
        );

        JPanel pn_btn = new JPanel(new FlowLayout(0, 10, 10));
        String[] btn_name = new String[]{"Xem chi tiết", "Hoàn thành"};
        for (int i = 0; i < btn_name.length; i++) {
            JButton btn = new JButton(btn_name[i]);
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            pn_btn.add(btn);
        }

        this.getContentPane().add(pn_header, BorderLayout.NORTH);
        this.getContentPane().add(pn_table, BorderLayout.CENTER);
        this.getContentPane().add(pn_btn, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FrameThemCHVaoDe();
    }

}
