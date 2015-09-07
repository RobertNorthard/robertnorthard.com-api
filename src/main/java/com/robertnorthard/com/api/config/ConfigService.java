package com.robertnorthard.com.api.config;

import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * This class represents a configuration service using the Strategy design
 * pattern.
 * 
 * @author robertnorthard
 *
 */
public class ConfigService {

    private static final Logger LOGGER = Logger.getLogger(ConfigService.class);

    /**
     * Represents configuration loaders
     */
    private static ConfigLoader[] LOADERS = new ConfigLoader[] { new ClassPathConfigLoader() };

    public static Properties getConfig(String conf) {

        try {
            for (ConfigLoader configLoader : LOADERS) {
                Properties properties = configLoader.getConfig(conf);

                if (properties != null)
                    return properties;
            }
        } catch (RuntimeException e) {
            LOGGER.error(e.toString());
        }

        return null;
    }

}
