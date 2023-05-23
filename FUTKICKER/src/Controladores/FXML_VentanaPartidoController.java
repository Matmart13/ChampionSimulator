/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Auxiliares.Conexiones;
import Auxiliares.Sonido;
import Auxiliares.SonidoManager;
import static Controladores.FXML_VistaTemporadaController.Eqlist;
import static Controladores.FXML_VistaTemporadaController.ListaTemporada;
import static Controladores.FXML_VistaTemporadaController.nombre;
import Modelo.Equipo;
import Modelo.Partidos;
import Utiles.HiloPartido;
import Utiles.HiloTiempo;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author marti
 */
public class FXML_VentanaPartidoController extends Thread implements Initializable {

    @FXML
    private ImageView vs;
    @FXML
    private ImageView fondoPartido;
    @FXML
    private ImageView equipo1;

    @FXML
    private Label marcadorEq2;
    @FXML
    private ImageView equipo2;
    @FXML
    private Label marcadorEq1;
    @FXML
    private Label Temporizador;

    String nombreEquipo1;
    static int estrellasEquipo1;
    static int estrellasEquipo2;
    ArrayList<Equipo> equiposjugar;

    ArrayList<Partidos> EquiposSecun;
    @FXML
    private Label Temporizador1;
    private TextField texto;
    String visitante;
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
    @FXML
    private TextField TextField;
    public static HiloTiempo ht;
   public static HiloPartido hp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        equiposjugar = new ArrayList<Equipo>();
        EquiposSecun = new ArrayList<Partidos>();
        marcadorEq1 = new Label();
        marcadorEq2 = new Label();
        texto = new TextField();
        SonidoManager b = SonidoManager.getInstance();
        Sonido background = b.getSonido("Background");
        background.PararSonido();
        ht = new HiloTiempo(Temporizador);
        hp = new HiloPartido(estrellasEquipo1, estrellasEquipo2, marcadorEq1, marcadorEq2, ht);
        
 

