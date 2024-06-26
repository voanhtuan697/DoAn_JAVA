/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.cauHoiDTO;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PHUNG
 */
public class cauHoiDAO {

    private MyConnection conn;

    public cauHoiDAO() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }

    public ArrayList<cauHoiDTO> layDanhSachCauHoi() throws SQLException {
        ArrayList<cauHoiDTO> arr = new ArrayList<>();
        String sql = "SELECT * FROM cauhoi";
        PreparedStatement stmt = conn.preparedStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            cauHoiDTO ch = new cauHoiDTO();
            ch.setMaCH(rs.getString(1));
            ch.setMaKho(rs.getString(2));
            ch.setMaHT(rs.getString(3));
            ch.setNoidung(rs.getString(4));
            ch.setDoKho(rs.getString(5));
            ch.setMaGV(rs.getString(6));
            ch.setTrangThai(rs.getBoolean(7));
            ch.setImg(rs.getString(8));
            arr.add(ch);
        }
        return arr;
    }

    public String layMaCHTheoNoiDung(String noiDung) throws SQLException {
        String sql = "SELECT MaCH FROM cauhoi WHERE NoiDung = ?";
        PreparedStatement stmt = conn.preparedStatement(sql);
        stmt.setString(1, noiDung);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString(1);
        }
        return null;
    }
    
    public boolean themCauHoi(cauHoiDTO cauHoi) {
        try {
            String query = "INSERT INTO CAUHOI (MaCH, MaKho, MaHT, Noidung, DoKho, MaGV, TrangThai, Img) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.preparedStatement(query);

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
            PreparedStatement ps = conn.preparedStatement(query);

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
            PreparedStatement ps = conn.preparedStatement(query);

            ps.setString(1, maCH);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Khong the xoa");
            return false;
        }
    }


    
    public cauHoiDTO layCauHoiBangMaCH(String maCH) throws SQLException{
        cauHoiDTO cauHoi = new cauHoiDTO();
        try {
            String query = "select* from cauhoi where mach = '"+maCH+"'";

            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                cauHoi.setMaCH(rs.getString(1));
                cauHoi.setMaKho(rs.getString(2));
                cauHoi.setMaHT(rs.getString(3));
                cauHoi.setNoidung(rs.getString(4));
                cauHoi.setDoKho(rs.getString(5));
                cauHoi.setMaGV(rs.getString(6));
                cauHoi.setTrangThai(rs.getBoolean(7));
                cauHoi.setImg(rs.getString(8));
                return cauHoi;
            } else {
                // Xử lý trường hợp không có dữ liệu phù hợp với điều kiện
                System.out.println("Không có dữ liệu phù hợp với điều kiện.");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean chuyenTrangThaiCH(String maCH) {
        try {
            String query = "UPDATE CAUHOI SET TrangThai = 1 WHERE MaCH = ?";
            PreparedStatement ps = conn.preparedStatement(query);
            ps.setString(1, maCH);

            int rowsAffected = ps.executeUpdate();
            ps.close();
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
