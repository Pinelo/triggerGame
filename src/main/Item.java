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
public class Item {
    private ImageIcon ItemImg;
    
    public Item(ImageIcon img) {
        ItemImg = img;
    }

    
    public ImageIcon getImg() {
        return ItemImg;
    }
    
    public void setImg(ImageIcon a) {
        ItemImg = a;
    }
}
