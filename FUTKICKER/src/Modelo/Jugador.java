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
    /**
     * Constructor de la clase Jugador
     * @param _id
     * @param _nombre
     * @param _posicion
     * @param _titular 
     */
    public Jugador(int _id, String _nombre, String _posicion, int _titular) {
        this.id = _id;
        this.nombre = _nombre;
        this.posicion = _posicion;
        this.titular = _titular;
    }
    /**
     * Este metodo sirve para devolver el valor de la variable id
     * @return 
     */
    public int getId() {
        return id;
    }
    /**
     * Este metodo sirve para devolver el valor de la variable nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Este metodo sirve para devolver el valor de la variable posicion
     * @return 
     */
    public String getPosicion() {
        return posicion;
    }
    /**
     * Este metodo sirve para devolver el valor de la variable Titular
     * @return 
     */
    public int getTitular() {
        return titular;
    }
    /**
     * Este metodo sirve para cambiar el valor de la variable id 
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }   
    /**
     * Este metodo sirve para cambiar el valor de la variable nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Este metodo sirve para cambiar el valor de la varible posicion
     * @param posicion 
     */
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
    /**
     * Este metodo sirve para cambiar el valor de la variable Titular
     * @param titular 
     */
    public void setTitular(int titular) {
        this.titular = titular;
    }

}
