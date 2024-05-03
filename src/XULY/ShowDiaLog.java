/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XULY;

import static GUI.BASE.createResizedIcon;
import static GUI.BASE.font14;
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class ShowDiaLog extends JDialog {

    private String text = "Đăng ký thành công";
    private int type;
    JPanel pnTop, pnCenter, pnBottom, pnMain;
    JLabel lblIcon, lblContent, lblClose;
    JButton btnOK, btnCancel;
    final ImageIcon iconError = createResizedIcon(ShowDiaLog.class, "..//image//error_icon.png", 20, 20);
    final ImageIcon iconSuccess = createResizedIcon(ShowDiaLog.class, "..//image//success_icon.png", 20, 20);
    final ImageIcon iconInfo = createResizedIcon(ShowDiaLog.class, "..//image//information_icon.png", 20, 20);

    public final static int ERROR_DIALONG = 1;
    public final static int SUCCESS_DIALOG = 2;
    public final static int INFO_DIALOG = 3;

    public ShowDiaLog(String text, int type) {
        this.text = text;
        this.type = type;
        addComponents();
        showWindow();
    }

    public void addComponents() {
        Container container = getContentPane();
        pnMain = new JPanel(new BorderLayout());

        pnTop = new JPanel(new BorderLayout());
        pnTop.setPreferredSize(new Dimension(0, 25));
        pnTop.setBorder(BorderFactory.createEmptyBorder(5, 5, 2, 5));
        JLabel lblThongBao = new JLabel("Thông báo");
        lblThongBao.setForeground(white);
        lblThongBao.setFont(font14);
        lblClose = new JLabel(createResizedIcon(ShowDiaLog.class, "..//image//close_icon.png", 20, 20));
        lblClose.setCursor(Cursor.getDefaultCursor());
        lblClose.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pnTop.add(lblThongBao, BorderLayout.CENTER);
        pnTop.add(lblClose, BorderLayout.EAST);

        pnCenter = new JPanel(new BorderLayout());
        pnCenter.setBorder(BorderFactory.createEmptyBorder(35, 5, 0, 0));
        pnCenter.setBackground(white);
        lblContent = new JLabel(text, JLabel.CENTER);
        lblContent.setFont(font14);
        lblIcon = new JLabel();
        JPanel pn_content = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pn_content.add(lblIcon);
        pn_content.add(lblContent);
        pn_content.setBackground(white);
        pnCenter.add(pn_content, BorderLayout.CENTER);

        pnBottom = new JPanel(new FlowLayout(FlowLayout.CENTER));
        pnBottom.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 0));
        pnBottom.setPreferredSize(new Dimension(0, 40));
        pnBottom.setBackground(white);
        btnOK = new JButton("Chấp nhận");
        btnOK.setPreferredSize(new Dimension(100, 25));
        btnOK.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnOK.setBackground(Color.decode("#A6D8F0"));
        btnOK.setForeground(white);
        btnOK.setBorderPainted(false);
        btnOK.setFocusPainted(false);
        btnCancel = new JButton("Cancel");
        btnCancel.setBackground(Color.decode("#FF623D"));
        btnCancel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnCancel.setBorderPainted(false);
        btnCancel.setFocusPainted(false);

        Color bgHeader = new Color(0);
        switch (type) {
            case ERROR_DIALONG:
                bgHeader = new Color(220, 20, 60);
                lblIcon.setIcon(iconError);
                break;
            case SUCCESS_DIALOG:
                bgHeader = new Color(50, 205, 50);
                lblIcon.setIcon(iconSuccess);
                break;
            case INFO_DIALOG:
                bgHeader = new Color(135, 206, 250);
                lblIcon.setIcon(iconInfo);
                break;
        }

        pnTop.setBackground(bgHeader);

        pnBottom.add(btnOK);
        pnMain.add(pnTop, BorderLayout.NORTH);
        pnMain.add(pnCenter, BorderLayout.CENTER);
        pnMain.add(pnBottom, BorderLayout.SOUTH);

        container.add(pnMain);

        lblClose.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }

        });
        btnOK.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
            }

        });

    }

    public void showWindow() {
        this.setUndecorated(true);
        this.setSize(350, 150);
        this.setLocationRelativeTo(null);
        this.setAlwaysOnTop(true);
        this.setModal(true);
        this.setBackground(Color.WHITE);
        this.setVisible(true);
        getRootPane().setDefaultButton(btnOK);
    }
    
    public static void main(String[] args) {
        new ShowDiaLog("thanh cong", ShowDiaLog.ERROR_DIALONG);
    }
}
