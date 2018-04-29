package trafficsim;

import java.util.ArrayList;
import java.util.List;
import processing.core.*;
/**
 *
 *@author Isaac Lindahl <isaac.lindahl at https://github.com/lindahlisaac>
 */
public class Processing extends PApplet {
    float n = 0;
    float lastTime = 0;
    public float delta = 0;
    Road r; //road object containing data for entire map of roads
    Boolean b = false;
    public ArrayList<Car> car_arr;
    public int num_cars = 1;
    Car c;
    Car c_1, c_2, c_3, c_4, c_5;
    Car[] cars = {c_1, c_2, c_3};
    Map m;
    
    @Override
    public void settings(){
        size(1200,800);
        r = new Road();
        car_arr = new ArrayList<>();
        m = new Map();
        
    }
    
    @Override
    public void draw(){  
        //smooth();
        //frameRate(10);
        background(0, 150, 50);
        calc_dt();
        draw_intersections();
        draw_streets();
        draw_street_lines();      
        build_car_array();
        draw_cars();        
    }
    
    private void build_car_array(){
        
        
        if(b == false){        
            c_1 = new Car();
            c_2 = new Car();
            c_3 = new Car();
            c_4 = new Car();
            c_5 = new Car();
            
            car_arr.add(c_1);
            car_arr.add(c_2);
            car_arr.add(c_3);
            car_arr.add(c_4);
            car_arr.add(c_5);
            b = true;
        }
    }
    
    public void calc_dt(){
        delta = millis() - lastTime;
        lastTime = millis();
    }
    
    private void draw_cars(){
            update_cars(car_arr);
    }
 
    private void update_cars(ArrayList<Car> c){
        for(int x = 0; x < num_cars; ++x){
            c.get(x).move_car((float) ((double) delta*.6));
            int w,h;
            if(c.get(x).isVertical()){
                w = 20;
                h = 50;
            } else{
                w = 50;
                h = 20;
            }
        rect(c.get(x).xLoc, c.get(x).yLoc, w, h);
        }
    } 
    
    /* 
    Section containing functions for drawing the road elements eg. 
    *intersections
    *streets
    *traffic lines
    */
    private void draw_intersections(){
        List<Intersection> inter_list = r.getIntersections();
        stroke(0,0,0);
        strokeWeight(8);
        for(int x = 0; x <= 5; ++x){
            Intersection temp = inter_list.get(x);
            point(temp.getX(x), temp.getY(x));
        }
    }
    private void draw_streets(){
        List<Intersection> inter_list = r.getIntersections();
        fill(0,0,0);
        stroke(0,0,0);

        int w = 150; // width
        int h = 75; //height
        float offset = 125;
        for(int x = 0; x <= 5; ++x){
            Intersection temp = inter_list.get(0);
            rectMode(CENTER);
            //for horizontal streets, the width is 125 and height is 50
            rect((float) (temp.getX(x) + offset),(float) (temp.getY(x)), w, h);
            rect( (float) (temp.getX(x) - offset), (float) (temp.getY(x)), w, h);
            
            //for vertical streets, the width is 50 and the height is 125
            rect( (float) temp.getX(x), (float) (temp.getY(x) - offset), h, w);
            rect( (float) temp.getX(x), (float) (temp.getY(x) + offset), h, w); 
        }
        //fill in the gaps around the edges of the window
        rect(50,200,100,75); // upper left
        rect(50,600,100,75); //lower left
        rect(1150,200,100,75); //upper right
        rect(1150,600,100,75); //lower right
        
        fill(150,150,150);
        stroke(150,150,150);
        
        rect(300,200,(float)82.5, (float)82.5);//intersection 0
        rect(600,200,(float)82.5, (float)82.5);//intersection 1
        rect(900,200,(float)82.5, (float)82.5);//intersection 2
        
        rect(300,600,(float)82.5, (float)82.5);//intersection 0
        rect(600,600,(float)82.5, (float)82.5);//intersection 1
        rect(900,600,(float)82.5, (float)82.5);//intersection 2
    }
    
    private void draw_street_lines(){
        fill(255, 255, 0);
        stroke(255, 255, 0);
        strokeWeight(2);
        
        //traffic lines - top row
        line(0,200,250,200);
        line(350,200,550,200);
        line(650,200,850,200);
        line(950,200,1200,200);
        
        //traffic lines - bottom row
        line(0,600,250,600);
        line(350,600,550,600);
        line(650,600,850,600);
        line(950,600,1200,600);
        
        //traffic lines - first column
        line(300,0,300,150);
        line(300,250,300,550);
        line(300,650,300,800);
        
        //traffic lines - second column
        line(600,0,600,150);
        line(600,250,600,550);
        line(600,650,600,800);
        
        //traffic lines - third column
        line(900,0,900,150);
        line(900,250,900,550);
        line(900,650,900,800);
    }

}
