/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.chiTietLopBUS2;
import BUS.chiTietMonBUS2;
import BUS.lopBUS2;
import BUS.monBUS2;
import BUS.nguoiDungBUS2;
import BUS.taiKhoanBUS2;
import DTO.monDTO;
import DTO.nguoiDungDTO;
import static GUI.BASE.dark_green;
import static GUI.BASE.font14;
import static GUI.BASE.font14b;
import static GUI.BASE.gray_bg;
import XULY.ShowDiaLog;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class PnThemMonChoGV extends JPanel {

    private JPanel pnTop, pnCenter, pnBottom;
    private JTextField tfTimKiem;
    private JComboBox cbMon;
    private JTable table;
    private DefaultTableModel model;
    private String maSV;
    private JButton btnThem;
    private nguoiDungBUS2 busNgDung = new nguoiDungBUS2();
    private taiKhoanBUS2 busTK = new taiKhoanBUS2();
    private monBUS2 busMon = new monBUS2();
    private chiTietMonBUS2 busCTMon = new chiTietMonBUS2();

    public PnThemMonChoGV() {
        init();
        initComponents();
        loadData();
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
        JLabel lblTimKiem, lblTenMon;
        lblTimKiem = CreateLabel("Tìm kiếm:");
        lblTenMon = CreateLabel("Tên môn:");

        tfTimKiem = new JTextField(15);

        cbMon = new JComboBox();
        cbMon.setPreferredSize(new Dimension(200, cbMon.getPreferredSize().height));

        Object[] columns = {"Mã giảng viên", "Tên giảng viên", "Ngày sinh"};
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
        btnThem.setFont(font14b);
        btnThem.setForeground(white);
        btnThem.setBorderPainted(false);
        btnThem.setFocusPainted(false);
        btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnThem.setMaximumSize(new Dimension(120, 20));

        pnTop.add(lblTimKiem);
        pnTop.add(tfTimKiem);
        pnCenter.add(scrlTable, BorderLayout.CENTER);

        JPanel container = new JPanel(new FlowLayout(FlowLayout.LEFT));
        container.setBackground(gray_bg);

        container.add(lblTenMon);
        container.add(cbMon);
        container.add(btnThem);

        pnBottom.add(container, BorderLayout.CENTER);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                if (!event.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        String data = table.getValueAt(selectedRow, 0).toString();
                        String MaTk = busTK.getMaTkByTenDN(data);
                        getListMon(MaTk);
                    }
                }
            }
        });

        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThemMonChoGV();
            }
        });

    }

    private JLabel CreateLabel(String txt) {
        JLabel lbl = new JLabel(txt);
        lbl.setFont(font14);
        return lbl;
    }

    private void setTableFont(JTable table) {
        table.setFont(font14);

        JTableHeader header = table.getTableHeader();
        header.setFont(font14);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setFont(font14);
        table.setDefaultRenderer(Object.class, renderer);
    }

    private void loadData() {
        model.setRowCount(0);
        ArrayList<nguoiDungDTO> list = busNgDung.DSGiaoVien();
        for (nguoiDungDTO x : list) {
            Object[] row = {x.getMaUser(), x.getHoTen(), x.getNgSinh()};
            model.addRow(row);
        }
    }

    private void getListMon(String MaTK) {
        cbMon.removeAllItems();
        ArrayList<monDTO> list = busMon.DSMonGVCHTT(MaTK);
        for (monDTO m : list) {
            cbMon.addItem(m.getTenMon());
        }
    }

    private void ThemMonChoGV() {
        int i = table.getSelectedRow();
        if (i != -1) {
            String MaUser = table.getValueAt(i, 0) + "";
            String MaTK = busTK.getMaTkByTenDN(MaUser);
            String TenMon = cbMon.getSelectedItem() + "";
            String MaMon = busMon.getMaMonByName(TenMon);

            boolean success = busCTMon.ThemDS(MaMon, MaTK);
            if (success) {
                new ShowDiaLog("Thêm môn thành công", ShowDiaLog.SUCCESS_DIALOG);
                getListMon(MaTK);
            }
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(900, 500);
        PnThemMonChoGV p = new PnThemMonChoGV();
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
