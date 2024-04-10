/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PnDoiMatKhau extends JPanel {

    private JPanel pnInput;
    private JTextField txtMatkhau, txtMatkhauMoi, txtXacNhan;
    private JButton btnCapNhat;
    private Color colorGray = Color.decode("#B3BECB");
    private Color colorBtn = Color.decode("#009594");
    private Color colorPink = Color.decode("#DA91A4");
    private JLabel[] lbl = new JLabel[3];
    private String[] lblContent = {"Mật khẩu cũ:", "Mật khẩu mới:", "Xác nhận lại mật khẩu mới"};
    Font font = new Font("Segoe UI", Font.PLAIN, 13);

    public PnDoiMatKhau() {
        init();
        showLayout();
    }

    public void init() {
        this.setLayout(new BorderLayout());
        pnInput = new JPanel();
        pnInput.setBackground(colorGray);

        this.add(pnInput, BorderLayout.CENTER);

        for (int i = 0; i < lblContent.length; i++) {
            lbl[i] = new JLabel(lblContent[i]);
            lbl[i].setFont(font);
        }

        txtMatkhau = new JTextField();
        txtMatkhau.setPreferredSize(new Dimension(200, 25));
        txtMatkhauMoi = new JTextField();
        txtMatkhauMoi.setPreferredSize(new Dimension(200, 25));
        txtXacNhan = new JTextField();
        txtXacNhan.setPreferredSize(new Dimension(200, 25));

        btnCapNhat = new JButton("Cập nhật");
        btnCapNhat.setFont(font);
        btnCapNhat.setBackground(colorBtn);
        btnCapNhat.setBorderPainted(false);
        btnCapNhat.setFocusPainted(false);
        btnCapNhat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void showLayout() {
        GroupLayout layout = new GroupLayout(pnInput);
        pnInput.setLayout(layout);
        int gapSize = 30;

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lbl[0])
                        .addComponent(lbl[1])
                        .addComponent(lbl[2])
                        .addComponent(btnCapNhat)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(txtMatkhau)
                        .addComponent(txtMatkhauMoi)
                        .addComponent(txtXacNhan)
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl[0])
                        .addComponent(txtMatkhau)
                )
                .addGap(gapSize)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl[1])
                        .addComponent(txtMatkhauMoi)
                )
                .addGap(gapSize)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl[2])
                        .addComponent(txtXacNhan)
                )
                .addGap(gapSize)
                .addComponent(btnCapNhat)
        );
    }

}
