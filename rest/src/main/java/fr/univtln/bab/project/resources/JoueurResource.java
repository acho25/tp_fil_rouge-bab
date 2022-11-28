package fr.univtln.bab.project.resources;

import fr.univtln.bab.project.entities.Joueur;
import fr.univtln.bab.project.services.JoueurBean;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


@Path("personnes/joueurs")
public class JoueurResource {

    @Inject
    JoueurBean joueurBean;



    /**
     * this function returns all the personnes in the db thanks to a curl command
     */
    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Personne> getPersons() {
        List<Personne> joueurs;
        joueurs = j.findAll();
        return joueurs;
    }*/

    /**
     * this function adds a person to the db thanks to a curl command
     *
     * @param j1 a personne written in json format
     */
    @POST
    @Path("joueur")
    @Consumes(MediaType.APPLICATION_JSON)
    public void createJoueur(Joueur j1) {
        System.out.println("111111 " + joueurBean);
        joueurBean.ajouterJoueur(j1);
    }

    @GET
    public String hello() {
        return "hello world";
    }


    /**
     * this function updates a person using his id thanks to a curl command
     *
     * @param id the old persons id
     * @param t the new person
     */
        /*@PUT
        @Path("person/update/{id}")
        @Consumes(MediaType.APPLICATION_JSON)
        public void updateperson(@PathParam("id") int id, Personne t) {
            personneDAO.updatepersone(id,t);
        }*/

        /**
         * this function deletes a person using his id thanks to a curl command
         * @param id a persons id
         */
    /*@DELETE
    @Path("joueur/delete/{id}")
    public void removeperson(@PathParam("id") final int id) {
        personneDAO.remove(personneDAO.find(id));
    }*/


}