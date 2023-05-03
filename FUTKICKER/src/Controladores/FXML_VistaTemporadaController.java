/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author marti
 */
public class FXML_VistaTemporadaController implements Initializable {
    String nombre;
    @FXML
    private ImageView Logo;
    @FXML
    private ImageView EscudoEquipo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    

    public FXML_VistaTemporadaController(String _nombre) {
        this.nombre = _nombre;
    }
    
    
    
    
}
