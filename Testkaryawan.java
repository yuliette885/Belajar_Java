/**
 * @(#)Testkaryawan.java
 *
 *
 * @author 
 * @version 1.00 2020/4/27
 */


public class Testkaryawan {

    public static void main(String[] args) {
    	Manager Budi01 = new Manager();
    	Budi01.setNama("Wahyu Aji");
    	Budi01.setNik("2020049191");
    	Budi01.setBagian("Pemasaran");
    	Budi01.setkehadiran(25);
    	Budi01.setGaji(25000000);
    	
    	Budi01.lihatInfo();
    	
    	Manager Wati02 = new Manager();
    	Wati02.setNama("Wati Ayu");
    	Wati02.setGaji(22000000);
    	
    	System.out.println("Nama :"+Wati02.getNama());
    	System.out.printf("Gaji :%.0f\n",Wati02.getGaji());
    	
    }
    
    
}