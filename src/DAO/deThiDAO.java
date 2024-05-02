/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.deThiDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author E7250
 */
public class deThiDAO {

    private MyConnection conn;

    public deThiDAO() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }

    public ArrayList<deThiDTO> layDanhSachDeThi() throws SQLException {
        ArrayList<deThiDTO> arr = new ArrayList<>();
        String sql = "SELECT * FROM DETHI";
        PreparedStatement stmt = conn.preparedStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            deThiDTO dt = new deThiDTO();
            dt.setMaDT(rs.getString(1));
            dt.setMaGV(rs.getString(2));
            dt.setTenDeThi(rs.getString(3));
            dt.setHienThiDA(rs.getBoolean(4));
            dt.setTienLui(rs.getBoolean(5));
            dt.setMatKhau(rs.getString(6));
            dt.setNgayThi(rs.getString(7));
            dt.setThoiGianBatDauThi(rs.getString(8));
            dt.setTrangThai(rs.getInt(9));
            dt.setSLCauHoi(rs.getInt(10));
            dt.setThoiGianLamBai(rs.getInt(11));
            arr.add(dt);
        }
        return arr;
    }

    public ArrayList<deThiDTO> layDeThiDSBangMaTK(String maTK, int trangThai) throws SQLException {
        ArrayList<deThiDTO> arr = new ArrayList<>();
        String query = "SELECT dt.MaDT, dt.MaGV, TenDeThi, HienThiDA, TienLui, dt.MatKhau, NgayThi, ThoiGianBatDauThi, dt.TrangThai,SoLuongCau,ThoiGianLamBai\n"
                + "FROM taikhoan tk\n"
                + "JOIN chitietlop ctl on tk.MaTK = ctl.MaSV\n"
                + "JOIN lop l on ctl.MaLop = l.MaLop\n"
                + "JOIN chitietdelop ctdl on l.MaLop = ctdl.MaLop\n"
                + "JOIN dethi dt on ctdl.MaDT = dt.MaDT\n"
                + "WHERE MaTK ='" + maTK + "' AND dt.TrangThai =" + trangThai;
        PreparedStatement pre = conn.preparedStatement(query);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            deThiDTO dt = new deThiDTO();
            dt.setMaDT(rs.getString(1));
            dt.setMaGV(rs.getString(2));
            dt.setTenDeThi(rs.getString(3));
            dt.setHienThiDA(rs.getBoolean(4));
            dt.setTienLui(rs.getBoolean(5));
            dt.setMatKhau(rs.getString(6));
            dt.setNgayThi(rs.getString(7));
            dt.setThoiGianBatDauThi(rs.getString(8));
            dt.setTrangThai(rs.getInt(9));
            dt.setSLCauHoi(rs.getInt(10));
            dt.setThoiGianLamBai(rs.getInt(11));
            arr.add(dt);
        }
        return arr;

    }

//    public static void main(String[] args) throws SQLException {
//        deThiDAO dt = new deThiDAO();
//        deThiDTO dtt = dt.layDeThiBangMaTK("TK12", 0);
//        System.out.println(dtt.getThoiGianLamBai());
//    }

}
