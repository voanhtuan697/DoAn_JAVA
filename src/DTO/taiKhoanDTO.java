/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PHUNG
 */
public class taiKhoanDTO {

    private String MaTK;
    private String TenDN;
    private String MatKhau;
    private int bit;
    private boolean trangThai;
    private String MaQuyen;
    private nguoiDungDTO NgDung = new nguoiDungDTO();

    public taiKhoanDTO(String MaTK, String TenDN, String MatKhau, int bit, String MaQuyen) {
        this.MaTK = MaTK;
        this.TenDN = TenDN;
        this.MatKhau = MatKhau;
        this.bit = bit;
        this.MaQuyen = MaQuyen;
    }

    public taiKhoanDTO(String MaTK, String TenDN, String MatKhau, boolean bit, String MaQuyen) {
        this.MaTK = MaTK;
        this.TenDN = TenDN;
        this.MatKhau = MatKhau;
        this.trangThai = bit;
        this.MaQuyen = MaQuyen;
    }

    public taiKhoanDTO() {
    }

    public nguoiDungDTO getNgDung() {
        return NgDung;
    }

    public void setNgDung(nguoiDungDTO NgDung) {
        this.NgDung = NgDung;
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

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getMaQuyen() {
        return MaQuyen;
    }

    public void setMaQuyen(String MaQuyen) {
        this.MaQuyen = MaQuyen;
    }
}
