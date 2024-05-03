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
            dt.setMatKhau(rs.getString(4));
            dt.setNgayThi(rs.getString(5));
            dt.setThoiGianBatDauThi(rs.getString(6));
            dt.setTrangThai(rs.getInt(7));
            dt.setSLCauHoi(rs.getInt(8));
            dt.setThoiGianLamBai(rs.getInt(9));
            arr.add(dt);
        }
        return arr;
    }

    public ArrayList<deThiDTO> layDeThiDSBangMaTK(String maTK, int trangThai) throws SQLException {
        ArrayList<deThiDTO> arr = new ArrayList<>();
        String query = "SELECT dt.MaDT, dt.MaGV, TenDeThi, dt.MatKhau, NgayThi, ThoiGianBatDauThi, dt.TrangThai,SoLuongCau,ThoiGianLamBai\n"
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
            dt.setMatKhau(rs.getString(4));
            dt.setNgayThi(rs.getString(5));
            dt.setThoiGianBatDauThi(rs.getString(6));
            dt.setTrangThai(rs.getInt(7));
            dt.setSLCauHoi(rs.getInt(8));
            dt.setThoiGianLamBai(rs.getInt(9));
            arr.add(dt);
        }
        return arr;
    }

    public ArrayList<deThiDTO> layDSDeThiDaTao(String maTK, int trangThai) throws SQLException {
        ArrayList<deThiDTO> arr = new ArrayList<>();
        String query = "select dt.MaDT, dt.MaGV, TenDeThi, dt.MatKhau, NgayThi, ThoiGianBatDauThi, dt.TrangThai,SoLuongCau,ThoiGianLamBai\n"
                + "from taikhoan tk\n"
                + "join dethi dt on tk.matk = dt.magv\n"
                + "where tk.matk = '" + maTK + "' and dt.trangthai =" + trangThai;
        PreparedStatement pre = conn.preparedStatement(query);
        ResultSet rs = pre.executeQuery();
        while (rs.next()) {
            deThiDTO dt = new deThiDTO();
            dt.setMaDT(rs.getString(1));
            dt.setMaGV(rs.getString(2));
            dt.setTenDeThi(rs.getString(3));
            dt.setMatKhau(rs.getString(4));
            dt.setNgayThi(rs.getString(5));
            dt.setThoiGianBatDauThi(rs.getString(6));
            dt.setTrangThai(rs.getInt(7));
            dt.setSLCauHoi(rs.getInt(8));
            dt.setThoiGianLamBai(rs.getInt(9));
            arr.add(dt);
        }
        return arr;
    }

    public void updateTrangThaiDeThi(String maDT) throws SQLException {
        ArrayList<deThiDTO> arr = new ArrayList<>();
        String query = "UPDATE dethi SET trangthai = 2 WHERE MaDT = ?";
        PreparedStatement pre = conn.preparedStatement(query);
        pre.setString(1, maDT);
        int rowsAffected = pre.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Thành công.");
        } else {
            System.out.println("Khong thanh cong");
        }
    }

    public static void main(String[] args) throws SQLException {
        deThiDAO dt = new deThiDAO();
        ArrayList<deThiDTO> arr = dt.layDSDeThiDaTao("TK4", 2);
        System.out.println(arr.size());
    }
}
