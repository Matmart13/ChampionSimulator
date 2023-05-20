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
 
    public Partidos(String _local,String _visitante) {
        this.local = _local;
        this.visitante = _visitante;
   
    }

    public String getLocal() {
        return local;
    }

    public String getVisitante() {
        return visitante;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setVisitante(String visitante) {
        this.visitante = visitante;
    }
    
    
    
}
