import java.util.ArrayList;

public class Robot implements Event {

	private int myID;
	private int myX;
	private int myY;
	private ArrayList<int[]> myMovements;

	public Robot(int x, int y, int ID){
		myX = x;
		myY = y;
		myMovements = new ArrayList<int[]>();
		myID = ID;
	}
	
	public void move(int x, int y){
		System.out.println("Robot " + myID + " has moved: X = "+myX+ " Y = "+myY+".");
		myX = x;
		myY = y;
	}

	@Override
	public void performAction(String Method) {
		
		
	}
	
	
	/// move method moves the 1/1 but then enques another move with x,y
}
