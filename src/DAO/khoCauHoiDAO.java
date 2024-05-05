/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.khoCauHoiDTO;
import java.sql.*;

/**
 *
 * @author PHUNG
 */
public class khoCauHoiDAO {

    private MyConnection conn;

    public khoCauHoiDAO() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }

    public String layMaKhoCHTheoMaMon(String maMon) throws SQLException {
        String sql = "SELECT MaKho FROM khocauhoi WHERE MaMon=?";
        PreparedStatement stmt = conn.preparedStatement(sql);
        stmt.setString(1, maMon);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString(1);
        }
        return null;
    }

    public khoCauHoiDTO layKhoBangMaTK(String maTK) {
        khoCauHoiDTO kho = new khoCauHoiDTO();
        try {
            String query = "select * from khocauhoi where maTBM = '" + maTK + "'";

            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                kho.setMaKho(rs.getString(1));
                kho.setMaMon(rs.getString(2));
                kho.setMaTBM(rs.getString(3));
                return kho;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean taoKhoCauHoi(khoCauHoiDTO kch) throws SQLException {
        String sql = "INSERT INTO khocauhoi(MaKho, MaMon, MaTBM) VALUES (?,?,?)";
        PreparedStatement pre = conn.preparedStatement(sql);
        pre.setString(1, kch.getMaKho());
        pre.setString(2, kch.getMaMon());
        pre.setString(3, kch.getMaTBM());
        if (pre.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean xoaMaTBMKhoiKhoCH(String maKho) throws SQLException {
        String query = "UPDATE khocauhoi SET matbm = NULL WHERE makho = ?";
        PreparedStatement pre = conn.preparedStatement(query);
        pre.setString(1, maKho);
        int rowsAffected = pre.executeUpdate();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean themTBMChoKhoCH(String maTBM, String mamon) throws SQLException {
        String query = "UPDATE khocauhoi SET matbm = ? WHERE mamon = ?";
        PreparedStatement pre = conn.preparedStatement(query);
        pre.setString(1, maTBM);
        pre.setString(2, mamon);
        int rowsAffected = pre.executeUpdate();
        if (rowsAffected > 0) {
            return true;
        } else {
            return false;
        }
    }
}
