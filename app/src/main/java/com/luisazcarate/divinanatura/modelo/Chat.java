package com.luisazcarate.divinanatura.modelo;

/**
 * Created by Luis on 16/12/16.
 */

public class Chat {

    String autor;
    String mensaje;
    Long hora;

    public Chat() {
    }

    public Chat(String autor, String mensaje, Long hora) {
        this.autor = autor;
        this.mensaje = mensaje;
        this.hora = hora;
    }

    public String getAutor() {
        return autor;
    }

    public String getMensaje() {
        return mensaje;
    }



    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Long getHora() {
        return hora;
    }
}
