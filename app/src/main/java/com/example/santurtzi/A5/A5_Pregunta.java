package com.example.santurtzi.A5;

public class A5_Pregunta {
    private String pregunta;
    private int respuesta_correcta;
    private String[] opciones;

    public A5_Pregunta(String pregunta, int respuesta_correcta, String[] opciones) {
        this.pregunta = pregunta;
        this.respuesta_correcta = respuesta_correcta;
        this.opciones = opciones;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public String getPregunta() {
        return pregunta;
    }

    public int getRespuesta_correcta() {
        return respuesta_correcta;
    }
}
