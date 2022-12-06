package fr.univtln.bab.project.daos;

import fr.univtln.bab.project.entities.Personne;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Named
public class PersonneDAO extends GenericDAO<Personne> {

    public void updatepersone(int id, Personne t) {
        Query query = entityManager.createQuery(
                "UPDATE Personne h"+
                        " SET h.nom = ?1"+
                        " WHERE h.id= ?2").setParameter(1,t.getNom()).setParameter(2,id);
        query.executeUpdate();
    }
}
