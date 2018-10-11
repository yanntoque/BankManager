/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webservice;

import DAO.DAO;
import beans.Account;
import beans.BankBranch;
import beans.Client;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Valentin Lecouple
 * @author Yann Toqué
 */
@WebService(serviceName = "BankWS")
public class BankWS {

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "findClientById")
    public Client findClientById(@WebParam(name = "clientId") String clientId){
        DAO<Client> DAOClient = new DAO();
        return (Client)DAOClient.findByPrimaryKey(new Client(), clientId);
    }
    
    @WebMethod(operationName = "getAllClients")
    public List<Client> getAllClients(){
        DAO<Client> DAOClient = new DAO();
        return (List<Client>)DAOClient.findAll(new Client());
    }
    
    @WebMethod(operationName = "createBankBranch")
    public void createBankBranch(@WebParam(name = "numAgence") String numAgence, @WebParam(name = "adresseAgence") String adresseAgence) throws Exception{
        BankBranch newBankBranch = new BankBranch(numAgence, adresseAgence);
        DAO<BankBranch> DAOBankBranch = new DAO();
        DAOBankBranch.create(newBankBranch);
    }
    
    @WebMethod(operationName = "deleteAccount")
    public void deleteAccount(@WebParam(name = "numAccount") String numAccount){
        DAO<Account> DAOAccount = new DAO();
        DAOAccount.delete((Account)DAOAccount.findByPrimaryKey(new Account(), numAccount));
    }
}
