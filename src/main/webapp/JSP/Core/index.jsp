<%-- 
    Document   : index
    Created on : 03-nov-2018, 13:02:32
    Author     : tomlu
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSLT</title>
    </head>
     <body>
        <div id="cabecera" name="cabecera">
                    <%@include file="/INC/cabecera.inc"%>
        </div>
        <div id="formulario" name="formulario">
        
            <form action="${pageContext.request.contextPath}/Eleccion" method="post" name="formuEdificio">
                <p> ¿Qué tipo de edificio quiere?</p> 
                <p><input type="checkbox" name="edificio" value=true checked><label for="edifi">Seguro de edificios</label> </p>
                <p><input type="checkbox" name="contenido" value=true checked><label for="conti">Seguro de contenido</label></p>
                <input type="hidden" name="oculto" value="jslt">
                <p><input type="submit" name="enviar" value="enviar"></p>
            </form>
            
            
        </div>
        
    </body>
</html>
