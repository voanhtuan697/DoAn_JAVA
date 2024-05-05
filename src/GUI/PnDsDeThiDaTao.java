/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.deThiBUS;
import BUS.lopBUS;
import BUS.monBUS;
import DTO.nguoiDungDTO;
import BUS.nguoiDungBUS;
import DTO.deThiDTO;
import DTO.lopDTO;
import java.awt.BorderLayout;
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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author E7250
 */
public class PnDsDeThiDaTao extends JPanel implements ActionListener {

    private DefaultTableModel model;
    private JTextField txt_seach;
    private JComboBox<String> cbb_trangThai;
    private String maTK;
    private JTable table;
    private deThiBUS deThi;
    private JPanel pn_btn;

    public PnDsDeThiDaTao(String maTK) throws SQLException {
        deThi = new deThiBUS();
        this.maTK = maTK;
        init();
        cbb_trangThai.setSelectedIndex(0);
    }

    public JComboBox<String> getCbb_trangThai() {
        return cbb_trangThai;
    }

    public void setCbb_trangThai(JComboBox<String> cbb_trangThai) {
        this.cbb_trangThai = cbb_trangThai;
    }

    public void init() {
        this.setLayout(new BorderLayout());
        JPanel pn_header = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 10));
        JLabel lb_search = new JLabel("Tìm kiếm:");
        txt_seach = new JTextField(10);
        cbb_trangThai = new JComboBox<>(new String[]{"Sắp diễn ra", "Đang diễn ra", "Đã diễn ra"});
        cbb_trangThai.setPreferredSize(new Dimension(100, cbb_trangThai.getPreferredSize().height));
        cbb_trangThai.addActionListener(this);

        pn_header.add(lb_search);
        pn_header.add(txt_seach);

        pn_header.add(cbb_trangThai);

        JPanel pn_table = new JPanel(new BorderLayout());

        Object[][] data = {};
        Object[] columns = {"Mã đề", "Tên đề", "Môn", "Nhóm lớp", "Ngày làm bài", "Thời gian bắt đầu", "Số lượng câu hỏi", "Thời gian làm bài"};

        model = new DefaultTableModel(data, columns);

        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        JScrollPane scrollPane_table = new JScrollPane(table);
        pn_table.add(scrollPane_table, BorderLayout.CENTER);

        pn_btn = new JPanel(new FlowLayout(1, 10, 10));
        JButton btn_ketThucDe = new JButton("Kết thúc đề");
        pn_btn.add(btn_ketThucDe);
        btn_ketThucDe.addActionListener(this);

        this.add(pn_header, BorderLayout.NORTH);
        this.add(pn_table, BorderLayout.CENTER);
        this.add(pn_btn, BorderLayout.SOUTH);

        txt_seach.addKeyListener(new KeyListener() {
            

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String selectedOption = (String) cbb_trangThai.getSelectedItem();
                    if (selectedOption.equals("Sắp diễn ra")) {
                        try {
                            search(0);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }else if (selectedOption.equals("Đang diễn ra")) {
                        try {
                            search(1);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }else if (selectedOption.equals("Đã diễn ra")) {
                        try {
                            search(2);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }

    public void loadData(int trangThai) throws SQLException {
        ArrayList<deThiDTO> arr = this.deThi.layDSDeThiDaTao(maTK, trangThai);
        for (deThiDTO dt : arr) {
            lopBUS lopBUS = new lopBUS();
            lopDTO lop = lopBUS.layLopBangMaDe(dt.getMaDT());
            monBUS monBUS = new monBUS();
            String tenMon = monBUS.layTenMonTheoMaMon(lop.getMaMon()).trim();
            model.addRow(new Object[]{dt.getMaDT(), dt.getTenDeThi(), tenMon, lop.getNhomLop(), dt.getNgayThi(), dt.getThoiGianBatDauThi(), dt.getSLCauHoi(), dt.getThoiGianLamBai()});
        }
        table.setModel(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn = e.getActionCommand();
        String selectedOption = (String) this.getCbb_trangThai().getSelectedItem();
        if (btn.equals("Kết thúc đề")) {
            int[] selectedRows = table.getSelectedRows();
            for (int row : selectedRows) {
                Object maDeThi = table.getValueAt(row, 0);
                try {
                    deThi.updateTrangThaiDeThi(maDeThi.toString().trim());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            try {
                loadData(1);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (selectedOption.equals("Sắp diễn ra")) {
            model.setRowCount(0);
            try {
                this.loadData(0);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            pn_btn.setVisible(false);
        } else if (selectedOption.equals("Đang diễn ra")) {
            model.setRowCount(0);
            try {
                this.loadData(1);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            pn_btn.setVisible(true);
        } else if (selectedOption.equals("Đã diễn ra")) {
            model.setRowCount(0);
            try {
                this.loadData(2);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            pn_btn.setVisible(false);
        }
    }

    private void search(int trangThai) throws SQLException {
        String searchText = txt_seach.getText().toLowerCase();
        model.setRowCount(0);
//   -------------------------
        ArrayList<deThiDTO> arr = this.deThi.layDSDeThiDaTao(maTK, trangThai);
        for (deThiDTO dt : arr) {
            lopBUS lopBUS = new lopBUS();
            lopDTO lop = lopBUS.layLopBangMaDe(dt.getMaDT());
            monBUS monBUS = new monBUS();
            String tenMon = monBUS.layTenMonTheoMaMon(lop.getMaMon()).trim();
            if (dt.getMaDT().toLowerCase().trim().contains(searchText) || dt.getTenDeThi().toLowerCase().trim().contains(searchText) || tenMon.toLowerCase().contains(searchText)) {
                model.addRow(new Object[]{dt.getMaDT(), dt.getTenDeThi(), tenMon, lop.getNhomLop(), dt.getNgayThi(), dt.getThoiGianBatDauThi(), dt.getSLCauHoi(), dt.getThoiGianLamBai()});
            } else if (searchText.isEmpty()) {
                model.addRow(new Object[]{dt.getMaDT(), dt.getTenDeThi(), tenMon, lop.getNhomLop(), dt.getNgayThi(), dt.getThoiGianBatDauThi(), dt.getSLCauHoi(), dt.getThoiGianLamBai()});
            }
        }

    }

    public static void main(String[] args) throws SQLException {
        JFrame f = new JFrame();
        f.setSize(900, 500);
        PnDsDeThiDaTao p = new PnDsDeThiDaTao("TK4");
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}
