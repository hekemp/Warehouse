package inventory;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * @author Yunfan Jiang
 *
 */
public class itemcontrol {
	int numberinstock;
	int currentID;           
	int maxinventory=80;
	int mininventory;
	String[] itemtypes;
	Floor floor;
	HashMap<String,ArrayList<Integer>> inventory; //key: item type, value: item ID 
	//initialize
	String[] itemlist={"pen","pear","apple","banana","pen","pineapple"};
	void itemcontrol(){
		numberinstock=0;
		currentID=0;
		//extract item from the item list and put it on the shelf.
		for (int z=0;z<itemlist.length&&z<maxinventory;z++){
			item a= new item(currentID);    
			a.type=itemlist[z]; 
			additemtostock(a);
			placeitemtoshelf(a);
			currentID++;
		}
		
	}
	item finditem(String product){
		
		
		
	}
	
	Item removeitem(item a, Shelf f){
		
	}
	

	
	int getinventory(){
		return numberinstock;
		}
	//check if low stock, and if so, add inventory 
	void checkstatus(){
		if (numberinstock<mininventory){		
			increaseinventory(maxinventory-numberinstock);
			}
		}
		
	void additemtostock(item x){
		if (inventory.containsKey(x.type)){
			ArrayList<Integer> temp= inventory.get(x.type);
			temp.add(x.itemID);
			inventory.put(x.type, (temp));  
		}
		else {
			ArrayList<Integer> val= new ArrayList<Integer>();
			val.add(x.itemID);
			inventory.put(x.type, val);
		}
	}
	void placeitemtoshelf(item x){
		for (int j=0;j<floor.shelf;j++){
			if(floor.shelf[j].full==false){
				floor.shelf[j].addItem(x.itemID);	
				break;
			}
		}
	}
	
	
	void increaseinventory(int x){
		while(currentID<maxinventory){
			item a= new item(currentID);    
			a.type=itemlist[currentID];
			additemtostock(a);
			placeitemtoshelf(a);
			currentID++;	
	}
	
	}
	


}
