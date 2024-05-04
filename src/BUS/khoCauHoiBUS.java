/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.khoCauHoiDAO;
import java.sql.*;

/**
 *
 * @author PHUNG
 */
public class khoCauHoiBUS {

    private khoCauHoiDAO kho;

    public khoCauHoiBUS() throws SQLException {
        this.kho = new khoCauHoiDAO();
    }

    public String layMaKhoCHTheoMaMon(String maMon) throws SQLException {
        return kho.layMaKhoCHTheoMaMon(maMon);
    }
}
