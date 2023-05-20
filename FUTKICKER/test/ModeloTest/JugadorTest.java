/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloTest;

import Modelo.Jugador;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author marti
 */
public class JugadorTest {

    Jugador jugador = new Jugador(0, "JugadorTest", "PosicionTest", 0);

    @Test
    public void testGetId() {
        assertEquals(0, jugador.getId());
    }

    @Test
    public void testGetNombre() {
        assertEquals("JugadorTest", jugador.getNombre());
    }

    @Test
    public void testGetPosicion() {
        assertEquals("PosicionTest", jugador.getPosicion());
    }

    @Test
    public void testGetTitular() {
        assertEquals(0, jugador.getTitular());
    }

    @Test
    public void testSetid() {
        jugador.setId(1);
        assertEquals(1, jugador.getId());
    }

    @Test
    public void testSetNombre() {
        jugador.setNombre("NuevoNombre");
        assertEquals("NuevoNombre", jugador.getNombre());
    }

    @Test
    public void testSetPosicion() {
        jugador.setPosicion("NuevaPosicion");
        assertEquals("NuevaPosicion", jugador.getPosicion());
    }

    @Test
    public void testSetTitular() {
        jugador.setTitular(1);
        assertEquals(1, jugador.getTitular());
    }
}
