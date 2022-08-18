/**
 * @(#)pemasok06075.java
 *
 *
 * @author 
 * @version 1.00 2020/6/29
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class pemasok06075 extends JFrame implements ActionListener,MouseListener {
	private JPanel 		brg 		= new JPanel();
	private JLabel 		lKode 		= new JLabel ("Kode "),
						lNama		= new JLabel ("Nama Pemasok "),
						lAlamat 	= new JLabel ("Alamat "),
						lKota	    = new JLabel ("Kota "),
						lHari	    = new JLabel ("Hari datang    "),
						lTelp	    = new JLabel ("Telpon    "),
						lcreate 	= new JLabel ("nama ");
	private JTextField 	fKode 		= new JTextField(),
						fNama		= new JTextField(),
						fAlamat 	= new JTextField(),
						fKota	    = new JTextField (),						
					    fHari       = new JTextField (),
					    fTelp	    = new JTextField ();
	private JButton 	btnAdd 		= new JButton(),
						btnCari 	= new JButton(),
						btnKoreksi  = new JButton(),
	 					btnHapus    = new JButton(),
						btnSelesai 	= new JButton();
						
	private ResultSet rs;
	String[] header = {"Kode","Nama Pemasok","Alamat","Hari Datang","Telpon"};
	
	DefaultTableModel tabMode1;
	JTable tabel = new JTable();
	JScrollPane skrTabel = new JScrollPane();

    public pemasok06075() {
    	setPreferredSize(new Dimension(500,500));
		setTitle("Data Pemasok_A12.2018.06075 Yuliette Rindani");	
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
		
		JDesktopPane brg = new JDesktopPane();
		
		/* Mengatur letak objek Label Di container*/
		lKode.setBounds (15, 20, 100, 25);
	    lNama.setBounds (15, 55, 100, 25);
		lAlamat.setBounds (15, 90, 100, 25);
		lKota.setBounds (15, 125, 100, 25);
		lHari.setBounds (15, 170, 100, 25);
		lTelp.setBounds (250, 125, 100, 25);
		lcreate.setBounds (250, 460, 200, 25);
		lcreate.setText("Yuliette Rindani_A12.2018.06075");
		
		/* Mengatur letak objek Text Di Container */
		fKode.setBounds (115, 20, 100, 25);
		fNama.setBounds (115, 55, 205, 25);
		fAlamat.setBounds (115, 90, 92, 25);
		fKota.setBounds (115, 125, 100, 25);
		fHari.setBounds (115, 170, 200, 25);
		fTelp.setBounds (315, 125, 100, 25);
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
		brg.add (lNama);	
		brg.add (fNama);
		brg.add (lAlamat);		
		brg.add (fAlamat);
		brg.add (lKota);
		brg.add (fKota);
		brg.add (lHari);
		brg.add (fHari);
		brg.add (lTelp);
		brg.add (fTelp);
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
		new pemasok06075().setVisible(true);
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
			 		fNama.requestFocus();
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
	   		
	   		String strsqlcr = "SELECT * FROM pemasok06075 WHERE kode ='" + fKode.getText () + "'";
	   		ResultSet rs = stat.executeQuery(strsqlcr);

			if(rs.next())	
			{
				JOptionPane.showMessageDialog(this, "Kode Sudah Ada !");
				return;
			}

	   		String strsql = "insert into pemasok06075(kode, nama_pemasok, alamat, kota, hari_datang, telp) values " +
	   				" ('"+fKode.getText() + "','"+fNama.getText()+"','"+fAlamat.getText()+"','"+fKota.getText()+"','"+fHari.getText()+"','"+fTelp.getText()+"')";
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
	   		
	   		String strsql = "SELECT * FROM pemasok06075 WHERE kode ='" + fKode.getText () + "'";
	   		ResultSet rs = stat.executeQuery(strsql);

			if(rs.next())	
			{
				// Jika Nip Ditemukan Di Tabel Pegawai
				fKode.setText (rs.getString ("kode"));
				fNama.setText (rs.getString ("nama_pemasok"));
				fAlamat.setText (rs.getString ("alamat"));
				fKota.setText (rs.getString ("kota"));
				fHari.setText (rs.getString ("hari_datang"));
				fTelp.setText (rs.getString ("telp"));
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
			fNama.setText(vnama);
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
	   		
	   		String strsql = "update pemasok06075 set nama_pemasok='"+fNama.getText()+
	   		 	   "',alamat='"+ fAlamat.getText()+
	   		 	   "',kota='"+ fKota.getText()+
	   		 	   "',hari_datang='"+ fHari.getText()+
	   		 	   	"',telp='"+ fTelp.getText()+
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
	   		
	   		String strsql = "delete from pemasok06075 where kode='"+fKode.getText()+"' ";
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
	   		String strsql = "select * from pemasok06075";
	   		rs = stat.executeQuery(strsql);
            ResultSetMetaData meta = rs.getMetaData();

            rs.beforeFirst();
            while(rs.next()) {
                String Kode = rs.getString("kode");
                String Nama = rs.getString("nama_pemasok");
                String Alamat = rs.getString("alamat");
                String Kota = rs.getString("kota");
                String Hari = rs.getString("hari_datang");
                String Telp = rs.getString("telp");
                String[] data = {Kode, Nama, Alamat, Kota, Hari, Telp};
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
		 fNama.setText ("");
		 fAlamat.setText ("");
		 fKota.setText ("");
		 fHari.setText ("");
		 fTelp.setText ("");
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