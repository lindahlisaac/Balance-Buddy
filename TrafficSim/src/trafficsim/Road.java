/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trafficsim;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Isaac
 */
public class Road {
    
   // Road r; //Road object  
    Road r;// = new Road();
    int r_beginX, r_endX; //x-coords for road location
    int r_beginY, r_endY; //y-coords for road location
    int r_width; //road width 
    int r_length; //length which road spans across the screen according to a horizontal road or vertical road
    int lane_width; // width of each lane
    int num_lanes; //number of lanes for a road
    String r_name; //name of road
    Road[] arr_roads; //array to store multiple roads (if desired)
    //The following member variables designate the details of the 6 intersections on the road map
    
    //left-right for first row/column, then 2nd row left-right
      Intersection i_0, i_1, i_2, //top row of intersections
                   i_3, i_4, i_5; //bottom row of intersections
      List<Intersection> int_list;
      
    public Road(){
        this.int_list = new ArrayList();
        setIntersections();
    }
    
    private void setIntersections(){
        
        i_0 = i_1 = i_2 = i_3 = i_4 = i_5 = new Intersection();
        
        i_0.setOrigin(300, 200);
        i_1.setOrigin(600, 200);
        i_2.setOrigin(900, 200);
        i_3.setOrigin(300, 600);
        i_4.setOrigin(600, 600);
        i_5.setOrigin(900, 200);
        
        int_list.add(i_0); //key val = 0
        int_list.add(i_1);// key val = 1
        int_list.add(i_2);// key val = 2
        int_list.add(i_3);// key val = 3
        int_list.add(i_4);// key val = 4
        int_list.add(i_5);// key val = 5
        
//        for(int x = 0; x <= int_list.size() - 1; ++x){
//            Intersection temp = int_list.get(x);
//            System.out.println(temp.getX(x));
//            System.out.println(temp.getY(x));
//        }
    }
    
    public List<Intersection> getIntersections(){
        return this.int_list;
    }
    
}
