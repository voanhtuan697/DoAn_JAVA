/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.cauHoiBUS;
import BUS.dapAnBUS;
import BUS.monBUS;
import DAO.cauHoiDAO;
import DTO.cauHoiDTO;
import DTO.dapAnDTO;
import DTO.monDTO;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import static GUI.BASE.cobalt_blue;
import static GUI.BASE.dark_green;
import static GUI.BASE.font13;
import static GUI.BASE.white;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import XULY.ShowDiaLog;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author E7250
 */
public class PanelTaoCauHoi extends JPanel implements ActionListener, MouseListener {

    private JComboBox<String> cbb_mon;
    private JComboBox<String> cbb_trangThaiCH;
    private JComboBox<String> cbb_hinhThuc;
    private DefaultTableModel model;
    private JPanel cards;
    private CardLayout cardLayout;
    private JLabel lb_soDapAn;
    private JTextField txt_soDapAn;
    private String[] bangChuCai;
    private cauHoiDAO cauHoiDAO;
    private File selectedFile;
    private String maTK;
    private monBUS monbus;
    private cauHoiBUS chBUS;
    private JTable table;
    private Map<String, String> mapCBB_mon = new HashMap<>();
    private JTextField txt_ctl_a;
    private JTextField txt_ctl_b;
    private JTextField txt_ctl_c;
    private JTextField txt_ctl_d;
    private JRadioButton rdb_a;
    private JRadioButton rdb_b;
    private JRadioButton rdb_c;
    private JRadioButton rdb_d;
    private dapAnBUS da;
    private JTextArea txta;

    public PanelTaoCauHoi(String maTK) throws SQLException {
        da = new dapAnBUS();
        chBUS = new cauHoiBUS();
        this.maTK = maTK;
        monbus = new monBUS();
        init();
        phanCauHoi(0);
        loadCBBMon();
        cauHoiDAO = new cauHoiDAO();
        cbb_mon.setSelectedIndex(0);
    }

    public void loadData(String maKho, String trangThai) throws SQLException {
        boolean status;
        if (trangThai.equals("Đã duyệt")) {
            status = true;
        } else {
            status = false;
        }
        model.setRowCount(0);
        ArrayList<cauHoiDTO> arr = this.chBUS.layDanhSachCauHoi();
        for (cauHoiDTO ch : arr) {
            if (ch.getMaKho().trim().equals(maKho) && ch.isTrangThai() == status) {
                model.addRow(new Object[]{ch.getMaCH(), ch.getMaGV(), ch.getNoidung(), ch.getDoKho(), ch.getMaHT(), ch.getImg()});
            }
            table.setModel(model);
        }
    }

    public JComboBox<String> getCbb_monThi() {
        return cbb_mon;
    }

    public void setCbb_monThi(JComboBox<String> cbb_monThi) {
        this.cbb_mon = cbb_monThi;
    }

    public JComboBox<String> getCbb_trangThaiCH() {
        return cbb_trangThaiCH;
    }

    public void setCbb_trangThaiCH(JComboBox<String> cbb_trangThaiCH) {
        this.cbb_trangThaiCH = cbb_trangThaiCH;
    }

    public JComboBox<String> getCbb_hinhThuc() {
        return cbb_hinhThuc;
    }

    public void setCbb_hinhThuc(JComboBox<String> cbb_hinhThuc) {
        this.cbb_hinhThuc = cbb_hinhThuc;
    }

    public DefaultTableModel getModel() {
        return model;
    }

    public void setModel(DefaultTableModel model) {
        this.model = model;
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

    public JLabel getLb_soDapAn() {
        return lb_soDapAn;
    }

    public void setLb_soDapAn(JLabel lb_soDapAn) {
        this.lb_soDapAn = lb_soDapAn;
    }

    public JTextField getTxt_soDapAn() {
        return txt_soDapAn;
    }

    public void setTxt_soDapAn(JTextField txt_soDapAn) {
        this.txt_soDapAn = txt_soDapAn;
    }
//ssssssssssssssssssssss

    public void loadCBBMon() throws SQLException {
        ArrayList<monDTO> arr = monbus.layDanhSachMon();
        for (monDTO m : arr) {
            cbb_mon.addItem(m.getTenMon());
            String maKho = "K" + m.getMaMon().trim().substring(1);
            mapCBB_mon.put(m.getTenMon().trim(), maKho);
        }
    }

    public void init() {
        JPanel pn1 = new JPanel();
        pn1.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pn1.setPreferredSize(new Dimension(0, 40));
        pn1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));
        JLabel lb_cbbMonThi = new JLabel("Tên môn:");
        lb_cbbMonThi.setFont(font13);
        cbb_mon = new JComboBox<>();

