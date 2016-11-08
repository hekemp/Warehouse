
public class Belt implements Event{
	public Belt(){
	}
	
	public void performAction(String Method){
	    System.out.println("Belt did something.");
	}
	
	public Event getEvent(){

	     return (Event) this;
	   }
	        
	public String getPara(){
	    return "Null";
	   }
}
