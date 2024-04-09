/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connect;
//import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import java.sql.*;
/**
 *
 * @author E7250
 */
public class connect {
    private Connection conn;
   private String url;
   private String dbName;
   private String driver;
   private String userName; 
   private String password;

   public connect() throws SQLException
   {
      //driver = new org.gjt.mm.mysql.Driver();
       url = "jdbc:mysql://localhost:3306/";
       dbName = "qlba";
       driver = "com.mysql.jdbc.Driver";
       userName = "root";//username tuy may moi nguoi khac nhau
       password = "Oanh2004!";//password tuy may moi nguoi khac nhau
   }
   public connect(String url, String dbName, String driver, String userName, String password) {
      this.url = url;
      this.dbName = dbName;
      this.driver = driver;
      this.userName = userName;
      this.password = password;
   }

   private void connect() throws SQLException {
      try {
         Class.forName(driver);
         conn = DriverManager.getConnection(url + dbName, userName, password);
      } catch (ClassNotFoundException e) {
         throw new SQLException("Driver not found");
      }
      
   }

   public void disconnect() throws SQLException {
      if (conn != null) {
          try{
         conn.close();
         conn = null;
         }catch (SQLException E){}
      }
   }
   public ResultSet executeQuery(String sql){//executeQuery() được sử dụng để thực thi các câu lệnh SELECT trả về dữ liệu trong ResultSet
       ResultSet rs = null;
       try {
            Statement statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            
        } catch (SQLException ex) {}
       return rs;
   }
   
   public void executeUpdate(String sql) throws SQLException {//executeUpdate() trong JDBC được sử dụng để thực thi các câu lệnh SQL như INSERT, UPDATE, DELETE hoặc các câu lệnh khác như CREATE TABLE, ALTER TABLE và DROP TABLE
      //connect();
      try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException ex) {}
   }

    public static void main(String[] args) throws SQLException {
        connect cn=new connect();
        cn.connect();
        if(cn.conn==null)
        {
            System.out.println("Kết nối thất bạii");
        }
        else
            System.out.println("Kêt nối thành công");
//        String sql="DELETE FROM chucnang WHERE MACHUCNANG='QLSP' ";
//        cn.executeUpdate(sql);
    }
}
