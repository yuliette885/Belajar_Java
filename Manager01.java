/**
 * @(#)Manager01.java
 *
 *
 * @author 
 * @version 1.00 2020/5/4
 */


public class Manager01 extends Employee {
	public static final double BONUSPERCENT=0.2;
	public Manager01(String employeeName, double salary){
		super(employeeName, salary);
	}

    public double getSalary() {
    	return salary + (salary*BONUSPERCENT);
    }
    
    
}