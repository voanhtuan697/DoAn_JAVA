
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import static javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION;
import static javax.swing.border.TitledBorder.DEFAULT_POSITION;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import static GUI.BASE.dark_green;
import static GUI.BASE.font13;
import static GUI.BASE.font14;
import static GUI.BASE.gray_bg;
import static GUI.BASE.white;

public class PnTaoDe extends JPanel {

    private JPanel pnRight, pnLeft;
    private JTextField tfTenDe, tfTgian, tfMatKhau;
    private JLabel lblDaChonCH;
    private JButton btnChonCH;
    private SpinnerModel spSLCH;
    private JSpinner dateTime;
    private JButton btnLop, btnThem, btnSua, btnXoa;
    private JTable tblDeThi, tblDSCH;
    private DefaultTableModel modelDSCH, modelDeThi;

    public PnTaoDe() {
        init();
        initComponents();
    }

    public void init() {
        this.setLayout(new GridLayout(1, 2));
        pnLeft = new JPanel(new BorderLayout());
        pnRight = new JPanel(new BorderLayout());
        this.add(pnLeft);
        this.add(pnRight);
    }

    public void initComponents() {
        JPanel pndethi = new JPanel(new BorderLayout());
        pndethi.setBorder(BorderFactory.createTitledBorder(null, "Danh sách đề thi", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font14) {
        }));
        pndethi.setBackground(gray_bg);
        Object[] colDeThi = {"Mã đề thi", "Người tạo", "Tên đề thi", "Môn thi", "Số câu hỏi", "Ngày thi", "Thời gian", "Lớp", "Mật khẩu"};
        modelDeThi = new DefaultTableModel(colDeThi, 0);

        tblDeThi = new JTable(modelDeThi);
        setTableFont(tblDeThi);

        JScrollPane scrDeThi = new JScrollPane(tblDeThi);
        pndethi.add(scrDeThi);

