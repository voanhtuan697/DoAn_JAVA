/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.lopDAO1;
import DTO.lopDTO;
import java.sql.SQLException;
/**
 *
 * @author E7250
 */
public class lopBUS1 {
    private lopDAO1 lop;

    public lopBUS1() throws SQLException {
        lop = new lopDAO1();
    }
    
    
    public lopDTO layLopBangMaDe(String maDT){
        lopDTO l = lop.layLopBangMaDe(maDT);
        return l;
    }
}
