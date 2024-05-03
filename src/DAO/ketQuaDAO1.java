/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ketQuaDTO;
import java.sql.*;

/**
 *
 * @author E7250
 */
public class ketQuaDAO1 {

    private final MyConnection conn;

    public ketQuaDAO1() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }

    public void taoKetQua(ketQuaDTO kq) throws SQLException {
        String sql = "INSERT INTO ketqua(MaKQ, MaDT, Diem,SLCauDung,TGLamXong,MaTK) VALUES (?,?,?,?,?,?)";
        PreparedStatement pre = conn.preparedStatement(sql);
        pre.setString(1, kq.getMaKQ());
        pre.setString(2, kq.getMaDT());
        pre.setFloat(3, kq.getDiem());
        pre.setInt(4, kq.getSLCauDung());
        pre.setString(5, kq.getTGLamXong());
        pre.setString(6, kq.getMaTK());
        if (pre.executeUpdate() > 0) {
            System.out.println("Tao kq thanh cong");
        } else {
            System.out.println("Tao kq that bai");
        }
    }

    public boolean kiemTraSVDaLamDeChua(String maTK, String maDT) throws SQLException {
        String sql = "select count(*) from ketqua where madt = '" + maDT + "' and matk = '" + maTK + "'";
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

    public ketQuaDTO layKetQuaBangMaTKvaMaDT(String maTK,String maDT) {
        ketQuaDTO ketQua = new ketQuaDTO();
        try {
            String query = "select* from ketqua where maDT ='"+maDT+"' and matk='"+maTK+"'";

            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                ketQua.setMaKQ(rs.getString(1));
                ketQua.setMaDT(rs.getString(2));
                ketQua.setDiem(rs.getFloat(3));
                ketQua.setSLCauDung(rs.getInt(4));
                ketQua.setTGLamXong(rs.getString(5));
                ketQua.setMaTK(rs.getString(6));
                return ketQua;
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
