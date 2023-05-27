/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author marti
 */
public class Partidos {
    private String local;
    private String  visitante;
    /**
     * Constructor de la clase Partidos
     * @param _local
     * @param _visitante 
     */
    public Partidos(String _local,String _visitante) {
        this.local = _local;
        this.visitante = _visitante;
   
    }
    /**
     * Sirve para devolver el valor de local
     * @return 
     */
    public String getLocal() {
        return local;
    }
    /**
     * Sirve para devolver el valor de visitante
     * @return 
     */
    public String getVisitante() {
        return visitante;
    }
    /**
     * Sirve para settear el valor de la variable local
     * @param local 
     */
    public void setLocal(String local) {
        this.local = local;
    }   
    /**
     * Sirve para settear el valor de la variable visitante
     * @param visitante 
     */
    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }
    
    
    
}
