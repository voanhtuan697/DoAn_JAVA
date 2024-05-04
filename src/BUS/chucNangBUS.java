/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.chucNangDAO;
import DTO.chucNangDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author E7250
 */
public class chucNangBUS {

    private chucNangDAO chucNang;

    public chucNangBUS() throws SQLException {
        this.chucNang = new chucNangDAO();
    }

    public ArrayList<chucNangDTO> layDanhSachChucNang() {
        ArrayList<chucNangDTO> arr = chucNang.layDanhSachChucNang();
        return arr;
    }

    public ArrayList<String> layDanhSachMaChucNang() {
        ArrayList<String> arrMaChucNang = new ArrayList<>();
        ArrayList<chucNangDTO> arr = chucNang.layDanhSachChucNang();
        for (chucNangDTO x : arr) {
            arrMaChucNang.add(x.getMaCN());
        }
        return arrMaChucNang;
    }

    public ArrayList<String> layDanhSachTenChucNang() {
        ArrayList<String> arrTenChucNang = new ArrayList<>();
        ArrayList<chucNangDTO> arr = chucNang.layDanhSachChucNang();
        for (chucNangDTO x : arr) {
            arrTenChucNang.add(x.getTenCN());
        }
        return arrTenChucNang;
    }

    public String layMaChucNangTheoMaQuyen(String maQuyen) throws SQLException {
        return chucNang.layMaChucNangTheoMaQuyen(maQuyen);
    }
    
    
}
