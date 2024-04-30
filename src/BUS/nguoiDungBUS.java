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

    nguoiDungDAO user1; //user của Phụng tạo

    public nguoiDungBUS() throws SQLException {
        user1 = new nguoiDungDAO();
        this.user = new nguoiDungDAO();

    }

//   ArrayList<nguoiDungDTO> user = new ArrayList<>();
    public ArrayList<nguoiDungDTO> getNguoiDung() throws SQLException {
        return user1.getNguoiDung();
    }

    public int getSoLuongNguoiDung() throws SQLException {
        return user1.getSoLuongNguoiDung();
    }

    public boolean addNguoiDung(nguoiDungDTO a) throws SQLException {
        return user1.addNguoiDung(a);
    }

    public boolean deleteNguoiDung(String maUser) throws SQLException {
        return user1.deleteNguoiDung(maUser);
    }

    public boolean updateNguoiDung(String hoTen, String ngSinh, String maUser) throws SQLException {
        return user1.updateNguoiDung(hoTen, ngSinh, maUser);
    }

    public nguoiDungDTO layNguoiDung(String maTK) {
        nguoiDungDTO u = user.layNguoiDung(maTK);
        return u;
    }

}
