/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

public class ketQuaDTO {
//<<<<<<< HEAD

    private String MaKQ, MaDT, TGLamXong, MaTK;
    private int SLCauDung;
    private float Diem;
    private lopDTO lopDTO = new lopDTO();
    private nguoiDungDTO ngDungDTO = new nguoiDungDTO();

    public ketQuaDTO() {
    }
//=======
//    private String MaKQ, MaDT,TGLamXong,MaTK;
//    private int SLCauDung;
//    private float Diem;
//
//    public ketQuaDTO() {
//    }
    
  
//>>>>>>> 07c12653363da382cbb6a76cff52188243b95a34

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

    public lopDTO getLopDTO() {
        return lopDTO;
    }

    public nguoiDungDTO getNgDungDTO() {
        return ngDungDTO;
    }

    public void setLopDTO(lopDTO lopDTO) {
        this.lopDTO = lopDTO;
    }

    public void setNgDungDTO(nguoiDungDTO ngDungDTO) {
        this.ngDungDTO = ngDungDTO;
    }
    

}
