/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Minh Phuc
 */
public class chiTietkhocauhoiDTO {
    private String MaKho, MaGV;

    public chiTietkhocauhoiDTO() {
    }

    public chiTietkhocauhoiDTO(String MaKho, String MaGV) {
        this.MaKho = MaKho;
        this.MaGV = MaGV;
    }

    public String getMaKho() {
        return MaKho;
    }

    public void setMaKho(String MaKho) {
        this.MaKho = MaKho;
    }

    public String getMaGV() {
        return MaGV;
    }

    public void setMaGV(String MaGV) {
        this.MaGV = MaGV;
    }
    
    
}
