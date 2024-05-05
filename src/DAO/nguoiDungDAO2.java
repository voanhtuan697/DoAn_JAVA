/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.nguoiDungDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class nguoiDungDAO2 {

    private MyConnection conn;
    private nguoiDungDTO ng;

    public nguoiDungDAO2() {
        try {
            conn = new MyConnection();
        } catch (SQLException e) {
            System.err.println("Ket noi database that bai");
        }
    }

    public ArrayList<nguoiDungDTO> getThongTinSV(int Nam, int HocKy, String TenMon, String MaLop) {
        ArrayList<nguoiDungDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT ND.* "
                    + "FROM NGUOIDUNG ND "
                    + "JOIN TAIKHOAN TK ON ND.MaUser = TK.TenDN "
                    + "WHERE TK.MaQuyen = 'QSV' AND TK.TrangThai = 1 AND NOT EXISTS ( "
                    + "    SELECT 1 "
                    + "    FROM CHITIETLOP CT "
                    + "    JOIN LOP L ON L.MaLop = CT.MaLop "
                    + "    JOIN MON M ON L.MaMon = M.MaMon "
                    + "    WHERE CT.MaSV = TK.MaTK "
                    + "      AND L.Nam = ? "
                    + "      AND L.HocKy = ? "
                    + "      AND M.TenMon = ? "
                    + "      AND CT.MaLop = ?"
                    + ");";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setInt(1, Nam);
                pre.setInt(2, HocKy);
                pre.setString(3, TenMon);
                pre.setString(4, MaLop);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    ng = new nguoiDungDTO(rs.getString("MaUser"), rs.getString("HoTen"), rs.getString("NgSinh"));
                    list.add(ng);
                }
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay thong tin sv that bai" + e.getMessage());
        }
        return list;
    }

    public ArrayList<nguoiDungDTO> TimKiem(int Nam, int HocKy, String TenMon, String MaLop, String key) {
        ArrayList<nguoiDungDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT ND.* "
                    + "FROM NGUOIDUNG ND "
                    + "JOIN TAIKHOAN TK ON ND.MaUser = TK.TenDN "
                    + "WHERE TK.MaQuyen = 'QSV' AND TK.TrangThai = 1 AND ND.HoTen LIKE ? AND NOT EXISTS ( "
                    + "    SELECT 1 "
                    + "    FROM CHITIETLOP CT "
                    + "    JOIN LOP L ON L.MaLop = CT.MaLop "
                    + "    JOIN MON M ON L.MaMon = M.MaMon "
                    + "    WHERE CT.MaSV = TK.MaTK "
                    + "      AND L.Nam = ? "
                    + "      AND L.HocKy = ? "
                    + "      AND M.TenMon = ? "
                    + "      AND CT.MaLop = ?"
                    + ");";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                String keyword = "%" + key + "%";
                pre.setString(1, keyword);
                pre.setInt(2, Nam);
                pre.setInt(3, HocKy);
                pre.setString(4, TenMon);
                pre.setString(5, MaLop);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    ng = new nguoiDungDTO(rs.getString("MaUser"), rs.getString("HoTen"), rs.getString("NgSinh"));
                    list.add(ng);
                }
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay thong tin sv that bai" + e.getMessage());
        }
        return list;
    }

    public ArrayList<nguoiDungDTO> DSTenGV(String TenMon) {
        ArrayList<nguoiDungDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT ND.HoTen "
                    + "FROM TAIKHOAN TK "
                    + "JOIN NGUOIDUNG ND ON TK.TenDN = ND.MaUser "
                    + "JOIN CHITIETMON CTM ON TK.MaTK = CTM.MaGV "
                    + "JOIN Mon M ON CTM.MaMon = M.MaMon "
                    + "WHERE TK.MaQuyen = 'QGV' "
                    + "AND TK.TrangThai = 1 "
                    + "AND M.TenMon = ?";
            try(PreparedStatement pre = conn.preparedStatement(sql)){
                pre.setString(1, TenMon);
                ResultSet rs = pre.executeQuery();
                while(rs.next()){
                    ng = new nguoiDungDTO(rs.getString("HoTen"));
                    list.add(ng);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lay danh sach gv that bai" + e.getMessage());
        }
        return list;
    }
    
    
    public ArrayList<nguoiDungDTO> DSGiaoVien(){
        ArrayList<nguoiDungDTO> list = new ArrayList<>();
        try{
            conn.Connect();
            String sql = "SELECT ND.MaUser, ND.HoTen, ND.NgSinh FROM NGUOIDUNG ND JOIN TAIKHOAN TK ON TK.TenDN = ND.MaUser WHERE TK.MaQuyen ='QGV' AND TK.TrangThai = 1";
            try(PreparedStatement pre = conn.preparedStatement(sql)){
                ResultSet rs = pre.executeQuery();
                while(rs.next()){
                    ng = new nguoiDungDTO(rs.getString("MaUser"), rs.getString("HoTen"), rs.getString("NgSinh"));
                    list.add(ng);
                }
            }
        }catch(SQLException e){
            System.err.println("Lay danh sach gv that bai" + e.getMessage());
        }
        return list;
    }

    public static void main(String[] args) {
        nguoiDungDAO2 dao = new nguoiDungDAO2();
        ArrayList<nguoiDungDTO> list = dao.TimKiem(2024, 1, "Quản trị doanh nghiệp", "LQTDN1", "L");
        for (nguoiDungDTO x : list) {
            System.out.println(x.getMaUser() + "    " + x.getHoTen());
        }
    }

}
