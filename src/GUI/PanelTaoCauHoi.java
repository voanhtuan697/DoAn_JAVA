/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import BUS.cauHoiBUS;
import DAO.cauHoiDAO;
import DTO.cauHoiDTO;
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
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class PanelTaoCauHoi extends JPanel implements ActionListener {

    private JComboBox<String> cbb_monThi;
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

    public PanelTaoCauHoi() throws SQLException {
        init();
        phanCauHoi(0);
        cauHoiDAO = new cauHoiDAO();
        cauHoiDAO.loadDataFromDatabase(model);
    }

    public JComboBox<String> getCbb_monThi() {
        return cbb_monThi;
    }

    public void setCbb_monThi(JComboBox<String> cbb_monThi) {
        this.cbb_monThi = cbb_monThi;
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

    public void init() {
        JPanel pn1 = new JPanel();
        pn1.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pn1.setPreferredSize(new Dimension(0, 40));
        pn1.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 10));

        JLabel lblMaCH = new JLabel("Mã câu hỏi:");
        JTextField txtMaCH = new JTextField(10);
        JLabel lb_cbbMonThi = new JLabel("Tên môn:");
        lb_cbbMonThi.setFont(font13);
        String[] cacMonChinh = new String[]{"Toán", "Lý", "Sử", "Địa"};
        cbb_monThi = new JComboBox<>(cacMonChinh);
        cbb_monThi.setFont(font13);
//        Thêm môn
        cbb_monThi.addItem("Tiếng anh");

        JLabel lb_cbbTrangThaiCH = new JLabel("Trạng thái:");
        lb_cbbTrangThaiCH.setFont(font13);
        String[] kiemDuyetCH = new String[]{"Đã duyệt", "Chưa duyệt"};
        cbb_trangThaiCH = new JComboBox<>(kiemDuyetCH);
        cbb_trangThaiCH.setFont(font13);

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
        pn1.add(cbb_monThi);
        pn1.add(lb_cbbTrangThaiCH);
        pn1.add(cbb_trangThaiCH);
        pn1.add(lblMaCH);
        pn1.add(txtMaCH);

//-------------------------------------------------PANEL2------------------------------------------------------------
        JPanel pn2 = new JPanel();
        pn2.setLayout(new BorderLayout());

        Object[][] data = {};

        // Tạo tiêu đề cho bảng
        Object[] columns = {"Mã câu hỏi", "Mã giảng viên", "Nội dung", "Độ khó", "Ảnh"};
        model = new DefaultTableModel(data, columns);

//        Không cho người dùng tác động
        JTable table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

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
        JTextArea txta = new JTextArea();
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

        String[] name_btn = new String[]{"Thêm", "Xóa", "Sửa", "Nhập Excel", "Xuất Excel", "Chi tiết"};
        String[] name_image = new String[]{"plus_icon.png", "delete_icon.png", "edit_icon.png"};
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
                // Cập nhật dữ liệu trên table model với các giá trị mới từ người dùng
                String maCH = txtMaCH.getText(); // Lấy mã câu hỏi từ textField maCH
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
                String imagePath = null; // Khởi tạo chuỗi để lưu đường dẫn hình ảnh

                // Kiểm tra xem người dùng đã chọn hình ảnh hay chưa
                if (selectedFile != null && selectedFile.exists()) {
                    imagePath = selectedFile.getAbsolutePath();
                }

                // Tạo một hàng mới cho dữ liệu từ các trường nhập liệu
                Object[] newRow = {maCH, "", noiDung, doKho, imagePath}; // Chú ý thêm dữ liệu hình ảnh vào hàng mới

                // Thêm hàng mới vào table model
                model.addRow(newRow);

                // Thêm câu hỏi vào cơ sở dữ liệu
                cauHoiDTO cauHoiMoi = new cauHoiDTO();
                cauHoiMoi.setMaCH(maCH);
                cauHoiMoi.setNoidung(noiDung);
                cauHoiMoi.setDoKho(doKho);
                cauHoiMoi.setImg(imagePath);
                String trangThai = (String) cbb_trangThaiCH.getSelectedItem();
                // Kiểm tra và gán giá trị tương ứng cho thuộc tính trangThai
                if ("Đã duyệt".equals(trangThai)) {
                    cauHoiMoi.setTrangThai(true); // hoặc 1
                } else {
                    cauHoiMoi.setTrangThai(false); // hoặc 0
                }
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

                // Cập nhật lại table model sau khi thêm câu hỏi vào cơ sở dữ liệu
                cauHoiDAO dao = null;
                try {
                    dao = new cauHoiDAO();
                } catch (SQLException ex) {
                    Logger.getLogger(PanelTaoCauHoi.class.getName()).log(Level.SEVERE, null, ex);
                }
                dao.loadDataFromDatabase(model);
            }
        });

        // Gán Renderer cho cột ảnh của table
        table.getColumnModel().getColumn(4).setCellRenderer(new ImageRenderer());

        // Đoạn code này nên được đặt trong constructor hoặc phương thức khởi tạo của PanelTaoCauHoi
        JButton btnXoa = (JButton) pn3_btn.getComponent(1); // Lấy nút Xóa từ panel pn3_btn
        btnXoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy mã câu hỏi từ textField maCH
                String maCH = txtMaCH.getText();

                // Gọi phương thức xóa câu hỏi từ lớp DAO
                cauHoiDAO dao = null;
                try {
                    dao = new cauHoiDAO();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                if (dao.xoaCauHoi(maCH)) {
                    // Nếu xóa thành công, thông báo và cập nhật lại dữ liệu trên bảng
                    new ShowDiaLog("Xóa câu hỏi thành công!", ShowDiaLog.SUCCESS_DIALOG);
                    dao.loadDataFromDatabase(model); // Cập nhật lại dữ liệu trên bảng
                } else {
                    new ShowDiaLog("Xóa câu hỏi thất bại! Vui lòng kiểm tra lại.", ShowDiaLog.ERROR_DIALOG);
                }
            }
        });
        // Đoạn code này nên được đặt trong constructor hoặc phương thức khởi tạo của PanelTaoCauHoi
        JButton btnSua = (JButton) pn3_btn.getComponent(2); // Lấy nút Sửa từ panel pn3_btn
        btnSua.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lấy các giá trị từ các trường nhập liệu
                String maCH = txtMaCH.getText(); // Lấy mã câu hỏi từ textField maCH
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

                // Tạo một đối tượng câu hỏi mới
                cauHoiDTO cauHoiMoi = new cauHoiDTO();
                cauHoiMoi.setMaCH(maCH);
                cauHoiMoi.setNoidung(noiDung);
                cauHoiMoi.setDoKho(doKho);
                String trangThai = (String) cbb_trangThaiCH.getSelectedItem();
                // Kiểm tra và gán giá trị tương ứng cho thuộc tính trangThai
                if ("Đã duyệt".equals(trangThai)) {
                    cauHoiMoi.setTrangThai(true); // hoặc 1
                } else {
                    cauHoiMoi.setTrangThai(false); // hoặc 0
                }

                // Gọi phương thức sửa câu hỏi từ lớp DAO
                cauHoiDAO dao = null;
                try {
                    dao = new cauHoiDAO();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                if (dao.suaCauHoi(cauHoiMoi)) {
                    // Nếu sửa thành công, thông báo và cập nhật lại dữ liệu trên bảng
                    new ShowDiaLog("Sửa câu hỏi thành công!", ShowDiaLog.SUCCESS_DIALOG);
                    dao.loadDataFromDatabase(model); // Cập nhật lại dữ liệu trên bảng
                } else {
                    new ShowDiaLog("Sửa câu hỏi thất bại! Vui lòng kiểm tra lại.", ShowDiaLog.ERROR_DIALOG);
                }
            }
        });
        JButton btnChiTiet = (JButton) pn3_btn.getComponent(5);
        // Thêm sự kiện cho nút "Chi tiết"
        btnChiTiet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cauHoiDTO cauHoi = new cauHoiDTO();
                String maCH = cauHoi.getMaCH();
                try {
                    new FrameXemChiTietCauHoi(maCH); // Khởi tạo FrameXemChiTietCauHoi với mã câu hỏi
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

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

        JTextField txt_ctl_a = new JTextField();
        JTextField txt_ctl_b = new JTextField();
        JTextField txt_ctl_c = new JTextField();
        JTextField txt_ctl_d = new JTextField();

        ButtonGroup btnG = new ButtonGroup();
        JRadioButton rdb_a = new JRadioButton();
        rdb_a.setOpaque(false);
        JRadioButton rdb_b = new JRadioButton();
        rdb_b.setOpaque(false);
        JRadioButton rdb_c = new JRadioButton();
        rdb_c.setOpaque(false);
        JRadioButton rdb_d = new JRadioButton();
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

    public void actionPerformed(ActionEvent e) {
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
        Component add = f.getContentPane().add(new PanelTaoCauHoi());
        f.setVisible(true);
    }
}
