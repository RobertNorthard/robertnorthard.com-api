package com.robertnorthard.com.api.config;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;


/**
 * This class facilitates reading properties from files on the class path.
 * 
 * @author robertnorthard
 *
 */
public class ClassPathConfigLoader implements ConfigLoader {

    /**
     * Return config from file.
     * @param file file to read properties from
     */
    public Properties getConfig(String file) throws RuntimeException {

        Properties properties = new Properties();

        try {
            Reader reader = new InputStreamReader(Thread.currentThread()
                    .getContextClassLoader().getResourceAsStream(file));

            try {
                properties.load(reader);
                return properties;
            } finally {
                reader.close();
            }
        } catch (Throwable e) {
            throw new RuntimeException(String.format(
                    "Unable to find properties file - [%s]", file));
        }
    }
}
