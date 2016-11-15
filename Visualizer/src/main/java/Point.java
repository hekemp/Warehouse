/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zhaoxinglu
 * point class helps to get coordinates of items
 */
public class Point {
    int x;
    int y;
 /**
 + *
 + * @author zhaoxinglu
 + * two initializer, one can take parameters to set coordinates 
 + * the other one defines exact coordinate numbers
 + */
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    public Point(){
        this(5,7);
        
    }
 /**
 *
 * @author zhaoxinglu
 * @override toString, print out the x and y in a clear way
 * @return String
 */
    
    
    public String toString(){
        String s;
        s = String.format("(%d"+","+"%d)", x, y);
        return s;


    
}
}
