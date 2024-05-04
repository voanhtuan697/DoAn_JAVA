/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.nguoiDungDAO2;
import DTO.nguoiDungDTO;
import java.util.ArrayList;

public class nguoiDungBUS2 {

    private nguoiDungDAO2 dao = new nguoiDungDAO2();

    public ArrayList<nguoiDungDTO> getThongTinSV(int Nam, int HocKy, String TenMon, String MaLop) {
        return dao.getThongTinSV(Nam, HocKy, TenMon, MaLop);
    }

    public ArrayList<nguoiDungDTO> TimKiem(int Nam, int HocKy, String TenMon, String MaLop, String key) {
        return dao.TimKiem(Nam, HocKy, TenMon, MaLop, key);
    }

    public ArrayList<nguoiDungDTO> DSTenGV(String TenMon) {
        return dao.DSTenGV(TenMon);
    }
}
