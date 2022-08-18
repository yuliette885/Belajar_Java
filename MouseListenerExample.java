/**
 * @(#)MouseListenerExample.java
 *
 *
 * @author 
 * @version 1.00 2020/6/2
 */

import java.awt.*;  
import java.awt.event.*;  

public class MouseListenerExample extends Frame implements MouseListener
{
	//konstruktor...................
    MouseListenerExample()
    {  
        addMouseListener(this);  
        setSize(300,300);  
        setLayout(null);  
        setVisible(true);  
    }  
	
	//pembuatan body/tubuh method yg harus dibuat.......
    public void mouseClicked(MouseEvent e) {  
        Graphics g=getGraphics();  
        g.setColor(Color.BLUE);  
        g.fillOval(e.getX(),e.getY(),25,25);  
    }  
	
	//tubuh method minimal {}...........................
    public void mouseEntered(MouseEvent e) {}  
    public void mouseExited(MouseEvent e) {}  
    public void mousePressed(MouseEvent e) {}  
    public void mouseReleased(MouseEvent e) {}  
      
	//program utama.....................................
	public static void main(String[] args) 
       {  
		new MouseListenerExample();  
	}    
}