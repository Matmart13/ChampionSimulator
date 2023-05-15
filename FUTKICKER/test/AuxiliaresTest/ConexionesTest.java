/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AuxiliaresTest;

/**
 *
 * @author marti
 */
import Auxiliares.Conexiones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;
public class ConexionesTest {

       static String host ;
   static String baseDatos;
    static String usuario ;
   static String password ;
 private static Connection conexion;

     @BeforeClass
    public static void setUp() throws SQLException {
              // Adaptalos a tu conexion
              
         host = "localhost";
         baseDatos = "championsimulator";
         usuario = "root";
         password = "";

        // Cadena de conexion para conectarnos a la base de datos en MySQL
        String cadenaConexion = "jdbc:mysql://" + host + "/" + baseDatos;

        // Creo la conexion 
        conexion = DriverManager.getConnection(cadenaConexion, usuario, password);

        // Hace commit automaticamente
        conexion.setAutoCommit(true);
    }

     @AfterClass
    public static void tearDown() throws SQLException {
         conexion.close();
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
