import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class mapa extends JLabel{

	public mapa() {
		
		ImageIcon mexico = new ImageIcon( getClass().getResource("img/mexico.png"));
		this.setIcon(mexico);
		
		this.setBounds(100, 100, 700, 400);
		this.setBackground(Color.magenta);
		this.setOpaque(false);	
		this.setVisible(true);
		
		Dimension d = new Dimension( mexico.getIconWidth(), mexico.getIconHeight() );        
        this.setPreferredSize(d);
        this.setSize(d); 
	}
	
}
