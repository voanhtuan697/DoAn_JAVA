/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BUS;

import DAO.monDAO;
import java.util.ArrayList;

public class monBUS {

    private ArrayList list;
    private monDAO dao = new monDAO();

    public monBUS() {
        list = new ArrayList();
        init();
    }

    public void init() {
        list = dao.listMon();
    }

    public ArrayList getList() {
        return list;
    }

    public String getMaMonByName(String name) {
        return dao.getMaMonByName(name);
    }

    public String getNameByMaMon(String MaMon) {
        return dao.getNameByMaMon(MaMon);
    }
}
