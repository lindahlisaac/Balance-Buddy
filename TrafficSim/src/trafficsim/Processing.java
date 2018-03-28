/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficsim;

import processing.core.*;
/**
 *
 * @author Isaac
 */
public class Processing extends PApplet {
    
    public void settings(){
        size(500,500);
    }
    
    public void draw(){
        rect(mouseX, mouseY, 20, 20);
    }
    
}
