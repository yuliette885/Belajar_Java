/**
 * @(#)Bicycle.java
 *
 *
 * @author 
 * @version 1.00 2020/4/27
 */

public class Bicycle {
	public int gear;
	public int speed;

    public Bicycle(int startSpeed, int startGear) {
    	gear = startGear;
    	speed = startSpeed;
    }
    
    public void setGear(int newValue) {
    	gear = newValue;
    }
    
    public void applyBrake(int decrement) {
    	speed -= decrement;
    }
    
    public void speedUp(int increment) {
    	speed += increment;
    }
}