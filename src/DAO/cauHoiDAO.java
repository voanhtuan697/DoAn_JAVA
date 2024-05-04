/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.cauHoiDTO;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author PHUNG
 */
public class cauHoiDAO {

    private MyConnection conn;

    public cauHoiDAO() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }

    public ArrayList<cauHoiDTO> layDanhSachCauHoi() throws SQLException {
        ArrayList<cauHoiDTO> arr = new ArrayList<>();
        String sql = "SELECT * FROM cauhoi";
        PreparedStatement stmt = conn.preparedStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            cauHoiDTO ch = new cauHoiDTO();
            ch.setMaCH(rs.getString(1));
            ch.setMaKho(rs.getString(2));
            ch.setMaHT(rs.getString(3));
            ch.setNoidung(rs.getString(4));
            ch.setDoKho(rs.getString(5));
            ch.setMaGV(rs.getString(6));
            ch.setTrangThai(rs.getBoolean(7));
            ch.setImg(rs.getString(8));
            arr.add(ch);
        }
        return arr;
    }

    public String layMaCHTheoNoiDung(String noiDung) throws SQLException {
        String sql = "SELECT MaCH FROM cauhoi WHERE NoiDung = ?";
        PreparedStatement stmt = conn.preparedStatement(sql);
        stmt.setString(1, noiDung);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString(1);
        }
        return null;
    }
//    public ArrayList<cauHoiDTO> layDanhSachCauHoiTheoMon(String tenMon) throws SQLException{
//        
//        String sql="";
//    }
}
