/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Auxiliares.Conexiones;
import Utiles.HiloTiempo;
import static ChampionsSimulator.ChampionSimulator.Musica;
import static ChampionsSimulator.ChampionSimulator.sonido;
import static Controladores.FXML_VistaTemporadaController.nombre;
import Utiles.HiloTiempo;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author martín y pablo
 */
public class FXML_VentanaGanadorController implements Initializable {

    @FXML
    private Button botonRegreso;
    @FXML
    private ImageView logoGanador;
    @FXML
    private ImageView winnerGIF;
    @FXML
    private ImageView fondo;

    Image ArsenalLogo = new Image("/Imagenes/Arsenal_FC.png", 600, 800, false, true);
    Image RMLogo = new Image("/Imagenes/Madrid.gif", 800, 800, false, true);
    Image BarsaLogo = new Image("/Imagenes/Barsa.gif", 800, 800, false, true);
    Image BetisLogo = new Image("/Imagenes/betis.png", 800, 800, false, true);
    Image SportingLogo = new Image("/Imagenes/Sporting.png", 600, 800, false, true);
    Image InterMilanLogo = new Image("/Imagenes/inter-milan-logo.png", 800, 800, false, true);
    Image McityLogo = new Image("/Imagenes/manchester.gif", 800, 800, false, true);
    Image bayernMunichLogo = new Image("/Imagenes/bayern.gif", 800, 800, false, true);
    Image LazioLogo = new Image("/Imagenes/lazio-logo.png", 800, 600, false, true);
    Image PSGLogo = new Image("/Imagenes/PSG.png", 800, 800, false, true);
    Image logo = new Image("/Imagenes/Logo.png");
    Image winner = new Image("/Imagenes/Winner.gif", 1000, 400, false, true);
    Image fondoGIF = new Image("Imagenes/Fondo ganador.gif");
    Image fondoempate = new Image("Imagenes/fondoEmpate.gif", 800, 800, false, false);
    Image fondofin = new Image("Imagenes/gameover.gif", 800, 800, false, false);
    String ganador;
    static int contador = 0;
    @FXML
    private Label empateLabel;

    /**
     * Inicializa el controlador de la ventana FXML_VentanaGanadorController
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // winnerGIF.setImage(winner);
        ganador = HiloTiempo.getGanador();
        cambioGanador();
        if (contador == 4) {
            fondo.setImage(fondofin);
            botonRegreso.setText("FINAL DE LA TEMPORADA");

        } else if (ganador.equals("madrid")) {
            fondo.setImage(fondoGIF);
            logoGanador.setImage(RMLogo);
            winnerGIF.setImage(winner);
        } else if (ganador.equals("barcelona")) {
            fondo.setImage(fondoGIF);
            logoGanador.setImage(BarsaLogo);
            winnerGIF.setImage(winner);
        } else if (ganador.equals("bayern")) {
            fondo.setImage(fondoGIF);
            logoGanador.setImage(bayernMunichLogo);
            winnerGIF.setImage(winner);
        } else if (ganador.equals("psg")) {
            fondo.setImage(fondoGIF);
            logoGanador.setImage(PSGLogo);
            winnerGIF.setImage(winner);
        } else if (ganador.equals("lazio")) {
            fondo.setImage(fondoGIF);
            logoGanador.setImage(LazioLogo);
            winnerGIF.setImage(winner);
        } else if (ganador.equals("betis")) {
            fondo.setImage(fondoGIF);
            logoGanador.setImage(BetisLogo);
            winnerGIF.setImage(winner);
        } else if (ganador.equals("sporting")) {
            fondo.setImage(fondoGIF);
            logoGanador.setImage(SportingLogo);
            winnerGIF.setImage(winner);
        } else if (ganador.equals("arsenal")) {
            fondo.setImage(fondoGIF);
            logoGanador.setImage(ArsenalLogo);
            winnerGIF.setImage(winner);
        } else if (ganador.equals("manchestercity")) {
            fondo.setImage(fondoGIF);
            logoGanador.setImage(McityLogo);
            winnerGIF.setImage(winner);
        } else if (ganador.equals("inter")) {
            fondo.setImage(fondoGIF);
            logoGanador.setImage(InterMilanLogo);
            winnerGIF.setImage(winner);
        } else if (ganador.equals("")) {
            fondo.setImage(fondoempate);
            logoGanador.setImage(logo);
            empateLabel.setText("EMPATE");
            //winnerGIF.setImage(winner);
        }

    }

    /**
     * Este metodo sirve que para volver a la ventana temporada al pulsar el
     * boton correspondiente
     *
     * @param event
     */
    @FXML
    private void regresoTemporada(ActionEvent event) {
        if (contador == 4) {
            Stage myStage = (Stage) this.botonRegreso.getScene().getWindow();
            myStage.close();
            Musica = "Background";
            sonido = ChampionsSimulator.ChampionSimulator.SM.getSonido(Musica);
            sonido.ReproducirSonido();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXML_VentanaTemporada.fxml"));

                Parent root = loader.load();
                FXML_VistaTemporadaController vec = new FXML_VistaTemporadaController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.getIcons().add(new Image("/Imagenes/LogoAPP.png"));
                stage.setTitle("ChampionSimulator");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.setResizable(false);
                stage.show();

            } catch (IOException ex) {
                Logger.getLogger(FXML_VentanaGanadorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            cambioNombre();
            cambioVisitante();
            Stage myStage = (Stage) this.botonRegreso.getScene().getWindow();
            myStage.close();
            Musica = "Background";
            sonido = ChampionsSimulator.ChampionSimulator.SM.getSonido(Musica);
            sonido.ReproducirSonido();

            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXML_VentanaTemporada.fxml"));

                Parent root = loader.load();
                FXML_VistaTemporadaController vec = new FXML_VistaTemporadaController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();

                stage.getIcons().add(new Image("/Imagenes/LogoAPP.png"));
                stage.setTitle("ChampionSimulator");
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.setResizable(false);
                ganador = "";
                contador++;
                stage.show();

            } catch (IOException ex) {
                Logger.getLogger(FXML_VentanaGanadorController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Este metodo sirve para cambiar la variable nombre
     */
    public void cambioNombre() {
        switch (nombre) {
            case "Real Madrid":
                nombre = "madrid";
                break;
            case "Barcelona":
                nombre = "barcelona";
                break;
            case "ManchesterCity":
                nombre = "manchestercity";
                break;
            case "Arsenal":
                nombre = "arsenal";
                break;
            case "Bayern Munich":
                nombre = "bayern";
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

    public void cambioGanador() {
        switch (ganador) {
            case "Real Madrid":
                ganador = "madrid";
                break;
            case "Barcelona":
                ganador = "barcelona";
                break;
            case "ManchesterCity":
                ganador = "manchestercity";
                break;
            case "Arsenal":
                ganador = "arsenal";
                break;
            case "Bayern Munich":
                ganador = "bayern";
                break;
            case "Real Betis":
                ganador = "betis";
                break;
            case "Lazio":
                ganador = "lazio";
                break;
            case "Sporting de Gijon":
                ganador = "sporting";
                break;
            case "PSG":
                ganador = "psg";
                break;
            case "Inter de Milan":
                ganador = "inter";
                break;
            default:
                ganador = "";
                break;
        }
    }

    public void cambioVisitante() {
        switch (FXML_VentanaPartidoController.visitante) {
            case "Real Madrid":
                FXML_VentanaPartidoController.visitante = "madrid";
                break;
            case "Barcelona":
                FXML_VentanaPartidoController.visitante = "barcelona";
                break;
            case "ManchesterCity":
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

}
