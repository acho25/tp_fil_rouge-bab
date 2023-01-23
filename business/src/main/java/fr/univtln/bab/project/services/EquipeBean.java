package fr.univtln.bab.project.services;

import fr.univtln.bab.project.daos.EquipeDAO;
import fr.univtln.bab.project.daos.PersonneDAO;
import fr.univtln.bab.project.entities.Equipe;
import fr.univtln.bab.project.entities.Personne;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Stateless
@Named

public class EquipeBean {


    @Inject
    private EquipeDAO equipeDAO;

    @Setter
    @Getter
    private Equipe equipe;
    public EquipeBean() {
        equipe = new Equipe();
    }
    public void init() {
        equipe = new Equipe();
    }

    public List<Equipe> getEquipes(){
        return equipeDAO.findAll();
    }

    public void ajouterEquipe(Equipe equipe){equipeDAO.persist(equipe);}
    public void supprimerEquipe(Equipe equipe){equipeDAO.remove(equipe);}
}