        try {
            getEquipos(equiposjugar);

            //  recogerPartidosNoPrincipal();
        } catch (SQLException ex) {
            Logger.getLogger(FXML_VentanaPartidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image vsFoto = new Image("/Imagenes/v1.png");
        Image fondo = new Image("/Imagenes/FondoPartido.png", 1100, 800, false, true);

        vs.setImage(vsFoto);
        fondoPartido.setImage(fondo);
        if (FXML_VistaTemporadaController.nombre.equals("madrid")) {
            equipo1.setImage(RMLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            cambioVisitante();
            ht.start();
            hp.start();
        } else if (FXML_VistaTemporadaController.nombre.equals("barcelona")) {
            equipo1.setImage(BarsaLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            ht.start();
            hp.start();
        } else if (FXML_VistaTemporadaController.nombre.equals("bayern")) {
            equipo1.setImage(bayernMunichLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            cambioVisitante();
            ht.start();
            hp.start();
        } else if (FXML_VistaTemporadaController.nombre.equals("psg")) {
            equipo1.setImage(PSGLogo);
            getVisitante();
            getEstrellasEquipos();
            ht.start();
            hp.start();
        } else if (FXML_VistaTemporadaController.nombre.equals("lazio")) {
            equipo1.setImage(LazioLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            cambioVisitante();
            ht.start();
            hp.start();
        } else if (FXML_VistaTemporadaController.nombre.equals("betis")) {
            equipo1.setImage(BetisLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            cambioVisitante();
            ht.start();
            hp.start();
        } else if (FXML_VistaTemporadaController.nombre.equals("sporting")) {
            equipo1.setImage(SportingLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            ht.start();
            hp.start();
        } else if (FXML_VistaTemporadaController.nombre.equals("arsenal")) {
            equipo1.setImage(ArsenalLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            cambioVisitante();
            ht.start();
            hp.start();
        } else if (FXML_VistaTemporadaController.nombre.equals("manchestercity")) {
            equipo1.setImage(McityLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            cambioVisitante();
            ht.start();
            hp.start();
        } else if (FXML_VistaTemporadaController.nombre.equals("inter")) {
            equipo1.setImage(InterMilanLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            cambioVisitante();
            ht.start();
            hp.start();
        }

    }

    public void getEquipos(ArrayList<Equipo> lista) throws SQLException {
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
            equiposjugar.add(l);
        }

        conexion.cerrarConexion();
    }

    public void getVisitante() {
        for (int i = 0; i < ListaTemporada.size(); i++) {
            if (ListaTemporada.get(i).getLocal().equals(FXML_VistaTemporadaController.nombre) == true) {
                visitante = ListaTemporada.get(i).getVisitante();

                if (visitante.equals("madrid")) {
                    equipo2.setImage(RMLogo);
                    cambioVisitante();
                    for (int v = 0; v < equiposjugar.size(); v++) {
                        if (equiposjugar.get(v).getNombre().equals(visitante) == true) {
                            estrellasEquipo2 = Eqlist.get(v).getEstrellas();
                        }
                    }
                } else if (visitante.equals("barcelona")) {
                    equipo2.setImage(BarsaLogo);

                    cambioVisitante();
                    for (int v = 0; v < equiposjugar.size(); v++) {
                        if (equiposjugar.get(v).getNombre().equals(visitante) == true) {
                            estrellasEquipo2 = Eqlist.get(v).getEstrellas();
                        }
                    }
                } else if (visitante.equals("bayern")) {
                    equipo2.setImage(bayernMunichLogo);

                    cambioVisitante();
                    for (int v = 0; v < equiposjugar.size(); v++) {
                        if (equiposjugar.get(v).getNombre().equals(visitante) == true) {
                            estrellasEquipo2 = Eqlist.get(v).getEstrellas();
                        }
                    }
                } else if (visitante.equals("psg")) {
                    equipo2.setImage(PSGLogo);

                    cambioVisitante();
                    for (int v = 0; v < equiposjugar.size(); v++) {
                        if (equiposjugar.get(v).getNombre().equals(visitante) == true) {
                            estrellasEquipo2 = Eqlist.get(v).getEstrellas();
                        }
                    }
                } else if (visitante.equals("lazio")) {
                    equipo2.setImage(LazioLogo);

                    cambioVisitante();
                    for (int v = 0; v < equiposjugar.size(); v++) {
                        if (equiposjugar.get(v).getNombre().equals(visitante) == true) {
                            estrellasEquipo2 = Eqlist.get(v).getEstrellas();
                        }
                    }
                } else if (visitante.equals("betis")) {
                    equipo2.setImage(BetisLogo);
                    cambioVisitante();
                    for (int v = 0; v < equiposjugar.size(); v++) {
                        if (equiposjugar.get(v).getNombre().equals(visitante) == true) {
                            estrellasEquipo2 = Eqlist.get(v).getEstrellas();
                        }
                    }
                } else if (visitante.equals("sporting")) {

                    equipo2.setImage(SportingLogo);
                    cambioVisitante();
                    for (int v = 0; v < equiposjugar.size(); v++) {
                        if (equiposjugar.get(v).getNombre().equals(visitante) == true) {
                            estrellasEquipo2 = Eqlist.get(v).getEstrellas();
                        }
                    }
                } else if (visitante.equals("arsenal")) {
                    equipo2.setImage(ArsenalLogo);

                    cambioVisitante();
                    for (int v = 0; v < equiposjugar.size(); v++) {
                        if (equiposjugar.get(v).getNombre().equals(visitante) == true) {
                            estrellasEquipo2 = Eqlist.get(v).getEstrellas();
                        }
                    }
                } else if (visitante.equals("manchestercity")) {
                    equipo2.setImage(McityLogo);

                    cambioVisitante();
                    for (int v = 0; v < equiposjugar.size(); v++) {
                        if (equiposjugar.get(v).getNombre().equals(visitante) == true) {
                            estrellasEquipo2 = Eqlist.get(v).getEstrellas();
                        }
                    }
                } else if (visitante.equals("inter")) {
                    equipo2.setImage(InterMilanLogo);

                    cambioVisitante();
                    for (int v = 0; v < equiposjugar.size(); v++) {
                        if (equiposjugar.get(v).getNombre().equals(visitante) == true) {
                            estrellasEquipo2 = Eqlist.get(v).getEstrellas();
                        }
                    }
                }
            }
        }

    }

    public void getEstrellasEquipos() {
        for (int i = 0; i < ListaTemporada.size(); i++) {
            if (ListaTemporada.get(i).getLocal().equals(FXML_VistaTemporadaController.nombre) == true) {
                visitante = ListaTemporada.get(i).getVisitante();

                for (int j = 0; j < equiposjugar.size(); j++) {
                    if (ListaTemporada.get(j).getLocal().equals(nombre) == true) {
                        estrellasEquipo1 = equiposjugar.get(j).getEstrellas();
                        break;
                    }
                }
                for (int v = 0; v < ListaTemporada.size(); v++) {
                    if (ListaTemporada.get(v).getVisitante().equals(visitante) == true) {
                        estrellasEquipo2 = equiposjugar.get(v).getEstrellas();
                        break;
                    }
                }

            }
        }
    }

    public void cambioNombre() {
        switch (nombre) {
            case "madrid":
                nombre = "Real Madrid";
                break;
            case "barcelona":
                nombre = "Barcelona";
                break;
            case "manchestercity":
                nombre = "Manchester City";
                break;
            case "arsenal":
                nombre = "Arsenal";
                break;
            case "bayern":
                nombre = "Bayern Munich";
                break;
            case "betis":
                nombre = "Real Betis";
                break;
            case "lazio":
                nombre = "Lazio";
                break;
            case "sporting":
                nombre = "Sporting de Gijon";
                break;
            case "psg":
                nombre = "PSG";
                break;
            case "inter":
                nombre = "Inter de Milan";
                break;
            default:
                break;
        }
    }

    public void cambioVisitante() {
        switch (visitante) {
            case "madrid":
                visitante = "Real Madrid";
                break;
            case "barcelona":
                visitante = "Barcelona";
                break;
            case "manchestercity":
                visitante = "Manchester City";
                break;
            case "arsenal":
                visitante = "Arsenal";
                break;
            case "bayern":
                visitante = "Bayern Munich";
                break;
            case "betis":
                visitante = "Real Betis";
                break;
            case "lazio":
                visitante = "Lazio";
                break;
            case "sporting":
                visitante = "Sporting de Gijon";
                break;
            case "psg":
                visitante = "PSG";
                break;
            case "inter":
                visitante = "Inter de Milan";
                break;
            default:
                System.out.println("No existe el equipo");
                break;
        }
    }
}
