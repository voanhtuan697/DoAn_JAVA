/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XULY;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.TableModel;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;

public class xuLyFileExcel {

    public void xuatExcel(JTable tbl) {
        try {
            TableModel dtm = tbl.getModel();

            JFileChooser chooser = new fileChooser("export/");
            chooser.setDialogTitle("Lưu vào");
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("Excel Files", "xls", "xlsx", "xlsm");
            chooser.setFileFilter(fnef);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                // Lấy đường dẫn vừa chọn + tên tệp
                String path = chooser.getSelectedFile().getPath();
                if (!path.contains(".xlsx")) {
                    path += ".xlsx";
                }

                XSSFWorkbook workbook = new XSSFWorkbook();
                Sheet sheet = workbook.createSheet("Sheet 1");

                Font headerFont = workbook.createFont();
                headerFont.setBold(true);
                headerFont.setFontHeightInPoints((short) 14);
                headerFont.setColor(IndexedColors.WHITE.getIndex());
                CellStyle headerCellStyle = workbook.createCellStyle();
                headerCellStyle.setFont(headerFont);

                headerCellStyle.setFillForegroundColor(IndexedColors.GREEN.getIndex()); // Sửa thành setFillForegroundColor()

                headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                headerCellStyle.setBorderTop(BorderStyle.THIN);
                headerCellStyle.setBorderBottom(BorderStyle.THIN);
                headerCellStyle.setBorderLeft(BorderStyle.THIN);
                headerCellStyle.setBorderRight(BorderStyle.THIN);
                headerCellStyle.setAlignment(HorizontalAlignment.CENTER);

                Row headerRow = sheet.createRow(0);

                // Tạo header
                for (int i = 0; i < dtm.getColumnCount(); i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(dtm.getColumnName(i));
                    cell.setCellStyle(headerCellStyle);
                    sheet.autoSizeColumn(i);
                }

                Font contentFont = workbook.createFont();
                contentFont.setBold(false);
                contentFont.setFontHeightInPoints((short) 13);
                contentFont.setColor(IndexedColors.BLACK.getIndex());
                CellStyle contentCellStyle = workbook.createCellStyle();
                contentCellStyle.setFont(contentFont);
                contentCellStyle.setBorderTop(BorderStyle.THIN);
                contentCellStyle.setBorderBottom(BorderStyle.THIN);
                contentCellStyle.setBorderLeft(BorderStyle.THIN);
                contentCellStyle.setBorderRight(BorderStyle.THIN);

                for (int i = 0; i < dtm.getRowCount(); i++) {
                    Row row = sheet.createRow(i + 1);
                    for (int j = 0; j < dtm.getColumnCount(); j++) {
                        Cell cell = row.createCell(j);
                        cell.setCellValue(dtm.getValueAt(i, j) + "");
                        cell.setCellStyle(contentCellStyle);
                        sheet.autoSizeColumn(j);
                    }
                }

                // Ghi file
                FileOutputStream fileOut = new FileOutputStream(path);
                workbook.write(fileOut);
                fileOut.close();
                workbook.close();

                new ShowDiaLog("Xuất file thành công!", ShowDiaLog.SUCCESS_DIALOG);
            }
        } catch (Exception e) {
            new ShowDiaLog("Xuất file thất bại!", ShowDiaLog.ERROR_DIALONG);
        }
    }

    public void nhapExcel(JTable tbl) {
        try {
            TableModel dtm = tbl.getModel();

            JFileChooser chooser = new JFileChooser("export/");
            chooser.setDialogTitle("Chọn file");
            FileNameExtensionFilter fnef = new FileNameExtensionFilter("Excel Files", "xls", "xlsx", "xlsm");
            chooser.setFileFilter(fnef);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                File fileSelected = chooser.getSelectedFile();
                FileInputStream fis = new FileInputStream(fileSelected);
                BufferedInputStream bis = new BufferedInputStream(fis);

                XSSFWorkbook wb = new XSSFWorkbook(bis);
                Sheet sheet = wb.getSheetAt(0);

                DefaultTableModel dtmtbl = (DefaultTableModel) dtm;
                dtmtbl.setRowCount(0);
                for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    if (row != null) {
                        Vector vec = new Vector();
                        for (int j = 0; j < row.getLastCellNum(); j++) {
                            Cell cell = row.getCell(j);
                            if (cell != null) {
                                // Kiểm tra kiểu dữ liệu của ô trước khi lấy giá trị
                                if (cell.getCellType() == CellType.NUMERIC) {
                                    // Xử lý các ô có kiểu dữ liệu số
                                    // Ở đây ta có thể chuyển giá trị số thành chuỗi nếu cần
                                    vec.add(String.valueOf(cell.getNumericCellValue()));
                                } else {
                                    // Xử lý các kiểu dữ liệu khác nếu cần
                                    // Trong ví dụ này, ta đang bỏ qua các ô có kiểu dữ liệu khác
                                    vec.add(cell.getStringCellValue());
                                }
                            } else {
                                vec.add(null);
                            }
                        }
                        dtmtbl.addRow(vec);
                    }
                }
                new ShowDiaLog("Nhập file thành công!", ShowDiaLog.SUCCESS_DIALOG);
            }
        } catch (IOException e) {
            e.printStackTrace();
            new ShowDiaLog("Nhập file thất bại! Không thể đọc file.", ShowDiaLog.ERROR_DIALONG);
        } catch (Exception e) {
            e.printStackTrace();
            new ShowDiaLog("Nhập file thất bại!", ShowDiaLog.ERROR_DIALONG);
        }
    }

}
