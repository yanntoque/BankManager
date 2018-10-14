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
 *
 * @author Valentin LECOUPLE & Yann TOQUE
 */
public class ServiceClient {

    DAO<Client> DAOClient;

    public ServiceClient() {
        this.DAOClient = new DAO();
    }

    public Client search(String pk) {
        return (Client) this.DAOClient.findByPrimaryKey(new Client(), pk);
    }

    public void delete(String pk) {
        this.DAOClient.delete((Client) this.DAOClient.findByPrimaryKey(new Client(), pk));
    }

    public void create(String clientNumber, String lastName, String firstName, String birthDate) throws ParseException, Exception {
        Date newDate = new SimpleDateFormat("dd-MM-yyyy").parse(birthDate);
        Client newClient = new Client(clientNumber, lastName, firstName, newDate, null);
        this.DAOClient.create(newClient);
    }
}
