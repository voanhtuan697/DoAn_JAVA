/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import java.sql.*;
import DTO.lopDTO;
import java.util.ArrayList;
/**
 *
 * @author PHUNG
 */
public class lopDAO {
    private MyConnection conn;
    public lopDAO() throws SQLException{
        this.conn = new MyConnection();
        conn.Connect();
    }
    public ArrayList<String> layMaLopTheoMon(String tenMon) throws SQLException{
        ArrayList<String> arr = new ArrayList<>();
        String sql="SELECT MaLop FROM lop, mon WHERE lop.MaMon = mon.MaMon AND TenMon=?";
        PreparedStatement stmt = conn.preparedStatement(sql);
        stmt.setString(1, tenMon);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            arr.add(rs.getString(1));
        }
        return arr;
    }
}
