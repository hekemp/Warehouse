
public class Order implements Event{

    public Order(){
    
    }
    
    public void performAction(String Method){
        System.out.println("Order did something.");
    }
    
    public Event getEvent(){

         return (Event) this;
       }
            
    public String getPara(){
        return "Null";
       }
}
