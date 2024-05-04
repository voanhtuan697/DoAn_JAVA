/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package XULY;

/**
 *
 * @author Minh Phuc
 */
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class format {
    public static String FormatTime(Timestamp time) {
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");
        return formatDate.format(time);
    }
}
