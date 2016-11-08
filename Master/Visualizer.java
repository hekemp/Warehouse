
public class Visualizer implements Event{
	
	public Visualizer(){
		
	}

	public void performAction(String Method){
		System.out.println("Visualizer did something");
	}
	
	public Event getEvent(){

	     return (Event) this;
	   }
	        
	public String getPara(){
	    return "Null";
	   }
}
