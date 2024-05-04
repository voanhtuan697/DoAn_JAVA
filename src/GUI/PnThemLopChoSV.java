/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.chiTietLopBUS2;
import BUS.lopBUS2;
import BUS.monBUS2;
import BUS.nguoiDungBUS2;
import BUS.taiKhoanBUS2;
import DTO.lopDTO;
import DTO.monDTO;
import DTO.nguoiDungDTO;
import static GUI.BASE.createResizedIcon;
import static GUI.BASE.dark_green;
import static GUI.BASE.font14;
import static GUI.BASE.font14b;
import static GUI.BASE.font16;
import static GUI.BASE.gray_bg;
import XULY.ShowDiaLog;
import java.awt.BorderLayout;
import static java.awt.Color.white;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class PnThemLopChoSV extends JPanel {
    
    private JPanel pnTop, pnCenter, pnBottom;
    private JTextField tfTimKiem;
    private JComboBox cbNam, cbHocKy, cbMon, cbLop;
    private JTable table;
    private DefaultTableModel model;
    private String maSV;
    private JButton btnThem;
    private lopBUS2 busLop = new lopBUS2();
    private monBUS2 busMon = new monBUS2();
    private nguoiDungBUS2 busNgDung = new nguoiDungBUS2();
    private chiTietLopBUS2 busCTLop = new chiTietLopBUS2();
    private taiKhoanBUS2 busTK = new taiKhoanBUS2();
    private ArrayList<String> choose = new ArrayList<>();
    
    public PnThemLopChoSV() {
        init();
        initComponents();
        LoadData();
    }
    
    public void init() {
        this.setLayout(new BorderLayout());
        pnTop = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        pnTop.setBackground(gray_bg);
        
        pnCenter = new JPanel(new BorderLayout());
        
        pnBottom = new JPanel(new BorderLayout());
        pnBottom.setBackground(gray_bg);
        
        this.add(pnTop, BorderLayout.NORTH);
        this.add(pnCenter, BorderLayout.CENTER);
        this.add(pnBottom, BorderLayout.SOUTH);
    }
    
    public void initComponents() {
        JLabel lblTimKiem, lblNam, lblHocKy, lblTenMon, lblLop;
        lblTimKiem = CreateLabel("Tìm kiếm:");
        lblNam = CreateLabel("Năm:");
        lblHocKy = CreateLabel("Học kỳ:");
        lblTenMon = CreateLabel("Tên môn:");
        lblLop = CreateLabel("Lớp:");
        
        tfTimKiem = new JTextField(15);
        cbHocKy = new JComboBox<>(new Integer[]{1, 2});
        cbHocKy.setPreferredSize(new Dimension(50, cbHocKy.getPreferredSize().height));
        cbLop = new JComboBox();
        cbLop.setPreferredSize(new Dimension(120, cbLop.getPreferredSize().height));
        cbMon = new JComboBox();
        cbMon.setPreferredSize(new Dimension(200, cbMon.getPreferredSize().height));
        cbNam = new JComboBox();
        cbNam.setPreferredSize(new Dimension(90, cbNam.getPreferredSize().height));
        
        Object[] columns = {"Mã sinh viên", "Tên sinh viên", "Ngày sinh"};
        model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(model);
        setTableFont(table);
        JScrollPane scrlTable = new JScrollPane(table);
        
        btnThem = new JButton("Thêm");
        btnThem.setBackground(dark_green);
        btnThem.setFont(font14b);
        btnThem.setForeground(white);
        btnThem.setBorderPainted(false);
        btnThem.setFocusPainted(false);
        btnThem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnThem.setMaximumSize(new Dimension(120, 20));
        
        pnTop.add(lblTimKiem);
        pnTop.add(tfTimKiem);
        pnCenter.add(scrlTable, BorderLayout.CENTER);
        
        JPanel container = new JPanel(new FlowLayout(FlowLayout.CENTER));
        container.setBackground(gray_bg);
        container.add(lblNam);
        container.add(cbNam);
        container.add(lblHocKy);
        container.add(cbHocKy);
        container.add(lblTenMon);
        container.add(cbMon);
        container.add(lblLop);
        container.add(cbLop);
        container.add(btnThem);
        
        pnBottom.add(container, BorderLayout.CENTER);
        
        cbNam.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCbLop();
                loadDSSV();
            }
        });
        
        cbHocKy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCbLop();
                loadDSSV();
            }
        });
        cbMon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCbLop();
                loadDSSV();
            }
        });
        
        cbMon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadDSSV();
            }
        });
        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                choose.clear();
                if (!e.getValueIsAdjusting() && !table.getSelectionModel().isSelectionEmpty()) {
                    int[] selectedRows = table.getSelectedRows();
                    for (int row : selectedRows) {
                        String Ma = table.getValueAt(row, 0) + "";
                        String MaTK = busTK.getMaTkByTenDN(Ma);
//                        System.out.println(MaTK);
                        choose.add(MaTK);
                    }
                }
            }
        });
        
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String MaLop = cbLop.getSelectedItem() + "";
                if (!choose.isEmpty()) {
                    for (String MaSV : choose) {
                        ThemSV(MaLop, MaSV);
                    }
                    loadDSSV();
                    new ShowDiaLog("Thêm danh sách sinh viên thành công", ShowDiaLog.SUCCESS_DIALOG);
                } else {
                    new ShowDiaLog("Vui lòng chọn ít nhất 1 sinh viên", ShowDiaLog.ERROR_DIALONG);
                }
            }
        });
        
        tfTimKiem.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                DSTimKiem();
            }
        });
    }
    
    private JLabel CreateLabel(String txt) {
        JLabel lbl = new JLabel(txt);
        lbl.setFont(font14);
        return lbl;
    }
    
    private void setTableFont(JTable table) {
        table.setFont(font14);
        
        JTableHeader header = table.getTableHeader();
        header.setFont(font14);
        
        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setFont(font14);
        table.setDefaultRenderer(Object.class, renderer);
    }
    
    private void LoadData() {
        cbNam.removeAllItems();
        cbMon.removeAllItems();
        
        ArrayList<lopDTO> listNam = busLop.getListNam();
        for (lopDTO n : listNam) {
            cbNam.addItem(n.getNam());
        }
        
        ArrayList<monDTO> listMon = busMon.getList();
        for (monDTO m : listMon) {
            cbMon.addItem(m.getTenMon());
        }
        
    }
    
    private void showCbLop() {
        int Nam = Integer.parseInt(cbNam.getSelectedItem() + "");
        int HocKy = Integer.parseInt(cbHocKy.getSelectedItem() + "");
        String TenMon = cbMon.getSelectedItem() + "";
        
        cbLop.removeAllItems();
        ArrayList<lopDTO> listMon = busLop.getMaByNamHKMon(Nam, HocKy, TenMon);
        for (lopDTO x : listMon) {
            cbLop.addItem(x.getMaLop());
        }
    }
    
    private void ThemSV(String MaLop, String MaSV) {
        busCTLop.themSV(MaLop, MaSV);
    }
    
    private void loadDSSV() {
        model.setRowCount(0);
        int Nam = Integer.parseInt(cbNam.getSelectedItem() + "");
        int HocKy = Integer.parseInt(cbHocKy.getSelectedItem() + "");
        String TenMon = cbMon.getSelectedItem() + "";
        String MaLop = cbLop.getSelectedItem() + "";
        if (cbLop.getItemCount() > 0) {
            ArrayList<nguoiDungDTO> listNgDung = busNgDung.getThongTinSV(Nam, HocKy, TenMon, MaLop);
            for (nguoiDungDTO ng : listNgDung) {
                Object[] row = {ng.getMaUser(), ng.getHoTen(), ng.getNgSinh()};
                model.addRow(row);
            }
        }
    }
    
    private void DSTimKiem() {
        model.setRowCount(0);
        int Nam = Integer.parseInt(cbNam.getSelectedItem() + "");
        int HocKy = Integer.parseInt(cbHocKy.getSelectedItem() + "");
        String TenMon = cbMon.getSelectedItem() + "";
        String MaLop = cbLop.getSelectedItem() + "";
        String keyword = tfTimKiem.getText();
        if (cbLop.getItemCount() > 0) {
            ArrayList<nguoiDungDTO> list = busNgDung.TimKiem(Nam, HocKy, TenMon, MaLop, keyword);
            for (nguoiDungDTO ng : list) {
                Object[] row = {ng.getMaUser(), ng.getHoTen(), ng.getNgSinh()};
                model.addRow(row);
            }
            tfTimKiem.setText("");
        }
    }
    
    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(900, 400);
        PnThemLopChoSV p = new PnThemLopChoSV();
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
}
