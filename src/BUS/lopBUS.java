/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import java.sql.*;
import DAO.lopDAO;
import DTO.lopDTO;
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

    public lopDTO layLopBangMaDe(String maDT) {
        lopDTO l = lop.layLopBangMaDe(maDT);
        return l;
    }

    public int layNhomLopMaTKvaMaDT(String maTK, String maDT) {
        int nhomLop = this.lop.layNhomLopMaTKvaMaDT(maTK, maDT);
        return nhomLop;
    }

    public ArrayList<lopDTO> layDanhSachLopTheoMaGV(String maGV) throws SQLException {
        return lop.layDanhSachLopTheoMaGV(maGV);
    }
}
