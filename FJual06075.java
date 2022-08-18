/**
 * @(#)FJual06075.java
 *
 *
 * @author 
 * @version 1.00 2020/6/2
 */

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class FJual06075 extends JFrame implements ActionListener, FocusListener 
{
	private JPanel 		brg       = new JPanel();
	private JLabel 		lNoJual	   = new JLabel ("No. Transaksi "),
						lKode	   = new JLabel ("Kode "),
						lNamabrg   = new JLabel ("Nama"), 
						lHrgjual   = new JLabel ("Harga  "), 
						lJumlah    = new JLabel ("Jumlah "),
						lBayar     = new JLabel ("Bayar  "),
						lKembali   = new JLabel ("Kembali  "),
						lTotal     = new JLabel ("Total  "),
						lToko      = new JLabel ("A12.2018.06075\n Yuliette Rindani");

	private JTextField 	fNoJual	   = new JTextField (), 
						fKode	   = new JTextField (), 
						fNamabrg   = new JTextField (), 
						fHrgjual   = new JTextField (),
						fJumlah    = new JTextField (),
						fTotal     = new JTextField (),
						fBayar     = new JTextField (),
						fKembali   = new JTextField ();
	private JButton 	btnJual    = new JButton (), 
						btnDelete  = new JButton (), 
						btnCari    = new JButton (),
						btnSelesai = new JButton ();	
						
	private ResultSet rs;
	String[] header = {"Kode","Nama","Harga", "Jumlah", "Total"};
	
	DefaultTableModel tabMode1;
	JTable tabel = new JTable();
	JScrollPane skrTabel = new JScrollPane();
	float total = 0,bayar = 0, kembali = 0;
	int xjumlah = 0;


    public FJual06075() {
    	setPreferredSize(new Dimension(580,600));
		setTitle("Transaksi Penjualan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		new BorderLayout();
		JDesktopPane brg = new JDesktopPane();
		add(brg, BorderLayout.CENTER);
		
		/* Mengatur letak objek Label Di container*/
		lToko.setBounds (15, 35, 400, 40);
		lNoJual.setBounds (15, 100, 120, 20);
		lKode.setBounds (15, 400, 60, 20);
		lHrgjual.setBounds (15, 425, 60, 20);
		lJumlah.setBounds (15, 450, 60, 20);
		lBayar.setBounds (350, 425, 60, 20);
		lKembali.setBounds (350, 450, 60, 20);
		
        
		/* Mengatur letak objek Text Di Container */
		fNoJual.setBounds (15, 125, 100, 20);
		fKode.setBounds (75, 400, 100, 20);
		fNamabrg.setBounds (180, 400, 205, 20);
		fTotal.setBounds (400, 400, 150, 20);
		fHrgjual.setBounds (75, 425, 92, 20);
		fBayar.setBounds (400, 425, 150, 20);
		fKembali.setBounds (400, 450, 150, 20);
		fJumlah.setBounds (75, 450, 100, 20);
		
		/* Mengatur letak objek Button di Container */
		btnJual.setBounds (165, 500, 85, 25);	
		btnJual.setLabel("Jual");	
		btnDelete.setBounds (265, 500, 85, 25);
		btnDelete.setLabel("Delete");
		btnCari.setBounds (365, 500, 85, 25);
		btnCari.setLabel("Cari");
		btnSelesai.setBounds (465, 500, 85, 25);
		btnSelesai.setLabel("Selesai");

		tabMode1 = new DefaultTableModel(null,header);
		tabel.setModel(tabMode1);
		skrTabel.getViewport().add(tabel);
		tabel.setEnabled(true);
		skrTabel.setBounds(15,160,540,220);

		/* Mengatur Perataan teks di Text */ 
		fHrgjual.setHorizontalAlignment (JTextField.RIGHT);
        	fJumlah.setHorizontalAlignment (JTextField.RIGHT);
        	fBayar.setHorizontalAlignment (JTextField.RIGHT);
        	fKembali.setHorizontalAlignment (JTextField.RIGHT);
        	fTotal.setHorizontalAlignment (JTextField.RIGHT);
        
		/* Objek Button di Non Aktifkan dan di aktifkan */
		btnJual.setEnabled(true);		
		btnDelete.setEnabled(false);			
		btnSelesai.setEnabled(true);			

		/* Mengatur objek untuk dapat berinteraksi */
		fKode.addFocusListener (this);
		fJumlah.addFocusListener (this);
		fKembali.addFocusListener (this);
		btnJual.addActionListener (this);
		btnDelete.addActionListener (this);
		btnCari.addActionListener (this);
		btnSelesai.addActionListener (this);
		//tabel.TampungMouseListener(this);		

		
		// Meletakkan seluruh kontrol pada objek panel */
		brg.add (skrTabel);		
		brg.add(lToko);
		brg.add(lNoJual);	
		brg.add(fNoJual);
		brg.add(lKode);	
		brg.add(fKode);		
		brg.add(lNamabrg);	
		brg.add(fNamabrg);
		brg.add(lHrgjual);		
		brg.add(fHrgjual); 
		brg.add(lJumlah);		
		brg.add(fJumlah);
		brg.add(lTotal);		
		brg.add(fTotal);
		brg.add(lBayar);		
		brg.add(fBayar);
		brg.add(lKembali);		
		brg.add(fKembali);
		brg.add(btnJual);		
		brg.add(btnDelete);	
		brg.add(btnCari);
		brg.add(btnSelesai);

		/* Menambahkan objek panel (pBrg) ke container frame */
		getContentPane().add (brg);
		
		/* Menampilkan frame ke layar monitor */
		pack();
		setLocationRelativeTo(null);		

		CariNoJual();
		//tampiltabel();		
		setVisible (true);
    }
    public static void main(String[] args) {
		new FJual06075().setVisible(true);
	}
	
    /* Fungsi untuk memeriksa kursor saat meninggalkan objek txtKode_Barang */
	public void focusGained (FocusEvent fe) 
	{
		if (fBayar.getText().equals (""))
		{
		}
		else
		Bayar();
	}
	public void focusLost (FocusEvent fe) {
	
		if (fKode.getText().equals (""))
		{		
		}
		else 
		{
			Cari();
			fJumlah.requestFocus ();
		}
		
		if ((fJumlah.getText().equals (""))) { }
		else 
		{
			int stat = CekJumlah();
			if (stat == 1)	
			{
				fJumlah.requestFocus();
			}
			
			else
			{
				tampiltabel();
				Kosong();
			}
		}
		
	}

	/* Fungsi jika user melakukan action penekanan tombol Button */
	public void actionPerformed (ActionEvent ae) {
		Object obj = ae.getSource();
		if (obj == btnJual) 	
			{ 
			 	SimpanJual();
			 	bersihtabel();
			 	total = 0;
			 	fTotal.setText("");
			 	Kosong(); 
			 	CariNoJual();			 	
			}				
		if (obj == btnDelete) 	
			{ 
			 //Delete(); 	
			}
		if (obj == btnCari) 	
			{ 
			 	Cari();	
			}			
		if (obj == btnSelesai) 	
			{ 
			 	this.dispose();	
			}						
	}
	    
	// Fungsi untuk mencari Kode_Barang ke tabel barang 
	void CariNoJual(){
		try	{
	   		KoneksiDBMS CnPenjualan = new KoneksiDBMS();
	   		Connection con = CnPenjualan.BukaCn();
	   		Statement stat = con.createStatement();
			
	   		String sql1 = "SELECT * FROM jual";
	   		ResultSet rs1 = stat.executeQuery(sql1);
			if(rs1.next())	
				{

				rs1.last();
				// Jika Kode Barang Ditemukan Di Tabel Barang 
				int xno = Integer.parseInt(rs1.getString ("notransaksi"));
				fNoJual.setText (String.valueOf(xno + 1));

				btnJual.setEnabled(false);
				fKode.requestFocus ();
			
				
			    }
			else 
				{
				// Jika Kode Barang Tidak ketemu di Tabel Barang ..
		   		fNoJual.setText ("20001");
		   		fKode.setText("");					

		   		fKode.requestFocus();				
			}
   			rs1.close();
   			con.close();
		}
		catch(SQLException e) 
		{
		}
	} 
		
	// Fungsi untuk mencari Kode_Barang ke tabel barang 
	void Cari(){
		try	{
	   		KoneksiDBMS CnPenjualan = new KoneksiDBMS();
	   		Connection con = CnPenjualan.BukaCn();
	   		Statement stat = con.createStatement();
			
	   		String sql1 = "SELECT * FROM tb_barang06075 WHERE kode ='" + fKode.getText () + "'";
	   		ResultSet rs1 = stat.executeQuery(sql1);
			if(rs1.next())	
				{
				// Jika Kode Barang Ditemukan Di Tabel Barang 
				fKode.setText (rs1.getString ("kode"));
				fNamabrg.setText (rs1.getString ("nama_barang"));
				fHrgjual.setText (rs1.getString ("harga_jual"));
				xjumlah = Integer.parseInt(rs1.getString ("harga_jual"));
				btnJual.setEnabled(false);
				btnDelete.setEnabled(true);
				fNamabrg.requestFocus ();
				
			    }
			else 
				{
				// Jika Kode Barang Tidak ketemu di Tabel Barang ..
		   		fKode.setText("");					

				JOptionPane.showMessageDialog(this, "Kode salah !!");
		   		fKode.requestFocus();				
			}
   			rs1.close();
   			con.close();
		}
		catch(SQLException e) 
		{
		}
	} 
	
	// Fungsi untuk mencari Kode_Barang ke tabel barang 
	int CekJumlah(){
		int x = 0;
		try	{

			if(xjumlah < Integer.parseInt(fJumlah.getText()))
			{
		   		fJumlah.setText("");
		   		JOptionPane.showMessageDialog(this, "Jumlah Barang : " + xjumlah);
		   		x = 1;	   		
			}
			else
			{
				//tambahkan proses mengurangi stok barang;
				//buat methode untuk mengupdate jumlag stock
				// jumlah = jumlah - jumlah jual
			}
		}
		catch(Exception e) 
		{
		}
		return x;
	} 	

	//Simpan Data...........................
	void SimpanJual()
	{
		try	
		{
	   		KoneksiDBMS CnPenjualan = new KoneksiDBMS();
	   		Connection con = CnPenjualan.BukaCn();
	   		Statement stat = con.createStatement();
			
			int brs = tabMode1.getRowCount();
			for(int i=0;i<brs;i++)
			{
				int vnojual = Integer.parseInt(fNoJual.getText());			
				String vkode   = String.valueOf(tabel.getValueAt(i,0));
				String vharga  = String.valueOf(tabel.getValueAt(i,2));
				String vjumlah = String.valueOf(tabel.getValueAt(i,3));
						
	   			String strsql = "insert into jual(notransaksi, kode, harga, jumlah) " +
	   				" values ('"+ vnojual + "', '"+ vkode + "', '"+ vharga + "', '"+ vjumlah + "')";

   			
	   			int stsproses = stat.executeUpdate(strsql);			
			}

 			con.close();
		}
		catch(SQLException e) 
		{
	   	
		   	JOptionPane.showMessageDialog(this, "Ada Kesalahan !!!");
		}
		

	}
	

	void Bayar()
	{

        try {
            	fBayar.requestFocus();
                kembali = Float.parseFloat(fBayar.getText()) - 
                	      Float.parseFloat(fTotal.getText()); 
                fKembali.setText (String.valueOf(kembali));
           
        } catch (Exception se) {
            System.err.println("Pesan Salah : " + se.getMessage());
        }		
	}
	
	void tampiltabel()
	{

        try {
            
                String Kode = fKode.getText();
                String Nama = fNamabrg.getText();
                String Harga = fHrgjual.getText();
                String Jumlah = fJumlah.getText();
                String Total = String.valueOf(Float.parseFloat(fHrgjual.getText()) *
                					Float.parseFloat(fJumlah.getText()));
                String[] data = {Kode, Nama, Harga, Jumlah, Total};
                tabMode1.addRow(data);
                
                //masukkan ke total........
                total = total + Float.parseFloat(Total);
                fTotal.setText (String.valueOf(total));
           
        } catch (Exception se) {
            System.err.println("Pesan Salah : " + se.getMessage());
        }		
	}
	
	void bersihtabel()
	{
		int brs = tabMode1.getRowCount();
		for(int i=0;i<brs;i++)
		{
			tabMode1.removeRow(0);
		}
	}

	// Fungsi untuk mengkosongkan Objek masukan 
	void Kosong () 
		{
		 fKode.setText ("");
		 fNamabrg.setText ("");
		 fHrgjual.setText ("");
		 fJumlah.setText ("");
		 fBayar.setText ("");
		 fKembali.setText ("");

		 
		 btnJual.setEnabled(true);
		 btnDelete.setEnabled(false);
		 fKode.requestFocus ();
	    }
	    
}