/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.deThiDAO;
import DTO.deThiDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class deThiBUS {

    private deThiDAO dethi;

    public deThiBUS() throws SQLException {
        dethi = new deThiDAO();
    }

    public ArrayList<deThiDTO> layDanhSachDeThi() throws SQLException {
        return dethi.layDanhSachDeThi();
    }
}
