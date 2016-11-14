
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
 */
public class Visualizer {
   
    
    
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        createAndShowGUI(); 
        }
      });
    }

    private static void createAndShowGUI() {
       
        JFrame f = new JFrame("Warehouse");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        f.add(new MyPanel(new Mockfloor())); 
        f.pack();
        f.setVisible(true);
    } 


}
class MyPanel extends JPanel {
    
    Mockfloor m;
    MockBelt b=new MockBelt();
    MockRobot r=new MockRobot();
    List<Point> allPoints;
    
    public MyPanel(Mockfloor m1) {
         setBorder(BorderFactory.createLineBorder(Color.black));
         this.m=m1;
         setup();
    }
   
    
    
    public void setup(){
        allPoints=new ArrayList<Point>();
        for (int i=0;i<m.getWarehousesize();i++)
	  for (int j=0;j<m.getWarehousesize();j++)
		allPoints.add(new Point(i,j));
        System.out.println("Warehouse size is:"+m.size);
        System.out.println("Belt information");
        System.out.println("Picker at:"+m.getPicker());
        System.out.println("Packer at:"+m.getPacker());
        System.out.println("Shipping dock at"+m.getShippingDock());
        System.out.println("Receiving Dock at"+m.getReceivingDock());
        System.out.println("Charger at"+m.getCharger());
        System.out.println("Item is at:"+b.TrackItem());
        System.out.println("Robot is at"+r.TrackRobot());
       
    }
    
    public void tick(int count){
        String display = "Tick %d";
	System.out.println(String.format(display,count)); 
    }
    
    
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
}




  
 


