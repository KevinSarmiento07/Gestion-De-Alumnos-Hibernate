/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kass.dao;

import co.com.kass.domain.Asignacion;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author kevin
 */
public class AsignacionDAO extends GenericDAO{

   

   

    public List<Asignacion> listar() {

        String hql = "SELECT a FROM Asignacion a";
        em = getEntityManager();
        Query query = em.createQuery(hql);

        return query.getResultList();
    }

    public void insertar(Asignacion asignacion) {
        try {
            em.getTransaction().begin();
            em.persist(asignacion);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }

    }
    
    
    public void modificar(Asignacion asignacion){
        try {
            em.getTransaction().begin();
            em.merge(asignacion);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }
    
    public void eliminar(Asignacion asignacion){
        try {
            em.getTransaction().begin();
            em.remove(em.merge(asignacion));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }
    
    public Asignacion buscarAsignacionPorId(Asignacion asignacion){
        return em.find(Asignacion.class, asignacion.getIdAsignacion());
    }

}
