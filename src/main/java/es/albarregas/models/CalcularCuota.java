/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.models;

import es.albarregas.beans.ContenidoBean;
import es.albarregas.beans.EdificioBean;
import java.text.DecimalFormat;

/**
 *
 * @author tomlu
 */
public class CalcularCuota {
    
    public static double calcularContinente(EdificioBean edificio){
        double total=0;
                String tipoEdi=edificio.getTipoEdificio();
                int fechaDeConstruccion=edificio.getFechaConstru();
                String tipoCons=edificio.getTipoConstruccion();
                int numeroHabitacion=edificio.getNumHabi();
                double valorMercado=edificio.getValorMercado();
               /**
                *  private String tipoEdificio;
                   private int numHabi;
                   private String fechaConstru;
                   private String tipoConstruccion;
                   private double valorMercado;
               
                * 
                * 
                */
                    double prima=0.0;
                   double cuotaBasica=edificio.getValorMercado()*0.005;
                   double prueba=0.0;
                  
                   switch (tipoEdi){
                       case "piso" :
                                                    cuotaBasica+=cuotaBasica * 0.95;
                                                    break;
                       case "casa":                 cuotaBasica=cuotaBasica * 1.0;
                                                    break;
                       case "adosado":              cuotaBasica=cuotaBasica * 1.05;
                                                    break;
                       case "duplex":               cuotaBasica=cuotaBasica * 1.10;
                                                    break;
                       case "chalet":                cuotaBasica=cuotaBasica * 1.20;
                                                    break;
                       
                       default://Por si sale un error la cuotaBasica pongo el default y la multiplicaremos por la mayor
                           cuotaBasica+=cuotaBasica * 1.20;
                   
                   
                   }
                        prima=cuotaBasica;
                        prima+=numeroHabitacion*(cuotaBasica /100.0);
                        
                        switch (fechaDeConstruccion){
                            case 1949: prima+=prima * 0.09;
                                       break;
                            case 1950: prima+=prima * 0.06;
                                       break;
                            case 1991: prima+=prima * 0.04;
                                       break;
                            case 2006: prima+=prima * 0.02;
                                       break;
                            case 2016: prima+=prima * 0.01;
                                       break;
                            default:
                                prima+=prima * 0.09;
                                        break;
                        
                        }
                        
                        if(tipoCons.equals("madera")){
                            prima+=prima * 0.1;
                        }
                      
        
        return prima;
    }
    public static double calcularContenido(ContenidoBean contenido){
    
        double prima=0.0;
        
        prima+=contenido.getCantidadAsegurada() * 0.008;
    
        if(contenido.isDanosAccidentales()){
        prima=prima*1.60;
        }
        if(contenido.getFranquicia().equals("500")){
            prima-=(prima * 0.1);
        }else if(contenido.getFranquicia().equals("1000")){
            prima-=(prima * 0.2);
        }
    
    
    
    
    
    
    
    return prima;
    }
    
    public static int pasarEnteros(String numero){
        int numeroEnt=0;
        try {
            numeroEnt=Integer.parseInt(numero);
        }catch(NumberFormatException e){
        
            numeroEnt=0;
        }    
        
        return numeroEnt;
    }
    public static double pasarDouble(String numero){
        double numeroDou=0.0;
        
        try{
            numeroDou=Double.parseDouble(numero);
        
        }catch(NumberFormatException e){
        
            numeroDou=0.0;
        }
    
    
    return numeroDou;
    
    }
    
}
