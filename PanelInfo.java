import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.io.File;

public class PanelInfo extends JPanel implements MouseListener{

	private Point cursorLocation;
	private boolean cerrar=false;
	private boolean derecha=false;
	private boolean izquierda=false;
	
	JLabel imagen;
	JLabel rojo;
	JLabel[] verde = new JLabel[2];
	JLabel nomEstado;
	JLabel info;
	private int numArchivos;
	private int numPanel;
	private int numImagen=1;
	
	public PanelInfo(int numPanel) { //panel de informacion

		File carpeta = new File("src/"+numPanel);
		File[] lista = carpeta.listFiles();
		numArchivos = lista.length;//guarda el numero de archivos de la carpeta

		this.numPanel = numPanel;
		
		this.setBounds(150, 0, 700, 800);
		this.setBackground(Color.black);
		this.setOpaque(true);
		this.setVisible(false);
		
		this.addMouseListener(this);//agrega un listener
		
		rojo = new JLabel();
		rojo.setBounds(650, 0, 50, 50);
		rojo.setBackground(Color.red);
		rojo.setOpaque(true);
		
		this.add(rojo);
		
		nomEstado = new JLabel(""+numPanel);
		nomEstado.setBounds(50, 0, 600, 50);
		nomEstado.setBackground(Color.pink);
		nomEstado.setOpaque(true);
		
		this.add(nomEstado);
		panelesImagen();

		ImageIcon icon = new ImageIcon( getClass().getResource(numPanel+"/"+numArchivos+".jpg"));
		info = new JLabel();
		info.setBounds(50, 500, 600, 550);
		info.setIcon(icon);
		info.setBackground(Color.orange);
		info.setOpaque(true);
		info.setVisible(true);
		
		
		this.add(info);
		
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
		
		if(cursorLocation.getX() >= 650 && cursorLocation.getX() <= 700 &&
				cursorLocation.getY() >= 0 && cursorLocation.getY() <= 50) {
			cerrar=true;//cambia el estado cuando se presiona
		}//Boton cerrar "X"
		if(cursorLocation.getX() >= 650 && cursorLocation.getX() <= 700 &&
				cursorLocation.getY() > 50 && cursorLocation.getY() <= 750) {
			derecha=true;//cambia el estado cuando se presiona
		}//Boton derecho
		if(cursorLocation.getX() >= 0 && cursorLocation.getX() <= 50 &&
				cursorLocation.getY() > 50 && cursorLocation.getY() <= 750) {
			izquierda=true;//cambia el estado cuando se presiona
		}//Boton izquierdo
		
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
	
	public void setCerrar(boolean cerrar) {
		this.cerrar = cerrar;
	}
	
	public boolean getDerecha() {
		return derecha;
	}

	public boolean getIzquierda() {
		return izquierda;
	}

	public void aumentarDerecha() {
		numImagen++;
		
		if(numImagen > numArchivos-1)
			numImagen = 1;
		
		ImageIcon icon = new ImageIcon( getClass().getResource(numPanel+"/"+numImagen+".jpg"));
		imagen.setIcon(icon);
		derecha = false;
	}
	
	public void aumentarIzquierda() {
		numImagen--;
		
		if(numImagen < 1)
			numImagen = numArchivos-1;
		
		
		ImageIcon icon = new ImageIcon( getClass().getResource(numPanel+"/"+numImagen+".jpg"));
		imagen.setIcon(icon);
		izquierda = false;
	}
	
	public void panelesImagen() {
		verde[0] = new JLabel(">");
		verde[0].setBounds(650, 50, 50, 750);
		verde[0].setBackground(Color.green);
		verde[0].setOpaque(true);
		
		verde[1] = new JLabel("<");
		verde[1].setBounds(0, 50, 50, 750);
		verde[1].setBackground(Color.green);
		verde[1].setOpaque(true);
		
		this.add(verde[0]);
		this.add(verde[1]);
		
		ImageIcon icon = new ImageIcon( getClass().getResource(numPanel+"/"+numImagen+".jpg"));
        
		imagen = new JLabel();
		imagen.setIcon(icon);
		imagen.setHorizontalAlignment(JLabel.CENTER);
		imagen.setBounds(50, 50, 600, 500);
		imagen.setVisible(true);
		imagen.setOpaque(true);
		this.add(imagen);
	}
	
}
