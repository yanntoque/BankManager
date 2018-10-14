/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.DAO;
import beans.Account;
import beans.BankBranch;
import java.util.List;

/**
 *  Classe de service permettant de faire le lien entre une servlet traitant un account et la classe de DAO
 * @author Valentin LECOUPLE & Yann TOQUE
 */
public class ServiceAccount {
    DAO<Account> DAOAccount;
    DAO<BankBranch> DAOBankBranch;
    
    /**
     * Constructeur de la classe
     */
    public ServiceAccount(){
        this.DAOAccount = new DAO();
        this.DAOBankBranch = new DAO();
    }
    
    /**
     * Méthode permettant de faire une recherche avec le DAO
     * @param pk Clé primaire
     * @return Retourne un objet Account correspondant à la clé primaire
     */
    public Account search(String pk){
        return (Account)this.DAOAccount.findByPrimaryKey(new Account(), pk);
    }
    
    /**
     * Méthode permettant de supprimer un objet avec le DAO
     * @param pk Clé primaire de l'objet à supprimer
     */
    public void delete(String pk){
        this.DAOAccount.delete((Account)this.DAOAccount.findByPrimaryKey(new Account(), pk));
    }
    
    /**
     * Méthode permettant de créer un objet avec le DAO
     * @param accountNumber Numéro du compte
     * @param label Label du compte
     * @param IBAN IBAN du compte
     * @param bankBranchCode Clé primaire de la bankBranch du compte
     * @param totalMoney Somme d'argent du compte
     * @throws Exception 
     */
    public void create(String accountNumber, String label, String IBAN, String bankBranchCode, double totalMoney) throws Exception{
        BankBranch accountBankBranch = (BankBranch)this.DAOBankBranch.findByPrimaryKey(new BankBranch(), bankBranchCode);
        Account newAccount = new Account(accountNumber, label, IBAN, accountBankBranch, totalMoney, null);
        this.DAOAccount.create(newAccount);
    }
    
     /**
     * Méthode permettant de récupérer toutes les entrées de la table account avec le DAO
     * @return Retourne la liste de tous les account enregistrées dans la BDD
     */
    public List<Account> getAll(){
        return this.DAOAccount.findAll(new Account());
    }
    
     /**
     * Méthode permettant de mettre à jour un account avec le DAO
     * @param bankBranchCode Clé primaire de la bankBranch à mettre à jour
     * @param bankBranchNewAddress Nouvelle valeur à associer à la bankBranch choisie
     */
    public void update(String accountNumber, String newLabel, String newIBAN, double newTotalMoney){
        Account accountToUpdate = (Account)DAOAccount.findByPrimaryKey(new Account(), accountNumber);
        accountToUpdate.setLabel(newLabel);
        accountToUpdate.setIBAN(newIBAN);
        accountToUpdate.setTotalMoney(newTotalMoney);
        this.DAOAccount.update(accountToUpdate);
    }
}
