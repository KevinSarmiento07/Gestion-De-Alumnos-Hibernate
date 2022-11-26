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
public class Estado2RecuperarObjetoPersistente {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();

        //Recuperar un objeto de la base de datos
        Contacto contacto = null;
        
        //recuperamos el  objeto
        contacto = em.find(Contacto.class, 3);
        
        
        //detached
        System.out.println("Contracto = " + contacto);
      
    }
}
