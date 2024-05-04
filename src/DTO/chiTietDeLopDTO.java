/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author TK
 */
public class chiTietDeLopDTO {
    private String MaDT, MaLop;

    public chiTietDeLopDTO() {
    }

    public chiTietDeLopDTO(String MaDT, String MaLop) {
        this.MaDT = MaDT;
        this.MaLop = MaLop;
    }

    public String getMaDT() {
        return MaDT;
    }

    public void setMaDT(String MaDT) {
        this.MaDT = MaDT;
    }

    public String getMaLop() {
        return MaLop;
    }

    public void setMaLop(String MaLop) {
        this.MaLop = MaLop;
    }
    
}
