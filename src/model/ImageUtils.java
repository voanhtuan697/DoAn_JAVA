/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageUtils {
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

