package com.pack.bicisegura;

public class Denuncia implements Comparable<Object> {
    private String lugar;
    private String hora;
    private String usuario;
    private Localidad localidad;


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

    public Denuncia(String lugar, String hora, String usuario){
        this.lugar = lugar;
        this.hora = hora;
        this.usuario = usuario;

    }
    public Denuncia(){

    }

    @Override
    public int compareTo(Object o) {

        return 0;
    }
}
