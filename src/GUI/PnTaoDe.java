
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.*;
import DTO.*;
import static GUI.BASE.createResizedIcon;
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
import static GUI.BASE.font14;
import static GUI.BASE.font16;
import static GUI.BASE.gray_bg;
import static GUI.BASE.white;
import XULY.ShowDiaLog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.SwingUtilities;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JSpinner.DateEditor;

public class PnTaoDe extends JPanel {

//    pnRight
    private DefaultTableModel model_left;
    private DefaultTableModel model_right;
    private Object[] columns = {"Mã câu hỏi", "Nội dung"};

//    private JComboBox<String> cbb_nguoiTao;
    private JTextField txt_ndCH;
    private JTable table_left, table_right;
    private JButton btnThemRight, btnXoaRight;
    private ArrayList<String> dsMaCH = new ArrayList<>();
    private cauHoiBUS ch;
//    private String tenMon = "Quản trị doanh nghiệp";
    private String maTK = "TK8";
//
    private JPanel pnRight, pnLeft;
    private JTextField tfTenDe, tfTgian, tfMatKhau;
    private JLabel lblDaChonCH;
    private JButton btnChonCH;
    private SpinnerModel spSLCH;
    private JSpinner.DateEditor dateEditor;
    private JSpinner dateTime;
    private JButton btnLop, btnThem, btnSua, btnXoa;
    private JTable tblDeThi, tblDSCH;
    private DefaultTableModel modelDSCH, modelDeThi;
    Object[] colDeThi = {"Mã đề thi", "Người tạo", "Tên đề thi", "Môn thi", "Số câu hỏi", "Ngày thi", "Thời gian", "Lớp", "Mật khẩu"};

    private JComboBox cbbMon, cbbLop;
    private ArrayList<String> dsCauHoi = new ArrayList<>();
    private JFormattedTextField txtNgayGio;

    public PnTaoDe() throws SQLException {
//        this.maTK = maTK;
        init();
        initComponents();
        loadData();

        loadTable_Left();
        addEvent1();
        addEvent2();

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
        pndethi.setBorder(BorderFactory.createTitledBorder(null, "Danh sách đề thi", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font16) {
        }));
        pndethi.setBackground(gray_bg);

        modelDeThi = new DefaultTableModel(colDeThi, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblDeThi = new JTable(modelDeThi);
        setTableFont(tblDeThi);

        JScrollPane scrDeThi = new JScrollPane(tblDeThi);
        pndethi.add(scrDeThi);

        JPanel pnctdethi = new JPanel();
        pnctdethi.setBorder(BorderFactory.createTitledBorder(null, "Chi tiết đề thi", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font16) {
        }));
        pnctdethi.setBackground(gray_bg);
        JLabel lblTenDe, lblNgayThi, lblTgian, lblMatKhau, lblChon;

        lblTenDe = new JLabel("Tên đề thi:");
        lblTenDe.setFont(font16);
        lblNgayThi = new JLabel("Ngày thi:");
        lblNgayThi.setFont(font16);
        lblTgian = new JLabel("Thời gian(phút):");
        lblTgian.setFont(font16);
        lblMatKhau = new JLabel("Mật khẩu:");
        lblMatKhau.setFont(font16);

        lblChon = new JLabel("Chọn môn & lớp:");
        lblChon.setFont(font16);

        SpinnerDateModel modeldate = new SpinnerDateModel();
        dateTime = new JSpinner(modeldate);
        dateEditor = new JSpinner.DateEditor(dateTime, "dd/MM/yyyy HH:mm:ss");
        dateTime.setEditor(dateEditor);
        txtNgayGio = dateEditor.getTextField();

