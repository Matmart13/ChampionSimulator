/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UtilesTest;

import Utiles.HiloTiempo;
import java.util.Optional;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;



/**
 *
 * @author marti
 */
public class HiloTiempoTest {
     private static Label label;
    private static HiloTiempo hiloTiempo;
    private static Timeline timeline;
 
    @Test
    public void testHiloTiempo() {
        label = new Label("Hola");
        // Comprobar que el contador aumenta en cada iteración del Timeline
        timeline = hiloTiempo.getTimeline() ;
  
            Assert.assertEquals("Hola", label.getText().toString());
            timeline.playFromStart();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        // Comprobar que se detiene el conteo del HiloTiempo
        timeline.stop();
        int count = Integer.parseInt(label.getText());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(count, Integer.parseInt(label.getText()));

        // Comprobar que se muestra la alerta de fin de la primera parte
        timeline.playFromStart();
        timeline.jumpTo(Duration.seconds(45));
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Fin primera parte");
        a.setHeaderText("Fin primera parte");
        ButtonType botonSeguir = new ButtonType("SEGUIR");
        a.getButtonTypes().setAll(botonSeguir);
        Optional<ButtonType> result = a.showAndWait();
        Assert.assertTrue(result.isPresent() && result.get() == botonSeguir);

        // Comprobar que se reinicia el conteo del HiloTiempo al pulsar el botón de seguir en la alerta
        Assert.assertEquals("0", label.getText());

        // Comprobar que se muestra la alerta de fin del partido
        timeline.playFromStart();
    }
}
