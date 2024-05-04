/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.nguoiDungDAO;
import DTO.nguoiDungDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author PHUNG
 */
public class nguoiDungBUS {

    private nguoiDungDAO user;

    public nguoiDungBUS() throws SQLException {
        this.user = new nguoiDungDAO();
    }

//   ArrayList<nguoiDungDTO> user = new ArrayList<>();
    public ArrayList<nguoiDungDTO> getNguoiDung() throws SQLException {
        return user.getNguoiDung();
    }

    public int getSoLuongNguoiDung() throws SQLException {
        return user.getSoLuongNguoiDung();
    }

    public boolean addNguoiDung(nguoiDungDTO a) throws SQLException {
        return user.addNguoiDung(a);
    }

    public boolean deleteNguoiDung(String maUser) throws SQLException {
        return user.deleteNguoiDung(maUser);
    }

    public boolean updateNguoiDung(String hoTen, String ngSinh, String maUser) throws SQLException {
        return user.updateNguoiDung(hoTen, ngSinh, maUser);
    }

    public nguoiDungDTO layNguoiDung(String maTK) {
        nguoiDungDTO u = user.layNguoiDung(maTK);
        return u;
    }

    public String layTenNguoiDungTheoMaTK(String maTK) {
        return user.layTenNguoiDungTheoMaTK(maTK);
    }

}
