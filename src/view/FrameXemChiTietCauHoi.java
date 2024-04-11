/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import model.ImageUtils;

/**
 *
 * @author E7250
 */
public class FrameXemChiTietCauHoi extends JFrame {

    public FrameXemChiTietCauHoi() {
        init();
    }

    public void init() {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        JPanel pn_header = new JPanel();
        pn_header.setPreferredSize(new Dimension(500, 300));
        JLabel lb_img = new JLabel();
        lb_img.setIcon(ImageUtils.createResizedIcon(MenuFrameAd.class, "..//image//anhTruong.jpg", pn_header.getPreferredSize().width, pn_header.getPreferredSize().height));
        pn_header.add(lb_img, BorderLayout.CENTER);

        Font font = new Font("Arial", Font.BOLD, 17);

        JPanel pn_center = new JPanel();
        GroupLayout layout_center = new GroupLayout(pn_center);
        pn_center.setLayout(layout_center);
        layout_center.setAutoCreateGaps(true);
        layout_center.setAutoCreateContainerGaps(true);

        JLabel lb_cauHoi = new JLabel("Cau hoi:");
        lb_cauHoi.setFont(font);

        JPanel pn_cauHoi = new JPanel();
        pn_cauHoi.setPreferredSize(new Dimension(0, 50));
        pn_cauHoi.setLayout(new BorderLayout());
        JTextArea txt_cauHoi = new JTextArea();
        txt_cauHoi.setLineWrap(true);
        txt_cauHoi.setEnabled(false);

        JScrollPane scrollPane_cauhoi = new JScrollPane(txt_cauHoi);
        pn_cauHoi.add(scrollPane_cauhoi, BorderLayout.CENTER);

//        ------------
        JLabel lb_ctl_a = new JLabel("A: ");
        lb_ctl_a.setFont(font);
        JPanel pn_ctl_a = new JPanel();
        pn_ctl_a.setPreferredSize(new Dimension(0, 30));
        pn_ctl_a.setLayout(new BorderLayout());
        JTextArea txt_ctl_a = new JTextArea();
        txt_ctl_a.setLineWrap(true);
        txt_ctl_a.setEnabled(false);

        JScrollPane scrollPane_ctl_a = new JScrollPane(txt_ctl_a);
        pn_ctl_a.add(scrollPane_ctl_a, BorderLayout.CENTER);

//        ---------------
        JLabel lb_ctl_b = new JLabel("B: ");
        lb_ctl_b.setFont(font);
        JPanel pn_ctl_b = new JPanel();
        pn_ctl_b.setPreferredSize(new Dimension(0, 30));
        pn_ctl_b.setLayout(new BorderLayout());
        JTextArea txt_ctl_b = new JTextArea();
        txt_ctl_b.setLineWrap(true);
        txt_ctl_b.setEnabled(false);

        JScrollPane scrollPane_ctl_b = new JScrollPane(txt_ctl_b);
        pn_ctl_b.add(scrollPane_ctl_b, BorderLayout.CENTER);

//        ---------------------
        JLabel lb_ctl_c = new JLabel("C: ");
        lb_ctl_c.setFont(font);
        JPanel pn_ctl_c = new JPanel();
        pn_ctl_c.setPreferredSize(new Dimension(0, 30));
        pn_ctl_c.setLayout(new BorderLayout());
        JTextArea txt_ctl_c = new JTextArea();
        txt_ctl_c.setLineWrap(true);
        txt_ctl_c.setEnabled(false);

        JScrollPane scrollPane_ctl_c = new JScrollPane(txt_ctl_c);
        pn_ctl_c.add(scrollPane_ctl_c, BorderLayout.CENTER);
//        ------------------
        JLabel lb_ctl_d = new JLabel("D: ");
        lb_ctl_d.setFont(font);
        JPanel pn_ctl_d = new JPanel();
        pn_ctl_d.setPreferredSize(new Dimension(0, 30));
        pn_ctl_d.setLayout(new BorderLayout());
        JTextArea txt_ctl_d = new JTextArea();
        txt_ctl_d.setLineWrap(true);
        txt_ctl_d.setEnabled(false);

        JScrollPane scrollPane_ctl_d = new JScrollPane(txt_ctl_d);
        pn_ctl_d.add(scrollPane_ctl_d, BorderLayout.CENTER);
        
        layout_center.setHorizontalGroup(
                layout_center.createSequentialGroup()
                        .addGroup(layout_center.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lb_cauHoi)
                                .addComponent(lb_ctl_a)
                                .addComponent(lb_ctl_b)
                                .addComponent(lb_ctl_c)
                                .addComponent(lb_ctl_d))
                        .addGroup(layout_center.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(pn_cauHoi)
                                .addComponent(pn_ctl_a)
                                .addComponent(pn_ctl_b)
                                .addComponent(pn_ctl_c)
                                .addComponent(pn_ctl_d))
        );
        
        layout_center.setVerticalGroup(
                layout_center.createSequentialGroup()
                        .addGroup(layout_center.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_cauHoi)
                                .addComponent(pn_cauHoi))
                        .addGroup(layout_center.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_ctl_a)
                                .addComponent(pn_ctl_a))
                        .addGroup(layout_center.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_ctl_b)
                                .addComponent(pn_ctl_b))
                        .addGroup(layout_center.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_ctl_c)
                                .addComponent(pn_ctl_c))
                        .addGroup(layout_center.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_ctl_d)
                                .addComponent(pn_ctl_d))
        );
        
        JPanel pn_thongTinGV = new JPanel(new FlowLayout(0,10,10));
        
        String maGV ="GV1";
        String tenGV ="Lý Mạc Sầu";
        JLabel lb_thongTinGV = new JLabel("Câu hỏi được tạo bởi: "+maGV+"-"+tenGV);
        lb_thongTinGV.setFont(font);
        
        pn_thongTinGV.add(lb_thongTinGV);

        this.getContentPane().add(pn_header, BorderLayout.NORTH);
        this.getContentPane().add(pn_center, BorderLayout.CENTER);
        this.getContentPane().add(pn_thongTinGV, BorderLayout.SOUTH);
        
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FrameXemChiTietCauHoi();
    }
}
