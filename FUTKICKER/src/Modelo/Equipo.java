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
public class Equipo {
    private int id;
    private String nombre;
    private int victorias;
    private int derrotas;
    private int goles;
    private int golesc;
    private int golesdiff;
    private int estrellas;
                    
    public Equipo(int _id,String _nombre, int _victorias, int _derrotas, int _goles, int _golesc, int _golesdiff, int _estrellas) {
      this.id = _id;
      this.nombre = _nombre;
      this.victorias = _victorias;
      this.derrotas = _derrotas;
      this.goles = _goles;
      this.golesc = _golesc;
      this.golesdiff = _golesdiff;
      this.estrellas = _estrellas;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVictorias() {
        return victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public int getGoles() {
        return goles;
    }

    public int getGolesc() {
        return golesc;
    }

    public int getGolesdiff() {
        return golesdiff;
    }
    
    public int getEstrellas() {
        return estrellas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    
    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    public void setGolesc(int golesc) {
        this.golesc = golesc;
    }

    public void setGolesdiff(int golesdiff) {
        this.golesdiff = golesdiff;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }
    
    
}
