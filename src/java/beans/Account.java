/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.persistence.*;

/**
 * Classe représentant un compte bancaire
 * @author Valentin LECOUPLE & Yann Toqué
 */
@Entity
public class Account {
    /**
     * Numéro du compte. PK de la table
     */
    @Id
    @Column(nullable = false, length = 11)
    private String accountNumber;
  
    /**
     * Label du compte
     */
    @Column(nullable = false)
    private String label;
    
    /**
     * IBAN du compte. Maximum de 27 caractères
     */
    @Column(nullable = false, length = 27)
    private String IBAN;
    
    /**
     * Agence à laquelle le compte est lié
     */
    @JoinColumn(nullable = false)
    private BankBranch bankBranch;
    
    /**
     * Somme d'argent présente sur le compte
     */
    @Column(nullable = false)
    private double totalMoney;

    
    
    public Account() {
    }

    public Account(String accountNumber, String label, String IBAN, BankBranch bankBranch, double totalMoney) {
        this.accountNumber = accountNumber;
        this.label = label;
        this.IBAN = IBAN;
        this.bankBranch = bankBranch;
        this.totalMoney = totalMoney;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIBAN() {
        return IBAN;
    }

    public void setIBAN(String IBAN) {
        this.IBAN = IBAN;
    }

    public BankBranch getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(BankBranch bankBranch) {
        this.bankBranch = bankBranch;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
    
    
}
