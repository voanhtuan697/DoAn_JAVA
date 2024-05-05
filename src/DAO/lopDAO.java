/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;
import DTO.lopDTO;
import java.time.Year;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class lopDAO {

    private MyConnection conn;
    private lopDTO lop;

    public lopDAO() throws SQLException {
        this.conn = new MyConnection();
        conn.Connect();
    }

    public ArrayList<String> layMaLopTheoMon(String tenMon) throws SQLException {
        ArrayList<String> arr = new ArrayList<>();
        String sql = "SELECT MaLop FROM lop, mon WHERE lop.MaMon = mon.MaMon AND TenMon=?";
        PreparedStatement stmt = conn.preparedStatement(sql);
        stmt.setString(1, tenMon);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            arr.add(rs.getString(1));
        }
        return arr;
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
                    + "where tk.matk = '" + maTK + "' and dt.madt = '" + maDT + "'";

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

    public ArrayList<lopDTO> layDanhSachLopTheoMaGV(String maGV) throws SQLException {
        ArrayList<lopDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM LOP WHERE MaGV=?";
        PreparedStatement stmt = conn.preparedStatement(sql);
        stmt.setString(1, maGV);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            lopDTO x = new lopDTO();
            x.setMaLop(rs.getString(1));
            x.setSoLuong(rs.getInt(3));
            x.setMaMon(rs.getString(4));
            x.setNam(rs.getInt(5));
            x.setHocKy(rs.getInt(6));
            x.setTrangThai(rs.getBoolean(7));
            x.setNhomLop(rs.getInt(8));
            list.add(x);
        }
        return list;
    }

    public ArrayList<lopDTO> listLop() {
        ArrayList<lopDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT * FROM LOP";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    lopDTO item = new lopDTO(rs.getString("MaLop"), rs.getString("MaGV"), rs.getString("MaMon"), rs.getBoolean("TrangThai"), rs.getInt("SoLuong"), rs.getInt("Nam"), rs.getInt("HocKy"), rs.getInt("NhomLop"));
                    list.add(item);
                }
            }
            conn.disconnect();
            System.out.println("Lay danh sach lop thanh cong");
        } catch (SQLException e) {
            System.err.println("Lay danh sach that bai" + e.getMessage());
        }
        return list;
    }

    public boolean ThemLop(lopDTO l) {
        boolean success = false;
        try {
            conn.Connect();
            String sql = "INSERT INTO LOP(MaLop,MaGV, SoLuong,MaMon,Nam,HocKy,TrangThai,NhomLop) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement pre = conn.preparedStatement(sql);
            pre.setString(1, l.getMaLop());
            pre.setString(2, l.getMaGV());
            pre.setInt(3, l.getSoLuong());
            pre.setString(4, l.getMaMon());
            pre.setInt(5, l.getNam());
            pre.setInt(6, l.getHocKy());
            pre.setBoolean(7, l.getTrangThai());
            pre.setInt(8, l.getNhomLop());
            success = pre.executeUpdate() > 0;
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Them lop bat thai" + e.getMessage());
        }
        return success;
    }

    public boolean XoaLop(String MaLop) {
        boolean success = false;
        try {
            conn.Connect();
            String check = "SELECT COUNT(*) FROM CHITIETLOP WHERE MaLop = ?";
            PreparedStatement pre1 = conn.preparedStatement(check);
            pre1.setString(1, MaLop);
            ResultSet rs1 = pre1.executeQuery();
            int count = 0;
            if (rs1.next()) {
                count = rs1.getInt(1);
            }

            if (count == 0) {
                String sql = "DELETE FROM LOP WHERE MaLop = ?";
                PreparedStatement pre = conn.preparedStatement(sql);
                pre.setString(1, MaLop);
                success = pre.executeUpdate() > 0;
            }

            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Xoa lop that bai" + e.getMessage());
        }
        return success;
    }

    public ArrayList<lopDTO> TimKiem(String input) {
        ArrayList<lopDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String keyword = "%" + input + "%";
            String sql = "SELECT * FROM LOP WHERE MaLop LIKE ?";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, keyword);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    lopDTO item = new lopDTO(rs.getString("MaLop"), rs.getString("MaGV"), rs.getString("MaMon"), rs.getBoolean("TrangThai"), rs.getInt("SoLuong"), rs.getInt("Nam"), rs.getInt("HocKy"), rs.getInt("NhomLop"));
                    list.add(item);
                }
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay danh sach that bai" + e.getMessage());
        }
        return list;
    }

    public ArrayList<lopDTO> listTrangThaiLop(int action) {
        ArrayList<lopDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT * FROM LOP WHERE TrangThai = ?";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setInt(1, action);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    lopDTO item = new lopDTO(rs.getString("MaLop"), rs.getString("MaGV"), rs.getString("MaMon"), rs.getBoolean("TrangThai"), rs.getInt("SoLuong"), rs.getInt("Nam"), rs.getInt("HocKy"), rs.getInt("NhomLop"));
                    list.add(item);
                }
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay danh sach that bai" + e.getMessage());
        }
        return list;
    }

    public String getMaLop(String TenMon) {
        String Malop = "";
        int nam = Year.now().getValue();
        try {
            conn.Connect();
            String sql = "SELECT TOP 1 LOP.MaLop "
                    + "FROM LOP "
                    + "INNER JOIN MON ON LOP.MaMon = MON.MaMon "
                    + "WHERE MON.TenMon = ? AND Nam = ? "
                    + "ORDER BY LOP.MaLop DESC";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, TenMon);
                pre.setInt(2, nam);
                ResultSet rs = pre.executeQuery();
                if (rs.next()) {
                    Malop = rs.getString("Malop");
                }
            }
        } catch (SQLException e) {
            System.err.println("error getMaLop" + e.getMessage());
        }
        return Malop;
    }

    public int getNhomLop(String TenMon) {
        int nhom = 0;
        int nam = Year.now().getValue();
        try {
            conn.Connect();
            String sql = "SELECT TOP 1 LOP.NhomLop "
                    + "FROM LOP "
                    + "INNER JOIN MON ON LOP.MaMon = MON.MaMon "
                    + "WHERE MON.TenMon = ? AND Nam = ? "
                    + "ORDER BY LOP.MaLop DESC";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, TenMon);
                pre.setInt(2, nam);
                ResultSet rs = pre.executeQuery();
                if (rs.next()) {
                    nhom = rs.getInt("NhomLop");
                }
            }
        } catch (SQLException e) {
            System.err.println("error getMaLop" + e.getMessage());
        }
        return nhom;
    }

    public ArrayList<lopDTO> getDSMaLop(String MaMon) {
        ArrayList<lopDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT * "
                    + "FROM LOP "
                    + "INNER JOIN CHITIETDELOP ON LOP.MaLop = CHITIETDELOP.MaLop "
                    + "WHERE LOP.MaMon = ?";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, MaMon);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    lop = new lopDTO(rs.getString("MaLop"), rs.getString("MaGV"), rs.getString("MaMon"), rs.getBoolean("TrangThai"), rs.getInt("SoLuong"), rs.getInt("Nam"), rs.getInt("HocKy"), rs.getInt("NhomLop"));
                    list.add(lop);
                }
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay ra ma lop that bai" + e.getMessage());
        }
        return list;
    }

    public ArrayList<lopDTO> getListNam() {
        ArrayList<lopDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT DISTINCT Nam FROM LOP";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    lop = new lopDTO(rs.getInt("Nam"));
                    list.add(lop);
                }
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay ra danh sach nam that bai" + e.getMessage());
        }
        return list;
    }

    public ArrayList<lopDTO> getMaByNamHKMon(int Nam, int HocKy, String TenMon) {
        ArrayList<lopDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT LOP.MaLop "
                    + "FROM LOP "
                    + "JOIN MON ON LOP.MaMon = MON.MaMon "
                    + "WHERE LOP.Nam = ? "
                    + "AND LOP.HocKy = ? "
                    + "AND MON.TenMon = ?";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setInt(1, Nam);
                pre.setInt(2, HocKy);
                pre.setString(3, TenMon);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    lop = new lopDTO(rs.getString("MaLop"));
                    list.add(lop);
                }
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay ra ma lop by nam hk mon that bai" + e.getMessage());
        }
        return list;
    }

}
