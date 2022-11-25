import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class PanelInfo extends JPanel{

	public PanelInfo() { //panel de informacion
		//this.setPreferredSize(new Dimension(200, 200));
		this.setBounds(100, 100, 100, 100);
		this.setBackground(Color.black);
		this.setVisible(true);
	}
}
