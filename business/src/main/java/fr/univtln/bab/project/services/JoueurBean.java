package fr.univtln.bab.project.services;

import fr.univtln.bab.project.daos.JoueurDAO;
import fr.univtln.bab.project.entities.Joueur;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.apache.log4j.Logger;

@Stateless
public class JoueurBean {
    @Inject
    private Logger logger;

    @Inject
    private JoueurDAO joueurDAO;

    public void ajouterJoueur(Joueur joueur){
        joueurDAO.persist(joueur);
    }

}
