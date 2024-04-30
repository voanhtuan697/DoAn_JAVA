/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MyConnection {

    private Connection conn;
    private String url;
    private String dbName;
    private String driver;
    private String username;
    private String password;

    public MyConnection() throws SQLException {
//        dbName = "data_QLTN";
        url = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyTracNghiem;trustServerCertificate=true";
        driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        username = "sa";
        password = "123456";  //moi nguoi se co pass khac nhau
    }

    public MyConnection(Connection conn, String url, String dbName, String driver, String username, String password) {
        this.conn = conn;
        this.url = url;
        this.dbName = dbName;
        this.driver = driver;
        this.username = username;
        this.password = password;
    }

    public void Connect() throws SQLException {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver not found");
        }
    }

    public void disconnect() throws SQLException {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new SQLException("Error while closing connection: " + e.getMessage());
            } finally {
                conn = null;
            }
        }
    }

    public PreparedStatement preparedStatement(String query) throws SQLException {
        if (conn == null || conn.isClosed()) {
            throw new SQLException("Connection is not established");
        }
        return conn.prepareStatement(query);
    }
}
