/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Equipo;
import Utiles.HiloTiempo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
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
    private TextArea textField;
    @FXML
    private Label marcadorEq2;
    @FXML
    private ImageView equipo2;
    @FXML
    private Label marcadorEq1;
    @FXML
    private Label Temporizador;
    
    private String nombreEquipo1;
    private String nombreEquipo2;
    private int estrellasEquipo1;
    private int estrellasEquipo2;
    int jornada;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Image vsFoto= new Image("/Imagenes/v1.png");
        Image fondo= new Image("/Imagenes/FondoPartido.png");
        
        
        
        vs.setImage(vsFoto);
        fondoPartido.setImage(fondo);
        HiloTiempo ht = new HiloTiempo(Temporizador);
        ht.start();
        
    }
    
    
    
    
    public void recibirEquipos(Equipo _equipo1,Equipo _equipo2, ImageView _imagen1, ImageView _imagen2,int _jornada){
        this.nombreEquipo1 = _equipo1.getNombre();
        this.estrellasEquipo1 = _equipo1.getEstrellas();
        
        this.nombreEquipo2 = _equipo2.getNombre();
        this.estrellasEquipo2  = _equipo2.getEstrellas();
        
        this.equipo1 = _imagen1;
        this.equipo2 = _imagen2;
        this.jornada = _jornada;
    }
    

}
