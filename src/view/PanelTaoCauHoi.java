/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import model.DisabledTableCellRenderer;

/**
 *
 * @author E7250
 */
public class PanelTaoCauHoi extends JPanel{
    private JComboBox<String> cbb_monThi;
    private JComboBox<String> cbb_trangThaiCH;
    private DefaultTableModel model;

    public PanelTaoCauHoi() {
        init();
    }

    public void init() {
        JPanel pn1 = new JPanel();
        pn1.setBackground(Color.BLUE);
        pn1.setMaximumSize(new Dimension(2000, 50));
        GroupLayout layoutPn1 = new GroupLayout(pn1);
        pn1.setLayout(layoutPn1);
        layoutPn1.setAutoCreateGaps(true);
        layoutPn1.setAutoCreateContainerGaps(true);

        JLabel lb_cbbMonThi = new JLabel("Tên môn:");
        String[] cacMonChinh = new String[]{"Toán", "Lý", "Sử", "Địa"};
        cbb_monThi = new JComboBox<>(cacMonChinh);
//        Thêm môn
        cbb_monThi.addItem("Tiếng anh");
        cbb_monThi.setMaximumSize(new Dimension(200, 0));

        JLabel lb_cbbTrangThaiCH = new JLabel("Trạng thái:");
        String[] kiemDuyetCH = new String[]{"Đã duyệt", "Chưa duyệt"};
        cbb_trangThaiCH = new JComboBox<>(kiemDuyetCH);
        cbb_trangThaiCH.setMaximumSize(new Dimension(200, 0));

        layoutPn1.setHorizontalGroup(
                layoutPn1.createSequentialGroup()
                        .addComponent(lb_cbbMonThi)
                        .addComponent(cbb_monThi)
                        .addComponent(lb_cbbTrangThaiCH)
                        .addComponent(cbb_trangThaiCH)
        );

        layoutPn1.setVerticalGroup(
                layoutPn1.createSequentialGroup()
                        .addGroup(layoutPn1.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(lb_cbbMonThi)
                                .addComponent(cbb_monThi)
                                .addComponent(lb_cbbTrangThaiCH)
                                .addComponent(cbb_trangThaiCH))
        );

        JPanel pn2 = new JPanel();
        pn2.setPreferredSize(new Dimension(0, 270));
        pn2.setLayout(new BorderLayout());

        Object[][] data = {
            {"CH1", "GV1", "Who are you?Who are you?", "Dễ"},
            {"CH1", "GV2", "Where do you do?", "Khó"},
            {"CH1", "GV3", "Will you marry me?", "Trung Bình"},
            {"CH1", "GV1", "Who are you?Who are you?", "Dễ"},
            {"CH1", "GV2", "Where do you do?", "Khó"},
            {"CH1", "GV3", "Will you marry me?", "Trung Bình"},
            {"CH1", "GV1", "Who are you?Who are you?", "Dễ"},
            {"CH1", "GV2", "Where do you do?", "Khó"},
            {"CH1", "GV3", "Will you marry me?", "Trung Bình"},
            {"CH1", "GV1", "Who are you?Who are you?", "Dễ"},
            {"CH1", "GV2", "Where do you do?", "Khó"},
            {"CH1", "GV3", "Will you marry me?", "Trung Bình"},
            {"CH1", "GV1", "Who are you?Who are you?", "Dễ"},
            {"CH1", "GV2", "Where do you do?", "Khó"},
            {"CH1", "GV3", "Will you marry me?", "Trung Bình"},
            {"CH1", "GV3", "Will you marry me?", "Trung Bình"},};

        // Tạo tiêu đề cho bảng
        Object[] columns = {"Mã câu hỏi", "Mã giảng viên", "Nội dung", "Độ khó"};
        model = new DefaultTableModel(data, columns);

//        Không cho người dùng tác động
        JTable table = new JTable(model) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };;

        // Thiết lập renderer cho tất cả các cột
        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new DisabledTableCellRenderer());
        }
