/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zhaoxinglu
 */
public class Point {
    int x;
    int y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    public Point(){
        this(5,7);
        
    }
    public String toString(){
        String s;
        s = String.format("(%d"+","+"%d)", x, y);
        return s;


    
}
}