        cbb_mon.setFont(font13);
        cbb_mon.addActionListener(this);

        JLabel lb_cbbTrangThaiCH = new JLabel("Trạng thái:");
        lb_cbbTrangThaiCH.setFont(font13);
        String[] kiemDuyetCH = new String[]{"Chưa duyệt", "Đã duyệt"};
        cbb_trangThaiCH = new JComboBox<>(kiemDuyetCH);
        cbb_trangThaiCH.setFont(font13);
        cbb_trangThaiCH.addActionListener(this);

        cbb_trangThaiCH.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    String trangThai = (String) cbb_trangThaiCH.getSelectedItem();
                    // Sử dụng giá trị trạng thái ở đây (ví dụ: có thể lưu vào biến hoặc truyền vào đối tượng câu hỏi)
                }
            }
        });

        pn1.add(lb_cbbMonThi);
        pn1.add(cbb_mon);
        pn1.add(lb_cbbTrangThaiCH);
        pn1.add(cbb_trangThaiCH);

//-------------------------------------------------PANEL2------------------------------------------------------------
        JPanel pn2 = new JPanel();
        pn2.setLayout(new BorderLayout());

        Object[][] data = {};

        // Tạo tiêu đề cho bảng
        Object[] columns = {"Mã câu hỏi", "Mã giảng viên", "Nội dung", "Độ khó", "Mã hình thức", "Ảnh"};
        model = new DefaultTableModel(data, columns);

//        Không cho người dùng tác động
        table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table.addMouseListener(this);

        // Thiết lập renderer cho tất cả các cột
//        set chiều ngang cho cột
//        TableColumnModel columnModel = table.getColumnModel();
//        columnModel.getColumn(0).setPreferredWidth(60); // Mã câu hỏi
//        columnModel.getColumn(1).setPreferredWidth(80); // Mã giảng viên
//        columnModel.getColumn(2).setPreferredWidth(1000); // Nội dung
//        columnModel.getColumn(3).setPreferredWidth(70); // Độ khó
        JScrollPane scrollPane_table = new JScrollPane(table);
        pn2.add(scrollPane_table, BorderLayout.CENTER);

//--------------------------------------------------PANEL3----------------------------------------------------------
        JPanel pn3 = new JPanel();
        pn3.setLayout(new BorderLayout());
        pn3.setPreferredSize(new Dimension(0, 300));

        JPanel pn3_input = new JPanel();
        pn3_input.setPreferredSize(new Dimension(600, 300));

        JPanel pn_lb_cauhoi = new JPanel();
        pn_lb_cauhoi.setMaximumSize(new Dimension(1300, 10));
        pn_lb_cauhoi.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pn_lb_cauhoi.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 3));
        JLabel lb_cauhoi = new JLabel("Nội dung câu hỏi loại:");
        lb_cauhoi.setFont(font13);

        cbb_hinhThuc = new JComboBox<>(new String[]{"Trắc nghiệm một lựa chọn đúng", "Trắc nghiệm nhiều lựa chọn đúng"});

        cbb_hinhThuc.addActionListener(this);
        lb_soDapAn = new JLabel("Số lượng đáp án");
        lb_soDapAn.setVisible(false);
        txt_soDapAn = new JTextField(5);
        txt_soDapAn.setText("0");
        txt_soDapAn.setVisible(false);

        txt_soDapAn.addActionListener(this);

        pn_lb_cauhoi.add(lb_cauhoi);
        pn_lb_cauhoi.add(cbb_hinhThuc);
        pn_lb_cauhoi.add(lb_soDapAn);
        pn_lb_cauhoi.add(txt_soDapAn);

        JPanel pn_cauhoi = new JPanel();
        pn_cauhoi.setPreferredSize(new Dimension(0, 100));
        pn_cauhoi.setLayout(new BorderLayout());
        txta = new JTextArea();
        txta.setLineWrap(true);// tự động xuống hàng khi văn bản quá dài

        JScrollPane scrollPane_cauhoi = new JScrollPane(txta);
        pn_cauhoi.add(scrollPane_cauhoi, BorderLayout.CENTER);

        JPanel pn_lb_cautraloi = new JPanel();
        pn_lb_cautraloi.setMaximumSize(new Dimension(1300, 10));
        pn_lb_cautraloi.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pn_lb_cautraloi.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 3));
        JLabel lb_cautraloi = new JLabel("Các câu trả lời");
        lb_cautraloi.setFont(font13);
        pn_lb_cautraloi.add(lb_cautraloi);

        JPanel pn_cautraloi = new JPanel();
        pn_cautraloi.setLayout(new BorderLayout());
        pn_cautraloi.setBackground(new Color(0xB3, 0xBE, 0xCB));

