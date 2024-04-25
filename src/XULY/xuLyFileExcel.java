/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XULY;

import java.io.FileOutputStream;
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
import org.apache.poi.ss.usermodel.FillPatternType;

public class xuLyFileExcel {

    public void xuatExcel(JTable tbl) {
        try {
            TableModel model = tbl.getModel();
            JFileChooser chooser = new fileChooser("export/");
            chooser.setDialogTitle("Save");
            FileNameExtensionFilter tnef = new FileNameExtensionFilter("Excel Files", "xls", "xlsx", "xlsm");
            chooser.setFileFilter(tnef);
            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

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
                headerCellStyle.setFillBackgroundColor(IndexedColors.GREEN.getIndex());
                headerCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
                headerCellStyle.setBorderTop(BorderStyle.THIN);
                headerCellStyle.setBorderBottom(BorderStyle.THIN);
                headerCellStyle.setBorderLeft(BorderStyle.THIN);
                headerCellStyle.setBorderRight(BorderStyle.THIN);
                headerCellStyle.setAlignment(HorizontalAlignment.CENTER);

                Row headerRow = sheet.createRow(0);

                for (int i = 0; i < model.getColumnCount(); i++) {
                    Cell cell = headerRow.createCell(i);
                    cell.setCellValue(model.getColumnName(i));
                    cell.setCellStyle(headerCellStyle);
                }

                Font connectFont = workbook.createFont();
                connectFont.setBold(false);
                connectFont.setFontHeight((short) 13);
                connectFont.setColor(IndexedColors.BLACK.getIndex());
                CellStyle conntentCellStyle = workbook.createCellStyle();
                conntentCellStyle.setFont(connectFont);
                conntentCellStyle.setBorderBottom(BorderStyle.THIN);
                conntentCellStyle.setBorderTop(BorderStyle.THIN);
                conntentCellStyle.setBorderLeft(BorderStyle.THIN);
                conntentCellStyle.setBorderRight(BorderStyle.THIN);

                for (int i = 0; i < model.getRowCount(); i++) {
                    Row row = sheet.createRow(i + 1);
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        Cell cell = row.createCell(j);
                        cell.setCellValue(model.getValueAt(i, j) + "");
                        cell.setCellStyle(conntentCellStyle);
                        sheet.autoSizeColumn(j);
                    }
                }

                FileOutputStream fileOut = new FileOutputStream(path);
                workbook.write(fileOut);
                fileOut.close();
                workbook.close();
                new ShowDiaLog("xuat file thanh cong", ShowDiaLog.SUCCESS_DIALOG);
            }
        } catch (Exception e) {
            new ShowDiaLog("xuat file that bai", ShowDiaLog.ERROR_DIALONG);
        }
    }
}
