package fr.univtln.bab.project.resources;

import fr.univtln.bab.project.daos.AdresseDAO;
import fr.univtln.bab.project.daos.PersonneDAO;
import fr.univtln.bab.project.entities.Adresse;
import fr.univtln.bab.project.entities.Match;
import fr.univtln.bab.project.entities.Personne;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Path("adresses")
public class AdresseResource {

    private AdresseDAO adresseDAO =new AdresseDAO();
    EntityManagerFactory emf = Persistence
            .createEntityManagerFactory("bab");
    EntityManager em = emf.createEntityManager();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAdresses(){
        List<Adresse> adresses = new ArrayList<>();
        adresses=adresseDAO.findAll();
        return adresses.toString();
    }

    @POST
    @Path("adresse/create")
    @Consumes(MediaType.APPLICATION_JSON)
    public void creatadresse (Adresse a1){
        System.out.println("adress created");
        EntityTransaction transac = em.getTransaction();
        transac.begin();
        em.persist(a1);
        transac.commit();
    }

}
