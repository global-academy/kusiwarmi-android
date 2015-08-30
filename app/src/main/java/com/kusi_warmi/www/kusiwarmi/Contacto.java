package com.kusi_warmi.www.kusiwarmi;

/**
 * Created by globalstudent on 13-08-15.
 */
public class Contacto {

    public String titulo;
    public String direccion;
    public String email;
    public String numero;

    public Contacto(String titulo,String direccion,String email,String numero){
        this.titulo = titulo;
        this.direccion=direccion;
        this.email=email;
        this.numero=numero;

    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo=titulo;
    }


    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
