import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class pantallaVictoria extends JPanel implements ActionListener{

	private String jugador;
	private String estado;
	
	private boolean reiniciar=false;
	private boolean salir=false;
	
	JLabel conffeti;
	JLabel felicitacion;
	
	JButton[] salida = new JButton[2];
	
	public pantallaVictoria(String jugador, String estado) {
		this.jugador = jugador;
    	this.estado = estado;
    	
    	conffeti= new JLabel();
    	
    	ImageIcon confetti = new ImageIcon( getClass().getResource("img/confetti.gif"));
    	conffeti.setIcon(confetti);
    	conffeti.setBounds(0, 0, confetti.getIconWidth(), confetti.getIconHeight());
    	this.add(conffeti);
    	
		this.setBounds(150, 200, 700, 400);
		this.setBackground(Color.magenta);
		this.setOpaque(true);	
		this.setVisible(true);
		
		felicitacion= new JLabel();
		
		ImageIcon icon = new ImageIcon( getClass().getResource("img/blue.png"));
		felicitacion.setIcon(icon);
		
		felicitacion.setText("Buen trabajo, "+jugador+"\n de "+estado);
		
		felicitacion.setBounds(50, 50, icon.getIconWidth(), icon.getIconHeight());
		felicitacion.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
		felicitacion.setHorizontalTextPosition(JLabel.CENTER);
		felicitacion.setOpaque(true);
		this.add(felicitacion);
		
		salida[0] = new JButton("Reiniciar partida");
		salida[0].setBounds(50, 300, 280, 56);
		salida[0].setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		salida[0].setVisible(true);
		salida[0].addActionListener(this);
		this.add(salida[0]);
		
		salida[1] = new JButton("Salir");
		salida[1].setBounds(370, 300, 280, 56);
		salida[1].setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		salida[1].setVisible(true);
		salida[1].addActionListener(this);
		this.add(salida[1]);
		
		setLayout(new BorderLayout());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() ==  salida[0]) {
			
			reiniciar = true;
			
			/*this.removeAll();
			this.add(new Tablero(jugador, estado));
			this.revalidate();
			this.repaint();*/
		}
		if(e.getSource() ==  salida[1]) {
			
			salir = true;
			
			/*this.removeAll();
			this.add(new menu());
			this.revalidate();
			this.repaint();*/
		}
		
		
	}
	
	public boolean getReiniciar() {
		return reiniciar;
	}
	
	public boolean getSalir() {
		return salir;
	}
}
