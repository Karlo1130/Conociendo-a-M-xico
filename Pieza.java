	
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
/**
 * @web https://www.jc-mouse.net/
 * @author Mouse
 */
public class Pieza extends JLabel implements MouseListener, MouseMotionListener{

    //para el movimiento de la pieza
    private Point start_drag;
    private Point start_loc;
    private Point final_location;
    private boolean correcta = false;

    /**
 * Constructor de clase
 * @param pieza numero de pieza
 * @param location Point coordenas de la pieza sobre su contenedor
 */
    public Pieza( int pieza, Point location ){    

        this.setText("");
        this.setVisible(true);        
        ImageIcon icon = new ImageIcon( getClass().getResource("img/"+pieza+".png"));
        this.setIcon(icon);
        Dimension d = new Dimension( icon.getIconWidth(), icon.getIconHeight() );        
        this.setPreferredSize(d);
        this.setSize(d); 
        this.setLocation( location );
        final_location = location;
        
        //Listener
        this.addMouseListener(this);
        this.addMouseMotionListener(this);        
    }

    @Override
    public void mouseClicked(MouseEvent e) {        
    }

    @Override
    public void mousePressed(MouseEvent e) {
       this.start_drag = getScreenLocation(e);
       this.start_loc = this.getLocation();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    	
    	if(final_location.getX() >= 200 && final_location.getX() <= 800 &&
    		final_location.getY() >= 200 && final_location.getY() <= 600) {
    		//System.out.println("Estas in");
    		this.setLocation(0, 0);
    		//this.add(new PanelInfo()).setBackground(Color.blue);
    		correcta = true;
    	}
    	else
    		correcta = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Point current = this.getScreenLocation(e);    
        Point offset = new Point((int) current.getX() - (int) start_drag.getX(),
        							(int) current.getY() - (int) start_drag.getY());//posicion actual - la posicion inicial con respecto a la pantalla   
        Point new_location = new Point((int) (this.start_loc.getX() + offset.getX()),
        								(int) (this.start_loc.getY() + offset.getY()));   
        this.final_location = new_location;
        
        this.setLocation(new_location);    
        this.repaint();
        /*
        if(final_location.getX() >= 0 && final_location.getX() <= 100 &&
        		final_location.getY() >= 0 && final_location.getY() <= 100) {
        		//System.out.println("Estas in");
        		//this.setLocation(0, 0);
        		//this.add(new PanelInfo()).setBackground(Color.blue);
        		correcta = true;
        	}
        	else
        		correcta = false;*/
    }

    @Override
    public void mouseMoved(MouseEvent e) {        
    }

    /**
 * metodo para obtener la posicion del frame en la pantalla
 * @param evt Evento del raton
 * @return Point obtiene las coordenadas del objeto sobre el tablero
 */
    public Point getScreenLocation( MouseEvent evt ) {
        Point cursor = evt.getPoint();//Obtiene las coordenadas del mouse en relacion con la pieza
        Point target_location = this.getLocationOnScreen();//Obtiene las coordenadas de la parte superior izquierda de la pieza
        return new Point((int) (target_location.getX() + cursor.getX()),
            (int) (target_location.getY() + cursor.getY()));//se suman ambos valores para obtener la posicion de la pieza
        													//con respecto a la pantallas
    }
    
    public boolean getCorrecta() {
    	return correcta;
    }
    
}//--> end class