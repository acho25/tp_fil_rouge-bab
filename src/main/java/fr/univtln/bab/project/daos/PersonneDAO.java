package fr.univtln.bab.project.daos;

import fr.univtln.bab.project.personne.Personne;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class PersonneDAO extends GenericDAO<Personne> {


    public void updatepersone(int id, Personne t) {
        System.out.printf("??");
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(
                "UPDATE Personne h"+
                        " SET h.name = ?1"+
                        " WHERE h.id= ?2").setParameter(1,t.getName()).setParameter(2,id);
        query.executeUpdate();
        transaction.commit();
    }
}
