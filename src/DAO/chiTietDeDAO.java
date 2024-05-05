/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.chiTietDeDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class chiTietDeDAO {
//    chiTietDeDTO ctd;

    private MyConnection conn;

    public chiTietDeDAO() {
        try {
            conn = new MyConnection();
        } catch (Exception e) {
            System.out.println("Ket noi database khong thanh cong" + e.getMessage());
        }
    }

    public ArrayList<chiTietDeDTO> layDanhSachChiTietDe() {
        ArrayList<chiTietDeDTO> arr = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT * FROM chitietde";
            PreparedStatement stmt = conn.preparedStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                chiTietDeDTO ctd = new chiTietDeDTO();
                ctd.setMaCH(rs.getString(1));
                ctd.setMaDT(rs.getString(2));
                arr.add(ctd);
            }
            stmt.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Lay danh sach chi tiet de khong thanh cong" + e.getMessage());
        }
        return arr;
    }

    public ArrayList<String> layDSChiTietDeTheoMaDT(String maDT) {
        ArrayList<String> arr = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT * FROM chitietde WHERE MaDT=?";
            PreparedStatement stmt = conn.preparedStatement(sql);
            stmt.setString(1, maDT);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                arr.add(rs.getString(1));
            }
            stmt.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Ket noi database khong thanh cong" + e.getMessage());
        }
        return arr;
    }

    public ArrayList<chiTietDeDTO> layDanhSachChiTietDeBangMaDe(String maDT) {
        ArrayList<chiTietDeDTO> arr = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "select* from chitietde where madt = '" + maDT + "'";
            PreparedStatement pre = conn.preparedStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                chiTietDeDTO ctd = new chiTietDeDTO();
                ctd.setMaCH(rs.getString(1));
                ctd.setMaDT(rs.getString(2));
                arr.add(ctd);
            }
            pre.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Ket noi database khong thanh cong" + e.getMessage());
        }
        return arr;
    }

}
