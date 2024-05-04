/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

public class taiKhoanDTO {

    private String MaTK;
    private String TenDN;
    private String MatKhau;
    private boolean TrangThai;
    private String MaQuyen;
    private nguoiDungDTO NgDung = new nguoiDungDTO();


    public taiKhoanDTO(String MaTK, String TenDN, String MatKhau, boolean TrangThai, String MaQuyen) {
        this.MaTK = MaTK;
        this.TenDN = TenDN;
        this.MatKhau = MatKhau;
        this.TrangThai = TrangThai;
        this.MaQuyen = MaQuyen;
    }

    public taiKhoanDTO() {
    }


    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String MaTK) {
        this.MaTK = MaTK;
    }

    public String getTenDN() {
        return TenDN;
    }

    public void setTenDN(String TenDN) {
        this.TenDN = TenDN;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public boolean getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getMaQuyen() {
        return MaQuyen;
    }

    public void setMaQuyen(String MaQuyen) {
        this.MaQuyen = MaQuyen;
    }

    public nguoiDungDTO getNgDung() {
        return NgDung;
    }

    public void setNgDung(nguoiDungDTO NgDung) {
        this.NgDung = NgDung;
    }
    
    
}
