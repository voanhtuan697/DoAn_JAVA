/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableCellRenderer;

public class BASE extends DefaultTableCellRenderer {

    public static Color cobalt_blue = Color.decode("#6A89CC");
    public static Color dark_green = Color.decode("#4A69BD");
    public static Color blue = Color.decode("#B6DDF2");
    public static Color dark_blue = Color.decode("#5BC0EB");
    public static Color white = Color.decode("#ffffff");
    public static Color gray_bg = Color.decode("#B3BECB");
    public static String typeface = "Segoe UI";
    public static Font font16 = new Font("typeface", Font.PLAIN, 16);
    public static Font font16b = new Font("typeface", Font.BOLD, 16);
    public static Font font14 = new Font("typeface", Font.PLAIN, 15);
    public static Font font14b = new Font("typeface", Font.BOLD, 14);
    public static Font font13 = new Font("typeface", Font.PLAIN, 13);
    public static Font font13b = new Font("typeface", Font.BOLD, 13);

    public static ImageIcon createResizedIcon(Class<?> clazz, String imagePath, int width, int height) {
        URL imageURL = clazz.getResource(imagePath);
        if (imageURL == null) {
            System.err.println("Resource not found: " + imagePath);
            return null;
        }
        ImageIcon originalIcon = new ImageIcon(imageURL);
        Image scaledImage = originalIcon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImage);
    }

}
