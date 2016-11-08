import java.util.*;

public class Robot implements Event {

    private int myID;
    private int myX;
    private int myY;
    private ArrayList<int[]> myMovements;
    private PriorityQueue<Event> myEvents;
    private PriorityQueue<String> myParameters;

    public Robot(int x, int y, int ID){
        myX = x;
        myY = y;
        myMovements = new ArrayList<int[]>();
        myID = ID;
        myEvents = new PriorityQueue<Event>();
        myParameters = new PriorityQueue<String>();
    }
    
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
    
    public Event getEvent(){
    if(myEvents.isEmpty())
        return (Event) new Robot(1,1,1);
    else
        return myEvents.remove();   
    
    }
    
    public String getPara(){
        if(myParameters.isEmpty())
            return "Null";
        else
            return myParameters.remove();   
        
        }

    @Override
    public void performAction(String Method) {
            if(Method == "move,1,1")
                this.move(2, 2);
            else
                this.move(1, 1);
        
    }
    
    
    /// move method moves the 1/1 but then enques another move with x,y
}
