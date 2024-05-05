/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.chiTietDeDTO;
import DAO.chiTietDeDAO;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class chiTietDeBUS {

    private chiTietDeDAO ctd;

    public chiTietDeBUS()  {
        this.ctd = new chiTietDeDAO();
    }

    public ArrayList<chiTietDeDTO> layDanhSachChiTietDe()  {
        return ctd.layDanhSachChiTietDe();
    }

    public ArrayList<String> layDSChiTietDeTheoMaDT(String maDT)  {
        return ctd.layDSChiTietDeTheoMaDT(maDT);
    }
    
    public ArrayList<chiTietDeDTO> layDanhSachChiTietDeBangMaDe(String maDT)  {
        ArrayList<chiTietDeDTO> arr = ctd.layDanhSachChiTietDeBangMaDe(maDT);
        return arr;
    }
}
