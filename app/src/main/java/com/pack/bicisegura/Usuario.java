package com.pack.bicisegura;

public class Usuario{
    private String clave;
    private String correo;

    public String getClave() {
        return clave;
    }

    public void setClave(String Clave){
        this.clave = clave;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String Correo){
        this.correo = correo;
    }

    public Usuario(String correo, String clave){

        this.clave = clave;
        this.correo = correo;

    }
    public Usuario(){

    }
}