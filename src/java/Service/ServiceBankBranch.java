/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import DAO.DAO;
import beans.BankBranch;

/**
 *
 * @author Valentin LECOUPLE & Yann TOQUE
 */
public class ServiceBankBranch {
     DAO<BankBranch> DAOBankBranch;
    
    public ServiceBankBranch(){
        this.DAOBankBranch = new DAO();
    }
    
    public BankBranch search(String pk){
        return (BankBranch)this.DAOBankBranch.findByPrimaryKey(new BankBranch(), pk);
    }
    
    public void delete(String pk){
        this.DAOBankBranch.delete((BankBranch)this.DAOBankBranch.findByPrimaryKey(new BankBranch(), pk));
    }
}
