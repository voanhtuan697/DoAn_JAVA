/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static GUI.BASE.font14;
import static GUI.BASE.gray_bg;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PnDeThiSinhVien extends JPanel implements ActionListener{

    private DefaultTableModel modelSapThi,modelDangThi,modelDaThi;
    private JComboBox<String> cbb_trangThai;
    private String maSV;
    private JPanel cards;
    private CardLayout cardLayout;
    private JPanel pn_KetQua;
    private JTable tableSapThi;
    private JTable tableDangThi;
    private JTable tableDaThi;
    
    
    public PnDeThiSinhVien() {
        init();
        cbb_trangThai.setSelectedIndex(0);
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

    public JComboBox<String> getCbb_trangThai() {
        return cbb_trangThai;
    }

    public void setCbb_trangThai(JComboBox<String> cbb_trangThai) {
        this.cbb_trangThai = cbb_trangThai;
    }

    public JPanel getPn_KetQua() {
        return pn_KetQua;
    }

    public void setPn_KetQua(JPanel pn_KetQua) {
        this.pn_KetQua = pn_KetQua;
    }
    
    
    
    
    public void init(){    
        this.setLayout(new BorderLayout());
        JPanel pnHeader = new JPanel();
        pnHeader.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pnHeader.setPreferredSize(new Dimension(0, 40));
        pnHeader.setLayout(new FlowLayout(FlowLayout.LEFT,20, 10));

        JLabel lb_trangThaiDeThi = new JLabel("Trạng thái:");
        String[] cacTrangThai = new String[]{"Đề sắp thi", "Đề đang thi","Đề đã thi"};
        cbb_trangThai = new JComboBox<>(cacTrangThai);
        cbb_trangThai.addActionListener(this);
        cbb_trangThai.setPreferredSize(new Dimension(100, cbb_trangThai.getPreferredSize().height));
        
        JLabel lb_timKiem = new JLabel("Tìm kiếm:");
        JTextField txt_timKiem = new JTextField(15);
        
        pnHeader.add(lb_trangThaiDeThi);
        pnHeader.add(cbb_trangThai);
        pnHeader.add(lb_timKiem);
        pnHeader.add(txt_timKiem);
        
        JPanel pnTable = new JPanel();
        pnTable.setLayout(new BorderLayout());
        cards = new JPanel();
        pnTable.add(cards, BorderLayout.CENTER);
        cardLayout = new CardLayout();
        cards.setLayout(cardLayout);

        
//--------------------------- Sắp thi--------------------------------------
        Object[][] dataSapThi = {
            {"DT1", "L1", "Toán rời rạc", "1","Sắp thi","2024-1-1","7:30:00","40","30"},
            
            
            };
        Object[] columns = {"Mã Đề", "Mã lớp","Môn","Nhóm lớp","Giảng viên","Ngày thi","Thời gian thi","Số câu","Thời gian làm bài(Phút)"};
        modelSapThi = new DefaultTableModel(dataSapThi, columns);
        
        tableSapThi = new JTable(modelSapThi) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane scrollPane_tableSapThi = new JScrollPane(tableSapThi);
//--------------------------- Đang thi--------------------------------------
        Object[][] dataDangThi = {
            {"DT1", "L1", "Toán rời rạc", "1","Đang thi","2024-1-1","7:30:00","40","30"},
            
            
            };
        modelDangThi = new DefaultTableModel(dataDangThi, columns);
        
        tableDangThi = new JTable(modelDangThi) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tableDangThi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Kiểm tra xem chuột đã được nhấp đúp hay không
                    int row = tableDangThi.getSelectedRow();
                    if (row != -1) { // Kiểm tra xem có hàng nào được chọn không
                        // Lấy dữ liệu từ hàng được chọn và hiển thị trong một frame mới
                        String id = tableDangThi.getValueAt(row, 0).toString();
                        System.out.println(id);
                    }
                }
            }
        });
        
        
        
        JScrollPane scrollPane_tableDangThi = new JScrollPane(tableDangThi);
//--------------------------- Đã thi--------------------------------------
        Object[][] dataDaThi = {
            {"DT1", "L1", "Toán rời rạc", "1","Đã thi","2024-1-1","7:30:00","40","30"},
            
            
            };
        modelDaThi = new DefaultTableModel(dataDaThi, columns);
        
        tableDaThi = new JTable(modelDaThi) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        JScrollPane scrollPane_tableDaThi = new JScrollPane(tableDaThi);
        
        cards.add(scrollPane_tableSapThi, "pn_SapThi");
        cards.add(scrollPane_tableDangThi, "pn_DangThi");
        cards.add(scrollPane_tableDaThi, "pn_DaThi");
        
        pn_KetQua = new JPanel();
        pn_KetQua.setLayout(new FlowLayout(0,10,10));
        
        JLabel lb_ketQua = new JLabel("Kết quả");
        JLabel lb_title_diem = new JLabel("Điểm:");
        JLabel lb_diem = new JLabel("");
        JLabel lb_title_soCauDung = new JLabel("Số câu đúng:");
        JLabel lb_soCauDung = new JLabel("");
        JLabel lb_title_thoiGianLam = new JLabel("Thời gian làm:");
        JLabel lb_thoiGianLam = new JLabel("");
        pn_KetQua.add(lb_ketQua);
        pn_KetQua.add(lb_title_diem);
        pn_KetQua.add(lb_diem);
        pn_KetQua.add(lb_title_soCauDung);
        pn_KetQua.add(lb_soCauDung);
        pn_KetQua.add(lb_title_thoiGianLam);
        pn_KetQua.add(lb_thoiGianLam);

        
        
        this.add(pnHeader,BorderLayout.NORTH);
        this.add(pnTable,BorderLayout.CENTER);
        this.add(pn_KetQua,BorderLayout.SOUTH);
        
        this.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedOption = (String) this.getCbb_trangThai().getSelectedItem();
        if (selectedOption.equals("Đề sắp thi")) {
            this.getCardLayout().show(this.getCards(), "pn_SapThi");
            this.pn_KetQua.setVisible(false);
            tableSapThi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) { // Kiểm tra xem chuột đã được nhấp đúp hay không
                    int row = tableSapThi.getSelectedRow();
                    if (row != -1) { // Kiểm tra xem có hàng nào được chọn không
                        System.out.println("1");
                    }
                }
            }
        });
            
        } else if (selectedOption.equals("Đề đang thi")) {
            this.getCardLayout().show(this.getCards(), "pn_DangThi");
            this.pn_KetQua.setVisible(false);
        }else if (selectedOption.equals("Đề đã thi")) {
            this.getCardLayout().show(this.getCards(), "pn_DaThi");
            this.pn_KetQua.setVisible(true);
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(800, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PnDeThiSinhVien p = new PnDeThiSinhVien();
        f.getContentPane().setLayout(new BorderLayout());
        f.add(p);
        f.setVisible(true);
    }

    
}
