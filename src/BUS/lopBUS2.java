/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.lopDAO2;
import DTO.lopDTO;
import XULY.ShowDiaLog;
import java.util.ArrayList;

public class lopBUS2 {

    private lopDAO2 dao = new lopDAO2();
    private ArrayList list;

    public lopBUS2() {
        list = new ArrayList<>();
        init();
    }

    public void init() {
        list = dao.listLop();
    }

    public ArrayList getList() {
        return list;
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
        success = dao.ThemLop(item);
        if (success) {
            new ShowDiaLog("Thêm lớp thành công", ShowDiaLog.SUCCESS_DIALOG);
        } else {
            new ShowDiaLog("Thêm lớp thất bại", ShowDiaLog.ERROR_DIALOG);
        }
        return success;
    }

    public boolean XoaLop(String MaLop) {
        boolean success = false;
        success = dao.XoaLop(MaLop);
        if (success) {
            new ShowDiaLog("Xóa lớp thành công", ShowDiaLog.SUCCESS_DIALOG);
        } else {
            new ShowDiaLog("Không thể xóa lớp đã tồn tại sinh viên", ShowDiaLog.ERROR_DIALOG);
        }
        return success;
    }

    public ArrayList<lopDTO> TimKiem(String input) {
        return dao.TimKiem(input);
    }

    public ArrayList<lopDTO> listTrangThaiLop(int action) {
        return dao.listTrangThaiLop(action);
    }

    public ArrayList<lopDTO> getDSMaLop(String MaMon) {
        return dao.getDSMaLop(MaMon);
    }

    public String getMaLop(String TenMon) {
        return dao.getMaLop(TenMon);
    }

    public int getNhomLop(String TenMon) {
        return dao.getNhomLop(TenMon);
    }
    
    public ArrayList<lopDTO> getListNam(){
        return dao.getListNam();
    }
    
     public ArrayList<lopDTO> getMaByNamHKMon(int Nam, int HocKy, String TenMon) {
         return dao.getMaByNamHKMon(Nam, HocKy, TenMon);
     }
}
