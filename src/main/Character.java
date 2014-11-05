/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.awt.Image;
import java.util.LinkedList;
import javax.swing.ImageIcon;

/**
 *
 * @author Casa
 */
public class Character extends Base{
    
    public int ID;
    public int maxHp;
    public int hp;
    public int speed;
    public int dir;
    public Boolean isPlayable;
    public LinkedList inventory;
    public Boolean isAlive;
    public Animacion aniAnimacion;
        
    public Character(int x, int y, Image img, Animacion ani ,int id, int maxhp, int hp, 
            int speed, int dir, Boolean isplayable, LinkedList invent, 
            Boolean isalive) {
        super(x, y, img);
        ID = id;
        aniAnimacion = ani;
        maxHp = maxhp;
        this.hp = hp;
        this.speed = speed;
        this.dir = dir;
        isPlayable = isplayable;
        inventory = invent;
        isAlive = isalive;
   
    }
    
    
    public int getId() {
        return ID;
    }
    
    public int getMaxHp() {
        return maxHp;
    }
    
    public int getHp() {
        return hp;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public int getDir() {
        return dir;
    }
    
    public Boolean getIsPlayable() {
       return isPlayable;
    }
    
    public LinkedList getInventory() {
        return inventory;
    }
    
    public Boolean getIsAlive() {
         return isAlive;
    }
    
    public void setId(int id) {
        ID = id;
    }
    
    public void setMaxHp(int max) {
        maxHp = max;
    }
    
    public void getHp(int hp) {
        this.hp = hp;
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public void setDir(int dir) {
        this.dir = dir;
    }
    
    public void setIsPlayable(Boolean isP) {
        isPlayable = isP;
    }
    
    public void setInventory(LinkedList inv) {
        inventory = inv;
    }
    
    public void setIsAlive(Boolean isalive) {
        isAlive = isalive;
    }
    
    public void setAnimacion(Animacion ani) {
        aniAnimacion = ani;
    }
    
    public Animacion getAnimacion() {
        return aniAnimacion;
    }
    
 }
