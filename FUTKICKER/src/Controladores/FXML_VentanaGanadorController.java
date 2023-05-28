/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Auxiliares.Conexiones;
import static ChampionsSimulator.ChampionSimulator.Musica;
import static ChampionsSimulator.ChampionSimulator.sonido;
import static Controladores.FXML_VistaTemporadaController.nombre;
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

    /**
     * Inicializa el controlador de la ventana FXML_VentanaGanadorController
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image winner = new Image("/Imagenes/Winner.gif", 1000, 400, false, true);
        Image fondoGIF = new Image("Imagenes/Fondo ganador.gif");
        fondo.setImage(fondoGIF);
        winnerGIF.setImage(winner);

    }
    /**
     * Este metodo sirve que para volver a la ventana temporada al pulsar el boton correspondiente
     * @param event 
     */
    @FXML
    private void regresoTemporada(ActionEvent event) {
            cambioNombre();
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
    
    public void actualizarTabla() throws SQLException {
         Auxiliares.Conexiones conexion = new Conexiones();
        for (int i = 0; FXML_VistaTemporadaController.Eqlist.size() < 10; i++) {
            
        }
        
        
        

    }
}
