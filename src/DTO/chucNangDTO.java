/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PHUNG
 */
public class chucNangDTO {
    private String MaCN;
    private String TenCN;
    private String TrangThai;

    public String getMaCN() {
        return MaCN;
    }

    public void setMaCN(String MaCN) {
        this.MaCN = MaCN;
    }

    public String getTenCN() {
        return TenCN;
    }

    public void setTenCN(String TenCN) {
        this.TenCN = TenCN;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public chucNangDTO(String MaCN, String TenCN, String TrangThai) {
        this.MaCN = MaCN;
        this.TenCN = TenCN;
        this.TrangThai = TrangThai;
    }

    public chucNangDTO() {
    }
}
