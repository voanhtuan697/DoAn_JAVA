/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.chiTietQuyenDAO;
import DTO.chiTietQuyenDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author E7250
 */
public class chiTietQuyenBUS {
    private chiTietQuyenDAO chiTietQ;

    public chiTietQuyenBUS() throws SQLException {
        this.chiTietQ = new chiTietQuyenDAO();
    }
    
    public ArrayList<chiTietQuyenDTO> layDanhSachChucNang() {
        ArrayList<chiTietQuyenDTO> arr = chiTietQ.layDanhSachCTQuyen();
        return arr;
    }
    
    public void xoaQuyenTrongDSCTQ(String maQuyen){
        this.chiTietQ.xoaQuyenTrongDSCTQ(maQuyen);
    }
    
    public void themChiTietQuyen(chiTietQuyenDTO ctq){
        this.chiTietQ.themChiTietQuyen(ctq);
    }
    
    
}
