/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

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
import static GUI.BASE.font13;
import static GUI.BASE.font16;
import static GUI.BASE.white;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GiaoDienUser extends JFrame implements ActionListener {

    private JPanel cards;
    private CardLayout cardLayout;
    private JLabel lb_Header;

    public GiaoDienUser() {
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

    public void init() {
        this.setTitle("Frame");
        this.setSize(1450, 700);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        String[] name_btn = new String[]{"Câu hỏi", "Môn", "Thêm lớp", "Đề thi", "Kết quả", "Tài khoản", "Phân quyền","Thông tin"};
        String[] name_image = new String[]{"taoCauHoi_icon.png", "books_icon.png", "class_icon.png", "taoDeThi_icon.png", "ketQua_icon.png", "account_icon.png", "Secure_icon.png","information_icon.png"};
        JButton[] arrBtn = new JButton[name_btn.length];
        for (int i = 0; i < name_btn.length; i++) {
            JButton btn = new JButton(name_btn[i]);
            btn.addActionListener(this);
            arrBtn[i] = btn;
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);
            btn.setForeground(white);
            btn.setIcon(createResizedIcon(GiaoDienUser.class, "..//image//" + name_image[i], 20, 20));
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
        arrBtn[0].setBackground(dark_green);
        arrBtn[0].setSelected(true);

//panel right
        JPanel pn_right = new JPanel();
        pn_right.setLayout(new BorderLayout());
// header
        JPanel pn_header = new JPanel();
        pn_header.setLayout(new BorderLayout());
        pn_header.setPreferredSize(new Dimension(0, 40));
        pn_header.setBackground(dark_green);

        lb_Header = new JLabel("Tạo câu hỏi");
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
//        Phần thêm panel
//String[] name_btn = new String[]{"Câu hỏi", "Môn thi","Thêm lớp", "Đề thi", "Kết quả", "Tài khoản", "Phân quyền"};
        JPanel pnTaoCauHoi = new PanelTaoCauHoi();
        cards.add(pnTaoCauHoi, "pnTaoCauHoi");
        JPanel pnThemMon = new PnThemMon();
        cards.add(pnThemMon, "pnThemMon");
        JPanel pnThemLop = new PnThemLop();
        cards.add(pnThemLop, "pnThemLop");
        JPanel pnDeThi = new PnTaoDe();
        cards.add(pnDeThi, "pnDeThi");
        JPanel pnKetQua = new PnKetQua();
        cards.add(pnKetQua, "pnKetQua");
        JPanel pnTaiKhoan = new PnThemUser();
        cards.add(pnTaiKhoan, "pnTaiKhoan");
        JPanel pnPhanQuyen = new PnPhanQuyen();
        cards.add(pnPhanQuyen, "pnPhanQuyen");
        JPanel pnThongTin = new PnThongTinCaNhan();
        cards.add(pnThongTin, "pnThongTin");

        pn_right.add(pn_header, BorderLayout.NORTH);
        pn_right.add(pn_content, BorderLayout.CENTER);

        this.add(pn_left, BorderLayout.WEST);
        this.add(pn_right, BorderLayout.CENTER);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btn_name = e.getActionCommand();
        if (btn_name.equals("Câu hỏi")) {
            cardLayout.show(cards, "pnTaoCauHoi");
            lb_Header.setText("Câu hỏi");
        } else if (btn_name.equals("Môn")) {
            cardLayout.show(cards, "pnThemMon");
            lb_Header.setText("Môn");
        } else if (btn_name.equals("Thêm lớp")) {
            cardLayout.show(cards, "pnThemLop");
            lb_Header.setText("Thêm lớp");
        } else if (btn_name.equals("Đề thi")) {
            cardLayout.show(cards, "pnDeThi");
            lb_Header.setText("Đề thi");
        } else if (btn_name.equals("Kết quả")) {
            cardLayout.show(cards, "pnKetQua");
            lb_Header.setText("Kết quả");
        } else if (btn_name.equals("Tài khoản")) {
            cardLayout.show(cards, "pnTaiKhoan");
            lb_Header.setText("Tài khoản");
        } else if (btn_name.equals("Phân quyền")) {
            cardLayout.show(cards, "pnPhanQuyen");
            lb_Header.setText("Phân quyền");
        }else if (btn_name.equals("Thông tin")) {
            cardLayout.show(cards, "pnThongTin");
            lb_Header.setText("Thông tin");
        }
    }

    public static void main(String[] args) {
        new GiaoDienUser();
    }
}
