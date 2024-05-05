/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.taiKhoanBUS;
import DTO.taiKhoanDTO;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import static GUI.BASE.cobalt_blue;
import static GUI.BASE.createResizedIcon;
import static GUI.BASE.dark_green;
import static GUI.BASE.font16;
import static GUI.BASE.white;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

public class GiaoDienUserGUI extends JFrame implements ActionListener {

    private String maTK;
    private JPanel cards;
    private CardLayout cardLayout;
    private JLabel lb_Header;
    private taiKhoanBUS taiKhoan;

    public GiaoDienUserGUI(String maTK) throws SQLException {
        this.maTK = maTK;
        this.taiKhoan = new taiKhoanBUS();
        init();
    }

    public JPanel getCards() {
        return cards;
    }

    public void setCards(JPanel cards) {
        this.cards = cards;
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public void setCardLayout(CardLayout cardLayout) {
        this.cardLayout = cardLayout;
    }

    public JLabel getLb_Header() {
        return lb_Header;
    }

    public void setLb_Header(JLabel lb_Header) {
        this.lb_Header = lb_Header;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String layTenBtn(String maCN) {
        if (maCN.equals("CNDCH")) {
            return "Duyệt câu hỏi";
        } else if (maCN.equals("CNPQ")) {
            return "Phân quyền";
        } else if (maCN.equals("CNTD")) {
            return "Tạo đề";
        } else if (maCN.equals("CNTLM")) {
            return "Tạo lớp mới";
        } else if (maCN.equals("CNTLSV")) {
            return "Thêm lớp sinh viên";
        } else if (maCN.equals("CNTMGV")) {
            return "Thêm môn giảng viên";
        } else if (maCN.equals("CNTMM")) {
            return "Tạo môn mới";
        } else if (maCN.equals("CNTTT")) {
            return "Tạo tài khoản";
        } else if (maCN.equals("CNDSDDT")) {
            return "Đề đã tạo";
        }else if (maCN.equals("CNTCH")) {
            return "Tạo câu hỏi mới";
        }else if(maCN.equals("CNCSNDK")){
            return "Chỉnh sửa người duyệt kho";
        }else if(maCN.equals("CNXKQCDT")){
            return "Xem kết quả thi các đề thi";
        }
        return "";  
    }

    public String layIconBtn(String maCN) {
        if (maCN.equals("CNDCH")) {
            return "..//image//taoCauHoi_icon.png";
        } else if (maCN.equals("CNPQ")) {
            return "..//image//taoCauHoi_icon.png";
        } else if (maCN.equals("CNTD")) {
            return "..//image//taoCauHoi_icon.png";
        } else if (maCN.equals("CNTLM")) {
            return "..//image//taoCauHoi_icon.png";
        } else if (maCN.equals("CNTLSV")) {
            return "..//image//taoCauHoi_icon.png";
        } else if (maCN.equals("CNTMGV")) {
            return "..//image//taoCauHoi_icon.png";
        } else if (maCN.equals("CNTMM")) {
            return "..//image//taoCauHoi_icon.png";
        } else if (maCN.equals("CNTTT")) {
            return "..//image//taoCauHoi_icon.png";
        } else if (maCN.equals("CNDSDDT")) {
            return "..//image//taoCauHoi_icon.png";
        }else if (maCN.equals("CNTCH")) {
            return "..//image//taoCauHoi_icon.png";
        }else if (maCN.equals("Môn giảng viên")) {
            return "..//image//taoCauHoi_icon.png";
        }else if (maCN.equals("Lớp giảng viên")) {
            return "..//image//taoCauHoi_icon.png";
        }else if (maCN.equals("Lớp sinh viên")) {
            return "..//image//taoCauHoi_icon.png";
        }else if (maCN.equals("Đề thi")) {
            return "..//image//taoCauHoi_icon.png";
        }else if (maCN.equals("Thông tin")) {
            return "..//image//taoCauHoi_icon.png";
        }else if (maCN.equals("Đăng xuất")) {
            return "..//image//taoCauHoi_icon.png";
        }else if(maCN.equals("CNCSNDK")){
            return "..//image//taoCauHoi_icon.png";
        }
        return "";
    }
    
    public ArrayList<String> layChucNangCoBan(String maTK){
        taiKhoanDTO tk =  taiKhoan.layTaiKhoan(maTK);
        String maQuyen = tk.getMaQuyen();
        ArrayList<String> arrCNCB = new ArrayList<>();
        
        if(maQuyen.equals("QGV")){
            arrCNCB.add("Môn giảng viên");
            arrCNCB.add("Lớp giảng viên");
        }else if(maQuyen.equals("QSV")){
            arrCNCB.add("Lớp sinh viên");
            arrCNCB.add("Đề thi");
        }
        arrCNCB.add("Thông tin");
        arrCNCB.add("Đăng xuất");
        return arrCNCB;
    }

    public void init() throws SQLException {
        this.setTitle("Frame");
        this.setSize(1200, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.getContentPane().setLayout(new BorderLayout());

        JPanel pn_left = new JPanel();
        pn_left.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        pn_left.setPreferredSize(new Dimension(200, 0));
        pn_left.setBackground(cobalt_blue);

        JPanel pn_tittle = new JPanel();
        pn_tittle.setLayout(new BorderLayout());
        pn_tittle.setBackground(dark_green);
        pn_tittle.setPreferredSize(new Dimension(200, 40));
        JLabel lb_tittle = new JLabel("Hellu");
        lb_tittle.setForeground(white);
        lb_tittle.setFont(font16);
        pn_tittle.add(lb_tittle, BorderLayout.CENTER);
        lb_tittle.setHorizontalAlignment(JLabel.CENTER);
        lb_tittle.setVerticalAlignment(JLabel.CENTER);
        pn_left.add(pn_tittle);
        
        ArrayList<String> arrMaCN = taiKhoan.layDanhSachMaCN(maTK);
        ArrayList<String> arrCNCB = layChucNangCoBan(maTK);
        
        
        //  String[] name_btn = new String[]{"Câu hỏi", "Môn", "Thêm lớp", "Đề thi", "Kết quả", "Tài khoản", "Phân quyền", "Thông tin"};
        // String[] name_image = new String[]{"taoCauHoi_icon.png", "books_icon.png", "class_icon.png", "taoDeThi_icon.png", "ketQua_icon.png", "account_icon.png", "Secure_icon.png", "information_icon.png"};
        ArrayList<JButton> arrBtn = new ArrayList<>();
        

        for (String maCN : arrMaCN) {
            JButton btn = new JButton(layTenBtn(maCN));
            btn.addActionListener(this);
            arrBtn.add(btn);
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);
            btn.setForeground(white);
            btn.setIcon(createResizedIcon(GiaoDienUserGUI.class, layIconBtn(maCN), 20, 20));
            btn.setFont(font16);
            btn.setPreferredSize(new Dimension(200, 50));
            btn.setBackground(cobalt_blue);
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            pn_left.add(btn);
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    // Thay đổi màu nền khi chuột hover vào
                    btn.setBackground(dark_green);

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (!btn.isSelected()) {
                        btn.setBackground(cobalt_blue);
                    }
                }

                public void mouseClicked(MouseEvent e) {
                    // Thiết lập lại màu nền của tất cả các JButton
                    for (JButton btn : arrBtn) {
                        btn.setSelected(false);
                        btn.setBackground(cobalt_blue);
                    }
                    // Thiết lập màu nền của JButton được chọn
                    btn.setSelected(true);
                    btn.setBackground(dark_green);
                }
            });
        }
        for (String maCN : arrCNCB) {
            JButton btn = new JButton(maCN);
            btn.addActionListener(this);
            arrBtn.add(btn);
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);
            btn.setForeground(white);
            btn.setIcon(createResizedIcon(GiaoDienUserGUI.class, layIconBtn(maCN), 20, 20));
            btn.setFont(font16);
            btn.setPreferredSize(new Dimension(200, 50));
            btn.setBackground(cobalt_blue);
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            pn_left.add(btn);
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    // Thay đổi màu nền khi chuột hover vào
                    btn.setBackground(dark_green);

                }

                @Override
                public void mouseExited(MouseEvent e) {
                    if (!btn.isSelected()) {
                        btn.setBackground(cobalt_blue);
                    }
                }

                public void mouseClicked(MouseEvent e) {
                    // Thiết lập lại màu nền của tất cả các JButton
                    for (JButton btn : arrBtn) {
                        btn.setSelected(false);
                        btn.setBackground(cobalt_blue);
                    }
                    // Thiết lập màu nền của JButton được chọn
                    btn.setSelected(true);
                    btn.setBackground(dark_green);
                }
            });
        }

        for(JButton btn: arrBtn){
            if(btn.getText().equals("Thông tin")){
                btn.setBackground(dark_green);
                btn.setSelected(true);
                break;
            }
        }



