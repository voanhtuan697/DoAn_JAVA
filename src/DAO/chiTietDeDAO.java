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

    public chiTietDeDAO() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }

    public ArrayList<chiTietDeDTO> layDanhSachChiTietDe() throws SQLException {
        ArrayList<chiTietDeDTO> arr = new ArrayList<>();
        String sql = "SELECT * FROM chitietde";
        PreparedStatement stmt = conn.preparedStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            chiTietDeDTO ctd = new chiTietDeDTO();
            ctd.setMaCH(rs.getString(1));
            ctd.setMaDT(rs.getString(2));
            arr.add(ctd);
        }
        return arr;
    }
    public ArrayList<String> layDSChiTietDeTheoMaDT(String maDT) throws SQLException {
        ArrayList<String> arr = new ArrayList<>();
        String sql = "SELECT * FROM chitietde WHERE MaDT=?";
        PreparedStatement stmt = conn.preparedStatement(sql);
        stmt.setString(1, maDT);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            arr.add(rs.getString(1));
        }
        return arr;
    }
    
}
