
public class Floor implements Event{

	public Floor(){
	}
	
	public void performAction(String Method){
		System.out.println("Floor did something");
	}
	
	public Event getEvent(){

	     return (Event) this;
	   }
	        
	public String getPara(){
	    return "Null";
	   }
}
