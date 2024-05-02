/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.deThiDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class deThiDAO {
    
    private MyConnection conn;
    
    public deThiDAO() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }
    
    public ArrayList<deThiDTO> layDanhSachDeThi() throws SQLException {
        ArrayList<deThiDTO> arr = new ArrayList<>();
        String sql = "SELECT * FROM dethi";
        PreparedStatement stmt = conn.preparedStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            deThiDTO dethi = new deThiDTO();
            dethi.setMaDT(rs.getString(1));
            dethi.setMaGV(rs.getString(2));
            dethi.setTenDeThi(rs.getString(3));
            dethi.setHienThiDA(rs.getBoolean(4));
            dethi.setTienLui(rs.getBoolean(5));
            dethi.setMatKhau(rs.getString(6));
            dethi.setNgayThi(rs.getString(7));
            dethi.setThoiGianBatDauThi(rs.getString(8));
            dethi.setTrangThai(rs.getString(9));
            dethi.setSLCauHoi(rs.getInt(10));
            dethi.setThoiGianLam(rs.getString(11));
            arr.add(dethi);
        }
        return arr;
    }
}
