import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;



public class PanelInfo extends JLabel implements MouseListener{

	private boolean cerrar=false;
	
	public PanelInfo() { //panel de informacion
		//this.setPreferredSize(new Dimension(200, 200));
		this.setBounds(100, 100, 100, 100);
		this.setBackground(Color.black);
		this.setOpaque(true);
		this.setVisible(false);
		
		
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("lol");
		/*this.setOpaque(false);
		//this.setVisible(false);
		this.removeAll();
        //this.revalidate();
        this.repaint();*/
		//cerrar = true;
		//this.removeAll();
		
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("lil");
		//cerrar = true;
		
		cerrar=true;
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
	
	public boolean getCerrar() {
		return cerrar;
	}
	
}
