/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.chiTietDeLopDAO;
import DTO.chiTietDeLopDTO;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class chiTietDeLopBUS {

    private chiTietDeLopDAO ctdl;

    public chiTietDeLopBUS()  {
        ctdl = new chiTietDeLopDAO();
    }

    public ArrayList<chiTietDeLopDTO> layDanhSachChiTietDeLop()  {
        return ctdl.layDanhSachChiTietDeLop();
    }

    public String layMaLopTheoMaDT(String maDT)  {
        return ctdl.layMaLopTheoMaDT(maDT);
    }
}
