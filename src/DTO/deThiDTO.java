/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author TK
 */
public class deThiDTO {

    private String MaDT, MaGV, NgayThi, TenDeThi, MatKhau, ThoiGianBatDauThi;
    private int trangThai, thoiGianLamBai, SLCauHoi;

    public deThiDTO() {
    }

    public deThiDTO(String MaDT, String TenDeThi) {
        this.MaDT = MaDT;
        this.TenDeThi = TenDeThi;
    }

    public deThiDTO(String MaDT) {
        this.MaDT = MaDT;
    }

    public deThiDTO(int SLCauHoi, String MaDT, String MaGV, String NgayThi, String TenDeThi, String MatKhau, String ThoiGianBatDauThi, int trangThai, int thoiGianLamBai) {
        this.SLCauHoi = SLCauHoi;
        this.MaDT = MaDT;
        this.MaGV = MaGV;
        this.NgayThi = NgayThi;
        this.TenDeThi = TenDeThi;
        this.MatKhau = MatKhau;
        this.ThoiGianBatDauThi = ThoiGianBatDauThi;
        this.trangThai = trangThai;
        this.thoiGianLamBai = thoiGianLamBai;
    }

    public int getThoiGianLamBai() {
        return thoiGianLamBai;
    }

    public void setThoiGianLamBai(int thoiGianLamBai) {
        this.thoiGianLamBai = thoiGianLamBai;
    }

    public int getSLCauHoi() {
        return SLCauHoi;
    }

    public void setSLCauHoi(int SLCauHoi) {
        this.SLCauHoi = SLCauHoi;
    }

    public String getMaDT() {
        return MaDT;
    }

    public void setMaDT(String MaDT) {
        this.MaDT = MaDT;
    }

    public String getMaGV() {
        return MaGV;
    }

    public void setMaGV(String MaGV) {
        this.MaGV = MaGV;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getNgayThi() {
        return NgayThi;
    }

    public void setNgayThi(String NgayThi) {
        this.NgayThi = NgayThi;
    }

    public String getTenDeThi() {
        return TenDeThi;
    }

    public void setTenDeThi(String TenDeThi) {
        this.TenDeThi = TenDeThi;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    public String getThoiGianBatDauThi() {
        return ThoiGianBatDauThi;
    }

    public void setThoiGianBatDauThi(String ThoiGianBatDauThi) {
        this.ThoiGianBatDauThi = ThoiGianBatDauThi;
    }
}
