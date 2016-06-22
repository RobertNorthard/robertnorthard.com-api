
package com.robertnorthard.api.util;

import java.util.Base64;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;

/**
 * Authentication utility class provide functions for managing base64
 * encoding/decoding and hashing of user passwords.
 *
 * @author robertnorthard
 */
public class AuthenticationUtils {

    private static final Logger LOGGER = Logger.getLogger(AuthenticationUtils.class.getName());

    private AuthenticationUtils() {
        //Empty as utility class.
    }

    /**
     * Hash a plaintext value using BCrypt, blowfish block-cipher with a work
     * factor of 12.
     *
     * @param password password to hash.
     * @return a string representation of the salted password.
     */
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    /**
     * Check if plain text password matches hash.
     *
     * @param password plaintext password
     * @param hash hashed password
     * @return true if plaintext password and hash match, else false.
     */
    public static boolean checkPassword(String password, String hash) {

        if (password == null || hash == null) {
            IllegalArgumentException e = new IllegalArgumentException(
                    "Password and hash cannot be null");
            LOGGER.log(Level.WARNING, e.getMessage());
            throw e;
        }

        return BCrypt.checkpw(password, hash);
    }

    /**
     * Return base64 encoded string.
     *
     * @param base64Encoding base64 encoding
     * @return base64 decoded string.
     * @throws IllegalArgumentException base64Encoding string is null.
     */
    public static String base64Decode(String base64Encoding) {

        if (base64Encoding == null) {
            throw new IllegalArgumentException();
        }

        return new String(Base64.getDecoder()
                .decode(base64Encoding.getBytes()));

    }
}
