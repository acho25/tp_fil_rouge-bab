package fr.univtln.bab.project.resources;

import fr.univtln.bab.project.entities.Adresse;
import fr.univtln.bab.project.services.AdresseBean;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@ApplicationScoped
@Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
@Consumes(MediaType.APPLICATION_JSON)
@Path("adresses")
public class AdresseResource {
    @Inject
    AdresseBean adresseBean;

    @GET
    public List<Adresse> getAdresses(){
        return adresseBean.getAdresses();
    }

    @POST
    @Path("adresse/create")
    public void createAdresse(Adresse a1){
        adresseBean.ajouterAdresse(a1);
    }

}