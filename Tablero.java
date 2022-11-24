
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Random;
import javax.swing.JPanel;

//import org.netbeans.lib.awtextra.AbsoluteLayout;
/**
 * 
 * @author Mouse
 */
public class Tablero extends JPanel{

    private int fila = 3;
    private int columna = 3;
    Pieza [][] matriz = new Pieza[fila][columna];        

    /** 
 * COnstructor de clase
 */
    public Tablero(){

        Dimension dt = new Dimension(500,450);
        this.setPreferredSize(dt);
        this.setSize(dt);
        this.setVisible(true);
        this.setBorder(javax.swing.BorderFactory.createLineBorder(Color.red));        

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
    }

}//--> end class