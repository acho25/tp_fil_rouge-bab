package fr.univtln.bab.project.services;

import fr.univtln.bab.project.daos.AdresseDAO;
import fr.univtln.bab.project.entities.Adresse;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class AdresseBean {

    @Inject
    private AdresseDAO adresseDAO;

    public Adresse getAdresse(int id){
        return adresseDAO.find(id);
    }

    public List<Adresse> getAdresses(){
        return adresseDAO.findAll();
    }

    public void ajouterAdresse(Adresse adresse){
        adresseDAO.persist(adresse);
    }

    public void modifierAdresse(Adresse adresseUpdated){
        adresseDAO.update(adresseUpdated);
    }

    public void supprimerAdresse(Adresse adresse){
        adresseDAO.remove(adresse);
    }
}
