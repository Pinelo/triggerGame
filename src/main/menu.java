/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import java.util.LinkedList;

/**
 *
 * @author Casa
 */
public class menu {
    public LinkedList options;
    //no esta documentado selectedOption
    public int selectedOption;
    
    public menu(LinkedList optionList) {
        
    }
    
    public void selectOption() {
    //falta
    }
    public void setOptions(LinkedList options) {
        this.options = options;
    }
    
    public void up() {
    if(selectedOption == options.size() - 1) {
        selectedOption = 0;
    }
    else{
        selectedOption++;
    }
    
    }
    
    public void down() {
        if(selectedOption == 0) {
            selectedOption = options.size();
        }
        else {
            selectedOption--;
        }
    }
}
