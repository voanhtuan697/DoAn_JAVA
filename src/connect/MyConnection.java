/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author LG
 */
public class MyConnection {

    static Connection con;
    Statement stm;

    public void openConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String Url = "jdbc:sqlserver://localhost:1433;databaseName=QLSinhVien2;trustServerCertificate=true";
            String user = "sa";
            String pass = "123";
            con = DriverManager.getConnection(Url, user, pass);
            stm = con.createStatement();
        } catch (Exception e) {
        }
    }

    public ResultSet runQuerry(String sql) {
        try {
            return stm.executeQuery(sql);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public int runUpdate(String sql) {
        try {
            return stm.executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
    
    public void closeConnection(){
        try {
             con.close();
        } catch (Exception e) {
        }
       
    }

//    public static void main(String[] args) {
//        MyConnection myConnect= new MyConnection();;
//        try {
//            
//            myConnect.openConnection();
//            System.out.println("Moi nhap ma lop:");
//            String st = new Scanner(System.in).nextLine();
//            String sql = "select * from Lop where MaLop='" + st + "'";
//            ResultSet rs = myConnect.runQuerry(sql);
//
//            if (rs.next()) {
//                System.out.println("Trung");
//            } else {
//                System.out.println("Khong trung");
//            }
//
//        } catch (Exception e) {
//        }
//        finally{
//            myConnect.closeConnection();
//        }
//
//    }
}
