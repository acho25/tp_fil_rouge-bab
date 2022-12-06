package fr.univtln.bab.project.resources;

import fr.univtln.bab.project.daos.MatchDAO;
import fr.univtln.bab.project.entities.Match;
import jakarta.persistence.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


import java.util.List;


@Path("matches")
public class MatchResource {

    MatchDAO matchDAO =new MatchDAO();
    EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("bab");
    EntityManager em = emf.createEntityManager();


    /**
     * this function returns all the Matches in the db thanks to a curl command
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getMatches(){

        List<Match> matches;

        matches=matchDAO.findAll();

        return matches.toString();

    }

    /**
     * this function adds a match to the db thanks to a curl command
     * @param m1 a match written in json format
     */
    @POST
    @Path("match/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void creatmatch (Match m1){
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        em.persist(m1);
        transac.commit();
    }

    @DELETE
    @Path("match/delete/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteMatch(@PathParam("id") int id) {
        matchDAO.remove(matchDAO.find(id));
    }

}