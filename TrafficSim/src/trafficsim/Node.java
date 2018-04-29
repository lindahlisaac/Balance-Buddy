/*
 * Here comes the text of your license
 * Each line should be prefixed with  * 
 */
package trafficsim;

import java.util.ArrayList;

/**
 *
 * @author Isaac Lindahl <isaac.lindahl at https://github.com/lindahlisaac>
 */
public class Node {
    String name;
    ArrayList adj_list,location;
    int num_adj;
    
    public Node(){
        
    }
    
    public Node(String name, ArrayList adjacency_list, ArrayList loc){
        this.name = name;
        
        num_adj = adjacency_list.size();
        
        this.adj_list = new ArrayList();        
        for(int x = 0; x < num_adj; ++x)
            this.adj_list.add(adjacency_list.get(x));
        
        location = new ArrayList(); // indexed arraylist to hold x and y coordinates of the node (intersection)
        
        this.location.add(loc.get(0)); // x coord @ index 0
        this.location.add(loc.get(1)); // y coord @index 1
        see_node();
        
        System.out.println(this.name);
        System.out.println(this.adj_list.get(0));
        System.out.println(this.adj_list.get(1));
        
    }
    
    public ArrayList set_route(String start, String dest){
        ArrayList route = new ArrayList();
        
        for(int x = 0; x < adj_list.size(); ++x){
            
        }
        
        return route;
    }
    
    public final void see_node(){
        for(int x = 0; x < num_adj; ++x){
            Node s = (Node) adj_list.get(x);
            System.out.println(this.name + " adj node " + x +": " + s.name);
        }
    }
}
