import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class PanelInfo extends JPanel implements MouseListener{

	public PanelInfo() { //panel de informacion
		//this.setPreferredSize(new Dimension(200, 200));
		this.setBounds(100, 100, 100, 100);
		this.setBackground(Color.black);
		this.setVisible(true);
	}
	/*
	public void keyPressed(KeyEvent e) {

	    int key = e.getKeyCode();

	    if(key == KeyEvent.VK_D){

	        System.out.println("lol");
	    }
	}*/

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
