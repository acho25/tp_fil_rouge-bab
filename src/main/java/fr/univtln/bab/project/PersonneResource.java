package fr.univtln.bab.project;


import fr.univtln.bab.project.daos.PersonneDAO;
import fr.univtln.bab.project.personne.Personne;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("personnes")

public class PersonneResource {
    PersonneDAO personneDAO = new PersonneDAO();
    EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("bab");
    EntityManager em = emf.createEntityManager();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Personne getAliens(){
        System.out.println("Personne called");

        Personne A = em.find(Personne.class, 1);
        System.out.println(A);
        return A;

    }

}
