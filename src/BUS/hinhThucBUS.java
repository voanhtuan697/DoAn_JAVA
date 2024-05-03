/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author Admin
 */
import DAO.hinhThucDAO;
import DTO.hinhThucDTO;
import java.util.List;

public class hinhThucBUS {
    private hinhThucDAO hinhThucDAO;

    public hinhThucBUS(hinhThucDAO hinhThucDAO) {
        this.hinhThucDAO = hinhThucDAO;
    }
    
    public void themHinhThuc(hinhThucDTO hinhThuc) {
        hinhThucDAO.themHinhThuc(hinhThuc);
    }

    public void suaHinhThuc(hinhThucDTO hinhThuc) {
        hinhThucDAO.suaHinhThuc(hinhThuc);
    }
}

