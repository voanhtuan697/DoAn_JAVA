/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.khoCauHoiDAO;
import DTO.khoCauHoiDTO;
import java.sql.*;

/**
 *
 * @author PHUNG
 */
public class khoCauHoiBUS {

    private khoCauHoiDAO kho;

    public khoCauHoiBUS() throws SQLException {
        this.kho = new khoCauHoiDAO();
    }

    public String layMaKhoCHTheoMaMon(String maMon) throws SQLException {
        return kho.layMaKhoCHTheoMaMon(maMon);
    }
    public khoCauHoiDTO layKhoBangMaTK(String maTK) {
        khoCauHoiDTO k = kho.layKhoBangMaTK(maTK);
        return k; 
    }
    
    public boolean taoKhoCauHoi(khoCauHoiDTO kch) throws SQLException {
        return kho.taoKhoCauHoi(kch);
    }
    
    public boolean xoaMaTBMKhoiKhoCH(String maKho) throws SQLException {
        return kho.xoaMaTBMKhoiKhoCH(maKho);
    }
    
    public boolean themTBMChoKhoCH(String maTBM, String maMon) throws SQLException {
        return kho.themTBMChoKhoCH(maTBM, maMon);
    }
}
