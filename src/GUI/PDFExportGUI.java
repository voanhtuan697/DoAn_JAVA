/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

/**
 *
 * @author Minh Phuc
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import XULY.writePDF;


public class PDFExportGUI extends JFrame implements ActionListener {
    private JButton exportButton;
    private JTextArea contentTextArea;
    private JTextField titleField;

    public PDFExportGUI() {
        setTitle("Export to PDF");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null); // Hiển thị cửa sổ ở giữa màn hình

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));

        // Tiêu đề
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Title: ");
        titleField = new JTextField(20);
        titlePanel.add(titleLabel);
        titlePanel.add(titleField);

        // Nội dung
        JPanel contentPanel = new JPanel();
        JLabel contentLabel = new JLabel("Content: ");
        contentTextArea = new JTextArea(10, 30);
        JScrollPane scrollPane = new JScrollPane(contentTextArea);
        contentPanel.add(contentLabel);
        contentPanel.add(scrollPane);

        // Nút export
        JPanel buttonPanel = new JPanel();
        exportButton = new JButton("Export PDF");
        exportButton.addActionListener(this);
        buttonPanel.add(exportButton);

        // Thêm các panel vào frame
        panel.add(titlePanel);
        panel.add(contentPanel);
        panel.add(buttonPanel);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exportButton) {
            String title = titleField.getText();
            String content = contentTextArea.getText();

            writePDF pdfWriter = new writePDF();
            pdfWriter.exportPDF(title, content);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PDFExportGUI().setVisible(true);
        });
    }
}