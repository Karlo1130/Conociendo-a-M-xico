import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.*;

public class audio{

	Clip clip;
	
	public audio(String sonido){
		
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(new File("src/sonido/"+sonido+".wav"));
			clip = AudioSystem.getClip();
			clip.open(audioStream);
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}
	
	public void reproducirSonido(){
		clip.setFramePosition(0);
		clip.start();
		
	}
	
	public void repetirSonido(){
		
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		
	}
	
	public void quitarSonido(){
		clip.stop();
		clip.close();
	}
	
	public void volverInicio() {
		clip.setFramePosition(0);
	}
}
