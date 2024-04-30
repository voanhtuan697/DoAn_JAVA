/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;
import java.sql.SQLException;
import DAO.nguoiDungDAO;
import DTO.nguoiDungDTO;

/**
 *
 * @author E7250
 */
public class nguoiDungBUS {
    private nguoiDungDAO user;

    public nguoiDungBUS() throws SQLException {
        this.user = new nguoiDungDAO();
    }
    
    public nguoiDungDTO layNguoiDung(String maTK){
        nguoiDungDTO u = user.layNguoiDung(maTK);
        return u;
    }
    
    
}
