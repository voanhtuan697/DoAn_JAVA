/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author TK
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION;
import static javax.swing.border.TitledBorder.DEFAULT_POSITION;
import static view.base.white;

public final class PnThongTinSV extends JPanel {
    JPanel pnCTND, pnQLHT, pnLichthi, pnBaidathi;
    JLabel lblMaTS, lblfullName, lblDob;
    JButton btnUpdate, btnLogout;
    JTextField tfMaTS, tffullName, tfDob;
    
    PnThongTinSV(){
        init();
        this.setLayout(new BorderLayout());
        this.add(pnCTND, BorderLayout.WEST);
        this.add(pnQLHT, BorderLayout.CENTER);
    }
    public void init(){
        lblMaTS = new JLabel("Mã thí sinh: ");
        lblMaTS.setBounds(30, 40, 85, 20);
        
        lblMaTS.setHorizontalAlignment(JLabel.RIGHT);
        lblfullName = new JLabel("Họ tên: ");
        lblfullName.setBounds(30, 80, 85, 20);
        lblfullName.setHorizontalAlignment(JLabel.RIGHT);
        lblDob = new JLabel("Ngày sinh: ");
        lblDob.setBounds(30,120,85,20);
        lblDob.setHorizontalAlignment(JLabel.RIGHT);
        
        btnUpdate = new JButton("Cập nhật");
        btnUpdate.setFocusable(false);
        btnUpdate.setBounds(20, 250, 90, 30);
        btnUpdate.setBackground(white);
        btnUpdate.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(tfMaTS.getText().isEmpty() || tffullName.getText().isEmpty() || tfDob.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Thông tin chưa đầy đủ. Vui lòng kiểm tra lại...", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Cập nhật thành công.", "", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        btnLogout = new JButton("Đăng xuất");
        btnLogout.setFocusable(false);
        btnLogout.setBounds(150, 250,110, 30);
        btnLogout.setBackground(new Color(0x74BFB2));
        
        tfMaTS = new JTextField();
        tfMaTS.setBounds(150,40,150,20);
        tffullName = new JTextField();
        tffullName.setBounds(150,80,150,20);
        tfDob = new JTextField();
        tfDob.setBounds(150,120,150,20);
        
        pnCTND = new JPanel();
        pnCTND.setBorder(BorderFactory.createTitledBorder(null, "Chi tiết người dùng", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font("Segoe UI 12", Font.BOLD, 15)));
        pnCTND.setPreferredSize(new Dimension(350,400));
        pnCTND.setBackground(white);
        
        
        pnCTND.add(lblMaTS);
        pnCTND.add(lblfullName);
        pnCTND.add(lblDob);
        pnCTND.add(tfMaTS);
        pnCTND.add(tffullName);
        pnCTND.add(tfDob);
        pnCTND.add(btnUpdate);
        pnCTND.add(btnLogout);
        pnCTND.setLayout(new BorderLayout());
        
        Object data[][] = {
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
        };
        String column[] = {"Kì thi", "Môn thi", "Thời gian", "Ngày thi","Mật khẩu"};
        JTable jtLichthi = new JTable(data, column);
        jtLichthi.setPreferredSize(new Dimension(475,100));
        JScrollPane jspLichthi = new JScrollPane(jtLichthi);
        jspLichthi.setPreferredSize(new Dimension(475,100));
        
        pnLichthi = new JPanel();
        pnLichthi.setBorder(BorderFactory.createTitledBorder(null, "Đề Thi", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font("Segoe UI 12", Font.BOLD, 15)));
        pnLichthi.setPreferredSize(new Dimension(475,150));
        pnLichthi.setBackground(new Color(0xD8A3AB));
        pnLichthi.add(jspLichthi);
        pnLichthi.setLayout(new FlowLayout());
      
        Object data2[][] = {{"JAVA" , "8,5", "34"}};
        String column2[] = {"Môn thi", "Điểm", "Số câu đúng"};
        JTable jtBaidathi = new JTable(data2, column2);
        jtBaidathi.setPreferredSize(new Dimension(475,100));
        JScrollPane jspBaidathi = new JScrollPane(jtBaidathi);
        jspBaidathi.setPreferredSize(new Dimension(475,100));
        
        pnBaidathi = new JPanel();
        pnBaidathi.setBorder(BorderFactory.createTitledBorder(null, "Kết quả", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font("Segoe UI 12", Font.BOLD, 15)));
        pnBaidathi.setPreferredSize(new Dimension(475,150));
        pnBaidathi.setBackground(white);
        pnBaidathi.add(jspBaidathi);
        pnBaidathi.setLayout(new FlowLayout());
        
        
        
        pnQLHT = new JPanel();
        pnQLHT.setBorder(BorderFactory.createTitledBorder(null, "Quản lý học tập", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font("Segoe UI 12", Font.BOLD, 15)));
        pnQLHT.setPreferredSize(new Dimension(535,295));
        pnQLHT.setBackground(white);
        pnQLHT.add(pnLichthi);
        pnQLHT.add(pnBaidathi);
        pnQLHT.setLayout(new FlowLayout());
        
        
    }
    public static void main(String[] args){
        JFrame f = new JFrame();
        f.setSize(950,450);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PnThongTinSV p = new PnThongTinSV();
        f.getContentPane().setLayout(new BorderLayout());
        f.add(p);
        f.setVisible(true);
    }
}
