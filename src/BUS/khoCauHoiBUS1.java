/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.khoCauHoiDAO1;
import DTO.khoCauHoiDTO;
import java.sql.*;
/**
 *
 * @author E7250
 */
public class khoCauHoiBUS1 {
    private khoCauHoiDAO1 khoCH;

    public khoCauHoiBUS1() throws SQLException {
        khoCH = new khoCauHoiDAO1();
    }
    
    public khoCauHoiDTO layKhoBangMaTK(String maTK) {
        khoCauHoiDTO kho = khoCH.layKhoBangMaTK(maTK);
        return kho; 
    }
}
