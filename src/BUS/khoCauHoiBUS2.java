/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.khoCauHoiDAO2;
import DTO.khoCauHoiDTO;

public class khoCauHoiBUS2 {

    private khoCauHoiDAO2 dao = new khoCauHoiDAO2();

    public boolean ThemKho(String MaKho, String MaMon, String MaTBM) {
        khoCauHoiDTO k = new khoCauHoiDTO();
        k.setMaKho(MaKho);
        k.setMaMon(MaMon);
        k.setMaTBM(MaTBM);
        return dao.ThemKho(k);
    }
}