package fr.univtln.bab.project.services;

import fr.univtln.bab.project.daos.JoueurDAO;
import fr.univtln.bab.project.daos.PersonneDAO;
import fr.univtln.bab.project.entities.Joueur;
import fr.univtln.bab.project.entities.Personne;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

import java.util.Set;

@Stateless
public class PersonneBean {

    @Inject
    private PersonneDAO personneDAO;

    public Personne getPersonne(int id){
        return personneDAO.find(id);
    }

    public void ajouterPersonne(Personne joueur){
        personneDAO.persist(joueur);
    }

    public void supprimerPersonne(Personne joueur){
        personneDAO.remove(joueur);
    }
}
