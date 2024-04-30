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

    private quyenDTO role = new quyenDTO();
    private final MyConnection conn;

    public quyenDAO() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }

    public ArrayList<quyenDTO> getQuyen() throws SQLException {
        ArrayList<quyenDTO> dsQuyen = new ArrayList<>();
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
        return dsQuyen;
    }

    public String getMaQuyenTheoTenQuyen(String tenQuyen) throws SQLException {
        String maQuyen = null;
        String sql = "SELECT * FROM quyen WHERE TenQuyen=?";
        PreparedStatement stmt = conn.preparedStatement(sql);
        stmt.setString(1, tenQuyen);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            maQuyen = rs.getString(1);
        }
        return maQuyen;
    }

    public String getTenQuyenTheoMaQuyen(String maQuyen) throws SQLException {
        String tenQuyen = null;
        String sql = "SELECT TenQuyen FROM quyen WHERE MaQuyen=?";
        PreparedStatement stmt = conn.preparedStatement(sql);
        stmt.setString(1, maQuyen);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            tenQuyen = rs.getString(1);
        }
        return tenQuyen;
    }

    public ArrayList<quyenDTO> layDanhSachQuyen() {
        ArrayList<quyenDTO> arr = new ArrayList<>();
        try {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public quyenDTO layQuyen(String maTK) {
        quyenDTO quyen = new quyenDTO();
        try {
            String query = "SELECT TK.MaQuyen, TenQuyen FROM TAIKHOAN TK JOIN QUYEN Q ON TK.MaQuyen = Q.MaQuyen WHERE TK.MaTK = '" + maTK + "'";

            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                quyen.setMaQuyen(rs.getString(1));
                quyen.setTenQuyen(rs.getString(2));
                return quyen;
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
}
