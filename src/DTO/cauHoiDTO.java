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
    private String MaCH, MaKho, MaHT, Noidung, DoKho, MaGV, TrangThai;
    private byte[] Img;

    public cauHoiDTO() {
    }

    public cauHoiDTO(String MaCH, String MaKho, String MaHT, String Noidung, String DoKho, String MaGV, String TrangThai, byte[] Img) {
        this.MaCH = MaCH;
        this.MaKho = MaKho;
        this.MaHT = MaHT;
        this.Noidung = Noidung;
        this.DoKho = DoKho;
        this.MaGV = MaGV;
        this.TrangThai = TrangThai;
        this.Img = Img;
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

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public byte[] getImg() {
        return Img;
    }

    public void setImg(byte[] Img) {
        this.Img = Img;
    }
    
    
}