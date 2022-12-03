
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

//import org.netbeans.lib.awtextra.AbsoluteLayout;
/**
 * 
 * @author Mouse
 */
public class Tablero extends JPanel implements MouseListener, ActionListener{

	private String jugador;
	private String estado;
    private int numPiezas = 32;
    private int piezasCorrectas = 0;
    Pieza [] piezas = new Pieza[numPiezas];   
    PanelInfo[] info = new PanelInfo[numPiezas];
    mapa mexico;
    pantallaVictoria victoria;
    audio[] musica = new audio[5];
    
    /** 
 * COnstructor de clase
 */
    public Tablero(String jugador, String estado) {
    	
    	this.jugador = jugador;
    	this.estado = estado;
    	
        Dimension dt = new Dimension(1000,800);
        this.setPreferredSize(dt);
        this.setSize(dt);
        this.setVisible(true);
        this.setBackground(Color.white);

        musica[0] = new audio("Fondo");
        musica[0].repetirSonido();
        
        musica[1] = new audio("Aplausos");
		musica[2] = new audio("Colocar_Pieza");
        musica[3] = new audio("Acierto");
        musica[4] = new audio("Error");
        
        victoria = new pantallaVictoria(jugador, estado);
        victoria.setBackground(Color.magenta);
        victoria.setVisible(false);
        victoria.salida[0].addMouseListener(this);
        victoria.salida[1].addMouseListener(this);
		this.add(victoria);
        
        //Se añaden las piezas al tablero
        
        for( int i=0 ; i< numPiezas; i++)
        {
                //coordenas aleatorias de pieza
                int x = new Random().nextInt(899+1)+1;
                int y = new Random().nextInt(699+1)+1;
                
                while(x >= 150 && x<800)
                	x =new Random().nextInt(899+1)+1;
                
                while(y >= 150 && y<600)
                	y =new Random().nextInt(699+1)+1;
                
                Point location = new Point(x,y);
                piezas[i] = new Pieza( i+1 , location );
                piezas[i].addMouseListener(this);//agrega un listener a las piezas
                this.add(piezas[i]);
                
                
                info[i] = new PanelInfo(i);
            	info[i].addMouseListener(this);//agrega un listener a las etiquetas
            	this.add(info[i]);
        }
        
        mexico = new mapa();
        this.add(mexico);

        //se asigna Layout
        this.setLayout(new BorderLayout());        
    }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int i = 0; i < numPiezas; i++) {
			if(info[i].getCerrar()) {
				info[i].setCerrar(false);
				//System.out.println(piezas[i].getFinal_Location().getX() +" - "+piezas[i].getFinal_Location().getY());
				this.remove(info[i]);//quita la etiqueta cuando clikas en ella
				for (int j = 0; j < numPiezas; j++) {
					piezas[j].setVisible(true);
				}
				this.revalidate();//refresca la ventana
            	this.repaint();//repinta
            	piezasCorrectas++;
            	
            	victoria.setAciertos(piezasCorrectas);
			}
			if(info[i].getDerecha()) {
				info[i].aumentarDerecha();
			}
			if(info[i].getIzquierda()) {
				info[i].aumentarIzquierda();
			}
		}
		
		if(piezasCorrectas == numPiezas) {

			victoria.setVisible(true);
			this.revalidate();
			this.repaint();

			musica[1].reproducirSonido();
		}
		
		if(e.getSource() ==  victoria.salida[0]) {
			
			for (int i = 0; i < musica.length; i++) {
				if(musica[i] != null)
					musica[i].quitarSonido();
			}

			this.removeAll();
			this.add(new Tablero(jugador, estado));
			this.revalidate();
			this.repaint();
		}
		if(e.getSource() ==  victoria.salida[1]) {
			
			for (int i = 0; i < musica.length; i++) {
				if(musica[i] != null)
					musica[i].quitarSonido();
			}
			
			this.removeAll();
			this.add(new menu());
			this.revalidate();
			this.repaint();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
		for( int i=0 ; i< numPiezas; i++)
        {
            if(piezas[i].getCorrecta()) {
            	
            	int x = 0, y = 0;
            	int x2 = 0, y2 = 0;
            	int px = 0, py = 0;
            	
            	switch(i) {
            	case 0:
            		x = 430; x2 = 460;
            		y = 420; y2 = 450;
            		
            		px = 442; py = 435;
            		break;
            	case 1:
            		x = 155; x2 = 180;
            		y = 145; y2 = 160;
            		
            		px = 167; py = 147;
            		break;
            	case 2:
            		x = 180; x2 = 205;
            		y = 155; y2 = 285;
            		
            		px = 191; py = 270;
            		break;
            	case 3:
            		x = 680; x2 = 710;
            		y = 450; y2 = 480;
            		
            		px = 694; py = 464;
            		break;
            	case 4:
            		x = 650; x2 = 665;
            		y = 535; y2 = 550;
            		
            		px = 657; py = 543;
            		break;
            	case 5:
            		x = 315; x2 = 325;
            		y = 180; y2 = 195;
            		
            		px = 320; py = 187;
            		break;
            	case 6:
            		x = 525; x2 = 535;
            		y = 505; y2 = 515;
            		
            		px = 529; py = 509;
            		break;
            	case 7:
            		x = 420; x2 = 430;
            		y = 235; y2 = 245;
            		
            		px = 425; py = 241;
            		break;
            	case 8:
            		x = 395; x2 = 405;
            		y = 505; y2 = 520;
            		
            		px = 399; py = 512;
            		break;
            	case 9:
            		x = 350; x2 = 360;
            		y = 310; y2 = 325;
            		
            		px = 354; py = 317;
            		break;
            	case 10:
            		x = 495; x2 = 505;
            		y = 480; y2 = 490;
            		
            		px = 499; py = 486;
            		break;
            	case 11:
            		x = 455; x2 = 470;
            		y = 445; y2 = 455;
            		
            		px = 463; py = 451;
            		break;
            	case 12:
            		x = 455; x2 = 465;
            		y = 525; y2 = 535;
            		
            		px = 460; py = 529;
            		break;
            	case 13:
            		x = 510; x2 = 520;
            		y = 445; y2 = 455;
            		
            		px = 514; py = 451;
            		break;
            	case 14:
            		x = 370; x2 = 380;
            		y = 415; y2 = 430;
            		
            		px = 377; py = 422;
            		break;
            	case 15:
            		x = 420; x2 = 430;
            		y = 480; y2 = 495;
            		
            		px = 426; py = 488;
            		break;
            	case 16:
            		x = 520; x2 = 530;
            		y = 515; y2 = 525;
            		
            		px = 525; py = 521;
            		break;
            	case 17:
            		x = 375; x2 = 385;
            		y = 410; y2 = 425;
            		
            		px = 380; py = 417;
            		break;
            	case 18:
            		x = 475; x2 = 485;
            		y = 285; y2 = 295;
            		
            		px = 481; py = 290;
            		break;
            	case 19:
            		x = 545; x2 = 560;
            		y = 525; y2 = 535;
            		
            		px = 552; py = 531;
            		break;
            	case 20:
            		x = 530; x2 = 540;
            		y = 465; y2 = 480;
            		
            		px = 536; py = 472;
            		break;
            	case 21:
            		x = 495; x2 = 505;
            		y = 450; y2 = 460;
            		
            		px = 500; py = 454;
            		break;
            	case 22:
            		x = 765; x2 = 780;
            		y = 425; y2 = 435;
            		
            		px = 772; py = 431;
            		break;
            	case 23:
            		x = 455; x2 = 465;
            		y = 375; y2 = 385;
            		
            		px = 460; py = 381;
            		break;
            	case 24:
            		x = 300; x2 = 315;
            		y = 305; y2 = 315;
            		
            		px = 308; py = 311;
            		break;
            	case 25:
            		x = 200; x2 = 210;
            		y = 150; y2 = 160;
            		
            		px = 205; py = 154;
            		break;
            	case 26:
            		x = 650; x2 = 660;
            		y = 520; y2 = 530;
            		
            		px = 654; py = 524;
            		break;
            	case 27:
            		x = 500; x2 = 515;
            		y = 290; y2 = 300;
            		
            		px = 507; py = 296;
            		break;
            	case 28:
            		x = 540; x2 = 550;
            		y = 495; y2 = 510;
            		
            		px = 545; py = 503;
            		break;
            	case 29:
            		x = 540; x2 = 550;
            		y = 435; y2 = 445;
            		
            		px = 546; py = 439;
            		break;
            	case 30:
            		x = 730; x2 = 745;
            		y = 425; y2 = 440;
            		
            		px = 737; py = 433;
            		break;
            	case 31:
            		x = 410; x2 = 420;
            		y = 355; y2 = 365;
            		
            		px = 415; py = 361;
            		break;
            	}
            	
            	if (piezas[i].getFinal_Location().getX() > x && piezas[i].getFinal_Location().getX() < x2 &&
    				piezas[i].getFinal_Location().getY() > y && piezas[i].getFinal_Location().getY() < y2) {
            			//this.remove(piezas[i]);//borra la pieza
            			piezas[i].quitarMovimiento();
            			
            			for (int j = 0; j < numPiezas; j++) {
        					piezas[j].setVisible(false);
        				}
            			
            			info[i].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion

            			piezas[i].setLocation(px, py);
            			
            			musica[2].reproducirSonido();
            			musica[3].reproducirSonido();
            	}
            	else {
            		victoria.aumentarIntentos();
                    musica[4].reproducirSonido();
            	}
            }
        }
		/*
			if (piezas[0].getFinal_Location().getX() > 430 && piezas[0].getFinal_Location().getX() < 460 &&
					piezas[0].getFinal_Location().getY() > 420 && piezas[0].getFinal_Location().getY() < 450) {
				System.out.println(piezas[0].getFinal_Location().getX() +" - "+piezas[0].getFinal_Location().getY());
		            	info[0].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
		            	this.remove(piezas[0]);//borra la pieza
			}
		    else if (piezas[1].getFinal_Location().getX() > 155 && piezas[1].getFinal_Location().getX() < 180 &&
					piezas[1].getFinal_Location().getY() > 145 && piezas[1].getFinal_Location().getY() < 160) {
					System.out.println(piezas[1].getFinal_Location().getX() +" - "+piezas[1].getFinal_Location().getY());
		            	info[1].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
		            	this.remove(piezas[1]);//borra la pieza
		            	this.repaint();//repinta
			}
		    else if (piezas[2].getFinal_Location().getX() > 180 && piezas[2].getFinal_Location().getX() < 205 &&
					piezas[2].getFinal_Location().getY() > 155 && piezas[2].getFinal_Location().getY() < 285) {
					System.out.println(piezas[2].getFinal_Location().getX() +" - "+piezas[2].getFinal_Location().getY());
			            	info[2].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[2]);//borra la pieza
			            	this.repaint();//repinta
			}
		    else if (piezas[3].getFinal_Location().getX() > 680 && piezas[3].getFinal_Location().getX() < 710 &&
						piezas[3].getFinal_Location().getY() > 450 && piezas[3].getFinal_Location().getY() < 480) {
						System.out.println(piezas[3].getFinal_Location().getX() +" - "+piezas[3].getFinal_Location().getY());
			            	info[3].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[3]);//borra la pieza
			            	this.repaint();//repinta
			}
		    else
		    	victoria.aumentarIntentos();
			
			/*
				if (piezas[4].getFinal_Location().getX() > 645 && piezas[4].getFinal_Location().getX() < 670 &&
						piezas[4].getFinal_Location().getY() > 530 && piezas[4].getFinal_Location().getY() < 555) {
						System.out.println(piezas[4].getFinal_Location().getX() +" - "+piezas[4].getFinal_Location().getY());
			            	info[4].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[4]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[5].getFinal_Location().getX() > 305 && piezas[5].getFinal_Location().getX() < 335 &&
						piezas[5].getFinal_Location().getY() > 175 && piezas[5].getFinal_Location().getY() < 200) {
						System.out.println(piezas[5].getFinal_Location().getX() +" - "+piezas[5].getFinal_Location().getY());
			            	info[5].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[5]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[6].getFinal_Location().getX() > 520 && piezas[6].getFinal_Location().getX() < 540 &&
						piezas[6].getFinal_Location().getY() > 500 && piezas[6].getFinal_Location().getY() < 520) {
						System.out.println(piezas[6].getFinal_Location().getX() +" - "+piezas[6].getFinal_Location().getY());
			            	info[6].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[6]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[7].getFinal_Location().getX() > 410 && piezas[7].getFinal_Location().getX() < 440 &&
						piezas[7].getFinal_Location().getY() > 225 && piezas[7].getFinal_Location().getY() < 255) {
						System.out.println(piezas[7].getFinal_Location().getX() +" - "+piezas[7].getFinal_Location().getY());
			            	info[7].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[7]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[8].getFinal_Location().getX() > 385 && piezas[8].getFinal_Location().getX() < 410 &&
						piezas[8].getFinal_Location().getY() > 500 && piezas[8].getFinal_Location().getY() < 525) {
						System.out.println(piezas[8].getFinal_Location().getX() +" - "+piezas[8].getFinal_Location().getY());
			            	info[8].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[8]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[9].getFinal_Location().getX() > 340 && piezas[9].getFinal_Location().getX() < 365 &&
						piezas[9].getFinal_Location().getY() > 305 && piezas[9].getFinal_Location().getY() < 330) {
						System.out.println(piezas[9].getFinal_Location().getX() +" - "+piezas[9].getFinal_Location().getY());
			            	info[9].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[9]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[10].getFinal_Location().getX() > 490 && piezas[10].getFinal_Location().getX() < 905 &&
						piezas[10].getFinal_Location().getY() > 480 && piezas[10].getFinal_Location().getY() < 490) {
						System.out.println(piezas[10].getFinal_Location().getX() +" - "+piezas[10].getFinal_Location().getY());
			            	info[10].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[10]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[11].getFinal_Location().getX() > 455 && piezas[11].getFinal_Location().getX() < 470 &&
						piezas[11].getFinal_Location().getY() > 440 && piezas[11].getFinal_Location().getY() < 460) {
						System.out.println(piezas[11].getFinal_Location().getX() +" - "+piezas[11].getFinal_Location().getY());
			            	info[11].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[11]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[12].getFinal_Location().getX() > 455 && piezas[12].getFinal_Location().getX() < 465 &&
						piezas[12].getFinal_Location().getY() > 525 && piezas[12].getFinal_Location().getY() < 535) {
						System.out.println(piezas[12].getFinal_Location().getX() +" - "+piezas[12].getFinal_Location().getY());
			            	info[12].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[12]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[13].getFinal_Location().getX() > 505 && piezas[13].getFinal_Location().getX() < 520 &&
						piezas[13].getFinal_Location().getY() > 445 && piezas[13].getFinal_Location().getY() < 455) {
						System.out.println(piezas[13].getFinal_Location().getX() +" - "+piezas[13].getFinal_Location().getY());
			            	info[13].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[13]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[14].getFinal_Location().getX() > 370 && piezas[14].getFinal_Location().getX() < 380 &&
						piezas[14].getFinal_Location().getY() > 415 && piezas[14].getFinal_Location().getY() < 430) {
						System.out.println(piezas[14].getFinal_Location().getX() +" - "+piezas[14].getFinal_Location().getY());
			            	info[14].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[14]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[15].getFinal_Location().getX() > 420 && piezas[15].getFinal_Location().getX() < 430 &&
						piezas[15].getFinal_Location().getY() > 480 && piezas[15].getFinal_Location().getY() < 495) {
						System.out.println(piezas[15].getFinal_Location().getX() +" - "+piezas[15].getFinal_Location().getY());
			            	info[15].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[15]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[16].getFinal_Location().getX() > 520 && piezas[16].getFinal_Location().getX() < 530 &&
						piezas[16].getFinal_Location().getY() > 515 && piezas[16].getFinal_Location().getY() < 525) {
						System.out.println(piezas[16].getFinal_Location().getX() +" - "+piezas[16].getFinal_Location().getY());
			            	info[16].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[16]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[17].getFinal_Location().getX() > 375 && piezas[17].getFinal_Location().getX() < 385 &&
						piezas[17].getFinal_Location().getY() > 410 && piezas[17].getFinal_Location().getY() < 425) {
						System.out.println(piezas[17].getFinal_Location().getX() +" - "+piezas[17].getFinal_Location().getY());
			            	info[17].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[17]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[18].getFinal_Location().getX() > 475 && piezas[18].getFinal_Location().getX() < 485 &&
						piezas[18].getFinal_Location().getY() > 285 && piezas[18].getFinal_Location().getY() < 295) {
						System.out.println(piezas[18].getFinal_Location().getX() +" - "+piezas[18].getFinal_Location().getY());
			            	info[18].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[18]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[19].getFinal_Location().getX() > 545 && piezas[19].getFinal_Location().getX() < 560 &&
						piezas[19].getFinal_Location().getY() > 525 && piezas[19].getFinal_Location().getY() < 535) {
						System.out.println(piezas[19].getFinal_Location().getX() +" - "+piezas[19].getFinal_Location().getY());
			            	info[19].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[19]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[20].getFinal_Location().getX() > 530 && piezas[20].getFinal_Location().getX() < 540 &&
						piezas[20].getFinal_Location().getY() > 465 && piezas[20].getFinal_Location().getY() < 475) {
						System.out.println(piezas[20].getFinal_Location().getX() +" - "+piezas[20].getFinal_Location().getY());
			            	info[20].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[20]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[21].getFinal_Location().getX() > 495 && piezas[21].getFinal_Location().getX() < 505 &&
						piezas[21].getFinal_Location().getY() > 460 && piezas[21].getFinal_Location().getY() < 450) {
						System.out.println(piezas[21].getFinal_Location().getX() +" - "+piezas[21].getFinal_Location().getY());
			            	info[21].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[21]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[22].getFinal_Location().getX() > 765 && piezas[22].getFinal_Location().getX() < 780 &&
						piezas[22].getFinal_Location().getY() > 425 && piezas[22].getFinal_Location().getY() < 435) {
						System.out.println(piezas[22].getFinal_Location().getX() +" - "+piezas[22].getFinal_Location().getY());
			            	info[22].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[22]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				
				
				//           TIENE UN ERROR QUE AÚN NO ENCUENTRO D:
				//           TIENE UN ERROR QUE AÚN NO ENCUENTRO D:
				if (piezas[23].getFinal_Location().getX() > 0 && piezas[23].getFinal_Location().getX() < 500 &&
						piezas[23].getFinal_Location().getY() > 0 && piezas[23].getFinal_Location().getY() < 500) {
						System.out.println(piezas[23].getFinal_Location().getX() +" - "+piezas[23].getFinal_Location().getY());
			            	info[23].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[23]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				
				if (piezas[24].getFinal_Location().getX() > 300 && piezas[24].getFinal_Location().getX() < 315 &&
						piezas[24].getFinal_Location().getY() > 305 && piezas[24].getFinal_Location().getY() < 315) {
						System.out.println(piezas[24].getFinal_Location().getX() +" - "+piezas[24].getFinal_Location().getY());
			            	info[24].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[24]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[25].getFinal_Location().getX() > 200 && piezas[25].getFinal_Location().getX() < 210 &&
						piezas[25].getFinal_Location().getY() > 150 && piezas[25].getFinal_Location().getY() < 160) {
						System.out.println(piezas[25].getFinal_Location().getX() +" - "+piezas[25].getFinal_Location().getY());
			            	info[25].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[25]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[26].getFinal_Location().getX() > 650 && piezas[26].getFinal_Location().getX() < 660 &&
						piezas[26].getFinal_Location().getY() > 520 && piezas[26].getFinal_Location().getY() < 530) {
						System.out.println(piezas[26].getFinal_Location().getX() +" - "+piezas[26].getFinal_Location().getY());
			            	info[26].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[26]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[27].getFinal_Location().getX() > 500 && piezas[27].getFinal_Location().getX() < 515 &&
						piezas[27].getFinal_Location().getY() > 290 && piezas[27].getFinal_Location().getY() < 300) {
						System.out.println(piezas[27].getFinal_Location().getX() +" - "+piezas[27].getFinal_Location().getY());
			            	info[27].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[27]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[28].getFinal_Location().getX() > 540 && piezas[28].getFinal_Location().getX() < 550 &&
						piezas[28].getFinal_Location().getY() > 500 && piezas[28].getFinal_Location().getY() < 510) {
						System.out.println(piezas[28].getFinal_Location().getX() +" - "+piezas[28].getFinal_Location().getY());
			            	info[28].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[28]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[29].getFinal_Location().getX() > 540 && piezas[29].getFinal_Location().getX() < 550 &&
						piezas[29].getFinal_Location().getY() > 435 && piezas[29].getFinal_Location().getY() < 445) {
						System.out.println(piezas[29].getFinal_Location().getX() +" - "+piezas[29].getFinal_Location().getY());
			            	info[29].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[29]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[30].getFinal_Location().getX() > 730 && piezas[30].getFinal_Location().getX() < 745 &&
						piezas[30].getFinal_Location().getY() > 425 && piezas[30].getFinal_Location().getY() < 440) {
						System.out.println(piezas[30].getFinal_Location().getX() +" - "+piezas[30].getFinal_Location().getY());
			            	info[30].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[30]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}
				if (piezas[31].getFinal_Location().getX() > 410 && piezas[31].getFinal_Location().getX() < 420 &&
						piezas[31].getFinal_Location().getY() > 355 && piezas[31].getFinal_Location().getY() < 365) {
						System.out.println(piezas[31].getFinal_Location().getX() +" - "+piezas[31].getFinal_Location().getY());
			            	info[31].setVisible(true);//muestra la etiqueta cuando la pieza esta en posicion
			            	this.remove(piezas[31]);//borra la pieza
			            	this.repaint();//repinta
						}else {          	
							victoria.aumentarIntentos();
						}*/
				
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	

}//--> end class