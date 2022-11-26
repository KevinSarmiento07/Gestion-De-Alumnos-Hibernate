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
public class Estado3ModificarObjetoPersistente {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        //1. Estado Transitivo
        Contacto contacto = null;

        //2. Estado transitivo
        contacto = em.find(Contacto.class, 3);

        //Modificamos el objeto
        contacto.setEmail("kass2@gmail.com");
        em.getTransaction().begin();

        //2. Persisitimos
        em.merge(contacto);
        //em.flush();  Es otra forma para actualizar los datos
        em.getTransaction().commit();

        //3. Detached representado en la base de datos
        System.out.println("Contacto: " + contacto);
    }
}
