/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.chiTietMonDTO;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author PHUNG
 */
public class chiTietMonDAO {

    MyConnection conn;

    public chiTietMonDAO() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }

    public ArrayList<chiTietMonDTO> layDanhSachChiTietMon() throws SQLException {
        ArrayList<chiTietMonDTO> arr = new ArrayList<>();
        String sql = "SELECT * FROM chitietmon";
        PreparedStatement stmt = conn.preparedStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while(rs.next()){
            chiTietMonDTO ctm = new chiTietMonDTO();
            ctm.setMaGV(rs.getString(2));
            ctm.setMaMon(rs.getString(1));
            arr.add(ctm);
        }
        return arr;
    }
}
