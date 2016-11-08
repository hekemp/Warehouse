import java.util.*;


public class Master
{
    // instance variables - replace the example below with your own
    private ArrayList<Event> myEvents;
    private ArrayList<String> myParameters;
    

    public Master()
    {myEvents = new ArrayList<Event>();
     myParameters = new ArrayList<String>();
    }
    
    public void addEvent(Event newEvent, String parameters)
    {myEvents.add(newEvent);
     myParameters.add(parameters);
    }
    
    
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
    
    // Unit tests with mock objects can test whether queueing new events works, 
    // initializing the queue with some initial events, and of course creating 
    // instances of the other (mock) components.
    
    
}
