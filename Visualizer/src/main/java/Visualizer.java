
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 *
 * @author zhaoxinglu
 * This class is to use Java Swing to show a picture of the warehouse
 */
public class Visualizer {
 

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
 * This method create GUI and label it "warehouse"
 */
    private static void createAndShowGUI() {
       
        JFrame f = new JFrame("Warehouse");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        f.add(new MyPanel()); 
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
    /**
    * @author zhaoxinglu
    * initializer sets line border's color to be black
    */
    public MyPanel() {
         setBorder(BorderFactory.createLineBorder(Color.black));
         
    }
    viewFloor f;
    Beltdata b;
    Robotdata r;
    Inventorydata i;
    Orderdata o;
 
/**
 *
 * @author zhaoxinglu
 * printout method print what is happening in the warehouse
 */
    
    public void printout(){
        System.out.println("Item is at:"+b.TrackItem());
        System.out.println("Robot is at"+r.TrackRobot());
        System.out.println("Inventory is :"+i.inventorylist());
        System.out.println("Robot is at"+o.orderlist());
    }
  
	
/**
 *
 * @author zhaoxinglu
 * @param Graphics
 * paint method temporarily uses mock object and expected return data to draw the warehouse
 */
    
    public void paint(Graphics g) {
       viewFloor f1=mock(viewFloor.class);
        Beltdata b=mock(Beltdata.class);
        Robotdata r=mock(Robotdata.class);
       Point[] P1=new Point[8];
       Point[] P2=new Point[8];
        int j=0;
        for(int i = 2; i < 6; i++){
	   P1[j] = new Point(4,i);
            j++;}
        for(int i = 0; i < 8; i++){
	   P2[i] = new Point(0, i);}
	   when(f1.getShelf()).thenReturn(P1);
           when(f1.floorSize()).thenReturn(7);
           when(f1.getBelt()).thenReturn(P2);
           when(f1.getPacker()).thenReturn(new Point(1,1));
           when(f1.getPicker()).thenReturn(new Point(1,5));
           when(f1.getReceving()).thenReturn(new Point());
           when(f1.shipping()).thenReturn(new Point(0,0));
           when(f1.getCharger()).thenReturn(new Point(2,6));
           when(r.TrackRobot()).thenReturn(new Point(4,3));
           when(b.TrackItem()).thenReturn(new Point(0,3));
           
       Point[] sf=f1.getShelf();
       g.drawRect(10,10,f1.floorSize()*20,f1.floorSize()*20);//warehouse 
       g.drawRect(10, 10, 20, (f1.getBelt().length-1)*20);//belt
       for(int i=0;i<j;i++){
          g.drawRect(sf[i].x*20+10, sf[i].y*20+10, 20, 20);}//shelf
      
       g.setColor(Color.green);
       g.drawLine(f1.getReceving().x*20+10,f1.getReceving().y*20+10,f1.getReceving().x*20+30,f1.getReceving().y*20+10);//draw for receiving dock
       g.setColor(Color.yellow);
       g.drawLine(10,10,30,10);//draw for shipping dock
       g.setColor(Color.blue);
       g.drawRect(f1.getCharger().x*20+10,f1.getCharger().y*20+10,20,20);//draw for robot charge
       g.setColor(Color.PINK);
       g.drawRect(f1.getPicker().x*20+10, f1.getPicker().y*20+10,20, 20);//picker
       g.drawRect(f1.getPacker().x*20+10, f1.getPacker().y*20+10, 20, 20);//packer
       g.setColor(Color.cyan);
       g.drawOval(r.TrackRobot().x*20+13, r.TrackRobot().y*20+13, 15, 15);//robot
       g.setColor(Color.GRAY);
       g.drawRect(b.TrackItem().x*20+10, b.TrackItem().y*20+10, 20, 20);//item
       
  }
}
/**
 *
 * @author zhaoxinglu
 * point class helps to get coordinates of items
 */
class Point{
    int x;
    int y;
 /**
 *
 * @author zhaoxinglu
 * two initializer, one can take parameters to set coordinates 
 * the other one defines exact coordinate numbers
 */
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    public Point(){
        this(5,7);
        
    }
}

/**
 *
 * @author zhaoxinglu
 * interface from floor class, get information of where belt, shelf, packer
 * picker, receiving dock, shipping dock are and the floor size.
 */
interface viewFloor{
  public Point[] getBelt();
  public Point[] getShelf();
  public Point getPacker();
  public Point getPicker();
  public Point getReceving();
  public Point getCharger();
  public Point shipping();
  public int floorSize();
  
  }

/**
 *
 * @author zhaoxinglu
 * interface from belt class, get information of where the item on the belt is.
 */
interface Beltdata{
   public Point TrackItem();
  
  
     }
/**
 *
 * @author zhaoxinglu
 * interface from robot class, get coordinate of the movement of robot
 */
interface Robotdata{
    public Point TrackRobot();
  }
/**
 *
 * @author zhaoxinglu
 * interface from order class, get information of the orderlist
 */
interface Orderdata{
    public String orderlist();
}
/**
 *
 * @author zhaoxinglu
 * interface from inventory class, get information of the inventorylist
 */
interface Inventorydata{
    public String inventorylist();
}
   

  
 


