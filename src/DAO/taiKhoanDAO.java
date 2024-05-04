/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.nguoiDungDTO;
import DTO.taiKhoanDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

public class taiKhoanDAO {

    private MyConnection conn;
    private taiKhoanDTO tk;

    public taiKhoanDAO() {
        try {
            conn = new MyConnection();
        } catch (SQLException e) {
            System.err.println("ket noi co so du lieu that bai" + e.getMessage());
        }
    }

    public String getMaTkByName(String ten) {
        String MaTk = "";
        try {
            conn.Connect();
            String sql = "SELECT tk.MaTK FROM TAIKHOAN tk INNER JOIN NGUOIDUNG nd ON tk.TenDN = nd.MaUser WHERE nd.HoTen = ?";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, ten);
                ResultSet rs = pre.executeQuery();
                if (rs.next()) {
                    MaTk = rs.getString("MaTK");
                }
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Chuyen doi ma that bai" + e.getMessage());
        }
        return MaTk;
    }

    public String getNameByMaTk(String MaTK) {
        String MaTk = "";
        try {
            conn.Connect();
            String sql = "SELECT nd.HoTen FROM TAIKHOAN tk INNER JOIN NGUOIDUNG nd ON tk.TenDN = nd.MaUser WHERE tk.MaTK = ?";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, MaTK);
                ResultSet rs = pre.executeQuery();
                if (rs.next()) {
                    MaTk = rs.getString("HoTen");
                }
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Chuyen doi ten that bai" + e.getMessage());
        }
        return MaTk;
    }

    public String getMaTkByTenDN(String TenDN) {
        String MaTk = "";
        try {
            conn.Connect();
            String sql = "SELECT tk.MaTK FROM TAIKHOAN tk INNER JOIN NGUOIDUNG nd ON tk.TenDN = nd.MaUser WHERE nd.MaUser = ?";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, TenDN);
                ResultSet rs = pre.executeQuery();
                if (rs.next()) {
                    MaTk = rs.getString("MaTK");
                }
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Chuyen doi ten that bai" + e.getMessage());
        }
        return MaTk;
    }


    public static void main(String[] args) {

    }
}
