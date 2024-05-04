/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author PHUNG
 */
public class nguoiDungDTO {
    private String MaUser;
    private String HoTen;
    private String NgSinh;

    public nguoiDungDTO() {
    }

    public nguoiDungDTO(String MaUser, String HoTen, String NgSinh) {
        this.MaUser = MaUser;
        this.HoTen = HoTen;
        this.NgSinh = NgSinh;
    }

    public nguoiDungDTO(String HoTen) {
        this.HoTen = HoTen;
    }
    
    

    public nguoiDungDTO(String MaUser, String HoTen) {
        this.MaUser = MaUser;
        this.HoTen = HoTen;
    }
    

    public String getMaUser() {
        return MaUser;
    }

    public void setMaUser(String MaUser) {
        this.MaUser = MaUser;
    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public String getNgSinh() {
        return NgSinh;
    }

    public void setNgSinh(String NgSinh) {
        this.NgSinh = NgSinh;
    }
}
