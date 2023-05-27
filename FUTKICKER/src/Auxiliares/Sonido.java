/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author martín y pablo
 */
public class Sonido {

    String url;
   public Clip clip;
   /**
    * Este metodo es el metodo constructor de esta clase que necesita una url por parametro. 
    * @param _url
    * @throws UnsupportedAudioFileException
    * @throws LineUnavailableException
    * @throws IOException 
    */
    public Sonido(String _url) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        this.url = _url;
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(url).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
    }

    /**
     * Este metodo sirve para reproducir el sonido
     */
    public void ReproducirSonido() {
        clip.start();
    }
    /**
     * Este metodo sirve para parar el sonido
     */
    public void PararSonido(){
        clip.stop();
    }
    /**
     * Este metodo sirve para reiniciar el sonido
     */
    public void reset(){
        clip.setMicrosecondPosition(0);
    }
}
