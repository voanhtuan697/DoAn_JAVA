/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.deThiDTO;
import DTO.ketQuaDTO;
import DTO.lopDTO;
import DTO.nguoiDungDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class deThiDAO2 {

    private MyConnection conn;
    private deThiDTO de;

    public deThiDAO2() {
        try {
            conn = new MyConnection();
        } catch (SQLException e) {
            System.err.println("Ket noi database that bai" + e.getMessage());
        }
    }

    public ArrayList<deThiDTO> getMaTen() {
        ArrayList<deThiDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT MaDT, TenDeThi FROM DETHI WHERE TrangThai = 2;";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    de = new deThiDTO(rs.getString("MaDT"), rs.getString("TenDeThi"));
                    list.add(de);
                }
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay getMaTen that bai" + e.getMessage());
        }
        return list;
    }

    public ArrayList<deThiDTO> getDSMaDT(String MaMon) {
        ArrayList<deThiDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT MaDT "
                    + "FROM DETHI "
                    + "WHERE MaDT IN ("
                    + "    SELECT MaDT "
                    + "    FROM CHITIETDELOP "
                    + "    INNER JOIN LOP ON CHITIETDELOP.MaLop = LOP.MaLop "
                    + "    WHERE LOP.MaMon = ?)";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, MaMon);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    de = new deThiDTO(rs.getString("MaDT"));
                    list.add(de);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lay danh sach ma de thi that bai" + e.getMessage());
        }
        return list;
    }
}
