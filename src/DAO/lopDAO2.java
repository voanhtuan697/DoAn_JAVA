/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.lopDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;

public class lopDAO2 {

    private MyConnection conn;
    private lopDTO lop;

    public lopDAO2() {
        try {
            conn = new MyConnection();
        } catch (SQLException e) {
            System.err.println("Ket noi bat thai" + e.getMessage());
        }
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
            pre.setBoolean(7, l.isTrangThai());
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

    public ArrayList<lopDTO> DSLop1SV(String MaTK) {
        ArrayList<lopDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT LOP.* "
                    + "FROM LOP "
                    + "JOIN CHITIETLOP ON LOP.MaLop = CHITIETLOP.MaLop "
                    + "LEFT JOIN TAIKHOAN TK ON TK.MaTK = CHITIETLOP.MaSV "
                    + "WHERE tk.MaTK = ?";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, MaTK);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    lop = new lopDTO(rs.getString("MaLop"), rs.getString("MaGV"), rs.getString("MaMon"), rs.getBoolean("TrangThai"), rs.getInt("SoLuong"), rs.getInt("Nam"), rs.getInt("HocKy"), rs.getInt("NhomLop"));
                    list.add(lop);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lay ds lop 1 sv that bai" + e.getMessage());
        }
        return list;
    }

    public ArrayList<lopDTO> DSTrangThaiLop1SV(String MaTK, boolean Trangthai) {
        ArrayList<lopDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT LOP.* "
                    + "FROM LOP "
                    + "JOIN CHITIETLOP ON LOP.MaLop = CHITIETLOP.MaLop "
                    + "LEFT JOIN TAIKHOAN TK ON TK.MaTK = CHITIETLOP.MaSV "
                    + "WHERE tk.MaTK = ? AND LOP.TrangThai = ?";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, MaTK);
                pre.setBoolean(2, Trangthai);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    lop = new lopDTO(rs.getString("MaLop"), rs.getString("MaGV"), rs.getString("MaMon"), rs.getBoolean("TrangThai"), rs.getInt("SoLuong"), rs.getInt("Nam"), rs.getInt("HocKy"), rs.getInt("NhomLop"));
                    list.add(lop);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lay ds lop 1 sv that bai" + e.getMessage());
        }
        return list;
    }

    public ArrayList<lopDTO> TimKiemDS1SV(String MaTK, String keyword) {
        ArrayList<lopDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String key = "%" + keyword + "%";
            String sql = "SELECT LOP.* "
                    + "FROM LOP "
                    + "JOIN CHITIETLOP ON LOP.MaLop = CHITIETLOP.MaLop "
                    + "LEFT JOIN TAIKHOAN TK ON TK.MaTK = CHITIETLOP.MaSV "
                    + "WHERE tk.MaTK = ? AND LOP.MaLop LIKE ?";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, MaTK);
                pre.setString(2, key);
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    lop = new lopDTO(rs.getString("MaLop"), rs.getString("MaGV"), rs.getString("MaMon"), rs.getBoolean("TrangThai"), rs.getInt("SoLuong"), rs.getInt("Nam"), rs.getInt("HocKy"), rs.getInt("NhomLop"));
                    list.add(lop);
                }
            }
        } catch (SQLException e) {
            System.err.println("Lay ds lop 1 sv that bai" + e.getMessage());
        }
        return list;
    }

    public static void main(String[] args) {
        lopDAO2 dao = new lopDAO2();
        String x = dao.getMaLop("Toán rời rạc");
        System.out.println(x);

        int nhom = dao.getNhomLop("Toán rời rạc");
        System.out.println(nhom);

        ArrayList<lopDTO> list = dao.getListNam();
        for (lopDTO p : list) {
            System.out.println(p.getNam());
        }
    }
}
