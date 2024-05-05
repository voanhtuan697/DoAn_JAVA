/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.chiTietLopDTO;
import java.sql.*;
import java.util.ArrayList;

public class chiTietLopDAO {
    private chiTietLopDTO ctlop;
    private MyConnection conn;
    
    public chiTietLopDAO(){
         try{
            conn = new MyConnection();
        }catch(SQLException e){
             System.err.println("Ket noi db that bai" + e.getMessage());
        }
    }
    
    public boolean themSV(chiTietLopDTO t){
        boolean success = false;
        try{
            conn.Connect();
            String sql = "INSERT INTO CHITIETLOP(MaLop,MaSV) VALUES(?,?)";
            PreparedStatement pre = conn.preparedStatement(sql);
            pre.setString(1, t.getMaLop());
            pre.setString(2, t.getMaSV());
            success = pre.executeUpdate() > 0;
            conn.disconnect();
        }catch(SQLException e){
            System.err.println("Them sinh vao lop hoc that bai" + e.getMessage());
        }
        return success;
    }
}
