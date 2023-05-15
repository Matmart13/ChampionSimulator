/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuxiliaresTest;

import Auxiliares.Sonido;
import Auxiliares.SonidoManager;
import java.io.IOException;
import java.util.HashMap;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Assert;
/**
 *
 * @author marti
 */
public class SonidoManagerTest {
    
    static  SonidoManager sonidoManager;
    static HashMap<String, Sonido> sonidos;
  static  String claveExistente = "existente";
  static  String claveNueva = "nueva";
  static  String urlSonido = "src\\Musica\\musicaMenu.wav";
    
  
    @BeforeClass
   public static void setUp() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        sonidoManager = SonidoManager.getInstance();
        sonidoManager.createSonido(claveExistente, urlSonido);
    }
    
    @Test
    public  void testGetInstance() {
        Assert.assertNotNull(sonidoManager);
    }
    @Test
    public   void testCreateSonidoExistente() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
      Assert.assertNotNull(sonidoManager.createSonido(claveNueva, urlSonido));
    }
    
    @Test
    public  void testCreateSonidoNoExistente() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Assert.assertNotNull(sonidoManager.createSonido(claveNueva, urlSonido));
    }
    @Test
  public  void testGetSonidoExistente() {
        Assert.assertNotNull(sonidoManager.getSonido(claveExistente));
    }
    
    @Test
    public  void testGetSonidoNoExistente() {
       Assert.assertNotNull(sonidoManager.getSonido(claveExistente));
    }

    
}
