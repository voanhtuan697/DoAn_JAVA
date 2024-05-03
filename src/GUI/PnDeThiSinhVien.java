/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.deThiBUS;
import BUS.ketQuaBUS1;
import BUS.lopBUS1;
import BUS.monBUS1;
import BUS.nguoiDungBUS;
import DTO.deThiDTO;
import DTO.lopDTO;
import DTO.ketQuaDTO;
import DTO.nguoiDungDTO;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static GUI.BASE.font14;
import static GUI.BASE.gray_bg;
import XULY.ShowDiaLog;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PnDeThiSinhVien extends JPanel implements ActionListener, MouseListener {

    private DefaultTableModel model;
    private JComboBox<String> cbb_trangThai;
    private String maTK;
    private JPanel pn_KetQua;
    private JTable table;
    private deThiBUS deThi;
    private ketQuaBUS1 kequaBUS;
    private JLabel lb_diem;
    private JLabel lb_soCauDung;
    private JLabel lb_thoiGianLam;

    public PnDeThiSinhVien(String maTK) throws SQLException {
        deThi = new deThiBUS();
        kequaBUS = new ketQuaBUS1();
        this.maTK = maTK;
        init();
//        model = (DefaultTableModel) table.getModel();
        cbb_trangThai.setSelectedIndex(0);
    }

    public JComboBox<String> getCbb_trangThai() {
        return cbb_trangThai;
    }

    public void setCbb_trangThai(JComboBox<String> cbb_trangThai) {
        this.cbb_trangThai = cbb_trangThai;
    }

    public JPanel getPn_KetQua() {
        return pn_KetQua;
    }

    public void setPn_KetQua(JPanel pn_KetQua) {
        this.pn_KetQua = pn_KetQua;
    }

    public void init() {
        this.setLayout(new BorderLayout());
        JPanel pnHeader = new JPanel();
        pnHeader.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pnHeader.setPreferredSize(new Dimension(0, 40));
        pnHeader.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        JLabel lb_trangThaiDeThi = new JLabel("Trạng thái:");
        String[] cacTrangThai = new String[]{"Đề sắp diễn ra", "Đề đang diễn ra", "Đề đã diễn ra"};
        cbb_trangThai = new JComboBox<>(cacTrangThai);
        cbb_trangThai.addActionListener(this);
        cbb_trangThai.setPreferredSize(new Dimension(150, cbb_trangThai.getPreferredSize().height));

        JLabel lb_timKiem = new JLabel("Tìm kiếm:");
        JTextField txt_timKiem = new JTextField(15);

        pnHeader.add(lb_trangThaiDeThi);
        pnHeader.add(cbb_trangThai);
        pnHeader.add(lb_timKiem);
        pnHeader.add(txt_timKiem);

        JPanel pnTable = new JPanel();
        pnTable.setLayout(new BorderLayout());

        Object[][] data = {};
        Object[] columns = {"Mã đề", "Môn", "Nhóm lớp", "Giảng viên", "Ngày thi", "Thời gian bắt đầu", "Số câu", "Thời gian làm bài(Phút)", "Trạng thái"};
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

        pn_KetQua = new JPanel();
        pn_KetQua.setLayout(new FlowLayout(0, 10, 10));

        JLabel lb_ketQua = new JLabel("Kết quả");
        lb_diem = new JLabel("Điểm:");
        lb_soCauDung = new JLabel("Số câu đúng: ");
        lb_thoiGianLam = new JLabel("Thời gian làm: ");
        pn_KetQua.add(lb_ketQua);
        pn_KetQua.add(lb_diem);
        pn_KetQua.add(lb_soCauDung);
        pn_KetQua.add(lb_thoiGianLam);

        this.add(pnHeader, BorderLayout.NORTH);
        this.add(pnTable, BorderLayout.CENTER);
        this.add(pn_KetQua, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedOption = (String) this.getCbb_trangThai().getSelectedItem();
        if (selectedOption.equals("Đề sắp diễn ra")) {
            model.setRowCount(0);
            try {
                this.loadData(maTK, 0);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            this.pn_KetQua.setVisible(false);
            lb_diem.setText("Điểm: ");
            lb_soCauDung.setText("Số câu đúng: ");
            lb_thoiGianLam.setText("Thời gian làm: ");
        } else if (selectedOption.equals("Đề đang diễn ra")) {
            model.setRowCount(0);
            try {
                this.loadData(maTK, 1);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            this.pn_KetQua.setVisible(false);
            lb_diem.setText("Điểm: ");
            lb_soCauDung.setText("Số câu đúng: ");
            lb_thoiGianLam.setText("Thời gian làm: ");
        } else if (selectedOption.equals("Đề đã diễn ra")) {
            model.setRowCount(0);
            try {
                this.loadData(maTK, 2);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            this.pn_KetQua.setVisible(true);
        }

    }

    public void loadData(String maTK, int trangThai) throws SQLException {
        ArrayList<deThiDTO> arr = this.deThi.layDSDeThiBangMaTK(maTK, trangThai);
        for (deThiDTO dt : arr) {
            nguoiDungBUS gvBUS = new nguoiDungBUS();
            nguoiDungDTO gv = gvBUS.layNguoiDung(dt.getMaGV());
            String tenGV = gv.getHoTen();

            lopBUS1 lopBUS = new lopBUS1();
            lopDTO lop = lopBUS.layLopBangMaDe(dt.getMaDT());
            monBUS1 monBUS = new monBUS1();
            String tenMon = monBUS.layTenMonBangMaMon(lop.getMaMon());
            model.addRow(new Object[]{dt.getMaDT(), tenMon, lop.getNhomLop(), tenGV, dt.getNgayThi(), dt.getThoiGianBatDauThi(), dt.getSLCauHoi(), dt.getThoiGianLamBai(), dt.getTrangThai()});
        }
        table.setModel(model);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) { // Kiểm tra xem chuột đã được nhấp đúp hay không
            int row = table.getSelectedRow();
            if (row != -1) { // Kiểm tra xem có hàng nào được chọn không
                String trangThai = table.getValueAt(row, 8).toString();

                if (trangThai.equals("0")) {
                    new ShowDiaLog("Bài thi vẫn chưa diễn ra!!!", ShowDiaLog.INFO_DIALOG);
                } else if (trangThai.equals("1")) {
                    String maDT = table.getValueAt(row, 0).toString().trim();

                    try {
                        if (kequaBUS.kiemTraSVDaLamDeChua(maTK, maDT)) {
                            new ShowDiaLog("Bạn đã thi bài thi này rồi!!!", ShowDiaLog.ERROR_DIALONG);
                        } else {
                            try {
                                new FrameDNVaoDeThi(maDT, maTK);
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                } else if (trangThai.equals("2")) {
                    String maDT = table.getValueAt(row, 0).toString().toString();
                    ketQuaDTO kq = kequaBUS.layKetQuaBangMaTKvaMaDT(maTK, maDT);
                    if (kq != null) {
                        lb_diem.setText("Điểm: " + kq.getDiem());
                        lb_soCauDung.setText("Số câu đúng: " + kq.getSLCauDung());
                        String thoiGianLamXong = kq.getTGLamXong().substring(0, 8);
                        lb_thoiGianLam.setText("Thời gian làm: "+thoiGianLamXong);
                    } else {
                        new ShowDiaLog("Bạn đã không thi bài thi này!!!", ShowDiaLog.ERROR_DIALONG);
                        lb_diem.setText("Điểm: ");
                        lb_soCauDung.setText("Số câu đúng: ");
                        lb_thoiGianLam.setText("Thời gian làm: ");
                    }
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

    public static void main(String[] args) throws SQLException {
        JFrame f = new JFrame();
        f.setSize(800, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PnDeThiSinhVien p = new PnDeThiSinhVien("TK12");
        f.getContentPane().setLayout(new BorderLayout());
        f.add(p);
        f.setVisible(true);
    }

}
