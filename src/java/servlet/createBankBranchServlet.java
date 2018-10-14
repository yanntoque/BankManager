/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Service.ServiceBankBranch;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet permettant de créer une bankBranch selon les informations entrées par l'utilisateur
 * @author Valentin LECOUPLE & Yann TOQUE
 */
@WebServlet(name = "createBankBranchServlet", urlPatterns = {"/createBankBranchServlet"})
public class createBankBranchServlet extends HttpServlet {

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
        
        //On récupère les informations entrées par l'utilisateur
        String bankBranchCode = request.getParameter("bankBranchCode");
        String bankBranchAdress = request.getParameter("bankBranchAdress");

        //On instancie une classe de service pour procéder aux traitements
        ServiceBankBranch serviceBankBranch = new ServiceBankBranch();
        try {
            //On demande la création d'un objet dans la BDD
            serviceBankBranch.create(bankBranchCode, bankBranchAdress);
        } catch (Exception ex) {
            Logger.getLogger(createBankBranchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        //On redirige vers la page d'accueil
        request.getRequestDispatcher("accueil.jsp").forward(request, response);
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
