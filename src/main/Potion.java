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
public class Potion extends Item{
    public int owner;           //quien posee la posion
    public int modifier;        //que tan fuerte es la posion
    public int quantity;        //que tantos usos tiene
    
    public Potion(ImageIcon img, int Owner, int Modifier, int Quantity) {
        super(img);
        owner = Owner;
        modifier = Modifier;
        quantity = Quantity;
    }

    public void setOwner(int NOwner) {
            this.owner = NOwner;
    }
    public void setModifier(int mod) {
            modifier = mod;
    }
    public void setQuantity(int n) {
            quantity = n;
    }
    
    
    public int getOwner() {
        return owner;
    }
    
    public int getModifier() {
        return modifier;
    }
    
    public int getQuantity() {
        return quantity;
    }

    
}
