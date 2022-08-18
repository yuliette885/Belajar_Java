/**
 * @(#)TestPolimorpish.java
 *
 *
 * @author 
 * @version 1.00 2020/5/13
 */


public class TestPolimorpish 
{

    public static void main(String[] args) 
    {
    	Person ref;
    	Student studentObject = new Student();
    	Employee01 employeeObject = new Employee01();
    	
    	String temp;
    	
    	studentObject.setName("Dian P");
    	employeeObject.setName("Nuswantari");
    	
    	System.out.println("");
    	
    	ref = studentObject;
    	temp = ref.getName();
    	System.out.println(temp);
    	
    	System.out.println(""); 
    		
    	ref = employeeObject;
    	temp = ref.getName();
    	System.out.println(temp);
    }
    
    
}