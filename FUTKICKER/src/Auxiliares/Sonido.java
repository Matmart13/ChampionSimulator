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
 * @author pablo
 */
public class Sonido {
   public void ReproducirSonido(String nombreSonido){
       try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(nombreSonido).getAbsoluteFile());
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
       } catch(UnsupportedAudioFileException ex) {
         System.out.println("Error al reproducir el sonido.");
       } catch (LineUnavailableException ex) {
             System.out.println("Error al reproducir el sonido 2.");
       } catch (IOException ex) {
             System.out.println("Error al reproducir el sonido 3.");
       }
     }
}