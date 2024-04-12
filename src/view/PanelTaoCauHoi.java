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
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
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
import model.DisabledTableCellRenderer;
import static view.base.cobalt_blue;
import static view.base.dark_green;
import static view.base.font13;
import static view.base.white;

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
        pn1.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pn1.setPreferredSize(new Dimension(0, 40));
        pn1.setLayout(new FlowLayout(FlowLayout.LEFT,20, 10));

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
        
        pn1.add(lb_cbbMonThi);
        pn1.add(cbb_monThi);
        pn1.add(lb_cbbTrangThaiCH);
        pn1.add(cbb_trangThaiCH);
        
//-------------------------------------------------PANEL2------------------------------------------------------------
        JPanel pn2 = new JPanel();
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
            };

        // Tạo tiêu đề cho bảng
        Object[] columns = {"Mã câu hỏi", "Mã giảng viên", "Nội dung", "Độ khó","Ảnh"};
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
        pn_lb_cauhoi.setLayout(new FlowLayout(FlowLayout.LEFT,10,3));
        JLabel lb_cauhoi = new JLabel("Nội dung câu hỏi");
        lb_cauhoi.setFont(font13);
        pn_lb_cauhoi.add(lb_cauhoi);

        JPanel pn_cauhoi = new JPanel();
        pn_cauhoi.setPreferredSize(new Dimension(0, 50));
        pn_cauhoi.setLayout(new BorderLayout());
        JTextArea txta = new JTextArea();
        txta.setLineWrap(true);// tự động xuống hàng khi văn bản quá dài

        JScrollPane scrollPane_cauhoi = new JScrollPane(txta);
        pn_cauhoi.add(scrollPane_cauhoi, BorderLayout.CENTER);

        JPanel pn_lb_cautraloi = new JPanel();
        pn_lb_cautraloi.setMaximumSize(new Dimension(1300, 10));
        pn_lb_cautraloi.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pn_lb_cautraloi.setLayout(new FlowLayout(FlowLayout.LEFT,10,3));
        JLabel lb_cautraloi = new JLabel("Các câu trả lời");
        lb_cautraloi.setFont(font13);
        pn_lb_cautraloi.add(lb_cautraloi);

        JPanel pn_cautraloi = new JPanel();
        pn_cautraloi.setPreferredSize(new Dimension(0, 700));
        pn_cautraloi.setBackground(new Color(0xB3, 0xBE, 0xCB));
        GroupLayout layout_cauTraLoi = new GroupLayout(pn_cautraloi);
        pn_cautraloi.setLayout(layout_cauTraLoi);
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

        JPanel pn_img = new JPanel();
        pn_img.setMaximumSize(new Dimension(1300, 10));
        pn_img.setBackground(new Color(0xB3, 0xBE, 0xCB));
        pn_img.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 5));

        JLabel lb_img = new JLabel("Hình ảnh:");
        lb_img.setFont(font13);
        JButton btn_img = new JButton("Upload Image");
        pn_img.add(lb_img);
        pn_img.add(btn_img);

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
        pn3_btn.setLayout(new FlowLayout(FlowLayout.CENTER,10,20));
        
        String []name_btn = new String[]{"Thêm","Xóa","Sửa","Nhập Excel","Xuất Excel","Chi tiết"};
        String[] name_image = new String[]{"plus_icon.png", "delete_icon.png", "edit_icon.png"};
        for(int i=0;i<name_btn.length;i++){
            JButton btn = new JButton(name_btn[i]);
            btn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            btn.setBorderPainted(false);
            btn.setFocusPainted(false);
            if(i<3){
                btn.setIcon(new ImageIcon(new ImageIcon(Toolkit.getDefaultToolkit().createImage(MenuFrameGV.class.getResource("..//image//"+name_image[i]))).getImage().getScaledInstance(20, 20,Image.SCALE_SMOOTH)));
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
        
        
        
        

        pn3.add(pn3_input,BorderLayout.CENTER);
        pn3.add(pn3_btn,BorderLayout.EAST);

        this.setLayout(new BorderLayout());
        this.add(pn1,BorderLayout.NORTH);
        this.add(pn2,BorderLayout.CENTER);
        this.add(pn3,BorderLayout.SOUTH);
    }
}
