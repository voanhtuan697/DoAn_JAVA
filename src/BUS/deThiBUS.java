/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.deThiDAO;
import DTO.deThiDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author E7250
 */
public class deThiBUS {
    private deThiDAO deThi;

    public deThiBUS() throws SQLException {
        deThi = new deThiDAO();
    }
    
    public ArrayList<deThiDTO> layDanhSachDeThi() throws SQLException {
        ArrayList<deThiDTO> arr = deThi.layDanhSachDeThi();
        return arr;
    }
    
    public deThiDTO layDeThiBangMaDT(String maDT) throws SQLException {
        ArrayList<deThiDTO> arr = deThi.layDanhSachDeThi();
        for (deThiDTO dt : arr) {
            if (maDT.equals(dt.getMaDT().trim())) {
                return dt;
            }
        }
        return null;
    }
    
    public ArrayList<deThiDTO> layDSDeThiBangMaTK(String maDT, int trangThai) throws SQLException {
        ArrayList<deThiDTO> arr = deThi.layDeThiDSBangMaTK(maDT, trangThai);
        return arr;
    }
    
    
    
}
