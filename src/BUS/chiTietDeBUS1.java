/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.chiTietDeDAO1;
import DTO.chiTietDeDTO;
import java.sql.*;
import java.util.ArrayList;
/** 
 *
 * @author E7250
 */
public class chiTietDeBUS1 {
    private chiTietDeDAO1 ctd;

    public chiTietDeBUS1() throws SQLException {
        this.ctd = new chiTietDeDAO1();
    }
    
    public ArrayList<chiTietDeDTO> layDanhSachChiTietDeBangMaDe(String maDT) throws SQLException {
        ArrayList<chiTietDeDTO> arr = ctd.layDanhSachChiTietDeBangMaDe(maDT);
        return arr;
    }
}