//panel right
        JPanel pn_right = new JPanel();
        pn_right.setLayout(new BorderLayout());
// header
        JPanel pn_header = new JPanel();
        pn_header.setLayout(new BorderLayout());
        pn_header.setPreferredSize(new Dimension(0, 40));
        pn_header.setBackground(dark_green);

        lb_Header = new JLabel("Thông tin");
        lb_Header.setFont(font16);
        lb_Header.setForeground(white);
        pn_header.add(lb_Header, BorderLayout.CENTER);
        lb_Header.setHorizontalAlignment(JLabel.CENTER);
        lb_Header.setVerticalAlignment(JLabel.CENTER);

        JPanel pn_content = new JPanel();
        pn_content.setLayout(new BorderLayout());
//card layout
        cards = new JPanel();
        pn_content.add(cards, BorderLayout.CENTER);
        cardLayout = new CardLayout();
        cards.setLayout(cardLayout);

//------------------------------
        JPanel pnThongTin = new ThongTinUserGUI(maTK);
        cards.add(pnThongTin, "pnThongTin");
        JPanel pnDuyetCauHoi = new PnDuyetCauHoi();
        cards.add(pnDuyetCauHoi, "pnDuyetCauHoi");
        JPanel pnPhanQuyen = new PnPhanQuyen();
        cards.add(pnPhanQuyen, "pnPhanQuyen");
        JPanel pnTaoDe = new PnTaoDe();
        cards.add(pnTaoDe, "pnTaoDe");
        JPanel pnTaoLop = new PnTaoLopMoi();
        cards.add(pnTaoLop, "pnTaoLop");
        JPanel pnTaoMon = new PnTaoMonMoi();
        cards.add(pnTaoMon, "pnTaoMon");
        JPanel pnThemLopSinhVien = new PnThemLopChoSV();
        cards.add(pnThemLopSinhVien, "pnThemLopSinhVien");
        JPanel pnThemMonGiangVien = new PnThemMonChoGV();
        cards.add(pnThemMonGiangVien, "pnThemMonGiangVien");
        JPanel pnTaoTaiKhoan = new PnTaoTaiKhoan();
        cards.add(pnTaoTaiKhoan, "pnTaoTaiKhoan");
        JPanel pnDSDDT = new PnDsDeThiDaTao(maTK);
        cards.add(pnDSDDT, "pnDSDDT");
        JPanel pnKetQua = new PnKetQua();
        cards.add(pnKetQua, "pnKetQua");
        JPanel pnTaoCauHoi = new PanelTaoCauHoi();
        cards.add(pnTaoCauHoi, "pnTaoCauHoi");
        JPanel pnMonGV = new PnDanhSachMonGV(maTK);
        cards.add(pnMonGV, "pnMonGV");
        JPanel pnLopGV = new PnDSLopGV(maTK);
        cards.add(pnLopGV, "pnLopGV");
        
        JPanel pnLopSV = new PnDSLopSV(maTK);
        cards.add(pnLopSV, "pnLopSV");
        JPanel pnDeThiSV = new PnDeThiSinhVien(maTK);
        cards.add(pnDeThiSV, "pnDeThiSV");
        JPanel pnCSNDK = new PnChinhSuaNguoiDuyetKho(maTK);
        cards.add(pnCSNDK, "pnCSNDK");
        
        

        pn_right.add(pn_header, BorderLayout.NORTH);
        pn_right.add(pn_content, BorderLayout.CENTER);

        this.add(pn_left, BorderLayout.WEST);
        this.add(pn_right, BorderLayout.CENTER);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn_name = e.getActionCommand();
        if (btn_name.equals("Duyệt câu hỏi")) {
            cardLayout.show(cards, "pnDuyetCauHoi");
            lb_Header.setText("Duyệt câu hỏi");
        } else if (btn_name.equals("Phân quyền")) {
            cardLayout.show(cards, "pnPhanQuyen");
            lb_Header.setText("Phân quyền");
        } else if (btn_name.equals("Tạo đề")) {
            cardLayout.show(cards, "pnTaoDe");
            lb_Header.setText("Tạo đề");
        }else if (btn_name.equals("Tạo lớp mới")) {
            cardLayout.show(cards, "pnTaoLop");
            lb_Header.setText("Tạo lớp mới");
        } else if (btn_name.equals("Thêm lớp sinh viên")) {
            cardLayout.show(cards, "pnThemLopSinhVien");
            lb_Header.setText("Thêm lớp sinh viên");
        } else if (btn_name.equals("Thêm môn giảng viên")) {
            cardLayout.show(cards, "pnThemMonGiangVien");
            lb_Header.setText("Thêm môn giảng viên");
        } else if (btn_name.equals("Tạo môn mới")) {
            cardLayout.show(cards, "pnTaoMon");
            lb_Header.setText("Tạo môn mới");
        } else if (btn_name.equals("Tạo tài khoản")) {
            cardLayout.show(cards, "pnTaoTaiKhoan");
            lb_Header.setText("Tạo tài khoản");
        } else if (btn_name.equals("Xem kết quả thi các đề thi")) {
            cardLayout.show(cards, "pnKetQua");
            lb_Header.setText("Xem kết quả thi các đề thi");
        }else if (btn_name.equals("Tạo câu hỏi mới")) {
            cardLayout.show(cards, "pnTaoCauHoi");
            lb_Header.setText("Tạo câu hỏi mới");
        } else if (btn_name.equals("Môn giảng viên")) {
            cardLayout.show(cards, "pnMonGV");
            lb_Header.setText("Môn giảng viên");
        } else if (btn_name.equals("Lớp giảng viên")) {
            cardLayout.show(cards, "pnLopGV");
            lb_Header.setText("Lớp giảng viên");
        } else if (btn_name.equals("Lớp sinh viên")) {
            cardLayout.show(cards, "pnLopSV");
            lb_Header.setText("Lớp sinh viên");
        } else if (btn_name.equals("Đề thi")) {
            cardLayout.show(cards, "pnDeThiSV");
            lb_Header.setText("Đề thi");
        } else if (btn_name.equals("Đề đã tạo")) {
            cardLayout.show(cards, "pnDSDDT");
            lb_Header.setText("Đề đã tạo");
        } else if (btn_name.equals("Thông tin")) {
            cardLayout.show(cards, "pnThongTin");
            lb_Header.setText("Thông tin");
        }else if (btn_name.equals("Chỉnh sửa người duyệt kho")) {
            cardLayout.show(cards, "pnCSNDK");
            lb_Header.setText("Chỉnh sửa người duyệt kho");
        } else if (btn_name.equals("Đăng xuất")) {
            System.exit(0);
        } 
    }

    public static void main(String[] args) throws SQLException {
        new GiaoDienUserGUI("TK1");
    }
}
