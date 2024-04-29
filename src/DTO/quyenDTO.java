/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PHUNG
 */
public class quyenDTO {
    private String MaQuyen;
    private String TenQuyen;

    public quyenDTO(String MaQuyen, String TenQuyen) {
        this.MaQuyen = MaQuyen;
        this.TenQuyen = TenQuyen;
    }

    public quyenDTO() {
    }

    public String getMaQuyen() {
        return MaQuyen;
    }

    public void setMaQuyen(String MaQuyen) {
        this.MaQuyen = MaQuyen;
    }

    public String getTenQuyen() {
        return TenQuyen;
    }

    public void setTenQuyen(String TenQuyen) {
        this.TenQuyen = TenQuyen;
    }
    
}
