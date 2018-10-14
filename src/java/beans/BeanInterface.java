/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 * Intreface imposant aux beans qui l'utilisent d'implémenter la méthode getPrimaryKey()
 * @author Valentin Lecouple
 * @author Yann Toqué
 */
public interface BeanInterface<T> {
    /**
     * Méthode permettant, pour n'importe quel bean, de récupérer sa clé primaire
     * @return Retourne la clé primaire de l'objet appelant cette méthode
     */
    public Object getPrimaryKey();
}
