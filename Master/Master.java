import java.util.*;

/**
 * 
 * @author Heather Kemp
 * The Master class is like the "main" method, which controls the simulated warehouses' runs.
 * It manages the instances of the Floor, Robot, Inventory, Order, Belt, Visualizer, and other classes as required.
 * It has a method to addEvent to update it's internal "queues" for the events and its parameters.
 * It also includes an event runSimulation, which runs all Events using the provided Event interface (provided in a seperate java file
 *
 */

public class Master
{
    
    private ArrayList<Event> myEvents;
    private ArrayList<String> myParameters;
    

    /**
     * Constructor initializes the queues for the events
	 */
    public Master()
    {myEvents = new ArrayList<Event>();
     myParameters = new ArrayList<String>();
    }
    
     /**
     * Add an event. This code allows us to add to both queues at the same time, and if an item has a Master object
     * down the line, it will be able to access the private queues.
     *
     * @input newEvent - an Event type object for which to execute a method on
     * @input parameters - a String object which contains the internal method to execute and any parameters
	 */
    public void addEvent(Event newEvent, String parameters)
    {myEvents.add(newEvent);
     myParameters.add(parameters);
    }
    
    /**
     * Run simulation. This code creates instances of all of the types of objects. It also executes very simple
     * commands to each event to start the cycle of events for the day.
     *
	 */
    public void runSimulation()
    {Belt myBelt = new Belt();
     Floor myFloor = new Floor();
     Inventory myInventory = new Inventory();
     Order myOrder = new Order();
     Robot myRobot = new Robot(0,0,0);
     Shelf myShelf = new Shelf();
     Visualizer myVisualizer = new Visualizer();
     
     this.addEvent((Event)myBelt," ");
     this.addEvent((Event)myFloor, " ");
     this.addEvent((Event)myInventory," ");
     this.addEvent((Event)myOrder, " ");
     this.addEvent((Event)myRobot," ");
     this.addEvent((Event)myShelf, " ");
     this.addEvent((Event)myVisualizer," ");
     
     while(!myEvents.isEmpty())
     {Event newEvent = myEvents.remove(0);
      String newPara = myParameters.remove(0);
      if(newPara != "Null")
      {newEvent.performAction(newPara);
      myEvents.add(newEvent.getEvent());
      myParameters.add(newEvent.getPara());}
     }
     
    }
    
}
