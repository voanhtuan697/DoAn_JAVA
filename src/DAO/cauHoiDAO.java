/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Minh Phuc
 */
import DTO.cauHoiDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connect.MyConnection;
import javax.swing.table.DefaultTableModel;

public class cauHoiDAO {

    private MyConnection myConnection;

    public cauHoiDAO() {
        try {
            myConnection = new MyConnection();
            myConnection.Connect();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Khong the ket noi den co so du lieu");
        }
    }

    // Thêm câu hỏi vào cơ sở dữ liệu
    public boolean themCauHoi(cauHoiDTO cauHoi) {
        try {
            String query = "INSERT INTO CAUHOI (MaCH, MaKho, MaHT, Noidung, DoKho, MaGV, TrangThai, Img) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = myConnection.preparedStatement(query);

            ps.setString(1, cauHoi.getMaCH());
            ps.setString(2, cauHoi.getMaKho());
            ps.setString(3, cauHoi.getMaHT());
            ps.setString(4, cauHoi.getNoidung());
            ps.setString(5, cauHoi.getDoKho());
            ps.setString(6, cauHoi.getMaGV());
            ps.setBoolean(7, cauHoi.isTrangThai());
            ps.setString(8, cauHoi.getImg());

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Khong the them");
            return false;
        }
    }

    // Sửa thông tin câu hỏi trong cơ sở dữ liệu
    public boolean suaCauHoi(cauHoiDTO cauHoi) {
        try {
            String query = "UPDATE CAUHOI SET MaKho = ?, MaHT = ?, Noidung = ?, DoKho = ?, MaGV = ?, TrangThai = ?, Img = ? WHERE MaCH = ?";
            PreparedStatement ps = myConnection.preparedStatement(query);

            ps.setString(1, cauHoi.getMaKho());
            ps.setString(2, cauHoi.getMaHT());
            ps.setString(3, cauHoi.getNoidung());
            ps.setString(4, cauHoi.getDoKho());
            ps.setString(5, cauHoi.getMaGV());
            ps.setBoolean(6, cauHoi.isTrangThai());
            ps.setString(7, cauHoi.getImg());
            ps.setString(8, cauHoi.getMaCH());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Cập nhật câu hỏi thành công.");
                return true;
            } else {
                System.out.println("Không có câu hỏi nào được cập nhật.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Không thể cập nhật câu hỏi.");
            return false;
        }
    }

    // Xóa câu hỏi khỏi cơ sở dữ liệu
    public boolean xoaCauHoi(String maCH) {
        try {
            String query = "DELETE FROM CAUHOI WHERE MaCH = ?";
            PreparedStatement ps = myConnection.preparedStatement(query);

            ps.setString(1, maCH);

            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Khong the xoa");
            return false;
        }
    }

    public void loadDataFromDatabase(DefaultTableModel model) {
        // Thực hiện truy vấn SQL để lấy dữ liệu từ bảng CAUHOI
        String query = "SELECT MaCH, MaGV, NoiDung, DoKho, MaHT, Img FROM CAUHOI";
        try {
            PreparedStatement ps = myConnection.preparedStatement(query);
            ResultSet rs = ps.executeQuery();

            // Xóa tất cả các hàng hiện có trong table model
            model.setRowCount(0);

            // Duyệt qua kết quả của truy vấn và thêm dữ liệu vào table model
            while (rs.next()) {
                String maCH = rs.getString("MaCH");
                String maGV = rs.getString("MaGV");
                String noiDung = rs.getString("NoiDung");
                String doKho = rs.getString("DoKho");
                String maHT = rs.getString("MaHT");
                String img = rs.getString("Img");

                // Tạo một hàng mới cho dữ liệu từ cơ sở dữ liệu
                Object[] newRow = {maCH, maGV, noiDung, doKho, maHT, img}; // Thêm dữ liệu ảnh vào hàng mới

                // Thêm hàng mới vào table model
                model.addRow(newRow);
            }

            // Đóng ResultSet và PreparedStatement
            rs.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
