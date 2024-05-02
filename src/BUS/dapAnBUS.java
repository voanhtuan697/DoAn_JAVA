/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import DAO.dapAnDAO;
import DTO.dapAnDTO;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author E7250
 */
public class dapAnBUS {
    private dapAnDAO da;

    public dapAnBUS() throws SQLException {
        this.da = new dapAnDAO();
    }
    
    public ArrayList<dapAnDTO> layCacDapAnBangMaCH(String maCH) throws SQLException {
        ArrayList<dapAnDTO> arr = da.layCacDapAnBangMaCH(maCH);
        return arr;
    }
    
    public boolean kiemTraDapAn(String maCH, String maDA) throws SQLException {
        ArrayList<dapAnDTO> arr = da.layCacDapAnBangMaCH(maCH);
        for(dapAnDTO x: arr){
            if(x.getMaCH().trim().equals(maCH)&&x.getMaDa().trim().equals(maDA)&&x.isDungSai()){
                return true;
            }
        }
        return false;
    }
    
    public int laySoDapAnCuaMotCauHoi(String maCH) throws SQLException {
        int soLuong = da.laySoDapAnCuaMotCauHoi(maCH);
        return soLuong;
    }
    
    public int laySoDapAnDungCuaMotCauHoi(String maCH) throws SQLException {
        int count = 0;
        ArrayList<dapAnDTO> arr = da.layCacDapAnBangMaCH(maCH);
        for(dapAnDTO x :arr){
            if(x.isDungSai()){
                count++;
            }
        }
        return count;
    }
    
//    public static void main(String[] args) throws SQLException {
//        dapAnBUS jj = new dapAnBUS();
//        if(jj.kiemTraDapAn("CHTH1", "DAC")){
//            System.out.println("dung");
//        }else{
//            System.out.println("sai");
//        }
//    }
}
