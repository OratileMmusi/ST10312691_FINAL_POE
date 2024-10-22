
package part1;

/**
  Student Name: Thandisiwe Mthokwa
 *Student Number: ST10440247
 * Description: Part_1
 * @author Mthokwa Thandisiwe
 */
public class UserCredentials {
    private static UserCredentials instance;
    private String username;
    private String password;

    private UserCredentials() 
    {
    
    }

    public static UserCredentials getInstance() {
        if (instance == null) {
            instance = new UserCredentials();
        }
        return instance;
    }

    public void setCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean checkCredentials(String username, String password) {
        return this.username != null && this.username.equals(username) && this.password != null && this.password.equals(password);
    }
}
