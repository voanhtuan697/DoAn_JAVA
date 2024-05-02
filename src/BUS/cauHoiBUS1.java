/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.cauHoiDAO1;
import DTO.cauHoiDTO;
import java.sql.SQLException;

/**
 *
 * @author E7250
 */
public class cauHoiBUS1 {
    private cauHoiDAO1 ch;

    public cauHoiBUS1() throws SQLException {
        this.ch = new cauHoiDAO1();
    }
    
    public cauHoiDTO layCauHoiBangMaCH(String maCH) throws SQLException{
        cauHoiDTO cauHoi = ch.layCauHoiBangMaCH(maCH);
        return cauHoi;
    }
}
