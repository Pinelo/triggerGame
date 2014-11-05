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
public class Weapon extends Item {
    private String type;        //el tipo de arma que se usa
    private int damage;        //da;o que causa el arma
    private int cost;          //costo para comprar el arma
    
    public Weapon(ImageIcon img, String Type, int damage, int cost) {
        super(img);
        this.type = Type;
        this.damage = damage;
        this.cost = cost;
        
    }
    
    
    public void setType(String type) {
       this.type = type;
    }
    public void setDamage(int dmg) {
        damage = dmg;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    
    public String getType() {
        return type;
    }
    
    public int getDamage() {
        return damage;
    }
    
    public int getCost() {
        return cost;
    }

}
