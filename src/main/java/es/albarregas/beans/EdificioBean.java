/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author tomlu
 */
public class EdificioBean implements Serializable{
    
    private String tipoEdificio;
    private int numHabi;
    private int fechaConstru;
    private String tipoConstruccion;
    private double valorMercado;
    private double valorCuota;//Es el total de lo que cuesta el seguro porque hay que pasarlo, y lo añado a session
    

    public String getTipoEdificio() {
        return tipoEdificio;
    }

    public void setTipoEdificio(String tipoEdificio) {
        this.tipoEdificio = tipoEdificio;
    }

    public int getNumHabi() {
        return numHabi;
    }

    public void setNumHabi(int numHabi) {
        this.numHabi = numHabi;
    }

    public int getFechaConstru() {
        return fechaConstru;
    }

    public void setFechaConstru(int fechaConstru) {
        this.fechaConstru = fechaConstru;
    }

    public String getTipoConstruccion() {
        return tipoConstruccion;
    }

    public void setTipoConstruccion(String tipoConstruccion) {
        this.tipoConstruccion = tipoConstruccion;
    }

    public double getValorMercado() {
        return valorMercado;
    }

    public void setValorMercado(double valorMercado) {
        this.valorMercado = valorMercado;
    }

    public double getValorCuota() {
        return valorCuota;
    }

    public void setValorCuota(double valorCuota) {
        this.valorCuota = valorCuota;
    }

   
    
    
    
    
    
    
    
}
