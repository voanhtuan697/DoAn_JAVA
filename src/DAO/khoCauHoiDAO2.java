/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.khoCauHoiDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class khoCauHoiDAO2 {
    private MyConnection conn;
    
    public khoCauHoiDAO2(){
        try{
            conn = new MyConnection();
        }catch( SQLException e){
            System.err.println("Ket nou that bai" + e.getMessage());
        }
    }
    
    public boolean ThemKho(khoCauHoiDTO k) {
        boolean success = false;
        try{
            conn.Connect();
            String sql = "INSERT INTO KHOCAUHOI(MaKho,MaMon,MaTBM) VALUES(?,?,?)";
            PreparedStatement pre = conn.preparedStatement(sql);
            pre.setString(1, k.getMaKho());
            pre.setString(2, k.getMaMon());
            pre.setString(3, k.getMaTBM());
            success = pre.executeUpdate() > 0;
            conn.disconnect();
        }catch(SQLException e){
            System.err.println("Them kho that bai" + e.getMessage());
        }
        return success;
    }
    
}
