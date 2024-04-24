/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import static GUI.BASE.createResizedIcon;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION;
import static javax.swing.border.TitledBorder.DEFAULT_POSITION;
import static GUI.BASE.dark_green;
import static GUI.BASE.font16;
import static GUI.BASE.font16;
import static GUI.BASE.white;
import java.awt.Color;
import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.JDatePicker;

public class PnThongTinCaNhan extends JPanel {

    private JPanel pnLeft, pnRight;
    private JButton btnLHoc, btnLDay, btnMon, btnDThi, btnCapNhat, btnDoiMK;
    private JTextField tfHoTen, tfMk, tfMKMoi, tfMkNL;
    private JLabel lblTenDn, lblChucVu, lblTrMon;

    public PnThongTinCaNhan() {
        init();
        initComponents();
    }

    public void init() {
        this.setLayout(new BorderLayout());
        pnLeft = new JPanel();

        pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
        pnLeft.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 0));
        pnLeft.setBorder(BorderFactory.createTitledBorder(null, "Thông tin cá nhân của người dùng", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font16) {
        }));

        pnRight = new JPanel();

        pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
        pnRight.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
        pnRight.setPreferredSize(new Dimension(400, 0));
        pnRight.setBorder(BorderFactory.createTitledBorder(null, "Đổi mật khẩu", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font16) {
        }));

        this.add(pnLeft, BorderLayout.CENTER);
        this.add(pnRight, BorderLayout.EAST);
    }

    public void initComponents() {
        JLabel lbTenDN, lbHoTen, lbNgSinh, lbChucVu, lbTrBM, lbLopDay, lbLopHoc, lbMonDay, lbDeThi;

        JPanel pnDN = new JPanel(new FlowLayout(FlowLayout.LEFT));

        lbTenDN = new JLabel("Tên đăng nhập:");
        lbTenDN.setFont(font16);
        lblTenDn = new JLabel("Nguyễn Thanh Tùng");
        lblTenDn.setFont(font16);
        pnDN.add(lbTenDN);
        pnDN.add(lblTenDn);

        JPanel pnHoTen = new JPanel(new FlowLayout(FlowLayout.LEFT));

        lbHoTen = new JLabel("Họ và tên:");
        lbHoTen.setFont(font16);
        tfHoTen = new JTextField(25);
        pnHoTen.add(lbHoTen);
        pnHoTen.add(tfHoTen);

        JPanel pnNgSinh = new JPanel(new FlowLayout(FlowLayout.LEFT));

        lbNgSinh = new JLabel("Ngày sinh:");
        lbNgSinh.setFont(font16);
        JDateComponentFactory dateComponent = new JDateComponentFactory();
        JDatePicker date = dateComponent.createJDatePicker();
        pnNgSinh.add(lbNgSinh);
        pnNgSinh.add((JComponent) date);

        JPanel pnChucVu = new JPanel(new FlowLayout(FlowLayout.LEFT));

        lbChucVu = new JLabel("Chức vụ:");
        lbChucVu.setFont(font16);
        lblChucVu = new JLabel("Admin");
        lblChucVu.setFont(font16);
        pnChucVu.add(lbChucVu);
        pnChucVu.add(lblChucVu);

        JPanel pnTrBM = new JPanel(new FlowLayout(FlowLayout.LEFT));

        lbTrBM = new JLabel("Trưởng bộ môn:");
        lbTrBM.setFont(font16);
        lblTrMon = new JLabel("Khoa học máy tính");
        lblTrMon.setFont(font16);
        pnTrBM.add(lbTrBM);
        pnTrBM.add(lblTrMon);

        JPanel pnLopDay = new JPanel(new FlowLayout(FlowLayout.LEFT));

        lbLopDay = new JLabel("Danh sách lớp dạy:");
        lbLopDay.setFont(font16);
        btnLDay = new JButton("show", createResizedIcon(PnThongTinCaNhan.class, "..//image//eye-icon.png", 20, 20));
        btnLDay.setHorizontalTextPosition(JButton.LEFT);
        btnLDay.setVerticalTextPosition(JButton.CENTER);
        btnLDay.setBackground(dark_green);
        btnLDay.setForeground(white);
        btnLDay.setBorderPainted(false);
        btnLDay.setFocusPainted(false);
        btnLDay.setFont(font16);
        btnLDay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        pnLopDay.add(lbLopDay);
        pnLopDay.add(btnLDay);

        JPanel pnLopHoc = new JPanel(new FlowLayout(FlowLayout.LEFT));

        lbLopHoc = new JLabel("Danh sách lớp học:");
        lbLopHoc.setFont(font16);
        btnLHoc = new JButton("show", createResizedIcon(PnThongTinCaNhan.class, "..//image//eye-icon.png", 20, 20));
        btnLHoc.setHorizontalTextPosition(JButton.LEFT);
        btnLHoc.setVerticalTextPosition(JButton.CENTER);
        btnLHoc.setBackground(dark_green);
        btnLHoc.setForeground(white);
        btnLHoc.setBorderPainted(false);
        btnLHoc.setFocusPainted(false);
        btnLHoc.setFont(font16);
        btnLHoc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnLopHoc.add(lbLopHoc);
        pnLopHoc.add(btnLHoc);

        JPanel pnMonDay = new JPanel(new FlowLayout(FlowLayout.LEFT));

        lbMonDay = new JLabel("Danh sách môn dạy:");
        lbMonDay.setFont(font16);
        btnMon = new JButton("show", createResizedIcon(PnThongTinCaNhan.class, "..//image//eye-icon.png", 20, 20));
        btnMon.setHorizontalTextPosition(JButton.LEFT);
        btnMon.setVerticalTextPosition(JButton.CENTER);
        btnMon.setBackground(dark_green);
        btnMon.setForeground(white);
        btnMon.setBorderPainted(false);
        btnMon.setFocusPainted(false);
        btnMon.setFont(font16);
        btnMon.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnMonDay.add(lbMonDay);
        pnMonDay.add(btnMon);

        JPanel pnDethi = new JPanel(new FlowLayout(FlowLayout.LEFT));

        lbDeThi = new JLabel("Đề thi:");
        lbDeThi.setFont(font16);
        btnDThi = new JButton("show", createResizedIcon(PnThongTinCaNhan.class, "..//image//eye-icon.png", 20, 20));
        btnDThi.setHorizontalTextPosition(JButton.LEFT);
        btnDThi.setVerticalTextPosition(JButton.CENTER);
        btnDThi.setBackground(dark_green);
        btnDThi.setForeground(white);
        btnDThi.setBorderPainted(false);
        btnDThi.setFocusPainted(false);
        btnDThi.setFont(font16);
        btnDThi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnDethi.add(lbDeThi);
        pnDethi.add(btnDThi);

        JPanel pnCapNhat = new JPanel(new FlowLayout(FlowLayout.LEFT));

        btnCapNhat = new JButton("Cập nhật");
        btnCapNhat.setBackground(dark_green);
        btnCapNhat.setForeground(white);
        btnCapNhat.setBorderPainted(false);
        btnCapNhat.setFocusPainted(false);
        btnCapNhat.setFont(font16);
        btnCapNhat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnCapNhat.add(btnCapNhat);

        pnLeft.add(pnDN);
        pnLeft.add(pnHoTen);
        pnLeft.add(pnNgSinh);
        pnLeft.add(pnChucVu);
        pnLeft.add(pnTrBM);
        pnLeft.add(Box.createVerticalStrut(10));
        pnLeft.add(pnLopDay);
        pnLeft.add(pnLopHoc);
        pnLeft.add(pnMonDay);
        pnLeft.add(pnDethi);
        pnLeft.add(pnCapNhat);

        JPanel pnMKcu = new JPanel(new FlowLayout(FlowLayout.LEFT));

        pnMKcu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel lbMKcu = new JLabel("Nhập mật khẩu cũ:");
        lbMKcu.setFont(font16);
        tfMk = new JTextField(25);
        tfMk.setPreferredSize(new Dimension(tfMk.getPreferredSize().width, 30));
        pnMKcu.add(lbMKcu);
        pnMKcu.add(tfMk);

        JPanel pnMkMoi = new JPanel(new FlowLayout(FlowLayout.LEFT));

        pnMkMoi.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel lbMkmoi = new JLabel("Nhập mật khẩu mới:");
        lbMkmoi.setFont(font16);
        tfMKMoi = new JTextField(25);
        tfMKMoi.setPreferredSize(new Dimension(tfMKMoi.getPreferredSize().width, 30));
        pnMkMoi.add(lbMkmoi);
        pnMkMoi.add(tfMKMoi);

        JPanel pnNhapLai = new JPanel(new FlowLayout(FlowLayout.LEFT));

        pnNhapLai.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel lbNhapLai = new JLabel("Nhập lại mật khẩu:");
        lbNhapLai.setFont(font16);
        tfMkNL = new JTextField(25);
        tfMkNL.setPreferredSize(new Dimension(tfMkNL.getPreferredSize().width, 30));
        pnNhapLai.add(lbNhapLai);
        pnNhapLai.add(tfMkNL);

        JPanel pnDoiMk = new JPanel(new FlowLayout(FlowLayout.LEFT));

        pnDoiMk.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnDoiMK = new JButton("Đổi mật khẩu");
        btnDoiMK.setBackground(dark_green);
        btnDoiMK.setForeground(white);
        btnDoiMK.setBorderPainted(false);
        btnDoiMK.setFocusPainted(false);
        btnDoiMK.setFont(font16);
        btnDoiMK.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnDoiMk.add(btnDoiMK);

        pnRight.add(pnMKcu);
        pnRight.add(pnMkMoi);
        pnRight.add(pnNhapLai);
        pnRight.add(pnDoiMk);

    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(950, 450);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PnThongTinCaNhan p = new PnThongTinCaNhan();
        f.getContentPane().setLayout(new BorderLayout());
        f.add(p);
        f.setVisible(true);
    }

}
