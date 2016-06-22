
package com.robertnorthard.api.util;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Unit tests for AuthenticationUtils
 * 
 * @author robertnorthard
 */
public class AuthenticationUtilsTest {
   
    /**
     * Test of hashPassword method, of class AuthenticationUtils.
     */
    @Test
    public void testCheckPassword1() {
        String password = "password";
        String expResult = "$2a$12$TT.5ms5cfPw7YyDWZbcnJu3gRBDep.2fem2HK6DoCFpe1px.Imbx2"; 
        boolean result = AuthenticationUtils.checkPassword(password, expResult);
        assertTrue(result);
    }

    /**
     * Test of checkPassword method, of class AuthenticationUtils.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckPassword2() {
        boolean result = AuthenticationUtils.checkPassword(null, null);
        fail("Expected Illegal Argument Exception");
    }
    
   /**
     * Test of checkPassword method, of class AuthenticationUtils.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckPassword3() {
        boolean result = AuthenticationUtils.checkPassword("", null);
        fail("Expected Illegal Argument Exception");
    }
    
   /**
     * Test of checkPassword method, of class AuthenticationUtils.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testCheckPassword4() {
        boolean result = AuthenticationUtils.checkPassword(null, "");
        fail("Expected Illegal Argument Exception");
    }
}
