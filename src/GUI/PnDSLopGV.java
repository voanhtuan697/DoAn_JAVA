/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author E7250
 */
public class PnDSLopGV extends JPanel implements ActionListener {

    private DefaultTableModel model;
    private JComboBox<String> cbb_trangThai;
    private String maGV;
    private Object[] columns = {"Mã lớp", "Tên lớp", "Tên môn", "Năm học", "Học kỳ"};

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
    }

    public JComboBox<String> getCbb_trangThai() {
        return cbb_trangThai;
    }

    public void setCbb_trangThai(JComboBox<String> cbb_trangThai) {
        this.cbb_trangThai = cbb_trangThai;
    }

    public Object[] getColumns() {
        return columns;
    }

    public void setColumns(Object[] columns) {
        this.columns = columns;
    }

    public PnDSLopGV(String maGV) {
        this.maGV = maGV;
        init();
    }

    public void init() {
        this.setLayout(new BorderLayout());

        JPanel pnHeader = new JPanel();
        pnHeader.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pnHeader.setPreferredSize(new Dimension(0, 40));
        pnHeader.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        JLabel lb_trangThaiLop = new JLabel("Trạng thái:");
        String[] cacTrangThai = new String[]{"Đang dạy", "Đã dạy"};
        cbb_trangThai = new JComboBox<>(cacTrangThai);
//        ChangeTableLopGV listener = new ChangeTableLopGV(this);
        cbb_trangThai.addActionListener(this);

        JLabel lb_timKiem = new JLabel("Tìm kiếm:");
        JTextField txt_timKiem = new JTextField(15);

        pnHeader.add(lb_trangThaiLop);
        pnHeader.add(cbb_trangThai);
        pnHeader.add(lb_timKiem);
        pnHeader.add(txt_timKiem);

        JPanel pnTable = new JPanel();
        pnTable.setLayout(new BorderLayout());

        Object[][] data = {
            {"L1", "CNTT", "Toán", "2024", "1"},};

        model = new DefaultTableModel(data, columns);

        JTable table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        JScrollPane scrollPane_table = new JScrollPane(table);
        pnTable.add(scrollPane_table, BorderLayout.CENTER);

        this.add(pnHeader, BorderLayout.NORTH);
        this.add(pnTable, BorderLayout.CENTER);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String selectedOption = (String) getCbb_trangThai().getSelectedItem();
        if (selectedOption.equals("Đang dạy")) {
            // Dữ liệu mới khi lựa chọn là Option 1
            Object[][] newData = {
                {"L1", "CNTT", "Toán", "2024", "1"},};
            getModel().setDataVector(newData, getColumns());
        } else if (selectedOption.equals("Đã dạy")) {
            // Dữ liệu mới khi lựa chọn là Option 2
            Object[][] newData = {
                {"L2", "CNTT1", "Toán1", "20241", "111"},};
            getModel().setDataVector(newData, getColumns());
        }
    }
    public void loadDSLopGV() throws SQLServerException{
        
    }
    
    
    
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(800, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.getContentPane().add(new PnDSLopGV("ddd"));
        f.setVisible(true);
    }
}
