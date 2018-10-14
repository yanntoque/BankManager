/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import DAO.DAO;
import beans.Account;
import beans.BankBranch;
import beans.Client;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Serlvet permettant de chercher n'importe quel objet (quel que soit sont type) dans la BDD grace à l'introspection
 * @author Valentin Lecouple
 * @author Yann Toqué
 *
 */
@WebServlet(name = "findServlet", urlPatterns = {"/findServlet"})
public class findServlet extends HttpServlet {

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

        //On récupère le nom de la classe de service à instancier en paramètre et la clé primaire de l'objet à rechercher
        String maClasseString = request.getParameter("rechercheClass");
        String primaryKey = request.getParameter("recherchePk");
        System.out.println(maClasseString + primaryKey);

        //On prépare l'instanciation de la classe
        Class maClasse;
        Class[] paramTypes = new Class[1];
        paramTypes[0] = String.class;

        try {
            //On instancie la classe de service et on invoque sa méthode search.
            //Toutes les classes de service souhaitant pouvoir être utilisées par cette servlet doivent implémenter la méthode search
            maClasse = Class.forName("Service." + maClasseString);
            Object classeInstance = maClasse.newInstance();
            Method searchMethode;
            searchMethode = maClasse.getMethod("search", paramTypes);
            Object obj = searchMethode.invoke(classeInstance, primaryKey);
            
            if(obj == null){
                obj = "Aucun résultat pour cette recherche";
            }
            
            //On ajoute dans les objets retournés le résultat de la recherche
            request.setAttribute("lastSearchResult", obj);
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException ex) {
            Logger.getLogger(findServlet.class.getName()).log(Level.SEVERE, null, ex);
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
