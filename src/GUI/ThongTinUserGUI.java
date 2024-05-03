/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.nguoiDungBUS;
import BUS.quyenBUS;
import BUS.chiTietQuyenBUS;
import BUS.khoCauHoiBUS1;
import BUS.monBUS1;
import BUS.taiKhoanBUS;
import DTO.khoCauHoiDTO;
import DTO.nguoiDungDTO;
import DTO.quyenDTO;
import DTO.taiKhoanDTO;
import static GUI.BASE.createResizedIcon;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION;
import static javax.swing.border.TitledBorder.DEFAULT_POSITION;
import static GUI.BASE.dark_green;
import static GUI.BASE.font16;
import static GUI.BASE.font16;
import static GUI.BASE.white;
import XULY.ShowDiaLog;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import net.sourceforge.jdatepicker.JDateComponentFactory;
import net.sourceforge.jdatepicker.JDatePanel;
import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;

public class ThongTinUserGUI extends JPanel {

    private String maTK;
    private nguoiDungDTO user;
    private quyenBUS q;
    private JPanel pnLeft, pnRight;
    private JButton btnCapNhat, btnDoiMK;
    private JTextField tfHoTen, tfMk, tfMKMoi, tfMkNL;
    private JLabel lblTenDn, lblChucVu, lblTrMon;
    private final nguoiDungBUS u;
    private final quyenDTO quyen;
    private UtilDateModel modell;

