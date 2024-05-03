/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

/**
 *
 * @author Minh Phuc
 */
import DAO.dapAnDAO;
import DTO.dapAnDTO;
import java.util.List;

public class dapAnBUS {
    private dapAnDAO dapAnDao;

    public dapAnBUS() {
        dapAnDao = new dapAnDAO();
    }

    public void themdapAn(dapAnDTO dapAn) {
        dapAnDao.themdapAn(dapAn);
    }

    public void suadapAn(dapAnDTO dapAn) {
        dapAnDao.suadapAn(dapAn);
    }

    public void xoadapAn(String maDa) {
        dapAnDao.xoadapAn(maDa);
    }

    public List<dapAnDTO> layDanhSachdapAnTheoMaCH(String maCH) {
        return dapAnDao.layDanhSachdapAnTheoMaCH(maCH);
    }
}


