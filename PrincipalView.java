
/**
 * @web https://www.jc-mouse.net/
 * @author Mouse
 */
public class PrincipalView extends javax.swing.JFrame {

    //instancia de tablero
    private menu tablero = new menu();

    /**
 * Creates new form principal
 */
    public PrincipalView() {
       // initComponents();
        this.setLocationRelativeTo(null);
        this.setTitle("Rompecabezas - Aprendiendo Estados");
        this.add(tablero);
    }
}