/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author PHUNG
 */
import DTO.chiTietDeLopDTO;
import java.sql.*;
import java.util.ArrayList;

public class chiTietDeLopDAO {

    private MyConnection conn;

    public chiTietDeLopDAO()  {
        try {
            conn = new MyConnection();
        } catch (Exception e) {
            System.out.println("Ket noi database khong thanh cong" + e.getMessage());
        }
    }

    public ArrayList<chiTietDeLopDTO> layDanhSachChiTietDeLop()  {
        ArrayList<chiTietDeLopDTO> arr = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT * FROM chitietdelop";
            PreparedStatement stmt = conn.preparedStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                chiTietDeLopDTO ctd = new chiTietDeLopDTO();
                ctd.setMaDT(rs.getString(1));
                ctd.setMaLop(rs.getString(2));
                arr.add(ctd);
            }
            stmt.close();
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay danh sach chi tiet de lop that bai" + e.getMessage());
        }
        return arr;
    }

    public String layMaLopTheoMaDT(String maDT)  {
        try {
            conn.Connect();
            String sql = "SELECT MaLop FROM chitietdelop WHERE MaDT=?";
            PreparedStatement stmt = conn.preparedStatement(sql);
            stmt.setString(1, maDT);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
            stmt.close();
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay ma lop that bai" + e.getMessage());
        }
        return null;
    }

}
