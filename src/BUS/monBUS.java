/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.monDAO;
import DTO.monDTO;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class monBUS {

    private monDAO mon;

    public monBUS()  {
        this.mon = new monDAO();
    }

    public ArrayList<monDTO> layDanhSachMon()  {
        return mon.layDanhSachMon();
    }

    public String layTenMonTheoMaMon(String maMon)  {
        return mon.layTenMonTheoMaMon(maMon);
    }

    public String layMaMonTheoTenMon(String tenMon)  {
        return mon.layMaMonTheoTenMon(tenMon);
    }

    public String layTenMonTheoMaDeThi(String maDT)  {
        return mon.layTenMonTheoMaDeThi(maDT);
    }

    public ArrayList<monDTO> layMonTuLop()  {
        return mon.layMonTuLop();
    }

    public ArrayList<monDTO> layCacMonChuaCoKho()  {
        ArrayList<monDTO> arr = mon.layCacMonChuaCoKho();
        return arr;
    }

    public String layTenMonBangMaCH(String maCH) {
        String tenMon = mon.layTenMonBangMaCH(maCH);
        return tenMon;
    }

    public String layTenMonBangMaDT(String maDT)  {
        String tenMon = mon.layTenMonBangMaDT(maDT);
        return tenMon;
    }

    public ArrayList getList() {
        ArrayList<monDTO> list = mon.listMon();
        return list;
    }

    public String getMaMonByName(String name) {
        return mon.getMaMonByName(name);
    }

    public String getNameByMaMon(String MaMon) {
        return mon.getNameByMaMon(MaMon);
    }

    public ArrayList<monDTO> TimKiem(String keyword) {
        return mon.TimKiem(keyword);
    }
    
    public ArrayList<monDTO> DSMonGVCHTT(String MaTK) {
        return mon.DSMonGVCHTT(MaTK);
    }

    public boolean ThemMon(String MaMon, String TenMon) {
        monDTO m = new monDTO();
        m.setMaMon(MaMon);
        m.setTenMon(TenMon);
        return mon.ThemMon(m);
    }
}
