/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.sql.*;
import DAO.lopDAO;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class lopBUS {

    private lopDAO lop;

    public lopBUS() throws SQLException {
        lop = new lopDAO();
    }

    public ArrayList<String> layMaLopTheoMon(String tenMon) throws SQLException {
        return lop.layMaLopTheoMon(tenMon);
    }
}
