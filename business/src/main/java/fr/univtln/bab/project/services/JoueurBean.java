package fr.univtln.bab.project.services;

import fr.univtln.bab.project.daos.JoueurDAO;
import fr.univtln.bab.project.entities.Joueur;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;


@Stateless
@Named
public class JoueurBean extends Joueur {

    @Inject
    private JoueurDAO joueurDAO;

    public Joueur getJoueur(int id){
        return joueurDAO.find(id);
    }

    public List<Joueur> getJoueurs(){
        return joueurDAO.findAll();
    }

    public void ajouterJoueur(Joueur joueur){
        joueurDAO.persist(joueur);
    }

    public void modifierJoueur(Joueur joueurUpdated){
        joueurDAO.update(joueurUpdated);
    }

    public void supprimerJoueur(Joueur joueur){
        joueurDAO.remove(joueur);
    }

}
