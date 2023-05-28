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
 *@author martín y pablo
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
    
    Image ArsenalLogo = new Image("/Imagenes/Arsenal_FC.png", 1000, 400, false, true);
    Image RMLogo = new Image("/Imagenes/Madrid.gif", 1000, 400, false, true);
    Image BarsaLogo = new Image("/Imagenes/Barsa.gif", 1000, 400, false, true);
    Image BetisLogo = new Image("/Imagenes/betis.png", 1000, 400, false, true);
    Image SportingLogo = new Image("/Imagenes/Sporting.png", 1000, 400, false, true);
    Image InterMilanLogo = new Image("/Imagenes/inter-milan-logo.png", 1000, 400, false, true);
    Image McityLogo = new Image("/Imagenes/manchester.gif", 1000, 400, false, true);
    Image bayernMunichLogo = new Image("/Imagenes/bayern.gif", 1000, 400, false, true);
    Image LazioLogo = new Image("/Imagenes/lazio-logo.png", 1000, 400, false, true);
    Image PSGLogo = new Image("/Imagenes/PSG.png", 1000, 400, false, true);
    Image logo = new Image("/Imagenes/Logo.png");
    
    String ganador;
    int contador = 0;
    @FXML
    private Label empateLabel;
    /**
     * Inicializa el controlador de la ventana FXML_VentanaGanadorController
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image winner = new Image("/Imagenes/Winner.gif", 1000, 400, false, true);
        Image fondoGIF = new Image("Imagenes/Fondo ganador.gif");
         Image fondoempate = new Image("Imagenes/fondoEmpate.gif",800,800,false,false);
          Image fondofin = new Image("Imagenes/gameover.gif",800,800,false,false);
        fondo.setImage(fondoGIF);
        winnerGIF.setImage(winner);
        ganador = HiloTiempo.getGanador();
        cambioGanador();
         if (ganador.equals("madrid")) {
                logoGanador.setImage(RMLogo);
            } else if (ganador.equals("barcelona")) {
                logoGanador.setImage(BarsaLogo);
            } else if (ganador.equals("bayern")) {
                logoGanador.setImage(bayernMunichLogo);
            } else if (ganador.equals("psg")) {
                logoGanador.setImage(PSGLogo);
            } else if (ganador.equals("lazio")) {
                logoGanador.setImage(LazioLogo);
            } else if (ganador.equals("betis")) {
                logoGanador.setImage(BetisLogo);
            } else if (ganador.equals("sporting")) {
                logoGanador.setImage(SportingLogo);
            } else if (ganador.equals("arsenal")) {
                logoGanador.setImage(ArsenalLogo);
            } else if (ganador.equals("manchestercity")) {
                logoGanador.setImage(McityLogo);
            } else if (ganador.equals("inter")) {
                logoGanador.setImage(InterMilanLogo);
            }else{
                fondo.setImage(fondoempate);
                logoGanador.setImage(logo);
                empateLabel.setText("EMPATE");
                //winnerGIF.setImage(winner);
            }
         if(contador == 3){
             fondo.setImage(fondofin);
             
         }
    }
    /**
     * Este metodo sirve que para volver a la ventana temporada al pulsar el boton correspondiente
     * @param event 
     */
    @FXML
    private void regresoTemporada(ActionEvent event) {
        if(contador == 3){
            botonRegreso.setText("FINAL DEL JUEGO");
             Stage myStage = (Stage) this.botonRegreso.getScene().getWindow();
             myStage.close();
        }
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
