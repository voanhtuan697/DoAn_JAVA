/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XULY;

/**
 *
 * @author Minh Phuc
 */
import DAO.ketQuaDAO;
import DTO.ketQuaDTO;
import com.itextpdf.text.Chunk;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JButton;

public class writePDF {

    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
    Document document = new Document();
    FileOutputStream file;
    JFrame jf = new JFrame();
    FileDialog fd = new FileDialog(jf, "Xuất pdf", FileDialog.SAVE);
    Font font10;
    Font font15b;
    Font font25b;
    Font font15i;
    private Font fontBold25;
    private Font fontNormal10;
    private Font fontBold15;

    public writePDF() {
        try {
            font10 = new Font(BaseFont.createFont("font/TimesNewRoman/SVN-Times New Roman.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 12, Font.NORMAL);
            font25b = new Font(BaseFont.createFont("font/TimesNewRoman/SVN-Times New Roman Bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, Font.NORMAL);
            font15b = new Font(BaseFont.createFont("font/TimesNewRoman/SVN-Times New Roman Bold.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 15, Font.NORMAL);
            font15i = new Font(BaseFont.createFont("font/TimesNewRoman/SVN-Times New Roman Bold Italic.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 15, Font.NORMAL);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(writePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void exportPDF(String title, String content) {
        try {
            String url = getFile(title + ".pdf");
            if (url == null) {
                return;
            }
            chooseURL(url);
            setTitle(title);

            // Thêm nội dung vào tài liệu PDF (sau này cần in gì sẽ bổ sung form để lấy dữ liệu cho dạng in đó)
            Paragraph paragraph = new Paragraph(new Phrase(content, font15b));
            document.add(paragraph);

            document.close();
            openFile(url);
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }

    public void chooseURL(String url) {
        try {
            document.close();
            document = new Document();
            file = new FileOutputStream(url);
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
        } catch (FileNotFoundException ex) {
            String errorMessage = "Không thể tìm thấy đường dẫn file " + url;
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi khi ghi file", JOptionPane.ERROR_MESSAGE);
        } catch (DocumentException ex) {
            String errorMessage = "Không thể tạo tài liệu PDF";
            JOptionPane.showMessageDialog(null, errorMessage, "Lỗi khi ghi file", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void setTitle(String title) {
        try {
            Paragraph pdfTitle = new Paragraph(new Phrase(title, font25b));
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdfTitle);
            document.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }

    private String getFile(String name) {
        fd.pack();
        fd.setSize(800, 600);
        fd.validate();
        Rectangle rect = jf.getContentPane().getBounds();
        double width = fd.getBounds().getWidth();
        double height = fd.getBounds().getHeight();
        double x = rect.getCenterX() - (width / 2);
        double y = rect.getCenterY() - (height / 2);
        Point leftCorner = new Point();
        leftCorner.setLocation(x, y);
        fd.setLocation(leftCorner);
        fd.setFile(name);
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("null")) {
            return null;
        }
        return url;
    }

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static Chunk createWhiteSpace(int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            builder.append(" ");
        }
        return new Chunk(builder.toString());
    }

    public void writeKetQua(String maKetQua, String tenMon, String maDT, String maLop, ketQuaDAO dao) {
        String url = "";
        try {
            fd.setTitle("In kết quả thi");
            fd.setLocationRelativeTo(null);
            url = getFile(maKetQua + "");
            if (url.equals("nullnull")) {
                return;
            }
            url = url + ".pdf";
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            Paragraph title = new Paragraph("KẾT QUẢ THI", fontBold25);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(Chunk.NEWLINE);

            // Truy vấn danh sách kết quả từ DAO
            ArrayList<ketQuaDTO> list = dao.DanhSach(tenMon, maDT, maLop);

            if (list.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Không tìm thấy thông tin kết quả thi");
                return;
            }

            boolean userInfoAdded = false; // Biến để kiểm tra xem thông tin người dùng đã được thêm vào tài liệu chưa

            // Thêm thông tin kết quả thi vào file PDF
            for (ketQuaDTO ketQua : list) {
                if (!userInfoAdded) { // Nếu thông tin người dùng chưa được thêm vào
                    // Thêm thông tin người dùng vào file PDF
                    Paragraph maNguoiDungPara = new Paragraph("Mã người dùng: " + ketQua.getNgDungDTO().getMaUser(), fontNormal10);
                    document.add(maNguoiDungPara);

                    Paragraph hoTenPara = new Paragraph("Họ tên: " + ketQua.getNgDungDTO().getHoTen(), fontNormal10);
                    document.add(hoTenPara);

                    Paragraph maLopPara = new Paragraph("Mã lớp: " + maLop, fontNormal10);
                    document.add(maLopPara);
                    document.add(Chunk.NEWLINE);

                    userInfoAdded = true; // Đánh dấu là thông tin người dùng đã được thêm vào
                }

                // Thêm thông tin kết quả thi vào file PDF
                Paragraph maKetQuaPara = new Paragraph("Mã kết quả: " + ketQua.getMaKQ(), fontNormal10);
                document.add(maKetQuaPara);

                Paragraph maDeThiPara = new Paragraph("Mã đề thi: " + ketQua.getMaDT(), fontNormal10);
                document.add(maDeThiPara);

                Paragraph monThiPara = new Paragraph("Môn thi: " + tenMon, fontNormal10);
                document.add(monThiPara);

                Paragraph ngayThiPara = new Paragraph("Thời gian thi: " + ketQua.getTGLamXong(), fontNormal10);
                document.add(ngayThiPara);
                document.add(Chunk.NEWLINE);

                // Thêm bảng điểm vào file PDF
                PdfPTable table = new PdfPTable(2);
                table.setWidthPercentage(100);
                table.setWidths(new float[]{50f, 50f});

                PdfPCell cell;

                cell = new PdfPCell(new Phrase("Số câu đúng", fontBold15));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setMinimumHeight(25f);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase("Điểm", fontBold15));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setMinimumHeight(25f);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(ketQua.getSLCauDung()), fontNormal10));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setMinimumHeight(25f);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(ketQua.getDiem()), fontNormal10));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setMinimumHeight(25f);
                table.addCell(cell);

                document.add(table);
                document.add(Chunk.NEWLINE); // Add a new line between ketQuaDTO objects
            }

            document.close();
            writer.close();
            openFile(url);
        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Lỗi khi ghi file " + url);
        }
    }

}
