/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet permettant de supprimer dans la BDD n'importe quel bean en utilisant l'introsepction.
 * La classe de service à utiliser est envoyées en paramètre et est instanciée grace à class.forName
 * Cela permet de n'avoir qu'une seul servlet pour traiter tous les beans
 * @author Valentin LECOUPLE & Yann TOQUE
 */
@WebServlet(name = "deleteServlet", urlPatterns = {"/deleteServlet"})
public class deleteServlet extends HttpServlet {


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
        
        //On récupère le nom de la classe de service à utiliser et la clé primaire de l'objet à supprimer
        String maClasseString = request.getParameter("deleteClass");
        String primaryKey = request.getParameter("deletePk");
        System.out.println(maClasseString + primaryKey);

        //On prépare l'instanciation de la classe de service
        Class maClasse;
        Class[] paramTypes = new Class[1];
        paramTypes[0] = String.class;

        try {
            //On instancie la classe de service et on invoque une de ses méthodes
            //Toutes les classes de service voulant permettre la suppression d'un objet doivent avoir une méthode delete
            maClasse = Class.forName("Service." + maClasseString);
            Object classeInstance = maClasse.newInstance();
            Method searchMethode;
            Method deleteMethode = maClasse.getMethod("delete", paramTypes);
            deleteMethode.invoke(classeInstance, primaryKey);
            
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
