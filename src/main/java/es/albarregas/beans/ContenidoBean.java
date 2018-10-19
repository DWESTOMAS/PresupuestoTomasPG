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
public class ContenidoBean implements Serializable {
    private double cantidadAsegurada;
    private boolean danosAccidentales;
    private String franquicia;
    private double total;
    private String cadenaHtml;

    public double getCantidadAsegurada() {
        return cantidadAsegurada;
    }

    public void setCantidadAsegurada(double cantidadAsegurada) {
        this.cantidadAsegurada = cantidadAsegurada;
    }

    public boolean isDanosAccidentales() {
        return danosAccidentales;
    }

    public void setDanosAccidentales(boolean danosAccidentales) {
        this.danosAccidentales = danosAccidentales;
    }

    public String getFranquicia() {
        return franquicia;
    }

    public void setFranquicia(String franquicia) {
        this.franquicia = franquicia;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCadenaHtml() {
        return cadenaHtml;
    }

    public void setCadenaHtml(String cadenaHtml) {
        this.cadenaHtml = cadenaHtml;
    }
    
    
    
}
