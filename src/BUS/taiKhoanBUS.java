/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.taiKhoanDAO;
import DTO.taiKhoanDTO;
import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author PHUNG
 */
public class taiKhoanBUS {

    taiKhoanDAO acc;

    public taiKhoanBUS() throws SQLException {
        acc = new taiKhoanDAO();

    }

//   ArrayList<nguoiDungDTO> user = new ArrayList<>();
    public ArrayList<taiKhoanDTO> getTaiKhoan() throws SQLException {
        return acc.getTaiKhoan();
    }

    public int getSoLuongTaiKhoan() throws SQLException {
        return acc.getSoLuongTaiKhoan();
    }

    public boolean addTaiKhoan(taiKhoanDTO a) throws SQLException {
        return acc.addTaiKhoan(a);
    }

    public String getMaQuyenTheoTenDN(String tenDN) throws SQLException {
        return acc.getMaQuyenTheoTenDN(tenDN);
    }

    public boolean deleteTaiKhoan(String tenDN) throws SQLException {
        return acc.deleteTaiKhoan(tenDN);
    }

    public boolean updateTaiKhoan(String maQuyen, String tenDN) throws SQLException {
        return acc.updateTaiKhoan(maQuyen, tenDN);
    }

    public taiKhoanDTO dangNhapTaiKhoan(String tenDN, String matKhau) throws SQLException {
        ArrayList<taiKhoanDTO> arr = acc.getTaiKhoan();
        for (taiKhoanDTO x : arr) {
            if (tenDN.equals(x.getTenDN().trim()) && matKhau.equals(x.getMatKhau()) && x.isTrangThai()) {
                return x;
            }
        }
        return null;
    }

    public ArrayList<String> layDanhSachMaCN(String maTK) {
        ArrayList<String> arr = this.acc.layDanhSachMaCN(maTK);
        return arr;
    }

    public taiKhoanDTO layTaiKhoan(String maTK) {
        taiKhoanDTO tk = this.acc.layTaiKhoan(maTK);
        return tk;
    }
}
