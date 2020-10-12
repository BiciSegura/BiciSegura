package com.pack.bicisegura;

public class Objeto_denuncia {
    private String lugar;
    private String hora;
    private String usuario;

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar){
        this.lugar = lugar;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora){
        this.hora = hora;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public Objeto_denuncia(String lugar, String hora, String usuario){
        this.lugar = lugar;
        this.hora = hora;
        this.usuario = usuario;

    }
}
