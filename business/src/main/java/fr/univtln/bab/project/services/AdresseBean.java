package fr.univtln.bab.project.services;

import fr.univtln.bab.project.daos.AdresseDAO;
import fr.univtln.bab.project.entities.Adresse;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Stateless
@Named
public class AdresseBean {
    @Setter
    @Getter
    private Adresse adresse;
    public void AdresseBean(){
        adresse = new Adresse();
    }

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
