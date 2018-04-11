/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package streaming.test;

import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;
import streaming.entiey.Film;

/**
 *
 * @author Formation
 */
public class NewEmptyJUnitTest {
    
    @Test
    public void demareJPA () {
        
        EntityManagerFactory f = Persistence.createEntityManagerFactory("PU");
//        EntityManager em = f.createEntityManager();
//        
//        em.getTransaction().begin();
//        
//        Film film = new Film ();
//        film.setTitre (" Inception ");
//        film.setDateSortie(new Date());
//        em.persist(film);
//        
//        Film film2 = new  Film();
//        film2.setTitre(" Avatar");
//        film2.setDateSortie(new Date ());
//        em.persist(film2);
//        
//        em.getTransaction().commit();
    }
    
}