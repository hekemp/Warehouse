package warehouse;

public class Robot {
	private int robotId;
	private int robotCharge;
	private boolean shelf = false;
	public boolean usable = true;
	private int xCord;
	private int yCord;
	
	public Robot(int x, int y, int id, int charge ){
		xCord = x;
		yCord = y;
		robotId = id;
		robotCharge = charge;
	}
	
	public void move(int x, int y){
		/*
		 * needs to check to see if space given is occupied
		 * also need to check if shelf is true or false...this
		 * determines if we are moving a shelf or not
		 */
		xCord = x;
		yCord = y;
	}
	
	public void restAndCharge(){
		//robots cannot be used while charging
		// charge increases by one every clock tick...
		usable = false;
		while (robotCharge < 30){
			robotCharge = robotCharge +1;
		}
		usable = true;
	}
	
	public void chargeUsage(){
		//when a robot is usable = true
		//charge needs to decrease by one every clock tick
		if (robotCharge == 20){
			//head back to charging station
		}
		if (robotCharge == 0){
			usable = false;
		}
		else{
			usable = true;
		}
	}
	
	public void pickShelf(){
		//wait one clock tick before picking up and moving
		shelf = true;
	}
}
