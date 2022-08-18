/**
 * @(#)FPegawai.java
 *
 *
 * @author
 * @version 1.00 2020/3/24
 */

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.sql.*;

public class FPegawai06002 extends JFrame implements ActionListener
 {

	private JPanel 	pPgw       = new JPanel();
	private JLabel 	lNip	   = new JLabel ("N I P       "),
				lNama	   		= new JLabel ("Nama        "),
				lBagian    		= new JLabel ("Bagian      "),
				lKota    		= new JLabel ("Kota      "),
				lNoHP    		= new JLabel ("NoHP      "),
				lcreate    		= new JLabel ("nama");
	private JTextField 	fNip	   = new JTextField (),
				fNama	   = new JTextField (),
				fBagian    = new JTextField (),
				fKota      = new JTextField (),
				fNoHP      = new JTextField ();
	private JButton 	btnAdd     = new JButton (),
	 			btnCari     		= new JButton (),

				btnSelesai  		= new JButton ();


    public FPegawai06002() {
    	setPreferredSize(new Dimension(450,280));
		setTitle("Data Pegawai");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JDesktopPane pPgw = new JDesktopPane();

		/* Mengatur letak objek Label Di container*/
		lNip.setBounds 		(15, 20, 100, 25);
	    lNama.setBounds 	(15, 55, 100, 25);
		lBagian.setBounds 	(15, 90, 100, 25);
		lKota.setBounds 	(15, 120, 100, 25);
		lNoHP.setBounds 	(15, 155, 100, 25);
		lcreate.setBounds (250, 230, 250, 30);
		lcreate.setText("create by Novela Manjani A12.2018.06002");

		/* Mengatur letak objek Text Di Container */
		fNip.setBounds 		(115, 20, 100, 25);
		fNama.setBounds 	(115, 55, 205, 25);
		fBagian.setBounds 	(115, 90, 150, 25);
		fKota.setBounds 	(115, 120, 150, 25);
		fNoHP.setBounds 	(115, 155, 150, 25);
		fNip.setToolTipText("Isi Nip dengan Angka !");

		/* Mengatur letak objek Button di Container */
		btnAdd.setBounds (150, 190, 85, 25);
		btnAdd.setLabel("Add");
		btnAdd.setBackground(Color.red);
		btnAdd.setForeground(Color.getHSBColor(250,0,255));
		btnCari.setBounds (50, 190, 85, 25);
		btnCari.setLabel("Cari");
		btnSelesai.setBounds (250, 190, 85, 25);
		btnSelesai.setLabel("Selesai");
		btnSelesai.setToolTipText("Mengakhiri Program");

		/* Objek Button di Non Aktifkan dan di aktifkan */
		btnAdd.setEnabled(true);
		btnSelesai.setEnabled(true);

		// Mengatur objek untuk dapat berinteraksi
		btnAdd.addActionListener (this);
		btnCari.addActionListener (this);
		btnSelesai.addActionListener (this);


		// Meletakkan seluruh kontrol pada objek panel */
		pPgw.add (lNip);
		pPgw.add (fNip);

		pPgw.add (lNama);
		pPgw.add (fNama);

		pPgw.add (lBagian);
		pPgw.add (fBagian);

		pPgw.add (lKota);
		pPgw.add (fKota);

		pPgw.add (lNoHP);
		pPgw.add (fNoHP);

		pPgw.add (lcreate);
		pPgw.add (btnCari);
		pPgw.add (btnAdd);
		pPgw.add (btnSelesai);

		/* Menambahkan objek panel (pPgr) ke container frame */
		getContentPane().add (pPgw).setBackground(Color.getHSBColor(250,0,255));

		/* Menampilkan frame ke layar monitor */
		pack();

	}

		public static void main(String[] args) {
		new FPegawai06002().setVisible(true);
	}

/* Fungsi jika user melakukan action penekanan tombol Button */
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
				Kosong();
				btnAdd.setText("Simpan");
				btnAdd.setForeground(Color.getHSBColor(100,10,0));
				btnAdd.setBackground(Color.getHSBColor(200,10,100));
			}
		}

		if (obj == btnSelesai)
		{
			System.exit(0);
		}
	}


	// Fungsi untuk menambahkan data ke tabel
		void Add ()
	{
		try
		{
			KoneksiDBMS CnPenjualan = new KoneksiDBMS();
			Connection con = CnPenjualan.BukaCn();
			Statement stat = con.createStatement();

			String strsql = "insert into pegawai06072 (nip ,nama) values "+
				"('"+fNip.getText() + "',' "+fNama.getText()+"')";
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


   // Fungsi untuk mengkosongkan Objek masukan
	void Kosong ()
	{
		 fNip.setText ("");
		 fNama.setText ("");
		 fBagian.setText ("");
		 fKota.setText ("");
		 fNoHP.setText ("");
		 btnAdd.setEnabled(true);
 		 btnSelesai.setEnabled(true);
		 fNip.requestFocus ();

    }

}