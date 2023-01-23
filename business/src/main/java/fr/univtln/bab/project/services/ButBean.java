package fr.univtln.bab.project.services;

import fr.univtln.bab.project.daos.ButDAO;
import fr.univtln.bab.project.entities.But;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Stateless
@Named
public class ButBean {
    @Setter
    @Getter
    private But but;
    public void AdresseBean(){
        but = new But();
    }

    @Inject
    private ButDAO butDAO;

    public But getBut(int id){
        return butDAO.find(id);
    }

    public List<But> getButs(){
        return butDAO.findAll();
    }

    public void ajouterBut(But adresse){
        butDAO.persist(but);
    }

    public void modifierBut(But butUpdated){
        butDAO.update(butUpdated);
    }

    public void supprimerBut(But but){
        butDAO.remove(but);
    }
}
