/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.hinhThucDTO;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.*;

public class hinhThucDAO {

     private MyConnection myConnection;
     
    public hinhThucDAO() {
        try {
            myConnection = new MyConnection();
            myConnection.Connect();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Khong the ket noi den co so du lieu");
        }
    }
    
    public void themHinhThuc(hinhThucDTO hinhThuc) {
        String sql = "INSERT INTO HINHTHUC(MaHT, TenHT) VALUES (?, ?)";
        try {
            PreparedStatement preparedStatement = myConnection.preparedStatement(sql);
            preparedStatement.setString(1, hinhThuc.getMaHT());
            preparedStatement.setString(2, hinhThuc.getTenHT());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void suaHinhThuc(hinhThucDTO hinhThuc) {
        String sql = "UPDATE HINHTHUC SET TenHT = ? WHERE MaHT = ?";
        try {
            PreparedStatement preparedStatement = myConnection.preparedStatement(sql);
            preparedStatement.setString(1, hinhThuc.getTenHT());
            preparedStatement.setString(2, hinhThuc.getMaHT());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
