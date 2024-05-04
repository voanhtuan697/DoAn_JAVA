/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;

/**
 *
 * @author PHUNG
 */
public class khoCauHoiDAO {

    private MyConnection conn;

    public khoCauHoiDAO() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }

    public String layMaKhoCHTheoMaMon(String maMon) throws SQLException {
        String sql = "SELECT MaKho FROM khocauhoi WHERE MaMon=?";
        PreparedStatement stmt = conn.preparedStatement(sql);
        stmt.setString(1, maMon);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return rs.getString(1);
        }
        return null;
    }
}
