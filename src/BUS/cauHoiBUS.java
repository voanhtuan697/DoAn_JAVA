/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.cauHoiDAO;
import DTO.cauHoiDTO;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class cauHoiBUS {

    private cauHoiDAO ch;

    public cauHoiBUS()  {
        this.ch = new cauHoiDAO();
    }

    public ArrayList<cauHoiDTO> layDanhSachCauHoi()  {
        return ch.layDanhSachCauHoi();
    }

    public String layMaCHTheoNoiDung(String noiDung)  {
        return ch.layMaCHTheoNoiDung(noiDung);
    }


    public boolean themCauHoi(cauHoiDTO cauHoi) {
        return ch.themCauHoi(cauHoi);
    }


    public boolean suaCauHoi(cauHoiDTO cauHoi) {
        return ch.suaCauHoi(cauHoi);
    }


    public boolean xoaCauHoi(String maCH) {
        return ch.xoaCauHoi(maCH);
    }
    
    
    public cauHoiDTO layCauHoiBangMaCH(String maCH) {
        cauHoiDTO cauHoi = ch.layCauHoiBangMaCH(maCH);
        return cauHoi;
    }
}
