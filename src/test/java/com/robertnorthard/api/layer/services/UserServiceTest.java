
package com.robertnorthard.api.layer.services;

import com.robertnorthard.api.layer.persistence.dao.UserDAO;
import com.robertnorthard.api.layer.persistence.entities.User;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 * Unit tests for UserService
 * @author robertnorthard
 */
public class UserServiceTest {
    
    private final UserDAO dao;
    private final UserService instance;
    
    public UserServiceTest() {
        dao = Mockito.mock(UserDAO.class);
        instance = new UserService(dao);
    }
    
    /**
     * Test of findByUsername method, of class UserService.
     */
    @Test
    public void testFindByUsername1() {
        String username = "not-a-real-username";
        when(dao.findByUsername(username)).thenReturn(null);

        User expResult = null;
        User result = instance.findByUsername(username);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of findByUsername method, of class UserService.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testFindByUsername2() {
        String username = null;
        User result = instance.findByUsername(username);
        fail("Expected illegal argument exception");
    }
}
