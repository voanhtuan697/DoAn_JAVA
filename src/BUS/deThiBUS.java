/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.deThiDAO;
import DTO.deThiDTO;
import java.util.ArrayList;


public class deThiBUS {
    private deThiDAO dao = new deThiDAO();
    
    public ArrayList<deThiDTO> getMaTen(){
        return dao.getMaTen();
    }
    
     public ArrayList<deThiDTO> getDSMaDT(String MaMon) {
         return dao.getDSMaDT(MaMon);
     }
}
