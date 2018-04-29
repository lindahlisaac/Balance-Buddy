/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package trafficsim;

import java.util.HashMap;

/**
 *
 * @author Isaac Lindahl <isaac.lindahl at https://github.com/lindahlisaac>
 */
public class Intersection {
    int x,y;
    double right_origX, right_origY, bottom_origX, bottom_origY, 
            left_origX, left_origY, top_origX, top_origY; //origins (center of rectangle) of the centers 
                                                        //of the right,left,bottom,top streets at this intersection  
    double offset = 87.5;
    float x_val, y_val;
    public Intersection(){
        
    }
    
    void setOrigin(Integer x, Integer y){
        this.x = x;
        this.y = y;
        
        this.setRightRoad();
        this.setBottomRoad();
        this.setLeftRoad();
        this.setTopRoad();
    }
    
    public float getX(Integer x){
        
        if(x == 0 || x == 3)
            x_val = 300;
        if(x == 1 || x == 4)
            x_val = 600;
        if(x == 2 || x == 5)
            x_val = 900;
        
        return x_val;
    }
    
    public float getY(Integer y){
        
        if(y == 0 || y == 1 || y == 2)
            y_val = 200;
        if(y == 3 || y == 4 || y == 5)
            y_val = 600;

        return y_val;
    }
    
    /*
    Mutator functions to calculate the centers of the rectangles which will represent the 
    roads surrounding the intersections
    the center of each road is 87.5 units from the origin of the intersection itself,
    represented by the "offset" variable
    
    */
    private void setRightRoad(){
        this.right_origX = (float) (this.x_val + offset);
        this.right_origY = this.y_val;
    }
    
    private void setLeftRoad(){
        this.left_origX =  (this.x_val - offset);
        this.left_origY = this.y_val;
    }
    
    private void setBottomRoad(){
        this.bottom_origX = this.x_val;
        this.bottom_origY =  (this.y_val + offset);
    }
    
    private void setTopRoad(){
        this.top_origX = this.x_val;
        this.top_origY = (this.y_val - offset);
    }
    
    //function which returns true if a road is horizontal, false if vertical
    public Boolean isHorizontal(String s){
        Boolean b = true;
        
        if("r".equals(s) || "l".equals(s))
            b = true;
        else
            b = false;
        
        return b;
    }
}
