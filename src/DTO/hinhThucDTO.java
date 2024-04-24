/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Admin
 */
public class hinhThucDTO {

    private String MaHT, TenHT;

    public hinhThucDTO() {
    }
    
    public hinhThucDTO(String MaHT, String TenHT) {
        this.MaHT = MaHT;
        this.TenHT = TenHT;
    }

    public String getMaHT() {
        return MaHT;
    }

    public String getTenHT() {
        return TenHT;
    }

    public void setMaHT(String MaHT) {
        this.MaHT = MaHT;
    }

    public void setTenHT(String TenHT) {
        this.TenHT = TenHT;
    }
}
