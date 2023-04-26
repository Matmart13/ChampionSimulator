/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author marti
 */
public class FXML_VentanaElegirController implements Initializable {

    @FXML
    private Button RealM;
    @FXML
    private Button SPORT;
    @FXML
    private Button INTER;
    @FXML
    private Button BARSA;
    @FXML
    private Button ARSENAL;
    @FXML
    private Button LAZIO;
    @FXML
    private Button BETIS;
    @FXML
    private Button PSG;
    @FXML
    private Button CITY;
    @FXML
    private Button BAYERN;
    @FXML
    private ImageView titulo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
             Image ArsenalLogo= new Image("/Imagenes/Arsenal_FC.png",48,60,false,true);
             Image RMLogo= new Image("/Imagenes/real-madrid-logo-escudo.png",48,60,false,true);
             Image BarsaLogo= new Image("/Imagenes/barsa.png",48,60,false,true);
             Image BetisLogo= new Image("/Imagenes/betis.png",80,80,false,true);
             Image SportingLogo= new Image("/Imagenes/Sporting.png",48,60,false,true);
             Image InterMilanLogo= new Image("/Imagenes/inter-milan-logo.png",60,60,false,true);
             Image McityLogo= new Image("/Imagenes/manchester-city-fc-logo-escudo-badge.png",60,60,false,true);
             Image bayernMunichLogo= new Image("/Imagenes/Bayern Munich.png",60,60,false,true);
             Image LazioLogo= new Image("/Imagenes/lazio-logo.png",48,60,false,true);
             Image PSGLogo= new Image("/Imagenes/PSG.png",60,60,false,true);
            
             RealM.setGraphic((new ImageView(RMLogo)));
             SPORT.setGraphic((new ImageView(SportingLogo)));
             INTER.setGraphic((new ImageView(InterMilanLogo)));
             BARSA.setGraphic((new ImageView(BarsaLogo)));
             ARSENAL.setGraphic((new ImageView(ArsenalLogo)));
             LAZIO.setGraphic((new ImageView(LazioLogo)));
             BETIS.setGraphic((new ImageView(BetisLogo)));
             PSG.setGraphic((new ImageView(PSGLogo)));
             CITY.setGraphic((new ImageView(McityLogo)));
             BAYERN.setGraphic((new ImageView(bayernMunichLogo)));
             
              Image tit= new Image("/Imagenes/titulo.png");
              titulo.setImage(tit);
               
        
               
              
              

    }    
     
    @FXML
    private void escogerRM(ActionEvent event) {
    }

    @FXML
    private void escogerSport(ActionEvent event) {
    }

    @FXML
    private void escogerInter(ActionEvent event) {
    }

    @FXML
    private void escogerBarsa(ActionEvent event) {
    }

    @FXML
    private void escogerArsenal(ActionEvent event) {
    }

    @FXML
    private void escogerLazio(ActionEvent event) {
    }

    @FXML
    private void escogerPSG(ActionEvent event) {
    }

    @FXML
    private void escogerCity(ActionEvent event) {
    }

    @FXML
    private void escogerBayern(ActionEvent event) {
    }

    @FXML
    private void escogerBETIS(ActionEvent event) {
    }
    
}
