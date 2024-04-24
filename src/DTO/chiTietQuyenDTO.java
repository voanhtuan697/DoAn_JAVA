/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PHUNG
 */
public class chiTietQuyenDTO {
    private String MaCN;
    private String MaQuyen;

    public chiTietQuyenDTO() {
    }

    public chiTietQuyenDTO(String MaCN, String MaQuyen) {
        this.MaCN = MaCN;
        this.MaQuyen = MaQuyen;
    }

    public String getMaCN() {
        return MaCN;
    }

    public void setMaCN(String MaCN) {
        this.MaCN = MaCN;
    }

    public String getMaQuyen() {
        return MaQuyen;
    }

    public void setMaQuyen(String MaQuyen) {
        this.MaQuyen = MaQuyen;
    }
    
}
