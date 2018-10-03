/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;
import java.sql.Timestamp;
import javax.persistence.*;

/**
 * Classe représentant un client de la banque
 * @author Valentin LECOUPLE & Yann Toqué
 */
@Entity
public class Client{
    
    /**
     * Numéro du client. PK de la table
     */
    @Id
    @Column(nullable = false, length = 8)
    private String clientNumber;
    
    /**
     * Nom de fammilee du client
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
    private Timestamp birthDate;

    public String getClientNumber() {
        return clientNumber;
    }

    
    
    public Client() {
    }

    public Client(String clientNumber, String lastName, String firstName, Timestamp birthDate) {
        this.clientNumber = clientNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthDate = birthDate;
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

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }
    
    
}
