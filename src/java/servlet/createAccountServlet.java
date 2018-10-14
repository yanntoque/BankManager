/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Service.ServiceAccount;
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
 * Servlet permettant de créer un objet Account dans la BDD après remplissage d'un formulaire adapté par un utilisateur
 * @author Valentin LECOUPLE
 * @author Yann TOQUE
 */
@WebServlet(name = "createAccountServlet", urlPatterns = {"/createAccountServlet"})
public class createAccountServlet extends HttpServlet {

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
        String accountNumber = request.getParameter("accountNumber");
        String accountLabel = request.getParameter("accountLabel");
        String accountIBAN = request.getParameter("accountIBAN");
        String accountBankBranchCode = request.getParameter("accountBankBranchCode");
        String accountTotalMoney = request.getParameter("accountTotalMoney");

        //On instancie une classe de service pour procéder aux traitements
        ServiceAccount serviceAccount = new ServiceAccount();
        try {
            //On demande à la classe de servicede créer un objet dans la BDD
            serviceAccount.create(accountNumber, accountLabel, accountIBAN, accountBankBranchCode, Double.valueOf(accountTotalMoney));
        } catch (Exception ex) {
            Logger.getLogger(createAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
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
