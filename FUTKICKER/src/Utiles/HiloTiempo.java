/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import Auxiliares.Conexiones;
import static ChampionsSimulator.ChampionSimulator.Musica;
import static ChampionsSimulator.ChampionSimulator.sonido;
import Controladores.FXML_VentanaGanadorController;
import Controladores.FXML_VentanaInicioController;
import Controladores.FXML_VentanaPartidoController;
import Controladores.FXML_VistaTemporadaController;
import static Controladores.FXML_VistaTemporadaController.nombre;
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
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.spi.DirStateFactory;

/**
 *
 * @author martín y pablo
 */
public class HiloTiempo extends Thread {

    Label label;
    public static String ganador = " ";
    private int count = 0;
    static Timeline timeline;
    public static int maximo = 45;
    private int countParte = 0;
    Image icono = new Image("/Imagenes/LogoAPP.png", 200, 100, false, true);
    private volatile boolean pausado = false;

    /**
     * Es el constructor de la Clase HiloTiempo
     *
     * @param _label
     */
    public HiloTiempo(Label _label) {
        label = _label;

    }

    /**
     * Este metodo run sirve para llevar el tiempo del partido y pararlo cuando
     * llegue el minuto 45 y reiniciarlo cuando en la alert le den a continuar.
     * Cuando llega al final de la segunda parte inicializa la ventana Ganador
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
                    if ((Integer.valueOf(HiloPartido.lblGolesLocal.getText()) > Integer.valueOf(HiloPartido.lblGolesVisitante.getText()))) {
                        ganador = nombre;
                    } else if (Integer.valueOf(HiloPartido.lblGolesLocal.getText()) < Integer.valueOf(HiloPartido.lblGolesVisitante.getText())) {
                        ganador = FXML_VentanaPartidoController.visitante;
                    } else if (Integer.valueOf(HiloPartido.lblGolesLocal.getText()) == Integer.valueOf(HiloPartido.lblGolesVisitante.getText())) {
                        ganador = "";
                    }
                    Platform.runLater(() -> {
                        //Este poner la llamada a ventana fin
                        Stage myStage = (Stage) label.getScene().getWindow();
                        myStage.close();
                        
                        try {


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
                            actualizarTabla();

                            stage.show();
                            sonido.PararSonido();
                            sonido.reset();
                            Musica = "Victoria";
                            sonido = ChampionsSimulator.ChampionSimulator.SM.getSonido(Musica);
                            sonido.ReproducirSonido();
                            timeline.stop();
                            timelinepartido.stop();
                            countParte = 0;
                            HiloPartido.cont1 = 0;
                            HiloPartido.cont2 = 0;

                        } catch (IOException ex) {
                            Logger.getLogger(FXML_VentanaInicioController.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (SQLException ex) {
                            Logger.getLogger(HiloTiempo.class.getName()).log(Level.SEVERE, null, ex);
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
     *
     * @return
     */
    public static Timeline getTimeline() {
        timeline = new Timeline();
        return timeline;
    }

