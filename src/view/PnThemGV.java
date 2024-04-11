/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import net.sourceforge.jdatepicker.JDatePanel;
import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import model.DisabledTableCellRenderer;

/**
 *
 * @author E7250
 */
public class PnThemGV extends JPanel {

    private JPanel pnSearch;
    private DefaultTableModel model;
    private JTextField txtSearch, txtHoTen;
    private JButton btnThem, btnSua, btnXoa, btnClear, btnNhap, btnXuat;

    private JLabel[] lbl = new JLabel[5];
    private String[] lblContent = {"Mã quản lý:", "Họ và tên:", "Môn học", "Ngày sinh:"};
    private Color colorGray = Color.decode("#B3BECB");
    private Color colorBtn = Color.decode("#009594");
    private Color colorPink = Color.decode("#DA91A4");
    Font font = new Font("Segoe UI", Font.PLAIN, 13);

    public PnThemGV() {
        init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        
        pnSearch = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        pnSearch.setBackground(colorGray);
        
        JLabel lblSearch = new JLabel("Tìm kiếm");
        lblSearch.setFont(font);
        txtSearch = new JTextField(15);
        pnSearch.add(lblSearch);
        pnSearch.add(txtSearch);
        
        JPanel pn_content = new JPanel();
        pn_content.setLayout(new BorderLayout());

        JPanel pn_table = new JPanel();
        pn_table.setLayout(new BorderLayout());

        JPanel pn_input = new JPanel();
        pn_input.setBackground(colorGray);
        pn_input.setPreferredSize(new Dimension(205, 0));
        pn_input.setLayout(new FlowLayout(FlowLayout.LEFT,2,3));
        
        JLabel lb_name = new JLabel("Ho ten:");
        txtHoTen = new JTextField(18);
        JLabel lb_ngaySinh = new JLabel("Ngay sinh:");
        
        btnThem = new JButton("Thêm");
        btnThem.setBackground(colorBtn);
        btnXoa = new JButton("Xóa");
        btnXoa.setBackground(colorBtn);
        btnNhap = new JButton("Nhập Excel");
        btnNhap.setBackground(colorBtn);
        btnXuat = new JButton("Xuất Excel");
        btnXuat.setBackground(colorBtn);
        btnSua = new JButton("Sửa");
        btnSua.setBackground(colorBtn);
        btnClear = new JButton("Clear");
        btnClear.setBackground(colorBtn);
        
        UtilDateModel model1 = new UtilDateModel();
        JDatePanel datePanel = new JDatePanelImpl(model1);
        JDatePicker datePicker = new JDatePickerImpl((JDatePanelImpl) datePanel);
        
        pn_input.add(lb_name);
        pn_input.add(txtHoTen);
        pn_input.add(lb_ngaySinh);
        pn_input.add((Component)datePicker);
        
        JPanel pn_btn = new JPanel(new GridLayout(3, 2, 7, 10));
        pn_btn.add(btnThem);
        pn_btn.add(btnXoa);
        pn_btn.add(btnNhap);
        pn_btn.add(btnXuat);
        pn_btn.add(btnSua);
        pn_btn.add(btnClear);
        pn_input.add(pn_btn);
        
        
        pn_content.add(pn_table,BorderLayout.CENTER);
        pn_content.add(pn_input,BorderLayout.EAST);
        
        

        Object[] columns = {"Mã giảng viên", "Họ và tên", "Ngày sinh"};
        Object[][] data = {{null, null, null},
        {null, null, null},
        {null, null, null},
        };
        model = new DefaultTableModel(data, columns);
        
        JTable table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };;
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new DisabledTableCellRenderer());
        }

        JScrollPane scrTabel = new JScrollPane(table);
        pn_table.add(scrTabel, BorderLayout.CENTER);

        txtHoTen = new JTextField(25);


        
        
        
        

        datePicker.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Date selectedDate = (Date) datePicker.getModel().getValue();
                    LocalDate localDate = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                    if (selectedDate != null) {
                        // Sử dụng giá trị ngày tháng đã chọn ở đây
                        System.out.println("Ngay da chon: " + selectedDate);
                        int ngay = localDate.getDayOfMonth();
                        int thang = localDate.getMonthValue();
                        int nam = localDate.getYear();

                        System.out.println("Ngay: " + ngay);
                        System.out.println("Thang: " + thang);
                        System.out.println("Nam: " + nam);
                    }
                } catch (Exception ex) {
                    System.out.println("Khong co ngay nao duoc chon.");
                }
            }

        });
        
        

        this.add(pnSearch, BorderLayout.NORTH);
        this.add(pn_content, BorderLayout.CENTER);

    }



    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(800, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PnThemGV p = new PnThemGV();
        f.getContentPane().setLayout(new BorderLayout());
        f.add(p);
        f.setVisible(true);
    }
}