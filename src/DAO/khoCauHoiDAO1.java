/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.khoCauHoiDTO;
import java.sql.*;
/**
 *
 * @author E7250
 */
public class khoCauHoiDAO1 {
    private MyConnection conn;

    public khoCauHoiDAO1() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }
    
    
    public khoCauHoiDTO layKhoBangMaTK(String maTK) {
        khoCauHoiDTO kho = new khoCauHoiDTO();
        try {
            String query = "select * from khocauhoi where maTBM = '"+maTK+"'";

            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                kho.setMaKho(rs.getString(1));
                kho.setMaMon(rs.getString(2));
                kho.setMaTBM(rs.getString(3));
                return kho;
            } else {
                System.out.println("Không có dữ liệu phù hợp với điều kiện.");
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
