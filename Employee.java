/**
 * @(#)Employee.java
 *
 *
 * @author 
 * @version 1.00 2020/5/4
 */


public class Employee {
	String employeeName;
	double salary;

    public Employee(String employeeName, double salary) {
    	this.employeeName = employeeName;
    	this.salary = salary;
    }
    
    public String getEmployeeName()
    {
    	return employeeName;
    }
    
    public void setEmployeeName(String employeeName)
    {
    	this.employeeName = employeeName;
    }
	
	public double getSalary()
    {
    	return salary;
    }
    
    public void setSalary(double salary)
    {
    	this.salary = salary;
	}
}