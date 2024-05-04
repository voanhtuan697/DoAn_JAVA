/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import DTO.dapAnDTO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author E7250
 */
public class dapAnDAO {

    private MyConnection conn;
    private List<dapAnDTO> danhSachDapAn;

    public dapAnDAO() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }

    public ArrayList<dapAnDTO> layCacDapAnBangMaCH(String maCH) throws SQLException {
        ArrayList<dapAnDTO> arr = new ArrayList<>();
        String sql = "select* from dapan where mach = '" + maCH + "'";
        PreparedStatement pre = conn.preparedStatement(sql);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            dapAnDTO da = new dapAnDTO();
            da.setMaDa(rs.getString(1));
            da.setMaCH(rs.getString(2));
            da.setNoidung(rs.getString(3));
            da.setDungSai(rs.getBoolean(4));
            arr.add(da);
        }
        return arr;
    }

    public int laySoDapAnCuaMotCauHoi(String maCH) throws SQLException {
        int soLuong = 0;
        String sql = "select count(*) from dapan where mach = '" + maCH + "'";
        PreparedStatement pre = conn.preparedStatement(sql);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            soLuong = rs.getInt(1);
            return soLuong;
        }
        return soLuong;
    }

    public List<dapAnDTO> layDanhSachdapAnTheoMaCH(String maCH) {
        danhSachDapAn = new ArrayList<>();
        try {
            String query = "SELECT * FROM dapAn WHERE MaCH = ?";
            PreparedStatement ps = conn.preparedStatement(query);
            ps.setString(1, maCH);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String maDa = rs.getString("MaDa");
                String noidung = rs.getString("Noidung");
                boolean dungSai = rs.getBoolean("DungSai");
                // Tạo đối tượng dapAnDTO và thêm vào danh sách
                dapAnDTO dapAn = new dapAnDTO(maDa, maCH, noidung, dungSai);
                danhSachDapAn.add(dapAn);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return danhSachDapAn;
    }

    public void themdapAn(dapAnDTO dapAn) {
        try {
            String query = "INSERT INTO dapAn(MaDa, MaCH, Noidung, DungSai) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.preparedStatement(query);
            ps.setString(1, dapAn.getMaDa());
            ps.setString(2, dapAn.getMaCH());
            ps.setString(3, dapAn.getNoidung());
            ps.setBoolean(4, dapAn.isDungSai());
            ps.executeUpdate();

            // Sau khi thêm vào cơ sở dữ liệu, cập nhật danh sách
            danhSachDapAn.add(dapAn);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void suadapAn(dapAnDTO dapAn) {
        try {
            String query = "UPDATE dapAn SET Noidung = ?, DungSai = ? WHERE MaDa = ?";
            PreparedStatement ps = conn.preparedStatement(query);
            ps.setString(1, dapAn.getNoidung());
            ps.setBoolean(2, dapAn.isDungSai());
            ps.setString(3, dapAn.getMaDa());
            ps.executeUpdate();

            // Sau khi sửa trong cơ sở dữ liệu thành công, cập nhật lại danh sách
            for (dapAnDTO da : danhSachDapAn) {
                if (da.getMaDa().equals(dapAn.getMaDa())) {
                    da.setNoidung(dapAn.getNoidung());
                    da.setDungSai(dapAn.isDungSai());
                    break;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void xoadapAn(String maDa) {
        try {
            String query = "DELETE FROM dapAn WHERE MaDa = ?";
            PreparedStatement ps = conn.preparedStatement(query);
            ps.setString(1, maDa);
            ps.executeUpdate();

            // Sau khi xóa khỏi cơ sở dữ liệu thành công, cập nhật lại danh sách
            danhSachDapAn.removeIf(da -> da.getMaDa().equals(maDa));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
