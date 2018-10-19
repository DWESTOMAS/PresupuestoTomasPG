/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;

/**
 *
 * @author tomlu
 */
public class EleccionBean implements Serializable{
    
    private boolean continente;
    private boolean contenido;

    public boolean isContinente() {
        return continente;
    }

    public void setContinente(Boolean continente) {
        this.continente=continente;
        //this.continente = continente;
    }

    public boolean isContenido() {
        return contenido;
    }

    public void setContenido(Boolean contenido) {
        this.contenido = contenido;
    }
    
}
