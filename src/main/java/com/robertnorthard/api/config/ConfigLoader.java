package com.robertnorthard.api.config;

import java.util.Properties;

/**
 * This interface represents a config loader
 * @author robertnorthard
 *
 */
public interface ConfigLoader {

    /**
     * 
     * @param conf configuration implementation, e.g. file, url etc
     * @return the associated properties object
     * @throws RuntimeException if unable to discover configuration
     */
    public Properties getConfig(String conf) throws RuntimeException;
}
