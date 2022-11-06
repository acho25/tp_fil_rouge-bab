package fr.univtln.bab.project;

import com.sun.jersey.api.core.ResourceConfig;
import com.sun.net.httpserver.HttpServer;



import fr.univtln.bab.project.personne.Personne;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.net.URI;

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


        Personne p1 = new Personne("jajaja",1);

        em.persist(p1);


        transac.commit();

    }
}
