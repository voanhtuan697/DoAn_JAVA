package GUI;

import BUS.cauHoiBUS1;
import BUS.chiTietDeBUS1;
import BUS.dapAnBUS;
import BUS.deThiBUS;
import BUS.ketQuaBUS1;
import BUS.lopBUS;
import BUS.monBUS;
import BUS.nguoiDungBUS;
import DTO.cauHoiDTO;
import DTO.chiTietDeDTO;
import DTO.dapAnDTO;
import DTO.deThiDTO;
import DTO.ketQuaDTO;
import DTO.nguoiDungDTO;
import static GUI.BASE.font14;
import XULY.ShowDiaLog;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import static javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION;
import static javax.swing.border.TitledBorder.DEFAULT_POSITION;
import java.util.Timer;
import java.util.TimerTask;

public class FrameBaiThi extends JFrame implements ActionListener {

    private String[] bangChuCai;
    private JLabel lb_time;
    private String maDT, maTK;
    private chiTietDeBUS1 ctd;
    private ArrayList<chiTietDeDTO> dsCTD;
    private ArrayList<Object> arrDA = new ArrayList<>();
    private ArrayList<String> mangMaCH = new ArrayList<>();
    private cauHoiBUS1 cauHoiBUS;
    private dapAnBUS dapAnBUS;
    private deThiBUS deThiBUS;
    private JButton btn_prev, btn_next, btn_finish;
    private int count = 0;
    private JPanel cards;
    private CardLayout cardLayout;
    private deThiDTO deThi;

    public FrameBaiThi(String maDT, String maTK) throws SQLException {
        deThiBUS = new deThiBUS();
        dapAnBUS = new dapAnBUS();
        ctd = new chiTietDeBUS1();
        this.maDT = maDT;
        this.maTK = maTK;
        dsCTD = ctd.layDanhSachChiTietDeBangMaDe(maDT);
        cauHoiBUS = new cauHoiBUS1();
        deThi = deThiBUS.layDeThiBangMaDT(maDT);

        init();
        taoCacCauHoi();

        startCountdown(deThi.getThoiGianLamBai(), 0);
    }

    public void init() throws SQLException {
        setSize(new Dimension(800, 600));
//        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        JPanel pn_thongTin = new JPanel(new BorderLayout());
        JPanel pn_time = new JPanel(new FlowLayout(2, 10, 10));
        lb_time = new JLabel();
        lb_time.setFont(font14);

        JPanel pn_thongTinDe = new JPanel(new FlowLayout(0, 10, 10));
        monBUS monBUS = new monBUS();
        JLabel lb_mon = new JLabel("Môn: "+monBUS.layTenMonBangMaDT(maDT));
        lopBUS lopBUS = new lopBUS();
        JLabel lb_nhomLop = new JLabel("Nhóm: "+ lopBUS.layNhomLopMaTKvaMaDT(maTK, maDT));
        nguoiDungBUS ndBUS = new nguoiDungBUS();
        nguoiDungDTO nguoiRaDe = ndBUS.layNguoiDung(deThi.getMaGV());
        
        JLabel lb_nguoiRaDe = new JLabel("Người ra đề: "+nguoiRaDe.getHoTen());
        JLabel lb_thoiGian = new JLabel("Thời gian: "+deThi.getThoiGianLamBai()+" phút");

        pn_thongTinDe.add(lb_mon);
        pn_thongTinDe.add(lb_nhomLop);
        pn_thongTinDe.add(lb_nguoiRaDe);
        pn_thongTinDe.add(lb_thoiGian);

        lb_time.setHorizontalAlignment(JLabel.CENTER);
        lb_time.setVerticalAlignment(JLabel.CENTER);

        pn_thongTinDe.setBorder(BorderFactory.createTitledBorder(null, deThi.getTenDeThi(), DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font14) {
        }));

        pn_time.add(lb_time, BorderLayout.EAST);

        pn_thongTin.add(pn_time, BorderLayout.NORTH);
        pn_thongTin.add(pn_thongTinDe, BorderLayout.CENTER);

