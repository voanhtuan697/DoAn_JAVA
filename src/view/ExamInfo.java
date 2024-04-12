
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import static model.base.dark_green;
import static model.base.font13b;
import static model.base.font14;
import static model.base.white;

public class ExamInfo extends JPanel {

    private JPanel combinedPanel, tablePanel;
    private JLabel lbMade, lbTende, lbMaGv, lbNgaythi, lbThoigian, lbSocauhoi, lbMatkhau;
    private JTextField tfMade, tfTende, tfMaGv, tfNgaythi, tfThoigian, tfSocauhoi, tfMatkhau;
    private JButton btnThem, btnXoa, btnSua;
    private static final String[] COLUMN_NAMES = {"Mã đề thi", "Tên đề thi", "Mã giảng viên", "Ngày thi", "Thời gian", "Số câu hỏi", "Mật khẩu"};

    public ExamInfo() {
        initComponents();
        setPreferredSize(new Dimension(800, 700));
        setBackground(new Color(0xB3, 0xBE, 0xCB));
        setLayout(new BorderLayout(20, 20));
        add(tablePanel, BorderLayout.CENTER);
        add(combinedPanel, BorderLayout.SOUTH);
    }

    public void initComponents() {

        combinedPanel = new JPanel();
        combinedPanel.setBackground(new Color(0xB3, 0xBE, 0xCB));
        combinedPanel.setPreferredSize(new Dimension(800, 350));
        combinedPanel.setLayout(new BorderLayout(10, 20)); 

        JPanel labelPanel = new JPanel();
        labelPanel.setBackground(new Color(0xB3, 0xBE, 0xCB));
        labelPanel.setPreferredSize(new Dimension(150, 350));
        labelPanel.setLayout(new GridLayout(8, 1, 0, 20));

        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(new Color(0xB3, 0xBE, 0xCB));
        contentPanel.setPreferredSize(new Dimension(500, 350));
        contentPanel.setLayout(new GridLayout(8, 1, 0, 20));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(0xB3, 0xBE, 0xCB));
        buttonPanel.setPreferredSize(new Dimension(150, 350));
        buttonPanel.setLayout(new FlowLayout(0, 20, 20));

        lbMade = new JLabel();
        lbMade.setText("Mã đề thi:");

        lbTende = new JLabel();
        lbTende.setText("Tên đề thi:");

        lbMaGv = new JLabel();
        lbMaGv.setText("Mã giáo viên:");

        lbNgaythi = new JLabel();
        lbNgaythi.setText("Ngày thi:");

        lbThoigian = new JLabel();
        lbThoigian.setText("Thời gian (phút):");

        lbSocauhoi = new JLabel();
        lbSocauhoi.setText("Số câu hỏi:");

        lbMatkhau = new JLabel();
        lbMatkhau.setText("Mật khẩu:");

        tfMade = new JTextField();
        tfMade.setBackground(new Color(255, 255, 255));

        tfTende = new JTextField();
        tfTende.setBackground(new Color(255, 255, 255));

        tfMaGv = new JTextField();
        tfMaGv.setBackground(new Color(255, 255, 255));

        tfNgaythi = new JTextField();
        tfNgaythi.setBackground(new Color(255, 255, 255));

        tfThoigian = new JTextField();
        tfThoigian.setBackground(new Color(255, 255, 255));

        tfSocauhoi = new JTextField();
        tfSocauhoi.setBackground(new Color(255, 255, 255));

        tfMatkhau = new JTextField();
        tfMatkhau.setBackground(new Color(255, 255, 255));
        
        
        btnThem = new JButton("Thêm");
        btnThem.setBackground(dark_green);
        btnThem.setSize(100, 20);
        btnThem.setForeground(white);
        btnThem.setBorderPainted(false);
        btnThem.setFocusPainted(false);

        btnSua = new JButton(" Sửa  ");
        btnSua.setForeground(white);
        btnSua.setBackground(dark_green);
        btnSua.setSize(100, 20);
        btnSua.setFocusPainted(false);
        btnSua.setBorderPainted(false);

        btnXoa = new JButton(" Xóa  ");
        btnXoa.setForeground(white);
        btnXoa.setBackground(dark_green);
        btnXoa.setSize(100, 20);
        btnXoa.setFocusPainted(false);
        btnXoa.setBorderPainted(false);

