/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.chiTietMonDAO2;
import DTO.chiTietMonDTO;
import java.util.ArrayList;

public class chiTietMonBUS2 {

    private chiTietMonDAO2 dao = new chiTietMonDAO2();

    public boolean ThemDS(String MaMon, String MaGV) {
        chiTietMonDTO ct = new chiTietMonDTO();
        ct.setMaMon(MaMon);
        ct.setMaGV(MaGV);
        return dao.ThemDS(ct);
    }
}
