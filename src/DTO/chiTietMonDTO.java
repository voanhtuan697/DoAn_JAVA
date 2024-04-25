/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PHUNG
 */
public class chiTietMonDTO {
    private String MaMon;
    private String MaGV;

    public chiTietMonDTO(String MaMon, String MaGV) {
        this.MaMon = MaMon;
        this.MaGV = MaGV;
    }

    public chiTietMonDTO() {
    }

    public String getMaMon() {
        return MaMon;
    }

    public void setMaMon(String MaMon) {
        this.MaMon = MaMon;
    }

    public String getMaGV() {
        return MaGV;
    }

    public void setMaGV(String MaGV) {
        this.MaGV = MaGV;
    }
    
}
