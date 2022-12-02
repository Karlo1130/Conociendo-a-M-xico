import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class pantallaVictoria extends JPanel{

	private String jugador;
	private String estado;
	
	private int aciertos=0;
	int intentos=0;
	
	private boolean reiniciar=false;
	private boolean salir=false;
	
	JLabel conffeti;
	JLabel felicitacion;
	JLabel[] movimientos = new JLabel[2];
	
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
		
		felicitacion.setText("<html>Buen trabajo, "+jugador+"<p>de "+estado+"<html>");
		
		felicitacion.setBounds(50, 25, icon.getIconWidth(), icon.getIconHeight());
		felicitacion.setFont(new Font("Comic Sans MS", Font.PLAIN, 28));
		felicitacion.setHorizontalTextPosition(JLabel.CENTER);
		felicitacion.setOpaque(true);
		this.add(felicitacion);
		
		movimientos[0] = new JLabel("Aciertos: "+aciertos);
		movimientos[0].setBounds(50, 250, 280, 56);
		movimientos[0].setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		movimientos[0].setBackground(Color.green);
		movimientos[0].setOpaque(true);
		movimientos[0].setVisible(true);

		this.add(movimientos[0]);
		
		movimientos[1] = new JLabel("Intentos: "+intentos);
		movimientos[1].setBounds(370, 250, 280, 56);
		movimientos[1].setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		movimientos[1].setBackground(Color.red);
		movimientos[1].setOpaque(true);
		movimientos[1].setVisible(true);

		this.add(movimientos[1]);
		
		salida[0] = new JButton("Reiniciar partida");
		salida[0].setBounds(50, 325, 280, 56);
		salida[0].setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		salida[0].setVisible(true);
		this.add(salida[0]);
		
		salida[1] = new JButton("Salir");
		salida[1].setBounds(370, 325, 280, 56);
		salida[1].setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		salida[1].setVisible(true);
		this.add(salida[1]);
		
		setLayout(new BorderLayout());
	}
	
	public void setAciertos(int aciertos) {
		this.aciertos = aciertos;
		movimientos[0].setText("Aciertos: "+aciertos);
	}
	
	public void aumentarIntentos() {
		intentos++;
		movimientos[1].setText("Intentos: "+intentos);
	}

}
