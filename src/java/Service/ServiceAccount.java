/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.DAO;
import beans.Account;

/**
 *
 * @author Valentin LECOUPLE & Yann TOQUE
 */
public class ServiceAccount {
    DAO<Account> DAOAccount;
    
    public ServiceAccount(){
        this.DAOAccount = new DAO();
    }
    
    public Account search(String pk){
        return (Account)this.DAOAccount.findByPrimaryKey(new Account(), pk);
    }
    
    public void delete(String pk){
        this.DAOAccount.delete((Account)this.DAOAccount.findByPrimaryKey(new Account(), pk));
    }
}
