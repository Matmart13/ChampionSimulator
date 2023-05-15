/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuxiliaresTest;

/**
 *
 * @author marti
 */
import Auxiliares.Sonido;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import org.junit.BeforeClass;

import org.junit.AfterClass;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class SonidoTest {

    private static SonidoTest sonido;
    static String url;
    static public Clip clip;
    static URL resource;

    public SonidoTest() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        url = "src\\Musica\\musicaMenu.wav";
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(url).getAbsoluteFile());
        clip = AudioSystem.getClip();
        clip.open(audioInputStream);
    }

    public void ReproducirSonido() {
        clip.start();
    }

    public void PararSonido() {
        clip.stop();
    }

    @BeforeClass
    public static void setUp() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        resource = SonidoTest.class.getClassLoader().getResource("test.wav");
        sonido = new SonidoTest();
    }

    @Test
    public void testReproducirSonido() throws InterruptedException {
        sonido.ReproducirSonido();
        Thread.sleep(5000);
        sonido.PararSonido();
    }

    @Test
    public void testPararSonido() {
        sonido.ReproducirSonido();
        sonido.PararSonido();
    }

}
