/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.chiTietDeLopDAO;
import DTO.chiTietDeLopDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class chiTietDeLopBUS {

    private chiTietDeLopDAO ctdl;

    public chiTietDeLopBUS() throws SQLException {
        ctdl = new chiTietDeLopDAO();
    }

    public ArrayList<chiTietDeLopDTO> layDanhSachChiTietDeLop() throws SQLException {
        return ctdl.layDanhSachChiTietDeLop();
    }

    public String layMaLopTheoMaDT(String maDT) throws SQLException {
        return ctdl.layMaLopTheoMaDT(maDT);
    }
}
