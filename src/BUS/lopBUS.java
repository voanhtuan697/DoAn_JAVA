/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.sql.*;
import DAO.lopDAO;
import DTO.lopDTO;
import XULY.ShowDiaLog;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class lopBUS {

    private lopDAO lop;
    public lopBUS() throws SQLException {
        lop = new lopDAO();
    }

    public ArrayList<String> layMaLopTheoMon(String tenMon) throws SQLException {
        return lop.layMaLopTheoMon(tenMon);
    }

    public lopDTO layLopBangMaDe(String maDT) {
        lopDTO l = lop.layLopBangMaDe(maDT);
        return l;
    }

    public int layNhomLopMaTKvaMaDT(String maTK, String maDT) {
        int nhomLop = this.lop.layNhomLopMaTKvaMaDT(maTK, maDT);
        return nhomLop;
    }

    public ArrayList<lopDTO> layDanhSachLopTheoMaGV(String maGV) throws SQLException {
        return lop.layDanhSachLopTheoMaGV(maGV);
    }
    
    public ArrayList getList() {
        return lop.listLop();
    }

    public boolean themLop(String MaLop, String MaGv, int SoLuong, String MaMon, int Nam, int HocKy, boolean Trangthai, int NhomLop) {
        boolean success = false;
        lopDTO item = new lopDTO();
        item.setMaLop(MaLop);
        item.setHocKy(HocKy);
        item.setMaGV(MaGv);
        item.setSoLuong(SoLuong);
        item.setMaMon(MaMon);
        item.setNam(Nam);
        item.setTrangThai(Trangthai);
        item.setNhomLop(NhomLop);
        success = lop.ThemLop(item);
        if (success) {
            new ShowDiaLog("Thêm lớp thành công", ShowDiaLog.SUCCESS_DIALOG);
        } else {
            new ShowDiaLog("Thêm lớp thất bại", ShowDiaLog.ERROR_DIALOG);
        }
        return success;
    }

    public boolean XoaLop(String MaLop) {
        boolean success = false;
        success = lop.XoaLop(MaLop);
        if (success) {
            new ShowDiaLog("Xóa lớp thành công", ShowDiaLog.SUCCESS_DIALOG);
        } else {
            new ShowDiaLog("Không thể xóa lớp đã tồn tại sinh viên", ShowDiaLog.ERROR_DIALOG);
        }
        return success;
    }

    public ArrayList<lopDTO> TimKiem(String input) {
        return lop.TimKiem(input);
    }

    public ArrayList<lopDTO> listTrangThaiLop(int action) {
        return lop.listTrangThaiLop(action);
    }

    public ArrayList<lopDTO> getDSMaLop(String MaMon) {
        return lop.getDSMaLop(MaMon);
    }

    public String getMaLop(String TenMon) {
        return lop.getMaLop(TenMon);
    }

    public int getNhomLop(String TenMon) {
        return lop.getNhomLop(TenMon);
    }
    
    public ArrayList<lopDTO> getListNam(){
        return lop.getListNam();
    }
    
     public ArrayList<lopDTO> getMaByNamHKMon(int Nam, int HocKy, String TenMon) {
         return lop.getMaByNamHKMon(Nam, HocKy, TenMon);
     }
}
