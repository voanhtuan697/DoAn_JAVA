/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author TK
 */
public class ketQuaDTO {
    private String MaKQ, MaDT,TGLamXong,MaTK;
    private int SLCauDung;
    private float Diem;

    public ketQuaDTO() {
    }
    
    

    public ketQuaDTO(String MaKQ, String MaDT, String TGLamXong, String MaTK, int SLCauDung, float Diem) {
        this.MaKQ = MaKQ;
        this.MaDT = MaDT;
        this.TGLamXong = TGLamXong;
        this.MaTK = MaTK;
        this.SLCauDung = SLCauDung;
        this.Diem = Diem;
    }


    public String getMaKQ() {
        return MaKQ;
    }

    public void setMaKQ(String MaKQ) {
        this.MaKQ = MaKQ;
    }

    public String getMaDT() {
        return MaDT;
    }

    public void setMaDT(String MaDT) {
        this.MaDT = MaDT;
    }

    public int getSLCauDung() {
        return SLCauDung;
    }

    public void setSLCauDung(int SLCauDung) {
        this.SLCauDung = SLCauDung;
    }

    public float getDiem() {
        return Diem;
    }

    public void setDiem(float Diem) {
        this.Diem = Diem;
    }
     public String getTGLamXong() {
        return TGLamXong;
    }

    public void setTGLamXong(String TGLamXong) {
        this.TGLamXong = TGLamXong;
    }

    public String getMaTK() {
        return MaTK;
    }

    public void setMaTK(String MaTK) {
        this.MaTK = MaTK;
    }
}
