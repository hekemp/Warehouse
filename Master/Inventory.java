
public class Inventory implements Event{

	public Inventory(){
	
	}
	public void performAction(String Method){
		System.out.println("Inventory did something");
	}
	
	public Event getEvent(){

	     return (Event) this;
	   }
	        
	public String getPara(){
	    return "Null";
	   }
}
