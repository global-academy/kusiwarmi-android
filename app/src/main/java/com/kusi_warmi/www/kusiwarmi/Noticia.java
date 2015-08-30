package com.kusi_warmi.www.kusiwarmi;

/**
 * Created by globalstudent on 10-08-15.
 */
public class Noticia {

    public String titulo;
    public String fecha;
    public String contenido;

    public Noticia(String titulo,String fecha,String contenido){
        this.titulo=titulo;
        this.fecha=fecha;
        this.contenido=contenido;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo=titulo;
    }

    public String getFecha(){
        return fecha;
    }
    public void setFecha(String fecha){
        this.fecha=fecha;
    }

    public String getContenido(){
        return contenido;
    }
    public void setContenido(String contenido){
        this.contenido=contenido;
    }
}
