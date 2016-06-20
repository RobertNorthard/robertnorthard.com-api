package com.robertnorthard.api.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.robertnorthard.api.model.blog.Post;
import com.robertnorthard.api.util.DBConnection;

import static com.mongodb.client.model.Filters.*;

/**
 * A generic Data Access Object (DAO) class for interfacing with Java
 * Persistence API, handling and managing event related data requested, updated,
 * and processed in the application and maintained in the database.
 *
 * @author robertnorthard
 * @param <K> unique identifier for entity
 * @param <V> type of object to manipulate
 */
public class MongoEntityDaoImpl<K, V> implements EntityDao<K, V> {

    private static final Logger LOGGER = Logger.getLogger(MongoEntityDaoImpl.class);

    private final Class<V> persistentClass;

    /**
     * Default constructor for class EntityDaoImpl
     */
    public MongoEntityDaoImpl() {
        this.persistentClass = (Class<V>) ((ParameterizedType) getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[1];
    }

    /**
     * Find a return object of type V with primary key K.
     * If entity with key K is not found return null.
     *
     * @param id primary key.
     * @return return object of type V with primary key K. 
     *         If entity with key K is not found return null.
     * @throws IllegalArgumentException if id is null.
     */
    @Override
    public V findEntityById(K id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null.");
        }
         
        MongoDatabase db = this.getConnection().getDatabase("blog");
        MongoCollection<Document> collection = db.getCollection(this.getCollectionName());
        Document document = collection.find(eq("_id", id)).first();
        
        return document == null ? null : new Gson().fromJson(document.toJson(), persistentClass);

    }

    /**
    * Return MongoClient from pool.
    *
    * @return mongo client from the connection pool.
    */
    public MongoClient getConnection(){
        return DBConnection.getConnection();
    }

    /**
    * Return db collection name.
    *
    * @Return database collection name.
    */
    public String getCollectionName(){
        return persistentClass.getSimpleName().toLowerCase() + "s";
    }
    

    /**
     * Persist an entity to the data layer.
     *
     * @param entity entity to persist
     * @throws IlslegalArgumentException if entity is null.
     */
    @Override
    public V persistEntity(V entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null.");
        }

        MongoDatabase db = this.getConnection().getDatabase("blog");
        MongoCollection<Document> json = db.getCollection(this.getCollectionName());
        Document dbObject = Document.parse(new Gson().toJson(entity));

        LOGGER.debug(dbObject.toString());

        json.insertOne(dbObject);
        
        return entity;
    }

    /**
     * Delete entity by id.
     *
     * @param id id of entity
     * @throws IllegalArgumentException if id is null.
     */
    @Override
    public void deleteEntityById(K id) {

        if (id == null) {
            throw new IllegalArgumentException("id cannot be null.");
        }

        MongoDatabase db = this.getConnection().getDatabase("blog");
        MongoCollection<Document> collection = db.getCollection(this.getCollectionName());
        collection.deleteOne(eq("_id", id));
    }

    /**
     * Update entity in JPA repository by merging attributes.
     *
     * @param entity entity to update.
     * @throws IllegalArgumentException if entity is null.
     */
    @Override
    public V update(K id, V entity) {

        if (entity == null) {
            throw new IllegalArgumentException("Entity cannot be null.");
        }

        MongoDatabase db = this.getConnection().getDatabase("blog");
        MongoCollection<Document> collection = db.getCollection(this.getCollectionName());

        collection.replaceOne(eq("_id", id), Document.parse(new Gson().toJson(persistentClass)));
        return entity;
    }

    /**
     * Return all entities for given class.
     * If no entities found, null is returned.
     *
     * @return all entities for given class. 
     *         If no entities, found null is returned.
     */
    @Override
    public List<V> findAll() {
        
        List<V> items = new ArrayList<>();

        MongoDatabase db = this.getConnection().getDatabase("blog");
        MongoCollection<Document> json = db.getCollection(this.getCollectionName());

        FindIterable<Document> iterable = json.find();

        for (Document document : iterable) {
            LOGGER.debug(document.toJson());
            items.add(new Gson().fromJson(document.toJson(), persistentClass));
        }

        return items;
    }
}
