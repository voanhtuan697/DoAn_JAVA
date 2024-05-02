/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author TK
 */
public class lopDTO {

    private String MaLop, MaGV, MaMon, TrangThai;
    private int SoLuong, Nam, HocKy, NhomLop;

    public lopDTO() {
    }

    public lopDTO(String MaLop, String MaGV, String MaMon, String TrangThai, int SoLuong, int Nam, int HocKy, int NhomLop) {
        this.MaLop = MaLop;
        this.MaGV = MaGV;
        this.MaMon = MaMon;
        this.TrangThai = TrangThai;
        this.SoLuong = SoLuong;
        this.Nam = Nam;
        this.HocKy = HocKy;
        this.NhomLop = NhomLop;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String MaLop) {
        this.MaLop = MaLop;
    }

    public String getMaGV() {
        return MaGV;
    }

    public void setMaGV(String MaGV) {
        this.MaGV = MaGV;
    }

    public String getMaMon() {
        return MaMon;
    }

    public void setMaMon(String MaMon) {
        this.MaMon = MaMon;
    }

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public int getNam() {
        return Nam;
    }

    public void setNam(int Nam) {
        this.Nam = Nam;
    }

    public int getHocKy() {
        return HocKy;
    }

    public void setHocKy(int HocKy) {
        this.HocKy = HocKy;
    }

    public int getNhomLop() {
        return NhomLop;
    }

    public void setNhomLop(int NhomLop) {
        this.NhomLop = NhomLop;
    }

}
