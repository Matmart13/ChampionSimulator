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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import Auxiliares.SonidoManager;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author marti
 */
public class ChampionSimulator extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Vistas/FXML_VentanaInicio.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        Image icono = new Image("/Imagenes/LogoAPP.png", 200, 100, false, true);
        stage.getIcons().add(icono);
        stage.setTitle("ChampionSimulator");
        stage.show();
        
        //Para crear todos los sonidos
        SonidoManager b = SonidoManager.getInstance();
        creacionSonidos(b);
        //Inicio la musica  
        Sonido background = b.getSonido("Background");
        background.ReproducirSonido();

        
    }
    
    void creacionSonidos(SonidoManager _m) throws UnsupportedAudioFileException, LineUnavailableException, IOException{
        _m.createSonido("Background","src\\Musica\\musicaMenu.wav");
        /*m.createSonido("Background","src\\Musica\\musicaMenu.wav");
        m.createSonido("Background","src\\Musica\\musicaMenu.wav");
         m.createSonido("Background","src\\Musica\\musicaMenu.wav");*/
      
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

    }
}
