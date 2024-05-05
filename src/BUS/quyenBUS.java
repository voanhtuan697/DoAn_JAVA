/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.quyenDAO;
import DTO.quyenDTO;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class quyenBUS {

    private quyenDAO quyen;

    quyenDAO role;

    public quyenBUS()  {
        role = new quyenDAO();
        this.quyen = new quyenDAO();

    }

    public ArrayList<quyenDTO> getQuyen()  {
        return role.getQuyen();
    }

    public String getMaQuyenTheoTenQuyen(String tenQuyen)  {
        return role.getMaQuyenTheoTenQuyen(tenQuyen);
    }

    public String getTenQuyenTheoMaQuyen(String maQuyen)  {
        return role.getTenQuyenTheoMaQuyen(maQuyen);
    }

    public ArrayList<quyenDTO> layDanhSachQuyen() {
        ArrayList<quyenDTO> arr = quyen.layDanhSachQuyen();
        return arr;
    }

    public quyenDTO layQuyen(String maTK) {
        quyenDTO quyen = this.quyen.layQuyen(maTK);
        return quyen;
    }

}
