/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kass.dao;

import co.com.kass.domain.Contacto;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author kevin
 */
public class ContactoDAO extends GenericDAO{

   

    public List<Contacto> listar() {

        String hql = "SELECT c FROM Contacto c";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        
        return query.getResultList();
    }

    public void insertar(Contacto contacto) {
        try {
            em.getTransaction().begin();
            em.persist(contacto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }
    
    public void modificar(Contacto contacto){
        try {
            em.getTransaction().begin();
            em.merge(contacto);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }
    
    public void eliminar(Contacto contacto){
        try {
            em.getTransaction().begin();
            em.remove(em.merge(contacto));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }
    
    public Contacto buscarContactoPorId(Contacto contacto){
        return em.find(Contacto.class, contacto.getIdContacto());
    }

}
