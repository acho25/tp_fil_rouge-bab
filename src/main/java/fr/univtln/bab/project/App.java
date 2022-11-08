package fr.univtln.bab.project;


import fr.univtln.bab.project.entities.Personne;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App
{


    // Base URI the Grizzly HTTP server will listen on



    public static void main( String[] args )
    {

        EntityManagerFactory emf = Persistence
                .createEntityManagerFactory("bab");
        EntityManager em = emf.createEntityManager();


        EntityTransaction transac = em.getTransaction();
        transac.begin();


        Personne p1 = new Personne();

        em.persist(p1);


        transac.commit();

    }
}
