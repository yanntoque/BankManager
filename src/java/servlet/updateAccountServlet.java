/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Service.ServiceAccount;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet permettant de mettre à jour les données d'un Account
 *
 * @author Valentin Lecouple
 * @author Yann Toqué
 */
@WebServlet(name = "updateAccountServlet", urlPatterns = {"/updateAccountServlet"})
public class updateAccountServlet extends HttpServlet {

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

        ServiceAccount serviceAccount = new ServiceAccount();

        if ("searchAllClient".equals(action)) {
            request.setAttribute("accountList", serviceAccount.getAll());
            request.getRequestDispatcher("updateAccount.jsp").forward(request, response);
        } else {
            String accountNumber = request.getParameter("accountNumber");
            String accountLabel = request.getParameter("accountLabel");
            String accountIBAN = request.getParameter("accountIBAN");
            String accountTotalMoney = request.getParameter("accountTotalMoney");
            double accountTotalMoneyDouble = Double.valueOf(accountTotalMoney);

            serviceAccount.update(accountNumber, accountLabel, accountIBAN, accountTotalMoneyDouble);
            
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
