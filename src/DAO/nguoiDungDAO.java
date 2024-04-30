/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.nguoiDungDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author E7250
 */
public class nguoiDungDAO {
    private MyConnection conn;

    public nguoiDungDAO() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }
    
    public nguoiDungDTO layNguoiDung(String maTK) {
        nguoiDungDTO user = new nguoiDungDTO();
        try {
            String query = "SELECT MaUser, HoTen, NgSinh FROM TAIKHOAN JOIN NGUOIDUNG ON TAIKHOAN.TenDN = NGUOIDUNG.MaUser WHERE MaTK ='"+maTK+"'";

            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                user.setMaUser(rs.getString("MaUser"));
                user.setHoTen(rs.getString("HoTen"));
                user.setNgSinh(rs.getString("NgSinh"));
                return user;
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
    
    public static void main(String[] args) throws SQLException {
        nguoiDungDAO tk = new nguoiDungDAO();
        nguoiDungDTO user = tk.layNguoiDung("TK2");
        System.out.println(user.getHoTen());
        System.out.println(user.getMaUser());
        System.out.println(user.getNgSinh());
    }
}
