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
 * Class permettant de faire les tests
 *
 *  @author Valentin Lecouple
 *  @author Yann Toqué
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
        BankBranch bankBranch2 = new BankBranch("8565", "3 rue de la pompe");
        BankBranch bankBranch3 = new BankBranch("zz", "zz");

        Account account = new Account("AX7850", "Compte CCP", "125522", bankBranch, 80000);
        Client client = new Client("10025", "Jobs", "Steve", dateNow);

        /*DAO*/
        DAO<BankBranch> DAOBankBranch = new DAO();
        DAO<Account> DAOAccount = new DAO();
        DAO<Client> DAOClient = new DAO();

        /*Test des fonctions*/
        try {
     
            BankBranch bb = (BankBranch) DAOBankBranch.findByPrimaryKey(bankBranch, "4586");
            bb.setAddress("adresse modifiée x4");
            DAOBankBranch.update(bb);
            
            DAOBankBranch.close();
            DAOAccount.close();
            DAOClient.close();

        } catch (Exception e) {
            System.err.println("Impossible de créer un tuple.");
        }
    }
}
