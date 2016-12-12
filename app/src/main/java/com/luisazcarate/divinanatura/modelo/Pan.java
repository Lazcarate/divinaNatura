package com.luisazcarate.divinanatura.modelo;

import org.parceler.Parcel;

/**
 * Created by Luis on 10/12/16.
 */
@Parcel
public class Pan {

    String nombre;
    String descripcion;
    String foto;
    String peso;
    String precio;


    public Pan() {
    }

    public Pan(String nombre, String descripcion, String foto, String peso, String precio) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.foto = foto;
        this.peso = peso;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }



    public String getFoto() {
        return foto;
    }

    public String getPeso() {
        return peso;
    }

    public String getPrecio() {
        return precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
