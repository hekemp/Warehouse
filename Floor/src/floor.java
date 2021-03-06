public class floor implements viewFloor,robotPath {
	int size = 7;
	Point[] belt = null;
	Point[] sPoint = null;
	Shelf[] shelf = new Shelf[4];
	Point packer;
	Point picker;
	Point receving;
	Point charger;
	Point shipping;
	
	public floor(){
		
		for(int i = 0; i < 8; i++){
			belt[i] = new Point(0, i);
			belt[i].belt = true;
		}
		
		for(int i = 2; i < 6; i++){
			sPoint[i] = new Point(4,i);
			shelf[i] = new Shelf(sPoint[i]);
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
	
	public Point[] getBelt(){
		return belt;
	}
	public Point[] getShelf(){
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
	
	private Point[] route = null;
	public Point[] getRoute(Point p1, Point p2){
		int move = Math.abs(p1.x - p2.x) + Math.abs(p1.x - p2.x);
		for(int i=0; i< move-1;i++){
			if(p1.x - p2.x > 1){
				route[i] = new Point(p1.x -1, p1.y);
			}
			if(p1.x - p2.x < -1){
				route[i] = new Point(p1.x +1, p1.y);
			}else{
				if(p1.y- p2.y > 0){
					route[i] = new Point(p1.x, p1.y-1);
				}
				if(p1.y- p2.y < 0){
					route[i] = new Point(p1.x, p1.y+1);
				}else{
					if(p1.x - p2.x > 0){
						route[i] = new Point(p1.x -1, p1.y);
					}
					if(p1.x - p2.x < 0){
						route[i] = new Point(p1.x +1, p1.y);
					}
				}
			}
			
		}
		route[move-1]= p2;
		return route;
	}
	
}


class Point{
	int x, y;
	boolean belt = false;
	boolean shelf = false;
	boolean picker = false;
	boolean packer = false;
	boolean receving = false;
	boolean shipping = false;
	boolean charger = false;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Point(){ 
		this(5, 7);
	}
	public boolean highway(){
		if(shelf||picker||packer||receving||shipping||charger){
			return true;
		}else{
			return false;
		}
	}
	
}


class Shelf{
	int Capacity = 20;
	int x, y;
	public Shelf(Point P){
		this.x = P.x;
		this.y = P.y;
		P.shelf = true;
	}
	
	public int addItems(int amount){
		return Capacity += amount;
	}
	
	public int reduceItems(int amount){
		return Capacity -= amount;
	}
	
	// floor will memorize the new location where robot
	// put the shelf at
	public Point reSetLocation(Point P){
		this.x = P.x;
		this.y = P.y;
		P.shelf = true;
	}
	
}









