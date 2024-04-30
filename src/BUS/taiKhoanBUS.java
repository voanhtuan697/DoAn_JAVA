/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.taiKhoanDAO;
import DTO.taiKhoanDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author E7250
 */
public class taiKhoanBUS {
    private taiKhoanDAO tk;

    public taiKhoanBUS() throws SQLException {
        this.tk = new taiKhoanDAO();
    }
    
    public taiKhoanDTO dangNhapTaiKhoan(String tenDN, String matKhau){
        ArrayList<taiKhoanDTO> arr =tk.layDanhSachTaiKhoan();
        for (taiKhoanDTO x: arr){
            if(tenDN.equals(x.getTenDN().trim())&&matKhau.equals(x.getMatKhau())&&x.isTrangThai()){
                return x;
            }
        }
        return null;
    }
    
    public ArrayList<String> layDanhSachMaCN(String maTK) {
        ArrayList<String> arr = this.tk.layDanhSachMaCN(maTK);
        return arr;
    }
    
    public taiKhoanDTO layTaiKhoan(String maTK) {
        taiKhoanDTO tk = this.tk.layTaiKhoan(maTK);
        return tk;
    }
    
    public static void main(String[] args) throws SQLException {
        taiKhoanDAO tk = new taiKhoanDAO();
        ArrayList<taiKhoanDTO> arr =tk.layDanhSachTaiKhoan();
        for (taiKhoanDTO x: arr){
            System.out.println(x.getTenDN());
        }
    }
    
    
}
