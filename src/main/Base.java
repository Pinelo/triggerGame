/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import javax.swing.ImageIcon;

/**
 *
 * @author Casa
 */
public class Base {
    private int posX;           //posicion en eje X
    private int posY;           //posicion en eje y
    private ImageIcon imgObj;   //imagen del objeto
    
    public Base(int x, int y, ImageIcon img) {
        posX = x;
        posY = y;
        imgObj = img;
    }
    
    public int getX() {
        return posX;
    }
    
    public int getY() {
        return posY;
    }
    
    public ImageIcon getImg() {
        return imgObj;
    }
    
    public void setX(int x) {
        posX = x;
    }
    
    public void setY(int y) {
        posY = y;
    }
    
    public void setImg(ImageIcon img) {
        imgObj = img;
    }
    
}
