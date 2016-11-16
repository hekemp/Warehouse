/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zhaoxinglu
 * This class make a fake robot object
 */
public class MockRobot {
    Point robot;
    
 /**
 * @author zhaoxinglu
 * @param Point, indicate the coordinate of robot in the map
 * @param boolean, indicate robot state
 */
    public MockRobot(){
        robot=new Point(4,3);
        ismove=true;
    }//initialize where robot is originally and continuously move
  
    
    public Point TrackRobot(){
       return robot;
   }
/**
 * @author zhaoxinglu
 * @return Point, keep track of where robot is in the map
 */
   
/**
 * @author zhaoxinglu
 * This method change the robot state, make it possible to stop
 */
    
}
