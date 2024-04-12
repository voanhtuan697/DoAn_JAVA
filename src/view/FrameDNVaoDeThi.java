/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
public class FrameDNVaoDeThi extends JFrame{
    public FrameDNVaoDeThi(){
        init();
    }
    
    public void init(){
        this.setSize(400, 200);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel pn_header = new JPanel();
        pn_header.setLayout(new FlowLayout(1,10,10));
        JLabel lb_tenLop = new JLabel("Tên lớp");
        pn_header.add(lb_tenLop);
        
        
        JPanel pn_input = new JPanel();
        JLabel lb_tenDe = new JLabel("Tên đề thi");
        JTextField txt_tenDe = new JTextField("Tên đề",15);
        txt_tenDe.setEnabled(false);
        JLabel lb_passwd = new JLabel("Mật khẩu:");
        JTextField txt_passwd = new JTextField(15);
        
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
        pn_btn.setLayout(new FlowLayout(1,10,10));
        String []btn_name = {"Thoát","Xác nhận"};
        for(int i=0;i<2;i++){
            JButton btn = new JButton(btn_name[i]);
            pn_btn.add(btn);
        }
        
        this.getContentPane().add(pn_header,BorderLayout.NORTH);
        this.getContentPane().add(pn_input,BorderLayout.CENTER);
        this.getContentPane().add(pn_btn,BorderLayout.SOUTH);
        
        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new FrameDNVaoDeThi();
    }
}
