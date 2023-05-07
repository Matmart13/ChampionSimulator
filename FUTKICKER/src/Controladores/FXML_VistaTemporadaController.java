/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Equipo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Auxiliares.Conexiones;
import Auxiliares.Sonido;
import Auxiliares.SonidoManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.Equipo;
import Modelo.Jugador;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author marti
 */
public class FXML_VistaTemporadaController implements Initializable {

    static String nombre;
    @FXML
    private ImageView Logo;
    @FXML
    private ImageView EscudoEquipo;
    @FXML
    private TableView<Equipo> TablaEquipos;
    @FXML
    private Button Iniciar;
    @FXML
    private Button Salir;
    @FXML
    private TableColumn<Equipo, String> NombreE;
    @FXML
    private TableColumn<Equipo, Integer> Victorias;
    @FXML
    private TableColumn<Equipo, Integer> Derrotas;
    @FXML
    private TableColumn<Equipo, Integer> Goles;
    @FXML
    private TableColumn<Equipo, Integer> GolesContra;
    @FXML
    private TableColumn<Equipo, Integer> DiffGoles;
    @FXML
    private TableView<Jugador> Jugadores;
    @FXML
    private TableColumn<Jugador, String> NombreJugador;
    @FXML
    private TableColumn<Jugador, String> J_Posicion;
    @FXML
    private TableColumn<Jugador, Integer> J_Convocatoria;

    Image ArsenalLogo = new Image("/Imagenes/Arsenal_FC.png", 60, 80, false, true);
    Image RMLogo = new Image("/Imagenes/Madrid.gif", 80, 80, false, true);
    Image BarsaLogo = new Image("/Imagenes/Barsa.gif", 80, 80, false, true);
    Image BetisLogo = new Image("/Imagenes/betis.png", 80, 80, false, true);
    Image SportingLogo = new Image("/Imagenes/Sporting.png", 60, 80, false, true);
    Image InterMilanLogo = new Image("/Imagenes/inter-milan-logo.png", 80, 80, false, true);
    Image McityLogo = new Image("/Imagenes/manchester.gif", 80, 80, false, true);
    Image bayernMunichLogo = new Image("/Imagenes/bayern.gif", 80, 80, false, true);
    Image LazioLogo = new Image("/Imagenes/lazio-logo.png", 80, 60, false, true);
    Image PSGLogo = new Image("/Imagenes/PSG.png", 80, 80, false, true);
    Image logo = new Image("/Imagenes/Logo.png");

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.NombreE.setCellValueFactory(new PropertyValueFactory("Nombre"));
        this.Victorias.setCellValueFactory(new PropertyValueFactory("Victorias"));
        this.Derrotas.setCellValueFactory(new PropertyValueFactory("Derrotas"));
        this.Goles.setCellValueFactory(new PropertyValueFactory("Goles"));
        this.GolesContra.setCellValueFactory(new PropertyValueFactory("GolesContra"));
        this.DiffGoles.setCellValueFactory(new PropertyValueFactory("DiffGoles"));
        this.NombreJugador.setCellValueFactory(new PropertyValueFactory("Nombre"));
        this.J_Posicion.setCellValueFactory(new PropertyValueFactory("Posicion"));
        this.J_Convocatoria.setCellValueFactory(new PropertyValueFactory("Convocado"));

