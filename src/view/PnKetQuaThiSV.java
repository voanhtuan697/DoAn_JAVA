/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import static javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION;
import static javax.swing.border.TitledBorder.DEFAULT_POSITION;
import javax.swing.table.DefaultTableModel;
import static model.base.font14;
import static model.base.gray_bg;

public class PnKetQuaThiSV extends JPanel {

    private DefaultTableModel modelDT, modelKQ;
    private JPanel pnDT, pnKQ;

    public PnKetQuaThiSV() {
        init();
        initComponents();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setBackground(gray_bg);

        pnDT = new JPanel(new BorderLayout());
        pnDT.setBorder(BorderFactory.createTitledBorder(null, "Thông tin thi", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font14) {
        }));
        pnDT.setPreferredSize(new Dimension(0, 150));
        pnDT.setBackground(gray_bg);

        pnKQ = new JPanel(new BorderLayout());
        pnKQ.setBorder(BorderFactory.createTitledBorder(null, "Kết quả", DEFAULT_JUSTIFICATION, DEFAULT_POSITION, new Font(font14) {
        }));
        pnKQ.setPreferredSize(new Dimension(0, 250));
        pnKQ.setBackground(gray_bg);

        this.add(pnDT, BorderLayout.NORTH);
        this.add(pnKQ, BorderLayout.SOUTH);
    }

    private void initComponents() {
        Object dataDT[][] = {
            {"JAVA", "90p", "25/05/2024", "123456", "Đã thi"},
            {"JAVA", "90p", "25/05/2024", "123456", "Đã thi"},
            {"JAVA", "90p", "25/05/2024", "123456", "Đã thi"},
            {"JAVA", "90p", "25/05/2024", "123456", "Đã thi"},
            {"JAVA", "90p", "25/05/2024", "123456", "Đã thi"},
            {"JAVA", "90p", "25/05/2024", "123456", "Đã thi"},
            {"JAVA", "90p", "25/05/2024", "123456", "Đã thi"},
            {"JAVA", "90p", "25/05/2024", "123456", "Đã thi"},
            {"JAVA", "90p", "25/05/2024", "123456", "Đã thi"},
            {"JAVA", "90p", "25/05/2024", "123456", "Đã thi"},
            {"JAVA", "90p", "25/05/2024", "123456", "Đã thi"},
            {"JAVA", "90p", "25/05/2024", "123456", "Đã thi"}
        };
        String columnDT[] = {"Môn thi", "Thời gian", "Ngày thi", "Mật khẩu", "Trạng thái"};
        modelDT = new DefaultTableModel(dataDT, columnDT);
        JTable jtDeThi = new JTable(modelDT);
        JScrollPane jspDeThi = new JScrollPane(jtDeThi);
        pnDT.add(jspDeThi, BorderLayout.CENTER);

        Object data2[][] = {{"JAVA", "8,5", "34"}};
        String column2[] = {"Môn thi", "Điểm", "Số câu đúng"};
        modelKQ = new DefaultTableModel(data2, column2);
        JTable jtKetQua = new JTable(modelKQ);
        JScrollPane jspKetQua = new JScrollPane(jtKetQua);
        pnKQ.add(jspKetQua, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(950, 450);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PnKetQuaThiSV p = new PnKetQuaThiSV();
        f.getContentPane().setLayout(new BorderLayout());
        f.add(p);
        f.setVisible(true);
    }
}
