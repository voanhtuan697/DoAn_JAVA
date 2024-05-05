/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.chiTietLopDTO;
import DTO.chiTietMonDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class chiTietMonDAO {

    MyConnection conn;

    public chiTietMonDAO()  {
        try {
            conn = new MyConnection();
        } catch (Exception e) {
            System.out.println("Ket noi database khong thanh cong" + e.getMessage());
        }
    }

    public ArrayList<chiTietMonDTO> layDanhSachChiTietMon()  {
        ArrayList<chiTietMonDTO> arr = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT * FROM chitietmon";
            PreparedStatement stmt = conn.preparedStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                chiTietMonDTO ctm = new chiTietMonDTO();
                ctm.setMaGV(rs.getString(2));
                ctm.setMaMon(rs.getString(1));
                arr.add(ctm);
            }stmt.close();
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay danh sach chi tiet mon that bai" + e.getMessage());
        }
        return arr;
    }

    public boolean themSV(chiTietLopDTO t) {
        boolean success = false;
        try {
            conn.Connect();
            String sql = "INSERT INTO CHITIETLOP(MaLop,MaSV) VALUES(?,?)";
            PreparedStatement pre = conn.preparedStatement(sql);
            pre.setString(1, t.getMaLop());
            pre.setString(2, t.getMaSV());
            success = pre.executeUpdate() > 0;
            pre.close();
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Them sinh vao lop hoc that bai" + e.getMessage());
        }
        return success;
    }

    public boolean ThemDS(chiTietMonDTO ct) {
        boolean success = false;
        try {
            conn.Connect();
            String sql = "INSERT INTO CHITIETMON(MaMon,MaGV) VALUES(?,?)";
            PreparedStatement pre = conn.preparedStatement(sql);
            pre.setString(1, ct.getMaMon());
            pre.setString(2, ct.getMaGV());
            success = pre.executeUpdate() > 0;
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("them lop cho gv that bai" + e.getMessage());
        }
        return success;
    }
}
