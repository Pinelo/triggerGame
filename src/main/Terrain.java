/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Casa
 */
public class Terrain extends Base{
    
    public String type;     //typo del terreno
    public Boolean isWalkable; //se puede caminar sobre el terreno o no
    
    public Terrain(int posX, int posY, Image img, String type, Boolean walkable) {
        super(posX, posY, img);
        this.type = type;
        isWalkable = walkable;
    }
    
    public void setType(String Type) {
        type = Type;
    }
    
    public void setIsWalkable(Boolean b) {
        isWalkable = b;
    }
    
    public String getType() {
        return type;
    }
    
    public Boolean getIsWalkable() {
        return isWalkable;
    }
}
