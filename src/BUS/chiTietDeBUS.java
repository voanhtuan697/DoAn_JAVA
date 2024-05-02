/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DTO.chiTietDeDTO;
import DAO.chiTietDeDAO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class chiTietDeBUS {

    private chiTietDeDAO ctd;

    public chiTietDeBUS() throws SQLException {
        this.ctd = new chiTietDeDAO();
    }

    public ArrayList<chiTietDeDTO> layDanhSachChiTietDe() throws SQLException {
        return ctd.layDanhSachChiTietDe();
    }
}
