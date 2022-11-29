import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class menu extends JPanel implements ActionListener{

	private String jugador;
	private String estado;
	
	JLabel titulo;
	JTextField nombre;
	JComboBox seleccionEstado;
	JButton boton;
	
	public menu() {
		Dimension dt = new Dimension(1000,800);
        this.setPreferredSize(dt);
        this.setSize(dt);
        this.setBackground(Color.white);
        this.setVisible(true);
        
        titulo = new JLabel("Conociendo a México");
        
        ImageIcon icon = new ImageIcon( getClass().getResource("img/blue.png"));
        titulo.setIcon(icon);
        
		titulo.setBounds(200, 50, icon.getIconWidth(), icon.getIconHeight());
		titulo.setBackground(Color.red);
		titulo.setFont(new Font("Comic Sans MS", Font.PLAIN, 56));
		titulo.setHorizontalTextPosition(JLabel.CENTER);
		titulo.setOpaque(true);
		this.add(titulo);
		
		nombre = new JTextField();
		nombre.setBounds(200, 300, 600, 56);
		nombre.addActionListener(this);
		nombre.setFont(new Font("Comic Sans MS", Font.PLAIN, 32));
		nombre.setVisible(true);
		this.add(nombre);

		String[] estados = {"Selecciona tu estado",
				"Baja California Sur",
				"Baja California",
				"Chihuahua"};
		
		seleccionEstado = new JComboBox(estados);
		seleccionEstado.setBounds(200, 400, 600, 56);
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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() ==  nombre) {
			//nombre.setEditable(false);
			jugador = nombre.getText();
			seleccionEstado.setEnabled(true);
			seleccionEstado.showPopup();
			
			System.out.println(jugador);
		}
		
		if(e.getSource() ==  seleccionEstado) {
			
			if(seleccionEstado.getSelectedIndex() != 0) {
				estado = (String) seleccionEstado.getSelectedItem();

				boton.setVisible(true);
				
				System.out.println(estado);
			}
			else {

				boton.setVisible(false);
			}
		}
		
		if(e.getSource() ==  boton) {
			
			this.removeAll();
			this.add(new Tablero(jugador, estado));
			this.revalidate();
			this.repaint();
		}
	}
	
}
