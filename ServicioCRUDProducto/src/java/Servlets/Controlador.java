/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Modelo.UserService;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import webservice.User;

/**
 *
 * @author pedro
 */
public class Controlador extends HttpServlet {

    String add="add.jsp";
    String edit="edit.jsp";
    String index="index.jsp";
    String Login="Login.jsp";
    String acceso="";
    UserService user=new UserService();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion=request.getParameter("accion");
        if(accion.equals("add")){
            acceso=add;
        }
        else if(accion.equals("Guardar")){
            String cod=request.getParameter("txtcodigo");
            String nom=request.getParameter("txtnombre");
            float prec=Float.parseFloat(request.getParameter("txtprecio"));
            int can=Integer.parseInt(request.getParameter("txtcantidad"));
            user.agregar(cod, nom, prec, can);
            acceso=index;
        }
        else if(accion.equals("editar")){
            acceso=edit;
            request.setAttribute("codigoProducto", request.getParameter("codigoProducto"));  
        }
        else if(accion.equals("Actualizar")){
            String cod=request.getParameter("txtcodigo");
            String nom=request.getParameter("txtnombre");
            float prec=Float.parseFloat(request.getParameter("txtprecio"));
            int can=Integer.parseInt(request.getParameter("txtcantidad"));
            user.actualizar(cod, nom, prec, can);
            acceso=index;
        }
        else if(accion.equals("eliminar")){
            String cod=request.getParameter("codigoProducto");
            user.eliminar(cod);
            acceso=index;
        }
        else if (accion.equals("login")) {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
                if (username.equals("usuario") && password.equals("user123")) { // reemplaza "usuario" y "user123" con las credenciales que quieras
                // inicio de sesión exitoso, redirige al usuario a la página principal
                request.getSession().setAttribute("username", username);
                acceso = index;
                } else {
                    // inicio de sesión fallido, muestra un mensaje de error
                       request.setAttribute("errorMessage", "Invalid username or password");
                       acceso = Login; // reemplaza "login" con la ruta a tu página de inicio de sesión
                    }
        }
        else if (accion.equals("buscar")) {
            String buscar = request.getParameter("buscar");
            List<User> productos = user.buscarPorCodigoONombre(buscar);
            request.setAttribute("productos", productos);
            acceso = index;
        }

        else{
            acceso=index;
        }
        RequestDispatcher dispatcher=request.getRequestDispatcher(acceso);
        dispatcher.forward(request, response);
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

