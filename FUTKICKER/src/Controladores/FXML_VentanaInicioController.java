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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author pablo
 */
public class FXML_VentanaInicioController implements Initializable {

    @FXML
    private ImageView fondoImagen;
    @FXML
    private Button botonInicio;
    @FXML
    private Button botonCargar;
    @FXML
    private Button botonSalir;
    @FXML
    private ImageView Logo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Image fondo= new Image("/Imagenes/FONDO.gif");
        Image logo= new Image("/Imagenes/Logo.png");
        fondoImagen.setImage(fondo);
        Logo.setImage(logo);
        
    }    

    @FXML
    private void botonInicioClick(ActionEvent event) {
         
          /* Pantalla p = new Pantalla();
        p.setVisible(true);
        dispose();
            */
      
         
         
         
        
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
