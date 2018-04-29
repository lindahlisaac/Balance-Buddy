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
public class Map {
    
    Node int1, int2, int3, 
         int4, int5, int6;
    
    String n1 = "node1";
    String n2 = "node2";
    String n3 = "node3";
    String n4 = "node4";
    String n5 = "node5";
    String n6 = "node6";
    
    ArrayList node_adj1, node_adj2, node_adj3, node_adj4, node_adj5, node_adj6;
    ArrayList node_coord1, node_coord2, node_coord3, node_coord4, node_coord5, node_coord6;
    
    public Map(){
        
        int1 = new Node();
        int2 = new Node();
        int3 = new Node();
        int4 = new Node();
        int5 = new Node();
        int6 = new Node();
        
        node_adj1 = new ArrayList();
        node_adj2 = new ArrayList(); 
        node_adj3 = new ArrayList();
        node_adj4 = new ArrayList(); 
        node_adj5 = new ArrayList();
        node_adj6 = new ArrayList();
        
        node_coord1 = new ArrayList();
        node_coord2 = new ArrayList();
        node_coord3 = new ArrayList();
        node_coord4 = new ArrayList();
        node_coord5 = new ArrayList();
        node_coord6 = new ArrayList();
        
        node_adj1.add(int2);
        node_adj1.add(int4);
        
        node_adj2.add(int1);
        node_adj2.add(int3);
        node_adj2.add(int5);
        
        node_adj3.add(int2);
        node_adj3.add(int6);
        
        node_adj4.add(int1);
        node_adj4.add(int5);
        
        node_adj5.add(int4);
        node_adj5.add(int2);
        node_adj5.add(int6);
        
        node_adj6.add(int3);
        node_adj6.add(int5);
        
        node_coord1.add(0,300);
        node_coord1.add(1,200);
        
        node_coord2.add(0,600);
        node_coord2.add(1,200);
        
        node_coord3.add(0,900);
        node_coord3.add(1,200);
        
        node_coord4.add(0,300);
        node_coord4.add(1,600);
        
        node_coord5.add(0,600);
        node_coord5.add(1,600);
        
        node_coord6.add(0,900);
        node_coord6.add(1,600);
        
        int1 = new Node(n1,node_adj1, node_coord1);
        int2 = new Node(n2,node_adj2, node_coord2);
        int3 = new Node(n3,node_adj3, node_coord3);
        int4 = new Node(n4,node_adj4, node_coord4);
        int5 = new Node(n5,node_adj5, node_coord5);
        int6 = new Node(n6,node_adj6, node_coord6);
                
    }
}
