package tests;

import clients.BookApiClient;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class GetBookByIDApiActions {
    @Steps
    BookApiClient bookApiClient;

    @Given("user is not logged in")
    public void userNotLoggedIn() {
    }

    @When("user asks for all books")
    public void asksForAllBooks() {
        bookApiClient.getAllBooks();
    }

    @Then("user gets unauthorized response")
    public void getUnauthorizedResponse() {
        bookApiClient.verifyUnauthorized();
    }
}
