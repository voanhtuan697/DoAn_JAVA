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

    public khoCauHoiDAO() {
        try {
            conn = new MyConnection();
        } catch (Exception e) {
            System.out.println("Ket noi database khong thanh cong" + e.getMessage());
        }
    }

    public String layMaKhoCHTheoMaMon(String maMon) {
        try {
            conn.Connect();
            String sql = "SELECT MaKho FROM khocauhoi WHERE MaMon=?";
            PreparedStatement stmt = conn.preparedStatement(sql);
            stmt.setString(1, maMon);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
            stmt.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Lay ma kho khong thanh cong" + e.getMessage());
        }
        return null;
    }

    public khoCauHoiDTO layKhoBangMaTK(String maTK) {
        khoCauHoiDTO kho = new khoCauHoiDTO();
        try {
            conn.Connect();
            String query = "select * from khocauhoi where maTBM = '" + maTK + "'";

            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                kho.setMaKho(rs.getString(1));
                kho.setMaMon(rs.getString(2));
                kho.setMaTBM(rs.getString(3));
                pre.close();
                conn.disconnect();
                return kho;
            } else {
                pre.close();
                conn.disconnect();
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean taoKhoCauHoi(khoCauHoiDTO kch) {
        try {
            conn.Connect();
            String sql = "INSERT INTO khocauhoi(MaKho, MaMon, MaTBM) VALUES (?,?,?)";
            PreparedStatement pre = conn.preparedStatement(sql);
            pre.setString(1, kch.getMaKho());
            pre.setString(2, kch.getMaMon());
            pre.setString(3, kch.getMaTBM());
            if (pre.executeUpdate() > 0) {
                pre.close();
                conn.disconnect();
                return true;
            } else {
                pre.close();
                conn.disconnect();
                return false;
            }
        } catch (Exception e) {
            System.out.println("Tao kho khong thanh cong" + e.getMessage());
            return false; //Phụng vừa thêm vào để không bị thiếu giá trị trả về 

        }
    }

    public boolean xoaMaTBMKhoiKhoCH(String maKho) {
        try {
            conn.Connect();
            String query = "UPDATE khocauhoi SET matbm = NULL WHERE makho = ?";
            PreparedStatement pre = conn.preparedStatement(query);
            pre.setString(1, maKho);
            int rowsAffected = pre.executeUpdate();
            pre.close();
            conn.disconnect();
            if (rowsAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Xoa maTBM khong thanh cong" + e.getMessage());
            return false;//Phụng vừa thêm vào để không bị thiếu giá trị trả về 

        }
    }

    public boolean themTBMChoKhoCH(String maTBM, String mamon) {
        try {
            conn.Connect();
            String query = "UPDATE khocauhoi SET matbm = ? WHERE mamon = ?";
            PreparedStatement pre = conn.preparedStatement(query);
            pre.setString(1, maTBM);
            pre.setString(2, mamon);
            int rowsAffected = pre.executeUpdate();
            pre.close();
            conn.disconnect();
            if (rowsAffected > 0) {
                return true;
            } else {
                pre.close();
                return false;
            }
        } catch (Exception e) {
            System.out.println("Them ma TBM khong thanh cong" + e.getMessage());
            return false;//Phụng vừa thêm vào để không bị thiếu giá trị trả về 

        }
    }

    public boolean ThemKho(khoCauHoiDTO k) {
        boolean success = false;
        try {
            conn.Connect();
            String sql = "INSERT INTO KHOCAUHOI(MaKho,MaMon,MaTBM) VALUES(?,?,?)";
            PreparedStatement pre = conn.preparedStatement(sql);
            pre.setString(1, k.getMaKho());
            pre.setString(2, k.getMaMon());
            pre.setString(3, k.getMaTBM());
            success = pre.executeUpdate() > 0;
            pre.close();
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Them kho that bai" + e.getMessage());
        }
        return success;
    }
}
