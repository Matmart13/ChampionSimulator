/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import static ChampionsSimulator.ChampionSimulator.Musica;
import static ChampionsSimulator.ChampionSimulator.sonido;
import Controladores.FXML_VentanaGanadorController;
import Controladores.FXML_VentanaInicioController;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author marti
 */
public class HiloTiempo extends Thread {

    Label label;

    private int count = 0;
    static Timeline timeline;
    private int max = 45;
    private int countParte = 0;
    Image icono = new Image("/Imagenes/LogoAPP.png", 200, 100, false, true);
    private volatile boolean pausado = false;

    public HiloTiempo(Label _label) {
        label = _label;
   
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        
           Musica="Silbato";
           sonido =  ChampionsSimulator.ChampionSimulator.SM.getSonido(Musica);
           sonido.ReproducirSonido();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloTiempo.class.getName()).log(Level.SEVERE, null, ex);
        }
           sonido.PararSonido();
           sonido.reset();
           Musica="FondoPartido";
           sonido =  ChampionsSimulator.ChampionSimulator.SM.getSonido(Musica);
           sonido.ReproducirSonido();
            timeline = new Timeline(new KeyFrame(Duration.seconds(0.15), event -> {
            count++;
            label.setText(Integer.toString(count));

            if (label.getText().equals(String.valueOf(max))) {
                timeline.stop();
                if (countParte == 0) {
                    Platform.runLater(() -> {
                        Alert a = new Alert(Alert.AlertType.CONFIRMATION);

                        a.setTitle("Fin primera parte");
                        a.setHeaderText("Fin primera parte");
                        ButtonType botonSeguir = new ButtonType("SEGUIR");
                        countParte = countParte + 1;
                        a.getButtonTypes().setAll(botonSeguir);

                        Optional<ButtonType> result = a.showAndWait();
                        if (result.isPresent() && result.get() == botonSeguir) {

                            synchronized (timeline) {

                                timeline.notify();
                                timeline.play();
                                sonido.PararSonido();
                                Musica="Silbato";
                                sonido =  ChampionsSimulator.ChampionSimulator.SM.getSonido(Musica);
                                sonido.ReproducirSonido();
                                Musica="FondoPartido";
                                sonido =  ChampionsSimulator.ChampionSimulator.SM.getSonido(Musica);
                                sonido.ReproducirSonido();
                            }
                            count = 0;
                            label.setText(Integer.toString(count));

                        }
                    });
                } else if (label.getText().equals(String.valueOf(max)) && countParte == 1) {
                    Platform.runLater(() -> {
                        //Este poner la llamada a ventana fin
                        Stage myStage = (Stage) label.getScene().getWindow();
                        myStage.close();
                        try {
                            sonido.PararSonido();
                            sonido.reset();
                            Musica="Victoria";
                            sonido =  ChampionsSimulator.ChampionSimulator.SM.getSonido(Musica);
                            sonido.ReproducirSonido();
                    
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXML_VentanaGanador.fxml"));

                            Parent root = loader.load();
                            FXML_VentanaGanadorController v = new FXML_VentanaGanadorController();

                            Scene scene = new Scene(root);
                            Stage stage = new Stage();
                            stage.getIcons().add(new Image("/Imagenes/LogoAPP.png"));
                            stage.setTitle("Final Partido");
                            stage.setResizable(false);
                            stage.initModality(Modality.APPLICATION_MODAL);
                            stage.setScene(scene);
                            stage.show();
                           
                         
                        } catch (IOException ex) {
                            Logger.getLogger(FXML_VentanaInicioController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    });
                }
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        sonido.reset();
    }

    public static Timeline getTimeline() {
        timeline = new Timeline();
        return timeline;
    }

    public int getTiempoTranscurrido() {
        return count;
    }
  
}
