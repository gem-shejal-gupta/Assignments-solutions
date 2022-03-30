package sample;

import javafx.scene.layout.Priority;
import org.testng.annotations.Test;

public class TestNG1 {
    //code for running all test cases
    /*@Test
    void setup() {
        System.out.println("opening browser");
    }

    @Test
    void login() {
        System.out.println("Enter user name and password");
    }

    @Test
    void close() {
        System.out.println("Closing browser");
    }*/

    //code for running testcases when priority is set//
  /*@Test
    void setup()
    {
        System.out.println("opening browser");
    }

    @Test(priority = 1)
    void login()
    {
        System.out.println("Enter user name and password");
    }

    @Test(priority = 2)
    void close()
    {
        System.out.println("Closing browser");
    }*/

    //code for running testcases when group is set//
    @Test(groups = {"regression"})
    void setup() {
        System.out.println("opening browser");
    }

    @Test
    void login() {
        System.out.println("Enter user name and password");
    }

    @Test
    void close() {
        System.out.println("Closing browser");
    }
}