        JPanel pnctdethi = new JPanel();
        pnctdethi.setBorder(BorderFactory.createTitledBorder(null, "Chi tiết đề thi", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font14) {
        }));
        pnctdethi.setBackground(gray_bg);
        JLabel lblTenDe, lblNgayThi, lblTgian, lblMatKhau;

        lblTenDe = new JLabel("Tên đề thi:");
        lblTenDe.setFont(font14);
        lblNgayThi = new JLabel("Ngày thi:");
        lblNgayThi.setFont(font14);
        lblTgian = new JLabel("Thời gian(phút):");
        lblTgian.setFont(font14);
        lblMatKhau = new JLabel("Mật khẩu:");
        lblMatKhau.setFont(font14);

        SpinnerDateModel modeldate = new SpinnerDateModel();
        dateTime = new JSpinner(modeldate);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(dateTime, "dd/MM/yyyy HH:mm:ss");
        dateTime.setEditor(dateEditor);

        btnLop = new JButton("Chọn lớp");
        btnLop.setBackground(dark_green);
        btnLop.setFont(font13);
        btnLop.setForeground(white);
        btnLop.setBorderPainted(false);
        btnLop.setFocusPainted(false);
        btnLop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnThem = new JButton("Tạo đề thi");
        btnThem.setBackground(dark_green);
        btnThem.setFont(font13);
        btnThem.setForeground(white);
        btnThem.setBorderPainted(false);
        btnThem.setFocusPainted(false);
        btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnSua = new JButton(" Cập nhật ");
        btnSua.setBackground(dark_green);
        btnSua.setFont(font13);
        btnSua.setForeground(white);
        btnSua.setBorderPainted(false);
        btnSua.setFocusPainted(false);
        btnSua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnXoa = new JButton("     Xóa     ");
        btnXoa.setBackground(dark_green);
        btnXoa.setFont(font13);
        btnXoa.setForeground(white);
        btnXoa.setBorderPainted(false);
        btnXoa.setFocusPainted(false);
        btnXoa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        tfTenDe = new JTextField();
        tfTgian = new JTextField();
        tfMatKhau = new JTextField();
        int grap = 20;
        GroupLayout layout = new GroupLayout(pnctdethi);
        pnctdethi.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lblTenDe)
                        .addComponent(lblNgayThi)
                        .addComponent(lblTgian)
                        .addComponent(lblMatKhau)
                        .addComponent(btnLop)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(tfTenDe)
                        .addComponent(dateTime)
                        .addComponent(tfTgian)
                        .addComponent(tfMatKhau)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(btnThem)
                        .addComponent(btnSua)
                        .addComponent(btnXoa)
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTenDe)
                        .addComponent(tfTenDe)
                        .addComponent(btnThem)
                )
                .addGap(grap)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNgayThi)
                        .addComponent(dateTime)
                        .addComponent(btnSua)
                )
                .addGap(grap)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTgian)
                        .addComponent(tfTgian)
                        .addComponent(btnXoa)
                )
                .addGap(grap)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblMatKhau)
                        .addComponent(tfMatKhau)
                )
                .addComponent(btnLop)
        );
        pnLeft.add(pndethi, BorderLayout.CENTER);
        pnLeft.add(pnctdethi, BorderLayout.SOUTH);

        pnRight.setBorder(BorderFactory.createTitledBorder(null, "Danh sách câu hỏi đề thi", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font14) {
        }));
        pnRight.setBackground(gray_bg);

        JPanel pnInput = new JPanel(new BorderLayout());
        pnInput.setBackground(gray_bg);
        JLabel lblSL = new JLabel("Số lượng câu hỏi:");
        lblSL.setBackground(gray_bg);
        lblSL.setFont(font14);
        spSLCH = new SpinnerNumberModel(0, 0, 50, 1);
        JSpinner spinner = new JSpinner(spSLCH);
        JLabel lblDaChon = new JLabel("Đã chọn:");
        lblDaChon.setFont(font14);
        lblDaChonCH = new JLabel("0");
        lblDaChonCH.setFont(font14);
        btnChonCH = new JButton("Chọn câu hỏi");
        btnChonCH.setFont(font13);
        btnChonCH.setForeground(white);
        btnChonCH.setBackground(dark_green);
        btnChonCH.setPreferredSize(new Dimension(110, 25));
        btnChonCH.setBorderPainted(false);
        btnChonCH.setFocusPainted(false);
        btnChonCH.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JPanel pnContainer = new JPanel(new BorderLayout());
        pnContainer.setBackground(gray_bg);

        JPanel pntop = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
        pntop.setBackground(gray_bg);
        pntop.add(lblSL);
        pntop.add(spinner);

        pnContainer.add(pntop, BorderLayout.CENTER);
        pnContainer.add(btnChonCH, BorderLayout.EAST);
        pnContainer.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));
        JPanel pnbottom = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        pnbottom.setBackground(gray_bg);
        pnbottom.add(lblDaChon);
        pnbottom.add(lblDaChonCH);
        pnInput.add(pnContainer, BorderLayout.NORTH);
        pnInput.add(pnbottom, BorderLayout.SOUTH);

        JPanel pnTable = new JPanel(new BorderLayout());
        pnTable.setBackground(gray_bg);
        Object[] colDSCH = {"Mã câu hỏi", "Nội dung", "Cấp độ"};
        modelDSCH = new DefaultTableModel(colDSCH, 0);

        tblDSCH = new JTable(modelDSCH);
        setTableFont(tblDSCH);
        tblDSCH.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrDSCH = new JScrollPane(tblDSCH);
        pnTable.add(scrDSCH, BorderLayout.CENTER);

        pnRight.add(pnInput, BorderLayout.NORTH);
        pnRight.add(pnTable, BorderLayout.CENTER);
    }

    private void setTableFont(JTable table) {
        table.setFont(font13);

        JTableHeader header = table.getTableHeader();
        header.setFont(font13);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setFont(font13);
        table.setDefaultRenderer(Object.class, renderer);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(900, 500);
        PnTaoDe p = new PnTaoDe();
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
