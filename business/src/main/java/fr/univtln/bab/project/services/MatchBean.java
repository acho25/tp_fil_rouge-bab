package fr.univtln.bab.project.services;
import fr.univtln.bab.project.daos.EquipeDAO;
import fr.univtln.bab.project.daos.MatchDAO;
import fr.univtln.bab.project.entities.Equipe;
import fr.univtln.bab.project.entities.Match;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Stateless
@Named
public class MatchBean {



    @Getter
    @Setter
    Match match;


    @Inject
    private EquipeDAO equipeDAO;

    @Inject
    private MatchDAO matchDAO;

    @Getter
    @Setter
    private Match selectedMatch;

    public List<Equipe> getEquipes(){
        return equipeDAO.findAll();
    }

    @PostConstruct
    public void init() {
        match = new Match();
    }


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
