/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

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
}