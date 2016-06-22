package com.robertnorthard.api.layer.persistence.dao;

import java.util.List;

/**
 * A generic Data Access Object (DAO) interface for CRUD operations.
 *
 * @author robertnorthard
 * @param <K> primary key for entity
 * @param <V> type of entity to manipulate
 */
public interface EntityDao<K, V> {

    /**
     * Find a return object of type V with primary key K.
     * If entity with key K is not found return null.
     *
     * @param id primary key.
     * @return return object of type V with primary key K. 
     *         If entity with key K is not found return null.
     * @throws IllegalArgumentException if id is null.
     */
    public V findEntityById(final K id);

    /**
     * Persist an entity to the data layer.
     *
     * @param entity entity to persist
     * @throws IllegalArgumentException if entity is null.
     */
    public V persistEntity(final V entity);

    /**
     * Delete entity by id.
     *
     * @param id id of entity
     * @throws IllegalArgumentException if id is null.
     */
    public void deleteEntityById(final K id);

    /**
     * Update entity in JPA repository.
     *
     * @param entity entity to update.
     * @Param id entity id.
     * @return updated entity.
     * @throws IllegalArgumentException if entity is null.
     */
    public V update(final K id, final V entity);

    /**
     * Return all entities for given class.
     * If no entities found, null is returned.
     *
     * @return all entities for given class. 
     *         If no entities, found null is returned.
     */
    public List<V> findAll();
}
