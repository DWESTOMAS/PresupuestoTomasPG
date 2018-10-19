<%-- 
    Document   : vista
    Created on : 19-oct-2018, 1:34:54
    Author     : tomlu
--%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="es.albarregas.beans.ContenidoBean"%>
<%@page import="es.albarregas.beans.EdificioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/estilo.css" media="screen" />
        <title>Total Seguro</title>
    </head>
    <body>
        <%@include file="/INC/cabecera.inc"%>
        <h1>Calculo de la prima del seguro</h1>
        <%
            double totalContenido=0;
            String cadenaMostrar="";
            String cadena="";
            HttpSession recuperarSesion = request.getSession();
            EdificioBean objeto=(EdificioBean) recuperarSesion.getAttribute("continente");
            if(objeto!=null){
            cadenaMostrar=objeto.getCadenaVisualizar();
            totalContenido+=objeto.getValorCuota();
            }
            ContenidoBean contenido=(ContenidoBean)recuperarSesion.getAttribute("contenido");
            if(contenido!=null){
                cadena=contenido.getCadenaHtml();
                totalContenido+=contenido.getTotal();
            }
            
            
        %>
        <div id="agrupar" class="agrupar">
        <%=cadenaMostrar%>
        <%=cadena%>
        <% 
             DecimalFormat df = new DecimalFormat("###,##0.00");
             String total=df.format(totalContenido);
        %>
        </div>
        <h3>  El total es: <%=total%></h3>
    </body>
</html>
