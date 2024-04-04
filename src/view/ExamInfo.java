package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class ExamInfo extends JFrame {

    private JPanel combinedPanel, titlePanel, tablePanel;
    private JLabel lbMade, lbTende, lbMaGv, lbNgaythi, lbThoigian, lbSocauhoi, lbMatkhau;
    private JTextField tfMade, tfTende, tfMaGv, tfNgaythi, tfThoigian, tfSocauhoi, tfMatkhau;
    private JButton btnThem, btnXoa, btnSua;
    private static final String[] COLUMN_NAMES = {"Mã đề thi", "Tên đề thi", "Mã giảng viên", "Ngày thi", "Thời gian", "Số câu hỏi", "Mật khẩu"};

    public ExamInfo() {
        initComponents();
        setSize(800, 700);
        getContentPane().setBackground(new Color(0xB3, 0xBE, 0xCB));
        setLayout(new BorderLayout(20, 20));
        add(titlePanel, BorderLayout.NORTH);
        add(tablePanel, BorderLayout.CENTER);
        add(combinedPanel, BorderLayout.SOUTH);
    }

    public void initComponents() {
        titlePanel = new JPanel();
        titlePanel.setBackground(new Color(0xD8, 0xA3, 0xAB));
        titlePanel.setPreferredSize(new Dimension(800, 30));
        JLabel titleLabel = new JLabel("TẠO ĐỀ THI");
        titleLabel.setForeground(Color.WHITE);
        titlePanel.add(titleLabel);

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
        btnThem.setBackground(new Color(0x00, 0x95, 0x94));
        btnThem.setSize(100, 20);


        btnSua = new JButton(" Sửa  ");
        btnSua.setBackground(new Color(0x00, 0x95, 0x94));
        btnSua.setSize(100, 20);

        btnXoa = new JButton(" Xóa  ");
        btnXoa.setBackground(new Color(0x00, 0x95, 0x94));
        btnXoa.setSize(100, 20);

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

        Font font = new Font("Segoe UI", Font.PLAIN, 15);
        Font font1 = new Font("Segoe UI", Font.BOLD, 15);
        
        titleLabel.setFont(font1);

        lbMade.setFont(font);
        lbTende.setFont(font);
        lbMaGv.setFont(font);
        lbNgaythi.setFont(font);
        lbThoigian.setFont(font);
        lbSocauhoi.setFont(font);
        lbMatkhau.setFont(font);

        tfMade.setFont(font);
        tfTende.setFont(font);
        tfMaGv.setFont(font);
        tfNgaythi.setFont(font);
        tfThoigian.setFont(font);
        tfSocauhoi.setFont(font);
        tfMatkhau.setFont(font);

        btnThem.setFont(font);
        btnSua.setFont(font);
        btnXoa.setFont(font);

        Object[][] data = {
            {"DE001", "Đề thi học kỳ 1", "GV001", "2024-05-15", 120, 50, "abc123"},
            {"DE002", "Đề thi giữa kỳ", "GV002", "2024-06-10", 90, 40, "def456"},
        }; 

        tablePanel = new JPanel();
    tablePanel.setBackground(new Color(0xB3, 0xBE, 0xCB));

    DefaultTableModel model = new DefaultTableModel(data, COLUMN_NAMES);
    JTable table = new JTable(model);
    table.getTableHeader().setReorderingAllowed(false);
    table.setPreferredSize(new Dimension(800, 400));  // Keep the desired table size
    table.setMinimumSize(new Dimension(800, 400));  // Ensure minimum size

    JPanel searchPn = new JPanel();
    searchPn.setBackground(new Color(0xB3, 0xBE, 0xCB));  // Adjust background color if needed
    searchPn.setPreferredSize(new Dimension(800, 30));  // Set preferred size for search panel
    searchPn.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 0));
    
    JLabel search = new JLabel();
    search.setText("Tìm kiếm: ");
    search.setFont(font);
    JTextField tfsearch = new JTextField();
    tfsearch.setBackground(Color.WHITE);
    tfsearch.setPreferredSize(new Dimension(150, 20));

    searchPn.add(search);
    searchPn.add(tfsearch);

    tablePanel.add(searchPn, BorderLayout.NORTH);  // Add search panel to the top
    tablePanel.add(new JScrollPane(table), BorderLayout.CENTER); 
    }

    public static void main(String[] args) {
        ExamInfo a = new ExamInfo();
        a.setVisible(true);
    }
}

