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
 *@author martín y pablo
 */
public class SonidoManager {

    static SonidoManager instance;
    HashMap<String, Sonido> sonidos;
    /**
     * Sirve para devolver la instancia de la clase tanto si existe como si no existe
     * @return 
     */
    public static SonidoManager getInstance() {
        if (instance == null) {
            instance = new SonidoManager();
        }
        return instance;
    }
    /**
     * Constructor de la clase SonidoManager() 
     */
    public SonidoManager() {
        sonidos = new HashMap<>();
    }
    /**
     * Este metodo sirve para devolver un sonido según la clave que le pases por parametro
     * @param _clave
     * @return 
     */
    public Sonido getSonido(String _clave) {
        if (sonidos.get(_clave) == null) {
            System.out.println("Sonido no existe,Crealo");
            return null;
        }
        return sonidos.get(_clave);
    }
    /**
     * Este metodo sirve para crear un sonido y para ello se le pasa tanto la clave como la url por parametro
     * @param _clave
     * @param _url
     * @return
     * @throws UnsupportedAudioFileException
     * @throws LineUnavailableException
     * @throws IOException 
     */
    public Sonido createSonido(String _clave, String _url) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if (sonidos.get(_clave) == null) {
            Sonido s = new Sonido(_url);
            sonidos.put(_clave, s);
        }
        return sonidos.get(_clave);
    }

}
