/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kass.test.cascade;

import co.com.kass.domain.Alumno;
import co.com.kass.domain.Contacto;
import co.com.kass.domain.Domicilio;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author kevin
 */
public class PersistenciaCascadaTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        
        //Con la persistencia en casacada nos ahorramos el hecho de tener que guardar
        //los objetos, ya que sin cascade, no se crea el id, pero con persistencia en casacda si
        
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Putumayo");
        domicilio.setNoCalle("10");
        domicilio.setPais("Colombia");
        
        Contacto contacto = new Contacto();
        contacto.setEmail("PedritoH@gmail.com");
        contacto.setTelefono("44332211");
        
        
        Alumno alumno = new Alumno();
        alumno.setNombre("Pedrito");
        alumno.setApellido("Celiss");
        alumno.setDomicilio(domicilio);
        alumno.setContacto(contacto);
        
        em.getTransaction().begin();
        em.persist(alumno);
        em.getTransaction().commit();
        
        System.out.println("Alumno: " + alumno);
        
        
    }
}
