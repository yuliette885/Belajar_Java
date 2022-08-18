/**
 * @(#)ProceHitung.java
 *
 *
 * @author 
 * @version 1.00 2020/3/19
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ProceHitung {

     public static void main(String[] args)
     {
     	InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader buf = new BufferedReader(input);
			
		try
		{
			System.out.println("Yuliette Rindani");
			System.out.println("A12.2018.06075\n");
						
			System.out.print("Masukkan Nilai    : ");
			String snilai = buf.readLine();
			int nilai = Integer.parseInt(snilai);
			
			System.out.println("");
			System.out.println("Menu");
			System.out.println("=====================");
			System.out.println("1. Tambah 2");
			System.out.println("2. Kurang 2");
			System.out.println("3. Kali 2");
			System.out.println("=====================");
			
			System.out.print("Pilihan Anda : ");
			String spilih = buf.readLine();
			int pilih = Integer.parseInt(spilih);	
			
			System.out.println("");
			HitungPilih(pilih, nilai);
		}
		catch(Exception e){}
     }
    
    static void HitungPilih(int a, int b)
    {
    	ProceHtambah tambah = new ProceHtambah();
		ProceHkurang kurang = new ProceHkurang();
		ProceHkali kali = new ProceHkali();
		
    	switch (a)
    	{
    		case 1 : tambah.HTambah(b);
					 break;
			case 2 : kurang.HKurang(b);
					 break;
			case 3 : kali.HKali(b);
					 break;
    	}
    }
    
}