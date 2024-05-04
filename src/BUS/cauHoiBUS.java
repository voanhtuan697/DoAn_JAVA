/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.cauHoiDAO;
import DTO.cauHoiDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class cauHoiBUS {

    private cauHoiDAO ch;

    public cauHoiBUS() throws SQLException {
        this.ch = new cauHoiDAO();
    }

    public ArrayList<cauHoiDTO> layDanhSachCauHoi() throws SQLException {
        return ch.layDanhSachCauHoi();
    }

    public String layMaCHTheoNoiDung(String noiDung) throws SQLException {
        return ch.layMaCHTheoNoiDung(noiDung);
    }
}
