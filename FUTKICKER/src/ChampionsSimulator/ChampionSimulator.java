/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChampionsSimulator;

import Auxiliares.Sonido;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import Auxiliares.SonidoManager;
import Controladores.FXML_VentanaInicioController;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author marti
 */
    
public class ChampionSimulator extends Application {
        
   public static String Musica ;
   public static SonidoManager SM;
   public static Sonido sonido;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/FXML_VentanaInicio.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        Image icono = new Image("/Imagenes/LogoAPP.png", 200, 100, false, true);
        stage.getIcons().add(icono);
        stage.setTitle("ChampionSimulator");
        stage.show();
        stage.setResizable(false);
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
        Musica= "Background";
        sonido= SM.getSonido(Musica);
        sonido.ReproducirSonido();     
        
    }
    /**
     * Este metodo sirve para crear todos los sonidos que hay en el programa
     * @param _m
     * @throws UnsupportedAudioFileException
     * @throws LineUnavailableException
     * @throws IOException 
     */
  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public void creacionSonidos(SonidoManager _m) throws UnsupportedAudioFileException, LineUnavailableException, IOException{
        _m.createSonido("Background","src\\Musica\\musicaMenu.wav");
        _m.createSonido("Background2","src\\Musica\\Cancion1.wav");
         _m.createSonido("Background3","src\\Musica\\Cancion2.wav");
        _m.createSonido("Background4","src\\Musica\\Cancion3.wav");
        _m.createSonido("FondoPartido","src\\Musica\\SonidoFondoPartido.wav");
        _m.createSonido("Victoria","src\\Musica\\Victoria.wav");
        _m.createSonido("Silbato","src\\Musica\\SILBATO.wav");
    }
}
