/**
 * @(#)CetakPegawai06091.java
 *
 *
 * @author 
 * @version 1.00 2020/6/26
 */

import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;

import javax.swing.JPanel;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class CetakPegawai06075 extends JFrame implements ActionListener 
{
	private JPanel 		pPgw       = new JPanel();

	private JTextField 	fNip	   = new JTextField ();

	private JButton 	btnAdd     = new JButton (),
						btnSelesai  = new JButton ();
						
	private ResultSet rs;
	String[] header = {"Nip","Nama","Jenis Kelamin","Bagian"};
	
	DefaultTableModel tabMode1;
	JTable tabel = new JTable();
	JScrollPane skrTabel = new JScrollPane();

    public CetakPegawai06075() 
    {
    	setPreferredSize(new Dimension(300,250));
		setTitle("Cetak Laporan Pegawai");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		new BorderLayout();
		JDesktopPane pPgw = new JDesktopPane();
		add(pPgw, BorderLayout.CENTER);
		
     
		/* Mengatur letak objek Text Di Container */
		fNip.setBounds (115, 20, 130, 25);

		/* Mengatur letak objek Button di Container */
		btnAdd.setBounds (60, 70, 85, 60);	
		btnAdd.setLabel("Cetak");	
		btnAdd.setBackground(Color.BLUE);
		btnAdd.setForeground(Color.getHSBColor(250,0,255));
		btnSelesai.setBounds (140, 70, 85, 60);
		btnSelesai.setLabel("Selesai");
		btnSelesai.setToolTipText("Mengakhiri Program");
     
		/* Objek Button di Non Aktifkan dan di aktifkan */
		btnAdd.setEnabled(true);		
		btnSelesai.setEnabled(true);			

		// Mengatur objek untuk dapat berinteraksi
		btnAdd.addActionListener (this);
		btnSelesai.addActionListener (this);
       
		
		// Meletakkan seluruh kontrol pada objek panel */	
		pPgw.add (btnAdd);		
		pPgw.add (btnSelesai);

		/* Menambahkan objek panel (pBrg) ke container frame */
		//getContentPane().add (pBrg);
		
		/* Menampilkan frame ke layar monitor */
		pack();
		setLocationRelativeTo(null);		
		setVisible (true);
    }
    
    public static void main(String[] args) 
    {
		new CetakPegawai06075().setVisible(true);
	}
	
	/* Fungsi jika user melakukan action penekanan tombol Button */
	public void actionPerformed (ActionEvent ae) 
	{
		Object obj = ae.getSource();
		
		if (obj == btnAdd) 	
			{ 
			 	CetakOK();	
			}	
						

		if (obj == btnSelesai) 	
			{ 
			 	//System.exit(0);	
			 	this.dispose();
			}			
	}
	
	// Fungsi untuk menambahkan data ke tabel barang
	void CetakOK()
	{
    try {
      PrinterJob pjob = PrinterJob.getPrinterJob();
      pjob.setJobName("Graphics Demo Printout");
      pjob.setCopies(1);
      pjob.setPrintable(new Printable() 
      {
        public int print(Graphics g1, PageFormat pf, int pageNum) {
          if (pageNum > 0) // we only print one page
            return Printable.NO_SUCH_PAGE; // ie., end of job

          g1.drawString("create by YULIETTE RINDANI - A12.2018.06075", 10, 10);
          //cetak data....................................
		try
		{
			
			//Koneksi ke table barang..................
	   		KoneksiDBMS CnPenjualan = new KoneksiDBMS();
	   		Connection con = CnPenjualan.BukaCn();
	   		Statement stat = con.createStatement();
	   		String strsql = "SELECT * FROM pegawai06075";
	   		
	   		ResultSet rs = stat.executeQuery(strsql);

	   		int i1, x1, y1;
	   		
	   		//Header
	   		g1.drawString("Laporan Pegawai", 50, 98);
	   		g1.drawString("A12.2018.06075 - YULIETTE RINDANI", 50, 122);
	   		g1.drawLine(50, 138, 800, 138);
	   		g1.drawString("No.", 50 ,155);
	   		g1.drawString("NIP", 80 ,155);
	   		g1.drawString("Nama", 140, 155);
	   		g1.drawString("Jenis Kelamin", 180, 155);
	   		g1.drawString("Bagian", 270, 155);
	   		g1.drawLine(50, 163, 600, 163);
	   		x1 = 50;
	   		y1 = 190;
	   		i1 = 1;

	   		//Cetak Record Barang.................
	   		while(rs.next())
	   		{
	   			g1.drawString(" " + i1 + ".", 50, y1);
	   			g1.drawString(rs.getString(1),80,y1);
	   			g1.drawString(rs.getString(2),140,y1);
	   			g1.drawString(rs.getString(3),180,y1);
	   			g1.drawString(rs.getString(4),270,y1);
	   			g1.drawString(rs.getString(5),350,y1);
	   			g1.drawString(rs.getString(6),400,y1);
	   			g1.drawString(rs.getString(7),450,y1);
	   			y1 += 14;
	   			i1++;
	   			
	   		}
	   		
	   		g1.drawLine(x1, y1, 800, y1);
	   		
	   		rs.close();
	   		con.close();

		}
		catch(Exception e)
		{
			System.out.println("Ada Kesalahan !");
		}

          return Printable.PAGE_EXISTS;
        }
      });

      if (pjob.printDialog() == false) // choose printer
        return; 
      pjob.print(); 
    } catch (PrinterException pe) {
      pe.printStackTrace();
    }
	}
	
}