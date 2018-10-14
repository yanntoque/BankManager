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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Class permettant de faire les tests
 *
 * @author Valentin Lecouple
 * @author Yann Toqué
 */
public class Main {

    public static void main(String args[]) throws ParseException {
        /*
        Example
         */

        /*DAO*/
        DAO<BankBranch> DAOBankBranch = new DAO();
        DAO<Account> DAOAccount = new DAO();
        DAO<Client> DAOClient = new DAO();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String dateInString = "11-11-1994";
        Date date = formatter.parse(dateInString);

        /*Objects*/
        BankBranch bankBranch = new BankBranch("4586", "10 rue de la banque postale");
        BankBranch bankBranch2 = new BankBranch("8565", "3 rue de la pompe");

        Client client = new Client("10025", "Jobs", "Steve", date, null);
        Client client2 = new Client("12345", "Tordvalds", "Linus", date, null);

        Collection<Client> lstClients = new ArrayList<>();
        lstClients.add(client);

        Account account = new Account("AX7850", "Compte CCP", "125522", bankBranch, 80000, lstClients);

        lstClients.add(client2);

        Account account2 = new Account("AX0000", "Compte Gold", "125522", bankBranch, 42000000, lstClients);

        /*Test des fonctions*/
        try {

            DAOBankBranch.create(bankBranch);
            DAOBankBranch.create(bankBranch2);

            DAOClient.create(client);
            DAOClient.create(client2);

            DAOAccount.create(account);
            DAOAccount.create(account2);

            Collection<Account> lstAccount = new ArrayList<>();
            lstAccount.add(account);
            client.setLstAccounts(lstAccount);
            lstAccount.add(account2);
            client2.setLstAccounts(lstAccount);

            DAOClient.update(client);
            DAOClient.update(client2);

            for (Account acc : lstAccount) {
                System.out.println(acc.toString());
            }

            DAOBankBranch.close();
            DAOAccount.close();
            DAOClient.close();

        } catch (Exception e) {
            System.err.println("Impossible de créer un tuple.");
        }
    }
}
