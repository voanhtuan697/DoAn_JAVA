/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.chiTietLopBUS;
import BUS.lopBUS;
import BUS.monBUS;
import BUS.nguoiDungBUS;
import BUS.taiKhoanBUS;
import DTO.lopDTO;
import DTO.monDTO;
import DTO.nguoiDungDTO;
import static GUI.BASE.createResizedIcon;
import static GUI.BASE.dark_green;
import static GUI.BASE.font16;
import static GUI.BASE.font16b;
import static GUI.BASE.font16;
import static GUI.BASE.gray_bg;
import XULY.ShowDiaLog;
import java.awt.BorderLayout;
import static java.awt.Color.white;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class PnThemLopChoSV extends JPanel {

    private JPanel pnTop, pnCenter, pnBottom;
    private JTextField tfTimKiem;
    private JComboBox cbNam, cbHocKy, cbMon, cbLop;
    private JTable table;
    private DefaultTableModel model;
    private String maSV;
    private JButton btnThem;
    private lopBUS busLop;
    private monBUS busMon;
    private nguoiDungBUS busNgDung;
    private chiTietLopBUS busCTLop = new chiTietLopBUS();
    private taiKhoanBUS busTK;
    private ArrayList<String> choose = new ArrayList<>();

    public PnThemLopChoSV() throws SQLException {
        busLop = new lopBUS();
        busTK = new taiKhoanBUS();
        busNgDung = new nguoiDungBUS();
        busMon = new monBUS();
        init();
        initComponents();
        LoadData();
    }

    public void init() {
        this.setLayout(new BorderLayout());
        pnTop = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        pnTop.setBackground(gray_bg);

        pnCenter = new JPanel(new BorderLayout());

        pnBottom = new JPanel(new BorderLayout());
        pnBottom.setBackground(gray_bg);

        this.add(pnTop, BorderLayout.NORTH);
        this.add(pnCenter, BorderLayout.CENTER);
        this.add(pnBottom, BorderLayout.SOUTH);
    }

    public void initComponents() {
        JLabel lblTimKiem, lblNam, lblHocKy, lblTenMon, lblLop;
        lblTimKiem = CreateLabel("Tìm kiếm:");
        lblTimKiem.setFont(font16);
        lblNam = CreateLabel("Năm:");
        lblNam.setFont(font16);
        lblHocKy = CreateLabel("Học kỳ:");
        lblHocKy.setFont(font16);
        lblTenMon = CreateLabel("Tên môn:");
        lblTenMon.setFont(font16);
        lblLop = CreateLabel("Lớp:");
        lblLop.setFont(font16);

        tfTimKiem = new JTextField(15);
        cbHocKy = new JComboBox<>(new Integer[]{1, 2});
        cbHocKy.setPreferredSize(new Dimension(50, cbHocKy.getPreferredSize().height));
        cbHocKy.setFont(font16);
        cbLop = new JComboBox();
        cbLop.setPreferredSize(new Dimension(120, cbLop.getPreferredSize().height));
        cbLop.setFont(font16);
        cbMon = new JComboBox();
        cbMon.setPreferredSize(new Dimension(200, cbMon.getPreferredSize().height));
        cbMon.setFont(font16);
        cbNam = new JComboBox();
        cbNam.setPreferredSize(new Dimension(90, cbNam.getPreferredSize().height));
        cbNam.setFont(font16);

        Object[] columns = {"Mã sinh viên", "Tên sinh viên", "Ngày sinh"};
        model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(model);
        setTableFont(table);
        JScrollPane scrlTable = new JScrollPane(table);

        btnThem = new JButton("Thêm");
        btnThem.setBackground(dark_green);
        btnThem.setFont(font16b);
        btnThem.setForeground(white);
        btnThem.setBorderPainted(false);
        btnThem.setFocusPainted(false);
        btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnThem.setMaximumSize(new Dimension(120, 20));

        pnTop.add(lblTimKiem);
        pnTop.add(tfTimKiem);
        pnCenter.add(scrlTable, BorderLayout.CENTER);

        JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER));
        container.setBackground(gray_bg);
        container.add(lblNam);
        container.add(cbNam);
        container.add(lblHocKy);
        container.add(cbHocKy);
        container.add(lblTenMon);
        container.add(cbMon);
        container.add(lblLop);
        container.add(cbLop);
        container.add(btnThem);

        pnBottom.add(container, BorderLayout.CENTER);

        cbNam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCbLop();
                loadDSSV();
            }
        });

        cbHocKy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCbLop();
                loadDSSV();
            }
        });
        cbMon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCbLop();
                loadDSSV();
            }
        });

        cbMon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadDSSV();
            }
        });

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                choose.clear();
                if (!e.getValueIsAdjusting() && !table.getSelectionModel().isSelectionEmpty()) {
                    int[] selectedRows = table.getSelectedRows();
                    for (int row : selectedRows) {
                        String Ma = table.getValueAt(row, 0) + "";
                        String MaTK = busTK.getMaTkByTenDN(Ma);
//                        System.out.println(MaTK);
                        choose.add(MaTK);
                    }
                }
            }
        });

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String MaLop = cbLop.getSelectedItem() + "";
                if (!choose.isEmpty()) {
                    for (String MaSV : choose) {
                        ThemSV(MaLop, MaSV);
                    }
                    loadDSSV();
                    new ShowDiaLog("Thêm danh sách sinh viên thành công", ShowDiaLog.SUCCESS_DIALOG);
                } else {
                    new ShowDiaLog("Vui lòng chọn ít nhất 1 sinh viên", ShowDiaLog.ERROR_DIALOG);
                }
            }
        });

        tfTimKiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DSTimKiem();
            }
        });
    }

    private JLabel CreateLabel(String txt) {
        JLabel lbl = new JLabel(txt);
        lbl.setFont(font16);
        return lbl;
    }

    private void setTableFont(JTable table) {
        table.setFont(font16);

        JTableHeader header = table.getTableHeader();
        header.setFont(font16);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setFont(font16);
        table.setDefaultRenderer(Object.class, renderer);
        table.setRowHeight(30);
    }

    private void LoadData() {
        cbNam.removeAllItems();
        cbMon.removeAllItems();

        ArrayList<lopDTO> listNam = busLop.getListNam();
        for (lopDTO n : listNam) {
            cbNam.addItem(n.getNam());
        }

        ArrayList<monDTO> listMon = busMon.getList();
        for (monDTO m : listMon) {
            cbMon.addItem(m.getTenMon());
        }

    }

    private void showCbLop() {
        int Nam = Integer.parseInt(cbNam.getSelectedItem() + "");
        int HocKy = Integer.parseInt(cbHocKy.getSelectedItem() + "");
        String TenMon = cbMon.getSelectedItem() + "";

        cbLop.removeAllItems();
        ArrayList<lopDTO> listMon = busLop.getMaByNamHKMon(Nam, HocKy, TenMon);
        for (lopDTO x : listMon) {
            cbLop.addItem(x.getMaLop());
        }
    }

    private void ThemSV(String MaLop, String MaSV) {
        busCTLop.themSV(MaLop, MaSV);
    }

    private void loadDSSV() {
        model.setRowCount(0);
        int Nam = Integer.parseInt(cbNam.getSelectedItem() + "");
        int HocKy = Integer.parseInt(cbHocKy.getSelectedItem() + "");
        String TenMon = cbMon.getSelectedItem() + "";
        String MaLop = cbLop.getSelectedItem() + "";
        if (cbLop.getItemCount() > 0) {
            ArrayList<nguoiDungDTO> listNgDung = busNgDung.getThongTinSV(Nam, HocKy, TenMon, MaLop);
            for (nguoiDungDTO ng : listNgDung) {
                Object[] row = {ng.getMaUser(), ng.getHoTen(), ng.getNgSinh()};
                model.addRow(row);
            }
        }
    }

    private void DSTimKiem() {
        model.setRowCount(0);
        int Nam = Integer.parseInt(cbNam.getSelectedItem() + "");
        int HocKy = Integer.parseInt(cbHocKy.getSelectedItem() + "");
        String TenMon = cbMon.getSelectedItem() + "";
        String MaLop = cbLop.getSelectedItem() + "";
        String keyword = tfTimKiem.getText();
        if (cbLop.getItemCount() > 0) {
            ArrayList<nguoiDungDTO> list = busNgDung.TimKiem(Nam, HocKy, TenMon, MaLop, keyword);
            for (nguoiDungDTO ng : list) {
                Object[] row = {ng.getMaUser(), ng.getHoTen(), ng.getNgSinh()};
                model.addRow(row);
            }
            tfTimKiem.setText("");
        }
    }

}
