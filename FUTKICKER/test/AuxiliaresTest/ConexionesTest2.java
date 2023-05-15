/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuxiliaresTest;

import Auxiliares.Conexiones;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class ConexionesTest2 {
    
    private static Conexiones conexiones;

     @BeforeClass
    public static void setUp() throws SQLException {
        conexiones = new Conexiones();
    }

     @AfterClass
    public static void tearDown() throws SQLException {
        conexiones.cerrarConexion();
    }
    
    @Test
    public void testEjecutarConsulta() throws SQLException {
        // Preparar datos
        String SQL = "SELECT COUNT(*) FROM equipos";
        
        // Ejecutar método y obtener resultado
        ResultSet resultado = conexiones.ejecutarConsulta(SQL);
        
        // Comprobar que el resultado es válido
        assertNotNull(resultado);
        assertTrue(resultado.next());
        int count = resultado.getInt(1);
        assertTrue(count >= 0);
    }
    
     @Test
    public void testEjecutarInstruccion() throws SQLException {
        // Preparar datos
        String SQL = "Insert into partidos (`p_eq1`, `p_eq2`, `p_jornada`) VALUES ('[value-1]','[value-2]',2)";
        
        // Ejecutar método y obtener resultado
        int filasAfectadas = conexiones.ejecutarInstruccion(SQL);
        
        // Comprobar que el resultado es válido
        assertTrue(filasAfectadas > 0);
    }
    
      public void testCerrarConexion() throws SQLException{
       String SQL = "SELECT COUNT(*) FROM usuarios";

    // Ejecutar método y comprobar que la conexión está cerrada
    conexiones.cerrarConexion();

    // Verificar que la consulta produce una excepción SQLException
    try {
        conexiones.ejecutarConsulta(SQL);
        fail("Se esperaba SQLException pero no se lanzó ninguna excepción");
    } catch (SQLException e) {
        String expectedMessage = "Connection is closed";
        String actualMessage = e.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }  
      }
}
