/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

public class taiKhoanDTO {

    private String MaTK;
    private String TenDN;
    private String MatKhau;
//    <<<<<<< HEAD
    private boolean TrangThai;
    private String MaQuyen;
    private nguoiDungDTO NgDung = new nguoiDungDTO();

    public taiKhoanDTO(String MaTK, String TenDN, String MatKhau, boolean TrangThai, String MaQuyen) {
        this.MaTK = MaTK;
        this.TenDN = TenDN;
        this.MatKhau = MatKhau;
        this.TrangThai = TrangThai;
//=======
//    private boolean trangThai;
//    private String MaQuyen;
//    private nguoiDungDTO NgDung = new nguoiDungDTO();
//
//    
//
//    public taiKhoanDTO(String MaTK, String TenDN, String MatKhau, boolean bit, String MaQuyen) {
//        this.MaTK = MaTK;
//        this.TenDN = TenDN;
//        this.MatKhau = MatKhau;
//        this.trangThai = bit;
//>>>>>>> 07c12653363da382cbb6a76cff52188243b95a34
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

//    <<<<<<< HEAD
    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;

    }

//    public boolean isTrangThai() {
//        return rangThai;
//    }
//    public void setTrangThai(boolean trangThai) {
//        this.trangThai = trangThai;
//         >>> >>> > 07c12653363da382cbb6a76cff52188243b95a34
//    }
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
