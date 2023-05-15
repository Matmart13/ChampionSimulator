/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControladoresTest;

import Modelo.Equipo;
import javafx.scene.image.ImageView;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author marti
 */
public class FXML_VentanaPartidoController {

    static Equipo Equipo1 = new Equipo(0, "Barcelona", 5, 0, 0, 0, 0, 0);
    static Equipo Equipo2 = new Equipo(0, "Real madrid", 5, 0, 0, 0, 0, 0);
    static ImageView Imagen1 = new ImageView();
    static ImageView Imagen2 = new ImageView();
    static int Jornada = 1;

    private static void recibirEquipos(Equipo equipo1, Equipo equipo2, ImageView imagen1, ImageView imagen2, int jornada) {

        Equipo1 = equipo1;
        Equipo2 = equipo2;
        Imagen1 = imagen1;
        Imagen2 = imagen2;
        Jornada = jornada;

    }

    @Test
    public void testRecibirEquipos() {
        Equipo equipo1 = new Equipo(0, "Barcelona", 5, 0, 0, 0, 0, 0);
        Equipo equipo2 = new Equipo(0, "Real madrid", 5, 0, 0, 0, 0, 0);
        ImageView imagen1 = new ImageView();
        ImageView imagen2 = new ImageView();
        int jornada = 1;

        FXML_VentanaPartidoController.recibirEquipos(equipo1, equipo2, imagen1, imagen2, jornada);

        assertEquals(equipo1.getNombre(), FXML_VentanaPartidoController.Equipo1.getNombre());
        assertEquals(equipo1.getEstrellas(), FXML_VentanaPartidoController.Equipo1.getEstrellas());
        assertEquals(equipo2.getNombre(), FXML_VentanaPartidoController.Equipo2.getNombre());
        assertEquals(equipo2.getEstrellas(), FXML_VentanaPartidoController.Equipo2.getEstrellas());
        assertEquals(imagen1, FXML_VentanaPartidoController.Imagen1);
        assertEquals(imagen2, FXML_VentanaPartidoController.Imagen2);
        assertEquals(jornada, FXML_VentanaPartidoController.Jornada);
    }

}
