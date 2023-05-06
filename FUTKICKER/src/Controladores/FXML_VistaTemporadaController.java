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
import java.sql.ResultSet;
import java.sql.SQLException;
import Modelo.Equipo;
import Modelo.Jugador;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        } catch (SQLException ex) {
            Logger.getLogger(FXML_VistaTemporadaController.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
       
       
       
    }    

    public FXML_VistaTemporadaController() {
        
    }
    
    
    public void recibirParametro(String parametro){
           this.nombre=parametro;
            if(nombre.equals("madrid") == true){
             try {
                 getTodosJugadores(nombre);
                 
             } catch (SQLException ex) {
                 Logger.getLogger(FXML_VistaTemporadaController.class.getName()).log(Level.SEVERE, null, ex);
             }
            Image Madrid = new Image("/Imagenes/Madrid.gif",80,80,false,true);
            EscudoEquipo.setImage(Madrid);   
        }
    }
    /**
     * Devuelve la tabla equipos que sera la tabla que tendra la clasificación de esta liga
     * @throws SQLException 
     */
    public void getTodosEquipos() throws SQLException{
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
     * Este metodo devuelve todos los jugadores correspondientes del equipo que ha seleccionado el jugador
     * @param _nombre
     * @throws SQLException 
     */
    public void getTodosJugadores(String _nombre) throws SQLException{
          ObservableList<Jugador> Jlist = FXCollections.observableArrayList();
          Auxiliares.Conexiones conexion = new Conexiones();
          String sql = "Select * from "+_nombre;
          //subString para sacar las tres primeras letras de cada equipo para sacar el nombre completo que hay que pasar 
          String recoger;
          //Debido a que algunos tienen mas de tres por que pablo es imbecil he tenido que poner este if
           ResultSet resultset = conexion.ejecutarConsulta(sql);
          if(_nombre.equals("sporting")|| _nombre.equals("mancity")){
              recoger = _nombre.substring(0,3);
               while (resultset.next()) {
               int id = resultset.getInt(recoger+"_id");
               String nombre = resultset.getString(recoger+"_jugador");
               String posicion = resultset.getString(recoger+"_posicion");
               int titularidad = resultset.getInt("Titular");
               Jugador j = new Jugador(id, _nombre, posicion, titularidad);
               Jlist.add(j);
               this.Jugadores.setItems(Jlist);
                conexion.cerrarConexion();
            }
          }else{
              recoger = _nombre.substring(0,3);
          
           while (resultset.next()) {
               int id = resultset.getInt(recoger+"_id");
               String nombre = resultset.getString(recoger+"_jugador");
               String posicion = resultset.getString(recoger+"_posicion");
               int titularidad = resultset.getInt("Titular");
               Jugador j = new Jugador(id, _nombre, posicion, titularidad);
               Jlist.add(j);
               this.Jugadores.setItems(Jlist);
               conexion.cerrarConexion();
            }

          }
        
           
    }
    
    
    
}
