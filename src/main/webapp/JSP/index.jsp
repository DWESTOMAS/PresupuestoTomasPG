<%-- 
    Document   : index
    Created on : 15-oct-2018, 17:26:29
    Author     : tomlu
--%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilo.css" media="screen" />
        <title>Empresa de seguros</title>
    </head>
    <body>
        <div id="cabecera" name="cabecera">
                    <%@include file="/INC/cabecera.inc"%>
        </div>
        <div id="formulario" name="formulario">
        
            <form action="./Eleccion" method="post" name="formuEdificio">
                <p> ¿Qué tipo de edificio quiere?</p> 
                <p><input type="checkbox" name="edificio" value=true checked><label for="edifi">Seguro de edificios</label> </p>
                <p><input type="checkbox" name="contenido" value=true checked><label for="conti">Seguro de contenido</label></p>
                <p><input type="submit" name="enviar" value="enviar"></p>
            </form>
            
            
        </div>
        
    </body>
</html>
