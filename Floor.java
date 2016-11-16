/**
 *
 * @author Xinyu Qian
 */
import java.util.ArrayList;
public class floor implements viewFloor,robotPath {
	int size = 7;
	ArrayList<Point> belt = new ArrayList<>();
	ArrayList<Point> sPoint = new ArrayList<>();
	Shelf[] shelf = new Shelf[4];
	Point packer;
	Point picker;
	Point receving;
	Point charger;
	Point shipping;
	
	//Initializing the floor
	public floor(){
		// initialize the belt location
		for(int i = 0; i < 8; i++){
			belt.add(new Point(0, i));
			belt.get(i).belt = true;
		}
		// initialize the shelf location
		for(int i = 2; i < 6; i++){
			sPoint.add(new Point(4,i));
			shelf[i-2] = new Shelf(sPoint.get(i-2));
		}
		packer = new Point(1,1);
		packer.packer = true;
		
		picker = new Point(1,5);
		picker.picker = true;
		
		receving = new Point();
		receving.receving = true;
		
		charger = new Point(2,6);
		charger.charger = true;
		
		shipping = new Point(0,0);
		shipping.shipping = true;
	}
	
	public ArrayList getBelt(){
		return belt;
	}
	public ArrayList getShelf(){
		return sPoint;
	}
	public Point getPacker(){
		return packer;
	}
	public Point getPicker(){
		return picker;
	}
	public Point getReceving(){
		return receving;
	}
	public Point getCharger(){
		return charger;
	}
	public Point shipping(){
		return shipping;
	}
	
	public int floorSize(){
		return size;
	}
	
	// the list of points for robot from p1 to p2
	private ArrayList<Point> route = new ArrayList<>();
    /**
     * @auther Xinyu Qian
     * @param p1 start point
     * @param p2 end point
     * @return the ArrayList of points from p1 to p2
     */
	public ArrayList getRoute(Point p1, Point p2){
        int move = Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
        for(int i=0; i< move-1;i++){
            if(p1.x - p2.x > 1){
                route.add(new Point(p1.x -1, p1.y));
            }
            else if(p1.x - p2.x < -1){
                route.add(new Point(p1.x +1, p1.y));
            }else{
                if(p1.y- p2.y > 0){
                    route.add(new Point(p1.x, p1.y-1));
                }
                else if(p1.y- p2.y < 0){
                    route.add(new Point(p1.x, p1.y+1));
                
                }else{
                    if(p1.x - p2.x > 0){
                        route.add(new Point(p1.x -1, p1.y));
                    }
                    if(p1.x - p2.x < 0){
                        route.add(new Point(p1.x +1, p1.y));
                    }
                }
            }
            p1 = route.get(i);
        }
        route.add(p2);
        return route;
    }
	
}

/**
 * 
 * @author Xinyu Qian
 */
class Point{
	int x, y;
	
	//this part would be ignored for right now
	boolean belt = false;
	boolean shelf = false;
	boolean picker = false;
	boolean packer = false;
	boolean receving = false;
	boolean shipping = false;
	boolean charger = false;
	/////////////////////////
	
	/**
     * 
     * @param x the x-coordinate
     * @param y the y-coordinate
     */
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Point(){ 
		this(5, 7);
	}
	
	// if the point is a highway return true
	public boolean highway(){
		return shelf||picker||packer||receving||shipping||charger;
	}
	
	/**
     * 
     * @return a readable tuple of the point
     */
	@Override
    public String toString(){
        String s;
        s = String.format("(%d"+","+"%d)", x, y);
        return s;
    }
	
}

class Shelf{
	int items = 0;
	ArrayList<item> Item = new ArrayList()<>;
	int x, y;
	public Shelf(Point P){
		this.x = P.x;
		this.y = P.y;
		P.shelf = true;
	}
	
	public String addItems(item I){
		Item.add(I);
		items++;
		if(items == 20) return "This shelf is full.";
		if(items > 20){
			items--;
			return "Load fails, shelf is full.";
		}
		return String.format("Add item %1$d %s to shelf", I.itemID, I.type);
	}
	
	public String removeItems(item I){
		Item.remove(Item.indexOf(I));
		items--;
		return String.format("Removed item %1$d %s from shelf", I.itemID, I.type);;
	}
	
	// floor will memorize the new location where robot
	// put the shelf at
	/**
     * 
     * @param P the location where robot drop the shelf
     */
	public Point reSetLocation(Point P){
		this.x = P.x;
		this.y = P.y;
		P.shelf = true;
	}
	
}
