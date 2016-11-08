package project;

import java.util.*;

public class Belt {

	//public static void main(String[] args) {
        /// TODO code application logic here
    //}
    
    boolean moving;
    double speed = 0.0;
    private Bin bin;
    private Item item;
    
    public Belt(){}
    
    
    void changeSpeed(double x){
        speed = x;
    }
    
    void pause(){
        speed = 0;
    }
    
    void start(double x){
        speed = x;
    }
   
    
    ArrayList<Bin> binOnBelt = new ArrayList<>();
    
    void add(Bin bin){
    	binOnBelt.add(bin);
        
    }
    
    void remove(Bin bin){
    	binOnBelt.remove(binOnBelt.size()-1);
    }
    
    ArrayList<Item> itemOnBelt = new ArrayList<>();
    
    void addItem(Item item){
    	itemOnBelt.add(item);
    }
    
    void removeItem(Item item){
    	itemOnBelt.remove(itemOnBelt.size()-1);
    }
}


abstract class Sensor{
    int x;
    int y;
    
    int getX(int tick){
        return x;
    }
    
    int getY(int tick){
        return y;
    }

}

class Bin extends Sensor{
	int binNum;
	boolean onBelt;
    
    public Bin(){
        Bin bin = new Bin();
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
}
}

class Item extends Sensor{
    int itemNum;
    int weight;
    boolean packed;
    boolean scanned;
    
    public Item(){
        Item item = new Item();
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getWeight(){
        return weight;
    }
    
    public void scan(){
    	
    }
    
    public void packe(){
    	if(packed == false){
    		packe();
    	}
    }
    
}

