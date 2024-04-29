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
 * @author PHUNG
 */
public class quyenBUS {

    quyenDAO role;

    public quyenBUS() throws SQLException {
        role = new quyenDAO();
    }

    public ArrayList<quyenDTO> getQuyen() throws SQLException {
        return role.getQuyen();
    }

    public String getMaQuyenTheoTenQuyen(String tenQuyen) throws SQLException {
        return role.getMaQuyenTheoTenQuyen(tenQuyen);
    }

    public String getTenQuyenTheoMaQuyen(String maQuyen) throws SQLException {
        return role.getTenQuyenTheoMaQuyen(maQuyen);
    }
}
