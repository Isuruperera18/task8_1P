package web.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class LoginServiceUnitTest {

    @Test
    public void testSuccessfulLogin() {
        assertTrue("Expected successful login for valid credentials", 
            LoginService.login("isuru", "isuru_pass", "1997-10-15"));
    }

    @Test
    public void testLoginWithIncorrectUsername() {
        assertFalse("Expected failure for incorrect username", 
            LoginService.login("wrong_username", "isuru_pass", "1997-10-15"));
    }

    @Test
    public void testLoginWithIncorrectPassword() {
        assertFalse("Expected failure for incorrect password", 
            LoginService.login("isuru", "wrong_password", "1997-10-15"));
    }

    @Test
    public void testLoginWithIncorrectDOB() {
        assertFalse("Expected failure for incorrect DOB", 
            LoginService.login("isuru", "isuru_pass", "1990-01-01"));
    }

    @Test
    public void testLoginWithAllIncorrectCredentials() {
        assertFalse("Expected failure for all incorrect credentials", 
            LoginService.login("wrong_username", "wrong_password", "1990-01-01"));
    }

    @Test
    public void testLoginWithEmptyStrings() {
        assertFalse("Expected failure for empty strings as input", 
            LoginService.login("", "", ""));
    }

    @Test
    public void testLoginWithNullValues() {
        assertFalse("Expected failure for null values as input", 
            LoginService.login(null, null, null));
    }

    @Test
    public void testLoginWithPartialEmptyFields() {
        assertFalse("Expected failure for partial empty fields", 
            LoginService.login("", "isuru_pass", "1997-10-15"));
        assertFalse("Expected failure for partial empty fields", 
            LoginService.login("isuru", "", "1997-10-15"));
        assertFalse("Expected failure for partial empty fields", 
            LoginService.login("isuru", "isuru_pass", ""));
    }

    @Test
    public void testLoginWithPartialNullFields() {
        assertFalse("Expected failure for partial null fields", 
            LoginService.login(null, "isuru_pass", "1997-10-15"));
        assertFalse("Expected failure for partial null fields", 
            LoginService.login("isuru", null, "1997-10-15"));
        assertFalse("Expected failure for partial null fields", 
            LoginService.login("isuru", "isuru_pass", null));
    }
}