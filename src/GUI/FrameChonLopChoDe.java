/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author E7250
 */
public class FrameChonLopChoDe extends JFrame {

    private DefaultTableModel model;
    private JTextField txt_mon;
    private JTextField txt_nam;
    private JComboBox<String> cbb_hocKy;
    private JTextField txt_maLop;

    public FrameChonLopChoDe() {
        init();
    }

    public void init() {
        this.setSize(800, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        JPanel pn_header = new JPanel(new BorderLayout(10, 10));

        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lb_maLop = new JLabel("Mã lớp:");
        txt_maLop = new JTextField(10);
        JLabel lb_mon = new JLabel("Tên môn:");
        txt_mon = new JTextField(10);
        leftPanel.add(lb_maLop);
        leftPanel.add(txt_maLop);
        leftPanel.add(lb_mon);
        leftPanel.add(txt_mon);

        JButton btn_finish = new JButton("Hoàn thành");

        pn_header.add(leftPanel, BorderLayout.CENTER);
        pn_header.add(btn_finish, BorderLayout.EAST);

        JPanel pn_table = new JPanel(new BorderLayout());

        Object[][] data = {
            {"L1", "1", "Cấu trúc dữ liệu", "Lý Mạc Sầu", "2024", "1", false},
            {"L1", "1", "Cấu trúc dữ liệu", "Lý Mạc Sầu", "2024", "1", false},
            {"L1", "1", "Cấu trúc dữ liệu", "Lý Mạc Sầu", "2024", "1", false},
            {"L1", "1", "Cấu trúc dữ liệu", "Lý Mạc Sầu", "2024", "1", false},
            {"L1", "1", "Cấu trúc dữ liệu", "Lý Mạc Sầu", "2024", "1", false},
            {"L1", "1", "Cấu trúc dữ liệu", "Lý Mạc Sầu", "2024", "1", true},};
        Object[] columns = {"Mã lớp", "Nhóm lớp", "Môn", "Giảng viên", "Năm", "Học kỳ", ""};

        model = new DefaultTableModel(data, columns);

        JTable table = new JTable(new DefaultTableModel(data, columns) {
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 6) {
                    return Boolean.class; // Set kiểu dữ liệu của cột checkbox là Boolean
                }
                return super.getColumnClass(columnIndex);
            }

            @Override
            public boolean isCellEditable(int row, int column) {
                return column == getColumnCount() - 1;
            }
        });
        table.getColumnModel().getColumn(6).setMaxWidth(20);
        table.getColumnModel().getColumn(6).setCellRenderer(new DefaultTableCellRenderer() {
            private final JCheckBox checkBox = new JCheckBox();

            @Override
            public java.awt.Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus,
                    int row, int column) {
                if (value instanceof Boolean) {
                    checkBox.setSelected((Boolean) value);
                }
                // Thiết lập kích thước của checkbox
                return checkBox;
            }

        });

        JScrollPane scrollPane_table = new JScrollPane(table);
        pn_table.add(scrollPane_table, BorderLayout.CENTER);

        this.add(pn_header, BorderLayout.NORTH);
        this.add(pn_table, BorderLayout.CENTER);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new FrameChonLopChoDe();

    }
}
