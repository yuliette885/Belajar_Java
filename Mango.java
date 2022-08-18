/**
 * @(#)Mango.java
 *
 *
 * @author 
 * @version 1.00 2020/5/18
 */


class Mango extends Fruit {

    public Mango(Color color, boolean seasional) 
    {
    	super(color, seasional);
    }
    
    @Override
    public void prepare()
    {
    	System.out.println("Cut the Mango");
    }
    
    
}