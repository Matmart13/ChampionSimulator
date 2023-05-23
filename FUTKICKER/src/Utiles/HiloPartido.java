/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import javafx.application.Platform;
import javafx.scene.control.Label;

/**
 *
 * @author marti
 */
public class HiloPartido extends Thread{
    private int estrellasEquipoLocal;
    private int estrellasEquipoVisitante;
    private Label lblGolesLocal;
    private Label lblGolesVisitante;
    private HiloTiempo hiloTiempo;
    private int golesLocal;
    private int golesVisitante;

    public HiloPartido(int estrellasEquipoLocal, int estrellasEquipoVisitante, Label lblGolesLocal, Label lblGolesVisitante, HiloTiempo ht) {
        this.estrellasEquipoLocal = estrellasEquipoLocal;
        this.estrellasEquipoVisitante = estrellasEquipoVisitante;
        this.lblGolesLocal = lblGolesLocal;
        this.lblGolesVisitante = lblGolesVisitante;
        this.hiloTiempo = ht;
        this.golesLocal = 0;
        this.golesVisitante = 0;
    }

  

    @Override
     public void run() {
        while (hiloTiempo.getTiempoTranscurrido() != 45) {
            int golLocal = (int) (Math.random() * (estrellasEquipoLocal + 1));
            if (golLocal == estrellasEquipoLocal) {
                synchronized (hiloTiempo) {
                    golesLocal++;
                    Platform.runLater(() -> lblGolesLocal.setText(Integer.toString(golesLocal)));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            int golVisitante = (int) (Math.random()*(estrellasEquipoVisitante + 1));
            if (golVisitante == estrellasEquipoVisitante) {
                synchronized (hiloTiempo) {
                    golesVisitante++;
                    Platform.runLater(() -> lblGolesVisitante.setText(Integer.toString(golesVisitante)));
                    try {
                         Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