//        set chiều ngang cho cột
        TableColumnModel columnModel = table.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(60); // Mã câu hỏi
        columnModel.getColumn(1).setPreferredWidth(80); // Mã giảng viên
        columnModel.getColumn(2).setPreferredWidth(1000); // Nội dung
        columnModel.getColumn(3).setPreferredWidth(70); // Độ khó

        JScrollPane scrollPane_table = new JScrollPane(table);
        scrollPane_table.setPreferredSize(new Dimension(0, 270));
        pn2.add(scrollPane_table, BorderLayout.CENTER);

        JPanel pn3 = new JPanel();
        pn3.setPreferredSize(new Dimension(0, 380));
        GroupLayout layoutPn3 = new GroupLayout(pn3);
        pn3.setLayout(layoutPn3);

        JPanel pn3_input = new JPanel();
        pn3_input.setPreferredSize(new Dimension(700, 0));

        JPanel pn_lb_cauhoi = new JPanel();
        pn_lb_cauhoi.setPreferredSize(new Dimension(0, 5));
        pn_lb_cauhoi.setBackground(Color.red);
        pn_lb_cauhoi.setLayout(new BorderLayout());
        JLabel lb_cauhoi = new JLabel("Nội dung câu hỏi");
        pn_lb_cauhoi.add(lb_cauhoi, BorderLayout.WEST);

        JPanel pn_cauhoi = new JPanel();
        pn_cauhoi.setPreferredSize(new Dimension(0, 50));
        pn_cauhoi.setLayout(new BorderLayout());
        JTextArea txta = new JTextArea();
        txta.setLineWrap(true);// tự động xuống hàng khi văn bản quá dài

        JScrollPane scrollPane_cauhoi = new JScrollPane(txta);
        pn_cauhoi.add(scrollPane_cauhoi, BorderLayout.CENTER);

        JPanel pn_lb_cautraloi = new JPanel();
        pn_lb_cautraloi.setPreferredSize(new Dimension(0, 5));
        pn_lb_cautraloi.setBackground(Color.pink);
        pn_lb_cautraloi.setLayout(new BorderLayout());
        JLabel lb_cautraloi = new JLabel("Các câu trả lời");
        pn_lb_cautraloi.add(lb_cautraloi, BorderLayout.WEST);

        JPanel pn_cautraloi = new JPanel();
        pn_cautraloi.setPreferredSize(new Dimension(0, 180));
        pn_cautraloi.setBackground(Color.gray);
        GroupLayout layout_cauTraLoi = new GroupLayout(pn_cautraloi);
        pn_cautraloi.setLayout(layout_cauTraLoi);
        layout_cauTraLoi.setAutoCreateGaps(true);
        layout_cauTraLoi.setAutoCreateContainerGaps(true);

        JLabel lb_a = new JLabel("A");
        JLabel lb_b = new JLabel("B");
        JLabel lb_c = new JLabel("C");
        JLabel lb_d = new JLabel("D");

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

        JPanel pn_img = new JPanel();
        pn_img.setPreferredSize(new Dimension(0, 15));
        pn_img.setBackground(Color.green);
        pn_img.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 3));

        JLabel lb_img = new JLabel("Hinh anh:");
        JButton btn_img = new JButton("Upload Image");
        pn_img.add(lb_img);
        pn_img.add(btn_img);

        JPanel pn_doKho = new JPanel();
        pn_doKho.setPreferredSize(new Dimension(0, 15));
        pn_doKho.setBackground(Color.orange);
        JLabel lb_doKho = new JLabel("Do kho:");
        pn_doKho.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 3));

        ButtonGroup btnG_DoKho = new ButtonGroup();

        JRadioButton rdb_easy = new JRadioButton();
        rdb_easy.setOpaque(false);
        JLabel lb_easy = new JLabel("De");

        JRadioButton rdb_medium = new JRadioButton();
        rdb_medium.setOpaque(false);
        JLabel lb_medium = new JLabel("Trung binh");

        JRadioButton rdb_hard = new JRadioButton();
        rdb_hard.setOpaque(false);
        JLabel lb_hard = new JLabel("Kho");

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
        pn3_btn.setMaximumSize(new Dimension(100, 500));
        pn3_btn.setBackground(Color.yellow);
        GroupLayout layout_btn = new GroupLayout(pn3_btn);
        pn3_btn.setLayout(layout_btn);
        layout_btn.setAutoCreateGaps(true);
        layout_btn.setAutoCreateContainerGaps(true);

        JButton btn1 = new JButton("Button 1");
        btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JButton btn2 = new JButton("Button 2");
        btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JButton btn3 = new JButton("Button 3");
        btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JButton btn4 = new JButton("Button 4");
        btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JButton btn5 = new JButton("Button 5");
        btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        JButton btn6 = new JButton("Button 6");
        btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        layout_btn.setHorizontalGroup(
                layout_btn.createSequentialGroup()
                        .addGroup(layout_btn.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(btn1)
                                .addComponent(btn2)
                                .addComponent(btn3)
                                .addComponent(btn4)
                                .addComponent(btn5)
                                .addComponent(btn6))
        );

        layout_btn.setVerticalGroup(
                layout_btn.createSequentialGroup()
                        .addComponent(btn1)
                        .addGap(40)
                        .addComponent(btn2)
                        .addGap(40)
                        .addComponent(btn3)
                        .addGap(40)
                        .addComponent(btn4)
                        .addGap(40)
                        .addComponent(btn5)
                        .addGap(40)
                        .addComponent(btn6)
        );

        layoutPn3.setHorizontalGroup(
                layoutPn3.createSequentialGroup()
                        .addComponent(pn3_input)
                        .addComponent(pn3_btn)
        );

        layoutPn3.setVerticalGroup(
                layoutPn3.createSequentialGroup()
                        .addGroup(layoutPn3.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(pn3_input)
                                .addComponent(pn3_btn))
        );

        GroupLayout layoutMain = new GroupLayout(this);
        this.setLayout(layoutMain);

//        layout.setAutoCreateGaps(true);
//        layout.setAutoCreateContainerGaps(true);
        layoutMain.setHorizontalGroup(
                layoutMain.createSequentialGroup()
                        .addGroup(layoutMain.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(pn1)
                                .addComponent(pn2)
                                .addComponent(pn3))
        );

        layoutMain.setVerticalGroup(
                layoutMain.createSequentialGroup()
                        .addComponent(pn1)
                        .addComponent(pn2)
                        .addComponent(pn3)
        );
    }
}