        cbbMon = new JComboBox();
        cbbLop = new JComboBox();
//        btnLop = new JButton("Chọn lớp");
//        btnLop.setBackground(dark_green);
//        btnLop.setFont(font14);
//        btnLop.setForeground(white);
//        btnLop.setBorderPainted(false);
//        btnLop.setFocusPainted(false);
//        btnLop.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnThem = new JButton("Tạo đề thi");
        btnThem.setBackground(dark_green);
        btnThem.setFont(font14);
        btnThem.setForeground(white);
        btnThem.setBorderPainted(false);
        btnThem.setFocusPainted(false);
        btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnSua = new JButton(" Cập nhật ");
        btnSua.setBackground(dark_green);
        btnSua.setFont(font14);
        btnSua.setForeground(white);
        btnSua.setBorderPainted(false);
        btnSua.setFocusPainted(false);
        btnSua.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnXoa = new JButton("     Xóa     ");
        btnXoa.setBackground(dark_green);
        btnXoa.setFont(font14);
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
                        .addComponent(lblChon)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(tfTenDe)
                        .addComponent(dateTime)
                        .addComponent(tfTgian)
                        .addComponent(tfMatKhau)
                        .addComponent(cbbMon)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(btnThem)
                        .addComponent(btnSua)
                        .addComponent(btnXoa)
                        .addGap(grap)
                        .addComponent(cbbLop)
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
                .addGap(grap)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(lblChon)
                        .addComponent(cbbMon)
                        .addComponent(cbbLop)
                )
        //                .addComponent(btnLop)
        );
        pnLeft.add(pndethi, BorderLayout.CENTER);
        pnLeft.add(pnctdethi, BorderLayout.SOUTH);

        pnRight.setBorder(BorderFactory.createTitledBorder(null, "Danh sách câu hỏi đề thi", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font16) {
        }));
        pnRight.setBackground(gray_bg);
        /*
        JPanel pnInput = new JPanel(new BorderLayout());
        pnInput.setBackground(gray_bg);
        JLabel lblSL = new JLabel("Số lượng câu hỏi:");
        lblSL.setBackground(gray_bg);
        lblSL.setFont(font16);
        spSLCH = new SpinnerNumberModel(0, 0, 50, 1);
        JSpinner spinner = new JSpinner(spSLCH);
        JLabel lblDaChon = new JLabel("Đã chọn:");
        lblDaChon.setFont(font16);
        lblDaChonCH = new JLabel("0");
        lblDaChonCH.setFont(font16);
        btnChonCH = new JButton("Chọn câu hỏi");
        btnChonCH.setFont(font14);
        btnChonCH.setForeground(white);
        btnChonCH.setBackground(dark_green);
        btnChonCH.setPreferredSize(new Dimension(160, 25));
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

        modelDSCH = new DefaultTableModel(colDSCH, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblDSCH = new JTable(modelDSCH);
        setTableFont(tblDSCH);
        tblDSCH.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrDSCH = new JScrollPane(tblDSCH);
        pnTable.add(scrDSCH, BorderLayout.CENTER);*/

//        pnRight.add(pnInput, BorderLayout.NORTH);
//        pnRight.add(pnTable, BorderLayout.CENTER);
        JPanel pn_header = new JPanel(new FlowLayout(0, 10, 10));
        JLabel lb_ndCH = new JLabel("Câu hỏi:");
        txt_ndCH = new JTextField(15);
//        JLabel lb_nguoiTao = new JLabel("Câu hỏi tạo bởi:");
//        String[] items = {"Tất cả giảng viên", "Chính mình"};
//        cbb_nguoiTao = new JComboBox<>(items);
        pn_header.add(lb_ndCH);
        pn_header.add(txt_ndCH);
//        pn_header.add(lb_nguoiTao);
//        pn_header.add(cbb_nguoiTao);

        JPanel pn_table = new JPanel();
        GroupLayout layout_table = new GroupLayout(pn_table);
        pn_table.setLayout(layout_table);

        JLabel lb_khoCH = new JLabel("Kho câu hỏi");
        JLabel lb_deThi = new JLabel("Đề thi");

        JPanel pn_table_left = new JPanel();
        pn_table_left.setLayout(new BorderLayout());

        Object[][] data_left = {
            {"L1", "CNTT"},
            {"L1", "CNTT"},};

