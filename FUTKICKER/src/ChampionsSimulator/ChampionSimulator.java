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
        Image icono= new Image("/Imagenes/LogoAPP.png",200,100,false,true);
        stage.getIcons().add(icono);
        stage.setTitle("ChampionSimulator");
        stage.show();
        
       Sonido musica= new Sonido();
        musica.ReproducirSonido("src\\Musica\\musicaMenu.wav");

        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

       
    }
    
}
