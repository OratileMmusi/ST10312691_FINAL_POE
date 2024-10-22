
package part1;

/**
  Student Name: Thandisiwe Mthokwa
 *Student Number: ST10440247
 * Description: Part_1
 * @author Mthokwa Thandisiwe
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Registration registration = new Registration();
         Login login = new Login(registration);
        login.setVisible(true);
    }
    
}
