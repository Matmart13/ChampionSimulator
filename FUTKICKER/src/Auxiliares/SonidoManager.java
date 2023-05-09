/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;

import java.io.IOException;
import java.util.HashMap;
import javafx.scene.control.Alert;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author marti
 */
public class SonidoManager {

    static SonidoManager instance;
    HashMap<String, Sonido> sonidos;

    public static SonidoManager getInstance() {
        if (instance == null) {
            instance = new SonidoManager();
        }
        return instance;
    }

    public SonidoManager() {
        sonidos = new HashMap<>();
    }

    public Sonido getSonido(String _clave) {
        if (sonidos.get(_clave) == null) {
            System.out.println("Sonido no existe,Crealo");
            return null;
        }
        return sonidos.get(_clave);
    }

    public Sonido createSonido(String _clave, String _url) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if (sonidos.get(_clave) == null) {
            Sonido s = new Sonido(_url);
            sonidos.put(_clave, s);
        }
        return sonidos.get(_clave);
    }

}