        try {
            getTodosEquipos();
            getTodosJugadores(nombre);
            Logo.setImage(logo);
            if (nombre.equals("madrid")) {
                EscudoEquipo.setImage(RMLogo);
            } else if (nombre.equals("barcelona")) {
                EscudoEquipo.setImage(BarsaLogo);
            } else if (nombre.equals("bayern")) {
                EscudoEquipo.setImage(bayernMunichLogo);
            } else if (nombre.equals("psg")) {
                EscudoEquipo.setImage(PSGLogo);
            } else if (nombre.equals("lazio")) {
                EscudoEquipo.setImage(LazioLogo);
            } else if (nombre.equals("betis")) {
                EscudoEquipo.setImage(BetisLogo);
            } else if (nombre.equals("sporting")) {
                EscudoEquipo.setImage(SportingLogo);
            } else if (nombre.equals("arsenal")) {
                EscudoEquipo.setImage(ArsenalLogo);
            } else if (nombre.equals("manchestercity")) {
                EscudoEquipo.setImage(McityLogo);
            } else if (nombre.equals("inter")) {
                EscudoEquipo.setImage(InterMilanLogo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(FXML_VistaTemporadaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Se para la musica, se crea la instancia, luego se llama al sonido y se pone el metodo que para la musica 
        SonidoManager m = SonidoManager.getInstance();
        Sonido Background = m.getSonido("Background");
        Background.PararSonido();
        //Aqui poner musica para Temporada
        

    }

    public FXML_VistaTemporadaController() {

    }

    public void recibirParametro(String parametro) {
        this.nombre = parametro;

    }

    /**
     * Devuelve la tabla equipos que sera la tabla que tendra la clasificación
     * de esta liga
     *
     * @throws SQLException
     */
    public void getTodosEquipos() throws SQLException {
        ObservableList<Equipo> Eqlist = FXCollections.observableArrayList();
        Auxiliares.Conexiones conexion = new Conexiones();
        String sql = "Select * from equipos";
        ResultSet resultset = conexion.ejecutarConsulta(sql);
        while (resultset.next()) {
            int id = resultset.getInt("eq_id");
            String nombre = resultset.getString("eq_nombre");
            int victorias = resultset.getInt("eq_victorias");
            int derrotas = resultset.getInt("eq_derrotas");
            int goles = resultset.getInt("eq_goles");
            int golesc = resultset.getInt("eq_goles_contra");
            int golesdiff = resultset.getInt("eq_goles_dif");
            int estrellas = resultset.getInt("eq_estrellas");
            Equipo l = new Equipo(id, nombre, victorias, derrotas, goles, golesc, golesdiff, estrellas);
            Eqlist.add(l);
        }
        TablaEquipos.setItems(Eqlist);
        conexion.cerrarConexion();
    }

    /**
     * Este metodo devuelve todos los jugadores correspondientes del equipo que
     * ha seleccionado el jugador
     *
     * @param _nombre
     * @throws SQLException
     */
    public void getTodosJugadores(String _nombre) throws SQLException {
        ObservableList<Jugador> Jlist = FXCollections.observableArrayList();
        Auxiliares.Conexiones conexion = new Conexiones();
        String sql = "Select * from " + _nombre;
        //subString para sacar las tres primeras letras de cada equipo para sacar el nombre completo que hay que pasar 
        String recoger;
        //Debido a que algunos tienen mas de tres por que pablo es imbecil he tenido que poner este if
        ResultSet resultset = conexion.ejecutarConsulta(sql);
        if (_nombre.equals("sporting") || _nombre.equals("manchestercity")) {
            recoger = _nombre.substring(0, 4);
            while (resultset.next()) {
                int id = resultset.getInt(recoger + "_id");
                String nombre = resultset.getString(recoger + "_jugador");
                String posicion = resultset.getString(recoger + "_posicion");
                int titularidad = resultset.getInt("Titular");
                Jugador j = new Jugador(id, nombre, posicion, titularidad);
                Jlist.add(j);

            }
            this.Jugadores.setItems(Jlist);
            conexion.cerrarConexion();
        } else {
            recoger = _nombre.substring(0, 3);
            while (resultset.next()) {
                int id = resultset.getInt(recoger + "_id");
                String nombre = resultset.getString(recoger + "_jugador");
                String posicion = resultset.getString(recoger + "_posicion");
                int titularidad = resultset.getInt("Titular");
                Jugador j = new Jugador(id, nombre, posicion, titularidad);
                Jlist.add(j);

            }
            Jugadores.setItems(Jlist);
            conexion.cerrarConexion();
        }

    }

    @FXML
    private void FuncionIniciar(ActionEvent event) {
        Stage myStage = (Stage) this.Iniciar.getScene().getWindow();
        myStage.close();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXML_VentanaPartido.fxml"));

            Parent root = loader.load();
            FXML_VentanaElegirController vec = new FXML_VentanaElegirController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/Imagenes/LogoAPP.png"));
            stage.setTitle("Partido");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.showAndWait();
            stage.setResizable(false);
        } catch (IOException ex) {
            Logger.getLogger(FXML_VentanaInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void FuncionSalir(ActionEvent event) {
        Stage myStage = (Stage) this.Salir.getScene().getWindow();
        myStage.close();
        
        
    }

}
