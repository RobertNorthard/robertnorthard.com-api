package com.robertnorthard.api.util;

import org.apache.log4j.Logger;

import com.mongodb.MongoClient;

/**
 * This class represents a persistent layers db connection.
 * @author robertnorthard
 *
 */
public class DBConnection {

    private static final Logger LOGGER = Logger.getLogger(DBConnection.class);
    
    private static MongoClient client = null;
    
    /**
     * Added explicit private constructor as this is a utility class.
     */
    private DBConnection() {

    }
    
    /**
     * Return a database connection object.
     * 
     * @return a database connection object
     */
    public static MongoClient getConnection() {

        client = new MongoClient("192.168.59.103", 27017);

        return client;
    }
    
    /**
     * Close Connection
     * 
     * @return true if database connection closed successful, else false if
     *         connection not closed or SQLException.
     */
    public static boolean closeConnection() {

        // Prevent unchecked NullPointerException
        if (DBConnection.client != null) {
            try {
                DBConnection.client.close();
                return true;
            } catch (Exception e) {
                LOGGER.error(e);
                return false;
            }
        }
        // default - failed to close
        return false;
    }
    
}
