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
    static String visitante;
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
        try {
            getEquipos(equiposjugar);

            //  recogerPartidosNoPrincipal();
        } catch (SQLException ex) {
            Logger.getLogger(FXML_VentanaPartidoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        Image vsFoto = new Image("/Imagenes/v1.png");
        Image fondo = new Image("/Imagenes/FondoPartido.png");

        vs.setImage(vsFoto);
        fondoPartido.setImage(fondo);
        if (FXML_VistaTemporadaController.nombre.equals("madrid")) {
            equipo1.setImage(RMLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            cambioVisitante();
            realizarPartidoPrincipal();
        } else if (FXML_VistaTemporadaController.nombre.equals("barcelona")) {
            equipo1.setImage(BarsaLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            cambioVisitante();
            realizarPartidoPrincipal();
        } else if (FXML_VistaTemporadaController.nombre.equals("bayern")) {
            equipo1.setImage(bayernMunichLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            cambioVisitante();
            realizarPartidoPrincipal();
        } else if (FXML_VistaTemporadaController.nombre.equals("psg")) {
            equipo1.setImage(PSGLogo);
            getVisitante();
            getEstrellasEquipos();
            realizarPartidoPrincipal();
        } else if (FXML_VistaTemporadaController.nombre.equals("lazio")) {
            equipo1.setImage(LazioLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            cambioVisitante();
            realizarPartidoPrincipal();
        } else if (FXML_VistaTemporadaController.nombre.equals("betis")) {
            equipo1.setImage(BetisLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            cambioVisitante();
            realizarPartidoPrincipal();
        } else if (FXML_VistaTemporadaController.nombre.equals("sporting")) {
            equipo1.setImage(SportingLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            cambioVisitante();
            realizarPartidoPrincipal();
        } else if (FXML_VistaTemporadaController.nombre.equals("arsenal")) {
            equipo1.setImage(ArsenalLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            cambioVisitante();
            realizarPartidoPrincipal();
        } else if (FXML_VistaTemporadaController.nombre.equals("manchestercity")) {
            equipo1.setImage(McityLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            cambioVisitante();
            realizarPartidoPrincipal();
        } else if (FXML_VistaTemporadaController.nombre.equals("inter")) {
            equipo1.setImage(InterMilanLogo);
            getVisitante();
            getEstrellasEquipos();
            cambioNombre();
            cambioVisitante();
            realizarPartidoPrincipal();
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
                    for (int v = 0; v < equiposjugar.size(); v++) {
                        if (equiposjugar.get(v).getNombre().equals(visitante) == true) {
                            estrellasEquipo2 = Eqlist.get(v).getEstrellas();
                        }
                    }
                } else if (visitante.equals("barcelona")) {
                    equipo2.setImage(BarsaLogo);
                    for (int v = 0; v < equiposjugar.size(); v++) {
                        if (equiposjugar.get(v).getNombre().equals(visitante) == true) {
                            estrellasEquipo2 = Eqlist.get(v).getEstrellas();
                        }
                    }
                } else if (visitante.equals("bayern")) {
                    equipo2.setImage(bayernMunichLogo);
                    for (int v = 0; v < equiposjugar.size(); v++) {
                        if (equiposjugar.get(v).getNombre().equals(visitante) == true) {
                            estrellasEquipo2 = Eqlist.get(v).getEstrellas();
                        }
                    }
                } else if (visitante.equals("psg")) {
                    equipo2.setImage(PSGLogo);
                    for (int v = 0; v < equiposjugar.size(); v++) {
                        if (equiposjugar.get(v).getNombre().equals(visitante) == true) {
                            estrellasEquipo2 = Eqlist.get(v).getEstrellas();
                        }
                    }
                } else if (visitante.equals("lazio")) {
                    equipo2.setImage(LazioLogo);
                    for (int v = 0; v < equiposjugar.size(); v++) {
                        if (equiposjugar.get(v).getNombre().equals(visitante) == true) {
                            estrellasEquipo2 = Eqlist.get(v).getEstrellas();
                        }
                    }
                } else if (visitante.equals("betis")) {
                    equipo2.setImage(BetisLogo);
                    for (int v = 0; v < equiposjugar.size(); v++) {
                        if (equiposjugar.get(v).getNombre().equals(visitante) == true) {
                            estrellasEquipo2 = Eqlist.get(v).getEstrellas();
                        }
                    }
                } else if (visitante.equals("sporting")) {
                    equipo2.setImage(SportingLogo);
                    for (int v = 0; v < equiposjugar.size(); v++) {
                        if (equiposjugar.get(v).getNombre().equals(visitante) == true) {
                            estrellasEquipo2 = Eqlist.get(v).getEstrellas();
                        }
                    }
                } else if (visitante.equals("arsenal")) {
                    equipo2.setImage(ArsenalLogo);
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

    public void realizarPartidoPrincipal() {
        int duracionPartido = 90; // Duración del partido en minutos

        // Obtener los equipos del partido principal
        Equipo equipoLocal = null;
        Equipo equipoVisitante = null;

        for (int i = 0; i < equiposjugar.size(); i++) {
            if (equiposjugar.get(i).getNombre().equals(nombre)) {
                equipoLocal = equiposjugar.get(i);
            } else if (equiposjugar.get(i).getNombre().equals(visitante)) {
                equipoVisitante = equiposjugar.get(i);
            }
        }

        if (equipoLocal == null || equipoVisitante == null) {
            // No se encontraron los equipos, mostrar un mensaje de error o realizar alguna acción adecuada
            return;
        }
        String nombreL = equipoLocal.getNombre();
        final String nombreLocal = nombreL;
        String nombreV = equipoVisitante.getNombre();
        final String nombreVisitante = nombreV;
        AtomicInteger golesLocal = new AtomicInteger(0);
        AtomicInteger golesVisitante = new AtomicInteger(0);
// Calcular las probabilidades de gol para cada equipo según las estrellas
        int diferenciaEstrellas = equipoLocal.getEstrellas() - equipoVisitante.getEstrellas();
        double factorProbabilidad = 0.02; // Factor de ajuste para las probabilidades de gol

        final double probabilidadLocal;
        final double probabilidadVisitante;

        if (diferenciaEstrellas > 0) {
            probabilidadLocal = 0.5 + (diferenciaEstrellas * factorProbabilidad);
            probabilidadVisitante = 0.5 - (diferenciaEstrellas * factorProbabilidad);
        } else if (diferenciaEstrellas < 0) {
            probabilidadLocal = 0.5 - (Math.abs(diferenciaEstrellas) * factorProbabilidad);
            probabilidadVisitante = 0.5 + (Math.abs(diferenciaEstrellas) * factorProbabilidad);
        } else {
            probabilidadLocal = 0.5;
            probabilidadVisitante = 0.5;
        }

// Crear el objeto de bloqueo
        Object lock = new Object(); // Objeto de bloqueo compartido entre los hilos

// Hilo para el tiempo
        HiloTiempo hiloTiempo = new HiloTiempo(Temporizador, lock);
        hiloTiempo.start();
        final Timeline golesTimeline = new Timeline(); // Declarar la variable final

        golesTimeline.getKeyFrames().add(new KeyFrame(Duration.seconds(1), event -> {
            synchronized (lock) {
                int tiempoTranscurrido = hiloTiempo.getTiempoTranscurrido(); // Obtener el tiempo transcurrido del hilo de tiempo

                if (tiempoTranscurrido < duracionPartido) {
                    // Simular el avance del partido y generación de goles (puedes adaptar esta lógica según tus necesidades)
                    final boolean finalGolLocal;
                    final boolean finalGolVisitante;

                    if (diferenciaEstrellas > 0) {
                        double probabilidadLocalAjustada = probabilidadLocal + (diferenciaEstrellas * factorProbabilidad);
                        double probabilidadVisitanteAjustada = probabilidadVisitante - (diferenciaEstrellas * factorProbabilidad);
                        finalGolLocal = Math.random() < probabilidadLocalAjustada;
                        finalGolVisitante = Math.random() < probabilidadVisitanteAjustada;
                    } else if (diferenciaEstrellas < 0) {
                        double probabilidadLocalAjustada = probabilidadLocal - (Math.abs(diferenciaEstrellas) * factorProbabilidad);
                        double probabilidadVisitanteAjustada = probabilidadVisitante + (Math.abs(diferenciaEstrellas) * factorProbabilidad);
                        finalGolLocal = Math.random() < probabilidadLocalAjustada;
                        finalGolVisitante = Math.random() < probabilidadVisitanteAjustada;
                    } else {
                        finalGolLocal = Math.random() < probabilidadLocal;
                        finalGolVisitante = Math.random() < probabilidadVisitante;
                    }
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if (finalGolLocal) {
                                int goleslocal = golesLocal.incrementAndGet();
                                marcadorEq1.setText(Integer.toString(goleslocal));
                                texto.appendText("¡Gol! " + nombreLocal + "\n");
                            } else {
                                texto.appendText("... " + nombreLocal + " jugada\n");
                            }

                            if (finalGolVisitante) {
                                int golesvisitante = golesVisitante.incrementAndGet();
                                marcadorEq2.setText(Integer.toString(golesvisitante));
                                texto.appendText("¡Gol! " + nombreVisitante + "\n");
                            } else {
                                texto.appendText("... " + nombreVisitante + " jugada\n");
                            }
                        }
                    });
                } else {
                    golesTimeline.pause(); // Pausar el timeline una vez que se haya alcanzado la duración del partido
                }
            }
        }));

        golesTimeline.setCycleCount(Timeline.INDEFINITE); // Repetir el timeline indefinidamente hasta que se detenga explícitamente

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
                nombre = "Manchester City";
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
                visitante = "Manchester City";
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
