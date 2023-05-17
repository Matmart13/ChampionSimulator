/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Auxiliares.Conexiones;
import static Controladores.FXML_VistaTemporadaController.Eqlist;
import static Controladores.FXML_VistaTemporadaController.nombre;
import Modelo.Equipo;
import Modelo.Partidos;
import Utiles.HiloTiempo;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
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

/**
 * FXML Controller class
 *
 * @author marti
 */
public class FXML_VentanaPartidoController implements Initializable {

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

    private String nombreEquipo1;
    private int estrellasEquipo1;
    private int estrellasEquipo2;
    ArrayList<Equipo> equiposjugar;
    ArrayList<Partidos> ListaTemporada;
    @FXML
    private Label Temporizador1;
    @FXML
    private TextField TextField;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        equiposjugar = new ArrayList<Equipo>();
        ListaTemporada = new ArrayList<Partidos>();
        try {
            getEquipos(equiposjugar);
            getPartidosTemporada();
        } catch (SQLException ex) {
            Logger.getLogger(FXML_VentanaPartidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image vsFoto = new Image("/Imagenes/v1.png");
        Image fondo = new Image("/Imagenes/FondoPartido.png");
        if (FXML_VistaTemporadaController.nombre.equals("madrid")) {
            equipo1.setImage(RMLogo);

            getVisitante();
        } else if (FXML_VistaTemporadaController.nombre.equals("barcelona")) {
            equipo1.setImage(BarsaLogo);
            getVisitante();
        } else if (FXML_VistaTemporadaController.nombre.equals("bayern")) {
            equipo1.setImage(bayernMunichLogo);
            getVisitante();
        } else if (FXML_VistaTemporadaController.nombre.equals("psg")) {
            equipo1.setImage(PSGLogo);
            getVisitante();
        } else if (FXML_VistaTemporadaController.nombre.equals("lazio")) {
            equipo1.setImage(LazioLogo);
            getVisitante();
        } else if (FXML_VistaTemporadaController.nombre.equals("betis")) {
            equipo1.setImage(BetisLogo);
            getVisitante();
        } else if (FXML_VistaTemporadaController.nombre.equals("sporting")) {
            equipo1.setImage(SportingLogo);
            getVisitante();
        } else if (FXML_VistaTemporadaController.nombre.equals("arsenal")) {
            equipo1.setImage(ArsenalLogo);
            getVisitante();
        } else if (FXML_VistaTemporadaController.nombre.equals("manchestercity")) {
            equipo1.setImage(McityLogo);
            getVisitante();
        } else if (FXML_VistaTemporadaController.nombre.equals("inter")) {
            equipo1.setImage(InterMilanLogo);
            getVisitante();
        }

        /*
                for (int j = 0; j < equiposjugar.size(); j++) {
                    if (equiposjugar.get(j).getNombre().equals(visitante)) {
                        // equiposjugar.get(j).getNombre().equals(visitante
                    }
                    if (equiposjugar.get(j).getNombre().equals(visitante)) {

                    }
                  
                }
         */
        vs.setImage(vsFoto);
        fondoPartido.setImage(fondo);
        HiloTiempo ht = new HiloTiempo(Temporizador);
        ht.start();

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

    public void getPartidosTemporada() throws SQLException {
        Auxiliares.Conexiones conexion = new Conexiones();
        String sql = "Select * from enfrentamientos";
        ResultSet resultset = conexion.ejecutarConsulta(sql);
        while (resultset.next()) {
            String nombre = resultset.getString("Local");
            String nombre2 = resultset.getString("Visitante");
            Partidos l = new Partidos(nombre, nombre2);
            ListaTemporada.add(l);
        }
        conexion.cerrarConexion();
    }

    public void getVisitante() {
        for (int i = 0; i < ListaTemporada.size(); i++) {
            if (ListaTemporada.get(i).getLocal().equals(FXML_VistaTemporadaController.nombre) == true) {
                visitante = ListaTemporada.get(i).getVisitante().toString();
                if (visitante.equals("madrid")) {
                    equipo2.setImage(RMLogo);
                   

                } else if (visitante.equals("barcelona")) {
                    equipo2.setImage(BarsaLogo);
                } else if (visitante.equals("bayern")) {
                    equipo2.setImage(bayernMunichLogo);
                } else if (visitante.equals("psg")) {
                    equipo2.setImage(PSGLogo);

                } else if (visitante.equals("lazio")) {
                    equipo2.setImage(LazioLogo);

                } else if (visitante.equals("betis")) {
                    equipo2.setImage(BetisLogo);

                } else if (visitante.equals("sporting")) {
                    equipo2.setImage(SportingLogo);

                } else if (visitante.equals("arsenal")) {
                    equipo2.setImage(ArsenalLogo);

                }
                if (visitante.equals("manchestercity")) {
                    equipo2.setImage(McityLogo);

                }
                if (visitante.equals("inter")) {
                    equipo2.setImage(InterMilanLogo);

                }
            }
        }
    }

    public void getEstrellasEquipos() {
        for (int i = 0; i < ListaTemporada.size(); i++) {
            if (ListaTemporada.get(i).getVisitante().equals(visitante) == true) {
                   for (int j = 0; j < Eqlist.size() ; j++) {
                       if(Eqlist.get(i).getNombre().equals(visitante)){
                           estrellasEquipo2 = Eqlist.get(i).getEstrellas();
                       }
                }
            }
            if(ListaTemporada.get(i).getLocal().equals(nombre) == true){
                for (int j = 0; j < Eqlist.size(); j++) {
                    if(Eqlist.get(i).getNombre().equals(nombre)){
                           estrellasEquipo1 = Eqlist.get(i).getEstrellas();
                       }
                }
            }
        }
    }

}
