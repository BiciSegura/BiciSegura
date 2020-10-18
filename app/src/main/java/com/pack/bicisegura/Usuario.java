package com.pack.bicisegura;

public class Usuario {
    private String correo;
    private String contraseña;

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo){
        this.correo = correo;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña){
        this.contraseña = contraseña;
    }

    public Usuario(String correo, String contraseña){
        this.correo = correo;
        this.contraseña = contraseña;

    }
    public Usuario(){

    }
}
