/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.taiKhoanDAO2;
import DTO.taiKhoanDTO;
import java.util.ArrayList;

public class taiKhoanBUS2 {

    private taiKhoanDAO2 dao = new taiKhoanDAO2();

  
    
    public String getMaTkByName(String name){
        return dao.getMaTkByName(name);
    }
    
    public String getNameByMaTk(String MaTK) {
        return dao.getNameByMaTk(MaTK);
    }
    
     public String getMaTkByTenDN(String TenDN){
         return dao.getMaTkByTenDN(TenDN);
     }
}
