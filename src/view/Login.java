
/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.LogIn_Listener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static view.base.dark_green;
import static view.base.font14;
import static view.base.font14b;
import static view.base.white;

public class Login extends JFrame {

    private JPanel pnTitlebg;
    private JLabel lbTitle, lbTaikhoan, lbMatkhau;
    private JTextField tfTaikhoan, tfMatkhau;
    private JButton btnForgot, btnLogin;

    public Login() {
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

        tfTaikhoan = new JTextField();
        tfTaikhoan.setBackground(new Color(255, 255, 255));
        tfTaikhoan.setBounds(150, 105, 300, 30);
        pn_main.add(tfTaikhoan);

        tfMatkhau = new JTextField();
        tfMatkhau.setBackground(new Color(255, 255, 255));
        tfMatkhau.setBounds(150, 155, 300, 30);
        pn_main.add(tfMatkhau);

        btnForgot = new JButton("Quên mật khẩu");
        btnForgot.setBounds(150, 250, 140, 30);
        btnForgot.setBorderPainted(false);
        btnForgot.setFocusPainted(false);
        btnForgot.setForeground(white);
        btnForgot.setBackground(dark_green);
        pn_main.add(btnForgot);

        LogIn_Listener listener = new LogIn_Listener(this);

        btnLogin = new JButton("Đăng nhập");
        btnLogin.setBounds(300, 250, 140, 30);
        btnLogin.setBackground(dark_green);
        btnLogin.setForeground(white);
        btnLogin.setBorderPainted(false);
        btnLogin.setFocusPainted(false);
        btnLogin.addActionListener(listener);
        pn_main.add(btnLogin);

        lbTitle.setFont(font14b);
        lbTaikhoan.setFont(font14);
        lbMatkhau.setFont(font14);
        tfTaikhoan.setFont(font14);
        tfMatkhau.setFont(font14);
        btnForgot.setFont(font14);
        btnLogin.setFont(font14);

        this.add(pn_main);
        this.setVisible(true);
    }

}
