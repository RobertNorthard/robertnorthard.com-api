package com.robertnorthard.api.dao;

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
public class PostDAO extends MongoEntityDaoImpl<String, Post> {}