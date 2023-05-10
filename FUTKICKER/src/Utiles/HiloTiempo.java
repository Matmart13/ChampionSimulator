/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.util.Duration;

/**
 *
 * @author marti
 */
public class HiloTiempo extends Thread {

    Label label;
    private int count = 0;
    Timeline timeline;
    private int max = 45;
    private int countParte = 0;
    public HiloTiempo(Label _label) {
        // TODO Auto-generated constructor stub
        label = _label;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        timeline = new Timeline(new KeyFrame(Duration.seconds(0.15), event -> {
            count++;
            label.setText(Integer.toString(count));
            if (label.getText().equals(String.valueOf(max)) == true) {
                timeline.stop();
                Alert a = new Alert(Alert.AlertType.NONE);
                a.show();
                if(countParte == 1){
                    a.setTitle("Fin Partido");
                    a.setContentText("Finalización partido");
                }
                a.setTitle("Fin primera parte");
                countParte = countParte+1;
                a.setContentText("Finalización primera parte");
                a.setResult(ButtonType.NEXT);
            }
        }));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

    }

}
