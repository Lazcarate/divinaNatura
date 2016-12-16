package com.luisazcarate.divinanatura.modelo;

/**
 * Created by Luis on 16/12/16.
 */

public class Chat {

    String autor;
    String mensaje;
    String uid;

    public Chat() {
    }

    public Chat(String autor, String mensaje, String uid) {
        this.autor = autor;
        this.mensaje = mensaje;
        this.uid = uid;
    }

    public String getAutor() {
        return autor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public String getUid() {
        return uid;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
