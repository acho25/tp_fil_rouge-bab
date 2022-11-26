package fr.univtln.bab.project.daos;

import fr.univtln.bab.project.entities.Match;
import jakarta.persistence.Query;


public class MatchDAO extends GenericDAO<Match>{
    public void updateMatch(int id, Match t) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(
                "UPDATE Match h"+
                        " SET h.score = ?1"+
                        " WHERE h.id= ?2").setParameter(1,t.getScore()).setParameter(2,id);
        query.executeUpdate();
        transaction.commit();
    }

}
