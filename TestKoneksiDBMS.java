/**
 * @(#)TestKoneksiDBMS.java
 *
 *
 * @author 
 * @version 1.00 2020/4/28
 */

import java.sql.*;

public class TestKoneksiDBMS {

    public static void main(String args[]) {
    	try
    	{
    		KoneksiDBMS CnPenjualan = new KoneksiDBMS();
    		Connection con = CnPenjualan.BukaCn();
    		
    		if (con != null){
    			System.out.println("Koneksi Berhasil");
    		} else {
    			System.out.println("Koneksi Tidak Berhasil");
    		}
    		con.close();
    	}
    	catch (SQLException e)
    	{
    		System.err.println("Kesalahan perintah SQL : " + e.getMessage());
    	}
    }       
}