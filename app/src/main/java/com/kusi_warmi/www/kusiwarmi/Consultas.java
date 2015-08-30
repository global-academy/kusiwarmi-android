package com.kusi_warmi.www.kusiwarmi;

/**
 * Created by globalstudent on 11-08-15.
 */
public class Consultas {

    public String pregunta;
    public String respuesta;

    public Consultas(String pregunta,String respuesta){

        this.pregunta=pregunta;
        this.respuesta=respuesta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta=pregunta;
    }


    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

}

