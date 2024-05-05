/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.nguoiDungDAO;
import DTO.nguoiDungDTO;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class nguoiDungBUS {

    private nguoiDungDAO user;

    public nguoiDungBUS()  {
        this.user = new nguoiDungDAO();
    }

    public ArrayList<nguoiDungDTO> getNguoiDung()  {
        return user.getNguoiDung();
    }

    public int getSoLuongNguoiDung()  {
        return user.getSoLuongNguoiDung();
    }

    public boolean addNguoiDung(nguoiDungDTO a)  {
        return user.addNguoiDung(a);
    }

    public boolean deleteNguoiDung(String maUser)  {
        return user.deleteNguoiDung(maUser);
    }

    public boolean updateNguoiDung(String hoTen, String ngSinh, String maUser)  {
        return user.updateNguoiDung(hoTen, ngSinh, maUser);
    }

    public nguoiDungDTO layNguoiDung(String maTK) {
        nguoiDungDTO u = user.layNguoiDung(maTK);
        return u;
    }

    public String layTenNguoiDungTheoMaTK(String maTK) {
        return user.layTenNguoiDungTheoMaTK(maTK);
    }

    public String layMaUserTheoMaTK(String maTK) {
        return user.layMaUserTheoMaTK(maTK);
    }
    
    public ArrayList<nguoiDungDTO> getThongTinSV(int Nam, int HocKy, String TenMon, String MaLop) {
        return user.getThongTinSV(Nam, HocKy, TenMon, MaLop);
    }

    public ArrayList<nguoiDungDTO> TimKiem(int Nam, int HocKy, String TenMon, String MaLop, String key) {
        return user.TimKiem(Nam, HocKy, TenMon, MaLop, key);
    }

    public ArrayList<nguoiDungDTO> DSTenGV(String TenMon) {
        return user.DSTenGV(TenMon);
    }

}