        JPanel pn_btn = new JPanel(new FlowLayout(0, 20, 10));
        btn_prev = new JButton("Trước");
        btn_prev.addActionListener(this);
        btn_next = new JButton("Sau");
        btn_next.addActionListener(this);
        btn_finish = new JButton("Nộp bài");
        btn_finish.addActionListener(this);
        pn_btn.add(btn_prev);
        pn_btn.add(btn_next);
        pn_btn.add(btn_finish);

        cards = new JPanel();
        cardLayout = new CardLayout();
        cards.setLayout(cardLayout);

        this.getContentPane().add(pn_thongTin, BorderLayout.NORTH);
        this.getContentPane().add(cards, BorderLayout.CENTER);
        this.getContentPane().add(pn_btn, BorderLayout.SOUTH);
        this.setVisible(true);

    }

    public void taoCacCauHoi() throws SQLException {
        int number = 0;
        for (chiTietDeDTO ctd : dsCTD) {
            mangMaCH.add(ctd.getMaCH().trim());
            number++;
            cauHoiDTO ch = cauHoiBUS.layCauHoiBangMaCH(ctd.getMaCH());
//            -------------------
            JPanel pn_cauHoi_Wrap = new JPanel(new BorderLayout(10, 10));
            JPanel pn_cauHoi = new JPanel(new BorderLayout(10, 10));
            pn_cauHoi.setBorder(BorderFactory.createTitledBorder(null, "Cau " + number, DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font14) {
            }));
            if (!ch.getImg().isEmpty()) {
                pn_cauHoi.setPreferredSize(new Dimension(0, 200));
                JLabel lb_img = new JLabel();
                lb_img.setIcon(BASE.createResizedIcon(FrameBaiThi.class, "..//image//" + ch.getImg(), 300, pn_cauHoi.getPreferredSize().height));

                pn_cauHoi.add(lb_img, BorderLayout.EAST);
            } else {
                pn_cauHoi.setPreferredSize(new Dimension(0, 100));
            }

            JTextArea txtaCauHoi = new JTextArea();
            txtaCauHoi.setEnabled(false);
            txtaCauHoi.setText(ch.getNoidung());
            txtaCauHoi.setLineWrap(true);// tự động xuống hàng khi văn bản quá dài
            JScrollPane scrollPane_cauhoi = new JScrollPane(txtaCauHoi);
            pn_cauHoi.add(scrollPane_cauhoi, BorderLayout.CENTER);

            bangChuCai = new String[]{"A", "B", "C", "D", "E", "F", "J", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
//        -------------------------
            ArrayList<dapAnDTO> arrDapAn = dapAnBUS.layCacDapAnBangMaCH(ch.getMaCH());

            if (ch.getMaHT().trim().equals("TNBC")) {
                JPanel pn_tn4 = new JPanel();
                pn_tn4.setLayout(new BoxLayout(pn_tn4, BoxLayout.Y_AXIS));
                ButtonGroup btnG = new ButtonGroup();
                for (int i = 0; i < arrDapAn.size(); i++) {
                    JPanel panel = new JPanel(new BorderLayout());

                    panel.setMaximumSize(new Dimension(1400, 40));
                    JLabel label = new JLabel(bangChuCai[i]);
                    label.setPreferredSize(new Dimension(15, 0));
                    JTextArea txtaCauTraLoi = new JTextArea();
                    txtaCauTraLoi.setText(arrDapAn.get(i).getNoidung());
                    txtaCauTraLoi.setEnabled(false);
                    txtaCauTraLoi.setLineWrap(true);
                    JScrollPane scrollPane_cauTraLoi = new JScrollPane(txtaCauTraLoi);
                    JRadioButton rdb = new JRadioButton();
                    rdb.setActionCommand("TNBC_DA" + bangChuCai[i] + "_" + ch.getMaCH().trim());
                    arrDA.add(rdb);
                    btnG.add(rdb);
                    panel.add(label, BorderLayout.WEST);
                    panel.add(scrollPane_cauTraLoi, BorderLayout.CENTER); // Thêm JScrollPane vào panel thay vì JTextField
                    panel.add(rdb, BorderLayout.EAST);
                    pn_tn4.add(panel);
                }
                pn_cauHoi_Wrap.add(pn_tn4, BorderLayout.CENTER);
            } else if (ch.getMaHT().trim().equals("TNNC")) {
                JPanel pn_nhieuCauTraLoi = new JPanel();
                pn_nhieuCauTraLoi.setLayout(new BoxLayout(pn_nhieuCauTraLoi, BoxLayout.Y_AXIS));

                for (int i = 0; i < arrDapAn.size(); i++) {
                    JPanel panel = new JPanel(new BorderLayout());
                    panel.setPreferredSize(new Dimension(0, 20));
                    JLabel label = new JLabel(bangChuCai[i]);
                    label.setPreferredSize(new Dimension(15, 0));

                    JTextArea txtaCauTraLoi = new JTextArea();
                    txtaCauTraLoi.setText(arrDapAn.get(i).getNoidung());
                    txtaCauTraLoi.setLineWrap(true);
                    txtaCauTraLoi.setEnabled(false);
                    JScrollPane scrollPane_cauTraLoi = new JScrollPane(txtaCauTraLoi);
                    JCheckBox checkBox = new JCheckBox();
                    checkBox.setActionCommand("TNNC_DA" + bangChuCai[i] + "_" + ch.getMaCH().trim());
                    arrDA.add(checkBox);

                    panel.add(label, BorderLayout.WEST);
                    panel.add(scrollPane_cauTraLoi, BorderLayout.CENTER); // Thêm JScrollPane vào panel thay vì JTextField
                    panel.add(checkBox, BorderLayout.EAST);
                    pn_nhieuCauTraLoi.add(panel);
                }
                JScrollPane scrollPane_nhieuCauTL = new JScrollPane(pn_nhieuCauTraLoi);
                scrollPane_nhieuCauTL.setPreferredSize(new Dimension(0, 200));
                scrollPane_nhieuCauTL.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Chỉ hiển thị thanh cuộn theo chiều dọc khi cần thiết
                scrollPane_nhieuCauTL.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Tắt thanh cuộn theo chiều ngang
                pn_cauHoi_Wrap.add(scrollPane_nhieuCauTL, BorderLayout.CENTER);

            }

            pn_cauHoi_Wrap.add(pn_cauHoi, BorderLayout.NORTH);
            cards.add(pn_cauHoi_Wrap, ch.getMaCH().trim());
//            -------------------
        }
    }

    private void startCountdown(int phut, int giay) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            int minutes = phut;
            int seconds = giay;

            @Override
            public void run() {
                SwingUtilities.invokeLater(() -> {
                    if (minutes == 0 && seconds == 0) {
                        timer.cancel(); // Dừng đồng hồ đếm ngược khi hết thời gian
//                        lb_time.setText("Time's up!");
                        dispose();
                    } else {
                        if (seconds == 0) {
                            minutes--;
                            seconds = 59;
                        } else {
                            seconds--;
                        }
                        String time = String.format("%02d:%02d", minutes, seconds);
                        lb_time.setText(time);
                    }
                });
            }
        }, 0, 1000); // Mỗi giây cập nhật một lần
    }

    private int laySoCauDung(ArrayList<Object> obj) throws SQLException {
        ArrayList<String> arrChuoiDA = new ArrayList<>();
        for (Object x : obj) {
            if (x instanceof JRadioButton) { // Kiểm tra xem x có phải là một JRadioButton không
                JRadioButton rdb = (JRadioButton) x; // Ép kiểu x thành JRadioButton
                if (rdb.isSelected()) {
                    arrChuoiDA.add(rdb.getActionCommand());
                }
            } else if (x instanceof JCheckBox) { // Kiểm tra xem x có phải là một JRadioButton không
                JCheckBox chk = (JCheckBox) x; // Ép kiểu x thành JCheckBox
                if (chk.isSelected()) {
                    arrChuoiDA.add(chk.getActionCommand());
                }
            }
        }

        ArrayList<String> arrChuoiNhieuDung = new ArrayList<>();
        for (String x : mangMaCH) {
            cauHoiDTO ch = cauHoiBUS.layCauHoiBangMaCH(x);
            if (ch.getMaHT().trim().equals("TNNC")) {
                ArrayList<dapAnDTO> arrDapAn = dapAnBUS.layCacDapAnBangMaCH(x);
                for (dapAnDTO y : arrDapAn) {
                    if (y.isDungSai()) {
                        String chuoi = "TNNC_" + y.getMaDa().trim() + "_" + y.getMaCH().trim();
                        arrChuoiNhieuDung.add(chuoi);
                    }
                }
            }
        }
        int countKQ = 0;
        for (String x : arrChuoiDA) {
            String[] parts = x.split("_");
            String maHT = parts[0];
            String maDA = parts[1];
            String maCH = parts[2];
            if (maHT.equals("TNBC") && dapAnBUS.kiemTraDapAn(maCH, maDA)) {
                countKQ++;
            }
        }

        for (String x : mangMaCH) {
            cauHoiDTO ch = cauHoiBUS.layCauHoiBangMaCH(x);
            if (ch.getMaHT().trim().equals("TNNC")) {
                ArrayList<String> arrChuoiMinhChon = new ArrayList<String>();
                ArrayList<String> arrChuoiDapAn = new ArrayList<String>();
                for (String a : arrChuoiDA) {
                    String[] parts = a.split("_");
                    String maHT = parts[0];
                    String maDA = parts[1];
                    String maCH = parts[2];
                    if (maCH.equals(ch.getMaCH().trim())) {
                        arrChuoiMinhChon.add(a);
//                        System.out.println(a);
                    }
                }
                for (String a : arrChuoiNhieuDung) {
                    String[] parts = a.split("_");
                    String maHT = parts[0];
                    String maDA = parts[1];
                    String maCH = parts[2];
                    if (maCH.equals(ch.getMaCH().trim())) {
                        arrChuoiDapAn.add(a);
//                        System.out.println(a);
                    }
                }
                if (arrChuoiMinhChon.equals(arrChuoiDapAn)) {
                    countKQ++;
                }
            }
        }
        return countKQ;

    }

    public ArrayList<Integer> cacCauChuaChon(ArrayList<Object> obj) {
        ArrayList<String> arrChuoiMaCHDaChon = new ArrayList<>();
        for (Object x : obj) {
            if (x instanceof JRadioButton) { // Kiểm tra xem x có phải là một JRadioButton không
                JRadioButton rdb = (JRadioButton) x; // Ép kiểu x thành JRadioButton
                if (rdb.isSelected()) {
                    String[] parts = rdb.getActionCommand().split("_");
                    String maCH = parts[2];
                    arrChuoiMaCHDaChon.add(maCH);
                }
            } else if (x instanceof JCheckBox) { // Kiểm tra xem x có phải là một JRadioButton không
                JCheckBox chk = (JCheckBox) x; // Ép kiểu x thành JCheckBox
                if (chk.isSelected()) {
                    String[] parts = chk.getActionCommand().split("_");
                    String maCH = parts[2];
                    arrChuoiMaCHDaChon.add(maCH);
                }
            }
        }
        ArrayList<Integer> cacCauChuaLam = new ArrayList<>();
        for (int i = 0; i < mangMaCH.size(); i++) {
            if (!arrChuoiMaCHDaChon.contains(mangMaCH.get(i))) {
                cacCauChuaLam.add(i + 1);
            }
        }
//        System.out.println("Cac cau chua lam");
//        for(int x: cacCauChuaLam){
//            System.out.println("cau: "+x);
//        }
        return cacCauChuaLam;
    }

    public String truThoiGian(String thoiGianBanDau, String thoiGianBiTru) {
        // Chuyển đổi thời gian ban đầu và thời gian bị trừ thành số phút
        int phutBanDau = chuyenDoiThanhPhut(thoiGianBanDau);
        int phutBiTru = chuyenDoiThanhPhut(thoiGianBiTru);

        // Trừ số phút của thời gian bị trừ từ số phút của thời gian ban đầu
        int phutKetQua = phutBanDau - phutBiTru;

        // Chuyển đổi kết quả trở lại dạng chuỗi thời gian
        return chuyenDoiThanhChuoiThoiGian(phutKetQua);
    }

    public int chuyenDoiThanhPhut(String thoiGian) {
        String[] parts = thoiGian.split(":");
        int gio = Integer.parseInt(parts[0]);
        int phut = Integer.parseInt(parts[1]);
        return gio * 60 + phut;
    }

    public String chuyenDoiThanhChuoiThoiGian(int phut) {
        int gio = phut / 60;
        int phutConLai = phut % 60;
        return String.format("%02d:%02d", gio, phutConLai);
    }

    public static String chuyenDoiGio(String thoiGian) {
        // Chia chuỗi thành các phần riêng biệt: phút và giây
        String[] parts = thoiGian.split(":");

        // Chuyển đổi các phần thành số nguyên
        int phut = Integer.parseInt(parts[0]);
        int giay = Integer.parseInt(parts[1]);

        // Tính số giờ mới và số phút mới sau khi chuyển đổi
        int gioMoi = phut / 60;
        phut %= 60;

        // Đảm bảo số giờ mặc định là 00
        int gio = 0;

        // Cộng số giờ mới vào số giờ
        gio += gioMoi;

        // Chuyển đổi các phần thành chuỗi và đảm bảo chúng có đủ số lượng chữ số
        String strGio = String.format("%02d", gio);
        String strPhut = String.format("%02d", phut);
        String strGiay = String.format("%02d", giay);

        // Ghép các phần lại với nhau thành chuỗi kết quả
        return strGio + ":" + strPhut + ":" + strGiay;
    }

    @Override
    public void actionPerformed(ActionEvent e
    ) {
        Object btn = e.getSource();
        if (btn == btn_next) {
            if (count != dsCTD.size() - 1) {
                count++;
                this.cardLayout.show(cards, dsCTD.get(count).getMaCH().trim());
            }
        } else if (btn == btn_prev) {
            if (count != 0) {
                count--;
                this.cardLayout.show(cards, dsCTD.get(count).getMaCH().trim());
            }
        } else if (btn == btn_finish) {
            ArrayList<Integer> cauChuaLam = cacCauChuaChon(arrDA);
            if (cauChuaLam.isEmpty()) {
                try {
                    int soCauDung = laySoCauDung(arrDA);
                    int slCau = deThi.getSLCauHoi();
                    float diem = (soCauDung / (float)slCau) * 10.0f;
                    String thoiGianConLai = lb_time.getText();
                    if (thoiGianConLai.charAt(0) == '0') {
                        thoiGianConLai = thoiGianConLai.substring(1);
                    }
                    String thoiGianTong = deThi.getThoiGianLamBai() + ":00";
                    String thoiGianDaLam = chuyenDoiGio(truThoiGian(thoiGianTong, thoiGianConLai));
                    String maKQ = "KQ" + maDT.substring(2) + maTK;
                    
                    ketQuaDTO kq = new ketQuaDTO();
                    kq.setMaKQ(maKQ);
                    kq.setMaDT(maDT);
                    kq.setDiem(diem);
                    kq.setSLCauDung(soCauDung);
                    kq.setTGLamXong(thoiGianDaLam);
                    kq.setMaTK(maTK);
                    ketQuaBUS1 ketQuaBUS = new ketQuaBUS1();
                    ketQuaBUS.taoKetQua(kq);
                    this.dispose();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } else {
                String thongBao = "Cac cau chua lam: ";

                for (int x : cauChuaLam) {
                    thongBao += x + ",";
                }
                thongBao = thongBao.substring(0, thongBao.length() - 1);
                new ShowDiaLog(thongBao, ShowDiaLog.ERROR_DIALONG);
            }
        }

    }
}
