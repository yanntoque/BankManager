/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.DAO;
import beans.Account;
import beans.Client;
import beans.BankBranch;
import java.sql.Timestamp;
import java.util.Date;

/**
 *  Class permettant de faire les tests
 * @author Valentin Lecouple et Yann Toqué
 */
public class Main {
    public static void main(String args[]) {
        /*
        Example
         */
        Date date = new Date();
        Timestamp dateNow = new Timestamp(date.getTime());
        /*Objects*/
        BankBranch bankBranch = new BankBranch("4586", "10 rue de la banque postale");
        Account account = new Account("AX7850", "Compte CCP", "125522", bankBranch, 80000);
        Client client = new Client("10025", "Jobs", "Steve", dateNow);
        /*DAO*/
        DAO<BankBranch> DAOBankBranch = new DAO();
        DAOBankBranch.create(bankBranch);
        DAO<Account> DAOAccount = new DAO();
        DAOAccount.create(account);
        DAO<Client> DAOClient = new DAO();
        DAOClient.create(client);
    }
}
