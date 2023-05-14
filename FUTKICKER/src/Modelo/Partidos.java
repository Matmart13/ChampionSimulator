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
    private Equipo local;
    private Equipo  visitante;
    private int jornada;
    public Partidos(Equipo _local,Equipo _visitante, int _jornada) {
        this.local = _local;
        this.visitante = _visitante;
        this.jornada = _jornada;
    }

    public Equipo getLocal() {
        return local;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public void setLocal(Equipo local) {
        this.local = local;
    }

    public void setVisitante(Equipo visitante) {
        this.visitante = visitante;
    }
    
    
    
}
