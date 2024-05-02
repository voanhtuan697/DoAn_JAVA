/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.cauHoiBUS1;
import BUS.dapAnBUS;
import BUS.monBUS1;
import BUS.nguoiDungBUS;
import DTO.cauHoiDTO;
import DTO.dapAnDTO;
import DTO.nguoiDungDTO;
import static GUI.BASE.font14;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import static javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION;
import static javax.swing.border.TitledBorder.DEFAULT_POSITION;

/**
 *
 * @author E7250
 */
public class FrameXemChiTietCauHoi extends JFrame {

    private String maCH;
    private cauHoiBUS1 cauHoiBUS;
    private cauHoiDTO ch;
    private dapAnBUS dapAnBUS;
    private String[] bangChuCai;

    public FrameXemChiTietCauHoi(String maCH) throws SQLException {
        this.maCH = maCH;
        cauHoiBUS = new cauHoiBUS1();
        dapAnBUS = new dapAnBUS();
        ch = cauHoiBUS.layCauHoiBangMaCH(maCH);
        init();
    }

    public void init() throws SQLException {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new BorderLayout());
        Font font = new Font("Arial", Font.PLAIN, 18);
        bangChuCai = new String[]{"A", "B", "C", "D", "E", "F", "J", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        JPanel pn_thongTinCH = new JPanel(new FlowLayout(0, 20, 10));
        pn_thongTinCH.setBorder(BorderFactory.createTitledBorder(null, "Chi tiết câu hỏi", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font14) {
        }));
        JLabel lb_maCH = new JLabel("Mã câu hỏi: " + this.maCH);
        nguoiDungBUS ndBus = new nguoiDungBUS();
        nguoiDungDTO gv = ndBus.layNguoiDung(this.ch.getMaGV());
        String tenGV = gv.getHoTen();
        monBUS1 monBUS = new monBUS1();
        String tenMon = monBUS.layTenMonBangMaCH(maCH);
        JLabel lb_mon = new JLabel("Môn: " + tenMon);
        JLabel lb_nguoiTaoCH = new JLabel("Người tạo câu hỏi: " + tenGV);
        JLabel lb_mucDo = new JLabel("Độ khó: " + ch.getDoKho());

        pn_thongTinCH.add(lb_maCH);
        pn_thongTinCH.add(lb_mon);
        pn_thongTinCH.add(lb_nguoiTaoCH);
        pn_thongTinCH.add(lb_mucDo);

        JPanel pn_cauHoiWrap = new JPanel(new BorderLayout(10, 10));

        JPanel pn_noiDungCauHoi = new JPanel(new BorderLayout(10, 10));
//        
//        
//        pn_noiDungCauHoi.setPreferredSize(new Dimension(0, 100));

        if (!ch.getImg().isEmpty()) {
            pn_noiDungCauHoi.setPreferredSize(new Dimension(0, 200));
            JLabel lb_img = new JLabel();
            lb_img.setIcon(BASE.createResizedIcon(FrameXemChiTietCauHoi.class, "..//image//" + ch.getImg(), 300, pn_noiDungCauHoi.getPreferredSize().height));

            pn_noiDungCauHoi.add(lb_img, BorderLayout.EAST);
        } else {
            pn_noiDungCauHoi.setPreferredSize(new Dimension(0, 100));
        }
        pn_noiDungCauHoi.setBorder(BorderFactory.createTitledBorder(null, "Nội dung câu hỏi", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font14) {
        }));

        ArrayList<dapAnDTO> arrDapAn = dapAnBUS.layCacDapAnBangMaCH(ch.getMaCH());

        JPanel pn_tn4 = new JPanel();
        pn_tn4.setLayout(new BoxLayout(pn_tn4, BoxLayout.Y_AXIS));
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
            JCheckBox chk = new JCheckBox();
            chk.setEnabled(false);
            chk.setSelected(arrDapAn.get(i).isDungSai());
            panel.add(label, BorderLayout.WEST);
            panel.add(scrollPane_cauTraLoi, BorderLayout.CENTER); // Thêm JScrollPane vào panel thay vì JTextField
            panel.add(chk, BorderLayout.EAST);
            pn_tn4.add(panel);
        }
        pn_cauHoiWrap.add(pn_tn4, BorderLayout.CENTER);

        JTextArea txtaCauHoi = new JTextArea();
        txtaCauHoi.setEnabled(false);
        txtaCauHoi.setText(ch.getNoidung());
        txtaCauHoi.setLineWrap(true);// tự động xuống hàng khi văn bản quá dài
        JScrollPane scrollPane_cauhoi = new JScrollPane(txtaCauHoi);
        pn_noiDungCauHoi.add(scrollPane_cauhoi, BorderLayout.CENTER);

        pn_cauHoiWrap.add(pn_noiDungCauHoi, BorderLayout.NORTH);

        this.getContentPane().add(pn_thongTinCH, BorderLayout.NORTH);
        this.getContentPane().add(pn_cauHoiWrap, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        new FrameXemChiTietCauHoi("CHTHUE1");
    }
}
