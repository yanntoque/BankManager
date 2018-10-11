/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Valentin Lecouple
 * @author Yann Toqué
 */
/**
 * Cette classe correspond à l'Agence bancaire
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BankBranch")
@Entity
public class BankBranch implements BeanInterface {

    /**
     * Clé primaire de l'entité BankBranch
     */
    @XmlElement(name = "code")
    @Id
    @Column(nullable = false, length = 5)
    private String code;

    /**
     * Adresse de la BankBranch
     */
    @XmlElement(name = "address")
    @Column(nullable = false)
    private String address;

    public BankBranch() {
    }

    public BankBranch(String code, String address) {
        this.code = code;
        this.address = address;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public Object getPrimaryKey() {
        return getCode();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Code: %s%s", this.getCode(), System.lineSeparator()));
        sb.append(String.format("Adresse: %s%s", this.getAddress(), System.lineSeparator()));

        return sb.toString();
    }
}
