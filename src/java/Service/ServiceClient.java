/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.DAO;
import beans.Client;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe de service permettant de faire le lien entre une servlet traitant un client et la classe de DAO
 * @author Valentin LECOUPLE & Yann TOQUE
 */
public class ServiceClient {

    DAO<Client> DAOClient;

    /**
     * Constructeur
     */
    public ServiceClient() {
        this.DAOClient = new DAO();
    }

    /**
     * Méthode permettant de faire une recherche avec le DAO
     * @param pk Clé primaire
     * @return Retourne un objet Account correspondant à la clé primaire
     */
    public Client search(String pk) {
        return (Client) this.DAOClient.findByPrimaryKey(new Client(), pk);
    }

    /**
     * Méthode permettant de supprimer un objet avec le DAO
     * @param pk Clé primaire de l'objet à supprimer
     */
    public void delete(String pk) {
        this.DAOClient.delete((Client) this.DAOClient.findByPrimaryKey(new Client(), pk));
    }

    /**
     * Méthode permettant de créer un objet avec le DAO
     * @param clientNumber Numéro du client (clé primaire)
     * @param lastName Nom de famille du client
     * @param firstName Prénom du client
     * @param birthDate Date de naissance du client
     * @throws ParseException
     * @throws Exception 
     */
    public void create(String clientNumber, String lastName, String firstName, String birthDate) throws ParseException, Exception {
        Date newDate = new SimpleDateFormat("dd-MM-yyyy").parse(birthDate);
        Client newClient = new Client(clientNumber, lastName, firstName, newDate, null);
        this.DAOClient.create(newClient);
    }
}
