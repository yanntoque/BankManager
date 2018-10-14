/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Service.ServiceBankBranch;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet permettant de mettre à jour un objet bankBranch dans la BDD
 * @author Valentin Lecouple 
 * @author Yann Toqué
 */
@WebServlet(name = "updateBankBranchServlet", urlPatterns = {"/updateBankBranchServlet"})
public class updateBankBranchServlet extends HttpServlet {

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
        //On récupère l'action à effectuer: soit on cherche toutes les bankBranch modifiables pour les afficher à l'utilisateur, soit on en modifie une en particuleir
        String action = request.getParameter("action");
        ServiceBankBranch serviceBankBranch = new ServiceBankBranch();

        if (action.equals("searchAllBankBranch")) {
            request.setAttribute("bankBranchList", serviceBankBranch.getAll());
            request.getRequestDispatcher("updateBankBranch.jsp").forward(request, response);
        } else {
            String bankBranchCode = request.getParameter("bankBranchCode");
            String bankBranchNewAdress = request.getParameter("bankBranchNewAddress");
            System.out.println("Servlet " + bankBranchCode + bankBranchCode);
            serviceBankBranch.update(bankBranchCode, bankBranchNewAdress);
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
