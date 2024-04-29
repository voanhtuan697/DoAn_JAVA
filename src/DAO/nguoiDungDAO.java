/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.nguoiDungDTO;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author PHUNG
 */
public class nguoiDungDAO {

    private final MyConnection conn;

    public nguoiDungDAO() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }
//    private final Connection conn = connect.Connect();

    public ArrayList<nguoiDungDTO> getNguoiDung() throws SQLException {
        ArrayList<nguoiDungDTO> arr = new ArrayList<>();
        String sql = "SELECT * FROM nguoidung";
        PreparedStatement stmt = conn.preparedStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            nguoiDungDTO user = new nguoiDungDTO();
            user.setMaUser(rs.getString(1));
            user.setHoTen(rs.getString(2));
            user.setNgSinh(rs.getString(3));
            arr.add(user);
        }
        return arr;
    }

    public int getSoLuongNguoiDung() throws SQLException {
        String sql = "SELECT COUNT(MaUser) FROM nguoidung";
        PreparedStatement stmt = conn.preparedStatement(sql);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return Integer.parseInt(rs.getString(1));
        }
        return 0;
    }

    public boolean addNguoiDung(nguoiDungDTO a) throws SQLException {
        String sql = "INSERT INTO nguoidung(MaUser, HoTen, NgSinh) VALUES (?,?,?)";
        PreparedStatement stmt = conn.preparedStatement(sql);
        stmt.setString(1, a.getMaUser());
        stmt.setString(2, a.getHoTen());
        stmt.setString(3, a.getNgSinh());
        int ketQua = stmt.executeUpdate();
        if (ketQua > 0) {
            return true;
        }
        return false;

    }

    public boolean deleteNguoiDung(String maUser) throws SQLException {
        String sql = "DELETE FROM nguoidung WHERE MaUser=?";
        PreparedStatement stmt = conn.preparedStatement(sql);
        stmt.setString(1, maUser);
        int rs = stmt.executeUpdate();
        if (rs > 0) {
            return true;
        }
        return false;
    }
 public boolean updateNguoiDung(String hoTen, String ngSinh, String maUser) throws SQLException {
        String sql = "UPDATE nguoidung SET HoTen=?, NgSinh=? WHERE MaUser=?";
        PreparedStatement stmt = conn.preparedStatement(sql);
        stmt.setString(1, hoTen);
        stmt.setString(2, ngSinh);
        stmt.setString(3, maUser);
        int rs = stmt.executeUpdate();
        if (rs > 0) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws SQLException {
        for (nguoiDungDTO x : new nguoiDungDAO().getNguoiDung()) {
            System.out.println(x.getMaUser());
        }
    }

}
