package warehouse;

import java.util.HashMap;

public class Orders {
	
	String progress;
	String address;
	String dateReceived;
	int orderNumber;
	HashMap<String, Integer> Item;
	public Orders(String progress,String address, String dateReceived,int orderNumber){
		progress=progress;
		address=address;
		dateReceived=dateReceived;
		this.orderNumber=orderNumber;
		this.Item= new HashMap<String,Integer>();
		
	}
	
	
	
	public void ship(String dateReceived){
	
	}
	public void cancel(){
		
	}
	
	public void changeProgress(){
		
	}//
	public void returningprocess(){
		
	}
	public void addItems(){
		
	}
	public void getProgress(){
		
	}//
	
	
}
