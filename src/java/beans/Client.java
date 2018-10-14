/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

/**
 * Classe représentant un client de la banque
 *
 * @author Valentin Lecouple
 * @author Yann Toqué
 */
@XmlRootElement
@XmlAccessorType(value = XmlAccessType.FIELD)
@Entity
public class Client implements BeanInterface, Serializable {

    /**
     * Numéro du client. PK de la table
     */
    @Id
    @Column(nullable = false, length = 8)
    private String clientNumber;

    /**
     * Collection des comptes du client
     */
    @XmlTransient
    @ManyToMany
    @JoinTable(name = "client_accounts",
            joinColumns = @JoinColumn(name = "client_Number", referencedColumnName = "clientNumber"),
            inverseJoinColumns = @JoinColumn(name = "account_Number", referencedColumnName = "accountNumber"))
    private Collection<Account> lstAccounts;

    /**
     * Nom de famille du client
     */
    @Column(nullable = false)
    private String lastName;

    /**
     * Prénom du client
     */
    @Column(nullable = false)
    private String firstName;

    /**
     * Date de naissance du client
     */
    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    public String getClientNumber() {
        return clientNumber;
    }

    public Client() {
    }

    public Client(String clientNumber, String lastName, String firstName, Date birthDate, Collection<Account> lstAccounts) {
        this.clientNumber = clientNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.lstAccounts = lstAccounts;
    }

    public void setClientNumber(String clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public Collection<Account> getLstAccounts() {
        return lstAccounts;
    }

    public void setLstAccounts(Collection<Account> lstAccounts) {
        this.lstAccounts = lstAccounts;
    }

    @Override
    public Object getPrimaryKey() {
        return getClientNumber();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Nom: %s%s", this.getLastName(), System.lineSeparator()));
        sb.append(String.format("Prénom : %s%s", this.getFirstName(), System.lineSeparator()));
        sb.append(String.format("Date de naissance: %s%s", this.getBirthDate().toString(), System.lineSeparator()));

        return sb.toString();
    }
}
