/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.quyenDAO;
import DTO.quyenDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author E7250
 */
public class quyenBUS {
    private quyenDAO quyen;

    public quyenBUS() throws SQLException {
        this.quyen = new quyenDAO();
    }
    
    public ArrayList<quyenDTO> layDanhSachQuyen() {
        ArrayList<quyenDTO> arr = quyen.layDanhSachQuyen();
        return arr;
    }
    
    public quyenDTO layQuyen(String maTK){
        quyenDTO quyen = this.quyen.layQuyen(maTK);
        return quyen;
    }
    
    
    
    
}
