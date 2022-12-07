import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class menu extends JPanel implements ActionListener{

	private String jugador;
	private String estado;
	
	JLabel titulo;
	JLabel fondo;
	JTextField nombre;
	JComboBox seleccionEstado;
	JButton boton;
	audio musica;
	
	public menu() {
		
		Dimension dt = new Dimension(1000,800);
        this.setPreferredSize(dt);
        this.setSize(dt);
        this.setBackground(Color.white);
        this.setVisible(true);
        
        //audio.repetirSonido("src/sonido/Fondo.wav");
        musica = new audio("Fondo");
        musica.repetirSonido();
        
        
        /*ImageIcon iconFondo = new ImageIcon( getClass().getResource("img/hola.png"));
        
        fondo = new JLabel ();
        fondo.setBounds(0,0,1000,800);
        fondo.setIcon(iconFondo);
        fondo.setOpaque(true);
        
        this.add(fondo);*/
        
        titulo = new JLabel();
        
        //this.add
		
		nombre = new JTextField();
		nombre.setBounds(200, 300, 600, 56);
		nombre.addActionListener(this);
		nombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		nombre.setVisible(true);
		this.add(nombre);

		String[] estados = {"Selecciona tu estado",
				"Aguascalientes",
				"Baja California",
				"Baja California Sur",
				"Campeche",
				"Chiapas",
				"Chihuahua",
				"Cuidad de méxico",
				"Coahuila",
				"Colima",
				"Durango",
				"Guanajuato",
				"Guerrero",
				"Hidalgo",
				"Jalisco",
				"Michoacán",
				"Morelos",
				"Nayarit",
				"Nuevo León",
				"Oaxaca",
				"Puebla",
				"Querétaro",
				"Quintana Roo",
				"San Luis Potosí",
				"Sinaloa",
				"Sonora",
				"Tabasco",
				"Tamaulipas",
				"Tlaxcala",
				"Veracruz",
				"Yucatán",
				"Zacatecas"};
		
		seleccionEstado = new JComboBox(estados);
		seleccionEstado.setBounds(200, 380, 600, 56);
		seleccionEstado.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		seleccionEstado.setMaximumRowCount(6);
		seleccionEstado.setEnabled(false);
		seleccionEstado.setVisible(true);
		seleccionEstado.addActionListener(this);
		this.add(seleccionEstado);
		
		boton = new JButton("Empezar");
		boton.setBounds(200, 500, 600, 56);
		boton.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		boton.setVisible(false);
		boton.addActionListener(this);
		this.add(boton);
		
		setLayout(new BorderLayout());
		
		ImageIcon icon = new ImageIcon( getClass().getResource("img/hola.png"));
        titulo.setIcon(icon);
        
		titulo.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
		titulo.setBackground(Color.red);
		titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 56));
		titulo.setHorizontalTextPosition(JLabel.CENTER);
		titulo.setOpaque(true);
		this.add(titulo);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() ==  nombre) {
			//nombre.setEditable(false);
			jugador = nombre.getText();
			seleccionEstado.setEnabled(true);
			seleccionEstado.showPopup();
		}
		
		if(e.getSource() ==  seleccionEstado) {
			
			if(seleccionEstado.getSelectedIndex() != 0) {
				estado = (String) seleccionEstado.getSelectedItem();

				boton.setVisible(true);

			}
			else {

				boton.setVisible(false);
			}
		}
		
		if(e.getSource() ==  boton) {
			
			musica.quitarSonido();
			this.removeAll();
			this.add(new Tablero(jugador, estado));
			this.revalidate();
			this.repaint();
		}
	}
	
}
