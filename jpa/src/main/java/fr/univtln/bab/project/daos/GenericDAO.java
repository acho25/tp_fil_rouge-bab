package fr.univtln.bab.project.daos;

import jakarta.ejb.Stateless;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;


import java.lang.reflect.ParameterizedType;
import java.util.List;


/**
 * Generic DAO which describe the common operations that all DAOs have
 *
 * @param <E> generic type for entity
 * @author Wide Factory Team
 */
@Stateless
public abstract class GenericDAO<E> implements DAO<E> {
    /**
     * The entity manager to manage entities with the database
     */
    @PersistenceContext(unitName="bab")
    protected EntityManager entityManager;

    /**
     * Used to store the real type of the sub class DAO (avoid to specify in find request)
     */
    protected final Class<E> type;


    /**
     * Constructor
     */
    protected GenericDAO() {
        // Get the real type of the sub class DAO
        ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
        this.type = (Class<E>) genericSuperclass.getActualTypeArguments()[0];
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Persist an entity in database and return after persisting
     * Equal to persist of entity manager
     *
     * @param entity entity to persist
     * @return entity after persisting
     */
    @Override
    public E persist(E entity) {
        System.out.println("heeeeeeeeeeeeeeeere "+ this.entityManager);
        this.entityManager.persist(entity);
        // Update the entity with modification performed by the database (like auto generated id)
        this.entityManager.refresh(entity);
        return entity;
    }

    /**
     * Return an entity which the primary key is specified
     * Equal to a find of entity manager
     *
     * @param id the primary key
     * @return object of type E
     */
    @Override
    public E find(Object id) {
        return this.entityManager.find(type, id);
    }

    /**
     * Refresh an entity JAVA specified with the data from database
     * Equals to a refresh of entity manager
     *
     * @param entity entity to refresh
     * @return object of type E
     */
    @Override
    public E refresh(E entity) {
        // refresh and return entity JAVA from the database
        this.entityManager.refresh(entity);
        return entity;
    }

    /**
     * Delete an entity from the database
     * Equal to remove of entity manager
     *
     * @param entity entity to remove
     */
    @Override
    public void remove(E entity) {
        this.entityManager.remove(entity);
    }

    /**
     * Update entity from the database
     * Perform a merge in a transaction
     * All modification will be caught and processed by the entity manager
     *
     * @param entity entity that will be updated in database
     */
    @Override
    public void update(E entity) {
        // In fact merge is used to ask to the entity manager to manage an entity non followed
        // But it can used in this configuration to caught any change in the entity
        // To directly update entity in database
        this.entityManager.merge(entity);
    }

    /**
     * Ask to entity manager to manage the given entity
     * Equal to merge of entity manager
     *
     * @param entity entity to manage
     * @return entity that look like, but which is managed by the entity manager
     */
    @Override
    public E merge(E entity) {
        return this.entityManager.merge(entity);
    }

    /**
     * Get all entity from a particular type
     *
     * @return list of entities
     */
    @Override
    public List<E> findAll() {
        // excerpt provided M.BRUNO example
        CriteriaBuilder cb = this.entityManager.getCriteriaBuilder();
        CriteriaQuery<E> cq = cb.createQuery(type);
        Root<E> rootEntry = cq.from(type);
        CriteriaQuery<E> all = cq.select(rootEntry);

        TypedQuery<E> allQuery = this.entityManager.createQuery(all);

        return allQuery.getResultList();
    }

}
