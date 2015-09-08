package com.robertnorthard.api.dao.blog;

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
 * Post Data Access Object
 * 
 * @author robertnorthard
 *
 */
public class PostDAO {

    private static final Logger LOGGER = Logger.getLogger(PostDAO.class);

    private MongoClient con = DBConnection.getConnection();

    /**
     * Persist blog post
     * 
     * @param post
     *            post to persist
     */
    public Post create(Post post) {

        MongoDatabase db = con.getDatabase("blog");
        MongoCollection<Document> json = db.getCollection("posts");
        Document dbObject = Document.parse(new Gson().toJson(post));

        LOGGER.info(dbObject.toString());

        json.insertOne(dbObject);
        
        return post;
    }

    /**
     * Return all blog post
     */
    public List<Post> findAll() {

        List<Post> posts = new ArrayList<Post>();

        MongoDatabase db = con.getDatabase("blog");
        MongoCollection<Document> json = db.getCollection("posts");

        FindIterable<Document> iterable = json.find();

        for (Document document : iterable) {
            LOGGER.info(document.toJson());
            posts.add(new Gson().fromJson(document.toJson(), Post.class));
        }

        return posts;
    }
 
    /**
     * Return post for with a specified id
     * 
     * @param id the id of the post
     */
    public Post findById(String id) {

        MongoDatabase db = con.getDatabase("blog");
        MongoCollection<Document> collection = db.getCollection("posts");
        
        return new Gson().fromJson(collection.find(eq("_id", id)).first()
                .toJson(), Post.class);

    }
    
    /**
     * Update post
     * 
     * @param
     */
    public Post update(String id, Post post) {

        MongoDatabase db = con.getDatabase("blog");
        MongoCollection<Document> collection = db.getCollection("posts");

        post.set_id(id);
        collection.replaceOne(eq("_id", id), Document.parse(new Gson().toJson(post)));
        
        return post;
    }
}
