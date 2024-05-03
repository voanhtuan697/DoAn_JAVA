/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.deThiBUS;
import DTO.deThiDTO;
import XULY.ShowDiaLog;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author E7250
 */
public class FrameDNVaoDeThi extends JFrame implements ActionListener {

    private String maDT;
    private String maTK;
    private deThiBUS dt;
    private deThiDTO deThi;
    private JTextField txt_passwd;

    public FrameDNVaoDeThi(String maDT, String maTK) throws SQLException {
        this.maDT = maDT;
        this.maTK = maTK;
        dt = new deThiBUS();
        deThi = dt.layDeThiBangMaDT(maDT);
        init();
    }

    public void init() {
        this.setSize(400, 200);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        JPanel pn_header = new JPanel();
        pn_header.setLayout(new FlowLayout(1, 10, 10));
        JLabel lb_tenLop = new JLabel("Nhập mật khẩu bài thi");
        pn_header.add(lb_tenLop);

        JPanel pn_input = new JPanel();
        JLabel lb_tenDe = new JLabel("Tên đề thi");
        JTextField txt_tenDe = new JTextField(deThi.getTenDeThi(), 15);
        txt_tenDe.setEnabled(false);
        JLabel lb_passwd = new JLabel("Mật khẩu:");
        txt_passwd = new JTextField(15);
        txt_passwd.addActionListener(this);

        GroupLayout layout_input = new GroupLayout(pn_input);
        pn_input.setLayout(layout_input);
        layout_input.setAutoCreateGaps(true);
        layout_input.setAutoCreateContainerGaps(true);

        layout_input.setHorizontalGroup(
                layout_input.createSequentialGroup()
                        .addGroup(layout_input.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lb_tenDe)
                                .addComponent(lb_passwd))
                        .addGroup(layout_input.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(txt_tenDe)
                                .addComponent(txt_passwd))
        );

        layout_input.setVerticalGroup(
                layout_input.createSequentialGroup()
                        .addGroup(layout_input.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_tenDe)
                                .addComponent(txt_tenDe))
                        .addGroup(layout_input.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_passwd)
                                .addComponent(txt_passwd))
        );

        JPanel pn_btn = new JPanel();
        pn_btn.setLayout(new FlowLayout(1, 10, 10));
        JButton btn_acept = new JButton("Xác nhận");
        btn_acept.addActionListener(this);
        JButton btn_exit = new JButton("Thoát");
        btn_exit.addActionListener(this);
        pn_btn.add(btn_acept);
        pn_btn.add(btn_exit);

        this.getContentPane().add(pn_header, BorderLayout.NORTH);
        this.getContentPane().add(pn_input, BorderLayout.CENTER);
        this.getContentPane().add(pn_btn, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();
        Object source = e.getSource();
        if (source == txt_passwd && !txt_passwd.getText().isEmpty()) {
            if (txt_passwd.getText().equals(deThi.getMatKhau())) {
                try {
                    new FrameBaiThi(maDT, maTK);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                this.dispose();
            } else {
                new ShowDiaLog("Mật khẩu không đúng", ShowDiaLog.ERROR_DIALONG);
                this.txt_passwd.setText("");
                this.txt_passwd.requestFocus();
            }
        }
        if (btn.equals("Xác nhận")) {
            if (txt_passwd.getText().equals(deThi.getMatKhau())) {
                try {
                    new FrameBaiThi(maDT, maTK);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                this.dispose();
            } else {
                new ShowDiaLog("Mật khẩu không đúng", ShowDiaLog.ERROR_DIALONG);
                this.txt_passwd.setText("");
                this.txt_passwd.requestFocus();
            }
        } else if (btn.equals("Thoát")) {
            this.dispose();
        }
    }
}
