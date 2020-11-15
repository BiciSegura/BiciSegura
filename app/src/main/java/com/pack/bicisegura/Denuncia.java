package com.pack.bicisegura;

public class Denuncia{
    private String lugar;
    private String hora;
    private String usuario;
    private String localidad;

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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad){
        this.localidad = localidad;
    }

    public Denuncia(String lugar, String hora, String usuario, String localidad){
        this.lugar = lugar;
        this.hora = hora;
        this.usuario = usuario;
        this.localidad = localidad;

    }
    public Denuncia(){

    }
}
