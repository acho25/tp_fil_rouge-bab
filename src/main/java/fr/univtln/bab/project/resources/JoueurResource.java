package fr.univtln.bab.project.resources;

import fr.univtln.bab.project.daos.PersonneDAO;
import fr.univtln.bab.project.entities.Joueur;
import fr.univtln.bab.project.entities.Personne;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("personnes/joueurs")
public class JoueurResource {


    PersonneDAO personneDAO = new PersonneDAO();
    EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("bab");
    EntityManager em = emf.createEntityManager();


    /**
     * this function returns all the personnes in the db thanks to a curl command
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Personne> getPersons() {

        List<Personne> joueurs;

        joueurs = personneDAO.findAll();

        return joueurs;

    }

    /**
     * this function adds a person to the db thanks to a curl command
     *
     * @param j1 a personne written in json format
     */
    @POST
    @Path("joueur")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createJoueur(Joueur j1) {
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        em.persist(j1);
        transac.commit();
    }


    /**
     * this function updates a person using his id thanks to a curl command
     *
     * @param id the old persons id
     * @param t  the new person
     */
        /*@PUT
        @Path("person/update/{id}")
        @Consumes(MediaType.APPLICATION_JSON)
        public void updateperson(@PathParam("id") int id, Personne t) {
            personneDAO.updatepersone(id,t);

        }

        /**
         * this function deletes a person using his id thanks to a curl command
         * @param id a persons id
         */
    @DELETE
    @Path("joueur/delete/{id}")
    public void removeperson(@PathParam("id") final int id) {
        personneDAO.remove(personneDAO.find(id));

    }


}