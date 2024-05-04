/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Minh Phuc
 */
public class cauHoiDTO {


    private String MaCH, MaKho, MaHT, Noidung, DoKho, MaGV, Img;
    private boolean TrangThai;

    public cauHoiDTO() {
    }

    public cauHoiDTO(String MaCH, String MaKho, String MaHT, String Noidung, String DoKho, String MaGV, String Img, boolean TrangThai) {
        this.MaCH = MaCH;
        this.MaKho = MaKho;
        this.MaHT = MaHT;
        this.Noidung = Noidung;
        this.DoKho = DoKho;
        this.MaGV = MaGV;
        this.Img = Img;
        this.TrangThai = TrangThai;
    }

    public String getMaCH() {
        return MaCH;
    }

    public void setMaCH(String MaCH) {
        this.MaCH = MaCH;
    }

    public String getMaKho() {
        return MaKho;
    }

    public void setMaKho(String MaKho) {
        this.MaKho = MaKho;
    }

    public String getMaHT() {
        return MaHT;
    }

    public void setMaHT(String MaHT) {
        this.MaHT = MaHT;
    }

    public String getNoidung() {
        return Noidung;
    }

    public void setNoidung(String Noidung) {
        this.Noidung = Noidung;
    }

    public String getDoKho() {
        return DoKho;
    }

    public void setDoKho(String DoKho) {
        this.DoKho = DoKho;
    }

    public String getMaGV() {
        return MaGV;
    }

    public void setMaGV(String MaGV) {
        this.MaGV = MaGV;
    }

    public boolean isTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(boolean TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String Img) {
        this.Img = Img;
    }

}
