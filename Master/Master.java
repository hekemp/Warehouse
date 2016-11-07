import java.util.*;


public class Master
{
    // instance variables - replace the example below with your own
    private PriorityQueue<Event> myEvents;
    //private PriorityQueue<Object[]> myParameters;
    

    public Master()
    {myEvents = new PriorityQueue<Event>();

    }
    
    public void addEvent(Event newEvent)
    {myEvents.add(newEvent);
    }
    
    //public void addParameters(Object... args)
    //{myParameters.add(args);
    //}
    
    public static void runSimulation()
    {
    }
    
    // Unit tests with mock objects can test whether queueing new events works, 
    // initializing the queue with some initial events, and of course creating 
    // instances of the other (mock) components.
    
    
}
