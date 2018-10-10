/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.DAO;
import beans.Client;

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
}
