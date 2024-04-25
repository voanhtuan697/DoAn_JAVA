/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Minh Phuc
 */
public class khoCauhoiDTO {
    private String MaKho, MaMon, MaTBM;

    public khoCauhoiDTO() {
    }

    public khoCauhoiDTO(String MaKho, String MaMon, String MaTBM) {
        this.MaKho = MaKho;
        this.MaMon = MaMon;
        this.MaTBM = MaTBM;
    }

    public String getMaKho() {
        return MaKho;
    }

    public void setMaKho(String MaKho) {
        this.MaKho = MaKho;
    }

    public String getMaMon() {
        return MaMon;
    }

    public void setMaMon(String MaMon) {
        this.MaMon = MaMon;
    }

    public String getMaTBM() {
        return MaTBM;
    }

    public void setMaTBM(String MaTBM) {
        this.MaTBM = MaTBM;
    }
    
    
}
