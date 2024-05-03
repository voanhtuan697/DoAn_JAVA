/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author Minh Phuc
 */
import DAO.cauHoiDAO;
import DTO.cauHoiDTO;

public class cauHoiBUS {
    private cauHoiDAO dao;

    public cauHoiBUS() {
        dao = new cauHoiDAO();
    }

    // Thêm câu hỏi
    public boolean themCauHoi(cauHoiDTO cauHoi) {
        return dao.themCauHoi(cauHoi);
    }

    // Sửa câu hỏi
    public boolean suaCauHoi(cauHoiDTO cauHoi) {
        return dao.suaCauHoi(cauHoi);
    }

    // Xóa câu hỏi
    public boolean xoaCauHoi(String maCH) {
        return dao.xoaCauHoi(maCH);
    }
}
