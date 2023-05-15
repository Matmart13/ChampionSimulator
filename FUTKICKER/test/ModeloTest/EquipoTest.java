/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTest;

import Modelo.Equipo;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author marti
 */
public class EquipoTest {

    static int id;
    static String nombre;
    static int victorias;
    static int derrotas;
    static int goles;
    static int golesc;
    static int golesdiff;
    static int estrellas;
    Equipo equipo = new Equipo(1, "Equipo de prueba", 2, 1, 6, 3, 3, 3);

    @Test
    public void testGetId() {
        assertEquals("Equipo de prueba", equipo.getNombre());
    }

    @Test
    public void testGetVictorias() {
        assertEquals(2, equipo.getVictorias());
    }

    @Test
    public void testGetDerrotas() {
        assertEquals(1, equipo.getDerrotas());
    }

    @Test
    public void testGetGoles() {
        assertEquals(6, equipo.getGoles());

    }

    @Test
    public void testGetGolesc() {
        assertEquals(3, equipo.getGolesc());
    }

    @Test
    public void testGetGolesdiff() {
        assertEquals(3, equipo.getGolesdiff());
    }

    @Test
    public void testSetId() {
        equipo.setNombre("Nuevo nombre");
        assertEquals("Nuevo nombre", equipo.getNombre());
    }

    @Test
    public void testSetVictorias() {
        equipo.setVictorias(3);
        assertEquals(3, equipo.getVictorias());
    }

    @Test
    public void voidSetDerrotas() {
        equipo.setDerrotas(6);
        assertEquals(6, equipo.getDerrotas());
    }

    @Test
    public void voidSetGoles() {
        equipo.setGoles(10);
        assertEquals(10, equipo.getGoles());
    }

    @Test
    public void voidSetGolesC() {
        equipo.setGolesc(10);
        assertEquals(10, equipo.getGolesc());
    }

    @Test
    public void voidSetGolesDiff() {
        equipo.setGolesdiff(10);
        assertEquals(10, equipo.getGolesdiff());
    }

    @Test
    public void voidSetEstrellas() {
        equipo.setEstrellas(5);
        assertEquals(5, equipo.getEstrellas());
    }

}
