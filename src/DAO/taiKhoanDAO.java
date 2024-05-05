/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.nguoiDungDTO;
import DTO.taiKhoanDTO;
import java.sql.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class taiKhoanDAO {

    private MyConnection conn;

    public taiKhoanDAO() {
        try {
            conn = new MyConnection();
        } catch (Exception e) {
            System.out.println("Ket noi database khong thanh cong" + e.getMessage());
        }
    }

    public ArrayList<taiKhoanDTO> getTaiKhoan() {
        ArrayList<taiKhoanDTO> arr = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT * FROM taikhoan";
            PreparedStatement stmt = conn.preparedStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                taiKhoanDTO acc = new taiKhoanDTO();
                acc.setMaTK(rs.getString(1));
                acc.setTenDN(rs.getString(2));
                acc.setMatKhau(rs.getString(3));
                acc.setTrangThai(rs.getBoolean(4));
                acc.setMaQuyen(rs.getString(5));
                arr.add(acc);
            }
            stmt.close();
            conn.disconnect();
        } catch (Exception e) {
            System.out.println("Lay danh sach tai khoan khong thanh cong" + e.getMessage());
        }
        return arr;
       
    }

    public int getSoLuongTaiKhoan() {
        try {
            conn.Connect();
            String sql = "SELECT COUNT(MaTK) FROM taikhoan";
            PreparedStatement stmt = conn.preparedStatement(sql);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return Integer.parseInt(rs.getString(1));
            }
            stmt.close();
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay so luong tai khoan khong thanh cong" + e.getMessage());
        }
        return 0;
    }

    public boolean addTaiKhoan(taiKhoanDTO a) {
        try {
            conn.Connect();
            String sql = "INSERT INTO taiKhoan(MaTK, TenDN, MatKhau, TrangThai, MaQuyen) VALUES (?,?,?,?,?)";
            PreparedStatement stmt = conn.preparedStatement(sql);
            stmt.setString(1, a.getMaTK());
            stmt.setString(2, a.getTenDN());
            stmt.setString(3, a.getMatKhau());
            stmt.setBoolean(4, a.isTrangThai());
            stmt.setString(5, a.getMaQuyen());
            int ketQua = stmt.executeUpdate();
            stmt.close();
            conn.disconnect();
            if (ketQua > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Them khong thanh cong" + e.getMessage());
        }
        return false;

    }

    public String getMaQuyenTheoTenDN(String tenDN) {
        String maQuyen = null;
        try {
            conn.Connect();
            String sql = "SELECT MaQuyen FROM taikhoan WHERE TenDN=?";
            PreparedStatement stmt = conn.preparedStatement(sql);
            stmt.setString(1, tenDN);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                maQuyen = rs.getString(1);
            }
            stmt.close();
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay ma quyen khong thanh cong" + e.getMessage());
        }
        return maQuyen;
    }

    public boolean deleteTaiKhoan(String tenDN) {
        try {
            conn.Connect();
            String sql = "UPDATE taikhoan SET TrangThai='0' WHERE TenDN=?";
            PreparedStatement stmt = conn.preparedStatement(sql);
            stmt.setString(1, tenDN);
            int rs = stmt.executeUpdate();
            stmt.close();
            conn.disconnect();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Xoa tai khoan khong thanh cong" + e.getMessage());
        }
        return false;
    }

    public boolean updateTaiKhoan(String maQuyen, String tenDN) {
        try {
            conn.Connect();
            String sql = "UPDATE taikhoan SET MaQuyen=? WHERE TenDN=?";
            PreparedStatement stmt = conn.preparedStatement(sql);
            stmt.setString(1, maQuyen);
            stmt.setString(2, tenDN);
            int rs = stmt.executeUpdate();
            stmt.close();
            conn.disconnect();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Cap nhat tai khoan khong thanh cong" + e.getMessage());
        }
        return false;
    }

    public boolean updateMatKhau(String matKhau, String maTK) {
        try {
            conn.Connect();
            String sql = "UPDATE taikhoan SET MatKhau=? WHERE MaTK=?";
            PreparedStatement stmt = conn.preparedStatement(sql);
            stmt.setString(1, matKhau);
            stmt.setString(2, maTK);

            int rs = stmt.executeUpdate();
            stmt.close();
            conn.disconnect();
            if (rs > 0) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("Cap nhat mat khau khong thanh cong" + e.getMessage());
        }
        return false;
    }

    public ArrayList<taiKhoanDTO> listGgTrBm() {
        ArrayList<taiKhoanDTO> list = new ArrayList<>();
        try {
            conn.Connect();
            String sql = "SELECT tk.*, nd.HoTen FROM TAIKHOAN tk INNER JOIN NGUOIDUNG nd ON tk.TenDN = nd.MaUser WHERE tk.MaQuyen='QGV' OR tk.MaQuyen='QTBM'";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                ResultSet rs = pre.executeQuery();
                while (rs.next()) {
                    taiKhoanDTO item = new taiKhoanDTO(rs.getString("MaTK"), rs.getString("TenDN"), rs.getString("MatKhau"), rs.getBoolean("TrangThai"), rs.getString("MaQuyen"));
                    nguoiDungDTO ngDung = new nguoiDungDTO();
                    ngDung.setHoTen(rs.getString("HoTen"));
                    item.setNgDung(ngDung);
                    list.add(item);
                }
                pre.close();
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay danh sach gv trnm khong thanh cong" + e.getMessage());
        }
        return list;
    }

    public String layMaTKTheoTenDN(String tenDN) {
        String maTK = null;
        try {
            conn.Connect();
            String sql = "SELECT MaTK FROM taikhoan WHERE TenDN=?";
            PreparedStatement stmt = conn.preparedStatement(sql);
            stmt.setString(1, tenDN);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                maTK = rs.getString(1);
            }
            stmt.close();
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Lay ma TK khong thanh cong" + e.getMessage());
        }
        return maTK;
    }

    public String getMaTkByName(String ten) {
        String MaTk = "";
        try {
            conn.Connect();
            String sql = "SELECT tk.MaTK FROM TAIKHOAN tk INNER JOIN NGUOIDUNG nd ON tk.TenDN = nd.MaUser WHERE nd.HoTen = ?";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, ten);
                ResultSet rs = pre.executeQuery();
                if (rs.next()) {
                    MaTk = rs.getString("MaTK");
                }
                pre.close();
            }
            conn.disconnect();

        } catch (SQLException e) {
            System.err.println("Chuyen doi ma that bai" + e.getMessage());
        }
        return MaTk;
    }

    public ArrayList<String> layDanhSachMaCN(String maTK) {
        ArrayList<String> arr = new ArrayList<>();
        try {
            conn.Connect();
            String query = "SELECT MaCN\n"
                    + "FROM TAIKHOAN TK\n"
                    + "JOIN QUYEN Q ON TK.MaQuyen = Q.MaQuyen\n"
                    + "JOIN CHITIETQUYEN CTQ ON Q.MaQuyen = CTQ.MaQuyen\n"
                    + "WHERE TK.MaTK ='" + maTK + "'";
            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                arr.add(rs.getString(1).trim());
            }
            pre.close();
            conn.disconnect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arr;
    }

    public taiKhoanDTO layTaiKhoan(String maTK) {
        taiKhoanDTO tk = new taiKhoanDTO();
        try {
            conn.Connect();
            String query = "SELECT* FROM TAIKHOAN TK WHERE TK.MaTK ='" + maTK + "'";

            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                tk.setMaTK(rs.getString(1).trim());
                tk.setTenDN(rs.getString(2).trim());
                tk.setMatKhau(rs.getString(3));
                tk.setTrangThai(rs.getBoolean(4));
                tk.setMaQuyen(rs.getString(5).trim());
                pre.close();
                conn.disconnect();
                return tk;
            } else {
                // Xử lý trường hợp không có dữ liệu phù hợp với điều kiện
                System.out.println("Không có dữ liệu phù hợp với điều kiện.");
                conn.disconnect();
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getNameByMaTk(String MaTK) {
        String MaTk = "";
        try {
            conn.Connect();
            String sql = "SELECT nd.HoTen FROM TAIKHOAN tk INNER JOIN NGUOIDUNG nd ON tk.TenDN = nd.MaUser WHERE tk.MaTK = ?";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, MaTK);
                ResultSet rs = pre.executeQuery();
                if (rs.next()) {
                    MaTk = rs.getString("HoTen");
                }
                pre.close();
            }
            conn.disconnect();

        } catch (SQLException e) {
            System.err.println("Chuyen doi ten that bai" + e.getMessage());
        }
        return MaTk;
    }

    public String getMaTkByTenDN(String TenDN) {
        String MaTk = "";
        try {
            conn.Connect();
            String sql = "SELECT tk.MaTK FROM TAIKHOAN tk INNER JOIN NGUOIDUNG nd ON tk.TenDN = nd.MaUser WHERE nd.MaUser = ?";
            try (PreparedStatement pre = conn.preparedStatement(sql)) {
                pre.setString(1, TenDN);
                ResultSet rs = pre.executeQuery();
                if (rs.next()) {
                    MaTk = rs.getString("MaTK");
                }
                pre.close();
            }
            conn.disconnect();
        } catch (SQLException e) {
            System.err.println("Chuyen doi ten that bai" + e.getMessage());
        }
        return MaTk;
    }

}
