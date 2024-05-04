package view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import static javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION;
import static javax.swing.border.TitledBorder.DEFAULT_POSITION;
import javax.swing.text.View;

public class baithi extends JPanel {

    private JPanel pnTop, pnCenter, pnBottom;
    String[] Title = {"Họ và tên:", "Ngày sinh:", "Môn thi:", "Số câu hỏi:", "Thời gian còn lại"};
    JLabel[] lblTitle = new JLabel[5];
    JLabel lblHoTen, lblNgSinh, lblMonthi, lblCauHoi, lblTGian;
    JLabel lblThuTu;
    JTextArea txtNoiDung;
    String[] Answer = {"A. Ngôn ngữ C", "B. Ngôn ngữ C++", "C. Ngôn ngữ Php", "D. Ngôn ngữ C#"};
    JRadioButton[] rdAnswer = new JRadioButton[4];
    String[] button = {"<< Câu đầu", "< Câu trước", "Câu sau >", "Câu cuối >>", "Nộp bài"};
    JButton btnButton[] = new JButton[5];
    private Color colorPink = Color.decode("#D8A3AB");
    private Color colorGreen = Color.decode("#74BFB2");
    Font font = new Font("Segoe UI", Font.PLAIN, 16);

    public baithi() {
        init();
        initComponent();
        showLayout();
    }

    public void init() {
        this.setLayout(new BorderLayout());
        this.setBackground(colorPink);

//        pnTop = new JPanel(new BorderLayout());
pnTop = new JPanel();
        pnTop.setLayout(new GridBagLayout());
        pnTop.setBorder(BorderFactory.createTitledBorder(null, "Thông tin thí sinh môn thi", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, font));
        pnTop.setBackground(colorPink);

        pnCenter = new JPanel(new GridLayout(1, 1));
        pnCenter.setBackground(colorPink);

        pnBottom = new JPanel();
        pnBottom.setLayout(new BoxLayout(pnBottom, BoxLayout.X_AXIS));
        pnBottom.setBackground(colorPink);

        this.add(pnTop, BorderLayout.NORTH);
        this.add(pnCenter, BorderLayout.CENTER);
        this.add(pnBottom, BorderLayout.SOUTH);
    }

    private void initComponent() {
        for (int i = 0; i < lblTitle.length; i++) {
            lblTitle[i] = new JLabel(Title[i]);
            lblTitle[i].setFont(font);
            lblTitle[i].setBackground(colorPink);
            lblTitle[i].setOpaque(true);
        }

        lblHoTen = new JLabel("Nguyễn Thanh Tùng");
        lblHoTen.setFont(font);
        lblHoTen.setBackground(Color.WHITE);
        lblHoTen.setOpaque(true);
        lblHoTen.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lblNgSinh = new JLabel("05/07/1994");
        lblNgSinh.setFont(font);
        lblNgSinh.setBackground(Color.WHITE);
        lblNgSinh.setOpaque(true);
        lblNgSinh.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lblMonthi = new JLabel("Java");
        lblMonthi.setFont(font);
        lblMonthi.setBackground(Color.WHITE);
        lblMonthi.setOpaque(true);
        lblMonthi.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lblTGian = new JLabel("0:0:0");
        lblTGian.setFont(font);
        lblTGian.setBackground(Color.WHITE);
        lblTGian.setOpaque(true);
        lblTGian.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lblCauHoi = new JLabel("50");
        lblCauHoi.setFont(font);
        lblCauHoi.setBackground(Color.WHITE);
        lblCauHoi.setOpaque(true);
        lblCauHoi.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        lblThuTu = new JLabel("Câu hỏi 1: ");
        txtNoiDung = new JTextArea();
        txtNoiDung.setText("Trong các loại ngôn ngữ sau đây, ngôn ngữ nào được giảng dạy trong môn Lập trình web và ứng dụng nâng cao ở SGU?");
        txtNoiDung.setFont(font);
        txtNoiDung.setForeground(Color.BLACK);
        txtNoiDung.setBackground(Color.WHITE);
        txtNoiDung.setEnabled(false);

        for (int i = 0; i < rdAnswer.length; i++) {
            rdAnswer[i] = new JRadioButton(Answer[i]);
            rdAnswer[i].setFont(font);
            rdAnswer[i].setBackground(colorPink);
        }

        for (int i = 0; i < btnButton.length; i++) {
            btnButton[i] = new JButton(button[i]);
            btnButton[i].setFont(font);
            btnButton[i].setBackground(colorGreen);
        }

    }

    private void showLayout() {

        JPanel pnThongTin = new JPanel(new FlowLayout());
        pnThongTin.add(lblTitle[0]);
        pnThongTin.add(lblHoTen);
        pnThongTin.add(lblTitle[1]);
        pnThongTin.add(lblNgSinh);
        pnThongTin.add(lblTitle[2]);
        pnThongTin.add(lblMonthi);
        pnThongTin.add(lblTitle[3]);
        pnThongTin.add(lblCauHoi);
        pnThongTin.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnThongTin.setBackground(colorPink);

        JPanel pnThoiGian = new JPanel(new GridLayout(2, 1));
        pnThoiGian.add(lblTitle[4]);
        pnThoiGian.add(lblTGian);
        pnThoiGian.setBackground(colorPink);
        pnThoiGian.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JPanel pnLeft = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnLeft.add(pnThongTin, BorderLayout.WEST);
        pnLeft.setBackground(colorPink);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0.2;

        gbc.gridx = 0;
        gbc.gridy = 0;
        pnTop.add(pnLeft, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        pnTop.add(pnThoiGian, gbc);
        gbc.insets = new Insets(10, 10, 10, 10);
//        pnTop.add(pnLeft);
//        pnTop.add(pnThoiGian, BorderLayout.EAST);

        ButtonGroup btnGrAnswer = new ButtonGroup();
        for (int i = 0; i < rdAnswer.length; i++) {
            btnGrAnswer.add(rdAnswer[i]);
        }

        JPanel pnNoiDung = new JPanel(new GridLayout(6, 1));
        pnNoiDung.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        pnNoiDung.add(lblThuTu);
        pnNoiDung.add(txtNoiDung);
        pnNoiDung.setBackground(colorPink);

        for (int i = 0; i < rdAnswer.length; i++) {
            pnNoiDung.add(rdAnswer[i]);
        }

        pnCenter.add(pnNoiDung);

        JPanel pnButton = new JPanel(new FlowLayout());
        pnButton.setBackground(colorPink);
        ((FlowLayout) pnButton.getLayout()).setHgap(10);
        for (int i = 0; i < btnButton.length - 1; i++) {
            btnButton[i].setBackground(colorGreen);
            pnButton.add(btnButton[i]);
        }
        btnButton[4].setBackground(colorGreen);

        pnBottom.add(Box.createHorizontalGlue());
        pnBottom.add(pnButton);
        pnBottom.add(Box.createHorizontalGlue());
        pnBottom.add(btnButton[4]);
        pnBottom.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        baithi b = new baithi();
        f.add(b);
        f.setSize(800, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.pack();
        f.setResizable(true);
        f.setLocationRelativeTo(null);
    }
}

