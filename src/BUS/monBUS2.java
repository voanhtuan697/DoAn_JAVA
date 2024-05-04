/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.monDAO2;
import DTO.monDTO;
import XULY.ShowDiaLog;
import java.util.ArrayList;

public class monBUS2 {

    private monDAO2 dao = new monDAO2();

    public ArrayList<monDTO> listMon() {
        return dao.listMon();
    }

    public String getMaMonByName(String name) {
        return dao.getMaMonByName(name);
    }

    public String getNameByMaMon(String MaMon) {
        return dao.getNameByMaMon(MaMon);
    }

    public boolean ThemMon(String MaMon, String TenMon) {
        monDTO m = new monDTO();
        m.setMaMon(MaMon);
        m.setTenMon(TenMon);
        return dao.ThemMon(m);
    }
    
    public ArrayList<monDTO> TimKiem(String keyword){
        return dao.TimKiem(keyword);
    }
}
