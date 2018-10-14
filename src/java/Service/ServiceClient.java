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
import java.util.List;

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

    public List<Client> getAll() {
        return this.DAOClient.findAll(new Client());
    }

    public void update(String clientNumber, String lastName, String firstName, String birthDate) throws ParseException {
        Date newDate = new SimpleDateFormat("dd-MM-yyyy").parse(birthDate);
        Client clientToUpdate = (Client) this.DAOClient.findByPrimaryKey(new Client(), clientNumber);
        clientToUpdate.setBirthDate(newDate);
        clientToUpdate.setFirstName(firstName);
        clientToUpdate.setLastName(lastName);
        this.DAOClient.update(clientToUpdate);
    }
}
