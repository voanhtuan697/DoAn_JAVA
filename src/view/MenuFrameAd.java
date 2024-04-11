/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import model.ImageUtils;
import controller.Menu_AD_Listener;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuFrameAd extends JFrame {
    
    private JPanel cards;
    private CardLayout cardLayout;
    private JLabel lblHeader, lblName;
    private JPanel pnLeft, pnCenter, pnTop;
    private String[] title = {"ADMIN", "Thêm Admin", "Thêm TBM", "Thêm GV", "Thêm SV"};
    private String[] nameImage = {"taoCauHoi_icon.png", "taoDeThi_icon.png", "passwd_icon.png","taoDeThi_icon.png", "passwd_icon.png"};
    private JButton[] buttons = new JButton[title.length];
    Font font = new Font("Segoe UI", Font.PLAIN, 13);
    Font fontTitle = new Font("Segoe UI", Font.BOLD, 15);
    private Color colorPink = Color.decode("#D8A3AB");
    private Color colorPinkH = Color.decode("#DA91A4");
    
    public MenuFrameAd() {
        init();
        initComponents();
        card();
        this.setVisible(true);
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
        return lblHeader;
    }
    
    private void init() {
        this.setSize(1000, 600);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pnLeft = new JPanel();
        
        pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
        pnLeft.setBackground(colorPink);
        pnLeft.setPreferredSize(new Dimension(150, 0));
        
        pnCenter = new JPanel(new BorderLayout());
        pnCenter.setBackground(Color.CYAN);
        
        pnTop = new JPanel(new BorderLayout());
        pnTop.setBackground(Color.pink);
        pnTop.setPreferredSize(new Dimension(0, 30));
        
        this.add(pnTop, BorderLayout.NORTH);
        this.add(pnCenter, BorderLayout.CENTER);
        this.add(pnLeft, BorderLayout.WEST);
        
    }
    
    private void initComponents() {
        lblName = new JLabel("Hello Word");
        lblName.setFont(new Font("Segoe UI", Font.BOLD, 14) {
        });
        lblName.setForeground(Color.decode("#3D1460"));
        JPanel pnName = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnName.add(lblName);
        pnName.setBackground(Color.decode("#DE838A"));
        pnName.setPreferredSize(new Dimension(150, 0));
        lblHeader = new JLabel("Quản lý");
        lblHeader.setForeground(Color.WHITE);
        JPanel pnHead = new JPanel();
        pnHead.setBackground(colorPinkH);
        pnHead.add(lblHeader);
        lblHeader.setFont(fontTitle);
        pnTop.add(pnName, BorderLayout.WEST);
        pnTop.add(pnHead, BorderLayout.CENTER);
        
        Dimension buttonDimension = pnLeft.getPreferredSize();
        buttonDimension.height = 35;
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = createButton(title[i], nameImage[i], buttonDimension);
            pnLeft.add(buttons[i]);
        }
        setupMenuActions();
        
    }
    
    private JButton createButton(String name, String img, Dimension size) {
        JButton btn = new JButton(name);
        btn.setBorderPainted(false);
        btn.setFocusPainted(false);
        ImageIcon icon = ImageUtils.createResizedIcon(MenuFrameAd.class, "..//image//" + img, 20, 20);
        btn.setIcon(icon);
        btn.setFont(font);
        btn.setMaximumSize(size);
        btn.setBackground(colorPink);
        btn.setForeground(Color.WHITE);
        btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                btn.setBackground(colorPinkH);
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                if (!btn.isSelected()) {
                    btn.setBackground(colorPink);
                }
            }
            
            @Override
            public void mouseClicked(MouseEvent e) {
                // Thiết lập lại màu nền của tất cả các JButton
                for (JButton button : buttons) {
                    button.setSelected(false);
                    button.setBackground(colorPink);
                }
                // Thiết lập màu nền của JButton được chọn
                btn.setSelected(true);
                btn.setBackground(colorPinkH);
            }
        });
        if (name.equals("Quản lý")) {
            btn.setBackground(colorPinkH);
            btn.setSelected(true);
        } else {
            btn.setBackground(colorPink);
        }
        return btn;
    }
    
    public void setupMenuActions() {
        Menu_AD_Listener menuActionListener = new Menu_AD_Listener(this);
        for (JButton button : buttons) {
            button.addActionListener(menuActionListener);
        }
    }
    
    private void card() {
        cards = new JPanel();
        pnCenter.add(cards, BorderLayout.CENTER);
        cardLayout = new CardLayout();
        cards.setLayout(cardLayout);
        
        JPanel pn_ctAd = new PnThongTinAdTr();
        cards.add(pn_ctAd, "pnCTAD");
        
        JPanel pn_themAD = new PnThemAd();
        cards.add(pn_themAD, "pnThemAD");
        
        JPanel pn_themTBM = new PnThemTBM();
        cards.add(pn_themTBM, "pnThemTBM");
        
        JPanel pn_themGV = new PnThemGV();
        cards.add(pn_themGV, "pnThemGV");
        
        JPanel pn_sv = new PnThemSV();
        cards.add(pn_sv, "pnThemSV");
        
    }
    
    public static void main(String[] args) {
        new MenuFrameAd();
    }
    
}
