package fr.univtln.bab.project.services;

import fr.univtln.bab.project.daos.MatchDAO;
import fr.univtln.bab.project.entities.Match;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.util.List;

@Stateless
@Named
public class MatchBean {

    @Inject
    private MatchDAO matchDAO;

    public Match getMatch(int id){
        return matchDAO.find(id);
    }

    public List<Match> getMatchs(){
        return matchDAO.findAll();
    }

    public void ajouterMatch(Match match){
        matchDAO.persist(match);
    }

    public void modifierMatch(Match matchUpdated){
        matchDAO.update(matchUpdated);
    }

    public void supprimerMatch(Match match){
        matchDAO.remove(match);
    }
}
