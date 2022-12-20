package fr.univtln.bab.project.resources;

import fr.univtln.bab.project.entities.Match;
import fr.univtln.bab.project.services.MatchBean;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;


@Path("matches")
public class MatchResource {
    @Inject
    MatchBean matchBean;

    /**
     * this function returns all the Matches in the db thanks to a curl command
     */
    @GET
    public List<Match> getMatches(){
        return matchBean.getMatchs();
    }

    /**
     * this function adds a match to the db thanks to a curl command
     * @param match a match written in json format
     */
    @POST
    @Path("match/create")
    public void createMatch (Match match){
       matchBean.ajouterMatch(match);
    }

    @DELETE
    @Path("match/delete/{id}")
    public void deleteMatch(@PathParam("id") int id) {
       matchBean.supprimerMatch(matchBean.getMatch(id));
    }

}