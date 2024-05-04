
/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.taiKhoanBUS;
import BUS.updateTrangThaiDeThiBUS;
import DAO.updateTrangThai;
import DTO.taiKhoanDTO;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static GUI.BASE.dark_green;
import static GUI.BASE.font14;
import static GUI.BASE.font14b;
import static GUI.BASE.white;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class dangNhapTaiKhoanGUI extends JFrame implements ActionListener {

    private JPanel pnTitlebg;
    private JLabel lbTitle, lbTaikhoan, lbMatkhau;
    private JTextField txtTenDN;
    private JPasswordField txtMatkhau;
    private JButton btnForgot, btnLogin;

    public dangNhapTaiKhoanGUI() throws SQLException {
        new updateTrangThaiDeThiBUS();
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Login");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        JPanel pn_main = new JPanel();
        pn_main.setLayout(null);
        pn_main.setBackground(new Color(0xB3, 0xBE, 0xCB));
        lbTitle = new JLabel();
        lbTitle.setText("ĐĂNG NHẬP");
        lbTitle.setForeground(new Color(255, 255, 255));
        lbTitle.setBounds(270, 10, 200, 20);

        pnTitlebg = new JPanel();
        pnTitlebg.setBounds(0, 0, 600, 30);
        pnTitlebg.setBackground(dark_green);
        pnTitlebg.add(lbTitle);
        pn_main.add(pnTitlebg);

        lbTaikhoan = new JLabel();
        lbTaikhoan.setText("Tài khoản:");
        lbTaikhoan.setBounds(50, 100, 300, 40);
        pn_main.add(lbTaikhoan);

        lbMatkhau = new JLabel();
        lbMatkhau.setText("Mật khẩu:");
        lbMatkhau.setBounds(50, 150, 300, 40);
        pn_main.add(lbMatkhau);

        txtTenDN = new JTextField();
        txtTenDN.setBackground(new Color(255, 255, 255));
        txtTenDN.setBounds(150, 105, 300, 30);
        txtTenDN.addActionListener(this);
        pn_main.add(txtTenDN);

        txtMatkhau = new JPasswordField();
        txtMatkhau.setBackground(new Color(255, 255, 255));
        txtMatkhau.setBounds(150, 155, 300, 30);
        txtMatkhau.addActionListener(this);
        pn_main.add(txtMatkhau);

        btnForgot = new JButton("Quên mật khẩu");
        btnForgot.setBounds(150, 250, 140, 30);
        btnForgot.setBorderPainted(false);
        btnForgot.setFocusPainted(false);
        btnForgot.setForeground(white);
        btnForgot.setBackground(dark_green);
        pn_main.add(btnForgot);

//        LogIn_Listener listener = new LogIn_Listener(this);

        btnLogin = new JButton("Đăng nhập");
        btnLogin.setBounds(300, 250, 140, 30);
        btnLogin.setBackground(dark_green);
        btnLogin.setForeground(white);
        btnLogin.setBorderPainted(false);
        btnLogin.setFocusPainted(false);
        btnLogin.addActionListener(this);
        pn_main.add(btnLogin);

        lbTitle.setFont(font14b);
        lbTaikhoan.setFont(font14);
        lbMatkhau.setFont(font14);
        txtTenDN.setFont(font14);
        txtMatkhau.setFont(font14);
        btnForgot.setFont(font14);
        btnLogin.setFont(font14);

        this.add(pn_main);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();
        Object source = e.getSource();
        if (source == txtTenDN) {
        txtMatkhau.requestFocus();
        } else if(source == txtMatkhau && !txtTenDN.getText().isEmpty() && !txtMatkhau.getText().isEmpty()){
            try {       
                taiKhoanBUS taiKhoan = new taiKhoanBUS();
                taiKhoanDTO tk =taiKhoan.dangNhapTaiKhoan(txtTenDN.getText(), txtMatkhau.getText());
                if(tk!=null){
                    this.dispose();
                    new GiaoDienUserGUI(tk.getMaTK());
                }else{
                    System.out.println("Khong");
                    txtTenDN.setText("");
                    txtTenDN.requestFocus();
                    txtMatkhau.setText("");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        if (btn.equals("Đăng nhập")) {
            try {       
                taiKhoanBUS taiKhoan = new taiKhoanBUS();
                taiKhoanDTO tk =taiKhoan.dangNhapTaiKhoan(txtTenDN.getText(), txtMatkhau.getText());
                if(tk!=null){
                    this.dispose();
                    new GiaoDienUserGUI(tk.getMaTK());
                }else{
                    System.out.println("Khong");
                    txtTenDN.setText("");
                    txtTenDN.requestFocus();
                    txtMatkhau.setText("");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            
        }
    }
}