//        model_left = new DefaultTableModel(data_left, columns);
        table_left = new JTable(model_left) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JScrollPane scrollPane_table_left = new JScrollPane(table_left);
        pn_table_left.add(scrollPane_table_left, BorderLayout.CENTER);
//        --------------------------------------
        JPanel pn_table_right = new JPanel();

        pn_table_right.setLayout(new BorderLayout());

        Object[][] data_right = {
            {"L1", "CNTT"},
            {"L1", "CNTT"},};

        model_right = new DefaultTableModel();
        model_right.addColumn("Nội dung");
        table_right = new JTable(model_right) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JScrollPane scrollPane_table_right = new JScrollPane(table_right);
        pn_table_right.add(scrollPane_table_right, BorderLayout.CENTER);

        JPanel pn_btn_center = new JPanel();
        pn_btn_center.setLayout(new BoxLayout(pn_btn_center, 1));
        pn_btn_center.setPreferredSize(new Dimension(100, 0));

        pn_btn_center.add(Box.createVerticalGlue());

        btnThemRight = new JButton();
        btnThemRight.setBorderPainted(false);
        btnThemRight.setFocusPainted(false);
        btnThemRight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnThemRight.setIcon(createResizedIcon(FrameThemCHVaoDe.class, "..//image//right-icon.png", 20, 20));
        pn_btn_center.add(btnThemRight);

        pn_btn_center.add(Box.createVerticalStrut(20));

        btnXoaRight = new JButton();
        btnXoaRight.setBorderPainted(false);
        btnXoaRight.setFocusPainted(false);
        btnXoaRight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnXoaRight.setIcon(createResizedIcon(FrameThemCHVaoDe.class, "..//image//left-icon.png", 20, 20));
        pn_btn_center.add(btnXoaRight);
        pn_btn_center.add(Box.createVerticalGlue());

        layout_table.setHorizontalGroup(
                layout_table.createSequentialGroup()
                        .addGroup(layout_table.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lb_khoCH)
                                .addComponent(pn_table_left))
                        .addComponent(pn_btn_center)
                        .addGroup(layout_table.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lb_deThi)
                                .addComponent(pn_table_right))
        );

        layout_table.setVerticalGroup(
                layout_table.createSequentialGroup()
                        .addGroup(layout_table.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_khoCH)
                                .addComponent(lb_deThi))
                        .addGroup(layout_table.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(pn_table_left)
                                .addComponent(pn_table_right)
                                .addComponent(pn_btn_center)
                        )
        );

//        JPanel pn_btn = new JPanel(new FlowLayout(0, 10, 10));
//        btnHoanThanhRight = new JButton("Hoàn thành");
//        btnHoanThanhRight.setBorderPainted(false);
//        btnHoanThanhRight.setFocusPainted(false);
//        btnHoanThanhRight.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//        pn_btn.add(btnHoanThanhRight);
        pnRight.add(pn_header, BorderLayout.NORTH);
        pnRight.add(pn_table, BorderLayout.CENTER);
