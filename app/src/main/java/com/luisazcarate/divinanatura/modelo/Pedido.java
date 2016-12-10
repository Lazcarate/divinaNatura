package com.luisazcarate.divinanatura.modelo;

/**
 * Created by Luis on 10/12/16.
 */

public class Pedido {

    private String idPan;
    private int cantidad;
    private String emailUsuario;

    public Pedido() {
    }

    public Pedido(String idPan, int cantidad, String emailUsuario) {
        this.idPan = idPan;
        this.cantidad = cantidad;
        this.emailUsuario = emailUsuario;
    }

    public String getIdPan() {
        return idPan;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setIdPan(String idPan) {
        this.idPan = idPan;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }
}
