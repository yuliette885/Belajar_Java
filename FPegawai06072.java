/**
 * @(#)FPegawai06072.java
 *
 *
 * @author 
 * @version 1.00 2020/5/8
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;

public class FPegawai06072 extends JFrame implements ActionListener 
{
	private JPanel		pPgw	= new JPanel ();
	private JLabel		lNip	= new JLabel ("N  I P	"),
						lNama	= new JLabel ("Nama		"),
						lBagian	= new JLabel ("Bagian	"),
						lcreate = new JLabel ("nama");
	private JTextField	fNip	= new JTextField (),
						fNama	= new JTextField (),
						fBagian	= new JTextField ();
	private JButton		btnAdd	= new JButton (),
						btnCari	= new JButton (),
						btnSelesai	= new JButton ();
	
	public FPegawai06072(){
		setPreferredSize(new Dimension (450,280));
		setTitle("Data Pegawai");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JDesktopPane pPgw = new JDesktopPane();
		
		/*Mengatur letak objek Label di container*/
		lNip.setBounds (15,20,100,25);
		lNama.setBounds (15,55,100,25);
		lBagian.setBounds (15,90,100,25);
		lcreate.setBounds (250,210,200,25);
		lcreate.setText ("Shofi MH A12.2018.06072");
		
				
		/*mengatur letak obyek text di container*/
		fNip.setBounds (115, 20, 100, 25);
		fNama.setBounds (115, 55, 205, 25);
		fBagian.setBounds (115, 90, 92, 25);
		fNip.setToolTipText("Isi Nip dengan Angka !");
		
		/*Mengatur letak objek Button di Container*/
		btnAdd.setBounds (150, 150, 85, 25);
		btnAdd.setLabel ("Add");
		btnAdd.setBackground (Color.red);
		btnAdd.setForeground (Color.getHSBColor (250,0,255));
		btnCari.setBounds (50, 150, 85, 25);
		btnCari.setLabel ("Cari");
		btnSelesai.setBounds (250, 150, 85, 25);
		btnSelesai.setLabel ("Selesai");
		btnSelesai.setToolTipText ("Mengakhiri Program");
		
		/*objek Button di Non Aktifkan dan di aktifkan*/
		btnAdd.setEnabled(true);
		btnSelesai.setEnabled(true);
		
		// mengatur objek untuk dapat berinteraksi
		btnAdd.addActionListener (this);
		btnCari.addActionListener (this);
		btnSelesai.addActionListener (this);
		
		//Meletakkan seluruh kontrol pada objek panel*/
		pPgw.add (lNip);
		pPgw.add (fNip);
		pPgw.add (lNama);
		pPgw.add (fNama);
		pPgw.add (lBagian);
		pPgw.add (fBagian);
		pPgw.add (lcreate);
		pPgw.add (btnCari);
		pPgw.add (btnAdd);
		pPgw.add (btnSelesai);
		
		/*menentukan objek oanel (pPgw) ke container frame */
		getContentPane().add (pPgw).setBackground(Color.getHSBColor(250,0,255));
		
		/* menampilkan frame ke layar monitor */
		pack();
	}
	
	public static void main (String[] args) {
		new FPegawai06072().setVisible(true);
	}
	
	/*Fungsi jika user melakukan action penekanan tombol Button */
	public void actionPerformed (ActionEvent ae) {
		Object obj = ae.getSource();
		
		if (obj == btnAdd)
		{
			if (btnAdd.getText()=="Simpan")
			{
				Add();
				btnAdd.setText("Add");
			}
			else
			{
				Kosong ();
				btnAdd.setText("Simpan");
				btnAdd.setForeground(Color.getHSBColor(100,10,0));
				btnAdd.setBackground(Color.getHSBColor(200,100,100));
			}
		}
		if (obj == btnSelesai)
		{
			System.exit(0);
		}
	}
	
	//Fungsi untuk menambah data ke tabel
	void Add()
	{
		try
		{
			KoneksiDBMS CnPenjualan = new KoneksiDBMS();
			Connection con = CnPenjualan.BukaCn();
			Statement stat = con.createStatement();
			
			String strsql = "insert into pegawai06072 (nip, nama) values " +
					" ('"+fNip.getText()+ "','" + fNama.getText()+"')";
			int stsproses = stat.executeUpdate(strsql);
			
			if (stsproses == 1)
				JOptionPane.showMessageDialog(this, "Sukses Di Tambahkan!!");
			con.close();
		}
		catch (SQLException e)
		{
			JOptionPane.showMessageDialog(this, "Penambahan Gagal!!!");
			System.err.println("Kesalahan perintah SQL : " + e.getMessage());
		}
	}
	
	//Fungsi untuk mengkosongkan objek masukan
	void Kosong ()
	{
		fNip.setText ("");
		fNama.setText ("");
		fBagian.setText ("");
		btnAdd.setEnabled(true);
		btnSelesai.setEnabled(true);
		fNip.requestFocus ();
	}
	}	
	
	

    
    