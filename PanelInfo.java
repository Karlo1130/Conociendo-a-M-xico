import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class PanelInfo extends JPanel implements MouseListener{

	private Point cursorLocation;
	private boolean cerrar=false;
	private boolean derecha=false;
	private boolean izquierda=false;
	
	JLabel imagen;
	JLabel rojo;
	JLabel[] verde = new JLabel[2];
	private int numPanel;
	private int numImagen=1;
	
	public PanelInfo(int numPanel) { //panel de informacion

		this.numPanel = numPanel;
		
		this.setBounds(400, 300, 200, 200);
		this.setBackground(Color.black);
		this.setOpaque(true);
		this.setVisible(false);
		
		this.addMouseListener(this);//agrega un listener
		
		rojo = new JLabel();
		rojo.setBounds(150, 0, 50, 50);
		rojo.setBackground(Color.red);
		rojo.setOpaque(true);
		
		this.add(rojo);

		cambiarImagen();
		
		setLayout(new BorderLayout());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		cursorLocation = getCursorLocation(e);
		
		if(cursorLocation.getX() >= 150 && cursorLocation.getX() <= 200 &&
				cursorLocation.getY() >= 0 && cursorLocation.getY() <= 50) {
			cerrar=true;//cambia el estado cuando se presiona
		}
		if(cursorLocation.getX() >= 150 && cursorLocation.getX() <= 200 &&
				cursorLocation.getY() > 50 && cursorLocation.getY() <= 150) {
			System.out.println("der");
			derecha=true;//cambia el estado cuando se presiona
		}
		if(cursorLocation.getX() >= 0 && cursorLocation.getX() <= 50 &&
				cursorLocation.getY() > 50 && cursorLocation.getY() <= 150) {
			System.out.println("izq");
			izquierda=true;//cambia el estado cuando se presiona
		}
		
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
	
	public Point getCursorLocation( MouseEvent evt ) {
        Point cursor = evt.getPoint();//Obtiene las coordenadas del mouse en relacion con la pieza
        return cursor;
    }
	
	public boolean getCerrar() {
		return cerrar;
	}
	
	public boolean getDerecha() {
		return derecha;
	}

	public boolean getIzquierda() {
		return izquierda;
	}

	public void aumentarDerecha() {
		numImagen++;
		ImageIcon icon = new ImageIcon( getClass().getResource(numPanel+"/"+numImagen+".png"));
		imagen.setIcon(icon);
		derecha = false;
	}
	
	public void aumentarIzquierda() {
		numImagen--;
		ImageIcon icon = new ImageIcon( getClass().getResource(numPanel+"/"+numImagen+".png"));
		imagen.setIcon(icon);
		izquierda = false;
	}
	
	public void cambiarImagen() {
		verde[0] = new JLabel();
		verde[0].setBounds(150, 50, 50, 100);
		verde[0].setBackground(Color.green);
		verde[0].setOpaque(true);
		
		verde[1] = new JLabel();
		verde[1].setBounds(0, 50, 50, 100);
		verde[1].setBackground(Color.green);
		verde[1].setOpaque(true);
		
		this.add(verde[0]);
		this.add(verde[1]);
		
		ImageIcon icon = new ImageIcon( getClass().getResource(numPanel+"/"+numImagen+".png"));
        
		imagen = new JLabel();
		imagen.setIcon(icon);
		imagen.setBounds(50, 50, 100, 100);
		imagen.setVisible(true);
		imagen.setOpaque(true);
		this.add(imagen);
	}
	
}
