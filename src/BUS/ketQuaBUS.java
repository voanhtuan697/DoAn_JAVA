/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.ketQuaDAO;
import DTO.ketQuaDTO;
import java.util.ArrayList;


public class ketQuaBUS {
    private ketQuaDAO dao = new ketQuaDAO();
    
    
    public ArrayList<ketQuaDTO> DanhSach(String TenMon, String MaDT, String MaLop){
        return dao.DanhSach(TenMon, MaDT, MaLop);
    }
    
    public ArrayList<ketQuaDTO> DanhSachMax(String TenMon, String MaDT, String MaLop) {
        return dao.DanhSachMax(TenMon, MaDT, MaLop);
    }
    
    public ArrayList<ketQuaDTO> DanhSachMin(String TenMon, String MaDT, String MaLop) {
        return dao.DanhSachMin(TenMon, MaDT, MaLop);
    }
    
    public ArrayList<ketQuaDTO> DanhSachTruot(String TenMon, String MaDT, String MaLop){
        return dao.DanhSachTruot(TenMon, MaDT, MaLop);
    }
    
    public ArrayList<ketQuaDTO> DanhSachKhoang(String TenMon, String MaDT, String MaLop,float start,float end){
        return dao.DanhSachKhoang(TenMon, MaDT, MaLop, start, end);
    }
    
}
