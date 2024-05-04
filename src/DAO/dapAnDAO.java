/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.dapAnDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author E7250
 */
public class dapAnDAO {

    private MyConnection conn;

    public dapAnDAO() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }

    public ArrayList<dapAnDTO> layCacDapAnBangMaCH(String maCH) throws SQLException {
        ArrayList<dapAnDTO> arr = new ArrayList<>();
        String sql = "select* from dapan where mach = '" + maCH + "'";
        PreparedStatement pre = conn.preparedStatement(sql);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            dapAnDTO da = new dapAnDTO();
            da.setMaDa(rs.getString(1));
            da.setMaCH(rs.getString(2));
            da.setNoidung(rs.getString(3));
            da.setDungSai(rs.getBoolean(4));
            arr.add(da);
        }
        return arr;
    }

    public int laySoDapAnCuaMotCauHoi(String maCH) throws SQLException {
        int soLuong = 0;
        String sql = "select count(*) from dapan where mach = '" + maCH + "'";
        PreparedStatement pre = conn.preparedStatement(sql);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            soLuong = rs.getInt(1);
            return soLuong;
        }
        return soLuong;
    }

}
