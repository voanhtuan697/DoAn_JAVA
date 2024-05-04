/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.lopDTO;
import java.sql.*;

public class lopDAO1 {

    private MyConnection conn;

    public lopDAO1() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }

    public lopDTO layLopBangMaDe(String maDT) {
        lopDTO lop = new lopDTO();
        try {
            String query = "select l.MaLop, MaGV, SoLuong, MaMon, Nam, HocKy, TrangThai, NhomLop\n"
                    + "from chitietdelop ctdl\n"
                    + "join lop l on ctdl.MaLop = l.MaLop\n"
                    + "where MaDT ='" + maDT + "'";

            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                lop.setMaLop(rs.getString(1));
                lop.setMaGV(rs.getString(2));
                lop.setSoLuong(rs.getInt(3));
                lop.setMaMon(rs.getString(4));
                lop.setNam(rs.getInt(5));
                lop.setHocKy(rs.getInt(6));
                lop.setTrangThai(rs.getBoolean(7));
                lop.setNhomLop(rs.getInt(8));
                return lop;
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

    public int layNhomLopMaTKvaMaDT(String maTK, String maDT) {
        int nhomLop;
        try {
            String query = "select nhomlop\n"
                    + "from taikhoan tk\n"
                    + "join chitietlop ctl on tk.matk = ctl.masv\n"
                    + "join lop l on l.malop = ctl.malop\n"
                    + "join chitietdelop ctdl on ctdl.malop = l.malop\n"
                    + "join dethi dt on dt.madt = ctdl.madt\n"
                    + "where tk.matk = '"+maTK+"' and dt.madt = '"+maDT+"'";

            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                nhomLop = rs.getInt(1);
                return nhomLop;
            } else {
                // Xử lý trường hợp không có dữ liệu phù hợp với điều kiện
                System.out.println("Không có dữ liệu phù hợp với điều kiện.");
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
