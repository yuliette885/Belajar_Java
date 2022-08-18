/**
 * @(#)KoneksiDBMS.java
 *
 *
 * @author 
 * @version 1.00 2020/4/28
 */

import java.sql.*;

public class KoneksiDBMS {
	String driverdbms = "com.mysql.jdbc.Driver";
	String database = "jdbc:mysql://localhost/dbyuliette6075";
	String user = "yuliette6075";
	String password = "";

    public KoneksiDBMS() {
    }
    
    public Connection BukaCn() throws SQLException
    {
    	Connection condbms = null;
    	try
    	{
    		Class.forName(driverdbms);
    		condbms = DriverManager.getConnection(database,user,password);
    		
    		return condbms;
    	}
    	catch (SQLException se)
    	{
    		System.out.println("Ada kesalahan pada SQL !");
    		return null;		
    	}
    	catch (Exception ex)
    	{
    		System.out.println("Koneksi database tidak berhasil !");
    		return null;		
    	}
    }
    
    
}