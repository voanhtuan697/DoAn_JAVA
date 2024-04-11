/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static view.base.dark_green;
import static view.base.font14;
import static view.base.gray_bg;
import static view.base.white;

public class PnThi extends JPanel {

    private JComboBox<String> comboBox;
    private JTextField tfMauKhau;
    private JPanel pnContent;
    private JButton btnThi;
    private String[] mon = {"Toán", "Lý", "Hóa"};

    public PnThi() {
        init();
        initComponents();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        pnContent = new JPanel();
        pnContent.setBackground(gray_bg);
        this.add(pnContent, BorderLayout.CENTER);
    }

    private void initComponents() {
        JLabel lblMauKhau = new JLabel("Mật khẩu:");
        lblMauKhau.setFont(font14);
        tfMauKhau = new JTextField();
        JLabel lblMon = new JLabel("Chọn môn");
        lblMon.setFont(font14);
        comboBox = new JComboBox<>(mon);
        comboBox.setFont(font14);
        btnThi = new JButton("Vào Thi");
        btnThi.setFont(font14);
        btnThi.setBackground(dark_green);
        btnThi.setForeground(white);
        btnThi.setBorderPainted(false);
        btnThi.setFocusPainted(false);

        GroupLayout layout = new GroupLayout(pnContent);
        pnContent.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblMon)
                        .addComponent(lblMauKhau)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(comboBox)
                        .addComponent(tfMauKhau)
                        .addComponent(btnThi)
                )
        );
        
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMon)
                        .addComponent(comboBox)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMauKhau)
                        .addComponent(tfMauKhau)
                )
                .addComponent(btnThi)
        );
    }

     public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(950, 450);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PnThi p = new PnThi();
        f.getContentPane().setLayout(new BorderLayout());
        f.add(p);
        f.setVisible(true);
    }
}
