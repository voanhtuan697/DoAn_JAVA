/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.chiTietLopDAO;
import DTO.chiTietLopDTO;
import XULY.ShowDiaLog;

/**
 *
 * @author Admin
 */
public class chiTietLopBUS {

    private chiTietLopDAO dao = new chiTietLopDAO();
    private chiTietLopDTO ct;

    public boolean themSV(String MaLop, String MaSV) {
        ct = new chiTietLopDTO(MaLop, MaSV);
        boolean success = dao.themSV(ct);
        return success;
    }
}
