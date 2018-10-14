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
    
    public void create(String code, String address) throws Exception{
        BankBranch newBanckBranch = new BankBranch(code, address);
        this.DAOBankBranch.create(newBanckBranch);
    }
    
    public List<BankBranch> getAll(){
        return this.DAOBankBranch.findAll(new BankBranch());
    }
    
    public void update(String bankBranchCode, String bankBranchNewAddress){
        BankBranch bankBranchToUpdate = (BankBranch)this.DAOBankBranch.findByPrimaryKey(new BankBranch(), bankBranchCode);
        bankBranchToUpdate.setAddress(bankBranchNewAddress);
        this.DAOBankBranch.update(bankBranchToUpdate);
    }
}
