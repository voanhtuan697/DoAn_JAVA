/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.deThiDTO;
import java.sql.*;
import java.util.ArrayList;

public class deThiDAO {

    private MyConnection conn;
    private deThiDTO de;
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

    public int laySoLuongDeThiTheoMon(String maMon) throws SQLException {
        String sql = "select count(dt.MaDT) from DETHI dt, CHITIETDELOP ct, LOP l , MON m where dt.MaDT=ct.MaDT and ct.MaLop=l.MaLop and l.MaMon=m.MaMon and m.MaMon=?";
        PreparedStatement pre = conn.preparedStatement(sql);
        pre.setString(1, maMon);
        ResultSet rs = pre.executeQuery();
        if (rs.next()) {
            return rs.getInt(1);
        }
        return 0;
    }
    //    Object[] colDeThi = {"Mã đề thi", "Người tạo", "Tên đề thi", "Môn thi", "Số câu hỏi", "Ngày thi", "Thời gian", "Lớp", "Mật khẩu"};

    public boolean themDeThi(String maDT, String maTK, String tenDT, String matKhau, java.util.Date ngayThi, Time thoiGianBatDau, int trangThai, int soLuongCau, int thoiGianLamBai, String maLop, ArrayList<String> dsMaCH) throws SQLException {
        String sqlDeThi = "INSERT INTO dethi(MaDT, MaGV, TenDeThi, Matkhau, NgayThi, ThoiGianBatDauThi, TrangThai, SoLuongCau, ThoiGianLamBai) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement stmt = conn.preparedStatement(sqlDeThi);
        stmt.setString(1, maDT);
        stmt.setString(2, maTK);
        stmt.setString(3, tenDT);
        stmt.setString(4, matKhau);
        stmt.setDate(5, new Date(ngayThi.getTime()));
        stmt.setTime(6, thoiGianBatDau);
        stmt.setInt(7, trangThai);
        stmt.setInt(8, soLuongCau);
        stmt.setInt(9, thoiGianLamBai);
        int rs = stmt.executeUpdate();

        String sqlChiTietDeLop = "INSERT INTO chitietdelop(MaDT, MaLop) VALUES(?,?)";
        PreparedStatement st = conn.preparedStatement(sqlChiTietDeLop);
        st.setString(1, maDT);
        st.setString(2, maLop);
        int rs1 = st.executeUpdate();

        String sqlChiTietDe = "INSERT INTO chitietde(MaCH, MaDT) VALUES(?,?)";
        PreparedStatement st2 = conn.preparedStatement(sqlChiTietDe);
        for (String x : dsMaCH) {
            st2.setString(1, x);
            st2.setString(2, maDT);
        }
        int rs2 = st2.executeUpdate();

        if (rs > 0 && rs1 > 0 && rs2 > 0) {
            return true;
        }
        return false;
    }

    public deThiDTO layDeThiTheoMaDT(String maDT) throws SQLException {
        String sql = "SELECT * FROM DETHI WHERE MaDT=?";
        deThiDTO dt = new deThiDTO();

        PreparedStatement stmt = conn.preparedStatement(sql);
        stmt.setString(1, maDT);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            dt.setMaDT(rs.getString(1));
            dt.setMaGV(rs.getString(2));
            dt.setTenDeThi(rs.getString(3));
            dt.setMatKhau(rs.getString(4));
            dt.setNgayThi(rs.getString(5));
            dt.setThoiGianBatDauThi(rs.getString(6));
            dt.setTrangThai(rs.getInt(7));
            dt.setSLCauHoi(rs.getInt(8));
            dt.setThoiGianLamBai(rs.getInt(9));
        }
        return dt;
    }

    public boolean xoaDeThiBangMaDT(String maDT) throws SQLException {
        String sqlChiTietDe = "DELETE FROM chitietde WHERE MaDT=?";
        PreparedStatement stmt1 = conn.preparedStatement(sqlChiTietDe);
        stmt1.setString(1, maDT);
        int rs1 = stmt1.executeUpdate();

        String sqlChiTietDeLop = "DELETE FROM chitietdelop WHERE MaDT=?";
        PreparedStatement stmt2 = conn.preparedStatement(sqlChiTietDeLop);
        stmt2.setString(1, maDT);
        int rs2 = stmt2.executeUpdate();

        String sqlDeThi = "DELETE FROM dethi WHERE MaDT=?";
        PreparedStatement stmt3 = conn.preparedStatement(sqlDeThi);
        stmt3.setString(1, maDT);
        int rs3 = stmt3.executeUpdate();

        if (rs1 > 0 && rs2 > 0 && rs3 > 0) {
            return true;
        }
        return false;
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

    public ArrayList<deThiDTO> getMaTen() {
        ArrayList<deThiDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT MaDT, TenDeThi FROM DETHI WHERE TrangThai = 2;";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    de = new deThiDTO(rs.getString("MaDT"), rs.getString("TenDeThi"));
                    list.add(de);
                }
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay getMaTen that bai" + e.getMessage());
        }
        return list;
    }

    public ArrayList<deThiDTO> getDSMaDT(String MaMon) {
        ArrayList<deThiDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT MaDT "
                    + "FROM DETHI "
                    + "WHERE MaDT IN ("
                    + "    SELECT MaDT "
                    + "    FROM CHITIETDELOP "
                    + "    INNER JOIN LOP ON CHITIETDELOP.MaLop = LOP.MaLop "
                    + "    WHERE LOP.MaMon = ?)";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, MaMon);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    de = new deThiDTO(rs.getString("MaDT"));
                    list.add(de);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lay danh sach ma de thi that bai" + e.getMessage());
        }
        return list;
    }
}
