package GUI;

import BUS.deThiBUS2;
import BUS.ketQuaBUS2;
import BUS.lopBUS2;
import BUS.monBUS2;
import DTO.deThiDTO;
import DTO.ketQuaDTO;
import DTO.lopDTO;
import DTO.monDTO;
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
import static GUI.BASE.dark_green;
import static GUI.BASE.font14;
import static GUI.BASE.font16;
import static GUI.BASE.font14b;
import static GUI.BASE.gray_bg;
import XULY.ShowDiaLog;
import XULY.xuLyFileExcel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class PnKetQua extends JPanel {

    private JPanel pnHeader, pnTable, pnInput;
    private JLabel[] lbl = new JLabel[5];
    private JTextField txtDiemTu, txtDiem;
    private JButton btnTimTheoDiem, btnXuat, btnVe;
    private DefaultTableModel model;
    private JRadioButton rdMax, rdMin, rdThi;
    private String[] lblContent = {"Môn thi:", "Đề thi:", "Điểm từ:", "Điểm", "Lớp:"};
    private JComboBox cbMonthi, cbDeThi, cbLop;
    private JTable table;
    private ButtonGroup group;
    private ketQuaBUS2 busKQ = new ketQuaBUS2();
    private monBUS2 busMon = new monBUS2();
    private deThiBUS2 busThi = new deThiBUS2();
    private lopBUS2 busLop = new lopBUS2();

    public PnKetQua() {
        init();
        initComponent();
        showLayout();
        loadData();
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
        Object[][] data = {};

        model = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(model);
        setTableFont(table);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        JScrollPane scrTabel = new JScrollPane(table);
        pnTable.add(scrTabel, BorderLayout.CENTER);

        for (int i = 0; i < lblContent.length; i++) {
            lbl[i] = new JLabel(lblContent[i]);
            lbl[i].setFont(font16);
        }

        cbMonthi = new JComboBox();
        cbDeThi = new JComboBox();
        cbLop = new JComboBox();

        txtDiemTu = new JTextField(20);
        txtDiem = new JTextField(20);

        rdMax = new JRadioButton("Điểm cao nhất");
        rdMax.setBackground(gray_bg);
        rdMax.setFont(font16);
        rdMin = new JRadioButton("Điểm thấp nhất");
        rdMin.setBackground(gray_bg);
        rdMin.setFont(font16);
        rdThi = new JRadioButton("Thi lại");
        rdThi.setBackground(gray_bg);
        rdThi.setFont(font16);
        group = new ButtonGroup();
        group.add(rdMax);
        group.add(rdMin);
        group.add(rdThi);

        btnXuat = new JButton("Xuất Excel  ");
        btnXuat.setBackground(dark_green);
        btnXuat.setFont(font14b);
        btnXuat.setForeground(white);
        btnXuat.setBorderPainted(false);
        btnXuat.setFocusPainted(false);
        btnXuat.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnVe = new JButton("Xuất PDF     ");
        btnVe.setBackground(dark_green);
        btnVe.setForeground(white);
        btnVe.setFont(font14b);
        btnVe.setBorderPainted(false);
        btnVe.setFocusPainted(false);
        btnVe.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnTimTheoDiem = new JButton("Tìm theo điểm");
        btnTimTheoDiem.setBackground(dark_green);
        btnTimTheoDiem.setFont(font14b);
        btnTimTheoDiem.setForeground(white);
        btnTimTheoDiem.setBorderPainted(false);
        btnTimTheoDiem.setFocusPainted(false);
        btnTimTheoDiem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        btnXuat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                xuatExcel();
            }
        });

        cbMonthi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tenMon = cbMonthi.getSelectedItem() + "";
                String MaMon = busMon.getMaMonByName(tenMon);
                if (MaMon != null) {
                    cbDeThi.removeAllItems();
                    cbLop.removeAllItems();

                    ArrayList<lopDTO> listLop = busLop.getDSMaLop(MaMon);
                    for (lopDTO l : listLop) {
                        cbLop.addItem(l.getMaLop());
                    }

                    ArrayList<deThiDTO> listDe = busThi.getDSMaDT(MaMon);
                    for (deThiDTO d : listDe) {
                        cbDeThi.addItem(d.getMaDT());
                    }
                    getDaTaTable();
                }
            }
        });

        cbDeThi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDaTaTable();
            }
        });
        cbLop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDaTaTable();
            }
        });

        rdMax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDanhSachMax();
            }
        });

        rdMin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDanhSachMin();
            }
        });

        rdThi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDanhSachTruot();
            }
        });

        btnTimTheoDiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getDanhSachKhoang();
                txtDiem.setText("");
                txtDiemTu.setText("");
            }
        });
    }

    private void setTableFont(JTable table) {
        table.setFont(font14);

        JTableHeader header = table.getTableHeader();
        header.setFont(font14);

        DefaultTableCellRenderer renderer = new DefaultTableCellRenderer();
        renderer.setFont(font14);
        table.setDefaultRenderer(Object.class, renderer);
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

    private void loadData() {
        setLoad();
        cbMonthi.removeAllItems();
        ArrayList<monDTO> listMon = busMon.getList();
        for (monDTO m : listMon) {
            cbMonthi.addItem(m.getTenMon());
        }
    }

    private void getDaTaTable() {
        String TenMon = cbMonthi.getSelectedItem() + "";
        String MaDT = cbDeThi.getSelectedItem() + "";
        String MaLop = cbLop.getSelectedItem() + "";

        model.setRowCount(0);
        ArrayList<ketQuaDTO> listTK = busKQ.DanhSach(TenMon, MaDT, MaLop);
        for (ketQuaDTO k : listTK) {
            Object[] row = {k.getNgDungDTO().getMaUser(), k.getNgDungDTO().getHoTen(), k.getDiem(), k.getLopDTO().getMaLop(), k.getLopDTO().getMonDTO().getTenMon()};
            model.addRow(row);
        }
    }

    private void getDanhSachMax() {
        setLoad();
        String TenMon = cbMonthi.getSelectedItem() + "";
        String MaDT = cbDeThi.getSelectedItem() + "";
        String MaLop = cbLop.getSelectedItem() + "";

        model.setRowCount(0);
        ArrayList<ketQuaDTO> listTK = busKQ.DanhSachMax(TenMon, MaDT, MaLop);
        for (ketQuaDTO k : listTK) {
            Object[] row = {k.getNgDungDTO().getMaUser(), k.getNgDungDTO().getHoTen(), k.getDiem(), k.getLopDTO().getMaLop(), k.getLopDTO().getMonDTO().getTenMon()};
            model.addRow(row);
        }
    }

    private void getDanhSachMin() {
        setLoad();
        String TenMon = cbMonthi.getSelectedItem() + "";
        String MaDT = cbDeThi.getSelectedItem() + "";
        String MaLop = cbLop.getSelectedItem() + "";

        model.setRowCount(0);
        ArrayList<ketQuaDTO> listTK = busKQ.DanhSachMin(TenMon, MaDT, MaLop);
        for (ketQuaDTO k : listTK) {
            Object[] row = {k.getNgDungDTO().getMaUser(), k.getNgDungDTO().getHoTen(), k.getDiem(), k.getLopDTO().getMaLop(), k.getLopDTO().getMonDTO().getTenMon()};
            model.addRow(row);
        }
    }

    private void getDanhSachTruot() {
        setLoad();
        String TenMon = cbMonthi.getSelectedItem() + "";
        String MaDT = cbDeThi.getSelectedItem() + "";
        String MaLop = cbLop.getSelectedItem() + "";

        model.setRowCount(0);
        ArrayList<ketQuaDTO> listTK = busKQ.DanhSachTruot(TenMon, MaDT, MaLop);
        for (ketQuaDTO k : listTK) {
            Object[] row = {k.getNgDungDTO().getMaUser(), k.getNgDungDTO().getHoTen(), k.getDiem(), k.getLopDTO().getMaLop(), k.getLopDTO().getMonDTO().getTenMon()};
            model.addRow(row);
        }
    }

    private void getDanhSachKhoang() {
        String TenMon = cbMonthi.getSelectedItem() + "";
        String MaDT = cbDeThi.getSelectedItem() + "";
        String MaLop = cbLop.getSelectedItem() + "";
        float start, end;

        if (txtDiem.getText().isEmpty() && txtDiemTu.getText().isEmpty()) {
            txtDiemTu.requestFocus();
            new ShowDiaLog("Không được bỏ trống", ShowDiaLog.ERROR_DIALOG);
            return;
        } else if (txtDiem.getText().isEmpty()) {
            txtDiem.requestFocus();
            new ShowDiaLog("Không được bỏ trống", ShowDiaLog.ERROR_DIALOG);
            return;
        } else if (txtDiemTu.getText().isEmpty()) {
            txtDiemTu.requestFocus();
            new ShowDiaLog("Không được bỏ trống", ShowDiaLog.ERROR_DIALOG);
            return;
        }

        try {
            start = Float.parseFloat(txtDiemTu.getText());
            end = Float.parseFloat(txtDiem.getText());
        } catch (NumberFormatException e) {
            new ShowDiaLog("Điểm phải là số", ShowDiaLog.ERROR_DIALOG);
            return;
        }

        if (start < 0 || start > 10 || end < 0 || end > 10) {
            txtDiemTu.requestFocus();
            new ShowDiaLog("Điểm phải trong khoảng từ 0 đến 10", ShowDiaLog.ERROR_DIALOG);
        } else if (start > end) {
            new ShowDiaLog("Chọn khoảng không hợp lệ", ShowDiaLog.ERROR_DIALOG);
            txtDiemTu.requestFocus();
        } else {
            model.setRowCount(0);
            ArrayList<ketQuaDTO> listTK = busKQ.DanhSachKhoang(TenMon, MaDT, MaLop, start, end);
            for (ketQuaDTO k : listTK) {
                Object[] row = {k.getNgDungDTO().getMaUser(), k.getNgDungDTO().getHoTen(), k.getDiem(), k.getLopDTO().getMaLop(), k.getLopDTO().getMonDTO().getTenMon()};
                model.addRow(row);
            }
        }
    }

    private void setLoad() {
        txtDiem.setText("");
        txtDiemTu.setText("");
    }

    private void xuatExcel() {
        xuLyFileExcel file = new xuLyFileExcel();
        file.xuatExcel(table);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(950, 450);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        PnKetQua p = new PnKetQua();
        f.getContentPane().setLayout(new BorderLayout());
        f.add(p);
        f.setVisible(true);
    }
}
