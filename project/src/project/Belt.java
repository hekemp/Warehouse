package project;

public class Belt {

	//public static void main(String[] args) {
        // TODO code application logic here
    //}
	
	public Belt(){}
    
    boolean moving;
    double speed;
    private Bin bin;
    private Item item;
    int tick;
    
    
    void changeSpeed(double x){
        speed = x;
    }
    
    void pause(){
        speed = 0;
    }
    
    void start(double x){
        speed = x;
    }
    
    //Bin getCurrentBins(){}
    
    void add(Bin bin){
        
    }
    
    void remove(Bin bin){}
    
    void addItem(Item item){}
    
    void removeItem(Item item){}
}


abstract class Sensor{
    int x;
    int y;
    
    int getX(){
        return x;
    }
    
    int getY(){
        return y;
    }

}

class Bin extends Sensor{

    
    public Bin(){
        int binNum;
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
    
    public void scan(){}
    
    public void packe(){}
    
}

