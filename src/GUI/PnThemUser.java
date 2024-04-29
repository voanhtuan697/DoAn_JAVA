/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.nguoiDungBUS;
import BUS.quyenBUS;
import BUS.taiKhoanBUS;
import DTO.nguoiDungDTO;
import DTO.quyenDTO;
import DTO.taiKhoanDTO;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import net.sourceforge.jdatepicker.JDatePanel;
import net.sourceforge.jdatepicker.JDatePicker;
import net.sourceforge.jdatepicker.impl.JDatePanelImpl;
import net.sourceforge.jdatepicker.impl.JDatePickerImpl;
import net.sourceforge.jdatepicker.impl.UtilDateModel;
import java.util.Date;
import javax.swing.JComboBox;
import static GUI.BASE.dark_green;
import static GUI.BASE.font13;
import static GUI.BASE.font14;
import static GUI.BASE.gray_bg;
import static GUI.BASE.white;
import XULY.ShowDiaLog;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author E7250
 */
public class PnThemUser extends JPanel {

    //, "Admin", "Trưởng bộ môn", "Giảng viên", "Sinh viên"
    private JTable table;
    private DefaultTableModel model;
    private String[] arr_table_quyen = {"Tất cả"};
    private String[] arr_quyen = {"Admin", "Trưởng bộ môn", "Giảng viên", "Sinh viên"};
    private JTextField txtSearch, txtHoTen;
    private JButton btnThem, btnSua, btnXoa, btnClear, btnNhap, btnXuat;
    private JComboBox<String> cbb_table_quyen, cbb_quyen;
    private UtilDateModel model1;

    JDatePicker datePicker;

    ArrayList<nguoiDungDTO> dsGoc = new ArrayList<>(new nguoiDungBUS().getNguoiDung());
    //new nguoiDungBUS().getNguoiDung());

    private nguoiDungBUS user;
    private taiKhoanBUS acc, acc1;
    private quyenBUS role;
    private String userId;

    public PnThemUser() throws SQLException {
        init();
        loadRole();
        loadUser();
        addEvent();
    }

