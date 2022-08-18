/**
 * @(#)RoadBike.java
 *
 *
 * @author 
 * @version 1.00 2020/5/2
 */


public class RoadBike extends Bicycle {
	public int seatHeight, seatTube, handlebarHeight;

    public RoadBike(int startHeight, int startSpeed, int startGear) 
    {
    	super(startSpeed, startGear);
    	seatHeight = startHeight;
    	seatTube = startGear;
    	handlebarHeight = startHeight;
    }
    
    public void seatHeight(int newValue)
    {
    	seatHeight = newValue;
    }
    
    public void seatTube(int newValue)
    {
    	seatTube = newValue;
    }
    
    public void handlebarHeight(int newValue)
    {
    	handlebarHeight = newValue;
    }
    
    
}