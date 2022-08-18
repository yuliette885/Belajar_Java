/**
 * @(#)TestMamalia.java
 *
 *
 * @author 
 * @version 1.00 2020/5/13
 */


public class TestMamalia {

    public static void main(String[] args) 
    {
    	Mamalia ref;
    	Kucing01 kucingObject = new Kucing01();
    	Sapi sapiObject = new Sapi();
    	
    	String temp;
    	
    	kucingObject.setSuara("Meow Meow");
    	kucingObject.setMakan("Ikan");
    	sapiObject.setSuara("Mouuu");
    	sapiObject.setMakan("Rumput");
    	
    	System.out.println("");
    	
    	ref = kucingObject;
    	temp = ref.getSuara();
    	temp = ref.getMakan();
    	System.out.println(temp);
    	
    	System.out.println(""); 
    		
    	ref = sapiObject;
    	temp = ref.getSuara();
    	temp = ref.getMakan();
    	System.out.println(temp);
    }
}
    
