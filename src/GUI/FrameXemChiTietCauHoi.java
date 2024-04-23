/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author E7250
 */
public class FrameXemChiTietCauHoi extends JFrame {

    private String[] bangChuCai;

    public FrameXemChiTietCauHoi() {
        init();
    }

    public void init() {
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(new BorderLayout());
        JPanel pn_header = new JPanel();
        pn_header.setPreferredSize(new Dimension(500, 300));
        JLabel lb_img = new JLabel();
        lb_img.setIcon(BASE.createResizedIcon(FrameXemChiTietCauHoi.class, "..//image//anhTruong.jpg", pn_header.getPreferredSize().width, pn_header.getPreferredSize().height));
        pn_header.add(lb_img, BorderLayout.CENTER);

        Font font = new Font("Arial", Font.PLAIN,18);
        
        bangChuCai = new String[]{"A", "B", "C", "D", "E", "F", "J", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        JPanel pn_content = new JPanel();
        pn_content.setLayout(new BoxLayout(pn_content, BoxLayout.Y_AXIS));
        
        JPanel pn_cauHoi = new JPanel();
        pn_cauHoi.setLayout(new BorderLayout());
//        pn_cauHoi.setMaximumSize(new Dimension(1400, 100));
        
        JTextArea txta = new JTextArea();
        txta.setFont(font);
        txta.setLineWrap(true);
        pn_cauHoi.setMaximumSize(new Dimension(1200, 50));
        
        
        JScrollPane scrollPane = new JScrollPane(txta);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pn_cauHoi.add(scrollPane, BorderLayout.CENTER);
        
        pn_content.add(pn_cauHoi);

        for (int i = 0; i < 4; i++) {
            JPanel panel = new JPanel(new BorderLayout());
            panel.setMaximumSize(new Dimension(1400, 20));
            JLabel label = new JLabel(bangChuCai[i]);
            label.setPreferredSize(new Dimension(15, 0));
            JTextField txt = new JTextField();
            JCheckBox checkBox = new JCheckBox();

            panel.add(label, BorderLayout.WEST);
            panel.add(txt, BorderLayout.CENTER);
            panel.add(checkBox, BorderLayout.EAST);
            pn_content.add(panel);
        }
        
//        JPanel pn_footer = new JPanel();
//        JLabel lb_gv = 
//        pn_footer.add(lb)

        this.getContentPane().add(pn_header,BorderLayout.NORTH);
        this.getContentPane().add(pn_content,BorderLayout.CENTER);

        
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FrameXemChiTietCauHoi();
    }
}

