<%-- 
    Document   : edificio
    Created on : 18-oct-2018, 12:02:28
    Author     : tomlu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilo.css" media="screen" />
        <title>Formulario continente</title>
    </head>
    <body>
        <%@include file="/INC/cabecera.inc"%>
        <div id="FormularioContinente">
            <form name="formuEdificio" method="Post" action="./Edificio">
                        <p><label for="tipo">Tipo de edificio: </label><select name="tipoEdi" id="tipoEdi">
                                <option value="piso">piso</option>
                                <option value="casa">casa</option>
                                <option value="duplex">duplex</option>
                                <option value="adosado">adosado</option>
                                <option value="chalet">chalet</option>
                    </select></p>
                            <p><label for="numHabi">Número de habitaciones: </label><select name="numHabi" id="numHabi">
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                    <option value="5">5 o más</option>
                                    
                        </select></p>
                        <p>
                            <label for="fechaConstru">Año de construcción: </label>
                            <select name="fechaConstru">
                                <option value="1949">Antes de 1950</option>
                                <option value="1950">Entre 1950 y 1990</option>
                                <option value="1991">Entre 1991 y 2005</option>
                                <option value="2006">Entre 2006 y 2015</option>
                                <option value="2016">Después de 2016</option>
                            </select>
                        </p>
                        <p>
                            <label>Tipo de construcción: </label><input type="radio" name="tipoConstruccion" value="madera"><label>Madera   </label><input type="radio" name="tipoConstruccion" value="hormigon" required><label>Hormigón</label>
                        </p>
                        <p>
                            <select name="valorMercado">
                                <option value="25000">Menos de 50.000</option>
                                <option value="50001">Entre 50.001 y 80.000</option>
                                <option value="80001">Entre 80.001 y 100.000</option>
                                <option value="100001">Entre 100.001 y 150.000</option>
                                <option value="125000">Más de 150.000</option>
                            </select>
                        </p>
                        <p>
                            
                            <input type="submit" value="Enviar"> 
                        </p>
            </form>
            
            
            
            
        </div>
    </body>
</html>
