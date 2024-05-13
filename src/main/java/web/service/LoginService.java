package web.service;

/**
 * Business logic to handle login functions.
 * 
 * @author Ahsan.
 */
public class LoginService {

    /**
     * Static method returns true for successful login, false otherwise.
     * @param username the username of the user
     * @param password the password of the user
     * @param dob the date of birth of the user (expected format: yyyy-mm-dd)
     * @return true if login is successful, false otherwise
     */
    public static boolean login(String username, String password, String dob) {
        // Match a fixed user name, password, and date of birth
        if ("isuru".equals(username) && "isuru_pass".equals(password) && "1997-10-15".equals(dob)) {
            return true;
        }
        return false;
    }	
}
