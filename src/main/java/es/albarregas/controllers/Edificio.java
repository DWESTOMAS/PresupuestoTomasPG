/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.EdificioBean;
import es.albarregas.beans.EleccionBean;
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
@WebServlet(name = "Edificio", urlPatterns = {"/Edificio"})
public class Edificio extends HttpServlet {

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
        EdificioBean continente=new EdificioBean();
        HttpSession miSesion=request.getSession();
       
        EleccionBean objeto=(EleccionBean) miSesion.getAttribute("tipoSeguro");
        if (objeto==null) {
            request.getRequestDispatcher("/JSP/index.jsp").forward(request, response);
        }else{
            //creamos el objeto
            String tipoEdifi=request.getParameter("tipoEdi");
            continente.setTipoEdificio(tipoEdifi);
            int numHabita=CalcularCuota.pasarEnteros(request.getParameter("numHabi"));
            continente.setNumHabi(numHabita);
            int fechaConstru=CalcularCuota.pasarEnteros(request.getParameter("fechaConstru"));
            continente.setFechaConstru(fechaConstru);
            String tipoConstru=request.getParameter("tipoConstruccion");
            continente.setTipoConstruccion(tipoConstru);
            Double valorMerca=Double.parseDouble(request.getParameter("valorMercado"));
            continente.setValorMercado(valorMerca);
            continente.setValorCuota(CalcularCuota.calcularContinente(continente));
            StringBuilder cadenaHtml=new StringBuilder();
            //-----es la construccion de la cadena html a visualizar
            cadenaHtml.append("<div id=\"continente\" class=\"contenido\"><legend><strong>Contrato continente</strong></legend><p>El tipo de edificio es: ");
            cadenaHtml.append(continente.getTipoEdificio());
            cadenaHtml.append("</p><p>Numero de habitaciones: ");
            cadenaHtml.append(continente.getNumHabi());
            cadenaHtml.append("</p><p>Fecha de construccion considerada: ");
            cadenaHtml.append(continente.getFechaConstru());
            cadenaHtml.append("</p><p>El tipo de construcción es: ");
            cadenaHtml.append(continente.getTipoConstruccion());
            cadenaHtml.append("</p><p>El valor de mercado: ");
            cadenaHtml.append(continente.getValorMercado());
            cadenaHtml.append("</p><p>El total del valor del continente es: <strong>");
            DecimalFormat df = new DecimalFormat("###,##0.00");
            cadenaHtml.append(df.format(continente.getValorCuota()));
            cadenaHtml.append(" €</strong></p></div>");
            String cadena="";
            cadena+=cadenaHtml;
            continente.setCadenaVisualizar(cadena);
            
            // ahora paso  a session el objeto
            miSesion.setAttribute("continente", continente);
            // y ahora compruebo si se ha marcado el contenido
            // EleccionBean objeto=(EleccionBean) miSesion.getAttribute("tipoSeguro");
            if((objeto.isContenido())){
                request.getRequestDispatcher("./JSP/contenido.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("./JSP/vista.jsp").forward(request, response);
            }
            
            
            //miSesion.getAttribute("tipoSeguro");
            
            
            
            
            
            
            
          EleccionBean eleccion=(EleccionBean) miSesion.getAttribute("tipoSeguro");
        
        
        
        }
        
        
        
         
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
