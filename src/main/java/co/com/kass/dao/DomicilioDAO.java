/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kass.dao;

import co.com.kass.domain.Domicilio;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author kevin
 */
public class DomicilioDAO extends GenericDAO{

    

    public List<Domicilio> listar() {

        String hql = "SELECT d FROM Domicilio d";
        em = getEntityManager();
        Query query = em.createQuery(hql);

        return query.getResultList();
    }

    public void insertar(Domicilio domicilio) {

        try {
            em.getTransaction().begin();
            em.persist(domicilio);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }
    
    
    public void modifcar(Domicilio domicilio){
        
         try {
            em.getTransaction().begin();
            em.merge(domicilio);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }
    
    public void eliminar(Domicilio domicilio){
         try {
            em.getTransaction().begin();
            em.remove(em.merge(domicilio));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }
    
    public Domicilio buscarDomicilioPorId(Domicilio domicilio){
        return em.find(Domicilio.class, domicilio.getIdDomicilio());
    }
}
