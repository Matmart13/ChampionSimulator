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
import static Utiles.HiloPartido.timelinepartido;
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
import Utiles.HiloPartido;

/**
 *
 * @author martín y pablo
 */
public class HiloTiempo extends Thread {

    Label label;

    private int count = 0;
    static Timeline timeline;
    public static int maximo = 45;
    private int countParte = 0;
    Image icono = new Image("/Imagenes/LogoAPP.png", 200, 100, false, true);
    private volatile boolean pausado = false;
    /**
     * Es el constructor de la Clase HiloTiempo
     * @param _label 
     */
    public HiloTiempo(Label _label) {
        label = _label;

    }
    /**
     * Este metodo run sirve para llevar el tiempo del partido y pararlo cuando llegue el minuto 45 y reiniciarlo cuando en la 
     * alert le den a continuar. Cuando llega al final de la segunda parte inicializa la ventana Ganador 
     */
    @Override
    public void run() {
        // TODO Auto-generated method stub

        Musica = "Silbato";
        sonido = ChampionsSimulator.ChampionSimulator.SM.getSonido(Musica);
        sonido.ReproducirSonido();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(HiloTiempo.class.getName()).log(Level.SEVERE, null, ex);
        }
        sonido.PararSonido();
        sonido.reset();
        Musica = "FondoPartido";
        sonido = ChampionsSimulator.ChampionSimulator.SM.getSonido(Musica);
        sonido.ReproducirSonido();
        timeline = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> {
            count++;
            label.setText(Integer.toString(count));

            if (label.getText().equals(String.valueOf(maximo))) {
                timeline.stop();
                if (countParte == 0) {
                    Platform.runLater(() -> {
                        Alert a = new Alert(Alert.AlertType.CONFIRMATION);

                        a.setTitle("Fin primera parte");
                        a.setHeaderText("Fin primera parte");
                        ButtonType botonSeguir = new ButtonType("SEGUIR");
                        countParte = countParte + 1;
                        a.getButtonTypes().setAll(botonSeguir);
                        timelinepartido.stop();
                        Optional<ButtonType> result = a.showAndWait();
                        if (result.isPresent() && result.get() == botonSeguir) {

                            synchronized (timeline) {
                                timeline.notify();
                                timeline.play();
                                timelinepartido.play();
                                sonido.PararSonido();
                                Musica = "Silbato";
                                sonido = ChampionsSimulator.ChampionSimulator.SM.getSonido(Musica);
                                sonido.ReproducirSonido();
                                Musica = "FondoPartido";
                                sonido = ChampionsSimulator.ChampionSimulator.SM.getSonido(Musica);
                                sonido.ReproducirSonido();
                            }
                            count = 0;
                            label.setText(Integer.toString(count));

                        }
                    });
                } else if (label.getText().equals(String.valueOf(maximo)) && countParte == 1) {
                    Platform.runLater(() -> {
                        //Este poner la llamada a ventana fin
                        Stage myStage = (Stage) label.getScene().getWindow();
                        myStage.close();
                        try {
                            sonido.PararSonido();
                            sonido.reset();
                            Musica = "Victoria";
                            sonido = ChampionsSimulator.ChampionSimulator.SM.getSonido(Musica);
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
                            timeline.stop();
                            timelinepartido.stop();
                            countParte = 0;
                            HiloPartido.cont1 = 0;
                            HiloPartido.cont2 = 0;
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
    /**
     * Sirve para devolver el valor del Timeline
     * @return 
     */
    public static Timeline getTimeline() {
        timeline = new Timeline();
        return timeline;
    }
    /**
     * Sirve para devolver el valor de la variable count
     * @return 
     */
    public int getTiempoTranscurrido() {
        return count;
    }

}
