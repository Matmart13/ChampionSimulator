/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.scene.image.ImageView;

/**
 *
 * @author martin
 */
public class Equiposvs {
  private String nombre;
  private int id;
  private int estrellas;
  private ImageView imagen;  
    public Equiposvs(String _nombre, int _id, int _estrellas, ImageView _imagen) {
        this.nombre = _nombre;
        this.id = _id;
        this.estrellas = _estrellas;
        this.imagen = _imagen;
    }

    public Equiposvs() {
    }
   public Equiposvs(String _nombre, int _id, int _estrellas) {
        this.nombre = _nombre;
        this.id = _id;
        this.estrellas = _estrellas;
     
    }


    
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEstrellas() {
        return estrellas;
    }

    public ImageView getImagen() {
        return imagen;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEstrellas(int estrellas) {
        this.estrellas = estrellas;
    }

    public void setImagen(ImageView imagen) {
        this.imagen = imagen;
    }
    
}
