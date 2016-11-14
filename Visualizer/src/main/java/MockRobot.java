/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zhaoxinglu
 */
public class MockRobot {
    Point robot;
    public MockRobot(){
        robot=new Point(4,3);
    }
   public Point TrackRobot(){
       return robot;
   }
    
}
