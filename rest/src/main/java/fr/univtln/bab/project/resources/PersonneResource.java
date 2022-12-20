package fr.univtln.bab.project.resources;

import fr.univtln.bab.project.entities.Personne;
import fr.univtln.bab.project.services.PersonneBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;


@ApplicationScoped
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
@Consumes(MediaType.APPLICATION_JSON)
@Path("personnes")
public class PersonneResource {
    @Inject
    PersonneBean personneBean;

    /**
     * this function returns all the personnes in the db thanks to a curl command
     */
    @GET
    public List<Personne> getPersonnes() {
        return personneBean.getPersonnes();
    }

    /**
     * this function adds a person to the db thanks to a curl command
     *
     * @param p1 a personne written in json format
     */
    @POST
    @Path("personne")
    public void createPersonne(Personne p1) {
        personneBean.ajouterPersonne(p1);
    }


    /**
     * this function updates a person using his id thanks to a curl command
     *
     * @param id the old persons id
     * @param p  the new person
     */
    @PUT
    @Path("personne/update/{id}")
    public void updatePersonne(@PathParam("id") int id, Personne p) {
        Personne personne = personneBean.getPersonne(id);
        personne.setNom(p.getNom());
        personne.setPrenom(p.getPrenom());
        personneBean.modifierPersonne(personne);
    }

    /**
     * this function deletes a person using his id thanks to a curl command
     *
     * @param id a persons id
     */

    @DELETE
    @Path("personne/delete/{id}")
    public void removePersonne(@PathParam("id") final int id) {
        personneBean.supprimerPersonne(personneBean.getPersonne(id));
    }


}