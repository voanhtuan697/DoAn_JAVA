/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION;
import static javax.swing.border.TitledBorder.DEFAULT_POSITION;

public class PnThongTinTBM extends JPanel {

    private JPanel pntt, pnDoiMK;
    private JLabel[] lblTitle = new JLabel[5];
    private String[] title = {"Tên đăng nhập:", "Họ và tên:", "Ngày sinh:", "Chức vụ:","Môn:"};
    private JLabel lblTenDN, lblHoTen, lblNgSinh, lblChucVu,lblMon;
    private Color colorGray = Color.decode("#B3BECB");
    private JLabel[] lblMk = new JLabel[3];
    private String[] txtMk = {"Mật khẩu cũ:", "Mật khẩu mới:", "Xác nhận lại mật khẩu mới:"};
    private JTextField txtMatkhau, txtMatkhauMoi, txtXacNhan;
    private JButton btnCapNhat;
    private Color colorBtn = Color.decode("#009594");
    Font font = new Font("Segoe UI", Font.PLAIN, 14);

    public PnThongTinTBM() {
        init();
    }

    public void init() {
        this.setLayout(new GridLayout(2, 1));
//        this.setBackground(Color.decode("#F4E4CA"));

        pntt = new JPanel();
        pntt.setBorder(BorderFactory.createTitledBorder(null, "Thông tin cá nhân", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font) {
        }));
//        pntt.setBackground(Color.decode("#FFFFFF"));
        this.add(pntt);

        for (int i = 0; i < lblTitle.length; i++) {
            lblTitle[i] = new JLabel(title[i]);
            lblTitle[i].setFont(font);
        }

        lblTenDN = new JLabel("ThanhTung");
        lblTenDN.setFont(font);
        lblHoTen = new JLabel("Nguyễn Thanh Tùng");
        lblHoTen.setFont(font);
        lblNgSinh = new JLabel("05/07/1994");
        lblNgSinh.setFont(font);
        lblChucVu = new JLabel("Admin");
        lblChucVu.setFont(font);
                lblMon = new JLabel("Cơ sở dữ liệu");
        lblMon.setFont(font);

        GroupLayout layout = new GroupLayout(pntt);
        pntt.setLayout(layout);
        int gapSize = 30;

        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblTitle[0])
                        .addComponent(lblTitle[1])
                        .addComponent(lblTitle[2])
                        .addComponent(lblTitle[3])
                        .addComponent(lblTitle[4])
                )
                .addGap(gapSize)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblTenDN)
                        .addComponent(lblHoTen)
                        .addComponent(lblNgSinh)
                        .addComponent(lblChucVu)
                        .addComponent(lblMon)
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTitle[0])
                        .addComponent(lblTenDN)
                )
                .addGap(gapSize)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTitle[1])
                        .addComponent(lblHoTen)
                )
                .addGap(gapSize)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTitle[2])
                        .addComponent(lblNgSinh)
                )
                .addGap(gapSize)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTitle[3])
                        .addComponent(lblChucVu)
                )
                .addGap(gapSize)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTitle[4])
                        .addComponent(lblMon)
                )
        );

        pnDoiMK = new JPanel();
//        pnDoiMK.setBackground(Color.decode("#FFFFFF"));
        pnDoiMK.setBorder(BorderFactory.createTitledBorder(null, "Đổi mật khẩu", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font) {
        }));
        this.add(pnDoiMK);

        for (int i = 0; i < lblMk.length; i++) {
            lblMk[i] = new JLabel(txtMk[i]);
            lblMk[i].setFont(font);
        }

        txtMatkhau = new JTextField();
        txtMatkhauMoi = new JTextField();
        txtXacNhan = new JTextField();
        btnCapNhat = new JButton("Cập nhật");
        btnCapNhat.setFont(font);
        btnCapNhat.setBackground(colorBtn);

        GroupLayout layoutMk = new GroupLayout(pnDoiMK);
        pnDoiMK.setLayout(layoutMk);
        layoutMk.setAutoCreateGaps(true);
        layoutMk.setAutoCreateContainerGaps(true);

        layoutMk.setHorizontalGroup(layoutMk.createSequentialGroup()
                .addGroup(layoutMk.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblMk[0])
                        .addComponent(lblMk[1])
                        .addComponent(lblMk[2])
                        .addComponent(btnCapNhat)
                )
                .addGroup(layoutMk.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(txtMatkhau)
                        .addComponent(txtMatkhauMoi)
                        .addComponent(txtXacNhan)
                )
        );

        layoutMk.setVerticalGroup(layoutMk.createSequentialGroup()
                .addGroup(layoutMk.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMk[0])
                        .addComponent(txtMatkhau)
                )
                .addGap(gapSize)
                .addGroup(layoutMk.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMk[1])
                        .addComponent(txtMatkhauMoi)
                )
                .addGap(gapSize)
                .addGroup(layoutMk.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMk[2])
                        .addComponent(txtXacNhan)
                )
                .addGap(gapSize)
                .addComponent(btnCapNhat)
        );

    }
}