    public ThongTinUserGUI(String maTK) throws SQLException {
        this.maTK = maTK;
        u = new nguoiDungBUS();
        user = u.layNguoiDung(maTK);
        q = new quyenBUS();
        quyen = q.layQuyen(maTK);
        init();
        initComponents();
        addEvent();
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public void init() {
        this.setLayout(new BorderLayout());
        pnLeft = new JPanel();

        pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
        pnLeft.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 0));
        pnLeft.setBorder(BorderFactory.createTitledBorder(null, "Thông tin cá nhân của người dùng", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font16) {
        }));

        pnRight = new JPanel();

        pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
        pnRight.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 10));
        pnRight.setPreferredSize(new Dimension(400, 0));
        pnRight.setBorder(BorderFactory.createTitledBorder(null, "Đổi mật khẩu", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font16) {
        }));

        this.add(pnLeft, BorderLayout.CENTER);
        this.add(pnRight, BorderLayout.EAST);
    }

    private static void setDateFromString(UtilDateModel model, String dateString) {
        // Phân tích chuỗi ngày tháng năm thành các thành phần
        String[] parts = dateString.split("-");
        int year = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]) - 1; // Trừ đi 1 vì tháng trong Calendar bắt đầu từ 0
        int day = Integer.parseInt(parts[2]);

        // Đặt giá trị ngày tháng năm cho UtilDateModel
        model.setDate(year, month, day);
    }

    public void initComponents() throws SQLException {
        JLabel lbTenDN, lbHoTen, lbNgSinh, lbChucVu, lbTrBM;

        JPanel pnDN = new JPanel(new FlowLayout(FlowLayout.LEFT));

        lbTenDN = new JLabel("Tên đăng nhập:");
        lbTenDN.setFont(font16);
        lblTenDn = new JLabel(user.getMaUser());
        lblTenDn.setFont(font16);
        pnDN.add(lbTenDN);
        pnDN.add(lblTenDn);

        JPanel pnHoTen = new JPanel(new FlowLayout(FlowLayout.LEFT));

        lbHoTen = new JLabel("Họ và tên:");
        lbHoTen.setFont(font16);
        tfHoTen = new JTextField(25);
        tfHoTen.setText(user.getHoTen());
        pnHoTen.add(lbHoTen);
        pnHoTen.add(tfHoTen);

        JPanel pnNgSinh = new JPanel(new FlowLayout(FlowLayout.LEFT));

        lbNgSinh = new JLabel("Ngày sinh:");
        lbNgSinh.setFont(font16);
        modell = new UtilDateModel();
        JDatePanel datePanel = new JDatePanelImpl(modell);
        JDatePicker datePicker = new JDatePickerImpl((JDatePanelImpl) datePanel);

        String ngSinh = user.getNgSinh();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date;
        try {
            date = sdf.parse(ngSinh);
            modell.setValue(date);
        } catch (ParseException ex) {
            System.out.println("Invalid date format");
        }

        pnNgSinh.add(lbNgSinh);
        pnNgSinh.add((JComponent) datePicker);

        JPanel pnChucVu = new JPanel(new FlowLayout(FlowLayout.LEFT));

        lbChucVu = new JLabel("Chức vụ:");
        lbChucVu.setFont(font16);
        lblChucVu = new JLabel(quyen.getTenQuyen());
        lblChucVu.setFont(font16);
        pnChucVu.add(lbChucVu);
        pnChucVu.add(lblChucVu);

        JPanel pnCapNhat = new JPanel(new FlowLayout(FlowLayout.LEFT));

        btnCapNhat = new JButton("Cập nhật");
        btnCapNhat.setBackground(dark_green);
        btnCapNhat.setForeground(white);
        btnCapNhat.setBorderPainted(false);
        btnCapNhat.setFocusPainted(false);
        btnCapNhat.setFont(font16);
        btnCapNhat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnCapNhat.add(btnCapNhat);

        pnLeft.add(pnDN);
        pnLeft.add(pnHoTen);
        pnLeft.add(pnNgSinh);
        pnLeft.add(pnChucVu);

        JPanel pnTrBM = new JPanel(new FlowLayout(FlowLayout.LEFT));

        chiTietQuyenBUS chiTietQuyenBUS = new chiTietQuyenBUS();
        if (chiTietQuyenBUS.kiemTraTKcoTonTaiCN(maTK, "CNDCH")) {
            lbTrBM = new JLabel("Trưởng bộ môn:");
            lbTrBM.setFont(font16);

            khoCauHoiBUS1 kchBUS = new khoCauHoiBUS1();
            monBUS1 mon = new monBUS1();
            khoCauHoiDTO kch = kchBUS.layKhoBangMaTK(maTK);
            String tenMon = mon.layTenMonBangMaMon(kch.getMaMon()).trim();
            lblTrMon = new JLabel(tenMon);
            lblTrMon.setFont(font16);
            pnTrBM.add(lbTrBM);
            pnTrBM.add(lblTrMon);

            pnLeft.add(pnTrBM);
        }

        pnLeft.add(Box.createVerticalStrut(10));
        pnLeft.add(pnCapNhat);

        JPanel pnMKcu = new JPanel(new FlowLayout(FlowLayout.LEFT));

        pnMKcu.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel lbMKcu = new JLabel("Nhập mật khẩu cũ:");
        lbMKcu.setFont(font16);
        tfMk = new JTextField(25);
        tfMk.setPreferredSize(new Dimension(tfMk.getPreferredSize().width, 30));
        pnMKcu.add(lbMKcu);
        pnMKcu.add(tfMk);

        JPanel pnMkMoi = new JPanel(new FlowLayout(FlowLayout.LEFT));

        pnMkMoi.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel lbMkmoi = new JLabel("Nhập mật khẩu mới:");
        lbMkmoi.setFont(font16);
        tfMKMoi = new JTextField(25);
        tfMKMoi.setPreferredSize(new Dimension(tfMKMoi.getPreferredSize().width, 30));
        pnMkMoi.add(lbMkmoi);
        pnMkMoi.add(tfMKMoi);

        JPanel pnNhapLai = new JPanel(new FlowLayout(FlowLayout.LEFT));

        pnNhapLai.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JLabel lbNhapLai = new JLabel("Nhập lại mật khẩu:");
        lbNhapLai.setFont(font16);
        tfMkNL = new JTextField(25);
        tfMkNL.setPreferredSize(new Dimension(tfMkNL.getPreferredSize().width, 30));
        pnNhapLai.add(lbNhapLai);
        pnNhapLai.add(tfMkNL);

        JPanel pnDoiMk = new JPanel(new FlowLayout(FlowLayout.LEFT));

        pnDoiMk.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnDoiMK = new JButton("Đổi mật khẩu");
        btnDoiMK.setBackground(dark_green);
        btnDoiMK.setForeground(white);
        btnDoiMK.setBorderPainted(false);
        btnDoiMK.setFocusPainted(false);
        btnDoiMK.setFont(font16);
        btnDoiMK.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnDoiMk.add(btnDoiMK);

        pnRight.add(pnMKcu);
        pnRight.add(pnMkMoi);
        pnRight.add(pnNhapLai);
        pnRight.add(pnDoiMk);

    }

    public void addEvent() throws SQLException {
        nguoiDungBUS nd = new nguoiDungBUS();
        btnCapNhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfHoTen.getText().trim().isEmpty()) {
                    new ShowDiaLog("Vui lòng nhập họ tên!", ShowDiaLog.ERROR_DIALONG);
                    tfHoTen.requestFocus();
                    tfHoTen.selectAll();
                    return;
                }
                if (!isVietnamese(tfHoTen.getText())) {
                    new ShowDiaLog("Họ tên không hợp lệ!", ShowDiaLog.ERROR_DIALONG);
                    tfHoTen.requestFocus();
                    tfHoTen.selectAll();
                    return;
                }
                String hoTen = tfHoTen.getText();
                Date selectedDate = modell.getValue();
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String newNgaySinh = dateFormat.format(selectedDate);
                int a = JOptionPane.showConfirmDialog(null, "Bạn muốn cập nhật thông tin?", "Thông báo", JOptionPane.YES_NO_OPTION);

                if (a == JOptionPane.YES_OPTION) {
                    try {
                        if (nd.updateNguoiDung(hoTen, newNgaySinh, nd.layMaUserTheoMaTK(maTK))) {
                            new ShowDiaLog("Cập nhật thành công!", ShowDiaLog.SUCCESS_DIALOG);
                            pnLeft.revalidate();
                            pnLeft.repaint();
                            return;
                        } else {
                            new ShowDiaLog("Cập nhật thất bại!", ShowDiaLog.ERROR_DIALONG);
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    return;
                }

            }
        }
        );
        btnDoiMK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (tfMk.getText().trim().isEmpty()) {
                    new ShowDiaLog("Vui lòng nhập mật khẩu cũ!", ShowDiaLog.ERROR_DIALONG);
                    tfMk.requestFocus();
                    return;
                }
                try {
                    taiKhoanDTO x = new taiKhoanBUS().layTaiKhoan(maTK);
                    if (!tfMk.getText().trim().equalsIgnoreCase(x.getMatKhau())) {
                        new ShowDiaLog("Mật khẩu cũ không đúng!", ShowDiaLog.ERROR_DIALONG);
                        tfMk.requestFocus();
                        tfMk.selectAll();
                        return;
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                if (tfMKMoi.getText().trim().isEmpty()) {
                    new ShowDiaLog("Vui lòng nhập mật khẩu mới!", ShowDiaLog.ERROR_DIALONG);
                    tfMKMoi.requestFocus();
                    return;
                }
                if (tfMkNL.getText().trim().isEmpty()) {
                    new ShowDiaLog("Vui lòng nhập lại mật khẩu mới!", ShowDiaLog.ERROR_DIALONG);
                    tfMkNL.requestFocus();
                    return;
                }
                if (!tfMKMoi.getText().trim().equalsIgnoreCase(tfMkNL.getText().trim())) {
                    new ShowDiaLog("Mật khẩu nhập lại không trùng với mật khẩu mới!", ShowDiaLog.ERROR_DIALONG);
                    tfMkNL.requestFocus();
                    tfMkNL.selectAll();
                    return;
                }

//                String oldPw = tfMk.getText();
                String newPw = tfMKMoi.getText();
//                String rPw = tfMkNL.getText();
                int a = JOptionPane.showConfirmDialog(null, "Bạn muốn cập nhật mật khẩu?", "Thông báo", JOptionPane.YES_NO_OPTION);

                if (a == JOptionPane.YES_OPTION) {
                    try {
                        if (new taiKhoanBUS().updateMatKhau(newPw, maTK)) {
                            new ShowDiaLog("Cập nhật thành công!", ShowDiaLog.SUCCESS_DIALOG);
                            pnRight.revalidate();
                            pnRight.repaint();
                            return;
                        } else {
                            new ShowDiaLog("Cập nhật thất bại!", ShowDiaLog.ERROR_DIALONG);
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    return;
                }

            }
        });
    }

    public boolean isVietnamese(String str) {
        String regex = "[a-zA-ZàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆđĐìÌỉỈĩĨíÍịỊòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢùÙủỦũŨúÚụỤưỪừỬữỮứỨựỰỳỲỷỶỹỸýÝỵỴ\\s]+$";
        return Pattern.matches(regex, str);

    }

    public static void main(String[] args) throws SQLException {
        JFrame f = new JFrame();
        f.setSize(950, 450);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ThongTinUserGUI p = new ThongTinUserGUI("TK10");
        f.getContentPane().setLayout(new BorderLayout());
        f.add(p);
        f.setVisible(true);
    }

}
