/**
 * @(#)FMenuUAS06075.java
 *
 *
 * @author 
 * @version 1.00 2020/6/16
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.Font;
import java.awt.Color;

// Menu.........................................................................
class FMenuUAS06075 extends JFrame {
    //============================================================== attribute
    private JTextArea m_editArea = new JTextArea(20, 50);
    private JPanel 	    JPMenu   = new JPanel();

    private JPopupMenu 	m_popup 	= new JPopupMenu();
	private JLabel 		lNama	  	= new JLabel ("PT. Mulia Sejahtera"),
						lAlamat  	= new JLabel ("Jl. A12.2018.06075-Yuliette Rindani");     
				//Nama Ganti dengan Nama dan NIM anda

    //========================================================== constructor
    public FMenuUAS06075()  //2020 ganti dengan 4 digit nim terakhir
    {
		
        setPreferredSize(new Dimension(800,600));
		setTitle("MENU PENJUALAN");
		
        JDesktopPane JDPMenu = new JDesktopPane();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lNama.setBounds (25, 40, 700, 55);
		lNama.setFont( new Font( "Dialog" , 1 , 48 ));	
		lNama.setForeground(Color.BLUE);
		
		lAlamat.setBounds (25, 95, 300, 35);	
		lAlamat.setFont( new Font( "Dialog" , 1 , 24 ));	    

        //sub menu (M0) Pegawai.....................................    
        JMenuItem M01Pegawai = new JMenuItem("Pegawai");
            M01Pegawai.setMnemonic('P');
            M01Pegawai.setAccelerator(KeyStroke.getKeyStroke("control P"));
            
        JMenuItem M02Password = new JMenuItem("PaSsword");
            M02Password.setMnemonic('S');
            M02Password.setEnabled(false);
            M02Password.setAccelerator(KeyStroke.getKeyStroke("control S"));

        JMenuItem M03Quit = new JMenuItem("Quit");
            M03Quit.setMnemonic('Q');
            M03Quit.setAccelerator(KeyStroke.getKeyStroke("control Q"));

        //sub menu (M1) Barang.....................................    
        JMenuItem M11Barang = new JMenuItem("Barang");
            M11Barang.setMnemonic('B');
            M11Barang.setAccelerator(KeyStroke.getKeyStroke("control B"));
            
        JMenuItem M12Stok = new JMenuItem("Stock Minim");
            M12Stok.setMnemonic('M');
            M12Stok.setEnabled(false);
            M12Stok.setAccelerator(KeyStroke.getKeyStroke("control M"));

           

        //sub menu (M2) Transaksi.....................................    
        JMenuItem M21Pengadaan = new JMenuItem("PengaDaan");
            M21Pengadaan.setMnemonic('D');
            M21Pengadaan.setEnabled(false);
            M21Pengadaan.setAccelerator(KeyStroke.getKeyStroke("control D"));
            
        JMenuItem M22Penjualan = new JMenuItem("PenJualan");
            M22Penjualan.setMnemonic('J');
            M22Penjualan.setEnabled(true);
            M22Penjualan.setAccelerator(KeyStroke.getKeyStroke("control J"));

        JMenuItem M23Laporan = new JMenuItem("Laporan");
            M23Laporan.setMnemonic('L');
            M23Laporan.setEnabled(true);
            M23Laporan.setAccelerator(KeyStroke.getKeyStroke("control L")); 
                       

        // (2) Build  menubar, menus, and add menuitems.
        JMenuBar menubar = new JMenuBar();  // Create new menu bar
            JMenu MenuPegawai = new JMenu("Pegawai"); // Create new menu
                MenuPegawai.setMnemonic('P');
                menubar.add(MenuPegawai);      
                MenuPegawai.add(M01Pegawai);
                MenuPegawai.add(M02Password);   
                MenuPegawai.addSeparator();    
                MenuPegawai.add(M03Quit);
            JMenu MenuBarang = new JMenu("Barang");
                MenuBarang.setMnemonic('B');
                menubar.add(MenuBarang);
                MenuBarang.add(M11Barang);
                MenuBarang.add(M12Stok);
            JMenu MenuTransaksi = new JMenu("Transaksi");
                MenuTransaksi.setMnemonic('T');
                menubar.add(MenuTransaksi);
                MenuTransaksi.add(M21Pengadaan);
                MenuTransaksi.add(M22Penjualan);
                MenuTransaksi.add(M23Laporan);
                                


        //Siap untuk menjalankan pilihan...............................
        M01Pegawai.addActionListener(new BukaPegawai());
        M03Quit.addActionListener(new QuitAction());
        M11Barang.addActionListener(new BukaBarang()); 
        M22Penjualan.addActionListener(new BukaJual());        
        M23Laporan.addActionListener(new Laporan());  


        //... Add the (unused) text area to the content pane.
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(m_editArea, BorderLayout.CENTER);

        //... Add menu items to popup menu, add popup menu to text area.
        m_popup.add(new JMenuItem("Testing"));
        m_editArea.setComponentPopupMenu(m_popup);

        //... Set the JFrame's content pane and menu bar.
        setContentPane(content);
        setJMenuBar(menubar);

		JDPMenu.add (lNama);
		JDPMenu.add (lAlamat);	
        getContentPane().add (JDPMenu).setBackground(Color.getHSBColor(180,100,200));

        pack();
        setLocationRelativeTo(null);
    }


    class OpenAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(FMenuUAS06075.this, "Can't Open.");
        }
    }

       //buka Form Pegawai.........................................................
	class BukaPegawai implements ActionListener {
        public void actionPerformed(ActionEvent e) {         
           
           FPegawai06075 xPegawai = new FPegawai06075();
           xPegawai.setVisible(true);           
           
           //..........................................
           //panggil Form pegawai untuk menjalankan program pegawai !
           //Perintah System.exit(0);  pada FPegawai ganti dengan perintah	
		   // this.dispose();
		   // System.exit(0);  menjadi  this.dispose();
        }
    }
    
      //Buka FormBarang.......................................................
	//hapus double slashnya "//"............................................
	class BukaBarang implements ActionListener {
        public void actionPerformed(ActionEvent e) {
			FTb_Barang06075 xBarang = new FTb_Barang06075();
            xBarang.setVisible(true);
        }
    }    
    
    class BukaJual implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            FJual06075 xJual = new FJual06075();
            xJual.setVisible(true);
        }
    }    
    
    class Laporan implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            CetakBarang06075 xLaporan = new CetakBarang06075();
            xLaporan.setVisible(true);
        }
    }    

    class QuitAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);  // Terminate the program.
        }
    }

    // main progrm............................................................
    public static void main(String[] args) {
        JFrame win = new FMenuUAS06075();
        win.setVisible(true);
    }
}

    
