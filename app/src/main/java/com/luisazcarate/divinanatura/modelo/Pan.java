package com.luisazcarate.divinanatura.modelo;

import org.parceler.Parcel;

/**
 * Created by Luis on 10/12/16.
 */
@Parcel
public class Pan {

    String nombre;
    String descripcion;
    String url_foto;
    String idPan;

    public Pan() {
    }

    public Pan(String idPan, String nombre, String descripcion, String url_foto) {
        this.idPan = idPan;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.url_foto = url_foto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrl_foto() {
        return url_foto;
    }

    public String getIdPan() {
        return idPan;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUrl_foto(String url_foto) {
        this.url_foto = url_foto;
    }

    public void setIdPan(String idPan) {
        this.idPan = idPan;
    }
}
