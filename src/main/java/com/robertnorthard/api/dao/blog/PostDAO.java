package com.robertnorthard.api.dao.blog;

import org.bson.Document;

import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.robertnorthard.api.model.blog.Post;
import com.robertnorthard.api.util.DBConnection;

/**
 * Post Data Access Object
 * @author robertnorthard
 *
 */
public class PostDAO {

    /**
     * Persist blog post
     * @param post post to persist
     */
    public void create(Post post){
        MongoClient con = DBConnection.getConnection();
   
        MongoDatabase db = con.getDatabase("blog");
        MongoCollection<Document> json = db.getCollection("posts");
        Document dbObject = Document.parse(new Gson().toJson(post));
        json.insertOne(dbObject);
        
        con.close();
    }
    
}
