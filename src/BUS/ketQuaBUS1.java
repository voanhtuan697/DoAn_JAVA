/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ketQuaDAO1;
import DTO.ketQuaDTO;
import java.sql.*;

/**
 *
 * @author E7250
 */
public class ketQuaBUS1 {

    private ketQuaDAO1 ketQua;

    public ketQuaBUS1() throws SQLException {
        ketQua = new ketQuaDAO1();
    }

    public void taoKetQua(ketQuaDTO kq) throws SQLException {
        ketQua.taoKetQua(kq);
    }

    public boolean kiemTraSVDaLamDeChua(String maTK, String maDT) throws SQLException {
        return ketQua.kiemTraSVDaLamDeChua(maTK, maDT);
    }
    
    public ketQuaDTO layKetQuaBangMaTKvaMaDT(String maTK,String maDT) {
        ketQuaDTO kq = this.ketQua.layKetQuaBangMaTKvaMaDT(maTK, maDT);
        return kq;
    }

}
