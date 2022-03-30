package sample;

import javafx.scene.layout.Priority;
import org.testng.annotations.Test;

public class TestNG2 {
    //code for running all the testcases//
    /* @Test
    void msg()
    {
        System.out.println("one new message");
    }

    @Test
    void notification()
    {
        System.out.println("No new notification");
    }

    @Test
    void request()
    {
        System.out.println("Four new requests");
    }*/

    //code for running  the testcases when priority is set//
   /*@Test
    void msg()
    {
        System.out.println("one new message");
    }

    @Test
    void notification()
    {
        System.out.println("No new notification");
    }

    @Test(priority = 3)
    void request()
    {
        System.out.println("Four new requests");
    }*/

    //code for running  the testcases when group is set//
   @Test(groups = {"regression"})
    void msg()
    {
        System.out.println("one new message");
    }

    @Test(groups = {"regression"})
    void notification()
    {
        System.out.println("No new notification");
    }

    @Test(groups = {"regression","Sanity"})
    void request()
    {
        System.out.println("Four new requests");
    }
}
