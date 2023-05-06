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
import javafx.scene.input.KeyEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author marti
 */
public class FXML_VentanaElegirController implements Initializable {
    String nombre ;
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
    @FXML
    private ImageView fondo;
    @FXML
    private ImageView EstrellasMadrid;
    @FXML
    private ImageView EstrellasBarcelona;
    @FXML
    private ImageView EstrellasBayern;
    @FXML
    private ImageView EstrellasManchester;
    @FXML
    private ImageView EstrellasSport;
    @FXML
    private ImageView EstrellasBetis;
    @FXML
    private ImageView EstrellasMilan;
    @FXML
    private ImageView EstrellasArsenal;
    @FXML
    private ImageView EstrellasPSG;
    @FXML
    private ImageView EstrellasLazio;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            Image fondoImagen= new Image("/Imagenes/campo.jpg");
            fondo.setImage(fondoImagen);
            
            Image estrellas= new Image("/Imagenes/estrellas.gif",200,200,false,true);
            Image tres= new Image("/Imagenes/tresEstrellas.png",100,30,false,true);
            Image cuatro= new Image("/Imagenes/cuatroEstrellas.png",100,20,false,true);
            EstrellasMadrid.setImage(estrellas);
            EstrellasBarcelona.setImage(estrellas);
            EstrellasBayern.setImage(estrellas);
            EstrellasManchester.setImage(estrellas);
            EstrellasSport.setImage(tres);
            EstrellasBetis.setImage(tres);
            EstrellasMilan.setImage(cuatro);
            EstrellasArsenal.setImage(cuatro);
            EstrellasLazio.setImage(cuatro);
            EstrellasPSG.setImage(cuatro);
             
              
             Image ArsenalLogo= new Image("/Imagenes/Arsenal_FC.png",60,80,false,true);
             Image RMLogo= new Image("/Imagenes/Madrid.gif",80,80,false,true);
             Image BarsaLogo= new Image("/Imagenes/Barsa.gif",80,80,false,true);
             Image BetisLogo= new Image("/Imagenes/betis.png",80,80,false,true);
             Image SportingLogo= new Image("/Imagenes/Sporting.png",60,80,false,true);
             Image InterMilanLogo= new Image("/Imagenes/inter-milan-logo.png",80,80,false,true);
             Image McityLogo= new Image("/Imagenes/manchester.gif",80,80,false,true);
             Image bayernMunichLogo= new Image("/Imagenes/bayern.gif",80,80,false,true);
             Image LazioLogo= new Image("/Imagenes/lazio-logo.png",80,60,false,true);
             Image PSGLogo= new Image("/Imagenes/PSG.png",80,80,false,true);
            
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
            nombre = "Madrid";
            Stage myStage = (Stage) this.RealM.getScene().getWindow();
            myStage.close();
       try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("src/Vistas/FXML_VentanaTemporada.fxml"));
            Parent root = loader.load();
            FXML_VistaTemporadaController vtc = loader.getController();
            vtc.nombre = nombre;
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(FXML_VentanaInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void escogerSport(ActionEvent event) {
         nombre = "Sport";
            Stage myStage = (Stage) this.SPORT.getScene().getWindow();
            myStage.close(); 
            try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXML_VentanaTemporada.fxml"));
            Parent root = loader.load();
            FXML_VistaTemporadaController vtc = new FXML_VistaTemporadaController(nombre);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.getIcons().add(new Image("/Imagenes/LogoAPP.png"));
            stage.setTitle("ChampionSimulator");
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(FXML_VentanaInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void escogerInter(ActionEvent event) {
         nombre = "Inter";
             Stage myStage = (Stage) this.INTER.getScene().getWindow();
            myStage.close();
             try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXML_VentanaTemporada.fxml"));
            Parent root = loader.load();
            FXML_VistaTemporadaController vtc = new FXML_VistaTemporadaController(nombre);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.getIcons().add(new Image("/Imagenes/LogoAPP.png"));
            stage.setTitle("ChampionSimulator");
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(FXML_VentanaInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void escogerBarsa(ActionEvent event) {
         nombre = "Barsa";
             Stage myStage = (Stage) this.BARSA.getScene().getWindow();
            myStage.close();
             try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXML_VentanaTemporada.fxml"));
            Parent root = loader.load();
            FXML_VistaTemporadaController vtc = new FXML_VistaTemporadaController(nombre);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.getIcons().add(new Image("/Imagenes/LogoAPP.png"));
            stage.setTitle("ChampionSimulator");
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(FXML_VentanaInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void escogerArsenal(ActionEvent event) {
         nombre = "Arsenal";
             Stage myStage = (Stage) this.ARSENAL.getScene().getWindow();
            myStage.close();
             try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXML_VentanaTemporada.fxml"));
            Parent root = loader.load();
            FXML_VistaTemporadaController vtc = new FXML_VistaTemporadaController(nombre);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.getIcons().add(new Image("/Imagenes/LogoAPP.png"));
            stage.setTitle("ChampionSimulator");
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(FXML_VentanaInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void escogerLazio(ActionEvent event) {
         nombre = "Lazio";
             Stage myStage = (Stage) this.LAZIO.getScene().getWindow();
            myStage.close();
             try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXML_VentanaTemporada.fxml"));
            Parent root = loader.load();
            FXML_VistaTemporadaController vtc = new FXML_VistaTemporadaController(nombre);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.getIcons().add(new Image("/Imagenes/LogoAPP.png"));
            stage.setTitle("ChampionSimulator");
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(FXML_VentanaInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void escogerPSG(ActionEvent event) {
         nombre = "PSG";
             Stage myStage = (Stage) this.PSG.getScene().getWindow();
            myStage.close();
             try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXML_VentanaTemporada.fxml"));
            Parent root = loader.load();
            FXML_VistaTemporadaController vtc = new FXML_VistaTemporadaController(nombre);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.getIcons().add(new Image("/Imagenes/LogoAPP.png"));
            stage.setTitle("ChampionSimulator");
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(FXML_VentanaInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void escogerCity(ActionEvent event) {
         nombre = "City";
             Stage myStage = (Stage) this.CITY.getScene().getWindow();
            myStage.close(); try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXML_VentanaTemporada.fxml"));
            Parent root = loader.load();
            FXML_VistaTemporadaController vtc = new FXML_VistaTemporadaController(nombre);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.getIcons().add(new Image("/Imagenes/LogoAPP.png"));
            stage.setTitle("ChampionSimulator");
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(FXML_VentanaInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }

    @FXML
    private void escogerBayern(ActionEvent event) {
         nombre = "Bayern";
             Stage myStage = (Stage) this.BAYERN.getScene().getWindow();
            myStage.close();
             try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXML_VentanaTemporada.fxml"));
            Parent root = loader.load();
            FXML_VistaTemporadaController vtc = new FXML_VistaTemporadaController(nombre);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.getIcons().add(new Image("/Imagenes/LogoAPP.png"));
            stage.setTitle("ChampionSimulator");
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(FXML_VentanaInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void escogerBETIS(ActionEvent event) {
         nombre = "Betis";
             Stage myStage = (Stage) this.BETIS.getScene().getWindow();
            myStage.close();
             try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vistas/FXML_VentanaTemporada.fxml"));
            Parent root = loader.load();
            FXML_VistaTemporadaController vtc = new FXML_VistaTemporadaController(nombre);
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            
            stage.getIcons().add(new Image("/Imagenes/LogoAPP.png"));
            stage.setTitle("ChampionSimulator");
            stage.setScene(scene);
            stage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(FXML_VentanaInicioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
}