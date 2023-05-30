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
import static ChampionsSimulator.ChampionSimulator.Musica;
import static ChampionsSimulator.ChampionSimulator.sonido;
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.Equipo;
import Modelo.Jugador;
import Modelo.Partidos;
import com.sun.javafx.collections.ElementObservableListDecorator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author martín y pablo
 */
public class FXML_VistaTemporadaController implements Initializable {

    //Variables FXML
    @FXML
    private ImageView EscudoEquipo;
    @FXML
    private TableView<Equipo> TablaEquipos;
    @FXML
    public Button Iniciar;
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
    @FXML
    private ImageView fondoTemporada;
    //Variables Image
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
    Image fondo = new Image("/Imagenes/FondoTemporada.jpg");
    @FXML
    private Button Menu;
    @FXML
    private Button botonSiguiente;
    @FXML
    private Button botonMute;
    @FXML
    private Button BottonConvocar;
    //Variables de uso
    public static String nombre;
    static int equiposvstotal;
    static int random;
    static int rival;
    static int contManchester;
    static int convocados = 0;
    public static List<Partidos> partidosTotales;
    public static List<Partidos> partidosSeleccionados;
    public static List<Partidos> ListaTemporada;
    static List<Partidos> enfrentamientosLocales;
    ObservableList<Partidos> listapartidos;
    Equipo elegido;
    Equipo vs;
    static int contador = 0;
    public static ObservableList<Equipo> Eqlist;
  
    static int contadorpartidos = 0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (FXML_VentanaGanadorController.contador == 4){
            Iniciar.setDisable(true);
            FXML_VentanaGanadorController.contador = 0;
       
        }
        fondoTemporada.setImage(fondo);
        colocarImagenBotones();
        this.NombreE.setCellValueFactory(new PropertyValueFactory("Nombre"));
        this.Victorias.setCellValueFactory(new PropertyValueFactory("Victorias"));
        this.Derrotas.setCellValueFactory(new PropertyValueFactory("Derrotas"));
        this.Goles.setCellValueFactory(new PropertyValueFactory("Goles"));
        this.GolesContra.setCellValueFactory(new PropertyValueFactory("golesc"));
        this.DiffGoles.setCellValueFactory(new PropertyValueFactory("golesdiff"));
        this.NombreJugador.setCellValueFactory(new PropertyValueFactory("Nombre"));
        this.J_Posicion.setCellValueFactory(new PropertyValueFactory("Posicion"));
        this.J_Convocatoria.setCellValueFactory(new PropertyValueFactory("Titular"));

        try {
            Eqlist = FXCollections.observableArrayList();
            getTodosEquipos(Eqlist);
            TablaEquipos.setItems(Eqlist);
            getTodosJugadores(nombre);

            if (contador == 0) {
                partidosTotales = new ArrayList<>();
                partidosSeleccionados = new ArrayList<>();
                ListaTemporada = new ArrayList<Partidos>();
                enfrentamientosLocales = new ArrayList<Partidos>();
                getEnfrentamientos();
                contador++;
            }
            getPartidosTemporada(nombre);
            //getPartidos(listapartidos);
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
        //  SonidoManager m = SonidoManager.getInstance();
        // Sonido Background = m.getSonido("Background");
        // Background.PararSonido();
        //Aqui poner musica para Temporada

    }

    /**
     * Constructor
     */
    public FXML_VistaTemporadaController() {
       
    }

