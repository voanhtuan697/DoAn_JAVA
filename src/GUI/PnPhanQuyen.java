/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 *
 * @author E7250
 */
public class PnPhanQuyen extends JPanel{
    public PnPhanQuyen(){
        init();
    }
    
    public void init(){
        this.setLayout(new BorderLayout());
        
        JTabbedPane tabbedPane = new JTabbedPane();
        
        JPanel pn_admin = new JPanel();
        
        String []tenQuyen = new String[]{"Admin","Trưởng bộ môn","Giảng viên","Sinh viên"};
        String []tenChucNang = new String[]{"Tạo đề","Tạo tài khoản","Tạo lớp","Tạo môn","Duyệt câu hỏi","Phân quyền","Xem kết quả các đề đã thi","Thêm lớp cho sinh viên","Thêm môn cho giáo viên"};
        
        int soCot = 2;
        int soHang = tenChucNang.length / 2;
        
        for (String x : tenQuyen) {
            JPanel panel = new JPanel(new GridLayout(soHang, soCot, 10, 10));
            for (String y : tenChucNang) {
                JCheckBox checkBox = new JCheckBox(y);
                panel.add(checkBox);
            }
            tabbedPane.addTab(x, panel);
        }
        
        this.add(tabbedPane, BorderLayout.CENTER);
    }
    
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(800, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.getContentPane().add( new PnPhanQuyen());
        f.setVisible(true);
    }
}
