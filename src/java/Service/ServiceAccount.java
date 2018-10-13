/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.DAO;
import beans.Account;
import beans.BankBranch;

/**
 *
 * @author Valentin LECOUPLE & Yann TOQUE
 */
public class ServiceAccount {
    DAO<Account> DAOAccount;
    DAO<BankBranch> DAOBankBranch;
    
    public ServiceAccount(){
        this.DAOAccount = new DAO();
        this.DAOBankBranch = new DAO();
    }
    
    public Account search(String pk){
        return (Account)this.DAOAccount.findByPrimaryKey(new Account(), pk);
    }
    
    public void delete(String pk){
        this.DAOAccount.delete((Account)this.DAOAccount.findByPrimaryKey(new Account(), pk));
    }
    
    public void create(String accountNumber, String label, String IBAN, String bankBranchCode, double totalMoney) throws Exception{
        BankBranch accountBankBranch = (BankBranch)this.DAOBankBranch.findByPrimaryKey(new BankBranch(), bankBranchCode);
        Account newAccount = new Account(accountNumber, label, IBAN, accountBankBranch, totalMoney, null);
        this.DAOAccount.create(newAccount);
    }
}
