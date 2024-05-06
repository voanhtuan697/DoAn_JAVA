/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ketQuaDTO;
import DTO.lopDTO;
import DTO.nguoiDungDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author E7250
 */
public class ketQuaDAO {

    private final MyConnection conn;
    private ketQuaDTO ketQuaDTO;
    public ketQuaDAO() throws SQLException {
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
    
    
    public ArrayList<ketQuaDTO> DanhSach(String TenMon, String MaDT, String MaLop) {
        ArrayList<ketQuaDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT ND.MaUser, ND.HoTen, KQ.Diem, LOP.MaLop, MON.TenMon, KQ.* "
                    + "FROM NGUOIDUNG ND "
                    + "JOIN TAIKHOAN TK ON ND.MaUser = TK.TenDN "
                    + "JOIN KETQUA KQ ON TK.MaTK = KQ.MaTK "
                    + "JOIN DETHI DT ON KQ.MaDT = DT.MaDT "
                    + "JOIN CHITIETDELOP CDL ON DT.MaDT = CDL.MaDT "
                    + "JOIN LOP ON CDL.MaLop = LOP.MaLop "
                    + "JOIN MON ON LOP.MaMon = MON.MaMon "
                    + "WHERE MON.TenMon = ? "
                    + "AND DT.MaDT = ? "
                    + "AND LOP.MaLop = ?";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, TenMon);
                pre.setString(2, MaDT);
                pre.setString(3, MaLop);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    ketQuaDTO = new ketQuaDTO(rs.getString("MaKQ"), rs.getString("MaDT"), rs.getString("TGLamXong"), rs.getString("MaTK"), rs.getInt("SLCauDung"), rs.getFloat("Diem"));
                    lopDTO lop = new lopDTO();
                    lop.setMaLop(rs.getString("MaLop"));
                    lop.getMonDTO().setTenMon(rs.getString("TenMon"));
                    ketQuaDTO.setLopDTO(lop);
                    nguoiDungDTO ngdung = new nguoiDungDTO();
                    ngdung.setHoTen(rs.getString("HoTen"));
                    ngdung.setMaUser(rs.getString("MaUser"));
                    ketQuaDTO.setNgDungDTO(ngdung);
                    list.add(ketQuaDTO);
                }
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay danh sach that bai");
        }
        return list;
    }

    public ArrayList<ketQuaDTO> DanhSachMax(String TenMon, String MaDT, String MaLop) {
        ArrayList<ketQuaDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT NGUOIDUNG.MaUser, NGUOIDUNG.HoTen, KETQUA.Diem, LOP.MaLop, MON.TenMon, KETQUA.* "
                    + "FROM KETQUA "
                    + "JOIN TAIKHOAN ON KETQUA.MaTK = TAIKHOAN.MaTK "
                    + "JOIN NGUOIDUNG ON TAIKHOAN.TenDN = NGUOIDUNG.MaUser "
                    + "JOIN DETHI ON KETQUA.MaDT = DETHI.MaDT "
                    + "JOIN CHITIETDELOP ON DETHI.MaDT = CHITIETDELOP.MaDT "
                    + "JOIN LOP ON CHITIETDELOP.MaLop = LOP.MaLop "
                    + "JOIN MON ON LOP.MaMon = MON.MaMon "
                    + "WHERE MON.TenMon = ? "
                    + "AND DETHI.MaDT = ? "
                    + "AND LOP.MaLop = ? "
                    + "AND KETQUA.Diem = (SELECT MAX(Diem) FROM KETQUA WHERE DETHI.MaDT = ? AND LOP.MaLop = ? AND MON.TenMon = ?)";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, TenMon);
                pre.setString(2, MaDT);
                pre.setString(3, MaLop);
                pre.setString(4, MaDT);
                pre.setString(5, MaLop);
                pre.setString(6, TenMon);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    ketQuaDTO = new ketQuaDTO(rs.getString("MaKQ"), rs.getString("MaDT"), rs.getString("TGLamXong"), rs.getString("MaTK"), rs.getInt("SLCauDung"), rs.getFloat("Diem"));
                    lopDTO lop = new lopDTO();
                    lop.setMaLop(rs.getString("MaLop"));
                    lop.getMonDTO().setTenMon(rs.getString("TenMon"));
                    ketQuaDTO.setLopDTO(lop);
                    nguoiDungDTO ngdung = new nguoiDungDTO();
                    ngdung.setHoTen(rs.getString("HoTen"));
                    ngdung.setMaUser(rs.getString("MaUser"));
                    ketQuaDTO.setNgDungDTO(ngdung);
                    list.add(ketQuaDTO);
                }
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay danh sach max that bai" + e.getMessage());
        }
        return list;
    }

    public ArrayList<ketQuaDTO> DanhSachMin(String TenMon, String MaDT, String MaLop) {
        ArrayList<ketQuaDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT NGUOIDUNG.MaUser, NGUOIDUNG.HoTen, KETQUA.Diem, LOP.MaLop, MON.TenMon, KETQUA.* "
                    + "FROM KETQUA "
                    + "JOIN TAIKHOAN ON KETQUA.MaTK = TAIKHOAN.MaTK "
                    + "JOIN NGUOIDUNG ON TAIKHOAN.TenDN = NGUOIDUNG.MaUser "
                    + "JOIN DETHI ON KETQUA.MaDT = DETHI.MaDT "
                    + "JOIN CHITIETDELOP ON DETHI.MaDT = CHITIETDELOP.MaDT "
                    + "JOIN LOP ON CHITIETDELOP.MaLop = LOP.MaLop "
                    + "JOIN MON ON LOP.MaMon = MON.MaMon "
                    + "WHERE MON.TenMon = ? "
                    + "AND DETHI.MaDT = ? "
                    + "AND LOP.MaLop = ? "
                    + "AND KETQUA.Diem = (SELECT MIN(Diem) FROM KETQUA WHERE DETHI.MaDT = ? AND LOP.MaLop = ? AND MON.TenMon = ?)";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, TenMon);
                pre.setString(2, MaDT);
                pre.setString(3, MaLop);
                pre.setString(4, MaDT);
                pre.setString(5, MaLop);
                pre.setString(6, TenMon);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    ketQuaDTO = new ketQuaDTO(rs.getString("MaKQ"), rs.getString("MaDT"), rs.getString("TGLamXong"), rs.getString("MaTK"), rs.getInt("SLCauDung"), rs.getFloat("Diem"));
                    lopDTO lop = new lopDTO();
                    lop.setMaLop(rs.getString("MaLop"));
                    lop.getMonDTO().setTenMon(rs.getString("TenMon"));
                    ketQuaDTO.setLopDTO(lop);
                    nguoiDungDTO ngdung = new nguoiDungDTO();
                    ngdung.setHoTen(rs.getString("HoTen"));
                    ngdung.setMaUser(rs.getString("MaUser"));
                    ketQuaDTO.setNgDungDTO(ngdung);
                    list.add(ketQuaDTO);
                }
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay danh sach max that bai" + e.getMessage());
        }
        return list;
    }

    public ArrayList<ketQuaDTO> DanhSachTruot(String TenMon, String MaDT, String MaLop) {
        ArrayList<ketQuaDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT NGUOIDUNG.MaUser, NGUOIDUNG.HoTen, KETQUA.Diem, LOP.MaLop, MON.TenMon, KETQUA.* "
                    + "FROM KETQUA "
                    + "JOIN TAIKHOAN ON KETQUA.MaTK = TAIKHOAN.MaTK "
                    + "JOIN NGUOIDUNG ON TAIKHOAN.TenDN = NGUOIDUNG.MaUser "
                    + "JOIN DETHI ON KETQUA.MaDT = DETHI.MaDT "
                    + "JOIN CHITIETDELOP ON DETHI.MaDT = CHITIETDELOP.MaDT "
                    + "JOIN LOP ON CHITIETDELOP.MaLop = LOP.MaLop "
                    + "JOIN MON ON LOP.MaMon = MON.MaMon "
                    + "WHERE MON.TenMon = ? "
                    + "AND DETHI.MaDT = ? "
                    + "AND LOP.MaLop = ? "
                    + "AND KETQUA.Diem < 5";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, TenMon);
                pre.setString(2, MaDT);
                pre.setString(3, MaLop);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    ketQuaDTO = new ketQuaDTO(rs.getString("MaKQ"), rs.getString("MaDT"), rs.getString("TGLamXong"), rs.getString("MaTK"), rs.getInt("SLCauDung"), rs.getFloat("Diem"));
                    lopDTO lop = new lopDTO();
                    lop.setMaLop(rs.getString("MaLop"));
                    lop.getMonDTO().setTenMon(rs.getString("TenMon"));
                    ketQuaDTO.setLopDTO(lop);
                    nguoiDungDTO ngdung = new nguoiDungDTO();
                    ngdung.setHoTen(rs.getString("HoTen"));
                    ngdung.setMaUser(rs.getString("MaUser"));
                    ketQuaDTO.setNgDungDTO(ngdung);
                    list.add(ketQuaDTO);
                }
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay danh sach that bai");
        }
        return list;
    }

    public ArrayList<ketQuaDTO> DanhSachKhoang(String TenMon, String MaDT, String MaLop, float start, float end) {
        ArrayList<ketQuaDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT NGUOIDUNG.MaUser, NGUOIDUNG.HoTen, KETQUA.Diem, LOP.MaLop, MON.TenMon, KETQUA.* "
                    + "FROM KETQUA "
                    + "JOIN TAIKHOAN ON KETQUA.MaTK = TAIKHOAN.MaTK "
                    + "JOIN NGUOIDUNG ON TAIKHOAN.TenDN = NGUOIDUNG.MaUser "
                    + "JOIN DETHI ON KETQUA.MaDT = DETHI.MaDT "
                    + "JOIN CHITIETDELOP ON DETHI.MaDT = CHITIETDELOP.MaDT "
                    + "JOIN LOP ON CHITIETDELOP.MaLop = LOP.MaLop "
                    + "JOIN MON ON LOP.MaMon = MON.MaMon "
                    + "WHERE MON.TenMon = ? "
                    + "AND DETHI.MaDT = ? "
                    + "AND LOP.MaLop = ? "
                    + "AND KETQUA.Diem  BETWEEN ? AND ?";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, TenMon);
                pre.setString(2, MaDT);
                pre.setString(3, MaLop);
                pre.setFloat(4, start);
                pre.setFloat(5, end);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    ketQuaDTO = new ketQuaDTO(rs.getString("MaKQ"), rs.getString("MaDT"), rs.getString("TGLamXong"), rs.getString("MaTK"), rs.getInt("SLCauDung"), rs.getFloat("Diem"));
                    lopDTO lop = new lopDTO();
                    lop.setMaLop(rs.getString("MaLop"));
                    lop.getMonDTO().setTenMon(rs.getString("TenMon"));
                    ketQuaDTO.setLopDTO(lop);
                    nguoiDungDTO ngdung = new nguoiDungDTO();
                    ngdung.setHoTen(rs.getString("HoTen"));
                    ngdung.setMaUser(rs.getString("MaUser"));
                    ketQuaDTO.setNgDungDTO(ngdung);
                    list.add(ketQuaDTO);
                }
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay danh sach that bai");
        }
        return list;
    }

//    public static void main(String[] args) {
//        ketQuaDAO2 p = new ketQuaDAO2();
////        ArrayList<ketQuaDTO> list = p.DanhSachTruot("Quản trị doanh nghiệp", "DTQTDN1", "LQTDN1");
//        ArrayList<ketQuaDTO> list = p.DanhSachKhoang("Quản trị doanh nghiệp", "DTQTDN1", "LQTDN1", 5, 8);
//        for (ketQuaDTO k : list) {
////            System.out.println(x.getNgDungDTO().getHoTen() + "  " + x.getDiem());
//            System.out.println(k.getNgDungDTO().getMaUser() + "  " + k.getNgDungDTO().getHoTen() + "  " + k.getDiem() + "  " + k.getLopDTO().getMaLop() + "  " + k.getLopDTO().getMonDTO().getTenMon());
//        }
//    }
}
