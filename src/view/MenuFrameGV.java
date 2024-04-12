/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Menu_GV_Listener;
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
import model.ImageUtils;
import static model.base.cobalt_blue;
import static model.base.dark_green;
import static model.base.font13;
import static model.base.font14b;
import static model.base.white;

/**
 *
 * @author E7250
 */
public class MenuFrameGV extends JFrame {

    private JPanel cards;
    private CardLayout cardLayout;
    private JLabel lb_Header;

    public MenuFrameGV() {
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
        this.setSize(1000, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        JPanel pn_left = new JPanel();
        pn_left.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        pn_left.setPreferredSize(new Dimension(150, 0));
        pn_left.setBackground(cobalt_blue);
        
        JPanel pn_tittle = new JPanel();
        pn_tittle.setLayout(new BorderLayout());
        pn_tittle.setBackground(dark_green);
        pn_tittle.setPreferredSize(new Dimension(150, 30));
        JLabel lb_tittle = new JLabel("Hellu");
        lb_tittle.setForeground(white);
        lb_tittle.setFont(font14b);
        pn_tittle.add(lb_tittle, BorderLayout.CENTER);
        lb_tittle.setHorizontalAlignment(JLabel.CENTER);
        lb_tittle.setVerticalAlignment(JLabel.CENTER);
        pn_left.add(pn_tittle);
        
// button
        Menu_GV_Listener listener = new Menu_GV_Listener(this);
        String[] name_btn = new String[]{"Tạo câu hỏi", "Tạo đề thi", "Kết quả","Thông tin","Đổi mật khẩu"};
        String[] name_image = new String[]{"taoCauHoi_icon.png", "taoDeThi_icon.png", "ketQua_icon.png","passwd_icon.png","passwd_icon.png"};
        JButton []arrBtn = new JButton[name_btn.length];
        for (int i = 0; i < name_btn.length; i++) {
            JButton btn = new JButton(name_btn[i]);
            btn.addActionListener(listener);
            arrBtn[i] = btn;
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);
            btn.setForeground(white);
            //btn.setIcon(new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MenuFrameGV.class.getResource("..//image//"+name_image[i]))).getImage().getScaledInstance(20, 20,Image.SCALE_SMOOTH)));
            btn.setIcon(ImageUtils.createResizedIcon(MenuFrameAd.class, "..//image//" + name_image[i], 20, 20));
            btn.setFont(font13);
            btn.setPreferredSize(new Dimension(150, 35));
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
        pn_header.setPreferredSize(new Dimension(0, 30));
        pn_header.setBackground(dark_green);
        
        lb_Header = new JLabel("Tạo câu hỏi");
        lb_Header.setFont(font14b);
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
        JPanel pn_TaoCH = new PanelTaoCauHoi();
        cards.add(pn_TaoCH, "pnTaoCH");
        JPanel pn_TaoDT = new ExamInfo();
        cards.add(pn_TaoDT, "pnTaoDT");
        JPanel pn_KQ = new pnKetQua();
        cards.add(pn_KQ, "pnKQ");
        JPanel pn_TT = new PnThongTinGV();
        cards.add(pn_TT, "pnThongTin");
        JPanel pn_Passwd = new PnDoiMatKhau();
        cards.add(pn_Passwd, "pnPass");

        pn_right.add(pn_header, BorderLayout.NORTH);
        pn_right.add(pn_content, BorderLayout.CENTER);

        this.add(pn_left, BorderLayout.WEST);
        this.add(pn_right, BorderLayout.CENTER);

        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        new MenuFrameGV();
    }
}
