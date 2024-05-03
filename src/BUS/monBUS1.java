/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.monDAO1;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author E7250
 */
public class monBUS1 {
    private monDAO1 mon;

    public monBUS1() throws SQLException {
        mon = new monDAO1();
    }
    
    public String layTenMonBangMaMon(String maMon){
        String tenMon = mon.layTenMonBangMaMon(maMon);
        return tenMon;
    }
    public String layTenMonBangMaCH(String maCH){
        String tenMon = mon.layTenMonBangMaCH(maCH);
        return tenMon;
    }
}
