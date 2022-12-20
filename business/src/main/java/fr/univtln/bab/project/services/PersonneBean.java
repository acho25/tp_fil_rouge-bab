package fr.univtln.bab.project.services;

import fr.univtln.bab.project.daos.PersonneDAO;
import fr.univtln.bab.project.entities.Joueur;
import fr.univtln.bab.project.entities.Personne;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class PersonneBean {

    @Inject
    private PersonneDAO personneDAO;

    public Personne getPersonne(int id){
        return personneDAO.find(id);
    }

    public List<Personne> getPersonnes(){
        return personneDAO.findAll();
    }

    public void ajouterPersonne(Personne personne){
        personneDAO.persist(personne);
    }

    public void modifierPersonne(Personne personneUpdated){
        personneDAO.update(personneUpdated);
    }

    public void supprimerPersonne(Personne personne){
        personneDAO.remove(personne);
    }
}