    /**
     * Sirve para devolver el valor de la variable count
     *
     * @return
     */
    public int getTiempoTranscurrido() {
        return count;
    }
    /**
     * Este metodo sirve para actualiza los valores de la base de datos en los campos necesarios 
     * de los equipos implicados
     * @throws SQLException 
     */
    public void actualizarTabla() throws SQLException {
        Auxiliares.Conexiones conexion = new Conexiones();
        String ejecucion;
        String consulta;
        ResultSet resultset;
        int anterior;
        int nvalor;
        cambioNombre2();
        cambioVisitante2();
        if (Integer.valueOf(HiloPartido.lblGolesLocal.getText()) > Integer.valueOf(HiloPartido.lblGolesVisitante.getText())) {
            for (int i = 0; i < Controladores.FXML_VistaTemporadaController.ListaTemporada.size(); i++) {
                if (FXML_VistaTemporadaController.ListaTemporada.get(i).getLocal().equals(Controladores.FXML_VistaTemporadaController.nombre)) {
                    cambioNombre();
                    cambioVisitante();
                    ejecucion = "Select eq_victorias from equipos where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
                    resultset = conexion.ejecutarConsulta(ejecucion);
                    if (resultset.next()) {
                        anterior = resultset.getInt("eq_victorias");
                        nvalor = anterior + 1;
                        ejecucion = "UPDATE equipos SET eq_victorias = " + nvalor + " where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
                        conexion.ejecutarInstruccion(ejecucion);
                        anterior = 0;
                        nvalor = 0;
                    }
                    ejecucion = "Select eq_goles from equipos where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
                    resultset = conexion.ejecutarConsulta(ejecucion);
                    if (resultset.next()) {
                        anterior = resultset.getInt("eq_goles");
                        nvalor = Integer.valueOf(HiloPartido.lblGolesLocal.getText()) + anterior;
                        ejecucion = "UPDATE equipos SET eq_goles = " + nvalor + " where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
                        conexion.ejecutarInstruccion(ejecucion);
                        anterior = 0;
                        nvalor = 0;
                    }
                    ejecucion = "Select eq_goles_contra from equipos where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
                    resultset = conexion.ejecutarConsulta(ejecucion);
                    if (resultset.next()) {
                        anterior = resultset.getInt("eq_goles_contra");
                        nvalor = Integer.valueOf(HiloPartido.lblGolesVisitante.getText()) + anterior;
                        ejecucion = "UPDATE equipos SET eq_goles_contra = " + nvalor + " where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
                        conexion.ejecutarInstruccion(ejecucion);
                        anterior = 0;
                        nvalor = 0;
                    }
                    int valor = Integer.valueOf(HiloPartido.lblGolesLocal.getText()) - Integer.valueOf(HiloPartido.lblGolesVisitante.getText());
                    ejecucion = "Select eq_goles_dif from equipos where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
                    resultset = conexion.ejecutarConsulta(ejecucion);
                    if (resultset.next()) {
                        anterior = resultset.getInt("eq_goles_dif");
                        nvalor = valor + anterior;
                        ejecucion = "UPDATE equipos SET eq_goles_dif = " + nvalor + " where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
                        conexion.ejecutarInstruccion(ejecucion);
                        anterior = 0;
                        nvalor = 0;
                    }
                    
                    ejecucion = "Select eq_derrotas from equipos where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
                    resultset = conexion.ejecutarConsulta(ejecucion);
                    if (resultset.next()) {
                        anterior = resultset.getInt("eq_derrotas");
                        nvalor = anterior + 1;
                        ejecucion = "UPDATE equipos SET eq_derrotas = " + nvalor + " where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
                        conexion.ejecutarInstruccion(ejecucion);
                        anterior = 0;
                        nvalor = 0;
                    }

                    ejecucion = "Select eq_goles from equipos where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
                    resultset = conexion.ejecutarConsulta(ejecucion);
                    if (resultset.next()) {
                        anterior = resultset.getInt("eq_goles");
                        nvalor = Integer.valueOf(HiloPartido.lblGolesVisitante.getText()) + anterior;
                        ejecucion = "UPDATE equipos SET eq_goles = " + nvalor + " where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
                        conexion.ejecutarInstruccion(ejecucion);
                        anterior = 0;
                        nvalor = 0;
                    }
                    ejecucion = "Select eq_goles_contra from equipos where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
                    resultset = conexion.ejecutarConsulta(ejecucion);
                    if (resultset.next()) {
                        anterior = resultset.getInt("eq_goles_contra");
                        nvalor = Integer.valueOf(HiloPartido.lblGolesLocal.getText()) + anterior;
                        ejecucion = "UPDATE equipos SET eq_goles_contra = " + nvalor + " where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
                        conexion.ejecutarInstruccion(ejecucion);
                        anterior = 0;
                        nvalor = 0;
                    }
                    ejecucion = "Select eq_goles_dif from equipos where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
                    resultset = conexion.ejecutarConsulta(ejecucion);
                    if (resultset.next()) {
                        anterior = resultset.getInt("eq_goles_dif");

                        int valor2 = Integer.valueOf(HiloPartido.lblGolesVisitante.getText()) - Integer.valueOf(HiloPartido.lblGolesLocal.getText());
                        nvalor = valor2 + anterior;
                        ejecucion = "UPDATE equipos SET eq_goles_dif = " + nvalor + " where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
                        conexion.ejecutarInstruccion(ejecucion);
                        anterior = 0;
                    }

                }
            }

        } else if (Integer.valueOf(HiloPartido.lblGolesLocal.getText()) < Integer.valueOf(HiloPartido.lblGolesVisitante.getText())) {
            for (int i = 0; i < Controladores.FXML_VistaTemporadaController.ListaTemporada.size(); i++) {
                if (FXML_VistaTemporadaController.ListaTemporada.get(i).getVisitante().equals(FXML_VentanaPartidoController.visitante)) {
                    cambioVisitante();
                    cambioNombre();
                    ejecucion = "Select eq_victorias from equipos where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
                    resultset = conexion.ejecutarConsulta(ejecucion);
                    if (resultset.next()) {
                        anterior = resultset.getInt("eq_victorias");
                        nvalor = anterior + 1;
                        ejecucion = "UPDATE equipos SET eq_victorias = " + nvalor + " where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
                        conexion.ejecutarInstruccion(ejecucion);
                        anterior = 0;
                        nvalor = 0;
                    }
                    ejecucion = "Select eq_goles from equipos where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
                    resultset = conexion.ejecutarConsulta(ejecucion);
                    if (resultset.next()) {
                        anterior = resultset.getInt("eq_goles");
                        nvalor = Integer.valueOf(HiloPartido.lblGolesVisitante.getText()) + anterior;
                        ejecucion = "UPDATE equipos SET eq_goles = " + nvalor + " where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
                        conexion.ejecutarInstruccion(ejecucion);
                        anterior = 0;
                        nvalor = 0;
                    }
                    ejecucion = "Select eq_goles_contra from equipos where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
                    resultset = conexion.ejecutarConsulta(ejecucion);
                    if (resultset.next()) {
                        anterior = resultset.getInt("eq_goles_contra");
                        nvalor = Integer.valueOf(HiloPartido.lblGolesLocal.getText()) + anterior;
                        ejecucion = "UPDATE equipos SET eq_goles_contra = " + nvalor + " where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
                        conexion.ejecutarInstruccion(ejecucion);
                        anterior = 0;
                        nvalor = 0;
                    }
                    ejecucion = "Select eq_goles_dif from equipos where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
                    resultset = conexion.ejecutarConsulta(ejecucion);
                    if (resultset.next()) {
                        anterior = resultset.getInt("eq_goles_dif");
                        int valor = Integer.valueOf(HiloPartido.lblGolesVisitante.getText()) - Integer.valueOf(HiloPartido.lblGolesLocal.getText());
                        nvalor = anterior + valor;
                        ejecucion = "UPDATE equipos SET eq_goles_dif = " + nvalor + " where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
                        conexion.ejecutarInstruccion(ejecucion);
                        anterior = 0;
                        nvalor = 0;
                    }

                    ejecucion = "Select eq_derrotas from equipos where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
                    resultset = conexion.ejecutarConsulta(ejecucion);
                    if (resultset.next()) {
                        anterior = resultset.getInt("eq_derrotas");
                        nvalor = anterior + 1;
                        ejecucion = "UPDATE equipos SET eq_derrotas = " + nvalor + " where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
                        conexion.ejecutarInstruccion(ejecucion);
                        anterior = 0;
                        nvalor = 0;
                    }

                    ejecucion = "Select eq_goles from equipos where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
                    resultset = conexion.ejecutarConsulta(ejecucion);
                    if (resultset.next()) {
                        anterior = resultset.getInt("eq_goles");
                        nvalor = Integer.valueOf(HiloPartido.lblGolesLocal.getText()) + anterior;
                        ejecucion = "UPDATE equipos SET eq_goles = " + nvalor + " where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
                        conexion.ejecutarInstruccion(ejecucion);
                        anterior = 0;
                        nvalor = 0;
                    }
                    ejecucion = "Select eq_goles_contra from equipos where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
                    resultset = conexion.ejecutarConsulta(ejecucion);
                    if (resultset.next()) {
                        anterior = resultset.getInt("eq_goles_contra");
                        nvalor = Integer.valueOf(HiloPartido.lblGolesVisitante.getText()) + anterior;
                        ejecucion = "UPDATE equipos SET eq_goles_contra = " + nvalor + " where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
                        conexion.ejecutarInstruccion(ejecucion);
                        anterior = 0;
                        nvalor = 0;
                    }
                    int valor2 = Integer.valueOf(HiloPartido.lblGolesLocal.getText()) - Integer.valueOf(HiloPartido.lblGolesVisitante.getText());
                    ejecucion = "Select eq_goles_dif from equipos where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
                    resultset = conexion.ejecutarConsulta(ejecucion);
                    if (resultset.next()) {
                        anterior = resultset.getInt("eq_goles_dif");
                        nvalor = valor2 + anterior;
                        ejecucion = "UPDATE equipos SET eq_goles_dif = " + nvalor + " where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
                        conexion.ejecutarInstruccion(ejecucion);
                        anterior = 0;
                        nvalor = 0;
                    }
                }
            }
        } else if (Integer.valueOf(HiloPartido.lblGolesLocal.getText()) == Integer.valueOf(HiloPartido.lblGolesVisitante.getText())) {
            cambioVisitante();
            cambioNombre();
            ejecucion = "Select eq_goles from equipos where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
            resultset = conexion.ejecutarConsulta(ejecucion);
            if (resultset.next()) {
                anterior = resultset.getInt("eq_goles");
                nvalor = Integer.valueOf(HiloPartido.lblGolesVisitante.getText()) + anterior;
                ejecucion = "UPDATE equipos SET eq_goles = " + nvalor + " where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
                conexion.ejecutarInstruccion(ejecucion);
                anterior = 0;
                nvalor = 0;
            }
            ejecucion = "Select eq_goles_contra from equipos where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
            resultset = conexion.ejecutarConsulta(ejecucion);
            if (resultset.next()) {
                anterior = resultset.getInt("eq_goles_contra");
                nvalor = Integer.valueOf(HiloPartido.lblGolesLocal.getText()) + anterior;
                ejecucion = "UPDATE equipos SET eq_goles_contra = " + nvalor + " where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
                conexion.ejecutarInstruccion(ejecucion);
                anterior = 0;
                nvalor = 0;
            }
            ejecucion = "Select eq_goles_dif from equipos where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
            resultset = conexion.ejecutarConsulta(ejecucion);
            if (resultset.next()) {
                anterior = resultset.getInt("eq_goles_dif");
                int valor = Integer.valueOf(HiloPartido.lblGolesVisitante.getText()) - Integer.valueOf(HiloPartido.lblGolesLocal.getText());
                nvalor = anterior + valor;
                ejecucion = "UPDATE equipos SET eq_goles_dif = " + nvalor + " where eq_nombre like '" + FXML_VentanaPartidoController.visitante + "'";
                conexion.ejecutarInstruccion(ejecucion);
                anterior = 0;
                nvalor = 0;
            }

            ejecucion = "Select eq_goles from equipos where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
            resultset = conexion.ejecutarConsulta(ejecucion);
            if (resultset.next()) {
                anterior = resultset.getInt("eq_goles");
                nvalor = Integer.valueOf(HiloPartido.lblGolesLocal.getText()) + anterior;
                ejecucion = "UPDATE equipos SET eq_goles = " + nvalor + " where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
                conexion.ejecutarInstruccion(ejecucion);
                anterior = 0;
                nvalor = 0;
            }
            ejecucion = "Select eq_goles_contra from equipos where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
            resultset = conexion.ejecutarConsulta(ejecucion);
            if (resultset.next()) {
                anterior = resultset.getInt("eq_goles_contra");
                nvalor = Integer.valueOf(HiloPartido.lblGolesVisitante.getText()) + anterior;
                ejecucion = "UPDATE equipos SET eq_goles_contra = " + nvalor + " where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
                conexion.ejecutarInstruccion(ejecucion);
                anterior = 0;
                nvalor = 0;
            }
            int valor2 = Integer.valueOf(HiloPartido.lblGolesLocal.getText()) - Integer.valueOf(HiloPartido.lblGolesVisitante.getText());
            ejecucion = "Select eq_goles_dif from equipos where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
            resultset = conexion.ejecutarConsulta(ejecucion);
            if (resultset.next()) {
                anterior = resultset.getInt("eq_goles_dif");
                nvalor = valor2 + anterior;
                ejecucion = "UPDATE equipos SET eq_goles_dif = " + nvalor + " where eq_nombre like '" + Controladores.FXML_VistaTemporadaController.nombre + "'";
                conexion.ejecutarInstruccion(ejecucion);
                anterior = 0;
                nvalor = 0;
            }
        }

        consulta = "Select * from equipos";
        conexion.ejecutarConsulta(consulta);

        conexion.cerrarConexion();

    }

