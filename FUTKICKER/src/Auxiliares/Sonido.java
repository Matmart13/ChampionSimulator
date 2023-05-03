/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;

import java.io.File;
import java.io.IOException;
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
        File canc= new File("musicaMenu.mp3");
        String sfondo= "file:///"+canc.getAbsolutePath();
        String def = sfondo.replace("\\" , "/");
        Media cancion= new Media(def);
        MediaPlayer reproductor= new MediaPlayer(cancion);
        
    
    public void reproducirSonido(){
        reproductor.play();
    
    }
    public void pausarSonido(){
        reproductor.pause();
    }
    public static void Reproducir(String nombreSonido){
       try {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("\\Musica\\musicaMenu.wav"));
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
       } catch(UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
         System.out.println("Error al reproducir el sonido.");
       }
     }
}