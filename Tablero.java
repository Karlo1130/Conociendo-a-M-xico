
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

//import org.netbeans.lib.awtextra.AbsoluteLayout;
/**
 * 
 * @author Mouse
 */
public class Tablero extends JPanel implements ActionListener{

    private int fila = 3;
    private int columna = 3;
    Pieza [][] matriz = new Pieza[fila][columna];   
    JPanel[][] info = new JPanel[fila][columna];
    Timer timer;

    /** 
 * COnstructor de clase
 */
    public Tablero(){

        Dimension dt = new Dimension(1000,800);
        this.setPreferredSize(dt);
        this.setSize(dt);
        this.setVisible(true);
        this.setBackground(Color.white);
        
        //info = new PanelInfo();
        
        //this.add(info);

        //Se añaden las piezas al tablero
        int p = 1;
        for( int i=0 ; i< fila; i++)
        {
            for( int j=0 ; j<columna; j++)
            {
                //coordenas aleatorias de pieza
                int x = 50 + ( new Random()).nextInt(400-10);
                int y = 50 + ( new Random()).nextInt(300-10);                
                Point location = new Point(x,y);
                matriz[i][j] = new Pieza( p , location );
                this.add( matriz[i][j] );
                p++;
            }
        }

        //se asigna Layout
        this.setLayout(new BorderLayout());
        
        timer = new Timer(1, this);
        timer.start();
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		for( int i=0 ; i< fila; i++)
        {
            for( int j=0 ; j<columna; j++)
            {
                if(matriz[i][j].getCorrecta()) {
                	info[i][j] = new JPanel();
                	info[i][j].setBounds(100, 100, 100, 100);
                	info[i][j].setBackground(Color.black);
                	info[i][j].setVisible(true);
                	this.add(info[i][j], BorderLayout.CENTER);
                	//this.remove(matriz[i][j]); //esto funciona pero aun ocupo saber como quitar el panel asi que lo  comento por mientras jeje
                	this.repaint();
                	//this.revalidate();
                }
                else if(info[i][j] != null && !matriz[i][j].getCorrecta()) {//no sirve como quiero lo de dentro
                	//this.remove(info[i][j]);
                	System.out.println("lele");
                	this.removeAll();
                	//System.out.println(this);	
                	this.revalidate();
                	this.repaint();
                }
            }
        }
	}

}//--> end class