    private void init() {
        this.setLayout(new BorderLayout());

        JPanel pn_header = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        pn_header.setBackground(gray_bg);

        JLabel lblSearch = new JLabel("Tìm kiếm");
        lblSearch.setFont(font14);
        txtSearch = new JTextField(15);

        JLabel lb_cbb_quyen = new JLabel("Quyền");

        cbb_table_quyen = new JComboBox<>(arr_table_quyen);
        pn_header.add(lb_cbb_quyen);
        pn_header.add(cbb_table_quyen);

        pn_header.add(lblSearch);
        pn_header.add(txtSearch);

        JPanel pn_content = new JPanel();
        pn_content.setLayout(new BorderLayout());

        JPanel pn_table = new JPanel();
        pn_table.setLayout(new BorderLayout());

        JPanel pn_input = new JPanel();
        pn_input.setBackground(gray_bg);
        pn_input.setPreferredSize(new Dimension(205, 0));
        pn_input.setLayout(new FlowLayout(FlowLayout.LEFT, 2, 3));

        JLabel lb_name = new JLabel("Họ tên:");
        lb_name.setFont(font13);
        txtHoTen = new JTextField(18);
        JLabel lb_ngaySinh = new JLabel("Ngày sinh:");
        lb_ngaySinh.setFont(font13);
        JLabel lb_quyen = new JLabel("Quyền:");
        cbb_quyen = new JComboBox<>();
        cbb_quyen.setPreferredSize(new Dimension(202, cbb_quyen.getPreferredSize().height));

        btnThem = new JButton("Thêm");
        btnThem.setBackground(dark_green);
        btnThem.setForeground(white);
        btnXoa = new JButton("Xóa");
        btnXoa.setBackground(dark_green);
        btnXoa.setForeground(white);
        btnNhap = new JButton("Nhập Excel");
        btnNhap.setBackground(dark_green);
        btnNhap.setForeground(white);
        btnXuat = new JButton("Xuất Excel");
        btnXuat.setBackground(dark_green);
        btnXuat.setForeground(white);
        btnSua = new JButton("Sửa");
        btnSua.setBackground(dark_green);
        btnSua.setForeground(white);
        btnClear = new JButton("Clear");
        btnClear.setBackground(dark_green);
        btnClear.setForeground(white);

        model1 = new UtilDateModel();
        JDatePanel datePanel = new JDatePanelImpl(model1);
        datePicker = new JDatePickerImpl((JDatePanelImpl) datePanel);

        pn_input.add(lb_name);
        pn_input.add(txtHoTen);
        pn_input.add(lb_ngaySinh);
        pn_input.add((Component) datePicker);
        pn_input.add(lb_quyen);
        pn_input.add(cbb_quyen);

        JPanel pn_btn = new JPanel(new GridLayout(3, 2, 7, 10));
        pn_btn.setBackground(gray_bg);
        pn_btn.add(btnThem);
        pn_btn.add(btnXoa);
        pn_btn.add(btnNhap);
        pn_btn.add(btnXuat);
        pn_btn.add(btnSua);
        pn_btn.add(btnClear);
        pn_input.add(pn_btn);

        pn_content.add(pn_table, BorderLayout.CENTER);
        pn_content.add(pn_input, BorderLayout.EAST);

        Object[] columns = {"Mã giảng viên", "Họ và tên", "Ngày sinh"};
        Object[][] data = {{null, null, null},
        {null, null, null},
        {null, null, null},};
        model = new DefaultTableModel(data, columns);

        table = new JTable(model) {
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

//        txtHoTen = new JTextField(25);
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

        this.add(pn_header, BorderLayout.NORTH);
        this.add(pn_content, BorderLayout.CENTER);
    }

    public void loadRole() throws SQLException {
        for (quyenDTO x : new quyenBUS().getQuyen()) {
//            System.out.println(x.getTenQuyen());
            cbb_table_quyen.addItem(x.getTenQuyen().toString());
            cbb_quyen.addItem(x.getTenQuyen().toString());
        }
    }

    public void loadUser() throws SQLException {
        acc = new taiKhoanBUS();

        model = new DefaultTableModel();
        String[] str = {"Mã người dùng", "Họ và tên", "Ngày sinh"};
        for (String s : str) {
            model.addColumn(s);
        }
        for (taiKhoanDTO x : acc.getTaiKhoan()) {
            if (x.getBit() != 0) {
                for (nguoiDungDTO y : new nguoiDungBUS().getNguoiDung()) {
                    if (x.getTenDN().equalsIgnoreCase(y.getMaUser())) {
                        model.addRow(new Object[]{
                            y.getMaUser(),
                            y.getHoTen(),
                            y.getNgSinh()
                        });
                    }
//                    break;

                }
            }
        }

        table.setModel(model);

    }

    public void addEvent() throws SQLException {
        if (cbb_table_quyen.getSelectedItem().equals("Tất cả")) {
            loadUser();
        }
        ArrayList<nguoiDungDTO> dsNguoiDung = new ArrayList<>();
        role = new quyenBUS();
        acc = new taiKhoanBUS();
        user = new nguoiDungBUS();
        cbb_table_quyen.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String luaChon = cbb_table_quyen.getSelectedItem().toString();
                try {
                    if (cbb_table_quyen.getSelectedItem().equals("Tất cả")) {
                        loadUser();
                    } else {
                        for (taiKhoanDTO x : acc.getTaiKhoan()) {
                            if (x.getMaQuyen().equalsIgnoreCase(role.getMaQuyenTheoTenQuyen(luaChon)) && x.getBit() != 0) {
                                nguoiDungDTO z = new nguoiDungDTO();
                                z.setMaUser(x.getTenDN());
                                dsNguoiDung.add(z);
                            }
                        }

                        user = new nguoiDungBUS();
                        model = new DefaultTableModel();
                        String[] str = {"Mã người dùng", "Họ và tên", "Ngày sinh"};
                        for (String s : str) {
                            model.addColumn(s);
                        }
                        for (nguoiDungDTO x : dsNguoiDung) {
                            for (nguoiDungDTO y : user.getNguoiDung()) {
                                if (x.getMaUser().equalsIgnoreCase(y.getMaUser())) {
                                    model.addRow(new Object[]{
                                        y.getMaUser(),
                                        y.getHoTen(),
                                        y.getNgSinh()
                                    });
                                    break;
                                }
                            }

                        }
                        table.setModel(model);
                        dsNguoiDung.clear();
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(PnThemUser.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });
        txtSearch.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    model = new DefaultTableModel();
                    String[] str = {"Mã người dùng", "Họ và tên", "Ngày sinh"};
                    for (String s : str) {
                        model.addColumn(s);
                    }
                    try {
                        ArrayList<nguoiDungDTO> ketQua = timKiem(new nguoiDungBUS().getNguoiDung(), txtSearch.getText());
                        for (taiKhoanDTO x : acc.getTaiKhoan()) {
                            for (nguoiDungDTO y : ketQua) {
                                if (x.getTenDN().equalsIgnoreCase(y.getMaUser()) && x.getBit() == 1) {
                                    for (nguoiDungDTO z : user.getNguoiDung()) {
                                        if (y.getMaUser().equalsIgnoreCase(z.getMaUser())) {
                                            model.addRow(new Object[]{
                                                z.getMaUser(),
                                                z.getHoTen(),
                                                z.getNgSinh()
                                            });
                                            break;
                                        }
                                    }
                                }

                            }
                        }
                        table.setModel(model);
                        ketQua.clear();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }
            }
        });
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtHoTen.getText().isEmpty()) {
                    new ShowDiaLog("Vui lòng nhập họ tên!", ShowDiaLog.ERROR_DIALONG);
//                    JOptionPane.showMessageDialog(null, "Vui lòng nhập họ tên!");
                    txtHoTen.requestFocus();
                    txtHoTen.selectAll();
                    return;
                }
                if (!isVietnamese(txtHoTen.getText())) {
                    new ShowDiaLog("Họ tên không hợp lệ!", ShowDiaLog.ERROR_DIALONG);
                    txtHoTen.requestFocus();
                    txtHoTen.selectAll();
                    return;
                }
                if (model1.getValue() == null) {
                    new ShowDiaLog("Vui lòng chọn ngày sinh!", ShowDiaLog.ERROR_DIALONG);
//                    JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày sinh!");
                    return;
                }
                if (userId != null) {
                    new ShowDiaLog("Người dùng đã tồn tại! Vui lòng clear form và nhập lại thông tin!", ShowDiaLog.ERROR_DIALONG);
//                    JOptionPane.showMessageDialog(null, "Người dùng đã tồn tại! Vui lòng clear form và nhập lại thông tin!");
                    return;
                }
                nguoiDungDTO a = new nguoiDungDTO();
                taiKhoanDTO b = new taiKhoanDTO();
                a.setHoTen(txtHoTen.getText());
                a.setNgSinh(model1.getYear() + "-" + (model1.getMonth() + 1) + "-" + model1.getDay());
                try {
                    int numAcc = acc.getSoLuongTaiKhoan();
                    int numUser = user.getSoLuongNguoiDung();
                    b.setMaTK("TK" + (numAcc + 1));
                    a.setMaUser("USER" + (numUser + 1));
                } catch (SQLException ex) {
                    Logger.getLogger(PnThemUser.class.getName()).log(Level.SEVERE, null, ex);
                }
                b.setTenDN(a.getMaUser());
                b.setMatKhau("12345");
                b.setBit(1);
                String tenQuyen = cbb_quyen.getSelectedItem().toString();

                try {
                    b.setMaQuyen(role.getMaQuyenTheoTenQuyen(tenQuyen));
                } catch (SQLException ex) {
                    Logger.getLogger(PnThemUser.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    if (user.addNguoiDung(a) && acc.addTaiKhoan(b)) {
                        new ShowDiaLog("Thêm thành công!", 2);
//                        JOptionPane.showMessageDialog(null, "Thêm thành công!");
                        loadUser();
                        datePicker.getModel().setValue(null);
                        cbb_table_quyen.setSelectedItem(1);
                        userId = null;
                        return;
                    } else {
                        new ShowDiaLog("Thêm thất bại!", 1);
//                        JOptionPane.showMessageDialog(null, "Thêm thất bại!");
                        return;
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        });
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtHoTen.getText().isEmpty()) {
                    new ShowDiaLog("Vui lòng nhập họ tên!", ShowDiaLog.ERROR_DIALONG);
//                    JOptionPane.showMessageDialog(null, "Vui lòng nhập họ tên!");
                    txtHoTen.requestFocus();
                    txtHoTen.selectAll();
                    return;
                }
                if (!isVietnamese(txtHoTen.getText())) {
                    new ShowDiaLog("Họ tên không hợp lệ!", ShowDiaLog.ERROR_DIALONG);
                    txtHoTen.requestFocus();
                    txtHoTen.selectAll();
                    return;
                }
                if (model1.getValue() == null) {
                    new ShowDiaLog("Vui lòng chọn ngày sinh!", ShowDiaLog.ERROR_DIALONG);
//                    JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày sinh!");
                    return;
                }
                int choose = JOptionPane.showConfirmDialog(null, "Bạn chắc chắn muốn sửa thông tin?", "Thông báo", JOptionPane.YES_NO_OPTION);
                if (choose == JOptionPane.YES_OPTION) {
                    String hoTen = txtHoTen.getText();
                    String ngSinh = model1.getYear() + "-" + (model1.getMonth() + 1) + "-" + model1.getDay();
                    System.out.println(ngSinh);
                    String tenQuyen = cbb_quyen.getSelectedItem().toString();
                    try {
                        if (user.updateNguoiDung(hoTen, ngSinh, userId)
                                && acc.updateTaiKhoan(role.getMaQuyenTheoTenQuyen(tenQuyen), userId)) {
                            new ShowDiaLog("Sửa thành công!", 2);
//                            JOptionPane.showMessageDialog(null, "Sửa thành công!");
                            cbb_table_quyen.setSelectedItem(1);
                            datePicker.getModel().setValue(null);
                            loadUser();
                            return;
                        } else {
                            new ShowDiaLog("Sửa thất bại!", 1);
//                            JOptionPane.showMessageDialog(null, "Sửa không thành công!");
                            return;
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } else {
                    return;
                }

            }
        }
        );
        btnXoa.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != 1) {
                    int choose = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa?", "Thông báo", JOptionPane.YES_NO_OPTION);
                    if (choose == JOptionPane.YES_OPTION) {
                        try {
                            if (acc.deleteTaiKhoan(userId)) {
                                new ShowDiaLog("Xóa thành công!", 2);
//                                JOptionPane.showMessageDialog(null, "Xóa thành công!");
                                cbb_table_quyen.setSelectedItem(1);
                                datePicker.getModel().setValue(null);
                                loadUser();
                                userId = null;
                                return;
                            }
                        } catch (SQLException ex) {
                            new ShowDiaLog("Xóa thất bại!", 1);
//                            JOptionPane.showMessageDialog(null, "Xóa thất bại!");

                            ex.printStackTrace();
                        }
                    } else {
                        return;
                    }

                } else {
                    new ShowDiaLog("Vui lòng chọn người dùng cần xóa!", ShowDiaLog.ERROR_DIALONG);

//                    JOptionPane.showMessageDialog(null, "Vui lòng chọn người dùng cần xóa!");
                    return;
                }
            }
        }
        );

        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
                datePicker.getModel().setValue(null);

            }
        });

        btnNhap.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File f = new File("C:\\Users\\PHUNG\\Videos\\NetBeansProjects\\DSNguoiDung.xlsx");
                    FileInputStream fi = new FileInputStream(f);
                    XSSFWorkbook wb = new XSSFWorkbook(fi);
                    XSSFSheet sheet = wb.getSheetAt(0);
                    FormulaEvaluator formula = wb.getCreationHelper().createFormulaEvaluator();
                    for (Row row : sheet) {
                        String id = row.getCell(0).getStringCellValue();
                        String name = row.getCell(1).getStringCellValue();
                        String birthday = row.getCell(2).getStringCellValue();
                        nguoiDungDTO a = new nguoiDungDTO(id, name, birthday);
                        dsGoc.add(a);
                    }
                    wb.close();
                    fi.close();
                    try {
                        loadUser();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        btnXuat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e
            ) {
                try {
                    XSSFWorkbook wb = new XSSFWorkbook();
                    XSSFSheet sheet = wb.createSheet();
                    XSSFRow row = null;
                    Cell cell = null;
                    row = sheet.createRow(3);
                    cell = row.createCell(0, CellType.STRING);
                    cell.setCellValue("Mã người dùng");

                    cell = row.createCell(1, CellType.STRING);
                    cell.setCellValue("Họ tên");

                    cell = row.createCell(2, CellType.STRING);
                    cell.setCellValue("Ngày sinh");

                    for (int i = 0; i < dsGoc.size(); i++) {
                        row = sheet.createRow(4 + i);

                        cell = row.createCell(0, CellType.STRING);
                        cell.setCellValue(dsGoc.get(i).getMaUser());

                        cell = row.createCell(1, CellType.STRING);
                        cell.setCellValue(dsGoc.get(i).getHoTen());

                        cell = row.createCell(2, CellType.STRING);
                        cell.setCellValue(dsGoc.get(i).getNgSinh());

                    }
                    File f = new File("C:\\Users\\PHUNG\\Videos\\NetBeansProjects\\DSNguoiDung.xlsx");
                    try {
                        FileOutputStream fo = new FileOutputStream(f);
                        wb.write(fo);
                        fo.close();
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    }

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                new ShowDiaLog("Xuất thành công!", ShowDiaLog.ERROR_DIALONG);

//                JOptionPane.showMessageDialog(null, "Xuất thành công!");
            }
        }
        );
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e
            ) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    try {
                        System.out.println(selectedRow);
                        displaySelectedRow(selectedRow);
                    } catch (SQLException ex) {
                        Logger.getLogger(PnThemUser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        );

    }

    public void displaySelectedRow(int selectedRow) throws SQLException {
        userId = table.getValueAt(selectedRow, 0).toString();
        txtHoTen.setText(table.getValueAt(selectedRow, 1).toString());
        String str[] = table.getValueAt(selectedRow, 2).toString().split("-");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(str[0]), Integer.parseInt(str[1]) - 1, Integer.parseInt(str[2]));
        model1.setValue(calendar.getTime());
        String maUser = table.getValueAt(selectedRow, 0).toString();
        String tenDN = acc.getMaQuyenTheoTenDN(maUser);
        cbb_quyen.setSelectedItem(role.getTenQuyenTheoMaQuyen(tenDN));
    }

    public void reset() {
        {
            userId = null;
            txtHoTen.setText("");
//                model1 = new UtilDateModel();
//                JDatePanel datePanel = new JDatePanelImpl(model1);
//                JDatePicker datePicker = new JDatePickerImpl((JDatePanelImpl) datePanel);
//                
//                model1 = null;
            cbb_quyen.setSelectedItem("Admin");
            try {
                loadUser();
            } catch (SQLException ex) {
                Logger.getLogger(PnThemUser.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    public boolean isVietnamese(String str) {
        String regex = "[a-zA-ZàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆđĐìÌỉỈĩĨíÍịỊòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢùÙủỦũŨúÚụỤưỪừỬữỮứỨựỰỳỲỷỶỹỸýÝỵỴ\\s]+$";
        return Pattern.matches(regex, str);

    }

    public ArrayList<nguoiDungDTO> timKiem(ArrayList<nguoiDungDTO> ds, String tuKhoa) throws SQLException {
//        ds = new nguoiDungBUS().getNguoiDung();
        // Tạo một ArrayList mới để chứa kết quả tìm kiếm
        ArrayList<nguoiDungDTO> ketQua = new ArrayList<>();

        // Chạy vòng lặp qua các đối tượng trong danh sách gốc
        for (nguoiDungDTO x : ds) {
            // Kiểm tra xem từ khóa có gần giống với bất kỳ thuộc tính nào của đối tượng không
            if (x.getMaUser().contains(tuKhoa) || x.getHoTen().contains(tuKhoa) || x.getNgSinh().contains(tuKhoa)) {
                // Nếu có, thêm đối tượng đó vào danh sách kết quả
                ketQua.add(x);
            }
        }

        // Trả về danh sách kết quả
        return ketQua;
    }

    public static void main(String[] args) throws SQLException {
        JFrame f = new JFrame();
        f.setSize(800, 500);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PnThemUser p = new PnThemUser();
        f.getContentPane().setLayout(new BorderLayout());
        f.add(p);
        f.setVisible(true);
    }
}
