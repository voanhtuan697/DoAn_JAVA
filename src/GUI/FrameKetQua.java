
package GUI;

import java.awt.BorderLayout;
import static java.awt.Color.white;
import java.awt.Cursor;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import static GUI.BASE.dark_green;
import static GUI.BASE.font13;
import static GUI.BASE.font13b;
import static GUI.BASE.gray_bg;

public class FrameKetQua extends JFrame {

    private JPanel pnHeader, pnTable, pnInput;
    private JLabel[] lbl = new JLabel[5];
    private JTextField txtDiemTu, txtDiem;
    private JButton btnTimTheoDiem, btnXuat, btnVe;
    private DefaultTableModel model;
    private JRadioButton rdMax, rdMin, rdThi;
    private String[] lblContent = {"Môn thi:", "Đề thi:", "Điểm từ:", "Điểm", "Lớp:"};
    private JComboBox cbMonthi, cbDeThi, cbLop;

    public FrameKetQua() {
        init();
        initComponent();
        showLayout();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        pnHeader = new JPanel();
        pnHeader.setBackground(gray_bg);

        pnTable = new JPanel(new BorderLayout());

        pnInput = new JPanel();
        pnInput.setBackground(gray_bg);

        this.setLayout(new BorderLayout());
        this.add(pnHeader, BorderLayout.NORTH);
        this.add(pnTable, BorderLayout.CENTER);
        this.add(pnInput, BorderLayout.SOUTH);
    }

    private void initComponent() {

        Object[] columns = {"Mã thí sinh", "Họ và tên", "Điểm", "Lớp", "Môn"};
        Object[][] data = {{null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},
        {null, null, null, null, null},};

        model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);

        int[] columnWidths = {100, 200, 80, 100, 100};
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = table.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
        JScrollPane scrTabel = new JScrollPane(table);
        pnTable.add(scrTabel, BorderLayout.CENTER);

        for (int i = 0; i < lblContent.length; i++) {
            lbl[i] = new JLabel(lblContent[i]);
            lbl[i].setFont(font13);
        }

        cbMonthi = new JComboBox();
        cbDeThi = new JComboBox();
        cbLop = new JComboBox();

        txtDiemTu = new JTextField(20);
        txtDiem = new JTextField(20);

        rdMax = new JRadioButton("Điểm cao nhất");
        rdMax.setBackground(gray_bg);
        rdMax.setFont(font13);
        rdMin = new JRadioButton("Điểm thấp nhất");
        rdMin.setBackground(gray_bg);
        rdMin.setFont(font13);
        rdThi = new JRadioButton("Thi lại");
        rdThi.setBackground(gray_bg);
        rdThi.setFont(font13);
        ButtonGroup group = new ButtonGroup();
        group.add(rdMax);
        group.add(rdMin);
        group.add(rdThi);

        btnXuat = new JButton("Xuất Excel  ");
        btnXuat.setBackground(dark_green);
        btnXuat.setFont(font13b);
        btnXuat.setForeground(white);
        btnXuat.setBorderPainted(false);
        btnXuat.setFocusPainted(false);
        btnXuat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnVe = new JButton("Vẽ biểu đồ");
        btnVe.setBackground(dark_green);
        btnVe.setForeground(white);
        btnVe.setFont(font13b);
        btnVe.setBorderPainted(false);
        btnVe.setFocusPainted(false);
        btnVe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnTimTheoDiem = new JButton("Tìm theo điểm");
        btnTimTheoDiem.setBackground(dark_green);
        btnTimTheoDiem.setFont(font13b);
        btnTimTheoDiem.setForeground(white);
        btnTimTheoDiem.setBorderPainted(false);
        btnTimTheoDiem.setFocusPainted(false);
        btnTimTheoDiem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void showLayout() {
        GroupLayout layout = new GroupLayout(pnInput);
        pnInput.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lbl[0])
                        .addComponent(lbl[1])
                        .addComponent(lbl[4])
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(cbMonthi)
                        .addComponent(cbDeThi)
                        .addComponent(cbLop)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(rdMax)
                        .addComponent(rdMin)
                        .addComponent(rdThi)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lbl[2])
                        .addComponent(lbl[3])
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(txtDiemTu)
                        .addComponent(txtDiem)
                        .addComponent(btnTimTheoDiem)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(btnVe)
                        .addComponent(btnXuat)
                )
        );

        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lbl[0])
                        .addComponent(cbMonthi)
                        .addComponent(rdMax)
                        .addComponent(lbl[2])
                        .addComponent(txtDiemTu)
                        .addComponent(btnVe)
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(lbl[1])
                                .addComponent(cbDeThi)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(rdMin)
                                        .addComponent(lbl[3])
                                        .addComponent(txtDiem)
                                        .addComponent(btnXuat)
                                )
                        )
                )
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(lbl[4])
                        .addComponent(cbLop)
                        .addComponent(rdThi)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(btnTimTheoDiem)
                        )
                )
        );
    }

    public static void main(String[] args) {
        new FrameKetQua();
    }
}
