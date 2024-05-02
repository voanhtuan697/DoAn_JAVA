/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.cauHoiDTO;
import java.sql.*;

/**
 *
 * @author E7250
 */
public class cauHoiDAO1 {
    private MyConnection conn;

    public cauHoiDAO1() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }
    
    public cauHoiDTO layCauHoiBangMaCH(String maCH) throws SQLException{
        cauHoiDTO cauHoi = new cauHoiDTO();
        try {
            String query = "select* from cauhoi where mach = '"+maCH+"'";

            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                cauHoi.setMaCH(rs.getString(1));
                cauHoi.setMaKho(rs.getString(2));
                cauHoi.setMaHT(rs.getString(3));
                cauHoi.setNoidung(rs.getString(4));
                cauHoi.setDoKho(rs.getString(5));
                cauHoi.setMaGV(rs.getString(6));
                cauHoi.setTrangThai(rs.getBoolean(7));
                cauHoi.setImg(rs.getString(8));
                return cauHoi;
            } else {
                // Xử lý trường hợp không có dữ liệu phù hợp với điều kiện
                System.out.println("Không có dữ liệu phù hợp với điều kiện.");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
