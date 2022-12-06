package fr.univtln.bab.project.resources;

import fr.univtln.bab.project.daos.PersonneDAO;
import fr.univtln.bab.project.entities.Joueur;
import fr.univtln.bab.project.services.JoueurBean;
import fr.univtln.bab.project.services.PersonneBean;
import jakarta.ejb.TransactionAttribute;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;


@ApplicationScoped
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
@Consumes(MediaType.APPLICATION_JSON)
@Path("personnes/joueurs")
public class JoueurResource {

    @Inject
    JoueurBean joueurBean;

    @Inject
    PersonneBean personneBean;


    /**
     * this function returns all the personnes in the db thanks to a curl command
     */
    @GET
    public List<Joueur> getPersons() {
        return joueurBean.getJoueurs();
    }

    /**
     * this function adds a person to the db thanks to a curl command
     *
     * @param j1 a personne written in json format
     */
    @POST
    @Path("joueur")
    public void createJoueur(Joueur j1) {
        personneBean.ajouterPersonne(j1);
    }

    /**
     * this function updates a person using his id thanks to a curl command
     *
     * @param id the old persons id
     * @param j1  the new person
     */
    @PUT
    @Path("person/update/{id}")
    public void updateperson(@PathParam("id") int id, Joueur j1) {
        Joueur joueur = joueurBean.getJoueur(id);
        joueur.setNom(j1.getNom());
        joueur.setPrenom(j1.getPrenom());
        joueur.setNumero(j1.getNumero());
        joueur.setPostion(j1.getPostion());
        joueurBean.modifierJoueur(joueur);
    }

    /**
     * this function deletes a person using his id thanks to a curl command
     *
     * @param id a persons id
     */
    @DELETE
    @Path("joueur/delete/{id}")
    public void removeperson(@PathParam("id") final int id) {
        personneBean.supprimerPersonne(joueurBean.getJoueur(id));
    }


}