/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import static java.awt.Color.white;
import java.awt.Cursor;
import java.awt.Dimension;
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
import static model.base.dark_green;
import static model.base.font14;
import static model.base.gray_bg;

public class PnThongTinAdTr extends JPanel {

    private JPanel pntt, pnDoiMK;
    private JLabel[] lblTitle = new JLabel[4];
    private String[] title = {"Tên đăng nhập:", "Họ và tên:", "Ngày sinh:", "Chức vụ:"};
    private JLabel lblTenDN, lblHoTen, lblNgSinh, lblChucVu;
    private JLabel[] lblMk = new JLabel[3];
    private String[] txtMk = {"Mật khẩu cũ:", "Mật khẩu mới:", "Xác nhận lại mật khẩu mới:"};
    private JTextField txtMatkhau, txtMatkhauMoi, txtXacNhan;
    private JButton btnCapNhat;


    public PnThongTinAdTr() {
        init();
    }

    public void init() {
        this.setLayout(new GridLayout(2, 1));

        pntt = new JPanel();
        pntt.setBorder(BorderFactory.createTitledBorder(null, "Thông tin cá nhân", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font14) {
        }));
        pntt.setBackground(gray_bg);
        this.add(pntt);

        for (int i = 0; i < lblTitle.length; i++) {
            lblTitle[i] = new JLabel(title[i]);
            lblTitle[i].setFont(font14);
        }

        lblTenDN = new JLabel("ThanhTung");
        lblTenDN.setFont(font14);
        lblHoTen = new JLabel("Nguyễn Thanh Tùng");
        lblHoTen.setFont(font14);
        lblNgSinh = new JLabel("05/07/1994");
        lblNgSinh.setFont(font14);
        lblChucVu = new JLabel("Admin");
        lblChucVu.setFont(font14);

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
                )
                .addGap(gapSize)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblTenDN)
                        .addComponent(lblHoTen)
                        .addComponent(lblNgSinh)
                        .addComponent(lblChucVu)
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
        );

        pnDoiMK = new JPanel();
        pnDoiMK.setBackground(gray_bg);
        pnDoiMK.setBorder(BorderFactory.createTitledBorder(null, "Đổi mật khẩu", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font14) {
        }));
        this.add(pnDoiMK);

        for (int i = 0; i < lblMk.length; i++) {
            lblMk[i] = new JLabel(txtMk[i]);
            lblMk[i].setFont(font14);
        }

        txtMatkhau = new JTextField();
        txtMatkhauMoi = new JTextField();
        txtXacNhan = new JTextField();
        Dimension textFieldSize = new Dimension(200, 25);
        txtMatkhau.setPreferredSize(textFieldSize);
        txtMatkhauMoi.setPreferredSize(textFieldSize);
        txtXacNhan.setPreferredSize(textFieldSize);
        
        btnCapNhat = new JButton("Cập nhật");
        btnCapNhat.setForeground(white);
        btnCapNhat.setFont(font14);
        btnCapNhat.setBackground(dark_green);
        btnCapNhat.setBorderPainted(false);
        btnCapNhat.setFocusPainted(false);
        btnCapNhat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

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
    public static void main(String[] args){
        JFrame f = new JFrame();
        f.setSize(950,450);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PnThongTinAdTr p = new PnThongTinAdTr();
        f.getContentPane().setLayout(new BorderLayout());
        f.add(p);
        f.setVisible(true);
    }
}
