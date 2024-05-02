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
 * @author E7250
 */
public class chiTietDeDAO1 {
    private MyConnection conn;

    public chiTietDeDAO1() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }
    
    public ArrayList<chiTietDeDTO> layDanhSachChiTietDeBangMaDe(String maDT) throws SQLException {
        ArrayList<chiTietDeDTO> arr = new ArrayList<>();
        String sql = "select* from chitietde where madt = '"+maDT+"'";
        PreparedStatement pre = conn.preparedStatement(sql);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            chiTietDeDTO ctd = new chiTietDeDTO();
            ctd.setMaCH(rs.getString(1));
            ctd.setMaDT(rs.getString(2));
            arr.add(ctd);
        }
        return arr;
    }
}
