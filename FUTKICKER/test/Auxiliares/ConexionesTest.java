/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;

import java.sql.ResultSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marti
 */
public class ConexionesTest {
    
    public ConexionesTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of ejecutarConsulta method, of class Conexiones.
     */
    @Test
    public void testEjecutarConsulta() throws Exception {
        System.out.println("ejecutarConsulta");
        String SQL = "";
        Conexiones instance = new Conexiones();
        ResultSet expResult = null;
        ResultSet result = instance.ejecutarConsulta(SQL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ejecutarInstruccion method, of class Conexiones.
     */
    @Test
    public void testEjecutarInstruccion() throws Exception {
        System.out.println("ejecutarInstruccion");
        String SQL = "";
        Conexiones instance = new Conexiones();
        int expResult = 0;
        int result = instance.ejecutarInstruccion(SQL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cerrarConexion method, of class Conexiones.
     */
    @Test
    public void testCerrarConexion() throws Exception {
        System.out.println("cerrarConexion");
        Conexiones instance = new Conexiones();
        instance.cerrarConexion();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
