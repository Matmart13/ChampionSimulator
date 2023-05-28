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
 * @author martín y pablo
 */
public class FXML_VentanaPartidoController extends Thread implements Initializable {

    @FXML
    private ImageView vs;
    @FXML
    private ImageView fondoPartido;
    @FXML
    private ImageView equipo1;

    @FXML
    private ImageView equipo2;
    @FXML
    private Label Temporizador;

    String nombreEquipo1;
    int estrellasEquipo1;
    int estrellasEquipo2;
    int numvisitante = 0;
    ArrayList<Equipo> equiposjugar;

    ArrayList<Partidos> EquiposSecun;
    @FXML
    private Label Temporizador1;

    public static String visitante;
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
    public HiloTiempo ht;
    public HiloPartido hp;
    @FXML
    private TextArea Texto;

    @FXML
    private Label marcadorEquipo2;
    @FXML
    private Label marcadorEquipo1;

    /**
     * Sirve para sincronizar los hilos de esta ventana
     */
    @Override
    public synchronized void start() {
        super.start(); //To change body of generated methods, choose Tools | Templates.

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        equiposjugar = new ArrayList<Equipo>();
        EquiposSecun = new ArrayList<Partidos>();
        SonidoManager b = SonidoManager.getInstance();
        Sonido background = b.getSonido("Background");
        background.PararSonido();

        try {
            getEquipos(equiposjugar);
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
            ht = new HiloTiempo(Temporizador);
            hp = new HiloPartido(estrellasEquipo1, estrellasEquipo2, marcadorEquipo1, marcadorEquipo2, ht, Texto);
            ht.start();
            hp.start();
        } else if (FXML_VistaTemporadaController.nombre.equals("barcelona")) {
            equipo1.setImage(BarsaLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            ht = new HiloTiempo(Temporizador);
            hp = new HiloPartido(estrellasEquipo1, estrellasEquipo2, marcadorEquipo1, marcadorEquipo2, ht, Texto);
            ht.start();
            hp.start();

        } else if (FXML_VistaTemporadaController.nombre.equals("bayern")) {
            equipo1.setImage(bayernMunichLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            ht = new HiloTiempo(Temporizador);
            hp = new HiloPartido(estrellasEquipo1, estrellasEquipo2, marcadorEquipo1, marcadorEquipo2, ht, Texto);
            ht.start();
            hp.start();
        } else if (FXML_VistaTemporadaController.nombre.equals("psg")) {
            equipo1.setImage(PSGLogo);
            getVisitante();
            getEstrellasEquipos();
            ht = new HiloTiempo(Temporizador);
            hp = new HiloPartido(estrellasEquipo1, estrellasEquipo2, marcadorEquipo1, marcadorEquipo2, ht, Texto); 
            ht.start();
            hp.start();
        } else if (FXML_VistaTemporadaController.nombre.equals("lazio")) {
            equipo1.setImage(LazioLogo);
            getVisitante();
            getEstrellasEquipos();
            ht = new HiloTiempo(Temporizador);
            hp = new HiloPartido(estrellasEquipo1, estrellasEquipo2, marcadorEquipo1, marcadorEquipo2, ht, Texto);
            ht.start();
            hp.start();
        } else if (FXML_VistaTemporadaController.nombre.equals("betis")) {
            equipo1.setImage(BetisLogo);
            getVisitante();
            getEstrellasEquipos();
            ht = new HiloTiempo(Temporizador);
            hp = new HiloPartido(estrellasEquipo1, estrellasEquipo2, marcadorEquipo1, marcadorEquipo2, ht, Texto);
            ht.start();
            hp.start();
        } else if (FXML_VistaTemporadaController.nombre.equals("sporting")) {
            equipo1.setImage(SportingLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            ht = new HiloTiempo(Temporizador);
            hp = new HiloPartido(estrellasEquipo1, estrellasEquipo2, marcadorEquipo1, marcadorEquipo2, ht, Texto);
            ht.start();
            hp.start();
        } else if (FXML_VistaTemporadaController.nombre.equals("arsenal")) {
            equipo1.setImage(ArsenalLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            ht = new HiloTiempo(Temporizador);
            hp = new HiloPartido(estrellasEquipo1, estrellasEquipo2, marcadorEquipo1, marcadorEquipo2, ht, Texto);
            ht.start();
            hp.start();
        } else if (FXML_VistaTemporadaController.nombre.equals("manchestercity")) {
            equipo1.setImage(McityLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            ht = new HiloTiempo(Temporizador);
            hp = new HiloPartido(estrellasEquipo1, estrellasEquipo2, marcadorEquipo1, marcadorEquipo2, ht, Texto);
            ht.start();
            hp.start();
            
        } else if (FXML_VistaTemporadaController.nombre.equals("inter")) {
            equipo1.setImage(InterMilanLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            ht = new HiloTiempo(Temporizador);
            hp = new HiloPartido(estrellasEquipo1, estrellasEquipo2, marcadorEquipo1, marcadorEquipo2, ht, Texto);
            ht.start();
            hp.start();
            
        }
    }
    /**
     * Este metodo realiza una consulta a la tabla equipos para recoger toda la informacion de todos los campos que contiene
     * esta tabla y agregarlos a un Arraylist que se le pasa por parametro
     * @param lista
     * @throws SQLException 
     */
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
    /**
     * Este metodo sirve para recibir el visitante aleatorio que tiene que jugar contra nuestro equipo recoger sus estrellas y mostrar 
     * su escudo en la pantalla.
     */
    public void getVisitante() {
        for (int i = 0; i < ListaTemporada.size(); i++) {
            if (ListaTemporada.get(i).getLocal().equals(FXML_VistaTemporadaController.nombre) == true) {
                visitante = ListaTemporada.get(numvisitante).getVisitante();
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
        numvisitante ++;
    }
    /**
     * Este metodo sirve para recoger las estrellas de los equipos tanto local como visitante.
     */
    public void getEstrellasEquipos() {
        for (int i = 0; i < ListaTemporada.size(); i++) {
            if (ListaTemporada.get(i).getLocal().equals(FXML_VistaTemporadaController.nombre) == true) {
                visitante = ListaTemporada.get(numvisitante).getVisitante();

                for (int j = 0; j < ListaTemporada.size(); j++) {
                    if (ListaTemporada.get(j).getLocal().equals(nombre) == true) {
                        for (int k = 0; k < equiposjugar.size(); k++) {
                            cambioNombre();
                            if (equiposjugar.get(k).getNombre().equals(nombre) == true) {
                                estrellasEquipo1 = equiposjugar.get(k).getEstrellas();
                                break;
                            }
                        }

                    }
                }
                for (int v = 0; v < ListaTemporada.size(); v++) {
                    if (ListaTemporada.get(v).getVisitante().equals(visitante) == true) {
                        for (int k = 0; k < equiposjugar.size(); k++) {
                            cambioVisitante();
                            if (equiposjugar.get(k).getNombre().equals(visitante) == true) {
                                estrellasEquipo2 = equiposjugar.get(k).getEstrellas();
                                break;
                            }
                        }
                    }

                }
            }
        }
    }
    /**
     * Sirve para cambiar el valor de la variable nombre
     */
    public void cambioNombre() {
        switch (nombre) {
            case "madrid":
                nombre = "Real Madrid";
                break;
            case "barcelona":
                nombre = "Barcelona";
                break;
            case "manchester city":
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
    /**
     * Sirve para cambiar el valor de la variable visitante
     */
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
    /**
     * Sirve para ir cambiando los label de valor  segun van marcando goles los equipos.
     */
    public void setGOLESPARTIDO(){
         for (int i = 0; i < ListaTemporada.size(); i++) {
            if (ListaTemporada.get(i).getLocal().equals(FXML_VistaTemporadaController.nombre) == true) {
         

                for (int j = 0; j < ListaTemporada.size(); j++) {
                    if (ListaTemporada.get(j).getLocal().equals(nombre) == true) {
                        for (int k = 0; k < equiposjugar.size(); k++) {
                            cambioNombre();
                            if (equiposjugar.get(k).getNombre().equals(nombre) == true) {
                              equiposjugar.get(k).setGoles(Integer.valueOf(marcadorEquipo1.getText()));
                                break;
                            }
                        }

                    }
                }
                for (int v = 0; v < ListaTemporada.size(); v++) {
                    if (ListaTemporada.get(v).getVisitante().equals(visitante) == true) {
                        for (int k = 0; k < equiposjugar.size(); k++) {
                            cambioVisitante();
                            if (equiposjugar.get(k).getNombre().equals(visitante) == true) {
                                  equiposjugar.get(k).setGoles(Integer.valueOf(marcadorEquipo1.getText()));
                                break;
                            }
                        }
                    }

                }
            }
        }
    }
    
        

    
    
    
    
}
