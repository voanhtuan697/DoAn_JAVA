/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author E7250
 */
public class chiTietDeDTO {
    private String MaCH, MaDT;

    public chiTietDeDTO() {
    }

    public chiTietDeDTO(String MaCH, String MaDT) {
        this.MaCH = MaCH;
        this.MaDT = MaDT;
    }

    public String getMaCH() {
        return MaCH;
    }

    public void setMaCH(String MaCH) {
        this.MaCH = MaCH;
    }

    public String getMaDT() {
        return MaDT;
    }

    public void setMaDT(String MaDT) {
        this.MaDT = MaDT;
    }
    
    
}
