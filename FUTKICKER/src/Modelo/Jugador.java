/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author martin y pablo
 */
public class Jugador {
    private int id;
    private String nombre;
    private String posicion;
    private int titular;
    public Jugador( int _id, String _nombre, String _posicion, int _titular) {
        this.id = _id;
        this.nombre = _nombre;
        this.posicion = _posicion;
        this.titular = _titular;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public int getTitular() {
        return titular;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public void setTitular(int titular) {
        this.titular = titular;
    }
    
    
    
}
