/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.quyenDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author E7250
 */
public class quyenDAO {
    private MyConnection conn;

    public quyenDAO() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }
    
    public ArrayList<quyenDTO> layDanhSachQuyen() {
        ArrayList<quyenDTO> arr = new ArrayList<>();
        try {
            String query = "SELECT * FROM QUYEN";
            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                quyenDTO q = new quyenDTO();
                q.setMaQuyen(rs.getString(1));
                q.setTenQuyen(rs.getString(2));
                arr.add(q);
            }
            pre.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }
    
    public quyenDTO layQuyen(String maTK) {
        quyenDTO quyen = new quyenDTO();
        try {
            String query = "SELECT TK.MaQuyen, TenQuyen FROM TAIKHOAN TK JOIN QUYEN Q ON TK.MaQuyen = Q.MaQuyen WHERE TK.MaTK = '"+maTK+"'";

            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                quyen.setMaQuyen(rs.getString(1));
                quyen.setTenQuyen(rs.getString(2));
                return quyen;
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
