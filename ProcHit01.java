/**
 * @(#)ProcHit01.java
 *
 *
 * @author 
 * @version 1.00 2020/3/19
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProcHit01 {

    public static void main(String[] args)
    {
    	ProcHit02 a = new ProcHit02();
    	
    	InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(input);
		
		try
		{
			System.out.print("Masukkan Nilai    : ");
			String snilai = buf.readLine();
			int nilai = Integer.parseInt(snilai);
			
			a.HTambah(nilai);
		}
		catch (Exception e){}
    }
    
    
}