        lbMade.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPanel.add(lbMade);
        contentPanel.add(tfMade);
        lbTende.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPanel.add(lbTende);
        contentPanel.add(tfTende);
        lbMaGv.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPanel.add(lbMaGv);
        contentPanel.add(tfMaGv);
        lbNgaythi.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPanel.add(lbNgaythi);
        contentPanel.add(tfNgaythi);
        lbThoigian.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPanel.add(lbThoigian);
        contentPanel.add(tfThoigian);
        lbSocauhoi.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPanel.add(lbSocauhoi);
        contentPanel.add(tfSocauhoi);
        lbMatkhau.setHorizontalAlignment(SwingConstants.RIGHT);
        labelPanel.add(lbMatkhau);
        contentPanel.add(tfMatkhau);

        buttonPanel.add(btnThem);
        buttonPanel.add(btnSua);
        buttonPanel.add(btnXoa);

        combinedPanel.add(labelPanel, BorderLayout.WEST);
        combinedPanel.add(contentPanel, BorderLayout.CENTER);
        combinedPanel.add(buttonPanel, BorderLayout.EAST);



        lbMade.setFont(font13b);
        lbTende.setFont(font13b);
        lbMaGv.setFont(font13b);
        lbNgaythi.setFont(font13b);
        lbThoigian.setFont(font13b);
        lbSocauhoi.setFont(font13b);
        lbMatkhau.setFont(font13b);

        tfMade.setFont(font13b);
        tfTende.setFont(font13b);
        tfMaGv.setFont(font13b);
        tfNgaythi.setFont(font13b);
        tfThoigian.setFont(font13b);
        tfSocauhoi.setFont(font13b);
        tfMatkhau.setFont(font13b);

        btnThem.setFont(font13b);
        btnSua.setFont(font13b);
        btnXoa.setFont(font13b);

        Object[][] data = {
            {"DE001", "Đề thi học kỳ 1", "GV001", "2024-05-15", 120, 50, "abc123"},
            {"DE002", "Đề thi giữa kỳ", "GV002", "2024-06-10", 90, 40, "def456"},
            {"DE002", "Đề thi giữa kỳ", "GV002", "2024-06-10", 90, 40, "def456"},
            {"DE002", "Đề thi giữa kỳ", "GV002", "2024-06-10", 90, 40, "def456"},
            {"DE002", "Đề thi giữa kỳ", "GV002", "2024-06-10", 90, 40, "def456"},
            {"DE002", "Đề thi giữa kỳ", "GV002", "2024-06-10", 90, 40, "def456"},
            {"DE002", "Đề thi giữa kỳ", "GV002", "2024-06-10", 90, 40, "def456"},
            {"DE002", "Đề thi giữa kỳ", "GV002", "2024-06-10", 90, 40, "def456"},
            {"DE002", "Đề thi giữa kỳ", "GV002", "2024-06-10", 90, 40, "def456"},
            {"DE002", "Đề thi giữa kỳ", "GV002", "2024-06-10", 90, 40, "def456"},
        }; 

        tablePanel = new JPanel();
        tablePanel.setBackground(new Color(0xB3, 0xBE, 0xCB));
        tablePanel.setLayout(new BorderLayout(0, 10));

        DefaultTableModel model = new DefaultTableModel(data, COLUMN_NAMES);
        JTable table = new JTable(model);
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);

        JPanel searchPn = new JPanel();
        searchPn.setBackground(new Color(0xB3, 0xBE, 0xCB)); 
        searchPn.setPreferredSize(new Dimension(800, 30)); 
        searchPn.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 10));
        
        JLabel search = new JLabel();
        search.setText("Tìm kiếm: ");
        search.setFont(font14);
        JTextField tfsearch = new JTextField();
        tfsearch.setBackground(Color.WHITE);
        tfsearch.setPreferredSize(new Dimension(150, 20));

        searchPn.add(search);
        searchPn.add(tfsearch);

        tablePanel.add(searchPn, BorderLayout.NORTH);  // Add search panel to the top
        tablePanel.add(scrollPane, BorderLayout.CENTER); 
    }
}
