/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.albarregas.controllers;

import es.albarregas.beans.EleccionBean;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Eleccion", urlPatterns = {"/Eleccion"})
public class Eleccion extends HttpServlet {

    
 /*  public Edificio(){
       super();
   }*/
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
       
        EleccionBean tipoSeguro=new EleccionBean();
        
        tipoSeguro.setContenido(false);
        tipoSeguro.setContinente(Boolean.FALSE);
        HttpSession miSesion=null;
        //Declaro la variable para que pueda añadir una ruta u otra;
        //aqui creo mi sesion--------------------------------------------------------
        
       // HttpSession misesion=request.getSession();
      
      // url+=((request.getParameter("oculto")).equals("jsp"))? "./JSP/Estandar/":"./JSP/Core/";
       
       String url="";
            url+=((request.getParameter("oculto")).equals("jsp"))? "/JSP/Estandar/":"/JSP/Core/";
       String urlSesion=url;
       if(request.getParameter("edificio")==null && request.getParameter("contenido")==null){
       
            url+="index.jsp";
       }else{
           miSesion=request.getSession();
       
            if(request.getParameter("edificio")!=null && request.getParameter("contenido")!=null){
                         
                         tipoSeguro.setContinente(Boolean.TRUE);
                         tipoSeguro.setContenido(Boolean.TRUE);
                         miSesion.setAttribute("tipoSeguro", tipoSeguro);
                         miSesion.setAttribute("direccion", urlSesion);
                         url+="edificio.jsp";
           //como para todos los demás opciones hay que crear sesion pues hago else creo la sesión y por
           //cada opción guardamos los datos en sesión también el map de la sesión guardaré si es estandar o jslt
       
            } else if(request.getParameter("edificio")==null && request.getParameter("contenido")!=null){
                        tipoSeguro.setContinente(false);
                        tipoSeguro.setContenido(Boolean.TRUE);
                        miSesion.setAttribute("tipoSeguro", tipoSeguro);
                        miSesion.setAttribute("direccion", urlSesion);
                        url+="contenido.jsp";
                        
            }else if(request.getParameter("edificio")!=null && request.getParameter("contenido")==null){
                            tipoSeguro.setContinente(Boolean.TRUE);
                            tipoSeguro.setContenido(false);
                            miSesion.setAttribute("tipoSeguro", tipoSeguro);
                            miSesion.setAttribute("direccion", urlSesion);
                            url+="edificio.jsp";
                            
            
            }
       
       }
       
        request.getRequestDispatcher(url).forward(request,response);
       
       /* String url="";
        
        if(request.getParameter("edificio")!=null && request.getParameter("contenido")!=null){
                         
                         tipoSeguro.setContinente(Boolean.TRUE);
                         tipoSeguro.setContenido(Boolean.TRUE);
                         misesion.setAttribute("tipoSeguro", tipoSeguro);
                         //url="./JSP/edificio.jsp";
                          request.getRequestDispatcher("./JSP/edificio.jsp").forward(request, response);

                         
        
        }else if(request.getParameter("edificio")==null && request.getParameter("contenido")!=null){
                        tipoSeguro.setContinente(false);
                        tipoSeguro.setContenido(Boolean.TRUE);
                        misesion.setAttribute("tipoSeguro", tipoSeguro);
                       
                      request.getRequestDispatcher("./JSP/contenido.jsp").forward(request, response);
                        
        }else if(request.getParameter("edificio")!=null && request.getParameter("contenido")==null){
                            tipoSeguro.setContinente(Boolean.TRUE);
                            tipoSeguro.setContenido(false);
                            misesion.setAttribute("tipoSeguro", tipoSeguro);
                          
                        request.getRequestDispatcher("./JSP/edificio.jsp").forward(request, response);
                        
        }else if(request.getParameter("edificio")==null && request.getParameter("contenido")==null){
                        // out.println("<p>No has cogido ninguna de las elecciones</p>");
                        misesion.setAttribute("tipoSeguro", tipoSeguro);
                        misesion.invalidate();
                       
                         request.getRequestDispatcher("./JSP/index.jsp").forward(request, response);
                       // request.getRequestDispatcher("./JSP/index.jsp").forward(request, response);
        }
         
              //  request.getRequestDispatcher("./JSP/edificio.jsp").forward(request, response);
        
        */
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
