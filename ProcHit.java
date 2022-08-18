/**
 * @(#)ProcHit.java
 *
 *
 * @author 
 * @version 1.00 2020/3/19
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcHit {
	static double Hitung = 0;

    public static void main(String[] args)
    {
    	InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(input);
		
		try
		{
			System.out.print("Masukkan Nilai    : ");
			String snilai = buf.readLine();
			int nilai = Integer.parseInt(snilai);
			
			HTambah (nilai);	
		}
		catch (Exception e){}
    }
    static void HTambah(int c)
    {
    	Hitung = c + 2;
   		System.out.println(c + " + 2 = " + Hitung );
    }
    
    
}