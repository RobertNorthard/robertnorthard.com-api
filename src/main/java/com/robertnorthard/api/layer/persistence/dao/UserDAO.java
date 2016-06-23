package com.robertnorthard.api.layer.persistence.dao;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.client.MongoDatabase;
import com.robertnorthard.api.layer.persistence.entities.User;

import static com.mongodb.client.model.Filters.*;

/**
 * User Data Access Object
 * 
 * @author robertnorthard
 *
 */
public class UserDAO extends MongoEntityDaoImpl<String,User> {

    private static final Logger LOGGER = Logger.getLogger(UserDAO.class);

    /**
     * Return post for with a specified id
     * 
     * @param username the username of the user
     * @return found user, null if not found.
     */
    public User findByUsername(String username) {

        MongoDatabase db = this.getConnection().getDatabase("blog");
        Document document = db.getCollection(this.getCollectionName()).find(eq("username", username)).first();
        
        if (document != null){
            LOGGER.debug(document.toJson());
            return new Gson().fromJson(document.toJson(), User.class);
        }
        
        // User not found
        return null;
    }
}
