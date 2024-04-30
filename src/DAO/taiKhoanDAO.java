/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.taiKhoanDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author E7250
 */
public class taiKhoanDAO {

    private MyConnection conn;

    public taiKhoanDAO() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }

    public ArrayList<taiKhoanDTO> layDanhSachTaiKhoan() {
        ArrayList<taiKhoanDTO> arr = new ArrayList<>();
        try {
            String query = "SELECT * FROM TAIKHOAN";
            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                taiKhoanDTO tk = new taiKhoanDTO();
                tk.setMaTK(rs.getString(1));
                tk.setTenDN(rs.getString(2));
                tk.setMatKhau(rs.getString(3));
                tk.setTrangThai(rs.getBoolean(4));
                tk.setMaQuyen(rs.getString(5));
                arr.add(tk);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public ArrayList<String> layDanhSachMaCN(String maTK) {
        ArrayList<String> arr = new ArrayList<>();
        try {
            String query = "SELECT MaCN\n"
                    + "FROM TAIKHOAN TK\n"
                    + "JOIN QUYEN Q ON TK.MaQuyen = Q.MaQuyen\n"
                    + "JOIN CHITIETQUYEN CTQ ON Q.MaQuyen = CTQ.MaQuyen\n"
                    + "WHERE TK.MaTK ='" + maTK + "'";
            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                arr.add(rs.getString(1).trim());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public taiKhoanDTO layTaiKhoan(String maTK) {
        taiKhoanDTO tk = new taiKhoanDTO();
        try {
            String query = "SELECT* FROM TAIKHOAN TK WHERE TK.MaTK ='" + maTK + "'";

            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                tk.setMaTK(rs.getString(1).trim());
                tk.setTenDN(rs.getString(2).trim());
                tk.setMatKhau(rs.getString(3));
                tk.setTrangThai(rs.getBoolean(4));
                tk.setMaQuyen(rs.getString(5).trim());
                return tk;
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
    
    

//    public static void main(String[] args) throws SQLException {
//        taiKhoanDAO tk = new taiKhoanDAO();
//        String kk = tk.layTenQuyen("TK1");
//        System.out.println(kk);
//    }
}
