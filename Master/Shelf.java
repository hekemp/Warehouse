
public class Shelf implements Event{

	public Shelf(){
		
	}
	
	public void performAction(String Method){
		System.out.println("Shelf did something.");
	}
	
	public Event getEvent(){

	     return (Event) this;
	   }
	        
	public String getPara(){
	    return "Null";
	   }
}
