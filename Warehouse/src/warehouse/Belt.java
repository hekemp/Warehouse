package warehouse;

import java.util.*;

/**
 * @author Mouna Elkeurti
 * Bin class moves bins with the order from the picker to the packer then 
 * from the packer to the dock location to get it shipped
 */

public class Belt implements Event{

    
    boolean moving;
    double speed = 0.0;
    private Bin bin;
    int tick =0;
    Order order;
    
    public Belt(){}
    
    /**
     * @author Mouna Elkeurti
     * @param x is the speed of which the belt is moving with
     * pausing, starting and changing the speed of the belt
     */
    void changeSpeed(double x){
        speed = x;
    }
    
    /**
     * @author Mouna Elkeurti 
     * pausing the belt to leave time for the picker to add bin on the bell then restart it
     */
    void pause(){
        speed = 0;
    }
    
    void start(double x){
        speed = x;
    }
    
    boolean ismoving(){
    	tick++;
    	moving = true;
    }
    	
   
    
    ArrayList<Bin> binOnBelt = new ArrayList<>();
     
    /**
     * @author Mouna Elkeurti
     * @param bins are added to the belt
      * the picker add bins to the belt to the packer
      */
    void add(Bin bin){
    	tick =0; pause();
    	binOnBelt.add(bin);
        ismoving();
    }
    /**
     * @author Mouna Elkeurti 
     * @param bins are removed from the belt
     * bin is removed from the belt once it arrives to the dock location
     */
    void remove(Bin bin){
    	tick =0;
    	binOnBelt.remove(binOnBelt.size()-1);
    	ismoving();
    }
    
    ArrayList<Order> orderOnBelt = new ArrayList<>();
    
    /**
     * @author Mouna Elkeurti
     * @param orders are added to the belt 
     * method can be used by order to add a new order in the belt or romove it to go to the dock
     */
    void addOrder(Order order){
    	orderOnBelt.add(order);
    }
    
    /**
     * @author Mouna Elkeurti
     * Order arrives the to the shipping dock
     */
    void removeOrder(Order order){
    	orderOnBelt.remove(orderOnBelt.size()-1);
    }
    
    void scan(){
    	tick =0;
    	pause();
    	getOrderID();
    }
    
    void pack(){
    	pause();
    	tick =0;
    	order_belt = true;
    }
    
}

/**
 * @author Mouna Elkeurti
 * bins are tracked, when they are in the belt when the bins arrives to the end of belt
 */

class Bin {
	int binNum;
	boolean onBelt = false;
	boolean order_Belt = false;
	Order order;
    
    public Bin(){
        Bin bin = new Bin();
        
    }
    
    /**
     * @author Mouna Elkeurti
     * Order are put on the belt 
     */
    
    public boolean bin_full(){
    	return order_Belt = true;
    }
}
   


