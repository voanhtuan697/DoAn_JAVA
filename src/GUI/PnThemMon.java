/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JButton;
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
public class PnThemMon extends JPanel {
    
    private DefaultTableModel model;
    
    public PnThemMon() {
        init();
    }
    
    public void init(){
        this.setLayout(new BorderLayout());
        
        JPanel pnSearch = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        pnSearch.setBackground(Color.decode("#B3BECB"));
        
        JLabel lblSearch = new JLabel("Tìm kiếm");
        lblSearch.setFont(new Font("Arial", Font.PLAIN, 13));
        JTextField txtSearch = new JTextField(15);
        pnSearch.add(lblSearch);
        pnSearch.add(txtSearch);
        
        JPanel pn_table = new JPanel();
        pn_table.setLayout(new BorderLayout());
        
        Object[] columns = {"Ma mon","Ten Mon"};
        Object[][] data = {{null, null},
            
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
        
        JPanel pn_input = new JPanel(new FlowLayout(0,10,10));
        
        JLabel lb_mon = new JLabel("Ten mon");
        JTextField txt_mon = new JTextField(20);
        
        pn_input.add(lb_mon);
        pn_input.add(txt_mon);

        String []btn_name = new String[]{"Them","Xoa","Sua"};
        for(int i=0;i<3;i++){
            JButton btn = new JButton(btn_name[i]);
            pn_input.add(btn);
        }
        
        
        
        this.add(pnSearch,BorderLayout.NORTH);
        this.add(pn_table,BorderLayout.CENTER);
        this.add(pn_input,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        PnThemMon b = new PnThemMon();
        f.add(b);
        f.setSize(800, 500);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setLocationRelativeTo(null);
    }
}
