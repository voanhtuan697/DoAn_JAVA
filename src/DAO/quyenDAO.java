/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.quyenDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class quyenDAO {

    private MyConnection conn;

    public quyenDAO() {
        try {
            conn = new MyConnection();
        } catch (Exception e) {
            System.out.println("Ket noi database khong thanh cong" + e.getMessage());
        }
    }

    public ArrayList<quyenDTO> getQuyen() {
        ArrayList<quyenDTO> dsQuyen = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT * FROM quyen";
            PreparedStatement stmt = conn.preparedStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                quyenDTO r = new quyenDTO();
                r.setMaQuyen(rs.getString(1));
                System.out.println(rs.getString(2));
                r.setTenQuyen(rs.getString(2));
                dsQuyen.add(r);
            }
            stmt.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Lay danh sach quyen khong thanh cong" + e.getMessage());
        }
        return dsQuyen;
    }

    public String getMaQuyenTheoTenQuyen(String tenQuyen) {
        String maQuyen = null;
        try {
            conn.Connect();
            String sql = "SELECT * FROM quyen WHERE TenQuyen=?";
            PreparedStatement stmt = conn.preparedStatement(sql);
            stmt.setString(1, tenQuyen);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                maQuyen = rs.getString(1);
            }
            stmt.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Lay ma quyen khong thanh cong" + e.getMessage());
        }
        return maQuyen;
    }

    public String getTenQuyenTheoMaQuyen(String maQuyen) {
        String tenQuyen = null;
        try {
            conn.Connect();
            String sql = "SELECT TenQuyen FROM quyen WHERE MaQuyen=?";
            PreparedStatement stmt = conn.preparedStatement(sql);
            stmt.setString(1, maQuyen);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                tenQuyen = rs.getString(1);
            }
            stmt.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Lay ten quyen khong thanh cong" + e.getMessage());
        }
        return tenQuyen;
    }

    public ArrayList<quyenDTO> layDanhSachQuyen() {
        ArrayList<quyenDTO> arr = new ArrayList<>();
        try {
            conn.Connect();
            String query = "SELECT * FROM QUYEN";
            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                quyenDTO q = new quyenDTO();
                q.setMaQuyen(rs.getString(1));
                q.setTenQuyen(rs.getString(2));
                arr.add(q);
            }
            pre.close();
            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public quyenDTO layQuyen(String maTK) {
        quyenDTO quyen = new quyenDTO();
        try {
            conn.Connect();
            String query = "SELECT TK.MaQuyen, TenQuyen FROM TAIKHOAN TK JOIN QUYEN Q ON TK.MaQuyen = Q.MaQuyen WHERE TK.MaTK = '" + maTK + "'";

            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                quyen.setMaQuyen(rs.getString(1));
                quyen.setTenQuyen(rs.getString(2));
                pre.close();
                conn.disconnect();
                return quyen;
            } else {
                // Xử lý trường hợp không có dữ liệu phù hợp với điều kiện
                System.out.println("Không có dữ liệu phù hợp với điều kiện.");
                pre.close();
                conn.disconnect();
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
