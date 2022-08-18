/**
 * @(#)FTb_Barang06075.java
 *
 *
 * @author 
 * @version 1.00 2020/5/19
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class FTb_Barang06075 extends JFrame implements ActionListener,MouseListener {
	private JPanel 		brg 		= new JPanel();
	private JLabel 		lKode 		= new JLabel ("Kode "),
						lNamabrg	= new JLabel ("Nama Barang "),
						lHrgjual 	= new JLabel ("Harga Jual "),
						lHrgbeli    = new JLabel ("Harga Beli "),
						lJumlah     = new JLabel ("Jumlah    "),
						lcreate 	= new JLabel ("nama ");
	private JTextField 	fKode 		= new JTextField(),
						fNamabrg	= new JTextField(),
						fHrgjual 	= new JTextField(),
						fHrgbeli    = new JTextField (),						
					    fJumlah     = new JTextField ();
	private JButton 	btnAdd 		= new JButton(),
						btnCari 	= new JButton(),
						btnKoreksi  = new JButton(),
	 					btnHapus    = new JButton(),
						btnSelesai 	= new JButton();
						
	private ResultSet rs;
	String[] header = {"Kode","Nama Barang","Harga Jual","Harga Beli","Jumlah"};
	
	DefaultTableModel tabMode1;
	JTable tabel = new JTable();
	JScrollPane skrTabel = new JScrollPane();

    public FTb_Barang06075() {
    	setPreferredSize(new Dimension(500,500));
		setTitle("Data Barang");	
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
		
		JDesktopPane brg = new JDesktopPane();
		
		/* Mengatur letak objek Label Di container*/
		lKode.setBounds (15, 20, 100, 25);
	    lNamabrg.setBounds (15, 55, 100, 25);
		lHrgjual.setBounds (15, 90, 100, 25);
		lHrgbeli.setBounds (15, 125, 100, 25);
		lJumlah.setBounds (15, 170, 100, 25);
		lcreate.setBounds (250, 460, 200, 25);
		lcreate.setText("Yuliette Rindani_A12.2018.06075");
		
		/* Mengatur letak objek Text Di Container */
		fKode.setBounds (115, 20, 100, 25);
		fNamabrg.setBounds (115, 55, 205, 25);
		fHrgjual.setBounds (115, 90, 92, 25);
		fHrgbeli.setBounds (115, 125, 100, 25);
		fJumlah.setBounds (115, 170, 200, 25);
		fKode.setToolTipText("Mohon isi dengan benar !");
		
		/* Mengatur letak objek Button di Container */
		btnAdd.setBounds (20, 395, 85, 25);	
		btnAdd.setLabel("Add");	
		btnAdd.setBackground(Color.green);
		btnAdd.setForeground(Color.getHSBColor(250,0,255));
		btnCari.setBounds (120, 395, 85, 25);
		btnCari.setLabel("Cari");
		btnKoreksi.setBounds (220, 395, 85, 25);
		btnKoreksi.setLabel("Koreksi");
		btnHapus.setBounds (220, 425, 85, 25);
		btnHapus.setLabel("Hapus");				
		btnSelesai.setBounds (320, 395, 85, 60);
		btnSelesai.setLabel("Selesai");
		btnSelesai.setToolTipText("Mengakhiri Program");
		
		tabMode1 = new DefaultTableModel(null,header);
		tabel.setModel(tabMode1);
		tabel.setBackground(Color.orange);
		skrTabel.getViewport().add(tabel);
		tabel.setEnabled(true);
		skrTabel.setBounds(20,215,450,150);
		
		tabel.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		tabel.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabel.getColumnModel().getColumn(1).setPreferredWidth(350);
		tabel.getColumnModel().getColumn(1).setPreferredWidth(200);
		
			/* Objek Button di Non Aktifkan dan di aktifkan */
		btnAdd.setEnabled(true);
		btnKoreksi.setEnabled(true);
		btnCari.setEnabled(true);
		btnHapus.setEnabled(true);		
		btnSelesai.setEnabled(true);
		
		// Mengatur objek untuk dapat berinteraksi
		btnAdd.addActionListener (this);
		btnCari.addActionListener (this);
		btnKoreksi.addActionListener (this);
		btnHapus.addActionListener (this);
		btnSelesai.addActionListener (this);
		tabel.addMouseListener (this);
		
		// Meletakkan seluruh kontrol pada objek panel */
		brg.add (skrTabel);
		brg.add (lKode);	
		brg.add (fKode);
		brg.add (lNamabrg);	
		brg.add (fNamabrg);
		brg.add (lHrgjual);		
		brg.add (fHrgjual);
		brg.add (lHrgbeli);
		brg.add (fHrgbeli);
		brg.add (lJumlah);
		brg.add (fJumlah);
		brg.add (lcreate); 
		brg.add (btnAdd);		
		brg.add (btnCari);	
		brg.add (btnKoreksi);	
		brg.add (btnHapus);					
		brg.add (btnSelesai);
		
		/* Menambahkan objek panel (brg) ke container frame */
		getContentPane().add (brg).setBackground(Color.getHSBColor(100,150,75));
		
		/* Menampilkan frame ke layar monitor */
		pack();
		setLocationRelativeTo(null);		
		tampiltabel();		
		Kosong();
		settombol(1, 1, 0, 0, 1);	
    }
    
    public static void main(String[] args) {
		new FTb_Barang06075().setVisible(true);
	}
	
	/* Fungsi jika user melakukan action penekanan tombol Button */
	public void actionPerformed (ActionEvent ae) {
		Object obj = ae.getSource();
		
		if (obj == btnAdd) 	
			{ 
			 	if (btnAdd.getText()=="Simpan")
			 	{
			 		String xkode = fKode.getText();
			 		if (xkode.length() != 0) Add();
			 		else
			 			JOptionPane.showMessageDialog(this, "Kode kosong !");
			 		
			 		btnAdd.setText("Add");
			 		Kosong();
			 		tampiltabel();	
			 		settombol(1, 1, 0, 0, 1);
			 	}
			 	else
			 	{
			 		Kosong();
			 		settombol(1, 0, 0, 0, 1);			 		
			 		btnAdd.setText("Simpan");
			 		btnAdd.setForeground(Color.getHSBColor(100,10,0));
			 		btnAdd.setBackground(Color.getHSBColor(200,100,100));
			 	}
			 		
			}
			
			if (obj == btnCari) 	
			{ 
				String xcari = JOptionPane.showInputDialog(this,"Masukkan Kode !");
			 	if (xcari != null)
			 	{
			 		fKode.setText(xcari);
			 		int xx = Cari();
			 		if (xx == 1) settombol(1, 1, 1, 1, 1);
			 	}
			 	else
			 		JOptionPane.showMessageDialog(this, "Kode kosong !");
				
			}
		if (obj == btnKoreksi) 	
			{ 
			 	if (btnKoreksi.getText()=="Simpan")
			 	{
			 		if (fKode.getText() != "")
			 			Koreksi();
			 		btnKoreksi.setText("Koreksi");
			 		Kosong();
			 		settombol(1, 1, 0, 0, 1); 
			 	}
			 	else
			 	{
			 		btnKoreksi.setText("Simpan");
			 		settombol(0, 0, 1, 0, 1);
			 		fNamabrg.requestFocus();
			 	}
			}
			
			if (obj == btnHapus) 	
			{ 
			 	int stt = JOptionPane.showConfirmDialog(this,"Yakin dihapus ?");
			 	System.out.print(stt);
			 	
			 	if (stt == 0)
			 	{
			 		Hapus();
			 		Kosong();
			 	}

			}

		if (obj == btnSelesai) 	
			{ 
			 	//System.exit(0);
			 	this.dispose();
			}			
	}
	
	// Fungsi untuk menambahkan data ke tabel
	void Add()
	{
		try	
		{
	   		KoneksiDBMS CnPenjualan = new KoneksiDBMS();
	   		Connection con = CnPenjualan.BukaCn();
	   		Statement stat = con.createStatement();
	   		
	   		String strsqlcr = "SELECT * FROM tb_barang06075 WHERE kode ='" + fKode.getText () + "'";
	   		ResultSet rs = stat.executeQuery(strsqlcr);

			if(rs.next())	
			{
				JOptionPane.showMessageDialog(this, "Kode Sudah Ada !");
				return;
			}

	   		String strsql = "insert into tb_barang06075(kode, nama_barang, harga_jual, harga_beli, jumlah) values " +
	   				" ('"+fKode.getText() + "','"+fNamabrg.getText()+"','"+fHrgjual.getText()+"','"+fHrgbeli.getText()+"','"+fJumlah.getText()+"')";
	   		int stsproses = stat.executeUpdate(strsql);

      	          	   		
 			if (stsproses == 1)
  	    		JOptionPane.showMessageDialog(this, "Sukses Di Tambahkan!!!");
 			con.close();
		}
		catch(SQLException e) 
		{
		   	JOptionPane.showMessageDialog(this, "Penambahan Gagal!!!");
            System.err.println("Kesalahan perintah SQL : " + e.getMessage());		   	
		}
	}
	
	// Fungsi untuk mencari Kode_Barang ke tabel barang 
	int Cari(){
		int x = 0;
		try	{
			KoneksiDBMS CnPenjualan = new KoneksiDBMS();
	   		Connection con = CnPenjualan.BukaCn();
	  		Statement stat = con.createStatement();
	   		
	   		String strsql = "SELECT * FROM tb_barang06075 WHERE kode ='" + fKode.getText () + "'";
	   		ResultSet rs = stat.executeQuery(strsql);

			if(rs.next())	
			{
				// Jika Nip Ditemukan Di Tabel Pegawai
				fKode.setText (rs.getString ("kode"));
				fNamabrg.setText (rs.getString ("nama_barang"));
				fHrgjual.setText (rs.getString ("harga_jual"));
				fHrgbeli.setText (rs.getString ("harga_beli"));
				fJumlah.setText (rs.getString ("jumlah"));
				x = 1;
			   }
			else 
			{
				// Jika Nip tidak ditemukan 
				JOptionPane.showMessageDialog(this, "Data tidak ditemukan !");
				fKode.requestFocus ();
			}
   			rs.close();
   			con.close();
		}
		catch(SQLException e) 
		{
		}
		return x;
	}
	
	public void mouseClicked(MouseEvent me) 
	{ 
		try 
		{ 
			String vkode = String.valueOf(tabel.getValueAt
						(tabel.getSelectedRow(),0));
			String vnama = String.valueOf(tabel.getValueAt
						(tabel.getSelectedRow(),1));
			fKode.setText(vkode);
			fNamabrg.setText(vnama);
		}
		catch (Exception e)
		{
			JOptionPane.showMessageDialog(this, "Ada Kesalahan !!!");
		}
	}

	public void mouseExited(MouseEvent me){}
	public void mouseEntered(MouseEvent me){}
	public void mousePressed(MouseEvent me){}
	public void mouseReleased(MouseEvent me){}

		
		// Fungsi untuk menambahkan data ke tabel barang
	void Koreksi()
	{
		try	
		{
	   		KoneksiDBMS CnPenjualan = new KoneksiDBMS();
	   		Connection con = CnPenjualan.BukaCn();
	   		Statement stat = con.createStatement();
	   		
	   		String strsql = "update tb_barang06075 set nama_barang='"+fNamabrg.getText()+
	   		 	   "',harga_jual='"+ fHrgjual.getText()+
	   		 	   "',harga_beli='"+ fHrgbeli.getText()+
	   		 	   "',jumlah='"+ fJumlah.getText()+
	   		 	   "' where kode='"+fKode.getText()+"' ";
	   		int stsproses = stat.executeUpdate(strsql);

      	          	   		
 			if (stsproses == 1)
  	    		JOptionPane.showMessageDialog(this, "Sukses DiEdit!");
 			con.close();
		}
		catch(SQLException e) 
		{
		   	JOptionPane.showMessageDialog(this, "Koreksi Gagal !");
            System.err.println("Kesalahan perintah SQL : " + e.getMessage());		   	
		}
	}
	
	// Fungsi untuk menambahkan data ke tabel barang
	void Hapus()
	{
		try	
		{
	   		KoneksiDBMS CnPenjualan = new KoneksiDBMS();
	   		Connection con = CnPenjualan.BukaCn();
	   		Statement stat = con.createStatement();
	   		
	   		String strsql = "delete from tb_barang06075 where kode='"+fKode.getText()+"' ";
	   		int stsproses = stat.executeUpdate(strsql);
      	          	   		
 			if (stsproses == 1)
  	    		JOptionPane.showMessageDialog(this, "Data Terhapus !");
 			con.close();
		}
		catch(SQLException e) 
		{
		   	JOptionPane.showMessageDialog(this, "Penghapusan Gagal!!!");
            System.err.println("Kesalahan perintah SQL : " + e.getMessage());		   	
		}
	}		
			
	//tambah
	void tampiltabel()
	{
        try {
            bersihtabel();
	   		KoneksiDBMS CnPenjualan = new KoneksiDBMS();
	   		Connection con = CnPenjualan.BukaCn();
	   		Statement stat = con.createStatement(); 
	   		String strsql = "select * from tb_barang06075";
	   		rs = stat.executeQuery(strsql);
            ResultSetMetaData meta = rs.getMetaData();

            rs.beforeFirst();
            while(rs.next()) {
                String Kode = rs.getString("kode");
                String Namabrg = rs.getString("nama_barang");
                String Hrgjual = rs.getString("harga_jual");
                String Hrgbeli = rs.getString("harga_beli");
                String Jumlah = rs.getString("jumlah");
                String[] data = {Kode, Namabrg, Hrgjual, Hrgbeli, Jumlah};
                tabMode1.addRow(data);
            }
            stat.close();
            rs.close();
            con.close();
            
        } catch (SQLException se) {
            System.err.println("Kesalahan perintah SQL : " + se.getMessage());
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
		 fHrgbeli.setText ("");
		 fJumlah.setText ("");
		 fKode.requestFocus ();
	    }	
    
    void settombol(int a, int b, int c, int d, int e)
	{
		btnAdd.setEnabled(a>=1 ? true: false);
		btnCari.setEnabled(b>=1 ? true: false);
		btnKoreksi.setEnabled(c>=1 ? true: false);
		btnHapus.setEnabled(d>=1 ? true: false);
		btnSelesai.setEnabled(e>=1 ? true: false);
	}
}