
/**
 * 
 * @author Heather Kemp
 * The Event class implements three basic methods; performAction, getEvent, getPara, in order to force all items in the warehouse
 * to be able to execute these methods and be stored in one 'queue'. 
 *
 */

public interface Event {
	
	/**
	 * Performs an action. Extracts the method to be executed and parameters from the method strong and then executes these
	 * methods.
	 * @input - a string which contains a method name/key and parameters, seperated by commas
	 */
	
	void performAction(String Method);
	
	/**
	 * Gets the event. Returns this object as an Event
	 */
	
	Event getEvent();
	
	/**
	 * Gets the parameters. Returns the parameter for the next call of this method.
	 */
	String getPara();
}