    public void cambioNombre() {
        switch (nombre) {
            case "madrid":
                nombre = "Real Madrid";
                break;
            case "barcelona":
                nombre = "Barcelona";
                break;
            case "manchestercity":
                nombre = "Manchester City";
                break;
            case "arsenal":
                nombre = "Arsenal";
                break;
            case "bayern":
                nombre = "Bayern Munich";
                break;
            case "betis":
                nombre = "Real Betis";
                break;
            case "lazio":
                nombre = "Lazio";
                break;
            case "sporting":
                nombre = "Sporting de Gijon";
                break;
            case "psg":
                nombre = "PSG";
                break;
            case "inter":
                nombre = "Inter de Milan";
                break;
            default:
                break;
        }
    }

    public void cambioNombre2() {
        switch (nombre) {
            case "Real Madrid":
                nombre = "madrid";
                break;
            case "Barcelona":
                nombre = "barcelona";
                break;
            case "Manchester City":
                nombre = "manchestercity";
                break;
            case "Arsenal":
                nombre = "arsenal";
                break;
            case "Bayern Munich":
                nombre = "bayern ";
                break;
            case "Real Betis":
                nombre = "betis";
                break;
            case "Lazio":
                nombre = "lazio";
                break;
            case "Sporting de Gijon":
                nombre = "sporting";
                break;
            case "PSG":
                nombre = "psg";
                break;
            case "Inter de Milan":
                nombre = "inter";
                break;
            default:
                break;
        }
    }

