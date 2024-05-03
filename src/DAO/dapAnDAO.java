/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Minh Phuc
 */
import DTO.dapAnDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.SQLException;

public class dapAnDAO {

    private MyConnection myConnection;
    private List<dapAnDTO> danhSachDapAn;

    public dapAnDAO() {
        try {
            myConnection = new MyConnection();
            myConnection.Connect();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Khong the ket noi den co so du lieu");
        }
    }

    public List<dapAnDTO> layDanhSachdapAnTheoMaCH(String maCH) {
        danhSachDapAn = new ArrayList<>();
        try {
            String query = "SELECT * FROM dapAn WHERE MaCH = ?";
            PreparedStatement ps = myConnection.preparedStatement(query);
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
            PreparedStatement ps = myConnection.preparedStatement(query);
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
            PreparedStatement ps = myConnection.preparedStatement(query);
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
            PreparedStatement ps = myConnection.preparedStatement(query);
            ps.setString(1, maDa);
            ps.executeUpdate();

            // Sau khi xóa khỏi cơ sở dữ liệu thành công, cập nhật lại danh sách
            danhSachDapAn.removeIf(da -> da.getMaDa().equals(maDa));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
