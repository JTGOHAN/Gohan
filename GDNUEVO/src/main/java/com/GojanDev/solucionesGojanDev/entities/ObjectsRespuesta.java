package com.GojanDev.solucionesGojanDev.entities;

public class ObjectsRespuesta {
    private Object objeto;
    private String mensaje;

    //Constructor
    public ObjectsRespuesta(String mensaje, Object objeto){
        this.objeto = objeto;
        this.mensaje = mensaje;
    }

    //Constructor vacio
    public ObjectsRespuesta(){
   }

   //Getters
    public Object getObjeto() {
        return objeto;
    }

    public String getMensaje() {
        return mensaje;
    }

    //Setters

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