//card layout
        cards = new JPanel();
        pn_cautraloi.add(cards, BorderLayout.CENTER);
        cardLayout = new CardLayout();
        cards.setLayout(cardLayout);

        JPanel pn_img = new JPanel();
        pn_img.setMaximumSize(new Dimension(1300, 10));
        pn_img.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pn_img.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));

        JLabel lb_img = new JLabel("Hình ảnh:");
        lb_img.setFont(font13);
        JButton btn_img = new JButton("Upload Image");
        pn_img.add(lb_img);
        pn_img.add(btn_img);

        btn_img.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", ImageIO.getReaderFileSuffixes()));

                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    try {
                        // Lấy đường dẫn tới thư mục cùng cấp với thư mục hiện tại
                        String currentDir = new File("..").getCanonicalPath();
                        File destFile = new File(currentDir + "/DoAn_JAVA/src/image/" + selectedFile.getName());
                        Files.copy(selectedFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

                        // Lưu đường dẫn hình ảnh vào cơ sở dữ liệu
                        String imagePath = destFile.getAbsolutePath();
                        // Ở đây, bạn cần thực hiện các bước để lưu imagePath vào cơ sở dữ liệu của bạn
                        // Điều này sẽ phụ thuộc vào cách bạn đang tương tác với cơ sở dữ liệu
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        // Xử lý nếu có lỗi khi sao chép hình ảnh hoặc lấy đường dẫn tuyệt đối
                    }
                }
            }
        });

        JPanel pn_doKho = new JPanel();
        pn_doKho.setMaximumSize(new Dimension(1300, 10));
        pn_doKho.setBackground(new Color(0xB3, 0xBE, 0xCB));
        JLabel lb_doKho = new JLabel("Độ khó câu hỏi:");
        lb_doKho.setFont(font13);
        pn_doKho.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));

        ButtonGroup btnG_DoKho = new ButtonGroup();

        JRadioButton rdb_easy = new JRadioButton();
        rdb_easy.setSelected(true);
        rdb_easy.setOpaque(false);
        JLabel lb_easy = new JLabel("Dễ");
        lb_easy.setFont(font13);

        JRadioButton rdb_medium = new JRadioButton();
        rdb_medium.setOpaque(false);
        JLabel lb_medium = new JLabel("Trung bình");
        lb_medium.setFont(font13);

        JRadioButton rdb_hard = new JRadioButton();
        rdb_hard.setOpaque(false);
        JLabel lb_hard = new JLabel("Khó");
        lb_hard.setFont(font13);

        rdb_easy.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Đã chọn nút radio "Dễ"
                    String selectedDoKho = "Dễ";
                    // Sử dụng giá trị đã chọn ở đây (ví dụ: có thể lưu vào biến hoặc truyền vào đối tượng câu hỏi)
                }
            }
        });

        rdb_medium.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Đã chọn nút radio "Trung bình"
                    String selectedDoKho = "Trung bình";
                    // Sử dụng giá trị đã chọn ở đây
                }
            }
        });

        rdb_hard.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    // Đã chọn nút radio "Khó"
                    String selectedDoKho = "Khó";
                    // Sử dụng giá trị đã chọn ở đây
                }
            }
        });

        btnG_DoKho.add(rdb_easy);
        btnG_DoKho.add(rdb_medium);
        btnG_DoKho.add(rdb_hard);

        pn_doKho.add(lb_doKho);
        pn_doKho.add(lb_easy);
        pn_doKho.add(rdb_easy);
        pn_doKho.add(lb_medium);
        pn_doKho.add(rdb_medium);
        pn_doKho.add(lb_hard);
        pn_doKho.add(rdb_hard);

        GroupLayout layout_pn3_input = new GroupLayout(pn3_input);
        pn3_input.setLayout(layout_pn3_input);

        layout_pn3_input.setHorizontalGroup(
                layout_pn3_input.createSequentialGroup()
                        .addGroup(layout_pn3_input.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(pn_lb_cauhoi)
                                .addComponent(pn_cauhoi)
                                .addComponent(pn_lb_cautraloi)
                                .addComponent(pn_cautraloi)
                                .addComponent(pn_img)
                                .addComponent(pn_doKho))
        );

        layout_pn3_input.setVerticalGroup(
                layout_pn3_input.createSequentialGroup()
                        .addComponent(pn_lb_cauhoi)
                        .addComponent(pn_cauhoi)
                        .addComponent(pn_lb_cautraloi)
                        .addComponent(pn_cautraloi)
                        .addComponent(pn_img)
                        .addComponent(pn_doKho)
        );

        JPanel pn3_btn = new JPanel();
        pn3_btn.setPreferredSize(new Dimension(100, 300));
        pn3_btn.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pn3_btn.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));

        String[] name_btn = new String[]{"Thêm", "Xóa"};
        String[] name_image = new String[]{"plus_icon.png", "delete_icon.png"};
        for (int i = 0; i < name_btn.length; i++) {
            JButton btn = new JButton(name_btn[i]);
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);
            if (i < 3) {
                btn.setIcon(new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(GiaoDienUserGUI.class.getResource("..//image//" + name_image[i]))).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH)));
            }
            btn.setBackground(dark_green);
            btn.setFont(new Font("typeface", Font.BOLD, 10));
            btn.setForeground(white);

            btn.setPreferredSize(new Dimension(90, 30));
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    // Thay đổi màu nền khi chuột hover vào
                    btn.setBackground(cobalt_blue);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // Thay đổi màu nền khi chuột rời khỏi
                    btn.setBackground(dark_green);
                }
            });
            pn3_btn.add(btn);
        }
        // Tạo một Renderer cho cột ảnh
        class ImageRenderer extends DefaultTableCellRenderer {

            JLabel label = new JLabel();

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                if (value != null && value instanceof String) {
                    label.setText((String) value);
                } else {
                    label.setText("Không có ảnh");
                }
                return label;
            }
        }

        // Thêm câu hỏi vào cơ sở dữ liệu và cập nhật table
        JButton btnThem = (JButton) pn3_btn.getComponent(0);
        btnThem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<cauHoiDTO> arr = new ArrayList<>();
                try {
                    //kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk
                    arr = chBUS.layDanhSachCauHoi();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                String selectCBB_mon = (String) cbb_mon.getSelectedItem();
                String selectCBB_trangThai = (String) cbb_trangThaiCH.getSelectedItem();
                String maKho = mapCBB_mon.get(selectCBB_mon.trim()).trim();
//                
                int soCat = maKho.length() + 1;
                String maCHCuoi = "";
                for (cauHoiDTO x : arr) {
                    if (x.getMaKho().trim().equals(maKho.trim())) {
                        maCHCuoi = x.getMaCH().trim();
                    }
                }
                String maCH = "";
                if (maCHCuoi == "") {
                    maCHCuoi = "CH" + maKho.substring(1, soCat - 1) + "1";
                    maCH = maCHCuoi;
                } else {
                    String prefix = maCHCuoi.substring(0, soCat);
                    int so = Integer.parseInt(maCHCuoi.substring(soCat)) + 1;
                    maCH = prefix + so;
                }
                ;
                String noiDung = txta.getText(); // Lấy nội dung câu hỏi từ textField noiDung
                String doKho = ""; // Khai báo biến để lưu độ khó được chọn
                // Xử lý dựa trên giá trị của nút radio đã được chọn
                if (rdb_easy.isSelected()) {
                    doKho = "Dễ";
                } else if (rdb_medium.isSelected()) {
                    doKho = "Trung bình";
                } else if (rdb_hard.isSelected()) {
                    doKho = "Khó";
                }
                // Lấy đường dẫn hình ảnh từ người dùng
                String imagePath = "";

                // Kiểm tra xem người dùng đã chọn hình ảnh hay chưa
                if (selectedFile != null && selectedFile.exists()) {
                    imagePath = selectedFile.getAbsolutePath();
                }
                String maHT = "";
                String selectCBB_hinhThuc = (String) cbb_hinhThuc.getSelectedItem();
                if (selectCBB_hinhThuc.equals("Trắc nghiệm một lựa chọn đúng")) {
                    maHT = "TNBC";
                } else {
                    maHT = "TNNC";
                }

                cauHoiDTO cauHoiMoi = new cauHoiDTO();
                cauHoiMoi.setMaCH(maCH);
                cauHoiMoi.setMaKho(maKho);
                cauHoiMoi.setMaHT(maHT);
                cauHoiMoi.setNoidung(noiDung);
                cauHoiMoi.setDoKho(doKho);
                if (!imagePath.isEmpty()) {
                    Path path = Paths.get(imagePath);
                    String tenFile = path.getFileName().toString();
                    cauHoiMoi.setImg(tenFile);
                } else {
                    cauHoiMoi.setImg(imagePath);
                }

                cauHoiMoi.setMaGV(maTK);
                cauHoiMoi.setTrangThai(false);

                // Gọi phương thức thêm câu hỏi từ lớp BUS
                cauHoiBUS bus = null;
                try {
                    bus = new cauHoiBUS();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                if (bus.themCauHoi(cauHoiMoi)) {
                    new ShowDiaLog("Thêm câu hỏi thành công!", ShowDiaLog.SUCCESS_DIALOG);
                } else {
                    new ShowDiaLog("Thêm câu hỏi thất bại! Vui lòng kiểm tra lại.", ShowDiaLog.ERROR_DIALOG);
                }
                if (selectCBB_hinhThuc.equals("Trắc nghiệm một lựa chọn đúng")) {
                    dapAnDTO daa = new dapAnDTO();
                    daa.setMaCH(maCH);
                    daa.setMaDa("DAA");
                    daa.setNoidung(txt_ctl_a.getText());
                    daa.setDungSai(rdb_a.isSelected());
                    da.themdapAn(daa);

                    dapAnDTO dab = new dapAnDTO();
                    dab.setMaCH(maCH);
                    dab.setMaDa("DAB");
                    dab.setNoidung(txt_ctl_b.getText());
                    dab.setDungSai(rdb_b.isSelected());
                    da.themdapAn(dab);

                    dapAnDTO dac = new dapAnDTO();
                    dac.setMaCH(maCH);
                    dac.setMaDa("DAC");
                    dac.setNoidung(txt_ctl_b.getText());
                    dac.setDungSai(rdb_c.isSelected());
                    da.themdapAn(dac);

                    dapAnDTO dad = new dapAnDTO();
                    dad.setMaCH(maCH);
                    dad.setMaDa("DAD");
                    dad.setNoidung(txt_ctl_d.getText());
                    dad.setDungSai(rdb_d.isSelected());
                    da.themdapAn(dad);

                } else {
                    System.out.println("ss");
                }

                txta.setText("");

                try {
                    loadData(maKho, selectCBB_trangThai);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                rdb_a.setText("");
                rdb_b.setText("");
                rdb_c.setText("");
                rdb_d.setText("");
                // Cập nhật lại table model sau khi thêm câu hỏi vào cơ sở dữ liệu
                cauHoiDAO dao = null;
                try {
                    dao = new cauHoiDAO();
                } catch (SQLException ex) {
                    Logger.getLogger(PanelTaoCauHoi.class.getName()).log(Level.SEVERE, null, ex);
                }
//                hhhhhhhhhhhhhhhhhhhhh
            }
        });

        // Gán Renderer cho cột ảnh của table
        // Đoạn code này nên được đặt trong constructor hoặc phương thức khởi tạo của PanelTaoCauHoi
        JButton btnXoa = (JButton) pn3_btn.getComponent(1); // Lấy nút Xóa từ panel pn3_btn
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                if (row != -1) {
                    String maCH = table.getValueAt(row, 0).toString().trim();
                    da.xoadapAn(maCH);
                    chBUS.xoaCauHoi(maCH);
                    String selectCBB_mon = (String) cbb_mon.getSelectedItem();
                    String selectCBB_trangThai = (String) cbb_trangThaiCH.getSelectedItem();
                    String value = mapCBB_mon.get(selectCBB_mon);
                    try {
                        loadData(value, selectCBB_trangThai.trim());
                    } catch (SQLException ex) {

                    }
                } else {
                    new ShowDiaLog("Chưa chọn câu hỏi", ShowDiaLog.ERROR_DIALOG);
                }

            }
        });
        // Đoạn code này nên được đặt trong constructor hoặc phương thức khởi tạo của PanelTaoCauHoi

        pn3.add(pn3_input, BorderLayout.CENTER);
        pn3.add(pn3_btn, BorderLayout.EAST);

        this.setLayout(new BorderLayout());
        this.add(pn1, BorderLayout.NORTH);
        this.add(pn2, BorderLayout.CENTER);
        this.add(pn3, BorderLayout.SOUTH);
    }

    public void phanCauHoi(int soDapAn) {
        bangChuCai = new String[]{"A", "B", "C", "D", "E", "F", "J", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

        JPanel pn_content = new JPanel();
        pn_content.setLayout(new BoxLayout(pn_content, BoxLayout.Y_AXIS));
//        pn_content.add(Box.createHorizontalGlue());

        for (int i = 0; i < soDapAn; i++) {
            JPanel panel = new JPanel(new BorderLayout());
            panel.setMaximumSize(new Dimension(1400, 20));
            JLabel label = new JLabel(bangChuCai[i]);
            label.setPreferredSize(new Dimension(15, 0));
            JTextField txt = new JTextField();
//            txt.setName("DA"+bangChuCai[i]);
            JCheckBox checkBox = new JCheckBox();

            panel.add(label, BorderLayout.WEST);
            panel.add(txt, BorderLayout.CENTER);
            panel.add(checkBox, BorderLayout.EAST);
            pn_content.add(panel);
        }

        JScrollPane scrollPane = new JScrollPane(pn_content);
        scrollPane.setPreferredSize(new Dimension(0, 200));
//-----------------------------con ga con

        JPanel pn_tn4 = new JPanel();
        GroupLayout layout_cauTraLoi = new GroupLayout(pn_tn4);
        pn_tn4.setLayout(layout_cauTraLoi);
        layout_cauTraLoi.setAutoCreateGaps(true);
        layout_cauTraLoi.setAutoCreateContainerGaps(true);

        JLabel lb_a = new JLabel("A");
        lb_a.setFont(font13);
        JLabel lb_b = new JLabel("B");
        lb_b.setFont(font13);
        JLabel lb_c = new JLabel("C");
        lb_c.setFont(font13);
        JLabel lb_d = new JLabel("D");
        lb_d.setFont(font13);

        txt_ctl_a = new JTextField();
        txt_ctl_b = new JTextField();
        txt_ctl_c = new JTextField();
        txt_ctl_d = new JTextField();

        ButtonGroup btnG = new ButtonGroup();
        rdb_a = new JRadioButton();
        rdb_a.setSelected(true);
        rdb_a.setOpaque(false);
        rdb_b = new JRadioButton();
        rdb_b.setOpaque(false);
        rdb_c = new JRadioButton();
        rdb_c.setOpaque(false);
        rdb_d = new JRadioButton();
        rdb_d.setOpaque(false);

        btnG.add(rdb_a);
        btnG.add(rdb_b);
        btnG.add(rdb_c);
        btnG.add(rdb_d);

        layout_cauTraLoi.setHorizontalGroup(
                layout_cauTraLoi.createSequentialGroup()
                        .addGroup(layout_cauTraLoi.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lb_a)
                                .addComponent(lb_b)
                                .addComponent(lb_c)
                                .addComponent(lb_d))
                        .addGroup(layout_cauTraLoi.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(txt_ctl_a)
                                .addComponent(txt_ctl_b)
                                .addComponent(txt_ctl_c)
                                .addComponent(txt_ctl_d))
                        .addGroup(layout_cauTraLoi.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(rdb_a)
                                .addComponent(rdb_b)
                                .addComponent(rdb_c)
                                .addComponent(rdb_d))
        );

        layout_cauTraLoi.setVerticalGroup(
                layout_cauTraLoi.createSequentialGroup()
                        .addGroup(layout_cauTraLoi.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_a)
                                .addComponent(txt_ctl_a)
                                .addComponent(rdb_a))
                        .addGroup(layout_cauTraLoi.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_b)
                                .addComponent(txt_ctl_b)
                                .addComponent(rdb_b))
                        .addGroup(layout_cauTraLoi.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_c)
                                .addComponent(txt_ctl_c)
                                .addComponent(rdb_c))
                        .addGroup(layout_cauTraLoi.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_d)
                                .addComponent(txt_ctl_d)
                                .addComponent(rdb_d))
        );
