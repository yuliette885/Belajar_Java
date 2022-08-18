/**
 * @(#)Kalkulator001.java
 *
 *
 * @author 
 * @version 1.00 2020/3/31
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;

public class Kalkulator001 extends JFrame implements ActionListener{
	private JPanel 	pKalkulator       = new JPanel();

	private JTextField 	fLayar		= new JTextField ();
	private JLabel 		labelmhs	= new JLabel ("A12.2018.06075_YULIETTE RINDANI"); 

	private JButton 	btnTambah	= new JButton ("+"), 
						btnKurang	= new JButton ("-"),
						btnKali		= new JButton ("*"),
						btnBagi		= new JButton ("/"),
						btnC		        = new JButton ("C"),
						btnKoma				 = new JButton ("."),
						btnBackSpace		 = new JButton("Bspace"),
            			btnTambahKurang	 = new JButton("+/-"),
						btn1		= new JButton ("7"), 
						btn2		= new JButton ("8"), 
						btn3		= new JButton ("9"),
						btn4		= new JButton ("4"),
						btn5		= new JButton ("5"),
						btn6		= new JButton ("6"),
						btn7		= new JButton ("1"),
						btn8		= new JButton ("2"),
						btn9		= new JButton ("3"),						
						btn10		= new JButton ("0"),
						btn11		= new JButton ("000"), 
						btnSama		= new JButton ();
	
	private String isiLayar = "";
	private String snilai1, snilai2, tombol;
	private double hasil;


    public Kalkulator001() {
    	setPreferredSize(new Dimension(500,600));
		setTitle("Kalkulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		new BorderLayout();
		JDesktopPane pKalkulator = new JDesktopPane();
		add(pKalkulator, BorderLayout.CENTER);
		
        
		/* Mengatur letak objek Text Di Container */
		fLayar.setBounds (50, 90, 385, 50);
		labelmhs.setBounds (50, 480, 200, 50);

		/* Mengatur letak objek Button di Container */
		btnC.setBounds (50, 160, 85, 50);	
		btnBagi.setBounds (350, 230, 85, 50);
		btnKali.setBounds (350, 300, 85, 50); 
		btnKurang.setBounds (350, 370, 85, 50); 
		btnTambah.setBounds (350, 440, 85, 50);	
		btnSama.setBounds (250, 440, 85, 50);
		btnKoma.setBounds(250, 160, 85, 50);
        btnBackSpace.setBounds(350, 160, 85, 50);
        btnTambahKurang.setBounds(150, 160, 85, 50);	
		btnSama.setLabel("=");									

		//btnAdd.setToolTipText("Tombol Tambah Data");
		btn1.setBounds (50, 230, 85, 50);
		btn2.setBounds (150, 230, 85, 50);
		btn3.setBounds (250, 230, 85, 50);
		btn4.setBounds (50, 300, 85, 50);
		btn5.setBounds (150, 300, 85, 50);
		btn6.setBounds (250, 300, 85, 50);
		btn7.setBounds (50, 370, 85, 50);
		btn8.setBounds (150, 370, 85, 50);
		btn9.setBounds (250, 370, 85, 50);
		btn10.setBounds (50, 440, 85, 50);
		btn11.setBounds (150, 440, 85, 50);
	
		
		fLayar.setHorizontalAlignment (JTextField.RIGHT);

        
		/* Objek Button di Non Aktifkan dan di aktifkan */
		btnTambah.setEnabled(true);		
		

		/* Mengatur objek untuk dapat berinteraksi */
		btn1.addActionListener (this);
		btn2.addActionListener (this);
		btn3.addActionListener (this);
		btn4.addActionListener (this);
		btn5.addActionListener (this);
		btn6.addActionListener (this);
		btn7.addActionListener (this);
		btn8.addActionListener (this);
		btn9.addActionListener (this);
		btn10.addActionListener (this);
		btn11.addActionListener (this);


		btnTambah.addActionListener (this);
		btnKurang.addActionListener (this);
		btnKali.addActionListener (this);
		btnBagi.addActionListener (this);
		btnSama.addActionListener (this);
		btnC.addActionListener (this);
		btnKoma.addActionListener (this);
		btnTambahKurang.addActionListener (this);
		btnBackSpace.addActionListener (this);
		
	
		
		// Meletakkan seluruh kontrol pada objek panel */
		pKalkulator.add (fLayar);
		pKalkulator.add (labelmhs);
		pKalkulator.add (btn1);
		pKalkulator.add (btn2);
		pKalkulator.add (btn3);
		pKalkulator.add (btn4);
		pKalkulator.add (btn5);
		pKalkulator.add (btn6);
		pKalkulator.add (btn7);
		pKalkulator.add (btn8);
		pKalkulator.add (btn9);
		pKalkulator.add (btn10);
		pKalkulator.add (btn11);


		pKalkulator.add (btnTambah);
		pKalkulator.add (btnKurang);
		pKalkulator.add (btnKali);
		pKalkulator.add (btnBagi);		
		pKalkulator.add (btnSama);
		pKalkulator.add (btnC);
		pKalkulator.add (btnKoma);
		pKalkulator.add (btnTambahKurang);
		pKalkulator.add (btnBackSpace);
		
		getContentPane().add (pKalkulator).setBackground(Color.getHSBColor(250,0,255));
		
		/* Menambahkan objek panel (pKalkulator) ke container frame */
		getContentPane().add (pKalkulator);
		
		/* Menampilkan frame ke layar monitor */
		pack();
		setVisible (true);
    }
    
   public static void main(String[] args) {
		new Kalkulator001().setVisible(true);
	}

    
    /* Fungsi jika user melakukan action penekanan tombol Button */
	public void actionPerformed (ActionEvent ae) {
		Object obj = ae.getSource();
		if (obj == btnC) 	
			{ 
				tombol = ""; snilai1 = ""; snilai2 = "";  
				isiLayar = "";
			 	fLayar.setText(isiLayar); 	
			}

		if (obj == btn1) 	
			{ 
			 	isiLayar = isiLayar + "7";
			 	fLayar.setText(isiLayar); 
			}
		if (obj == btn2) 	
			{ 
			 	isiLayar = isiLayar + "8";
			 	fLayar.setText(isiLayar); 
			}
		if (obj == btn3) 	
			{ 
			 	isiLayar = isiLayar + "9";
			 	fLayar.setText(isiLayar); 
			}
		if (obj == btn4) 	
			{ 
			 	isiLayar = isiLayar + "4";
			 	fLayar.setText(isiLayar); 
			}
		if (obj == btn5) 	
			{ 
			 	isiLayar = isiLayar + "5";
			 	fLayar.setText(isiLayar); 
			}	
		if (obj == btn6) 	
			{ 
			 	isiLayar = isiLayar + "6";
			 	fLayar.setText(isiLayar); 
			}	
		if (obj == btn7) 	
			{ 
			 	isiLayar = isiLayar + "1";
			 	fLayar.setText(isiLayar); 
			}
		if (obj == btn8) 	
			{ 
			 	isiLayar = isiLayar + "2";
			 	fLayar.setText(isiLayar); 
			}
		if (obj == btn9) 	
			{ 
			 	isiLayar = isiLayar + "3";
			 	fLayar.setText(isiLayar); 
			}	

		if (obj == btn10) 	
			{ 
			 	isiLayar = isiLayar + "0";
			 	fLayar.setText(isiLayar); 
			}
		if (obj == btn11) 	
			{ 
			 	isiLayar = isiLayar + "000";
			 	fLayar.setText(isiLayar); 
			}						
		if (obj == btnTambah) 	
			{ 
				tombol = "tambah";
				snilai1 = fLayar.getText();
				isiLayar = "";
			 	fLayar.setText(isiLayar); 

			}
					
		if (obj == btnKurang) 	
			{ 
					tombol = "kurang";
				snilai1 = fLayar.getText();
				isiLayar = "";
			 	fLayar.setText(isiLayar); 
	
			}
		if (obj == btnKali) 	
			{ 
					tombol = "kali";
				snilai1 = fLayar.getText();
				isiLayar = "";
			 	fLayar.setText(isiLayar); 
	
			}
		if (obj == btnBagi) 	
			{ 
					tombol = "bagi";
				snilai1 = fLayar.getText();
				isiLayar = "";
			 	fLayar.setText(isiLayar); 
	
			}
		if (obj == btnKoma) 	
			{ 
			 	isiLayar = isiLayar + ".";
			 	fLayar.setText(isiLayar); 
			}
		if (obj == btnTambahKurang) 	
			{ 
			 	isiLayar = "-" + isiLayar;
            	fLayar.setText(isiLayar); 
			}
		if (obj == btnBackSpace) 	
			{ 
				int pj = isiLayar.length();
			 	isiLayar = isiLayar.substring(0, (pj-1));
			 	fLayar.setText(isiLayar); 
			}
		if (obj == btnSama) 	
			{ 
				//selanjutnya dapat dimodifikasi dengan perintah if.....
			snilai2 = fLayar.getText();
			if (tombol == "tambah")
			{
				hasil = Double.parseDouble(snilai1) + Double.parseDouble(snilai2);
			}
			else
			if (tombol == "kurang")
			{
				hasil = Double.parseDouble(snilai1) - Double.parseDouble(snilai2);
			}
			else
			if (tombol == "kali")
			{
				hasil = Double.parseDouble(snilai1) * Double.parseDouble(snilai2);
			}
			else
			if (tombol == "bagi")
			{
				hasil = Double.parseDouble(snilai1) / Double.parseDouble(snilai2);
			}
			else 
			if (tombol == "tambahkurang")
			{
                hasil = (Double.parseDouble(snilai1) * Double.parseDouble(snilai2)) * -1;
            }
			String shasil = ""+hasil;
			fLayar.setText(shasil);
			}			
			
	}

	
	// Fungsi untuk mengkosongkan Objek masukan 
	void Kosong () 
	{
		 fLayar.setText ("");
		 fLayar.requestFocus ();
	}  
    
}