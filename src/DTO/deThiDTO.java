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
    private int SLCauHoi;
    private String MaDT, MaGV, HienThiDA, TienLui,NgayThi, TenDeThi,MatKhau,TrangThai, ThoiGianBatDauThi;

    public deThiDTO() {
    }

    
    public deThiDTO(int SLCauHoi, String MaDT, String MaGV, String MaKho, String HienThiDA, String TienLui, String NgayThi, String TenDeThi, String MatKhau, String TrangThai, String ThoiGianBatDauThi) {
        this.SLCauHoi = SLCauHoi;
        this.MaDT = MaDT;
        this.MaGV = MaGV;
        this.HienThiDA = HienThiDA;
        this.TienLui = TienLui;
        this.NgayThi = NgayThi;
        this.TenDeThi = TenDeThi;
        this.MatKhau = MatKhau;
        this.TrangThai = TrangThai;
        this.ThoiGianBatDauThi = ThoiGianBatDauThi;
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

    public String getHienThiDA() {
        return HienThiDA;
    }

    public void setHienThiDA(String HienThiDA) {
        this.HienThiDA = HienThiDA;
    }

    public String getTienLui() {
        return TienLui;
    }

    public void setTienLui(String TienLui) {
        this.TienLui = TienLui;
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

    public String getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(String TrangThai) {
        this.TrangThai = TrangThai;
    }

    public String getThoiGianBatDauThi() {
        return ThoiGianBatDauThi;
    }

    public void setThoiGianBatDauThi(String ThoiGianBatDauThi) {
        this.ThoiGianBatDauThi = ThoiGianBatDauThi;
    }

   
    
}