//        them panel o day
        cards.add(pn_tn4, "pn_TN4");
        cards.add(scrollPane, "pn_TN_Nhieu");
    }

    @Override
//ssssssssssssssssssssssssssssssssssssssssssssssss
    public void actionPerformed(ActionEvent e) {
        String selectCBB_mon = (String) cbb_mon.getSelectedItem();
        String selectCBB_trangThai = (String) cbb_trangThaiCH.getSelectedItem();
        for (String key : mapCBB_mon.keySet()) {
            if (selectCBB_mon.equals(key)) {
                String value = mapCBB_mon.get(key);
                try {
                    loadData(value, selectCBB_trangThai.trim());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }

        if (selectCBB_trangThai.equals("Đã duyệt")) {
            String maKho = mapCBB_mon.get(selectCBB_mon);
            try {
                loadData(maKho, "Đã duyệt");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {
            String maKho = mapCBB_mon.get(selectCBB_mon);
            try {
                loadData(maKho, "Chưa duyệt");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        String selectedOption = (String) this.getCbb_hinhThuc().getSelectedItem();
        if (selectedOption.equals("Trắc nghiệm một lựa chọn đúng")) {
            this.getCardLayout().show(this.getCards(), "pn_TN4");
            this.getLb_soDapAn().setVisible(false);
            this.getTxt_soDapAn().setVisible(false);
        } else if (selectedOption.equals("Trắc nghiệm nhiều lựa chọn đúng")) {
            this.getCardLayout().show(this.getCards(), "pn_TN_Nhieu");
            this.getLb_soDapAn().setVisible(true);
            this.getTxt_soDapAn().setVisible(true);

            String pattern = "\\d+";
            String input = this.getTxt_soDapAn().getText();

            if (Pattern.matches(pattern, input)) {
                int number = Integer.parseInt(input);
                this.phanCauHoi(number);
//                panelTaoCauHoi.getTxt_soDapAn().setText("");
            } else {
                System.out.println("Không phải là số nguyên.");
//                panelTaoCauHoi.getTxt_soDapAn().setText("");
            }

        }
    }

    public static void main(String[] args) throws SQLException {
        JFrame f = new JFrame();
        f.setSize(800, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        Component add = f.getContentPane().add(new PanelTaoCauHoi("TK14"));
        f.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            int row = table.getSelectedRow();
            if (row != -1) {
                String maCH = table.getValueAt(row, 0).toString().trim();
                try {
                    new FrameXemChiTietCauHoi(maCH);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