    public void cambioVisitante() {
        switch (FXML_VentanaPartidoController.visitante) {
            case "madrid":
                FXML_VentanaPartidoController.visitante = "Real Madrid";
                break;
            case "barcelona":
                FXML_VentanaPartidoController.visitante = "Barcelona";
                break;
            case "manchestercity":
                FXML_VentanaPartidoController.visitante = "Manchester City";
                break;
            case "arsenal":
                FXML_VentanaPartidoController.visitante = "Arsenal";
                break;
            case "bayern":
                FXML_VentanaPartidoController.visitante = "Bayern Munich";
                break;
            case "betis":
                FXML_VentanaPartidoController.visitante = "Real Betis";
                break;
            case "lazio":
                FXML_VentanaPartidoController.visitante = "Lazio";
                break;
            case "sporting":
                FXML_VentanaPartidoController.visitante = "Sporting de Gijon";
                break;
            case "psg":
                FXML_VentanaPartidoController.visitante = "PSG";
                break;
            case "inter":
                FXML_VentanaPartidoController.visitante = "Inter de Milan";
                break;
            default:
                break;
        }
    }

    public void cambioVisitante2() {
        switch (FXML_VentanaPartidoController.visitante) {
            case "Real Madrid":
                FXML_VentanaPartidoController.visitante = "madrid";
                break;
            case "Barcelona":
                FXML_VentanaPartidoController.visitante = "barcelona";
                break;
            case "Manchester City":
                FXML_VentanaPartidoController.visitante = "manchestercity";
                break;
            case "Arsenal":
                FXML_VentanaPartidoController.visitante = "arsenal";
                break;
            case "Bayern Munich":
                FXML_VentanaPartidoController.visitante = "bayern ";
                break;
            case "Real Betis":
                FXML_VentanaPartidoController.visitante = "betis";
                break;
            case "Lazio":
                FXML_VentanaPartidoController.visitante = "lazio";
                break;
            case "Sporting de Gijon":
                FXML_VentanaPartidoController.visitante = "sporting";
                break;
            case "PSG":
                FXML_VentanaPartidoController.visitante = "psg";
                break;
            case "Inter de Milan":
                FXML_VentanaPartidoController.visitante = "inter";
                break;
            default:
                break;
        }
    }

    public static String getGanador() {
        return ganador;
    }

    public void setGanador(String ganador) {
        this.ganador = ganador;
    }

}
