/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Menu_GV_Listener;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

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
        this.setSize(900, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BorderLayout());

        JPanel pn_left = new JPanel();
        pn_left.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        pn_left.setPreferredSize(new Dimension(120, 0));
        
        JPanel pn_tittle = new JPanel();
        pn_tittle.setLayout(new BorderLayout());
        pn_tittle.setBackground(Color.PINK);
        pn_tittle.setPreferredSize(new Dimension(120, 30));
        JLabel lb_tittle = new JLabel("Hellu");
        pn_tittle.add(lb_tittle, BorderLayout.CENTER);
        lb_tittle.setHorizontalAlignment(JLabel.CENTER);
        lb_tittle.setVerticalAlignment(JLabel.CENTER);
        pn_left.add(pn_tittle);
        
// button
        Menu_GV_Listener listener = new Menu_GV_Listener(this);
        String[] name_btn = new String[]{"Tạo câu hỏi", "Tạo đề thi", "Kết quả","Đổi mật khẩu"};
        String[] name_image = new String[]{"taoCauHoi_icon.png", "taoDeThi_icon.png", "ketQua_icon.png","passwd_icon.png"};
        Font fontBtn = new Font("Arial", Font.BOLD, 10);
        for (int i = 0; i < name_btn.length; i++) {
            JButton btn = new JButton(name_btn[i]);
            btn.addActionListener(listener);
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);
            btn.setIcon(new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MenuFrameGV.class.getResource("..//image//"+name_image[i]))).getImage().getScaledInstance(20, 20,Image.SCALE_SMOOTH)));
            btn.setFont(fontBtn);
            btn.setPreferredSize(new Dimension(120, 40));
            btn.setBackground(Color.decode("#D8A3AB"));
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            pn_left.add(btn);
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    // Thay đổi màu nền khi chuột hover vào
                    btn.setBackground(Color.PINK);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // Thay đổi màu nền khi chuột rời khỏi
                    btn.setBackground(Color.decode("#D8A3AB"));
                }
            });
        }
        
        
//panel right
        JPanel pn_right = new JPanel();
        pn_right.setLayout(new BorderLayout());
// header
        JPanel pn_header = new JPanel();
        pn_header.setLayout(new BorderLayout());
        pn_header.setPreferredSize(new Dimension(0, 30));
        pn_header.setBackground(Color.decode("#D8A3AB"));
        
        lb_Header = new JLabel("Tạo câu hỏi");
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
        JPanel pn_Passwd = new PnDoiMatKhau();
        cards.add(pn_Passwd, "pnPass");

        pn_right.add(pn_header, BorderLayout.NORTH);
        pn_right.add(pn_content, BorderLayout.CENTER);

        this.add(pn_left, BorderLayout.WEST);
        this.add(pn_right, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
