import javax.swing.JFrame;

public class Ejemplo {

	public Ejemplo() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PrincipalView aplicacion = new PrincipalView();
		aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		aplicacion.pack();
		aplicacion.setVisible(true);

	}

}
