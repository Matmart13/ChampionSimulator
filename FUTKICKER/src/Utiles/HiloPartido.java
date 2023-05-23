/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import Controladores.FXML_VentanaPartidoController;
import static Utiles.HiloTiempo.maximo;
import static Utiles.HiloTiempo.timeline;
import static java.lang.Math.random;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.util.Duration;

/**
 *
 * @author marti
 */
public class HiloPartido extends Thread {

    private int estrellasEquipoLocal;
    private int estrellasEquipoVisitante;
    private Label lblGolesLocal;
    private Label lblGolesVisitante;
    private HiloTiempo hiloTiempo;
    private int golesLocal;
    private int golesVisitante;
    TextArea texto;
    static Timeline timelinepartido;
    static int  cont1 = 0;
    static int cont2 = 0;
    private float porcentajegol = 1;

    public HiloPartido(int estrellasEquipoLocal, int estrellasEquipoVisitante, Label lblGolesLocal, Label lblGolesVisitante, HiloTiempo ht, TextArea texto) {
        this.estrellasEquipoLocal = estrellasEquipoLocal;
        this.estrellasEquipoVisitante = estrellasEquipoVisitante;
        this.lblGolesLocal = lblGolesLocal;
        this.lblGolesVisitante = lblGolesVisitante;
        this.hiloTiempo = ht;
        this.golesLocal = 0;
        this.golesVisitante = 0;
        this.texto = texto;
    }

    int golVisitante = (int) (Math.random() * (estrellasEquipoVisitante + 1));

    @Override

    public void run() {
        float posiblidadEq1 = porcentajegol * estrellasEquipoLocal;
        float posibilidadEq2 = porcentajegol * estrellasEquipoVisitante;
       
        timelinepartido = new Timeline(new KeyFrame(Duration.seconds(0.5), event -> {
            texto.appendText("...........................................\n");
             float numeroAleatorio = (float) (Math.random() * 100);
             System.out.println(numeroAleatorio);
            if (numeroAleatorio < posiblidadEq1) {
               cont1 ++;
                lblGolesLocal.setText(String.valueOf(cont1));
                texto.appendText("Gooooooooooooool del local" + "\n");
            }
            if (numeroAleatorio >100- posibilidadEq2) {
                
               cont2  ++;
                lblGolesVisitante.setText(String.valueOf(cont2));
                texto.appendText("Gooooooooooooool del visitante" + "\n");
            }
        }));

        timelinepartido.setCycleCount(Timeline.INDEFINITE);
        timelinepartido.play();

    }

    public  int getCont1() {
        return cont1;
    }

    public int getCont2() {
        return cont2;
    }

    public void setCont1(int cont1) {
        this.cont1 = cont1;
    }

    public void setCont2(int cont2) {
        this.cont2 = cont2;
    }
    
}
