/**
 * @(#)TestKaryawanManager.java
 *
 *
 * @author 
 * @version 1.00 2020/5/4
 */


public class TestKaryawanManager {

    public static void main(String[] args) {
    	Employee karyawanAbo = new Employee("Arepit",20000);
    	Manager01 managerAmita = new Manager01("Amita",20000);
    	
    	System.out.println("Name : " + karyawanAbo.getEmployeeName());
    	System.out.println("Gaji : " + karyawanAbo.getSalary());
    	
    	System.out.println("");
    	System.out.println("Name : " + managerAmita.getEmployeeName());
    	System.out.println("Gaji : " + managerAmita.getSalary());
    }
    
    
}