/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.monDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class monDAO {

    private MyConnection conn;

    public monDAO() {
        try {
            conn = new MyConnection();
        } catch (Exception e) {
            System.out.println("Ket noi database khong thanh cong" + e.getMessage());
        }
    }

    public ArrayList<monDTO> layDanhSachMon() {
        ArrayList<monDTO> arr = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT * FROM mon";
            PreparedStatement stmt = conn.preparedStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                monDTO mon = new monDTO();
                mon.setMaMon(rs.getString(1));
                mon.setTenMon(rs.getString(2));
                arr.add(mon);
            }
            stmt.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Lay danh sach mon khong thanh cong" + e.getMessage());
        }
        return arr;
    }

    public String layTenMonTheoMaMon(String maMon) {
        try {
            conn.Connect();
            String sql = "SELECT TenMon FROM mon WHERE MaMon=?";
            PreparedStatement stmt = conn.preparedStatement(sql);
            stmt.setString(1, maMon);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
            stmt.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Lay ten mon khong thanh cong" + e.getMessage());
        }
        return null;
    }

    public String layMaMonTheoTenMon(String tenMon) {
        try {
            conn.Connect();
            String sql = "SELECT MaMon FROM mon WHERE TenMon=?";
            PreparedStatement stmt = conn.preparedStatement(sql);
            stmt.setString(1, tenMon);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
            stmt.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Lay ma mon khong thanh cong" + e.getMessage());
        }
        return null;
    }

    public String layTenMonTheoMaDeThi(String maDT) {
        try {
            conn.Connect();
            String sql = "select TenMon from MON, CHITIETDELOP, LOP,DETHI where MON.MaMon=LOP.MaMon and CHITIETDELOP.MaLop=LOP.MaLop and DETHI.MaDT = CHITIETDELOP.MaDT and DETHI.MaDT=?";
            PreparedStatement stmt = conn.preparedStatement(sql);
            stmt.setString(1, maDT);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
            stmt.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Lay ten mon khong thanh cong" + e.getMessage());
        }
        return null;
    }

    public ArrayList<monDTO> layMonTuLop() {
        ArrayList<monDTO> arr = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT DISTINCT mon.MaMon, TenMon FROM mon,lop WHERE lop.MaMon = mon.MaMon";
            PreparedStatement stmt = conn.preparedStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                monDTO mon = new monDTO();
                mon.setMaMon(rs.getString(1));
                mon.setTenMon(rs.getString(2));
                arr.add(mon);

            }
            stmt.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Lay mon khong thanh cong" + e.getMessage());
        }
        return arr;
    }

    public ArrayList<monDTO> layCacMonChuaCoKho() {
        ArrayList<monDTO> arr = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "select m.mamon, tenmon from mon m join khocauhoi kch on kch.mamon = m.mamon where matbm IS NULL";
            PreparedStatement pre = conn.preparedStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                monDTO mon = new monDTO();
                mon.setMaMon(rs.getString(1));
                mon.setTenMon(rs.getString(2));
                arr.add(mon);
            }
            pre.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Lay mon chua co kho khong thanh cong" + e.getMessage());
        }
        return arr;
    }

    public String layTenMonBangMaCH(String maCH) {
        String tenMon = "";
        try {
            conn.Connect();
            String query = "select tenmon\n"
                    + "from cauhoi ch\n"
                    + "join khocauhoi k on ch.makho = k.makho\n"
                    + "join mon m on m.mamon = k.mamon\n"
                    + "where ch.mach = '" + maCH + "'";
            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                tenMon = rs.getString(1);
                pre.close();
                conn.disconnect();
                return tenMon;
            } else {
                // Xử lý trường hợp không có dữ liệu phù hợp với điều kiện
                System.out.println("Không có dữ liệu phù hợp với điều kiện.");
                pre.close();
                conn.disconnect();
                return "";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String layTenMonBangMaDT(String maDT) {
        String tenMon = "";
        try {
            conn.Connect();
            String query = "select TOP 1 tenmon\n"
                    + "from dethi dt\n"
                    + "join chitietdelop ct on ct.madt = dt.madt\n"
                    + "join lop l on l.malop = ct.malop\n"
                    + "join mon m on m.mamon = l.mamon\n"
                    + "where dt.madt = '" + maDT + "'";
            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                tenMon = rs.getString(1);
                pre.close();
                conn.disconnect();
                return tenMon;
            } else {
                System.out.println("Không có dữ liệu phù hợp với điều kiện.");
                pre.close();
                conn.disconnect();
                return "";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

    public ArrayList<monDTO> listMon() {
        ArrayList<monDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT * FROM MON";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    monDTO item = new monDTO(rs.getString("MaMon"), rs.getString("TenMon"));
                    list.add(item);
                }
              pre.close();
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay danh sach mon that bai");
        }
        return list;
    }

    public String getMaMonByName(String name) {
        String MaMon = "";
        try {
            conn.Connect();
            String sql = "SELECT MaMon FROM MON WHERE TenMon=?";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, name);
                ResultSet rs = pre.executeQuery();
                if (rs.next()) {
                    MaMon = rs.getString("MaMon");
                }
             pre.close();
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Doi ma mon that bai" + e.getMessage());
        }
        return MaMon;
    }

    public String getNameByMaMon(String MaMon) {
        String TenMon = "";
        try {
            conn.Connect();
            String sql = "SELECT TenMon FROM MON WHERE MaMon=?";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, MaMon);
                ResultSet rs = pre.executeQuery();
                if (rs.next()) {
                    TenMon = rs.getString("TenMon");
                }
             pre.close();
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Doi ma mon that bai" + e.getMessage());
        }
        return TenMon;
    }

    public boolean ThemMon(monDTO m) {
        boolean success = false;
        try {
            conn.Connect();
            String check = "SELECT COUNT(*) FROM MON WHERE TenMon=?";
            PreparedStatement preCheck = conn.preparedStatement(check);
            preCheck.setString(1, m.getTenMon());
            ResultSet rs = preCheck.executeQuery();
            rs.next();
            int count = rs.getInt(1);
            if (count > 0) {
                System.out.println("Môn đã tồn tại trong csdl");
                return false;
            }
            String sql = "INSERT INTO MON(MaMon,TenMon) VALUES(?,?)";
            PreparedStatement pre = conn.preparedStatement(sql);
            pre.setString(1, m.getMaMon());
            pre.setString(2, m.getTenMon());
            success = pre.executeUpdate() > 0;
            pre.close();
            conn.disconnect();
        } catch (SQLException e) {
            System.out.println("Them mon that bai" + e.getMessage());
        }
        return success;
    }

    public static void main(String[] args) {
        monDAO m = new monDAO();
        String ss = m.layTenMonBangMaDT("DTTH1");
        System.out.println(ss);
    }
}
