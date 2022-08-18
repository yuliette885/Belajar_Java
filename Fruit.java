/**
 * @(#)Fruit.java
 *
 *
 * @author 
 * @version 1.00 2020/5/18
 */


abstract class Fruit 
{
	private Color color;
	private boolean seasonal;

    public Fruit(Color color, boolean seasonal) 
    {
    	this.color = color;
    	this.seasonal = seasonal;
    }
    
    public abstract void prepare();
    
    public Color getColor()
    {
    	return color;
    }
    
    public boolean isSeasional()
    {
    	return seasional;
    }
    
    
}