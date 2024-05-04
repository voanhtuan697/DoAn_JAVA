/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.chiTietQuyenDTO;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author E7250
 */
public class chiTietQuyenDAO {

    private MyConnection conn;

    public chiTietQuyenDAO() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }

    public ArrayList<chiTietQuyenDTO> layDanhSachCTQuyen() {
        ArrayList<chiTietQuyenDTO> arr = new ArrayList<>();
        try {
            String query = "SELECT * FROM CHITIETQUYEN";
            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                chiTietQuyenDTO ctq = new chiTietQuyenDTO();
                ctq.setMaCN(rs.getString(1));
                ctq.setMaQuyen(rs.getString(2));

                arr.add(ctq);
            }
            pre.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public void xoaQuyenTrongDSCTQ(String maQuyen) {
        try {
            String query = "DELETE FROM CHITIETQUYEN WHERE MaQuyen = ?";
            PreparedStatement pre = conn.preparedStatement(query);
            pre.setString(1, maQuyen);
            int rowsAffected = pre.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Dữ liệu đã được xóa thành công.");
            } else {
                System.out.println("Không có dữ liệu nào được xóa.");
            }
            pre.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void themChiTietQuyen(chiTietQuyenDTO ctq) {
        String insertQuery = "INSERT INTO CHITIETQUYEN VALUES(?,?)";
        try {
            PreparedStatement pre = conn.preparedStatement(insertQuery);
            pre.setString(1, ctq.getMaCN());
            pre.setString(2, ctq.getMaQuyen());
            pre.executeUpdate();
            pre.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean kiemTraTKcoTonTaiCN(String maTK, String maCN) throws SQLException {
        String sql = "select count(*)\n"
                + "from taikhoan tk\n"
                + "join quyen q on tk.maquyen = q.maquyen\n"
                + "join chitietquyen ctq on ctq.maquyen = q.maquyen\n"
                + "where tk.matk = '"+maTK+"' and macn = '"+maCN+"'";
        PreparedStatement pre = conn.preparedStatement(sql);
        ResultSet rs = pre.executeQuery();
        if (rs.next()) {
            int count = rs.getInt(1);
            if (count > 0) {
                return true;
            }
        }
        return false;
    }

}
