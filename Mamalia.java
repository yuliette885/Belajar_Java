/**
 * @(#)Mamalia.java
 *
 *
 * @author 
 * @version 1.00 2020/5/13
 */


public class Mamalia {
	protected String suara;
	protected String makan;

    public Mamalia() 
    {
    	System.out.println("Inside Mamalia:Constructor");
    	suara = "";
    	makan = "";
    }
    
    public Mamalia(String suara, String makan)
    {
    	this.suara = suara;
    	this.makan = makan;
    }
    
    public String getSuara()
    {
    	return suara;
    }
    
    public String getMakan()
    {
    	return makan;
    }
    
    public void setSuara (String suara)
    {
    	this.suara = suara;
    }
    
    public void setMakan (String makan)
    {
    	this.makan = makan;
    }
    
    
}