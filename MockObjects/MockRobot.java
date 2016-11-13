import java.util.*;

/**
 * 
 * @author Heather Kemp
 * the Master/Robot.java class is a mock version of the Robot.java object, created simply to test the Master's ability to
 * cycle through events.
 * It only implements the methods required by the Event interface and one simple move method.
 *
 */

public class Robot implements Event {

    private int myID;
    private int myX;
    private int myY;
    private ArrayList<int[]> myMovements;
    private PriorityQueue<Event> myEvents;
    private PriorityQueue<String> myParameters;

    /**
	 * Constructor initializes x location, y location, and ID, as well as the queues for events and arraylist for movements.
     * It saves these instance fields as the above variables for future use.
	 */
    
    public Robot(int x, int y, int ID){
        myX = x;
        myY = y;
        myMovements = new ArrayList<int[]>();
        myID = ID;
        myEvents = new PriorityQueue<Event>();
        myParameters = new PriorityQueue<String>();
    }
    
    /** Moves the robot. This method updates the robot's x and y location, prints out the action, and enqueues the next move.
     *
     * @input - x, an integer that marks the horizontal location of the robot
     * @input - y, an integer that marks the verticle location of the robot.
     */
    public void move(int x, int y){
        if(x == 1 && y == 1)
            {
            myX = x;
            myY = y;
            System.out.println("Robot " + myID + " has moved: X = "+myX+ " Y = "+myY+".");
            System.out.println("New move enqueued");
            myEvents.add(this);
            myParameters.add("move,1,1");}
        else
            {myX = x;
            myY = y;
            System.out.println("Robot " + myID + " has moved: X = "+myX+ " Y = "+myY+".");}
            
    }
    
    /**
	 * Gets the event. Returns this object as an Event
	 */
    
    public Event getEvent(){
    if(myEvents.isEmpty())
        return (Event) new Robot(1,1,1);
    else
        return myEvents.remove();   
    
    }
    
    /**
	 * Gets the parameters. Returns the parameter for the next call of this method.
	 */
    
    public String getPara(){
        if(myParameters.isEmpty())
            return "Null";
        else
            return myParameters.remove();   
        
        }

    /**
	 * Performs an action. Extracts the method to be executed and parameters from the method strong and then executes these
	 * methods.
	 * @input - a string which contains a method name/key and parameters, seperated by commas
	 */
    
    @Override
    public void performAction(String Method) {
            if(Method == "move,1,1")
                this.move(2, 2);
            else
                this.move(1, 1);
        
    }
    
}
