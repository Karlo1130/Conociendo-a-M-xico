
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

//import org.netbeans.lib.awtextra.AbsoluteLayout;
/**
 * 
 * @author Mouse
 */
public class Tablero extends JPanel implements MouseListener{

    private int numPiezas = 9;
    Pieza [] piezas = new Pieza[numPiezas];   
    PanelInfo[] info = new PanelInfo[numPiezas];
    Timer timer;
    int prueba;
    int l=0;
    /** 
 * COnstructor de clase
 */
    public Tablero() {
    	
        Dimension dt = new Dimension(1000,800);
        this.setPreferredSize(dt);
        this.setSize(dt);
        this.setVisible(true);
        this.setBackground(Color.white);
        //this.addMouseListener(this);
        //info = new PanelInfo();
        
        //this.add(info);

        //MouseListener mouse = new MouseListener();
        
        //Se añaden las piezas al tablero
        int p = 1;
        for( int i=0 ; i< numPiezas; i++)
        {
                //coordenas aleatorias de pieza
                int x = 50 + ( new Random()).nextInt(400-10);
                int y = 50 + ( new Random()).nextInt(300-10);                
                Point location = new Point(x,y);
                piezas[i] = new Pieza( 1 , location );
                piezas[i].addMouseListener(this);
                this.add( piezas[i] );
                p++;
                
                info[i] = new PanelInfo();
            	info[i].addMouseListener(this);
            	this.add(info[i]);
        }

        //se asigna Layout
        this.setLayout(new BorderLayout());

        
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < numPiezas; i++) {
			if(info[i].getCerrar()) {
				System.out.println(l++);
				this.remove(info[i]);
				this.revalidate();
            	this.repaint();
			}
		}
		/*
		System.out.println(prueba);
		this.remove(info[prueba]);
		this.revalidate();
    	this.repaint();
    	*/
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
            	prueba = i;
            	
            	info[i].setVisible(true);
            	
            	this.remove(piezas[i]);
            	this.repaint();
                
            }/*
            if(info[i] != null && !piezas[i].getCorrecta()) {
                System.out.println("lele");
                this.remove(info[i]);
                this.revalidate();
                this.repaint();
            } */
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
	

}//--> end class