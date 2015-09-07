package com.robertnorthard.api.util;

import java.util.Properties;

import org.apache.log4j.Logger;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.robertnorthard.api.config.ConfigService;

/**
 * This class represents a persistent layers db connection.
 * 
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

        Properties properties = ConfigService.getConfig("application.properties");

        if (DBConnection.client == null)
            synchronized (DBConnection.class) {
                if (DBConnection.client == null) {
                    DBConnection.client = new MongoClient(
                            new MongoClientURI(
                                    properties.getProperty("mongodb.connection.string")));
                }
            }

        return DBConnection.client;
    }

    /**
     * Close Connection
     * 
     * @return true if database connection closed successful, else false if
     *         connection not closed or SQLException.
     */
    public static boolean closeConnection() {

        if (DBConnection.client != null)
            synchronized (DBConnection.class) {
                // Prevent unchecked NullPointerException
                if (DBConnection.client != null) {
                    try {
                        DBConnection.client.close();
                        DBConnection.client = null;
                        return true;
                    } catch (Exception e) {
                        LOGGER.error(e);
                        return false;
                    }
                }
            }
        // default - failed to close
        return false;
    }

}
