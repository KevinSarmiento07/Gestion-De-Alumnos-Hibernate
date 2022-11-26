/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kass.dao;

import co.com.kass.domain.Alumno;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author kevin
 */
public class AlumnoDAO extends GenericDAO{

   
   

    public List<Alumno> listar() {
        String hql = "SELECT a FROM Alumno a";

        em = getEntityManager();
        
        Query query = em.createQuery(hql);
        
        return query.getResultList();
    }

    public void insertar(Alumno alumno) {

        try {
            em.getTransaction().begin();;
            em.persist(alumno);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();

        }

    }

    public void modificar(Alumno alumno) {

        try {
            em.getTransaction().begin();;
            em.merge(alumno);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }

    public void eliminar(Alumno alumno) {
        try {
            em.getTransaction().begin();;
            em.remove(em.merge(alumno));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();

        }
    }

    public Alumno buscarAlumnoPorId(Alumno alumno) {
        return em.find(Alumno.class, alumno.getIdAlumno());
    }
}
