/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.chiTietMonDTO;
import DTO.monDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class chiTietMonDAO2 {

    private MyConnection conn;

    public chiTietMonDAO2() {
        try {
            conn = new MyConnection();
        } catch (SQLException e) {
            System.out.println("ket noi that bai" + e.getMessage());
        }
    }

    public boolean ThemDS(chiTietMonDTO ct){
        boolean success = false;
        try{
            conn.Connect();
            String sql = "INSERT INTO CHITIETMON(MaMon,MaGV) VALUES(?,?)";
            PreparedStatement pre = conn.preparedStatement(sql);
            pre.setString(1, ct.getMaMon());
            pre.setString(2, ct.getMaGV());
            success = pre.executeUpdate() > 0;
        }catch(SQLException e){
            System.err.println("them lop cho gv that bai"+ e.getMessage());
        }
        return success;
    }

}
