package com.maldonado.android.model;

/**
 * Created by MALDONADO on 29/02/2016.
 */
public class Preguntas {
    private Integer mIdResTexto;
    private Boolean mRespuestaVerdadera;

    public Preguntas(Integer mIdResTexto, Boolean mRespuestaVerdadera){
        this.mIdResTexto=mIdResTexto;
        this.mRespuestaVerdadera=mRespuestaVerdadera;
    }

    public void setmIdResTexto (Integer mIdResTexto) {
        this.mIdResTexto=mIdResTexto;
    }

    public Integer getmIdResTexto(){
        return mIdResTexto;
    }

    public void setmRespuestaVerdadera (boolean mRespuestaVerdadera){
        this.mRespuestaVerdadera=mRespuestaVerdadera;
    }

    public boolean ismRespuestaVerdadera () {
        return  mRespuestaVerdadera;
    }
}
