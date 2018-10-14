/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Service.ServiceClient;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Valentin Lecouple
 * @author Yann Toqué
 */
@WebServlet(name = "updateClientServlet", urlPatterns = {"/updateClientServlet"})
public class updateClientServlet extends HttpServlet {

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
         
        String action = request.getParameter("action");
        
        ServiceClient serviceClient = new ServiceClient();

        if ("searchAllClient".equals(action)) {
            request.setAttribute("clientList", serviceClient.getAll());
            request.getRequestDispatcher("updateClient.jsp").forward(request, response);
        } else {
            String clientNumber = request.getParameter("clientNumber");
            String clientNewFirstname = request.getParameter("clientNewFirstname");
            String clientNewLastname = request.getParameter("clientNewLastname");
            String clientNewBirthdate = request.getParameter("clientNewBirthdate");
            try {
                serviceClient.update(clientNumber, clientNewLastname, clientNewFirstname, clientNewBirthdate);
            } catch (ParseException ex) {
                Logger.getLogger(updateClientServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("accueil.jsp").forward(request, response);
        }

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
