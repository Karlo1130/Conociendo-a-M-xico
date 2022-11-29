
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

//import org.netbeans.lib.awtextra.AbsoluteLayout;
/**
 * 
 * @author Mouse
 */
public class Tablero extends JPanel implements MouseListener, ActionListener{

	private String jugador;
	private String estado;
    private int numPiezas = 1	;
    private int piezasCorrectas = 0;
    Pieza [] piezas = new Pieza[numPiezas];   
    PanelInfo[] info = new PanelInfo[numPiezas];
    mapa mexico;
    pantallaVictoria victoria;
    
    /** 
 * COnstructor de clase
 */
    public Tablero(String jugador, String estado) {
    	
    	this.jugador = jugador;
    	this.estado = estado;
    	
        Dimension dt = new Dimension(1000,800);
        this.setPreferredSize(dt);
        this.setSize(dt);
        this.setVisible(true);
        this.setBackground(Color.white);

        victoria = new pantallaVictoria(jugador, estado);
        victoria.setBackground(Color.magenta);
        victoria.setVisible(false);
        victoria.salida[0].addMouseListener(this);
        victoria.salida[1].addMouseListener(this);
		this.add(victoria);
        
        //Se añaden las piezas al tablero
        
        for( int i=0 ; i< numPiezas; i++)
        {
                //coordenas aleatorias de pieza
                int x = new Random().nextInt(899+1)+1;
                int y = new Random().nextInt(699+1)+1;
                
                while(x >= 150 && x<800)
                	x =new Random().nextInt(899+1)+1;
                
                while(y >= 150 && y<600)
                	y =new Random().nextInt(699+1)+1;
                
                Point location = new Point(x,y);
                piezas[i] = new Pieza( i+1 , location );
                piezas[i].addMouseListener(this);//agrega un listener a las piezas
                this.add(piezas[i]);
                
                
                info[i] = new PanelInfo(i);
            	info[i].addMouseListener(this);//agrega un listener a las etiquetas
            	this.add(info[i]);
        }
        
        mexico = new mapa();
        this.add(mexico);

        //se asigna Layout
        this.setLayout(new BorderLayout());        
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < numPiezas; i++) {
			if(info[i].getCerrar()) {
				info[i].setCerrar(false);
				this.remove(info[i]);//quita la etiqueta cuando clikas en ella
				this.revalidate();//refresca la ventana
            	this.repaint();//repinta
            	piezasCorrectas++;
			}
			if(info[i].getDerecha()) {
				info[i].aumentarDerecha();
			}
			if(info[i].getIzquierda()) {
				info[i].aumentarIzquierda();
			}
		}
		
		if(piezasCorrectas == numPiezas) {
			victoria.setVisible(true);
			this.revalidate();
			this.repaint();
		}
		
		if(e.getSource() ==  victoria.salida[0]) {
			
			//reiniciar = true;
			
			this.removeAll();
			this.add(new Tablero(jugador, estado));
			this.revalidate();
			this.repaint();
		}
		if(e.getSource() ==  victoria.salida[1]) {
			
			//salir = true;
			
			this.removeAll();
			this.add(new menu());
			this.revalidate();
			this.repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		for( int i=0 ; i< numPiezas; i++)
        {
            if(piezas[i].getCorrecta()) {
            	info[i].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
            	this.remove(piezas[i]);//borra la pieza
            	this.repaint();//repinta
            }
        }
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}//--> end class