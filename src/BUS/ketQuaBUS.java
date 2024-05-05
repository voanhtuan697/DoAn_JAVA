/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ketQuaDAO;
import DTO.ketQuaDTO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author E7250
 */
public class ketQuaBUS {

    private ketQuaDAO ketQua;

    public ketQuaBUS() throws SQLException {
        ketQua = new ketQuaDAO();
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
    
    public ArrayList<ketQuaDTO> DanhSach(String TenMon, String MaDT, String MaLop){
        return ketQua.DanhSach(TenMon, MaDT, MaLop);
    }
    
    public ArrayList<ketQuaDTO> DanhSachMax(String TenMon, String MaDT, String MaLop) {
        return ketQua.DanhSachMax(TenMon, MaDT, MaLop);
    }
    
    public ArrayList<ketQuaDTO> DanhSachMin(String TenMon, String MaDT, String MaLop) {
        return ketQua.DanhSachMin(TenMon, MaDT, MaLop);
    }
    
    public ArrayList<ketQuaDTO> DanhSachTruot(String TenMon, String MaDT, String MaLop){
        return ketQua.DanhSachTruot(TenMon, MaDT, MaLop);
    }
    
    public ArrayList<ketQuaDTO> DanhSachKhoang(String TenMon, String MaDT, String MaLop,float start,float end){
        return ketQua.DanhSachKhoang(TenMon, MaDT, MaLop, start, end);
    }

}
