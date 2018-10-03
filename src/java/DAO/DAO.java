/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.BankBranch;
import javax.persistence.*;

/**
 *
 * @author Lecouple Valentin & Yann Toqué
 */
public class DAO<T> {

    @PersistenceContext(unitName = "BankManagerPU")
    private EntityManager em;

    public void create(T entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction();
        em.close();
    }
}
