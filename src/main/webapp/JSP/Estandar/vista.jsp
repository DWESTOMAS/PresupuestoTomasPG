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
             DecimalFormat df = new DecimalFormat("###,##0.00");
         
            EdificioBean objeto=(EdificioBean) recuperarSesion.getAttribute("continente");
            
            if(objeto!=null){
        %><div id="continente">
            <table>
                <tr>
                    <th>Concepto</th>
                    <th>Valores asegurados</th>
                </tr>
                <tr>
                    <td>Tipo edificio</td>
                    <td><%=objeto.getTipoEdificio()%></td>
                </tr>
                <tr>
                    <td>Número de Habitaciones. </td>
                    <td> <%=objeto.getNumHabi()%></td>
                </tr>
                <tr>
                    <td> Fecha construcción </td>
                    <td> <%=objeto.getFechaConstru()%> </td>
                </tr>
                <tr>
                    <td> Tipo de construcción. </td>
                    <td> <%=objeto.getTipoConstruccion()%> </td>
                </tr>
                <tr>
                    <td> Valor de mercado. </td>
                   
                    <td> <%= df.format(objeto.getValorMercado())%>. </td>
                </tr>
                <tr>
                    <td><strong>El total prima edificio.</strong></td>
                    <td><strong> <%= df.format(objeto.getValorCuota()) %></strong></td>
                </tr>
            </table>
            
          </div>
                    <%
            totalContenido+=objeto.getValorCuota();
            }
            ContenidoBean contenido=(ContenidoBean)recuperarSesion.getAttribute("contenido");
            if(contenido!=null){
               %>
               <div id="contenido">
               <table>
                   <tr>
                       <th> Concepto. </th>
                       <th> Tipo asegurado. </th>
                   </tr>
                   <tr>
                       <td> Daños accidentales. </td>
                       <td><%=contenido.isDanosAccidentales()? "Si":"No" %></td>
                   </tr>
                   <tr>
                       <td> Cantidad asegurada. </td>
                       <td><%=df.format(contenido.getCantidadAsegurada()) %></td>
                   </tr>
                   <tr>
                       <td> El valor de la franquicia.</td>
                       <td><%=contenido.getFranquicia() %></td>
                   </tr>
                   <tr>
                       <td><strong>El total prima contenido.</strong></td>
                       <td><strong><%=df.format(contenido.getTotal())%></strong></td>
                   </tr>
               </table>
             </div>
                <%
                totalContenido+=contenido.getTotal();
            }
            
            
        %>
        <div id="agrupar" class="agrupar">
       
            
        <% 
            // DecimalFormat df = new DecimalFormat("###,##0.00");
             String total=df.format(totalContenido);
        %>
        <h3>  El total es de la prima es: <%=total%></h3>
        <a href="<%=request.getContextPath()%>">Volver</a>
        </div>
        <% recuperarSesion.invalidate();     %>
        
    </body>
</html>
