/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.chiTietMonDAO;
import DTO.chiTietMonDTO;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class chiTietMonBUS {

    chiTietMonDAO ctm;

    public chiTietMonBUS()  {
        ctm = new chiTietMonDAO();
    }

    public ArrayList<chiTietMonDTO> layDanhSachChiTietMon()  {
        return ctm.layDanhSachChiTietMon();
    }
}
