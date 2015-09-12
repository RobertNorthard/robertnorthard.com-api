package com.robertnorthard.api.dao;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.robertnorthard.api.model.security.User;
import com.robertnorthard.api.util.DBConnection;

import static com.mongodb.client.model.Filters.*;

/**
 * User Data Access Object
 * 
 * @author robertnorthard
 *
 */
public class UserDAO {

    private static final Logger LOGGER = Logger.getLogger(UserDAO.class);

    private MongoClient con = DBConnection.getConnection();

    /**
     * Return post for with a specified id
     * 
     * @param username the username of the user
     * @return found user, null if not found.
     */
    public User findByUsername(String username) {

        MongoDatabase db = con.getDatabase("blog");
        Document document = db.getCollection("users").find(eq("username", username)).first();

        if (document != null){
            return new Gson().fromJson(document.toJson(), User.class);
        }
        
        // User not found
        return null;
    }
}
