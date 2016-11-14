
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author zhaoxinglu
 */
public class Mockfloor {
    int size = 7;
    ArrayList<Point> belt = new ArrayList<>();
    ArrayList<Point> sPoint = new ArrayList<>();
    
    Point packer;
    Point picker;
    Point receivingdock;
    Point charger;
    Point shippingdock;
    int j=0;
    int b=0;
    public Mockfloor(){
        // initialize the belt location
        
	for(int i = 0; i < 8; i++){
	   belt.add(new Point(0, i));
		b++;	
		}
	// initialize the shelf location
	for(int i = 2; i < 6; i++){
	   sPoint.add(new Point(4,i));
		j++;	
		}
	packer = new Point(1,1);
        picker = new Point(1,5);
	receivingdock = new Point();
	charger = new Point(2,6);
	shippingdock = new Point(0,0);
		
    }
    public int getWarehousesize() { return size; }
  
    public Point getPicker() { return picker; }
    public Point getPacker() { return packer; }
    public Point getShippingDock() { return shippingdock; }
    public Point getReceivingDock() { return receivingdock; }
    public Point getCharger() { return charger; }
    public ArrayList getBelt(){
		return belt;
	}
	public ArrayList getShelf(){
		return sPoint;
	}

    
    
}
