/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pablo
 */
public class InicioController implements Initializable {

    @FXML
    private ImageView fondoImagen;
    @FXML
    private Button botonInicio;
    @FXML
    private Button botonCargar;
    @FXML
    private Button botonSalir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void botonInicioClick(ActionEvent event) {
    }

    @FXML
    private void botonCargarClick(ActionEvent event) {
    }

    @FXML
    private void botonSalirClick(ActionEvent event) {
        Stage myStage = (Stage) this.botonSalir.getScene().getWindow();
        myStage.close();
        
    }
    
}
