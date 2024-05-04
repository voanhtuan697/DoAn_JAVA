/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.monDAO;
import DTO.monDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class monBUS {

    private monDAO mon;

    public monBUS() throws SQLException {
        this.mon = new monDAO();
    }

    public ArrayList<monDTO> layDanhSachMon() throws SQLException {
        return mon.layDanhSachMon();
    }

    public String layTenMonTheoMaMon(String maMon) throws SQLException {
        return mon.layTenMonTheoMaMon(maMon);
    }

    public String layMaMonTheoTenMon(String tenMon) throws SQLException {
        return mon.layMaMonTheoTenMon(tenMon);
    }

    public String layTenMonTheoMaDeThi(String maDT) throws SQLException {
        return mon.layTenMonTheoMaDeThi(maDT);
    }

    public ArrayList<monDTO> layMonTuLop() throws SQLException {
        return mon.layMonTuLop();
    }
}
