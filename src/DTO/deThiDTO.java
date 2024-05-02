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

    private String MaDT, MaGV,NgayThi, TenDeThi,MatKhau,ThoiGianBatDauThi;
    private int trangThai,thoiGianLamBai,SLCauHoi;
    private boolean HienThiDA, TienLui;
    public deThiDTO() {
    }

    public deThiDTO(int SLCauHoi, String MaDT, String MaGV, String NgayThi, String TenDeThi, String MatKhau, String ThoiGianBatDauThi, int trangThai, int thoiGianLamBai, boolean HienThiDA, boolean TienLui) {
        this.SLCauHoi = SLCauHoi;
        this.MaDT = MaDT;
        this.MaGV = MaGV;
        this.NgayThi = NgayThi;
        this.TenDeThi = TenDeThi;
        this.MatKhau = MatKhau;
        this.ThoiGianBatDauThi = ThoiGianBatDauThi;
        this.trangThai = trangThai;
        this.thoiGianLamBai = thoiGianLamBai;
        this.HienThiDA = HienThiDA;
        this.TienLui = TienLui;
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

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getThoiGianBatDauThi() {
        return ThoiGianBatDauThi;
    }

    public void setThoiGianBatDauThi(String ThoiGianBatDauThi) {
        this.ThoiGianBatDauThi = ThoiGianBatDauThi;
    }

    public boolean isHienThiDA() {
        return HienThiDA;
    }

    public void setHienThiDA(boolean HienThiDA) {
        this.HienThiDA = HienThiDA;
    }

    public boolean isTienLui() {
        return TienLui;
    }

    public void setTienLui(boolean TienLui) {
        this.TienLui = TienLui;
    }

   

}
