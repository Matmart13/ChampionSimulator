/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChamionSimulatorTest;

/**
 *
 * @author marti
 */

import Auxiliares.SonidoManager;
import ChampionsSimulator.ChampionSimulator;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.runner.RunWith;

public class ChampionSImulatorTest {

    @Test
   public void creacionSonidos_createsSounds() {
        // Arrange
        SonidoManager sonidoManager = SonidoManager.getInstance();

        // Act
        try {
            new ChampionSimulator().creacionSonidos(sonidoManager);
        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {
            // The method should not throw any exceptions
        }

        // Assert
        assertNotNull(sonidoManager.getSonido("Background"));
    }


}
