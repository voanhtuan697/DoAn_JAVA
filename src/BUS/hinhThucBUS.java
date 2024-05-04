/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;


import DAO.hinhThucDAO;
import DTO.hinhThucDTO;

public class hinhThucBUS {
    private hinhThucDAO hinhThucDAO;
    
    public void themHinhThuc(hinhThucDTO hinhThuc) {
        hinhThucDAO.themHinhThuc(hinhThuc);
    }

    public void suaHinhThuc(hinhThucDTO hinhThuc) {
        hinhThucDAO.suaHinhThuc(hinhThuc);
    }
}

