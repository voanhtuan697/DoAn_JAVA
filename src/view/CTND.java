/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Projects2024;

/**
 *
 * @author TK
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.*;
import static javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION;
import static javax.swing.border.TitledBorder.DEFAULT_POSITION;

public final class CTND extends JFrame {
    JPanel pnCTND, pnQLHT, pnLichthi, pnBaidathi;
    JLabel lblMaTS, lblfullName, lblDob, lbloldPass, lblnewPass;
    JButton btnUpdate, btnLogout;
    JTextField tfMaTS, tffullName, tfDob, tfoldPass, tfnewPass;
    CTND(){
        init();
        this.setSize(950,450);
        this.setResizable(true);
        this.getContentPane().setBackground(new Color(0xD8A3AB));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        this.setLayout(new BorderLayout());
        this.add(pnCTND, BorderLayout.WEST);
        this.add(pnQLHT, BorderLayout.CENTER);
        this.setVisible(true);
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
        lbloldPass = new JLabel("Mật khẩu cũ: ");
        lbloldPass.setBounds(30,160,85,20);
        lbloldPass.setHorizontalAlignment(JLabel.RIGHT);
        lblnewPass = new JLabel("Mật khẩu mới: ");
        lblnewPass.setBounds(30,200,85,20);
        lblnewPass.setHorizontalAlignment(JLabel.RIGHT);
        
        btnUpdate = new JButton("Cập nhật");
        btnUpdate.setFocusable(false);
        btnUpdate.setBounds(20, 250, 90, 30);
        btnUpdate.setBackground(new Color(0x74BFB2));
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
        tfoldPass = new JTextField();
        tfoldPass.setBounds(150,160,150,20);
        tfnewPass = new JTextField();
        tfnewPass.setBounds(150,200,150,20);
        
        pnCTND = new JPanel();
        pnCTND.setBorder(BorderFactory.createTitledBorder(null, "Chi tiết người dùng", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font("Segoe UI 12", Font.BOLD, 15)));
        pnCTND.setPreferredSize(new Dimension(350,400));
        pnCTND.setBackground(new Color(0xD8A3AB));
        
        
        pnCTND.add(lblMaTS);
        pnCTND.add(lblfullName);
        pnCTND.add(lblDob);
        pnCTND.add(lbloldPass);
        pnCTND.add(lblnewPass);
        pnCTND.add(tfMaTS);
        pnCTND.add(tffullName);
        pnCTND.add(tfDob);
        pnCTND.add(tfoldPass);
        pnCTND.add(tfnewPass);
        pnCTND.add(btnUpdate);
        pnCTND.add(btnLogout);
        pnCTND.setLayout(new BorderLayout());
        
        Object data[][] = {{"HK2", "JAVA", "90p", "25/05/2024", "O"}};
        String column[] = {"Kì thi", "Môn thi", "Thời gian", "Ngày làm", "Làm bài"};
        JTable jtLichthi = new JTable(data, column);
        jtLichthi.setPreferredSize(new Dimension(475,100));
        JScrollPane jspLichthi = new JScrollPane(jtLichthi);
        
        pnLichthi = new JPanel();
        pnLichthi.setBorder(BorderFactory.createTitledBorder(null, "Lịch thi", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font("Segoe UI 12", Font.BOLD, 15)));
        pnLichthi.setPreferredSize(new Dimension(475,150));
        pnLichthi.setBackground(new Color(0xD8A3AB));
        pnLichthi.add(jspLichthi);
        pnLichthi.setLayout(new FlowLayout());
      
        Object data2[][] = {{"JAVA" , "8,5", "34", "O"}};
        String column2[] = {"Môn thi", "Điểm", "Số câu đúng", "Xem lại bài"};
        JTable jtBaidathi = new JTable(data2, column2);
        jtBaidathi.setPreferredSize(new Dimension(475,100));
        JScrollPane jspBaidathi = new JScrollPane(jtBaidathi);
        
        pnBaidathi = new JPanel();
        pnBaidathi.setBorder(BorderFactory.createTitledBorder(null, "Bài đã thi", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font("Segoe UI 12", Font.BOLD, 15)));
        pnBaidathi.setPreferredSize(new Dimension(475,150));
        pnBaidathi.setBackground(new Color(0xD8A3AB));
        pnBaidathi.add(jspBaidathi);
        pnBaidathi.setLayout(new FlowLayout());
        
        
        
        pnQLHT = new JPanel();
        pnQLHT.setBorder(BorderFactory.createTitledBorder(null, "Quản lý học tập", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font("Segoe UI 12", Font.BOLD, 15)));
        pnQLHT.setPreferredSize(new Dimension(535,295));
        pnQLHT.setBackground(new Color(0xD8A3AB));
        pnQLHT.add(pnLichthi);
        pnQLHT.add(pnBaidathi);
        pnQLHT.setLayout(new FlowLayout());
        
        
    }
    public static void main(String[] args){
        CTND ctnd = new CTND();
    }
}
