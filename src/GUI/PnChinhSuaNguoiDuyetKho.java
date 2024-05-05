/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.chiTietQuyenBUS;
import BUS.khoCauHoiBUS;
import BUS.monBUS;
import BUS.nguoiDungBUS;
import BUS.taiKhoanBUS;
import DTO.khoCauHoiDTO;
import DTO.monDTO;
import DTO.nguoiDungDTO;
import DTO.taiKhoanDTO;
import DTO.khoCauHoiDTO;
import XULY.ShowDiaLog;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author E7250
 */
public class PnChinhSuaNguoiDuyetKho extends JPanel implements MouseListener, ActionListener {

    private DefaultTableModel model;
    private String maTK;
    private JComboBox<String> cbb_mon;
    private taiKhoanBUS tkBUS;
    private nguoiDungBUS ndBUS;
    private khoCauHoiBUS khoBUS;
    private JTable table;
    private chiTietQuyenBUS ctqBUS;
    private monBUS monBUS;
    private Map<String, String> mapCBB_mon = new HashMap<>();
    private JTextField txt_timKiem;

    public PnChinhSuaNguoiDuyetKho(String maTK) {
        tkBUS = new taiKhoanBUS();
        ndBUS = new nguoiDungBUS();
        monBUS = new monBUS();
        ctqBUS = new chiTietQuyenBUS();
        khoBUS = new khoCauHoiBUS();
        this.maTK = maTK;
        init();
        loadData();
        loadCBBMon();
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public void init() {
        this.setLayout(new BorderLayout());

        JPanel pnHeader = new JPanel();
        pnHeader.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pnHeader.setPreferredSize(new Dimension(0, 40));
        pnHeader.setLayout(new FlowLayout(0, 10, 10));

        JLabel lb_timKiem = new JLabel("Tìm kiếm:");
        txt_timKiem = new JTextField(15);

        pnHeader.add(lb_timKiem);
        pnHeader.add(txt_timKiem);

        JPanel pnTable = new JPanel();
        pnTable.setLayout(new BorderLayout());

        Object[][] data = {};
        Object[] columns = {"Mã tài khoản", "Họ và tên", "Ngày sinh"};
        model = new DefaultTableModel(data, columns);

        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.addMouseListener(this);

        JScrollPane scrollPane_table = new JScrollPane(table);
        pnTable.add(scrollPane_table, BorderLayout.CENTER);

        JPanel pn_input = new JPanel(new FlowLayout(0, 10, 10));
        JLabel lb_mon = new JLabel("Môn:");
        cbb_mon = new JComboBox<>();
//        cbb_mon.addActionListener(this);
        cbb_mon.setPreferredSize(new Dimension(150, cbb_mon.getPreferredSize().height));
        JButton btn_them = new JButton("Thêm");
        JButton btn_xoa = new JButton("Xóa");
        btn_them.addActionListener(this);
        btn_xoa.addActionListener(this);

        pn_input.add(lb_mon);
        pn_input.add(cbb_mon);
        pn_input.add(btn_them);
        pn_input.add(btn_xoa);

        this.add(pnHeader, BorderLayout.NORTH);
        this.add(pnTable, BorderLayout.CENTER);
        this.add(pn_input, BorderLayout.SOUTH);

        this.setVisible(true);

        txt_timKiem.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    search();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    public void loadData() {
        ArrayList<taiKhoanDTO> arr = this.tkBUS.getTaiKhoan();
        for (taiKhoanDTO tk : arr) {
            if (ctqBUS.kiemTraTKcoTonTaiCN(tk.getMaTK(), "CNDCH")) {
                nguoiDungDTO nd = this.ndBUS.layNguoiDung(tk.getMaTK());
                model.addRow(new Object[]{tk.getMaTK(), nd.getHoTen(), nd.getNgSinh()});
            }
        }
        table.setModel(model);
    }

    public void loadCBBMon() {
        ArrayList<monDTO> arr = monBUS.layCacMonChuaCoKho();
        for (monDTO m : arr) {
            cbb_mon.addItem(m.getTenMon());
            mapCBB_mon.put(m.getTenMon().trim(), m.getMaMon().trim());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();
        if (btn.equals("Thêm")) {
            int row = table.getSelectedRow();
            if (row != -1) {
                String maTK = table.getValueAt(row, 0).toString().trim();
                khoCauHoiDTO kch = khoBUS.layKhoBangMaTK(maTK);
                String tenMon = "";
                if (kch != null) {
                    tenMon = monBUS.layTenMonTheoMaMon(kch.getMaMon());

                    new ShowDiaLog("Đã duyệt kho câu hỏi môn: " + tenMon, ShowDiaLog.INFO_DIALOG);
                } else {
                    String monSelect = (String) cbb_mon.getSelectedItem();
                    String maMon = mapCBB_mon.get(monSelect);
                    if (khoBUS.themTBMChoKhoCH(maTK, maMon)) {
                        new ShowDiaLog("Thêm người duyệt kho câu hỏi " + monSelect + "thành công!", ShowDiaLog.SUCCESS_DIALOG);
                        cbb_mon.removeAllItems();
                        loadCBBMon();
                    } else {
                        new ShowDiaLog("Thêm người duyệt kho câu hỏi " + monSelect + "thất bại!", ShowDiaLog.ERROR_DIALOG);
                    }

                }
            } else {
                new ShowDiaLog("Bạn chưa chọn người phụ trách kho câu hỏi!", ShowDiaLog.ERROR_DIALOG);
            }
        } else if (btn.equals("Xóa")) {

            int row = table.getSelectedRow();
            if (row != -1) {
                String maTK = table.getValueAt(row, 0).toString().trim();
                khoCauHoiDTO kch = khoBUS.layKhoBangMaTK(maTK);
                String tenMon = "";
                if (kch != null) {
                    tenMon = monBUS.layTenMonTheoMaMon(kch.getMaMon());

                    int option = JOptionPane.showConfirmDialog(this, "Đang duyệt kho câu hỏi môn " + tenMon + "\nBạn có muốn xóa quyền duyệt kho của người này không?", "Thông báo", JOptionPane.OK_CANCEL_OPTION);
                    if (option == JOptionPane.OK_OPTION) {
                        if (khoBUS.xoaMaTBMKhoiKhoCH(kch.getMaKho())) {
                            new ShowDiaLog("Xóa người duyệt câu hỏi môn " + tenMon + " thành công!", ShowDiaLog.SUCCESS_DIALOG);
                            cbb_mon.removeAllItems();
                            loadCBBMon();
                        } else {
                            new ShowDiaLog("Xóa người duyệt câu hỏi môn " + tenMon + " thất bại!", ShowDiaLog.ERROR_DIALOG);
                        }

                    }
                } else {
                    new ShowDiaLog("Người này chưa duyệt kho nào!", ShowDiaLog.INFO_DIALOG);
                }
            } else {
                new ShowDiaLog("Bạn chưa chọn người để xóa quyền duyệt kho câu hỏi!", ShowDiaLog.ERROR_DIALOG);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            int row = table.getSelectedRow();
            if (row != -1) {
                String maTK = table.getValueAt(row, 0).toString().trim();
                khoCauHoiDTO kch = khoBUS.layKhoBangMaTK(maTK);
                String tenMon = "";
                if (kch != null) {
                    tenMon = monBUS.layTenMonTheoMaMon(kch.getMaMon());
                    new ShowDiaLog("Đã duyệt kho câu hỏi môn: " + tenMon, ShowDiaLog.INFO_DIALOG);
                } else {
                    new ShowDiaLog("Chưa duyệt kho nào!" + tenMon, ShowDiaLog.INFO_DIALOG);
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

    private void search() {
        String searchText = txt_timKiem.getText().toLowerCase();
        model.setRowCount(0);
        ArrayList<taiKhoanDTO> arr = this.tkBUS.getTaiKhoan();
        for (taiKhoanDTO tk : arr) {
            if (ctqBUS.kiemTraTKcoTonTaiCN(tk.getMaTK(), "CNDCH")) {
                nguoiDungDTO nd = this.ndBUS.layNguoiDung(tk.getMaTK());
                if (tk.getMaTK().toLowerCase().trim().contains(searchText) || nd.getHoTen().toLowerCase().trim().contains(searchText)) {
                    model.addRow(new Object[]{tk.getMaTK(), nd.getHoTen(), nd.getNgSinh()});
                } else if (txt_timKiem.getText().isEmpty()) {
                    model.addRow(new Object[]{tk.getMaTK(), nd.getHoTen(), nd.getNgSinh()});
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(800, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        Component add = f.getContentPane().add(new PnChinhSuaNguoiDuyetKho("TK1"));
        f.setVisible(true);
    }

}
