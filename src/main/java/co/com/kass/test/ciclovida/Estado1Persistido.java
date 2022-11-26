
package co.com.kass.test.ciclovida;

import co.com.kass.domain.Contacto;
import javax.persistence.*;
import javax.persistence.Persistence;


public class Estado1Persistido {
    
    
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("HibernateJpaPU");
        EntityManager em = emf.createEntityManager();
        
        
        //1. Estado Transitivo
        Contacto contacto = new Contacto();
        contacto.setEmail("kass@gmail.com");
        contacto.setTelefono("009338");
        
        
        //2. Persistimos el objeto 
        em.getTransaction().begin();
        em.persist(contacto);
        //em.flush();  Es otra forma para actualizar los datos
        em.getTransaction().commit();
        
        //3. Detached representado en la base de datos
        
        System.out.println("Contacto: " + contacto );
    }
}
