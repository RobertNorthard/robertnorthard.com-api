
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
    
    private UserDAO dao;
    private UserService instance;
    
    public UserServiceTest() {
        dao = Mockito.mock(UserDAO.class);
        instance = new UserService(dao);
    }
    
    /**
     * Test of findByUsername method, of class UserService.
     */
    @Test
    public void testFindByUsername1() {
        String username = "not-a-real-userame";
        
        UserDAO dao = Mockito.mock(UserDAO.class);
        
        UserService instance = new UserService(dao);
        when(dao.findByUsername(username)).thenReturn(null);

        User expResult = null;
        User result = instance.findByUsername(username);
        assertEquals(expResult, result);
    }
}
