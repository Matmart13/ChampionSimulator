/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Auxiliares.Sonido;
import Auxiliares.SonidoManager;
import java.io.IOException;
import java.net.URL;
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
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
//import Vistas.FXML_VentanaElegir;

/**
 * FXML Controller class
 *
 * @author pablo
 */
public class FXML_VentanaInicioController implements Initializable {

    @FXML
    private ImageView fondoImagen;
    @FXML
    private Button botonInicio;
    @FXML
    private Button botonCargar;
    @FXML
    private Button botonSalir;
    @FXML
    private ImageView Logo;
    @FXML
    private Button botonSiguiente;
    
    static String Musica = "Background";
    static SonidoManager SM;
    static Sonido sonido;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image fondo = new Image("/Imagenes/FONDO.gif");
        Image logo = new Image("/Imagenes/Logo.png");
        fondoImagen.setImage(fondo);
        Logo.setImage(logo);
        
           //Para crear todos los sonidos
        SM = SonidoManager.getInstance();
        try {
            creacionSonidos(SM);
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(FXML_VentanaInicioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(FXML_VentanaInicioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FXML_VentanaInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Inicio la musica, se recoge el sonido que quieres poniendo la clave que pusiste 
        sonido= SM.getSonido("Background");
        sonido.ReproducirSonido();
        
        
    }
    public void creacionSonidos(SonidoManager _m) throws UnsupportedAudioFileException, LineUnavailableException, IOException{
        _m.createSonido("Background","src\\Musica\\musicaMenu.wav");
        _m.createSonido("Background2","src\\Musica\\Cancion1.mp3");
        _m.createSonido("Background3","src\\Musica\\Cancion2.mp3");
        _m.createSonido("Background4","src\\Musica\\Cancion3.mp3");
        _m.createSonido("FondoPartido","src\\Musica\\SonidoFondoPartido.mp3");
        _m.createSonido("Victoria","src\\Musica\\Victoria.mp3");
    }
    
    

    @FXML
    private void botonInicioClick(ActionEvent event) {
        Stage myStage = (Stage) this.botonInicio.getScene().getWindow();
        myStage.close();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXML_VentanaElegir.fxml"));

            Parent root = loader.load();
            FXML_VentanaElegirController vec = new FXML_VentanaElegirController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.getIcons().add(new Image("/Imagenes/LogoAPP.png"));
            stage.setTitle("ChampionSimulator");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.showAndWait();

        } catch (IOException ex) {
            Logger.getLogger(FXML_VentanaInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void botonCargarClick(ActionEvent event) {

    }

    @FXML
    private void botonSalirClick(ActionEvent event) {
        Stage myStage = (Stage) this.botonSalir.getScene().getWindow();
        myStage.close();

    }

    @FXML
    private void pasarcanción(ActionEvent event) {
       if(Musica.equals("Background")){
        Musica= "Background2";
      }
       else if(Musica.equals("Background2")){
       Musica="Background3";
    }
     else if(Musica.equals("Background3")){
       Musica="Background";
    }
       
       SM.getSonido(Musica);
       sonido.ReproducirSonido();

    }
}