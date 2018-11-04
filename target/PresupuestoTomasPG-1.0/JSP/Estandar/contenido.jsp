<%-- 
    Document   : contenido
    Created on : 19-oct-2018, 2:45:06
    Author     : tomlu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilo.css" media="screen" />
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="/INC/cabecera.inc"%>
        <div id="contenido">
            
            <form action="<%=request.getContextPath()%>/Contenido" method="post">
                <p><label>Cubrir daños accidentales </label> <input type="checkbox" name="danosAc" value="true"></p>
                <p><label>Cantidad que se requiere Asegurar: </label>
                    <select name="valorAsegurado" id="valorAsegurado">
                                <option value="10000">10.000</option>
                                <option value="20000">20.000</option>
                                <option value="30000">30.000</option>
                                <option value="50000">50.000</option>
                                <option value="100000">100.000</option>
                    </select></p>
            
                    <p><label>Franquicia: Ninguna</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="canFranqui"  value="0" checked/>     </p>
                    <p><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Quinientos</label>&nbsp;&nbsp;&nbsp;<input type="radio" name="canFranqui"  value="500" /></p>
                    <p><label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Mil</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="radio" name="canFranqui"  value="1000" /></p>
                    <p><input type="submit" value="Enviar"></p>
            </form>
        </div>
    </body>
</html>
