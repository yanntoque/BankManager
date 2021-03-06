/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import beans.BankBranch;    
import java.util.List;
import javax.persistence.*;

/**
 *  Classe DAO générique permettant de traiter les beans, quels qu'ils soient
 *  @author Valentin Lecouple
 *  @author Yann Toqué
 */
public class DAO<T> {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("BankManagerPU");
    EntityManager em = emf.createEntityManager();
    
    
    
    /**
     * Permet de fermer la connexion de l'entity manager
     */
    public void close(){
        em.close();
    }

    /**
     * Permet de créer un tuple dans la base de données
     *
     * @param entity
     * @throws java.lang.Exception
     */
    public void create(T entity) throws Exception {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        
    }

    /**
     * Permet de modifier un tuple dans la base données
     *
     * @param entity
     */
    public void update(T entity) {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
        
    }

    /**
     * Permet de supprimer un tuple de la base données
     *
     * @param entity
     */
    public void delete(T entity) {
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
        
    }

    /**
     * Permet de trouver un tuple par sa clé primaire dans la base de données
     *
     * @param entity
     */
    public Object findByPrimaryKey(T entity, Object primaryKey) {
        em.getTransaction().begin();
        Object o = em.find(entity.getClass(), primaryKey);
        em.getTransaction().commit();
        
        return o;
    } 

    /**
     * Permet de récupérer tous les tuples d'une table 
     * @param entity
     * @return 
     */
    public  List<T> findAll(T entity){
        List result =  em.createQuery(String.format("SELECT p FROM %s p", entity.getClass().getName()),entity.getClass()).getResultList();
        return result;
    }
}
