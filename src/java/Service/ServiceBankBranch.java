/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.DAO;
import beans.BankBranch;
import java.util.List;

/**
 * Classe de service permettant de faire le lien entre une servlet traitant une bankBranch et la classe de DAO
 * @author Valentin LECOUPLE & Yann TOQUE
 */
public class ServiceBankBranch {
     DAO<BankBranch> DAOBankBranch;
    
     /**
      * Constructeur de la classe
      */
    public ServiceBankBranch(){
        this.DAOBankBranch = new DAO();
    }
    
    /**
     * Méthode permettant de faire une recherche avec le DAO
     * @param pk Clé primaire
     * @return Retourne un objet Account correspondant à la clé primaire
     */
    public BankBranch search(String pk){
        return (BankBranch)this.DAOBankBranch.findByPrimaryKey(new BankBranch(), pk);
    }
    
     /**
     * Méthode permettant de supprimer un objet avec le DAO
     * @param pk Clé primaire de l'objet à supprimer
     */
    public void delete(String pk){
        this.DAOBankBranch.delete((BankBranch)this.DAOBankBranch.findByPrimaryKey(new BankBranch(), pk));
    }
    
    /**
     * Méthode permettant de créer un objet avec le DAO
     * @param code Code de la bankBranch (clé primaire)
     * @param address Adresse de la bankBranch
     * @throws Exception 
     */
    public void create(String code, String address) throws Exception{
        BankBranch newBanckBranch = new BankBranch(code, address);
        this.DAOBankBranch.create(newBanckBranch);
    }
    
    /**
     * Méthode permettant de récupérer toutes les entrées de la table bankBranch avec le DAO
     * @return Retourne la liste de toutes les bankBranch enregistrées dans la BDD
     */
    public List<BankBranch> getAll(){
        return this.DAOBankBranch.findAll(new BankBranch());
    }
    
    /**
     * Méthode permettant de mettre à jour une bankBranch avec le DAO
     * @param bankBranchCode Clé primaire de la bankBranch à mettre à jour
     * @param bankBranchNewAddress Nouvelle valeur à associer à la bankBranch choisie
     */
    public void update(String bankBranchCode, String bankBranchNewAddress){
        BankBranch bankBranchToUpdate = (BankBranch)this.DAOBankBranch.findByPrimaryKey(new BankBranch(), bankBranchCode);
        bankBranchToUpdate.setAddress(bankBranchNewAddress);
        this.DAOBankBranch.update(bankBranchToUpdate);
    }
}
