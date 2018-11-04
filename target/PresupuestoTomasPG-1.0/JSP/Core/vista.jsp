<%-- 
    Document   : vista
    Created on : 19-oct-2018, 1:34:54
    Author     : tomlu
--%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="es.albarregas.beans.ContenidoBean"%>
<%@page import="es.albarregas.beans.EdificioBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<%@ taglib uri="http://java.sun.com/jstl/xml" prefix="x" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/estilo.css" media="screen" />
        <title>Total Seguro</title>
    </head>
    <body>
        <%@include file="/INC/cabecera.inc"%>
        <h1>Calculo de la prima del seguro</h1>
        <c:set var="total" value="0"/>
        <c:if test="${sessionScope.continente!=null}">
            <div id="continente">
                <table>
                    <tr>
                        <th> Concepto</th>
                        <th> Tipo asegurado</th>
                    </tr>
                    <tr>
                        <td> Tipo edificio.</td>
                        <td><c:out value="${sessionScope.continente.tipoEdificio}"/></td>
                    </tr>
                    <tr>
                        <td>Numero de habitaciones</td>
                        <td><c:out value="${sessionScope.continente.numHabi}"/></td>
                    </tr>
                    <tr>
                        <td>Fecha de construcción. </td>
                        <td><c:out value="${sessionScope.continente.fechaConstru}"/></td>
                    </tr>
                     <tr>
                        <td>Tipo de construcción. </td>
                        <td><c:out value="${sessionScope.continente.tipoConstruccion}"/></td>
                    </tr>
                    <tr>
                        <td>Valor de mercado. </td>
                        <td><fmt:formatNumber value = "${sessionScope.continente.valorMercado}" type = "currency"/></td>
                    </tr>
                    <tr>
                        <td><strong>Total prima edificio.</strong></td>
                        <td><strong>
                            <fmt:formatNumber value = "${sessionScope.continente.valorCuota}" type = "currency"/>
                            
                            </strong></td>
                    </tr>
             
                </table>
                            <c:set var="total" value="${(sessionScope.continente.valorCuota)+total}"/>
            </div>
        </c:if>
        <c:if test="${sessionScope.contenido!=null}">
           <div id="contenido">
            <table>
                <tr>
                    <th> Concepto </th>
                    <th> Tipo asegurado. </th>
                </tr>
                <tr>
                    <td> Daños accidentales. </td>
                    <td><c:out value="${sessionScope.contenido.danosAccidentales? 'Si':'No'}"/></td>
                </tr>
                <tr>
                    <td> Cantidad asegurada. </td>
                    <td><fmt:formatNumber value="${sessionScope.contenido.cantidadAsegurada}" type="currency"/></td>
                </tr>
                <tr>
                    <td>Franquicia.</td>
                    <td><c:out value="${sessionScope.contenido.franquicia}"/></td>
                </tr>
                <tr>
                    <td><strong>Total prima contenido</strong></td>
                    <td><strong><fmt:formatNumber value="${sessionScope.contenido.total}" type="currency"/> </strong></td>
                </tr>
                    
            </table>
                    <c:set var="total" value="${(sessionScope.contenido.total)+total}"/>
           </div>
        </c:if>
        <div id="total">
            <h3><strong>La cantidad total de la prima es: <fmt:formatNumber value="${total}" type="currency"/> </strong></h3>
            <% 
                request.getSession().invalidate();
            
            %>
            <a href="${pageContext.request.contextPath}">Volver</a>
                
          
        </div>
      
        
    </body>
</html>
