/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Minh Phuc
 */
public class dapAnDTO {
    private String MaDa, MaCH, Noidung;
    private boolean DungSai;

    public dapAnDTO() {
    }

    public dapAnDTO(String MaDa, String MaCH, String Noidung, boolean DungSai) {
        this.MaDa = MaDa;
        this.MaCH = MaCH;
        this.Noidung = Noidung;
        this.DungSai = DungSai;
    }

    public String getMaDa() {
        return MaDa;
    }

    public void setMaDa(String MaDa) {
        this.MaDa = MaDa;
    }

    public String getMaCH() {
        return MaCH;
    }

    public void setMaCH(String MaCH) {
        this.MaCH = MaCH;
    }

    public String getNoidung() {
        return Noidung;
    }

    public void setNoidung(String Noidung) {
        this.Noidung = Noidung;
    }

    public boolean isDungSai() {
        return DungSai;
    }

    public void setDungSai(boolean DungSai) {
        this.DungSai = DungSai;
    }
}
