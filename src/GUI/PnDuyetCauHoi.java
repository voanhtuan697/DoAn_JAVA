/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.cauHoiBUS;
import BUS.khoCauHoiBUS;
import BUS.monBUS;
import DAO.khoCauHoiDAO;
import DTO.cauHoiDTO;
import DTO.khoCauHoiDTO;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static GUI.BASE.dark_green;
import static GUI.BASE.font13;
import static GUI.BASE.gray_bg;
import static GUI.BASE.white;
import XULY.ShowDiaLog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;

/**
 *
 * @author E7250
 */
public class PnDuyetCauHoi extends JPanel implements ActionListener, MouseListener {

    private DefaultTableModel model;
    private String maTK;
    private khoCauHoiBUS khoCHBUS;
    private cauHoiBUS cauHoiBUS;
    private final khoCauHoiDTO khDAO;
    private JTable table;
    private JComboBox cbb_trangThai;
    private JPanel pn_btn;

    public PnDuyetCauHoi(String maTK) throws SQLException {
        khoCHBUS = new khoCauHoiBUS();
        cauHoiBUS = new cauHoiBUS();
        khDAO = khoCHBUS.layKhoBangMaTK(maTK);
        if (khDAO != null) {
            init();
            cbb_trangThai.setSelectedIndex(0);
        } else {
            initNull();
        }
    }

    public void initNull() {
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("Chưa quản lý kho nào");
        label.setFont(new Font("Arial", Font.BOLD, 20)); // Set font
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label, BorderLayout.CENTER);
    }

    public void init() throws SQLException {
        this.setLayout(new BorderLayout());

        JPanel pn_header = new JPanel();
        pn_header.setLayout(new FlowLayout(0, 10, 10));
        pn_header.setBackground(gray_bg);
        monBUS monbus = new monBUS();
        JLabel lb_mon = new JLabel();
        String tenMon = monbus.layTenMonTheoMaMon(khDAO.getMaMon()).trim();
        lb_mon.setText("Tên môn: " + tenMon);
        lb_mon.setFont(font13);
        String[] trangThai = {"Chưa duyệt", "Đã duyệt"};
        cbb_trangThai = new JComboBox(trangThai);
        cbb_trangThai.addActionListener(this);

        JPanel pnSearch = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        pnSearch.setBackground(gray_bg);

        JLabel lblSearch = new JLabel("Tìm kiếm");
        lblSearch.setFont(font13);
        JTextField txtSearch = new JTextField(15);

        pn_header.add(lb_mon);
        pn_header.add(cbb_trangThai);
        pn_header.add(lblSearch);
        pn_header.add(txtSearch);

//        -------------
        JPanel pn_table = new JPanel();
        pn_table.setLayout(new BorderLayout());

        Object[][] data = {};

        // Tạo tiêu đề cho bảng
        Object[] columns = {"Mã câu hỏi", "Mã giảng viên", "Nội dung", "Độ khó", "Ảnh"};
        model = new DefaultTableModel(data, columns);

//        Không cho người dùng tác động
        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.addMouseListener(this);
//        set chiều ngang cho cột
//        TableColumnModel columnModel = table.getColumnModel();
//        columnModel.getColumn(0).setPreferredWidth(60); // Mã câu hỏi
//        columnModel.getColumn(1).setPreferredWidth(80); // Mã giảng viên
//        columnModel.getColumn(2).setPreferredWidth(1000); // Nội dung
//        columnModel.getColumn(3).setPreferredWidth(70); // Độ khó

        JScrollPane scrollPane_table = new JScrollPane(table);
        pn_table.add(scrollPane_table, BorderLayout.CENTER);

        pn_btn = new JPanel();
        pn_btn.setLayout(new FlowLayout(1, 10, 10));
        pn_btn.setBackground(gray_bg);
        JButton btn = new JButton("Duyệt câu hỏi");
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        btn.setForeground(white);
        btn.setBackground(dark_green);
        btn.addActionListener(this);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pn_btn.add(btn);

        this.add(pn_header, BorderLayout.NORTH);
        this.add(pn_table, BorderLayout.CENTER);
        this.add(pn_btn, BorderLayout.SOUTH);

    }

    public void loadData(int trangThai) throws SQLException {
        boolean status;
        if (trangThai == 1) {
            status = true;
        } else {
            status = false;
        }
        ArrayList<cauHoiDTO> arr = this.cauHoiBUS.layDanhSachCauHoi();
        monBUS monbus = new monBUS();
        String tenMonMD = monbus.layTenMonTheoMaMon(khDAO.getMaMon()).trim();
        for (cauHoiDTO ch : arr) {
            String tenMon = monbus.layTenMonBangMaCH(ch.getMaCH()).trim();
            if (ch.isTrangThai() == status && tenMonMD.equals(tenMon)) {
                cauHoiDTO cauHoi = new cauHoiDTO();
                cauHoi.setMaCH(ch.getMaCH());
                cauHoi.setMaGV(ch.getMaGV());
                cauHoi.setNoidung(ch.getNoidung());
                cauHoi.setDoKho(ch.getDoKho());
                cauHoi.setImg(ch.getImg());
                model.addRow(new Object[]{cauHoi.getMaCH(), cauHoi.getMaGV(), cauHoi.getNoidung(), cauHoi.getDoKho(), cauHoi.getImg()});
            }
        }
        table.setModel(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();
        String selectedOption = (String) cbb_trangThai.getSelectedItem();
        if (btn.equals("Duyệt câu hỏi")) {
            int row = table.getSelectedRow();
            if (row != -1) {
                String maCH = table.getValueAt(row, 0).toString().trim();
                if (cauHoiBUS.chuyenTrangThaiCH(maCH)) {
                    new ShowDiaLog("Đã duyệt câu hỏi: " + maCH, ShowDiaLog.SUCCESS_DIALOG);
                    model.setRowCount(0);
                    try {
                        this.loadData(0);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            } else {
                new ShowDiaLog("Chưa chọn câu hỏi!", ShowDiaLog.ERROR_DIALOG);
            }
        }
        if (selectedOption.equals("Chưa duyệt")) {
            model.setRowCount(0);
            try {
                this.loadData(0);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            pn_btn.setVisible(true);
        } else if (selectedOption.equals("Đã duyệt")) {
            model.setRowCount(0);
            try {
                this.loadData(1);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            pn_btn.setVisible(false);
        }
    }

    public static void main(String[] args) throws SQLException {
        JFrame f = new JFrame();
        f.setSize(800, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PnDuyetCauHoi p = new PnDuyetCauHoi("TK2");
        f.getContentPane().setLayout(new BorderLayout());
        f.add(p);
        f.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            int row = table.getSelectedRow();
            if (row != -1) {
                String maCH = table.getValueAt(row, 0).toString().trim();
                try {
                    new FrameXemChiTietCauHoi(maCH);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
