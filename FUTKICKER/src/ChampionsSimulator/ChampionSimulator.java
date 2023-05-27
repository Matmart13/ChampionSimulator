/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ChampionsSimulator;

import Auxiliares.Conexiones;
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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author martín y pablo
 */
public class ChampionSimulator extends Application {

    public static String Musica;
    public static SonidoManager SM;
    public static Sonido sonido;

    /**
     * Este metodo sirve para iniciar la pantalla principal.
     *
     * @param stage
     * @throws Exception
     */
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
        //Limpiar bbdd
        limpiarBBDD();

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
        Musica = "Background";
        sonido = SM.getSonido(Musica);
        sonido.ReproducirSonido();

    }

    /**
     * Este metodo main ejecuta el programa
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Este metodo sirve para crear todos los sonidos que hay en el programa
     *
     * @param _m
     * @throws UnsupportedAudioFileException
     * @throws LineUnavailableException
     * @throws IOException
     */
    public void creacionSonidos(SonidoManager _m) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        _m.createSonido("Background", "src\\Musica\\musicaMenu.wav");
        _m.createSonido("Background2", "src\\Musica\\Cancion1.wav");
        _m.createSonido("Background3", "src\\Musica\\Cancion2.wav");
        _m.createSonido("Background4", "src\\Musica\\Cancion3.wav");
        _m.createSonido("FondoPartido", "src\\Musica\\SonidoFondoPartido.wav");
        _m.createSonido("Victoria", "src\\Musica\\Victoria.wav");
        _m.createSonido("Silbato", "src\\Musica\\SILBATO.wav");
    }

    /**
     * Este metodo sirve para limpiar la base de datos quiere decir dejar todos los campos que queramos en 0 para la ejecucion de una nueva temporada
     * @throws SQLException
     */
    public void limpiarBBDD() throws SQLException {
        Conexiones co = new Conexiones();

        String ejecucion;
        ejecucion = "UPDATE madrid SET Titular = " + 0;
        co.ejecutarInstruccion(ejecucion);
        ejecucion = "UPDATE barcelona SET Titular = " + 0;
        co.ejecutarInstruccion(ejecucion);
        ejecucion = "UPDATE arsenal SET Titular = " + 0;
        co.ejecutarInstruccion(ejecucion);
        ejecucion = "UPDATE lazio SET Titular = " + 0;
        co.ejecutarInstruccion(ejecucion);
        ejecucion = "UPDATE manchestercity SET Titular = " + 0;
        co.ejecutarInstruccion(ejecucion);
        ejecucion = "UPDATE sporting SET Titular = " + 0;
        co.ejecutarInstruccion(ejecucion);
        ejecucion = "UPDATE psg SET Titular = " + 0;
        co.ejecutarInstruccion(ejecucion);
        ejecucion = "UPDATE bayern SET Titular = " + 0;
        co.ejecutarInstruccion(ejecucion);
        ejecucion = "UPDATE betis SET Titular = " + 0;
        co.ejecutarInstruccion(ejecucion);
        ejecucion = "UPDATE inter SET Titular = " + 0;
        co.ejecutarInstruccion(ejecucion);
        ejecucion = "UPDATE equipos SET `eq_victorias`=' 0',`eq_derrotas`=' 0',`eq_goles`=' 0',`eq_goles_contra`=' 0',`eq_goles_dif`=' 0'";
        co.ejecutarInstruccion(ejecucion);
    }

}
