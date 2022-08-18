/**
 * @(#)MountainBike.java
 *
 *
 * @author 
 * @version 1.00 2020/4/27
 */


public class MountainBike extends Bicycle {
	
	public int seatHeight;

    public MountainBike(int startHeight, int startSpeed, int startGear) {
    	super (startSpeed, startGear);
    	seatHeight = startHeight;
    }
    
    public void seatHeight(int newValue){
    	seatHeight = newValue;
    }
    
    
}