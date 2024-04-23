/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author TK
 */
import java.awt.BorderLayout;
import java.awt.Color;
import static java.awt.Color.white;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import static javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION;
import static javax.swing.border.TitledBorder.DEFAULT_POSITION;


public final class PnThongTinSV extends JFrame {
    JPanel  pnQLHT, pnLichthi, pnBaidathi;
    PnThongTinSV(){
        init();
        this.setLayout(new BorderLayout());
        this.add(pnQLHT);
        this.setSize(950,450);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void init(){
        
        Object[] items ={"Bài sắp thi" , "Bài sẽ thi"};
        JComboBox cb1 =  new JComboBox(items);
        cb1.setPreferredSize(new Dimension(425,20));
        Object data[][] = {
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
            {"HK2", "JAVA", "90p", "25/05/2024","123456"},
        };
        String column[] = {"Kì thi", "Môn thi", "Thời gian", "Ngày thi","Mật khẩu"};
        JTable jtLichthi = new JTable(data, column);
        jtLichthi.setPreferredSize(new Dimension(425,200));
        JScrollPane jspLichthi = new JScrollPane(jtLichthi);
        jspLichthi.setPreferredSize(new Dimension(425,200));
        
        pnLichthi = new JPanel();
        pnLichthi.setBorder(BorderFactory.createTitledBorder(null, "Đề Thi", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font("Segoe UI 12", Font.BOLD, 15)));
        pnLichthi.setPreferredSize(new Dimension(455,200));
        pnLichthi.setBackground(new Color(0xD8A3AB));
        pnLichthi.setLayout(new BorderLayout());
        pnLichthi.add(jspLichthi, BorderLayout.CENTER);
        pnLichthi.add(cb1, BorderLayout.NORTH);
        
        Object data2[][] = {{"JAVA" , "8,5", "34"}};
        String column2[] = {"Môn thi", "Điểm", "Số câu đúng"};
        JTable jtBaidathi = new JTable(data2, column2);
        jtBaidathi.setPreferredSize(new Dimension(425,100));
        JScrollPane jspBaidathi = new JScrollPane(jtBaidathi);
        jspBaidathi.setPreferredSize(new Dimension(425,100));
        
        pnBaidathi = new JPanel();
        pnBaidathi.setBorder(BorderFactory.createTitledBorder(null, "Kết quả", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font("Segoe UI 12", Font.BOLD, 15)));
        pnBaidathi.setPreferredSize(new Dimension(455,200));
        pnBaidathi.setBackground(white);
        pnBaidathi.setLayout(new BorderLayout());
        pnBaidathi.add(jspBaidathi, BorderLayout.CENTER);
       
        pnQLHT = new JPanel();
        pnQLHT.setPreferredSize(new Dimension(535,295));
        pnQLHT.setBackground(white);
        pnQLHT.add(pnLichthi);
        pnQLHT.add(pnBaidathi);
        pnQLHT.setLayout(new GridLayout(1,2));      
    }
    public static void main(String[] args){
          PnThongTinSV p1 = new PnThongTinSV();
    }
}
