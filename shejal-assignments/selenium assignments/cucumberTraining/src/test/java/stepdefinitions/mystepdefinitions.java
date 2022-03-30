package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class mystepdefinitions {

    @Given("User is on NetBanking landing page")
    public  void user_is_on_netbanking_application(){
        System.out.println("Net Banking Landing Page");
    }
    @When("User login into application with username and password")
    public void user_login_into_application_with_username_and_password() {
        System.out.println("Login with username and password");

    }
    @Then("Home page is populated")
    public void home_page_is_populated() {
        System.out.println("Home page is populated");

    }
    @Then("Cards are displayed")
    public void cards_are_displayed() {
        System.out.println("Cards are displayed");

    }
    @When("User login into application with {string} and password {string}")
    public void user_login_into_application_with_and_password(String username, String password) {
        System.out.println("Login using "+username+" - "+password);

    }
    @Then("Cards displayed are {string}")
    public void cards_displayed_are(String cards) {
        System.out.println("Cards displayed are "+cards);

    }
    @When("^User login in to application with (.+) and password (.+)$")
    public void user_login_in_to_application_with_user1_and_password_pass1(String username, String password) {
       System.out.println(" Login with  "+username+" - "+password);
    }



}
