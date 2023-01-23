package fr.univtln.bab.project.services;

import fr.univtln.bab.project.daos.EquipeDAO;
import fr.univtln.bab.project.daos.JoueurDAO;
import fr.univtln.bab.project.entities.Joueur;
import fr.univtln.bab.project.entities.Personne;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Stateless
@Named

public class JoueurBean  {

    @Inject
    private JoueurDAO joueurDAO;

    @Inject
    private EquipeDAO equipeDAO;

    @Setter
    @Getter
    private Joueur joueur;

    public void init() {
        joueur = new Joueur();
    }

    public Joueur getJoueur(int id){
        return joueurDAO.find(id);
    }

    public List<Joueur> getJoueurs(){
        return joueurDAO.findAll();
    }

    public void ajouterJoueur(Joueur joueur){
        setJoueurEquipe(joueur);
        joueurDAO.persist(joueur);
    }

    public void modifierJoueur(Joueur joueurUpdated){
        joueurDAO.update(joueurUpdated);
    }

    public void supprimerJoueur(Joueur joueur){
        joueurDAO.remove(joueur);
    }

    public void setJoueurEquipe(Joueur joueur){
        joueur.setEquipe(equipeDAO.find(joueur.getEquipeId()));
    }

}
