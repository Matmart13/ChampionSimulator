/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author martín y pablo
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
    /**
     * Constructor de la clase Equipo
     * @param _id
     * @param _nombre
     * @param _victorias
     * @param _derrotas
     * @param _goles
     * @param _golesc
     * @param _golesdiff
     * @param _estrellas 
     */
    public Equipo(int _id, String _nombre, int _victorias, int _derrotas, int _goles, int _golesc, int _golesdiff, int _estrellas) {
        this.id = _id;
        this.nombre = _nombre;
        this.victorias = _victorias;
        this.derrotas = _derrotas;
        this.goles = _goles;
        this.golesc = _golesc;
        this.golesdiff = _golesdiff;
        this.estrellas = _estrellas;
    }
    /**
     * Este metodo sirve para recoger el id del equipo
     * @return 
     */
    public int getId() {
        return id;
    }
   /**
    * Este metodo sirve para recoger el Nombre del equipo
    * @return 
    */
    public String getNombre() {
        return nombre;
    }
   /**
    * Este metodo sirve para recoger las Victorias del equipo
    * @return 
    */
    public int getVictorias() {
        return victorias;
    }
   /**
    * Este metodo sirve para recoger el Nombre del equipo
    * @return 
    */
    public int getDerrotas() {
        return derrotas;
    }
   /**
    * Este metodo sirve para recoger los goles  del equipo
    * @return 
    */
    public int getGoles() {
        return goles;
    }
   /**
    * Este metodo sirve para recoger los goles en contra  del equipo
    * @return 
    */
    public int getGolesc() {
        return golesc;
    }
   /**
    * Este metodo sirve para recoger los goles de diferencia que tiene el equipo del equipo
    * @return 
    */
    public int getGolesdiff() {
        return golesdiff;
    }
   /**
    * Este metodo sirve para recoger las estrellas del equipo
    * @return 
    */
    public int getEstrellas() {
        return estrellas;
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
     * Este metodo sirve para cambiar el valor de la variable victorias
     * @param victorias 
     */
    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }
    /**
     * Este metodo sirve para cambiar el valor de la variable derrotas
     * @param derrotas 
     */
    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }
    /**
     * Este metodo sirve para cambiar el valor de la variable goles
     * @param goles 
     */
    public void setGoles(int goles) {
        this.goles = goles;
    }
    /**
     * Este metodo sirve para cambiar el valor de la variable golesc
     * @param golesc 
     */
    public void setGolesc(int golesc) {
        this.golesc = golesc;
    }
    /**
     * Este metodo sirve para cambiar el valor de la variable golesdiff
     * @param golesdiff 
     */
    public void setGolesdiff(int golesdiff) {
        this.golesdiff = golesdiff;
    }
    /**
     * Este metodo sirve para cambiar el valor de la variable estrellas
     * @param estrellas 
     */
    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

}
