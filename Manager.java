/**
 * @(#)Manager.java
 *
 *
 * @author 
 * @version 1.00 2020/4/27
 */


 class Manager extends Karyawan{
 	String bagian;
 	int kehadiran;
 	double gaji;

    public void setBagian(String bagian) {
    	this.bagian=bagian;
    }
    public String getBagian()
    {
    	return bagian;
    }
    
    public void setkehadiran(int kehadiran) {
    	this.kehadiran=kehadiran;
    }
    public int getkehadiran()
    {
    	return kehadiran;
    }
    
    public void setGaji(double xgaji)
    {
    	this.gaji=xgaji;
    }
    
    public double getGaji(){
    	return gaji;
    }
    
    public void lihatInfo()
    {
    	System.out.println("Manager			:"+this.getBagian());
    	System.out.println("---------------------------------------------------");
    	System.out.println("NIK 			:"+this.getNik());
    	System.out.println("Nama 			:"+this.getNama());
    	System.out.println("Jml Kehadiran	:"+this.getkehadiran());
    	System.out.printf("Gaji 			:%.0f\n",this.getGaji());
    	System.out.println("---------------------------------------------------");
    	System.out.println("===================================================");
    	
    }
    
    
}