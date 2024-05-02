/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.monDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class monDAO {

    private MyConnection conn;

    public monDAO() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }

    public ArrayList<monDTO> layDanhSachMon() throws SQLException {
        ArrayList<monDTO> arr = new ArrayList<>();
        String sql = "SELECT * FROM mon";
        PreparedStatement stmt = conn.preparedStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            monDTO mon = new monDTO();
            mon.setMaMon(rs.getString(1));
            mon.setTenMon(rs.getString(2));
            arr.add(mon);
        }
        return arr;
    }

    public String layTenMonTheoMaMon(String maMon) throws SQLException {
        String sql = "SELECT TenMon FROM mon WHERE MaMon=?";
        PreparedStatement stmt = conn.preparedStatement(sql);
        stmt.setString(1, maMon);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString(1);
        }
        return null;
    }

    public String layMaMonTheoTenMon(String tenMon) throws SQLException {
        String sql = "SELECT MaMon FROM mon WHERE TenMon=?";
        PreparedStatement stmt = conn.preparedStatement(sql);
        stmt.setString(1, tenMon);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString(1);
        }
        return null;
    }

    public String layTenMonTheoMaDeThi(String maDT) throws SQLException {
        String sql = "select TenMon from MON, CHITIETDELOP, LOP,DETHI where MON.MaMon=LOP.MaMon and CHITIETDELOP.MaLop=LOP.MaLop and DETHI.MaDT = CHITIETDELOP.MaDT and DETHI.MaDT=?";
        PreparedStatement stmt = conn.preparedStatement(sql);
        stmt.setString(1, maDT);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString(1);
        }
        return null;
    }

    public ArrayList<monDTO> layMonTuLop() throws SQLException {
        ArrayList<monDTO> arr = new ArrayList<>();
        String sql = "SELECT DISTINCT mon.MaMon, TenMon FROM mon,lop WHERE lop.MaMon = mon.MaMon";
        PreparedStatement stmt = conn.preparedStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
//                if (x.getMaMon().equalsIgnoreCase(rs.getString(1)) == false) {
            monDTO mon = new monDTO();
            mon.setMaMon(rs.getString(1));
            mon.setTenMon(rs.getString(2));
            arr.add(mon);
//                    break;

        }
        return arr;
    }
}
