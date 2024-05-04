/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author PHUNG
 */
import DTO.chiTietDeLopDTO;
import java.sql.*;
import java.util.ArrayList;

public class chiTietDeLopDAO {

    private MyConnection conn;

    public chiTietDeLopDAO() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }

    public ArrayList<chiTietDeLopDTO> layDanhSachChiTietDeLop() throws SQLException {
        ArrayList<chiTietDeLopDTO> arr = new ArrayList<>();
        String sql = "SELECT * FROM chitietdelop";
        PreparedStatement stmt = conn.preparedStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            chiTietDeLopDTO ctd = new chiTietDeLopDTO();
            ctd.setMaDT(rs.getString(1));
            ctd.setMaLop(rs.getString(2));
            arr.add(ctd);
        }
        return arr;
    }
    public String layMaLopTheoMaDT(String maDT) throws SQLException{
        String sql = "SELECT MaLop FROM chitietdelop WHERE MaDT=?";
        PreparedStatement stmt = conn.preparedStatement(sql);
        stmt.setString(1, maDT);
        ResultSet rs = stmt.executeQuery();
        if(rs.next()) {
            return rs.getString(1);
        }
        return null;
    }

}


