/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kass.test.ciclovida;

import co.com.kass.domain.Contacto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kevin
 */
public class Estado4EliminarObjeto {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        //Definir una variable
        Contacto contacto = null;

        //recuperar el objeto
        contacto = em.find(Contacto.class, 3);
        em.getTransaction().begin();

        //2. Remove
        em.remove(em.merge(contacto));
        em.getTransaction().commit();

        //3. Transitivo
        System.out.println("Contacto: " + contacto);
    }
}
