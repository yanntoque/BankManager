/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.*;
import javax.xml.bind.annotation.*;

/**
 * Classe représentant un compte bancaire
 *
 * @author Valentin Lecouple
 * @author Yann Toqué
 */
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
@Entity
public class Account implements BeanInterface, Serializable {

    /** 
     * Numéro du compte. PK de la table
     */
    @Id
    @Column(nullable = false, length = 11)
    private String accountNumber;

    /**
     * Collection des clients liés au compte
     */
    @XmlTransient
    @ManyToMany(mappedBy = "lstAccounts")
    private Collection<Client> lstClients;

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

    public Account(String accountNumber, String label, String IBAN, BankBranch bankBranch, double totalMoney, Collection<Client> lstClients) {
        this.accountNumber = accountNumber;
        this.label = label;
        this.IBAN = IBAN;
        this.bankBranch = bankBranch;
        this.totalMoney = totalMoney;
        this.lstClients = lstClients;

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

    public Collection<Client> getLstClients() {
        return lstClients;
    }

    public void setLstClients(Collection<Client> lstClients) {
        this.lstClients = lstClients;
    }

    @Override
    public Object getPrimaryKey() {
        return getAccountNumber();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Account: %s%s", this.getAccountNumber(), System.lineSeparator()));
        sb.append(String.format("BankBranch: %s%s", this.getBankBranch().toString(), System.lineSeparator()));
        sb.append(String.format("IBAN: %s%s", this.getIBAN(), System.lineSeparator()));
        sb.append(String.format("Label: %s%s", this.getLabel(), System.lineSeparator()));
        sb.append(String.format("Total money: %s%s", this.getTotalMoney(), System.lineSeparator()));

        return sb.toString();
    }
}