    //Metodos FXML
    /**
     * Este metodo sirve para que cuando pulses el boton iniciar inicie el
     * partido con su vista correspondiente.Tambien tiene encuenta si estan los
     * 11 jugadores del 11 inicial
     *
     * @param event
     */
    @FXML
    private void FuncionIniciar(ActionEvent event) {
        int faltan;
        if (convocados > 11) {
            Alert a = new Alert(Alert.AlertType.WARNING);

            a.setTitle("Error");
            faltan = convocados - 11;
            a.setHeaderText("Error, solo puede jugar con 11 jugadores convocados tienes que mandar al banquillo a " + faltan);
            ButtonType botonSeguir = new ButtonType("SEGUIR");
            a.getButtonTypes().setAll(botonSeguir);
            Optional<ButtonType> result = a.showAndWait();

        } else if (convocados < 11) {

            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setTitle("Error");
            faltan = 11 - convocados;
            a.setHeaderText("Error, no has metido a los 11 jugadores del 11 inicial te faltan " + faltan);
            ButtonType botonSeguir = new ButtonType("SEGUIR");
            a.getButtonTypes().setAll(botonSeguir);
            Optional<ButtonType> result = a.showAndWait();
        } else {
            Stage myStage = (Stage) this.Iniciar.getScene().getWindow();
            myStage.close();

            sonido.PararSonido();
            sonido.reset();
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXML_VentanaPartido.fxml"));

                Parent root = loader.load();
                FXML_VentanaPartidoController v = new FXML_VentanaPartidoController();

                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.getIcons().add(new Image("/Imagenes/LogoAPP.png"));
                stage.setTitle("ChampionSimulator");
                stage.setResizable(false);
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.setScene(scene);
                stage.showAndWait();

            } catch (IOException ex) {
                Logger.getLogger(FXML_VentanaInicioController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Este metodo sirve para que cuando pulses el boton salir, se cierre el
     * programa
     *
     * @param event
     */
    @FXML
    private void FuncionSalir(ActionEvent event) {
        Stage myStage = (Stage) this.Salir.getScene().getWindow();
        contadorpartidos = 0;
        myStage.close();

    }

    //Metodos de uso 
    /**
     * Sirve para recoger que equipo es el elegido por el usuario anteriormente
     * y que se le ponga la ventana/escena configurada con su equipo
     *
     * @param parametro
     */
    public void recibirParametro(String parametro) {
        this.nombre = parametro;
    }

    /**
     * Devuelve la tabla equipos que sera la tabla que tendra la clasificación
     * de esta liga
     *
     * @throws SQLException
     */
    public static void getTodosEquipos(ObservableList<Equipo> _Eqlist) throws SQLException {
        Auxiliares.Conexiones conexion = new Conexiones();
        String sql = "Select * from equipos order by eq_victorias desc,eq_goles desc";
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
        String sql;
        //subString para sacar las tres primeras letras de cada equipo para sacar el nombre completo que hay que pasar 
        String recoger;
        //Debido a que algunos tienen mas de tres por que pablo es imbecil he tenido que poner este if
        ResultSet resultset;

        if (_nombre.equals("sporting") || _nombre.equals("manchestercity")) {
            recoger = _nombre.substring(0, 4);
            sql = "Select * from " + _nombre;
            resultset = conexion.ejecutarConsulta(sql);
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
        } else if (_nombre.equals("Manchester City")) {
            sql = "Select * from " + _nombre;
            recoger = _nombre.substring(0, 4);
            _nombre = "manchestercity";
            resultset = conexion.ejecutarConsulta(sql);
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
            sql = "Select * from " + _nombre;
            resultset = conexion.ejecutarConsulta(sql);
            recoger = _nombre.substring(0, 3);
            while (resultset.next()) {
                int id = resultset.getInt(recoger + "_id");
                String nombre = resultset.getString(recoger + "_jugador");
                String posicion = resultset.getString(recoger + "_posicion");
                int titular = resultset.getInt("Titular");
                Jugador j = new Jugador(id, nombre, posicion, titular);
                Jlist.add(j);

            }
            Jugadores.setItems(Jlist);
            conexion.cerrarConexion();
        }

    }

    public void getEnfrentamientos() throws SQLException {
        if (partidosTotales.isEmpty()) {
            // Recoger los partidos totales solo si la lista está vacía
            Auxiliares.Conexiones conexion = new Conexiones();
            String sql = "SELECT * FROM enfrentamientos";
            ResultSet resultSet = conexion.ejecutarConsulta(sql);

            while (resultSet.next()) {
                String nombreLocal = resultSet.getString("Local");
                String nombreVisitante = resultSet.getString("Visitante");
                Partidos partido = new Partidos(nombreLocal, nombreVisitante);
                partidosTotales.add(partido);
            }

            conexion.cerrarConexion();
        }
    }

    /**
     * Este metodo devuelve los partidos que tienen que jugarse esa jornada para
     * ello tiene que coger todos los enfrentamientos posibles que puedan pasar
     * almacenarlos en una lista, a continuacion coger un enfrentamiento
     * aleatorio el cual el local es el valor del parametro nombre y luego
     * aleatoriemante cogera 4 enfrentamientos mas para esa jornada
     * almacenandolos en otra lista.
     *
     * @param nombre
     * @throws SQLException
     */
    public void getPartidosTemporada(String nombre) throws SQLException {
        List<Partidos> partidosRestantes = new ArrayList<>(partidosTotales); // Copia de la lista original

        // Obtener todos los enfrentamientos con el nombre local proporcionado
        for (Partidos partido : partidosTotales) {
            if (partido.getLocal().equals(nombre)) {
                enfrentamientosLocales.add(partido);
            }
        }

        Partidos enfrentamientoLocal = null;
        if (!enfrentamientosLocales.isEmpty()) {
            // Seleccionar aleatoriamente un enfrentamiento local
            Random random = new Random();
            enfrentamientoLocal = enfrentamientosLocales.get(random.nextInt(enfrentamientosLocales.size()));
            partidosSeleccionados.add(enfrentamientoLocal);
            partidosRestantes.remove(enfrentamientoLocal); // Utilizamos la lista de partidosRestantes
        }

        Set<String> equiposSeleccionados = new HashSet<>();
        equiposSeleccionados.add(nombre); // Agregar el nombre proporcionado como equipo seleccionado

        Random random = new Random();

        while (partidosSeleccionados.size() < 4 && !partidosRestantes.isEmpty()) {
            int index = random.nextInt(partidosRestantes.size());
            Partidos partidoSeleccionado = partidosRestantes.get(index);

            boolean localRepetido = equiposSeleccionados.contains(partidoSeleccionado.getLocal());
            boolean visitanteRepetido = equiposSeleccionados.contains(partidoSeleccionado.getVisitante());

            if (!localRepetido && !visitanteRepetido) {
                // Verificar si alguno de los equipos ya ha sido seleccionado en instancias previas
                boolean equiposRepetidos = false;
                for (Partidos partido : partidosSeleccionados) {
                    if (partido.getLocal().equals(partidoSeleccionado.getLocal())
                            || partido.getLocal().equals(partidoSeleccionado.getVisitante())
                            || partido.getVisitante().equals(partidoSeleccionado.getLocal())
                            || partido.getVisitante().equals(partidoSeleccionado.getVisitante())) {
                        equiposRepetidos = true;
                        break;
                    }
                }

                if (!equiposRepetidos) {
                    partidosSeleccionados.add(partidoSeleccionado);
                    equiposSeleccionados.add(partidoSeleccionado.getLocal());
                    equiposSeleccionados.add(partidoSeleccionado.getVisitante());
                }
            }

            partidosRestantes.remove(index);

            if (enfrentamientoLocal != null) {
                enfrentamientosLocales.remove(enfrentamientoLocal);
            }
        }

        // Agregar los partidos seleccionados a ListaTemporada
        ListaTemporada.addAll(partidosSeleccionados);
    }

    /**
     * Este metodo sirve para volver a la ventana inicio y e iniciar el juego
     * otra vez o salir de la aplicacion
     *
     * @param event
     */
    @FXML
    private void FuncionMenu(ActionEvent event) throws SQLException {

        Stage myStage = (Stage) this.Iniciar.getScene().getWindow();
        myStage.close();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXML_VentanaInicio.fxml"));
            ChampionsSimulator.ChampionSimulator.limpiarBBDD();
            Parent root = loader.load();
            FXML_VentanaInicioController v = new FXML_VentanaInicioController();
            contadorpartidos = 0;
            convocados = 0;
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.getIcons().add(new Image("/Imagenes/LogoAPP.png"));
            stage.setTitle("ChampionSimulator");
            stage.setResizable(false);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(FXML_VentanaInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Este metodo sirve para pasar cancion al pulsar el boton play
     *
     * @param event
     */
    @FXML
    private void pasarcanción(ActionEvent event) {
        sonido.PararSonido();
        sonido.reset();
        switch (Musica) {
            case "Background":
                Musica = "Background2";
                break;
            case "Background2":
                Musica = "Background3";
                break;
            case "Background3":
                Musica = "Background4";
                break;
            case "Background4":
                Musica = "Background";
                break;
            case "Victoria":
                Musica = "Background";
            default:
                break;
        }

        sonido = ChampionsSimulator.ChampionSimulator.SM.getSonido(Musica);
        sonido.ReproducirSonido();

    }

    /**
     * Este metodo sirve para mutear la musica al tocar el boton correspondiente
     *
     * @param event
     */
    @FXML
    private void mute(ActionEvent event) {
        sonido.PararSonido();
        sonido.reset();

    }

    /**
     * Este metodo sirve para colocar las imagenes de los botones de play y mute
     */
    private void colocarImagenBotones() {
        URL playFoto = getClass().getResource("/Imagenes/Play.png");
        URL muteFoto = getClass().getResource("/Imagenes/Mute.png");

        Image play = new Image(playFoto.toString(), 45, 45, false, true);
        Image mute = new Image(muteFoto.toString(), 45, 45, false, true);

        botonMute.setGraphic(new ImageView(mute));
        botonSiguiente.setGraphic(new ImageView(play));

    }

    /**
     * Este metodo lo que realiza es una con
     *
     * @param event
     * @throws SQLException
     */
    @FXML
    private void Convocar(ActionEvent event) throws SQLException {
        String recoger;
        String ejecucion;
        Conexiones co = new Conexiones();
        TableView.TableViewSelectionModel<Jugador> selectionModel = Jugadores.getSelectionModel();
        Jugador objetoSeleccionado = selectionModel.getSelectedItem();

        if (objetoSeleccionado.getTitular() == 1) {
            //Debido a que algunos tienen mas de tres por que pablo es imbecil he tenido que poner este if
            if (nombre.equals("sporting") || nombre.equals("manchestercity")) {
                recoger = nombre.substring(0, 4);
                ejecucion = "UPDATE " + nombre + " SET Titular = " + 0 + " where " + recoger + "_id = " + objetoSeleccionado.getId();
                co.ejecutarInstruccion(ejecucion);
                getTodosJugadores(nombre);
                convocados--;
              
            } else {
                recoger = nombre.substring(0, 3);
                ejecucion = "UPDATE " + nombre + " SET Titular = " + 0 + " where " + recoger + "_id = " + objetoSeleccionado.getId();
                co.ejecutarInstruccion(ejecucion);
                System.out.println(ejecucion);
                getTodosJugadores(nombre);
                convocados--;
              
            }

        } else {
            if (nombre.equals("sporting") || nombre.equals("manchestercity")) {
                recoger = nombre.substring(0, 4);
                ejecucion = "UPDATE " + nombre + " SET Titular = " + 1 + " where " + recoger + "_id = " + objetoSeleccionado.getId();
                co.ejecutarInstruccion(ejecucion);
                getTodosJugadores(nombre);
                convocados++;
          
            } else {
                recoger = nombre.substring(0, 3);
                ejecucion = "UPDATE " + nombre + " SET Titular = " + 1 + " where " + recoger + "_id = " + objetoSeleccionado.getId();
                co.ejecutarInstruccion(ejecucion);
                getTodosJugadores(nombre);
                convocados++;
           
            }
        }

    }

}
