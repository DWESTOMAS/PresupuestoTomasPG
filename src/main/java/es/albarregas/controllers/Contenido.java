/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.ContenidoBean;
import es.albarregas.models.CalcularCuota;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author tomlu
 */
@WebServlet(name = "Contenido", urlPatterns = {"/Contenido"})
public class Contenido extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        ContenidoBean contenido=new ContenidoBean();
        Double cantidadAsegura=CalcularCuota.pasarDouble(request.getParameter("valorAsegurado"));
        boolean asegurado=((request.getParameter("danosAc")!=null));
        String cantidadFranquicia=request.getParameter("canFranqui");
        contenido.setCantidadAsegurada(cantidadAsegura);
        contenido.setDanosAccidentales(asegurado);
        contenido.setFranquicia(cantidadFranquicia);
        contenido.setTotal(CalcularCuota.calcularContenido(contenido));
        StringBuilder cadena =new StringBuilder();
        cadena.append("<div id=\"contenido\" class=\"contenido\"><label>Contrato de contenido</label><p>Cobertura de daños accidentales: ");
        cadena.append((contenido.isDanosAccidentales())? "Si":"No");
        cadena.append("</p><p>La cantidad asegurada es: ");
        cadena.append(contenido.getCantidadAsegurada());
        cadena.append("</p><p>El valor de la franquicia es: ");
        cadena.append(contenido.getFranquicia());
        cadena.append("</p><p>El total del contenido es: <strong>");
        DecimalFormat df = new DecimalFormat("###,##0.00");
        cadena.append(df.format(contenido.getTotal()));
        cadena.append("€</strong></p></div>");
        String convertirCadena="";
        convertirCadena+=cadena;
        contenido.setCadenaHtml(convertirCadena);
        HttpSession miSesion=request.getSession();
        miSesion.setAttribute("contenido", contenido);
        request.getRequestDispatcher("./JSP/vista.jsp").forward(request, response);
        
        
        
        
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