//        pnRight.add(pn_btn, BorderLayout.SOUTH);

    }

    private void setTableFont(JTable table) {
        table.setFont(font14);

        JTableHeader header = table.getTableHeader();
        header.setFont(font14);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setFont(font14);
        table.setDefaultRenderer(Object.class, renderer);
    }

    public void loadData() throws SQLException {
        loadDSDT();
        loadCbbMonLop();
        this.revalidate();
        this.repaint();

    }

    public void loadDSDT() throws SQLException {
        modelDeThi = new DefaultTableModel(colDeThi, 0);
        for (deThiDTO x : new deThiBUS().layDanhSachDeThi()) {
            modelDeThi.addRow(new Object[]{x.getMaDT(), new nguoiDungBUS().layTenNguoiDungTheoMaTK(x.getMaGV()), x.getTenDeThi(), new monBUS().layTenMonTheoMaDeThi(x.getMaDT()),
                x.getSLCauHoi(), x.getNgayThi(), x.getThoiGianLamBai(), new chiTietDeLopBUS().layMaLopTheoMaDT(x.getMaDT()), x.getMatKhau()});
        }
        tblDeThi.setModel(modelDeThi);

    }

    public void loadCbbMonLop() throws SQLException {
        for (monDTO x : new monBUS().layMonTuLop()) {
            cbbMon.addItem(x.getTenMon());
        }
        for (String x : new lopBUS().layMaLopTheoMon(cbbMon.getSelectedItem().toString())) {
            cbbLop.addItem(x);
        }
        cbbLop.revalidate();
        cbbLop.repaint();
    }

    public void addEvent1() throws SQLException {
        cbbMon.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cbbLop.removeAllItems();
                try {
                    for (String x : new lopBUS().layMaLopTheoMon(cbbMon.getSelectedItem().toString())) {
                        cbbLop.addItem(x);
                    }
                    cbbLop.revalidate();
                    cbbLop.repaint();
                    loadTable_Left();
                    table_left.revalidate();
                    table_left.repaint();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfTenDe.getText().trim().isEmpty()) {
                    new ShowDiaLog("Vui lòng nhập tên đề thi!", ShowDiaLog.ERROR_DIALONG);
                    tfTenDe.requestFocus();
                    tfTenDe.selectAll();
                    return;
                }
                if (tfTgian.getText().trim().isEmpty()) {
                    new ShowDiaLog("Vui lòng nhập thời gian làm bài!", ShowDiaLog.ERROR_DIALONG);
                    tfTgian.requestFocus();
                    tfTgian.selectAll();
                    return;
                }
                if (tfMatKhau.getText().trim().isEmpty()) {
                    new ShowDiaLog("Vui lòng nhập mật khẩu đề thi!", ShowDiaLog.ERROR_DIALONG);
                    tfMatKhau.requestFocus();
                    tfMatKhau.selectAll();
                    return;
                }
                if (!isVietnamese(tfTenDe.getText().trim())) {
                    new ShowDiaLog("Tên đề thi không hợp lệ!", ShowDiaLog.ERROR_DIALONG);
                    tfTenDe.requestFocus();
                    tfTenDe.selectAll();
                    return;
                }
                if (!isNumber(tfTgian.getText().trim())) {
                    new ShowDiaLog("Thời gian làm bài không hợp lệ!", ShowDiaLog.ERROR_DIALONG);
                    tfTgian.requestFocus();
                    tfTgian.selectAll();
                    return;
                }
                if (dsMaCH.size() == 0) {
                    new ShowDiaLog("Vui lòng chọn câu hỏi!", ShowDiaLog.ERROR_DIALONG);
                    return;
                }
                try {
                    String maMon = new monBUS().layMaMonTheoTenMon(cbbMon.getSelectedItem().toString()).trim().substring(1);
                    int soLuongDe = new deThiBUS().laySoLuongDeThiTheoMon(new monBUS().layMaMonTheoTenMon(cbbMon.getSelectedItem().toString())) + 1;
                    String maDT = "DT" + maMon + Integer.toString(soLuongDe);
                    String tenDT = tfTenDe.getText();
                    String matKhau = tfMatKhau.getText();
                    SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                    SimpleDateFormat newFormat_Date = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat newFormat_Hour = new SimpleDateFormat("HH:mm:ss");

                    String ngay = null;
                    String gio = null;
                    try {
                        Date date = originalFormat.parse(txtNgayGio.getText());
                        ngay = newFormat_Date.format(date);
                        gio = newFormat_Hour.format(date);

                        System.out.println(ngay + gio);
                    } catch (ParseException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(maDT + "\t" + tenDT);

                    java.util.Date ngayThi = newFormat_Date.parse(ngay);
                    Date newGio = newFormat_Hour.parse(gio);
                    Time thoiGianBatDau = new Time(newGio.getTime());
                    int trangThai = 0;
                    int soLuongCau = dsMaCH.size();
                    int thoiGianLamBai = Integer.parseInt(tfTgian.getText());
                    String maLop = cbbLop.getSelectedItem().toString();

                    if (new deThiBUS().themDeThi(maDT, maTK, tenDT, matKhau, ngayThi, thoiGianBatDau, trangThai, soLuongCau, thoiGianLamBai, maLop, dsMaCH)) {
                        new ShowDiaLog("Thêm thành công!", ShowDiaLog.SUCCESS_DIALOG);
                        loadDSDT();
                        dsMaCH.clear();
                        loadTable_Right();
                        tfTenDe.setText("");
                        tfTgian.setText("");
                        tfMatKhau.setText("");
                        return;

                    } else {
                        new ShowDiaLog("Thêm thất bại!", ShowDiaLog.ERROR_DIALONG);
                        return;
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ParseException ex) {
                    Logger.getLogger(PnTaoDe.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        table_left.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    try {
                        String maCH = new cauHoiBUS().layMaCHTheoNoiDung(table_left.getValueAt(table_left.getSelectedRow(), 0).toString());
                        new FrameXemChiTietCauHoi(maCH);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        table_right.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    try {
                        String maCH = new cauHoiBUS().layMaCHTheoNoiDung(table_right.getValueAt(table_right.getSelectedRow(), 0).toString());
                        new FrameXemChiTietCauHoi(maCH);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        /*tblDeThi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = tblDeThi.getSelectedRow();
                try {
                    if (selectedRow != -1) {
                        displayDeThi(selectedRow);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
        });*/
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tblDeThi.getSelectedRow();
                if (selectedRow != -1) {
                    try {
                        String maDT = tblDeThi.getValueAt(selectedRow, 0).toString();
                        for (deThiDTO x : new deThiBUS().layDanhSachDeThi()) {
                            if (x.getMaDT().equalsIgnoreCase(maDT) && x.getTrangThai() == 0) {
                                int a = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn xóa đề thi?", "Thông báo", JOptionPane.YES_NO_OPTION);
                                if (a == JOptionPane.YES_OPTION) {
                                    try {
                                        if (new deThiBUS().xoaDeThiBangMaDT(maDT)) {
                                            new ShowDiaLog("Xóa thành công!", ShowDiaLog.SUCCESS_DIALOG);
                                            loadDSDT();
                                            return;
                                        }
                                    } catch (SQLException ex) {
                                        ex.printStackTrace();
                                    }
                                } else {
                                    return;
                                }
                            }
                        }
                        new ShowDiaLog("Không thể xóa! Đề thi này đã/đang được làm!", ShowDiaLog.ERROR_DIALONG);
                        return;

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                } else {
                    new ShowDiaLog("Vui lòng chọn đề thi cần xóa!", ShowDiaLog.ERROR_DIALONG);
                }
            }
        });
    }

    /*public void displayDeThi(int selectedRow) throws SQLException, ParseException {
        String maDT = tblDeThi.getValueAt(selectedRow, 0).toString();
        System.out.println(maDT);
        tfTenDe.setText(maDT);
        System.out.println(tfTenDe.getText());
        deThiDTO dt = new deThiDTO();
        dt = new deThiBUS().layDeThiTheoMaDT(maDT);
        System.out.println(dt.getNgayThi());
        System.out.println(dt.getThoiGianBatDauThi());
        SimpleDateFormat ngayGioFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date ngayGioDate = ngayGioFormat.parse(dt.getNgayThi() + " " + dt.getThoiGianBatDauThi());
        System.out.println(ngayGioDate);
/*SpinnerDateModel modeldate = new SpinnerDateModel();
        dateTime = new JSpinner(modeldate);
        dateEditor = new JSpinner.DateEditor(dateTime, "dd/MM/yyyy HH:mm:ss");
        dateTime.setEditor(dateEditor);
        
        // Tạo một SpinnerDateModel với giá trị là ngày và giờ đã chuyển đổi
        SpinnerDateModel model = new SpinnerDateModel(ngayGioDate, null, null, java.util.Calendar.HOUR_OF_DAY);

        // Tạo DateEditor cho SpinnerDateModel với định dạng ngày và giờ
        dateTime = new JSpinner(model);
        dateEditor = new JSpinner.DateEditor(dateTime, "dd-MM-yyyy HH:mm:ss");
        dateTime.setEditor(dateEditor);

        System.out.println(txtNgayGio.getText());
        tfTgian.setText(Integer.toString(dt.getThoiGianLamBai()));
        tfMatKhau.setText(dt.getMatKhau());
        String maMon = "M" + maDT.substring(2, maDT.length() - 1);
        System.out.println(maMon);
        cbbMon.setSelectedItem(new monBUS().layTenMonTheoMaMon(maMon).toString());
        cbbMon.revalidate();
        cbbMon.repaint();
        cbbLop.setSelectedItem(new chiTietDeLopBUS().layMaLopTheoMaDT(maDT).toString());
        cbbLop.revalidate();
        cbbLop.repaint();
        for (String x : new chiTietDeBUS().layDSChiTietDeTheoMaDT(maDT)) {
            dsMaCH.add(x);
        }
        loadTable_Right();

    }*/
    public boolean isVietnamese(String str) {
        String regex = "[a-zA-ZàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆđĐìÌỉỈĩĨíÍịỊòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢùÙủỦũŨúÚụỤưỪừỬữỮứỨựỰỳỲỷỶỹỸýÝỵỴ\\s0-9]+$";
        return Pattern.matches(regex, str);
    }

    public boolean isNumber(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
//pnRight

    public void loadTable_Left() throws SQLException {

        ch = new cauHoiBUS();
        model_left = new DefaultTableModel();
        model_left.addColumn("Nội dung");
        if (cbbMon.getSelectedItem().toString() != null) {
            String maMon = new monBUS().layMaMonTheoTenMon(cbbMon.getSelectedItem().toString().trim());
            String maKho = new khoCauHoiBUS().layMaKhoCHTheoMaMon(maMon);

            for (cauHoiDTO x : ch.layDanhSachCauHoi()) {
                if (x.getMaKho().equalsIgnoreCase(maKho) && x.getTrangThai() == true) {
                    model_left.addRow(new Object[]{x.getNoidung()});

                }
            }
        }
        table_left.setModel(model_left);
        this.revalidate();
        this.repaint();
    }

    public void loadTable_Right() throws SQLException {
        ch = new cauHoiBUS();
        model_right = new DefaultTableModel();
        model_right.addColumn("Nội dung");
        for (cauHoiDTO x : ch.layDanhSachCauHoi()) {
            for (String y : dsMaCH) {
                if (x.getMaCH().equalsIgnoreCase(y)) {
                    model_right.addRow(new Object[]{x.getNoidung()});
                }
            }
        }
        table_right.setModel(model_right);
        this.revalidate();
        this.repaint();
    }

    public void luuCauHoiDaChon() throws SQLException {
        String maCH = null;
        int selectedRow = table_left.getSelectedRow();
        if (selectedRow != -1) {
            String noiDungCH = table_left.getValueAt(selectedRow, 0).toString();
            for (cauHoiDTO x : new cauHoiBUS().layDanhSachCauHoi()) {
                if (x.getNoidung().equalsIgnoreCase(noiDungCH)) {
                    for (String y : dsMaCH) {
                        if (y.equalsIgnoreCase(x.getMaCH())) {
                            new ShowDiaLog("Câu hỏi đã được chọn!", ShowDiaLog.ERROR_DIALONG);
                            return;
                        }
                    }

                }
            }
            maCH = new cauHoiBUS().layMaCHTheoNoiDung(noiDungCH);

            dsMaCH.add(maCH);
        }
    }

    public void xoaCauHoiDaChon() throws SQLException {
        String tmp = "";
        int selectedRow = table_right.getSelectedRow();
        if (selectedRow != -1) {
            String noiDungCH = table_right.getValueAt(selectedRow, 0).toString();
            String maCH = new cauHoiBUS().layMaCHTheoNoiDung(noiDungCH);
            for (String x : dsMaCH) {
                if (x.equalsIgnoreCase(maCH)) {
                    tmp = x;
                }
            }
            dsMaCH.remove(tmp);
        }
    }

    public ArrayList<cauHoiDTO> timKiem(ArrayList<cauHoiDTO> ds, String tuKhoa) throws SQLException {
        ArrayList<cauHoiDTO> ketQua = new ArrayList<>();

        for (cauHoiDTO x : new cauHoiBUS().layDanhSachCauHoi()) {
            if (x.getMaCH().toLowerCase().contains(tuKhoa) || x.getNoidung().toLowerCase().contains(tuKhoa)) {
                ketQua.add(x);
            }
        }

        return ketQua;
    }

    public void loadTable_LeftTheoCmb(String ma, String maMon) throws SQLException {
        System.out.println(ma);
        String maKho = new khoCauHoiBUS().layMaKhoCHTheoMaMon(maMon);
        System.out.println(maKho);
        model_left = new DefaultTableModel();
        model_left.addColumn("Nội dung");
        for (cauHoiDTO x : new cauHoiBUS().layDanhSachCauHoi()) {
            System.out.println(x.getMaGV());
            System.out.println(x.getMaKho());

            if (x.getMaKho().trim().equalsIgnoreCase(maKho.trim()) && x.getMaGV().trim().equalsIgnoreCase(ma.trim())) {
                model_left.addRow(new Object[]{x.getNoidung()});

            }
        }
        table_left.setModel(model_left);
        this.revalidate();
        this.repaint();
    }

    public void addEvent2() {
//        this.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                dsMaCH.clear();
//            }
//        });
        btnThemRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (table_right.getSelectedRow() != -1) {
                        new ShowDiaLog("Vui lòng chọn câu hỏi ở bảng bên trái!", ShowDiaLog.ERROR_DIALONG);
                        return;
                    }
                    luuCauHoiDaChon();
                    loadTable_Left();
                    loadTable_Right();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnXoaRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (table_left.getSelectedRow() != -1) {
                        new ShowDiaLog("Vui lòng chọn câu hỏi ở bảng bên phải!", ShowDiaLog.ERROR_DIALONG);
                        return;
                    }
                    xoaCauHoiDaChon();
                    loadTable_Left();
                    loadTable_Right();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        txt_ndCH.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    model_left = new DefaultTableModel();
                    model_left.addColumn("Nội dung");
                    try {
                        ArrayList<cauHoiDTO> ketQua = timKiem(new cauHoiBUS().layDanhSachCauHoi(), txt_ndCH.getText());
                        for (cauHoiDTO y : ketQua) {
                            model_left.addRow(new Object[]{
                                y.getNoidung()
                            });
                            break;
                        }

                        table_left.setModel(model_left);
                        ketQua.clear();
                    } catch (SQLException ex) {
                        ex.printStackTrace();

                    }
                }
            }
        });
        /*cbb_nguoiTao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String luaChon = cbb_nguoiTao.getSelectedItem().toString();
                if (luaChon.equalsIgnoreCase("Tất cả giảng viên")) {
                    try {
                        loadTable_Left();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    try {
                        System.out.println("1");
                        loadTable_LeftTheoCmb(maTK, new monBUS().layMaMonTheoTenMon(cbbMon.getSelectedItem().toString()));
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });*/

    }

    public static void main(String[] args) throws SQLException {
        JFrame f = new JFrame();
        f.setSize(900, 500);
        PnTaoDe p = new PnTaoDe();
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
