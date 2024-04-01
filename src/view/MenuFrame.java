/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author E7250
 */
public class MenuFrame extends JFrame{
    public MenuFrame() {
        init();
    }
    public void init(){
        this.setTitle("Frame");
        this.setSize(1366,760);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel pn_tittle = new JPanel();
        pn_tittle.setBackground(Color.red);
        pn_tittle.setPreferredSize(new Dimension(100, 40));
        pn_tittle.setLayout(new GridBagLayout());
        JLabel lb_tittle = new JLabel("Tittle");
        lb_tittle.setHorizontalAlignment(SwingConstants.CENTER); // Đặt căn giữa theo chiều ngang
        lb_tittle.setVerticalAlignment(SwingConstants.CENTER); // Đặt căn giữa theo chiều dọc
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0; // Cho phép label mở rộng ngang
        gbc.weighty = 1.0; // Cho phép label mở rộng dọc
        gbc.fill = GridBagConstraints.BOTH; // Điền label vào cả hai hướng
        pn_tittle.add(lb_tittle,gbc);
        
        JPanel pn_tenChucNang = new JPanel();
        pn_tenChucNang.setBackground(Color.yellow);
        pn_tenChucNang.setPreferredSize(new Dimension(1200, 40));
        pn_tenChucNang.setLayout(new GridBagLayout());
        JLabel lb_tenChucNang = new JLabel("Tạo câu hỏi");
        lb_tenChucNang.setHorizontalAlignment(SwingConstants.CENTER); 
        lb_tenChucNang.setVerticalAlignment(SwingConstants.CENTER); 
        pn_tenChucNang.add(lb_tenChucNang,gbc);
        
        JPanel pn_btn = new JPanel();
        pn_btn.setBackground(Color.pink);
        pn_btn.setMaximumSize(new Dimension(400, 1000));
        pn_btn.setLayout(new BoxLayout(pn_btn, BoxLayout.Y_AXIS));
        JButton btn1 = new JButton("1");
        btn1.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        btn1.setBackground(Color.red);
        btn1.setFocusPainted(false);
        JButton btn2 = new JButton("2");
        btn2.setMaximumSize(new Dimension(Integer.MAX_VALUE,50));
        pn_btn.add(btn1);
        
        pn_btn.add(btn2);
        
        
        
        
        JPanel pn_content = new PanelTaoCauHoi();
        pn_content.setPreferredSize(new Dimension(1200, 670));
        
        GroupLayout layout = new GroupLayout(this.getContentPane());
        this.getContentPane().setLayout(layout);
        


        layout.setHorizontalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(pn_tittle)
                    .addComponent(pn_btn))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(pn_tenChucNang)
                    .addComponent(pn_content)      
                )
                    
                
        );

        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(pn_tittle)
                    .addComponent(pn_tenChucNang))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(pn_btn)
                    .addComponent(pn_content))
                
        );
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
//        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//        int screenWidth = (int) screenSize.getWidth();
//        int screenHeight = (int) screenSize.getHeight();
//        System.out.println("Chiều rộng của màn hình: " + screenWidth);
//        System.out.println("Chiều cao của màn hình: " + screenHeight);
        this.setVisible(true);
    }
}
