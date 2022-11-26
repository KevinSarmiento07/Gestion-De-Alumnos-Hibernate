/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.kass.dao;

import co.com.kass.domain.Curso;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author kevin
 */
public class CursoDAO extends GenericDAO{

   

    public List<Curso> listar() {

        String hql = "SELECT c FROM Curso c";
        em = getEntityManager();
        Query query = em.createQuery(hql);
        return query.getResultList();
    }

    public void insertar(Curso curso) {

        try {
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }
    
    public void modifcar(Curso curso){
         try {
            em.getTransaction().begin();
            em.merge(curso);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }
    
    public void eliminar(Curso curso){
         try {
            em.getTransaction().begin();
            em.remove(em.merge(curso));
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            em.getTransaction().rollback();
        }
    }
    
    public Curso buscarCursoPorId(Curso curso){
        
        return em.find(Curso.class, curso.getIdCurso());
    }

}
