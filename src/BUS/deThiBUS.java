/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.deThiDAO;
import DTO.deThiDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class deThiBUS {

    private deThiDAO deThi;

    public deThiBUS() throws SQLException {
        deThi = new deThiDAO();
    }

    public ArrayList<deThiDTO> layDanhSachDeThi() throws SQLException {
        return deThi.layDanhSachDeThi();
    }

    public deThiDTO layDeThiBangMaDT(String maDT) throws SQLException {
        ArrayList<deThiDTO> arr = deThi.layDanhSachDeThi();
        for (deThiDTO dt : arr) {
            if (maDT.equals(dt.getMaDT().trim())) {
                return dt;
            }
        }
        return null;
    }

    public ArrayList<deThiDTO> layDSDeThiBangMaTK(String maDT, int trangThai) throws SQLException {
        ArrayList<deThiDTO> arr = deThi.layDeThiDSBangMaTK(maDT, trangThai);
        return arr;
    }

    public int laySoLuongDeThiTheoMon(String maMon) throws SQLException {
        return deThi.laySoLuongDeThiTheoMon(maMon);
    }

    public boolean themDeThi(String maDT, String maTK, String tenDT, String matKhau, java.util.Date ngayThi, Time thoiGianBatDau, int trangThai, int soLuongCau, int thoiGianLamBai, String maLop, ArrayList<String> dsMaCH) throws SQLException {
        return deThi.themDeThi(maDT, maTK, tenDT, matKhau, ngayThi, thoiGianBatDau, trangThai, soLuongCau, thoiGianLamBai, maLop, dsMaCH);
    }

    public deThiDTO layDeThiTheoMaDT(String maDT) throws SQLException {
        return deThi.layDeThiTheoMaDT(maDT);
    }

    public boolean xoaDeThiBangMaDT(String maDT) throws SQLException {
        return deThi.xoaDeThiBangMaDT(maDT);
    }
    
    
    public ArrayList<deThiDTO> layDSDeThiDaTao(String maTK, int trangThai) throws SQLException {
        ArrayList<deThiDTO> arr = deThi.layDSDeThiDaTao(maTK, trangThai);
        return arr;
    }
    
    public static void main(String[] args) throws SQLException {
        deThiBUS dt = new deThiBUS();
        ArrayList<deThiDTO> arr = dt.layDSDeThiDaTao("TK4", 1);
        System.out.println(arr.size());
    }
    
    public void updateTrangThaiDeThi(String maDT) throws SQLException {
        deThi.updateTrangThaiDeThi(maDT);
    }
    
    public ArrayList<deThiDTO> getMaTen(){
        return deThi.getMaTen();
    }
    
     public ArrayList<deThiDTO> getDSMaDT(String MaMon) {
         return deThi.getDSMaDT(MaMon);
     }
    
    
}
