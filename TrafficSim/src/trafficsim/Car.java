/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package trafficsim;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Isaac Lindahl <isaac.lindahl at https://github.com/lindahlisaac>
 */
public class Car extends Processing{
    public int xLoc, yLoc;
    boolean isMoving = true;
    Boolean toRight, toLeft, toBottom, toTop;
    int random,xRand, yRand;
    ArrayList initX, initY;
    ArrayList vel_arr;
    double vel, orig_vel;
    Random rand = new Random();
    Random rand_vel = new Random();
    Boolean vertical;
    ArrayList route_queue;
    int offsetX, offsetY;
    double delta_sum = 0;
    Boolean isStopped = false;
    
    public Car(){
        vertical = false;
        toRight = toLeft = toBottom = toTop = false;
        random = rand.nextInt(3) + 0;
        xRand = rand.nextInt(2) + 0;
        yRand = rand.nextInt(1) + 0;
        
        System.out.println("yRand: " + yRand);
        
        initX = new ArrayList();
        initY = new ArrayList();
        
        initX.add(300);
        initX.add(600);
        initX.add(900);
        
        initY.add(200);
        initY.add(600);
        
        System.out.println("random: " + random);
        
        if(random == 0)
            toRight = true;
        if(random == 1)
            toLeft = true;
        if(random == 2)
            toTop = true;
        if(random == 3)
            toBottom = true;
        
        vel_arr = new ArrayList();
        
        for(float x = 1; x < 6; ++x){
            vel_arr.add(x/10);
            System.out.println(x/10);
        }
        
        this.vel = (float) vel_arr.get((int)rand_vel.nextInt(4) + 1);
        this.orig_vel = vel;
        route_queue = new ArrayList();
        
        offsetX = offsetY = 0;
        
        init_pos();
    }
    
    public void get_route(){
        //gives Node the destination and the starting point, then
        //iterates through the adjacent nodes until it reaches the
        //destination node, adding all the intermediate nodes to 
        //the destination to the route queue
    }
    
    private void init_pos(){
        if(toRight){
            xLoc = 0;
            yLoc = (int)  initY.get(yRand) + 22;
            vertical = false;
            offsetY = 22;
        }
       if(toLeft){
           xLoc = 1200;           
           yLoc = (int) initY.get(yRand) - 22;
           vertical = false;
           offsetY = -22;
       }
        if(toTop){ 
            xLoc = (int) initX.get(xRand) + 22;
            yLoc = 800;
            vertical = true;
            offsetX = 22;
        }
        if(toBottom){
            xLoc = (int) initX.get(xRand) - 22;
            yLoc = 0;
            vertical = true;
            offsetX = -22;
        }
    }
    
    public void move_car(float d){  
         d -= 5;
         
            if(toRight){
                xLoc += vel * d;
            }
            if(toLeft){
                xLoc -= vel * d;
            }
            if(toTop){
                yLoc -= vel * d;
            }
            if(toBottom){
                yLoc += vel * d;
            }
        
        intersection_stop(d);
        checkOB();
    }
    
    public void pause_car(float d){        
        xLoc += 0;
        yLoc += 0;

        intersection_stop(d);
        checkOB();
    }
    
    
    private void intersection_stop(float d){        
        ArrayList inters_xArr = new ArrayList();
        ArrayList inters_yArr = new ArrayList();
        
        inters_xArr.add(300 + offsetX);
        inters_xArr.add(600 + offsetX);
        inters_xArr.add(900+offsetX);
        
        inters_yArr.add(200 + offsetY);
        inters_yArr.add(600 + offsetY);
        

        double old_vel = vel;
//        System.out.println(old_vel);
        if(xLoc == (int) inters_xArr.get(0) && yLoc == (int) inters_yArr.get(0)){
            System.out.println("At intersection 1");            
            if(delta_sum <= 1500){
                vel = 0;
                delta_sum += 10;
                isStopped = true;
                System.out.println(delta_sum);
            } else if(delta_sum > 1500) {
                vel = old_vel;
                delta_sum = 0;
                isStopped = false;
//                xLoc+=vel*d;
                unpause(d, vel);
            }
        }
    }
    
    private void unpause(float d, double v){
//        xLoc += v * d;
    xLoc +=0.5;
    vel = orig_vel;
//    System.out.println("vel: " + v);
//    System.out.println("vel * d: " + v * d);
    }
    
    private void collision_check(){
        for(int x = 0; x < num_cars; ++x){
            for(int y = 0; y < num_cars; ++y){
                Car t1,t2;
                t1 = new Car();
                t2 = new Car();
                
                t1 = car_arr.get(x);
                t2 = car_arr.get(y);
                
                System.out.println("t1 xLoc: " + t1.xLoc);
                System.out.println("t2 xLoc: " + t2.xLoc);
                
                while(t1.xLoc == t2.xLoc && t1.yLoc == t2.yLoc){
                    t1.vel = 0;
                    System.out.println("Collision");
                }
            }
            this.vel = (float) vel_arr.get((int)rand_vel.nextInt(4) + 1);
        }
    }
    
    private void adjust_velocity(){
        
    }
    
    private void checkOB(){
        if(toRight && xLoc > 1225){
            this.xLoc = -25;
            this.yLoc = (int)  initY.get(yRand) + 22;
        }
        if(toLeft && xLoc < -25){
            this.xLoc = 1225;
            this.yLoc = (int)  initY.get(yRand) - 22;
        }
        if(toTop && yLoc < -25){
            this.xLoc = (int)  initX.get(xRand) + 22;
            this.yLoc = 1225;
        }
        if(toBottom && yLoc > 825){
            this.xLoc = (int) initX.get(xRand) - 22;
            this.yLoc = -25;
        }
            
    }
    
    public Boolean isVertical(){
        return vertical;            
    }
}
