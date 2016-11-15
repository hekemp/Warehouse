/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zhaoxinglu
 * This class is used to test only
 */
public class MockBelt {
  
    Point item;
    boolean ismove;
  /**
 *
 * @author zhaoxinglu
 * @param Point, which represent the coordinates of item on the belt
 * @param boolean, we can know whether the item on the belt is move or not
 * These two provide useful information to Visulaizer 
 */
    public MockBelt(){
        item=new Point(0,3);
        ismove=true;
    }
 /**
 *
 * @author zhaoxinglu
 * A constructor for mock belt 
 * 
 */
    public Point TrackItem(){
    return item;
}
 /**
 *
 * @author zhaoxinglu
 * @return Point, the coordinate of item
 * 
 */
    public void changemovestate(boolean t){
        ismove=t;
    }
  /**
 *
 * @author zhaoxinglu
 * @param boolean, which can be used to change the state of item
 * 
 */
}
