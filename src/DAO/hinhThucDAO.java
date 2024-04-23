/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.hinhThucDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.ResultSet;

public class hinhThucDAO {

    private MyConnection conn;

    public hinhThucDAO() {
        try {
            conn = new MyConnection();
        } catch (SQLException e) {
            System.out.println("ket noi database that bai");
        }
    }

    public ArrayList<hinhThucDTO> ListHinhThuc() {
        ArrayList<hinhThucDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT * FROM HINHTHUC";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    hinhThucDTO item = new hinhThucDTO(rs.getString("MaHT"), rs.getString("TenHT"));
                    list.add(item);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lay danh sach hinh thuc that bai" + e.getMessage());
        }
        return list;
    }

}
