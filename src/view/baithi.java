package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class baithi extends JPanel {

    private JPanel pnThongTin, pnCauHoi;
    private JLabel lblTitle, lblTen, lblNgaySinh, lblMonThi, lblSoCauHoi, lblThoiGian, lblCauHoi;
    private JTextField txtTen, txtNgaySinh, txtMonThi, txtSoCauHoi, txtThoiGian;
    private JTextArea txtNoiDungCauHoi;
    private JRadioButton rdA, rdB, rdC, rdD;
    private JButton btnDau, btnTruoc, btnSau, btnCuoi, btnNopBai;
    private ButtonGroup btnGr1;
    private Font font = new Font("Segoe UI", Font.PLAIN, 15);
    private Font fontTitle = new Font("Segoe UI", Font.BOLD, 15);

    public baithi() {
        init();
        initComponents();
        showLayout();
    }

    public void init() {
        this.setBackground(Color.decode("#D8A3AB"));
        this.setPreferredSize(new Dimension(1000, 550));

        pnThongTin = new JPanel();
        pnThongTin.setLayout(new GridLayout(3, 1));
        pnThongTin.setPreferredSize(new Dimension(1000, 100));
        pnThongTin.setBackground(Color.decode("#D8A3AB"));

        pnCauHoi = new JPanel();
        pnCauHoi.setPreferredSize(new Dimension(1000, 400));
        pnCauHoi.setBackground(Color.decode("#D8A3AB"));

        pnThongTin.setVisible(true);
        pnCauHoi.setVisible(true);
        this.add(pnThongTin);
        this.add(pnCauHoi);
    }

    public void initComponents() {
        lblTitle = new JLabel("Thông tin thí sinh môn thi");
        lblTitle.setFont(fontTitle);
        JPanel pnTitle = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnTitle.setBackground(Color.decode("#D8A3AB"));
        pnTitle.add(lblTitle);

        lblTen = new JLabel("Họ và tên ");
        txtTen = new JTextField(25);
        txtTen.setBorder(null);
        lblTen.setFont(fontTitle);
        txtTen.setFont(font);

        lblNgaySinh = new JLabel("Ngày sinh ");
        txtNgaySinh = new JTextField(25);
        txtNgaySinh.setBorder(null);
        lblNgaySinh.setFont(fontTitle);
        txtNgaySinh.setFont(font);

        lblMonThi = new JLabel("Môn thi ");
        txtMonThi = new JTextField(25);
        txtMonThi.setBorder(null);
        lblMonThi.setFont(fontTitle);
        txtMonThi.setFont(font);

        lblSoCauHoi = new JLabel("Số câu hỏi ");
        txtSoCauHoi = new JTextField(25);
        txtSoCauHoi.setBorder(null);
        lblSoCauHoi.setFont(fontTitle);
        txtSoCauHoi.setFont(font);

        lblThoiGian = new JLabel("Thời gian còn lại ");
        lblThoiGian.setFont(fontTitle);
        txtThoiGian = new JTextField(25);
        txtThoiGian.setBorder(null);
        txtThoiGian.setFont(font);

        JPanel pnThoiGian = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        pnThoiGian.setBackground(Color.decode("#D8A3AB"));
        pnThoiGian.add(lblThoiGian);

        JPanel pnInfo = new JPanel();
        pnInfo.setBackground(Color.decode("#D8A3AB"));
        GroupLayout thongTin = new GroupLayout(pnInfo);
        pnInfo.setLayout(thongTin);
        pnInfo.setPreferredSize(new Dimension(1000, 60));
        thongTin.setAutoCreateGaps(true);
        thongTin.setAutoCreateContainerGaps(true);
        thongTin.setHorizontalGroup(thongTin.createSequentialGroup()
                .addComponent(lblTen)
                .addComponent(txtTen)
                .addComponent(lblNgaySinh)
                .addComponent(txtNgaySinh)
                .addComponent(lblMonThi)
                .addComponent(txtMonThi)
                .addComponent(lblSoCauHoi)
                .addComponent(txtSoCauHoi)
                .addComponent(txtThoiGian)
        );
        thongTin.setVerticalGroup(thongTin.createSequentialGroup()
                .addGroup(thongTin.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTen)
                        .addComponent(txtTen)
                        .addComponent(lblNgaySinh)
                        .addComponent(txtNgaySinh)
                        .addComponent(lblMonThi)
                        .addComponent(txtMonThi)
                        .addComponent(lblSoCauHoi)
                        .addComponent(txtSoCauHoi)
                        .addComponent(txtThoiGian))
        );

        pnThongTin.add(pnTitle);
        pnThongTin.add(pnThoiGian);
        pnThongTin.add(pnInfo);

        lblCauHoi = new JLabel("Câu hỏi 1:");
        JPanel pnThuTu = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnThuTu.setBackground(Color.decode("#D8A3AB"));
        pnThuTu.setPreferredSize(new Dimension(1000, 30));
        pnThuTu.add(lblCauHoi);

        txtNoiDungCauHoi = new JTextArea();
        txtNoiDungCauHoi.setPreferredSize(new Dimension(900, 100));
        txtNoiDungCauHoi.setBorder(null);
        lblCauHoi.setFont(fontTitle);
        txtNoiDungCauHoi.setFont(font);

        JPanel pnNoiDung = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnNoiDung.setBackground(Color.decode("#D8A3AB"));
        pnNoiDung.setPreferredSize(new Dimension(900, 100));
        pnNoiDung.add(txtNoiDungCauHoi);

        rdA = new JRadioButton("A. Ngôn ngữ C");
        rdA.setBackground(Color.decode("#D8A3AB"));
        rdB = new JRadioButton("B. Ngôn ngữ C++");
        rdB.setBackground(Color.decode("#D8A3AB"));
        rdC = new JRadioButton("C. Ngôn ngữ Php");
        rdC.setBackground(Color.decode("#D8A3AB"));
        rdD = new JRadioButton("D. Ngôn Ngữ C#");
        rdD.setBackground(Color.decode("#D8A3AB"));
        rdA.setFont(font);
        rdB.setFont(font);
        rdC.setFont(font);
        rdD.setFont(font);

        btnGr1 = new ButtonGroup();
        btnGr1.add(rdA);
        btnGr1.add(rdB);
        btnGr1.add(rdC);
        btnGr1.add(rdD);

        JPanel pnDapAn = new JPanel();
        pnDapAn.setBackground(Color.decode("#D8A3AB"));
        pnDapAn.setPreferredSize(new Dimension(1000, 150));
        GroupLayout dapAn = new GroupLayout(pnDapAn);
        pnDapAn.setLayout(dapAn);
        dapAn.setAutoCreateGaps(true);
        dapAn.setAutoCreateContainerGaps(true);

        dapAn.setHorizontalGroup(dapAn.createSequentialGroup()
                .addGroup(dapAn.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(rdA)
                        .addComponent(rdB)
                        .addComponent(rdC)
                        .addComponent(rdD)
                )
        );
        dapAn.setVerticalGroup(dapAn.createSequentialGroup()
                .addComponent(rdA)
                .addComponent(rdB)
                .addComponent(rdC)
                .addComponent(rdD)
        );

        JPanel pnA = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnA.setBackground(Color.decode("#D8A3AB"));
        pnA.setPreferredSize(new Dimension(1000, 150));
        pnA.add(pnDapAn);
        
        btnDau = new JButton("<< Câu đầu");
        btnDau.setBackground(new Color(0x74BFB2));
        btnDau.setFont(fontTitle);

        btnTruoc = new JButton("< Câu trước");
        btnTruoc.setBackground(new Color(0x74BFB2));
        btnTruoc.setFont(fontTitle);

        btnSau = new JButton("Câu sau >");
        btnSau.setBackground(new Color(0x74BFB2));
        btnSau.setFont(fontTitle);

        btnCuoi = new JButton("Câu cuối >>");
        btnCuoi.setBackground(new Color(0x74BFB2));
        btnCuoi.setFont(fontTitle);

        btnNopBai = new JButton("Nộp bài");
        btnNopBai.setBackground(new Color(0x74BFB2));
        btnNopBai.setFont(fontTitle);

        JPanel pnBtn = new JPanel();
        pnBtn.setPreferredSize(new Dimension(1000, 50));
        pnBtn.setBackground(Color.decode("#D8A3AB"));
        GroupLayout chuyenHuong = new GroupLayout(pnBtn);
        pnBtn.setLayout(chuyenHuong);
        chuyenHuong.setAutoCreateGaps(true);
        chuyenHuong.setAutoCreateContainerGaps(true);
        chuyenHuong.setHorizontalGroup(chuyenHuong.createSequentialGroup()
                .addComponent(btnDau)
                .addComponent(btnTruoc)
                .addComponent(btnSau)
                .addComponent(btnCuoi)
                .addComponent(btnNopBai)
        );
        chuyenHuong.setVerticalGroup(chuyenHuong.createParallelGroup(GroupLayout.Alignment.BASELINE)
                .addComponent(btnDau)
                .addComponent(btnTruoc)
                .addComponent(btnSau)
                .addComponent(btnCuoi)
                .addComponent(btnNopBai)
        );
        pnCauHoi.setLayout(new BoxLayout(pnCauHoi, BoxLayout.Y_AXIS));

        pnCauHoi.setLayout(new BoxLayout(pnCauHoi, BoxLayout.Y_AXIS));

        pnCauHoi.add(pnThuTu);
        pnCauHoi.add(pnNoiDung);
        pnCauHoi.add(pnA);
        pnCauHoi.add(Box.createVerticalGlue()); // Thêm vertical glue để căn giữa
        pnCauHoi.add(pnBtn);

    }

    public void showLayout() {
        GroupLayout thongTin = new GroupLayout(pnThongTin);

    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        baithi b = new baithi();
        f.add(b);
        f.setSize(800, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.pack();
        f.setResizable(false);
        f.setLocationRelativeTo(null);
    }
}
