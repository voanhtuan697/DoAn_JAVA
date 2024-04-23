package view;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import static javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION;
import static javax.swing.border.TitledBorder.DEFAULT_POSITION;
import static model.base.dark_blue;
import static model.base.dark_green;
import static model.base.font14;
import static model.base.font16;
import static model.base.white;

public class FrameBaiThi extends JFrame {

    private JPanel pnLeft, pnRight;
    private JLabel lbTenKT, lbTGian;
    private JLabel lMaSv, lTenSV, lTenGV, lTgian, lMon, lbCauHoi;
    private JRadioButton rdA, rdB, rdC, rdD;
    private JButton btnNopBai;

    public FrameBaiThi() {
        init();
        initComponents();
        this.setVisible(true);
    }

    public void init() {
        setSize(new Dimension(1200, 700));
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pnLeft = new JPanel(new BorderLayout());
        pnRight = new JPanel(new BorderLayout());
        pnRight.setPreferredSize(new Dimension(300, 0));
        this.add(pnLeft, BorderLayout.CENTER);
        this.add(pnRight, BorderLayout.EAST);
        this.setResizable(false);
    }

    public void initComponents() {
        JPanel pnTopL = new JPanel(new BorderLayout());

        JPanel pnInfo = new JPanel(new BorderLayout());
        pnInfo.setBackground(white);
        lbTenKT = new JLabel("Bai kiem tra cuoi hoc ki II");
        lbTenKT.setFont(font16);
        JLabel lbNameTG = new JLabel("Thời gian còn lại:");
        lbNameTG.setFont(font14);
        lbNameTG.setForeground(white);
        lbTGian = new JLabel("15:45");
        lbTGian.setForeground(white);
        lbTGian.setFont(font14);
        JPanel pnTime = new JPanel(new FlowLayout());
        pnTime.setBackground(dark_green);
        pnTime.add(lbNameTG);
        pnTime.add(lbTGian);
        pnInfo.add(lbTenKT, BorderLayout.CENTER);
        pnInfo.add(pnTime, BorderLayout.EAST);
        pnInfo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 3));

        JPanel pnttss = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnttss.setBorder(BorderFactory.createTitledBorder(null, "Thông tin thí sinh môn thi", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font14) {
        }));
        pnttss.setBackground(white);

        lMaSv = new JLabel("31230090");
        lMaSv.setFont(font14);
        lTenSV = new JLabel("Đinh Thị Quỳnh");
        lTenSV.setFont(font14);
        lTenGV = new JLabel("Mạc Thiên Nhi");
        lTenGV.setFont(font14);
        lTgian = new JLabel("10 Phút");
        lTgian.setFont(font14);
        lMon = new JLabel("Kỹ thuật lập trình");
        lMon.setFont(font14);

        JPanel pnMaSV = creatJPanle("Mã sinh viên:", lMaSv);
        JPanel pnTenSV = creatJPanle("Họ và tên:", lTenSV);
        JPanel pnMon = creatJPanle("Môn thi:", lMon);
        JPanel pnTGian = creatJPanle("Thời gian làm bài:", lTgian);
        JPanel pnTenGV = creatJPanle("Giảng viên ra đề:", lTenGV);
        pnttss.add(pnMaSV);
        pnttss.add(pnTenSV);
        pnttss.add(pnTenGV);
        pnttss.add(pnMon);
        pnttss.add(pnTGian);
        pnTopL.add(pnInfo, BorderLayout.CENTER);
        pnTopL.add(pnttss, BorderLayout.SOUTH);

        JPanel pnBottomL = new JPanel(new BorderLayout());
        pnBottomL.setBackground(white);
        JPanel pnLeftB = new JPanel(new BorderLayout());
        JPanel pnCauHoi = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnCauHoi.setBackground(white);
        pnCauHoi.setBorder(BorderFactory.createTitledBorder(null, "Câu hỏi 1", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font14) {
        }));
        lbCauHoi = new JLabel("Những ngôn ngữ lập trình bạn đã học?");
        lbCauHoi.setFont(font14);
        pnCauHoi.add(lbCauHoi);

        JPanel pnChonDA = new JPanel(new GridLayout(4, 1));
        pnChonDA.setBorder(BorderFactory.createTitledBorder(null, "Chọn đáp án", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font14) {
        }));
        pnChonDA.setBackground(white);
        rdA = new JRadioButton("C");
        rdA.setBackground(white);
        rdA.setFont(font14);
        rdB = new JRadioButton("X");
        rdB.setBackground(white);
        rdB.setFont(font14);
        rdC = new JRadioButton("Y");
        rdC.setBackground(white);
        rdC.setFont(font14);
        rdD = new JRadioButton("Z");
        rdD.setBackground(white);
        rdD.setFont(font14);
        ButtonGroup group = new ButtonGroup();
        group.add(rdA);
        group.add(rdB);
        group.add(rdC);
        group.add(rdD);

        pnChonDA.add(rdA);
        pnChonDA.add(rdB);
        pnChonDA.add(rdC);
        pnChonDA.add(rdD);

        pnLeftB.add(pnCauHoi, BorderLayout.CENTER);
        pnLeftB.add(pnChonDA, BorderLayout.SOUTH);

        JPanel pnRightB = new JPanel(new BorderLayout());
        pnRightB.setBorder(BorderFactory.createTitledBorder(null, "Hình ảnh", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font14) {
        }));
        pnRightB.setPreferredSize(new Dimension(300, 0));
        pnRightB.setBackground(white);

        pnBottomL.add(pnLeftB, BorderLayout.CENTER);
        pnBottomL.add(pnRightB, BorderLayout.EAST);

        pnLeft.add(pnTopL, BorderLayout.NORTH);
        pnLeft.add(pnBottomL, BorderLayout.CENTER);

        JPanel pndsch = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pndsch.setBackground(dark_blue);
        JLabel lblTiteds = new JLabel("Danh sách câu hỏi", JLabel.CENTER);
        lblTiteds.setForeground(white);
        lblTiteds.setFont(font14);
        pndsch.add(lblTiteds);

        JPanel pnContent = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        pnContent.setBorder(BorderFactory.createTitledBorder(null, "", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font14) {
        }));
        pnContent.setBackground(white);

        for (int i = 1; i <= 10; i++) {
            JButton btn = new JButton("Câu hỏi " + i);
            btn.setPreferredSize(new Dimension(100, 25));
            pnContent.add(btn);
        }

        JPanel pnButton = new JPanel(new GridLayout(1, 1));
        btnNopBai = new JButton("Nộp Bài Thi");
        btnNopBai.setBackground(dark_green);
        btnNopBai.setForeground(white);
        btnNopBai.setBorderPainted(false);
        btnNopBai.setFocusPainted(false);
        btnNopBai.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnButton.add(btnNopBai);

        pnRight.add(pndsch, BorderLayout.NORTH);
        pnRight.add(pnContent, BorderLayout.CENTER);
        pnRight.add(pnButton, BorderLayout.SOUTH);

    }

    private JPanel creatJPanle(String txt1, JLabel lbText) {
        JPanel pn = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lb1 = new JLabel(txt1);
        pn.setBackground(white);
        lb1.setFont(font14);
        pn.add(lb1);
        pn.add(lbText);
        return pn;
    }

    public static void main(String[] args) {
        new FrameBaiThi();
    }

}
