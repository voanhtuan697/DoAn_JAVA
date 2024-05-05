/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.khoCauHoiDAO;
import DTO.khoCauHoiDTO;

/**
 *
 * @author PHUNG
 */
public class khoCauHoiBUS {

    private khoCauHoiDAO kho;

    public khoCauHoiBUS()  {
        this.kho = new khoCauHoiDAO();
    }

    public String layMaKhoCHTheoMaMon(String maMon)  {
        return kho.layMaKhoCHTheoMaMon(maMon);
    }
    public khoCauHoiDTO layKhoBangMaTK(String maTK) {
        khoCauHoiDTO k = kho.layKhoBangMaTK(maTK);
        return k; 
    }
    
    public boolean taoKhoCauHoi(khoCauHoiDTO kch)  {
        return kho.taoKhoCauHoi(kch);
    }
    
    public boolean xoaMaTBMKhoiKhoCH(String maKho)  {
        return kho.xoaMaTBMKhoiKhoCH(maKho);
    }
    
    public boolean themTBMChoKhoCH(String maTBM, String maMon)  {
        return kho.themTBMChoKhoCH(maTBM, maMon);
    }
    
    public boolean ThemKho(String MaKho, String MaMon, String MaTBM) {
        khoCauHoiDTO k = new khoCauHoiDTO();
        k.setMaKho(MaKho);;
        k.setMaMon(MaMon);
        k.setMaTBM(MaTBM);
        return kho.ThemKho(k);
    }
}
