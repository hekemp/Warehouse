
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zhaoxinglu
 * Visualizer class is use Java Swing to show a picture of
 * what is happening in the warehouse
 */
public class Visualizer {
 
/**
 *
 * @author zhaoxinglu
 * main method mainly calls createandshowGUI method
 */
  
    
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI(); 
        }
      });
    }
/**
 *
 * @author zhaoxinglu
 * @param f is an instance of JFram class,it creates a window 
 * that has decorations such as a border, a title, and supports button components. 
 * we use a constructor that lets us set the frame title "warehouse"
 * we use add method to add the content designed by ourselves
 * The EXIT_ON_CLOSE operation exits the program when user closes the frame
 */
    private static void createAndShowGUI() {
       
        JFrame f = new JFrame("Warehouse");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        f.add(new MyPanel(new Mockfloor())); 
        f.pack();
        f.setVisible(true);
    } 


}
/**
 *
 * @author zhaoxinglu
 * MyPanel class collect warehouse data and visualizes it on the panel
 */
  
class MyPanel extends JPanel {
    
    Mockfloor m;
    MockBelt b=new MockBelt();
    MockRobot r=new MockRobot();
 /**
 *
 * @author zhaoxinglu
 * @param m is a object of Mockfloor class, Mypanel can get information of warehouse from it
 * @param b is a object of MockBelt class, Mypanel class can get track of the item on the belt
 * @param r is a object of MockRobot class,Mypanel class can get coordinate of the robot
 * all mock class has been written for convinient testing
 */
  
    
    public MyPanel(Mockfloor m1) {
         setBorder(BorderFactory.createLineBorder(Color.black));
         this.m=m1;
         setup();
    }
   /**
 *
 * @author zhaoxinglu
 * @input Mockfloor, which initialize the instance variable m
 * MyPanel initializer set GUI border to be black
 * also calls setup method 
 */
    
    
    public void setup(){
       
        System.out.println("Warehouse size is:"+m.size);
        System.out.print("Belt information");
        System.out.println("Picker at:"+m.getPicker());
        System.out.println("Packer at:"+m.getPacker());
        System.out.println("Shipping dock at"+m.getShippingDock());
        System.out.println("Receiving Dock at"+m.getReceivingDock());
        System.out.println("Charger at"+m.getCharger());
        
       
    }
	
/**
 *
 * @author zhaoxinglu
 * setup method just print out where fixed things are in the warehouse
 */
    
    public void tick(int count){
        String display = "Tick %d";
	
        System.out.println(String.format(display,count));
        if (b.ismove==true){
	System.out.println("Item is at:"+b.TrackItem());}
        if(r.ismove==true){
        System.out.println("Robot is at"+r.TrackRobot());}
        if (m.isshelfchange()==true){
	for(int i=0;i<m.j;i++){
           System.out.println("Shelf"+i+"is at"+m.getShelf().get(i));}//shelf
    }
    }
/**
 *
 * @author zhaoxinglu
 * @input int, make method print out things state at input time
 * @param String just represents word tick
 * tick method update item coordinates at specific time
 */
    
    
    public void paint(Graphics g) {
       ArrayList<Point> sf=m.getShelf();
       g.drawRect(10,10,m.getWarehousesize()*20,m.getWarehousesize()*20);//warehouse 
       g.drawRect(10, 10, 20, (m.b-1)*20);//belt
       for(int i=0;i<m.j;i++){
          g.drawRect(sf.get(i).x*20+10, sf.get(i).y*20+10, 20, 20);}//shelf
      
       g.setColor(Color.green);
       g.drawLine(m.getReceivingDock().x*20+10,m.getReceivingDock().y*20+10,m.getReceivingDock().x*20+30,m.getReceivingDock().y*20+10);//draw for receiving dock
       g.setColor(Color.yellow);
       g.drawLine(10,10,30,10);//draw for shipping dock
       g.setColor(Color.blue);
       g.drawRect(m.getCharger().x*20+10,m.getCharger().y*20+10,20,20);//draw for robot charge
       g.setColor(Color.PINK);
       g.drawRect(m.getPicker().x*20+10, m.getPicker().y*20+10,20, 20);//picker
       g.drawRect(m.getPacker().x*20+10, m.getPacker().y*20+10, 20, 20);//packer
       g.setColor(Color.cyan);
       g.drawOval(r.TrackRobot().x*20+13, r.TrackRobot().y*20+13, 15, 15);//robot
       g.setColor(Color.GRAY);
       g.drawRect(b.TrackItem().x*20+10, b.TrackItem().y*20+10, 20, 20);//item
       
  }
/**
*
* @author zhaoxinglu
* @param Graphics
* paint method temporarily uses mock object and expected return data to draw the warehouse
*/
}




  
 


