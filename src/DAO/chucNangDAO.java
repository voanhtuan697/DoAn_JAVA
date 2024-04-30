/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.chucNangDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author E7250
 */
public class chucNangDAO {
    private MyConnection conn;

    public chucNangDAO() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }
    
    public ArrayList<chucNangDTO> layDanhSachChucNang() {
        ArrayList<chucNangDTO> arr = new ArrayList<>();
        try {
            String query = "SELECT * FROM CHUCNANG";
            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                chucNangDTO cn = new chucNangDTO();
                cn.setMaCN(rs.getString(1));
                cn.setTenCN(rs.getString(2));
                arr.add(cn);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }
}
