/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.*;

/**
 *
 * @author E7250
 */
public class monDAO1 {

    private MyConnection conn;

    public monDAO1() throws SQLException {
        conn = new MyConnection();
        conn.Connect();
    }

    public String layTenMonBangMaMon(String maMon) {
        String tenMon = "";
        try {
            String query = "select TenMon from mon where MaMon ='" + maMon + "'";
            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                tenMon = rs.getString(1);
                return tenMon;
            } else {
                // Xử lý trường hợp không có dữ liệu phù hợp với điều kiện
                System.out.println("Không có dữ liệu phù hợp với điều kiện.");
                return "";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String layTenMonBangMaCH(String maCH) {
        String tenMon = "";
        try {
            String query = "select tenmon\n"
                    + "from cauhoi ch\n"
                    + "join khocauhoi k on ch.makho = k.makho\n"
                    + "join mon m on m.mamon = k.mamon\n"
                    + "where ch.mach = '" + maCH + "'";
            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                tenMon = rs.getString(1);
                return tenMon;
            } else {
                // Xử lý trường hợp không có dữ liệu phù hợp với điều kiện
                System.out.println("Không có dữ liệu phù hợp với điều kiện.");
                return "";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

    public String layTenMonBangMaDT(String maDT) {
        String tenMon = "";
        try {
            String query = "select TOP 1 tenmon\n"
                    + "from dethi dt\n"
                    + "join chitietdelop ct on ct.madt = dt.madt\n"
                    + "join lop l on l.malop = ct.malop\n"
                    + "join mon m on m.mamon = l.mamon\n"
                    + "where dt.madt = '"+maDT+"'";
            PreparedStatement pre = conn.preparedStatement(query);
            ResultSet rs = pre.executeQuery();
            if (rs.next()) {
                tenMon = rs.getString(1);
                return tenMon;
            } else {
                // Xử lý trường hợp không có dữ liệu phù hợp với điều kiện
                System.out.println("Không có dữ liệu phù hợp với điều kiện.");
                return "";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void main(String[] args) throws SQLException {
        monDAO1 m = new monDAO1();
        String tenMon = m.layTenMonBangMaCH("CHTH1");
        System.out.println(tenMon);
    }
}
