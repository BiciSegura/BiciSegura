package com.pack.bicisegura;

public class Localidad implements Comparable<Localidad>{

    private String nombre;
    private int num_robos;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getNumeroRobos() {
        return num_robos;
    }

    public void setNumeroRobos(int num_robos){
        this.num_robos = num_robos;
    }



    public Localidad(String nombre, int num_robos){
        this.nombre = nombre;
        this.num_robos = num_robos;

    }

    @Override
    public int compareTo(Localidad loc){

        if (this.num_robos < loc.num_robos){
            return -1;
        }else if (this.num_robos == loc.num_robos){
            return 0;
        }else{
            return 1;
        }
    }



}
