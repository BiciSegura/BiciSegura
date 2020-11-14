package com.pack.bicisegura;

public class Usuario {
    private String correo;
    private String contraseña;
    private String usuario;

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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario){
        this.usuario = usuario;
    }

    public Usuario(String correo, String contraseña){
        this.correo = correo;
        this.contraseña = contraseña;
        this.usuario = usuario;

    }
    public Usuario(){

    }
}
